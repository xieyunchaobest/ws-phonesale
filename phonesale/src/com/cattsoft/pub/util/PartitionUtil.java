package com.cattsoft.pub.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * ��sql����еķ��������partition��ʾָ����
 * 
 * @author mjh E-mail:mjh@cattsoft.com
 * @version 1.0 ����ʱ�䣺2007-8-13 ����05:24:58 ��˵��
 */
public final class PartitionUtil {
    private static Logger log = Logger.getLogger(PartitionUtil.class);

    // �����������б� List<String>
    private static List ptTableNames;

    // ���������б� Map<String, String>
    private static Map ptNames;

    private static final String defaultPartition = "p000";

    static {
        ptTableNames = new ArrayList();
        ptNames = new HashMap();

        SAXReader saxReader = new SAXReader();
        String file = PartitionUtil.class.getClassLoader().getResource("partition_config.xml")
                .getFile();
        Document document;
        try {
            document = saxReader.read(file);
            List tables = document.selectNodes("//table/name");
            if (tables != null) {
                log.debug("Total partition tables: " + tables.size());
            }
            Iterator tit = tables.iterator();
            while (tit.hasNext()) {
                Node node = (Node) tit.next();
                log.debug(node.getText());
                ptTableNames.add(node.getText().toUpperCase());
            }
            List partitions = document.selectNodes("//partition");
            if (partitions != null) {
                log.debug("Total partitions: " + partitions.size());
            }
            Iterator pit = partitions.iterator();
            while (pit.hasNext()) {
                Node partition = (Node) pit.next();
                Node localnet = partition.selectSingleNode("partition-key");
                Node name = partition.selectSingleNode("partition-name");
                log.debug("partitionKey: " + localnet.getText() + " partitionName: "
                        + name.getText());
                ptNames.put(localnet.getText(), name.getText());
            }
        } catch (DocumentException e) {
            log.error("��ȡ������XML���̳���...");
        }
    }

    
    /**
     * ��sql����еķ��������partition��ʾָ���� ���ƣ�1-��дsql��ʱ�򣬱���ǰ��һ��Ҫ�пո񣬼�ʹǰ���ж��Ż��߽�β�����š�2-�ֶ���������Ҫ�������ͬ�������ͬ������
     * A.�ֶ��� ��ʽ��ʹ�á�
     * 
     * @param fromSql
     * @param localNetId
     * @return
     */
    public static String getPartitionSQL(String sql, String localNetId) {
        // ʾ��ԭsql
        // select count(*) from serv a,serv_acc_nbr b
        // where a.serv_id=b.serv_id
        // and a.sts='A'
        // and b.sts='A'
        // ʾ��Ŀ��sql
        // select count(*) from serv partition(partition_3) a,serv_acc_nbr
        // partition(partition_3) b
        // where a.serv_id=b.serv_id
        // and a.sts='A'
        // and b.sts='A'

        // ���δָ��localNetId, ��ָ����������ʹ�Ƿ�����
        if (localNetId == null || "".equals(localNetId.trim())) {
            return sql;
        }

        String[] splitFrom = sql.split(" ");
        StringBuffer ret = new StringBuffer();
        List fldLst = new ArrayList();
        // printTimestamp();
        for (int i = 0; i < splitFrom.length; i++) { // ��ѭ����sqlÿ���μ��뵽lst��
            // log.debug(splitFrom[i]);
            if (splitFrom[i].indexOf(",") < 0 && splitFrom[i].indexOf(")") < 0) { // ����ֳ����Ĵ���û�ж��źͷֺţ�����Լӵ�list��
                fldLst.add(splitFrom[i]);
            } else {
                addFld(fldLst, splitFrom[i]); // �����һ���з�
            }
        }
        String fldName = null;
        String nextFld = null;
        for (int i = 0; i < fldLst.size(); i++) { // ��ѭ����lst�еĶ�ƴ�ճ�sql������������
            fldName = (String) fldLst.get(i);
            if (ptTableNames.contains(fldName.toUpperCase())) {
                ret.append(fldName).append(" partition(").append(getOneTable(fldName, localNetId))
                        .append(") ");
            } else {
                boolean isKeyWord = false;
                if (fldName.indexOf("count") >= 0 || fldName.indexOf("sum") >= 0) { // �ж�ǰ���Ƿ��ǹؼ��ʣ�����count
                    isKeyWord = true;
                    nextFld = (String) fldLst.get(i + 1);
                }
                if (isKeyWord && nextFld.equalsIgnoreCase(")")) {
                    ret.append(fldName);
                } else {
                    ret.append(fldName).append(" ");
                }
            }
        }
        // printTimestamp();

        return ret.toString();
    }

    /*
     * �Ͱ������źͷֺŵ��ַ�����һ����֣������뵽list�С�
     */
    private static void addFld(List fldLst, String split1) {
        if (split1.length() == 1) { // ����һ���ַ���ֱ�Ӽ��뵽list��������
            fldLst.add(split1);
            return;
        }
        if (split1.indexOf(",") == 0) { // ����Ϊͷһ���ַ�
            fldLst.add(",");
            split1 = split1.substring(2);
            // log.debug(split1);
        }
        String end = null;

        if (split1.indexOf(")") == split1.length() - 1) { // ������һ���ַ�Ϊ����
            split1 = split1.substring(0, split1.length() - 1);
            // log.debug(split1);
            end = ")";
        } else if (split1.indexOf(",") == split1.length() - 1) { // ������һ���ַ�Ϊ����
            split1 = split1.substring(0, split1.length() - 1);
            // log.debug(split1);
            end = ",";
        }
        if (split1.indexOf(",") > 0) { // ���������ţ�����from bbb,xxx,ddd������ַ���
            String[] dou = split1.split(",");
            for (int i = 0; i < dou.length; i++) {
                fldLst.add(dou[i]);
                if (i < dou.length - 1) {
                    fldLst.add(",");
                }
            }
        } else {
            fldLst.add(split1);
        }
        if (end != null) {
            fldLst.add(end);
        }
    }

    private static String getOneTable(String splitOne, String localNetId) {
        String partition = null;
        if (ptNames.containsKey(localNetId)) {
            partition = (String) ptNames.get(localNetId);
        } else { // default
            partition = defaultPartition;
        }
        return partition;
    }

    private static void printTimestamp() {
        if (log.isDebugEnabled()) {
            log.debug(new Date(System.currentTimeMillis()));
        }
    }

    public static void main(String[] args) {
        String fromSql = "select a.serv_id, b.bank_id from serv a, bank b where 1=1 and b.bank_id = ? and b.sts_date = to_date('2007-01-01', 'yyyy-MM-dd')";
        log.debug("start...................");
        printTimestamp();
        String partitionSql = PartitionUtil.getPartitionSQL(fromSql, "0");
        log.debug("sql after partitioning is: " + partitionSql);
        printTimestamp();
        log.debug("end....................");
    }

}
