package com.cattsoft.pub.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sm.vo.SysConfigSVO;

/**
 * 
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author liaoyh
 */
public class MaxId {
    private static Log log = LogFactory.getLog(MaxId.class);

    /**
     * getSequenceNextVal:�õ���һ��Sequence
     * 
     * @param seqName
     * @throws AppException
     * @throws SysException
     * @return String
     */
    public static String getSequenceNextVal(String seqName) throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        String seq = "0";
        Sql sql = new Sql();
        sql.append("select " + seqName + "_SEQ.nextval from dual");
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.fillParams(ps);
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new SysException("100000", "��������" + seqName + "�����ֵʧ��", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                log.debug("cannot close resource");
            }
        }
        return seq;
    }

    /**
     * getMaxIdFromTable:��ĳ���и��������õ�ָ���ֶε����ֵ
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param condition
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return long
     * @throws AppException
     */
    public static Long getMaxIdFromTable(String tableName, String columnName, String condition)
            throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        Long seq = null;
        Sql sql = new Sql();
        sql.append("select nvl(max(");
        sql.append(columnName);
        sql.append("),0) from ");
        sql.append(tableName);

        if (!StringUtil.isBlank(condition)) {
            sql.append(" where ");
            sql.append(condition);
        }
        System.out.println("sql is >>>>> " + sql.getSql());
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = new Long(rs.getLong(1));
                // //System.out.println("max_id is :" + seq);
            }
        } catch (SQLException ex) {
            throw new SysException("", "����" + tableName + "���ֶ�" + columnName + "�����ֵʧ��" + "sql is "
                    + sql, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return seq;
    }

    /**
     * getMaxSeqFromTable:��ĳ���и���vo���õ�seq���ֵ
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param condition
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return long
     * @throws AppException
     */
    public static Long getMaxSeqFromTable(String tableName, String columnName, String condition)
            throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        Long seq = null;
        Sql sql = new Sql();
        sql.append("select nvl(max(");
        sql.append(columnName);
        sql.append("),0) from ");
        sql.append(tableName);

        if (!StringUtil.isBlank(condition)) {
            sql.append(" where ");
            sql.append(condition);
        }
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = new Long(rs.getLong(1));
                // //System.out.println("max_id is :" + seq);
            }
        } catch (SQLException ex) {
            throw new SysException("", "����" + tableName + "���ֶ�" + columnName + "�����ֵʧ��" + "sql is "
                    + sql, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return seq;
    }

    /**
     * @author wangdongxun getMaxSeqByServId:ӪҵservId��ȡservϵ�б�Ĵ�seq,��ǰ����seq+1
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param servId
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return String
     * @throws AppException
     */
    public static String getMaxSeqByServId(String tableName, String columnName, String servId)
            throws SysException, AppException {
        String seqTmp = getCurrSeqByServId(tableName, columnName, servId);
        int seq = Integer.parseInt(seqTmp) + 1;
        return new Integer(seq).toString();
    }

    /**
     * @author wangdongxun getCurrSeqByServId:ӪҵservId��ȡservϵ�б�Ĵ�seq,��ǰ����seq
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param servId
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return Stirng
     * @throws AppException
     */

    public static String getCurrSeqByServId(String tableName, String columnName, String servId)
            throws SysException, AppException {
        Long seq = MaxId.getMaxSeqFromTable(tableName, columnName, "serv_id=" + servId);
        return seq.toString();
    }
    /**
     * �õ��ͻ���Ӫ������Id
     * @param jfLocalNetId
     * @param seqName
     * @return
     * @throws SysException
     * @throws AppException
     */
    public static String getNewMaxId(String localNetId,String seqName)throws SysException, AppException {
        String id = ""; 
        String  seq=getSequenceNextVal(seqName);
        SysConfigSVO sysVo = new SysConfigSVO();
        try {
            sysVo = SysConfigData.getSysConfigById( "100019",  localNetId , null, null, null, null );
            id = ( new Long( sysVo.getCurValue() ).longValue() * 1000000000 )+Long.parseLong(seq)+"";
             // id = new Long( ( new Long( sysVo.getCurValue() ).longValue() * new Long("10000000000").longValue() ) + new Long( seq ).longValue() ).toString();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        } catch (DataCacheException e) {
            e.printStackTrace();
            return null;
        }
        //Partition_id*1000000000+CRM����ˮ
        
        return id;
    }
        
     /**
     * <p>
     * ʹ�÷���ʾ��1:getMaxId,ȡ���ֵ(һ������¶����������)
     * </p>
     * <p>
     * ˵��:
     * </p>
     * <p>
     * �����oracle��ȷ���Ѿ�����Sequence
     * </p>
     * <p>
     * �����Sybase��ȷ����MAX_IDS�����Ѿ����������
     * </p>
     * <p>
     * long commServSpecId ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * commServSpecId = maxId.getMaxId("comm_serv_spec_id");
     * </p>
     * <p>
     * .......
     * </p>
     * 
     * 
     * 
     * <p>
     * ʹ�÷���ʾ��2:getMaxAreaId,ȡ���ֵ(������ӡʱ��������ȡ���ֵ)
     * </p>
     * <p>
     * ˵��:
     * </p>
     * <p>
     * ��ȷ����MAX_IDS�����Ѿ����������
     * </p>
     * 
     * <p>
     * long printNbr ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * printNbr = maxId.getMaxAreaId("PRINT_NBR","10501");
     * </p>
     * 
     * 
     * 
     * <p>
     * ʹ�÷���ʾ��2:getMaxIdFromTable,��ĳ���и��������õ�ָ���ֶε����ֵ
     * </p>
     * 
     * <p>
     * long prodId ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * prodId = maxId.getMaxIdFromTable("product","prod_id","sts = 'A'");
     * </p>
     * <p>
     * .......
     * </p>
     * 
     * 
     */
}
