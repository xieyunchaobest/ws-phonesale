package com.cattsoft.pub.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cattsoft.pub.LogConfig;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-12 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class Sql extends AbstractSql {

	// private static final Logger log = Logger.getLogger(Sql.class);

	// sql���
	private StringBuffer sqlStr = new StringBuffer();

	public Sql() {

	}

	public Sql(String sql) {
		sqlStr = new StringBuffer(sql);
	}

	/**
	 * ��ñ�׼�Ĵ�����sql(?��Ϊ�������õ�sql)
	 * 
	 * @param sql
	 */
	public void setSql(String sql) {
		this.sqlStr = new StringBuffer(sql);
		parameters = new HashMap();
		paramIndexs = new ArrayList();
	}

	public void append(String sql) {
		// this.sqlStr.append(" ");
		this.sqlStr.append(sql);
	}

	public void insert(int index, String str) {
		this.sqlStr.insert(index, str);
	}

	/**
	 * ���� ����ת�����sql��ռλ��ת��?��
	 * 
	 * @return
	 */
	public String getSql() {
		// paramIndexs = orderParameters();
		// sqlStr = new StringBuffer(converSql(sqlStr.toString()));
		String str = this.convertAskParameter(sqlStr.toString());
		return str.toString();

	}

	/**
	 * ���ؼӷ��������sql
	 * 
	 * @return
	 */
	public String getPartitionSql(String partitionId) {
		return PartitionUtil.getPartitionSQL(this.getSql(), partitionId);
	}

	/*
	 * public void setList(String name, List value) { name = name.trim();
	 * parameters.put(name, new Parameter(name, Parameter.LIST, value)); }
	 */

	/**
	 * ��ȡ����������sql
	 */
	public String getPureSql() throws AppException {

		// �����־������sql������������
		String logSqlStr = sqlStr.toString();
		logSqlStr = this.convertAskParameter(logSqlStr);
		Iterator itor = parameters.keySet().iterator();
		while (itor.hasNext()) {
			String paramName = (String) itor.next();
			Parameter param = (Parameter) parameters.get(paramName);
			logSqlStr = logSqlStr.replaceAll(PARAM_SIGN + paramName + "\\b",
					StringUtil.getRegexStr(param.getSqlStr()));

		}

		return logSqlStr;
	}

	/**
	 * �����������������sql���
	 * 
	 * @param classObj
	 * @throws AppException
	 */
	public void log(Class classObj) throws AppException {
		if (null == classObj) {
			throw new AppException("100006", "ȱ����־�����ָ���࣡");
		}
		String logSqlStr = getPureSql();
		String className = classObj.getName();
		Logger log = Logger.getLogger(classObj);

		log.debug(StringUtil.getLastStr(className, ".") + ".sql=[ " + logSqlStr
				+ " ]");
	}

	/**
	 * ����������������sql
	 * 
	 * @param partitionId
	 * @param classObj
	 * @throws AppException
	 */
	public void logPartition(String partitionId, Class classObj)
			throws AppException {
		if (null == classObj) {
			throw new AppException("100006", "ȱ����־�����ָ���࣡");
		}
		String className = classObj.getName();
		String logSqlStr = getPureSql();
		logSqlStr = PartitionUtil.getPartitionSQL(logSqlStr, partitionId);

		Logger log = Logger.getLogger(classObj);
		log.debug(StringUtil.getLastStr(className, ".") + "-" + logSqlStr);
	}

	/**
	 * ����paramIndexs�Ĳ���˳�򣬴�parameters��ȡ����Ӧ��ֵ����ps���ò���ֵ
	 * 
	 * @param ps
	 * @return
	 * @throws SysException
	 */
	public PreparedStatement fillParams(PreparedStatement ps)
			throws AppException, SysException {
		if (null == ps)
			throw new AppException("100007", "ȱ�����ò�����PreparedStatement����");

		// ��sql�еĲ�������
		paramIndexs = this.orderParameters();
		// û�в�����ֱ�ӷ���
		if (null == paramIndexs)
			return ps;

		for (int i = 0; i < paramIndexs.size(); i++) {
			Parameter param = (Parameter) parameters.get(paramIndexs.get(i));
			if (null == param)
				throw new AppException("100008", "sql���ȱ�ٲ���"
						+ paramIndexs.get(i) + "����!");
			ps = param.fillParam(ps, i + 1);
		}
		return ps;
	}

	public void clearParameters() {
		this.parameters = new HashMap();
	}

	/**
	 * ת��sql��ռλ��ת��?��
	 * 
	 * @return
	 */
	public String convertSql(String converdSql) {
		if (null == converdSql || "".equals(converdSql)) {
			return null;
		}

		converdSql = convertAskParameter(converdSql);
		for (int i = 0; i < paramIndexs.size(); i++) {
			String paramName = (String) paramIndexs.get(i);
			converdSql = converdSql.replaceAll(PARAM_SIGN + paramName + "\\b",
					REF_SIGN);// \bƥ�䵥�ʽ�β
		}

		return converdSql;
	}

	/**
	 * ��sql�е�ռλ����˳��ȡ��
	 * 
	 * @return
	 */
	public List orderParameters() {
		List paramsOrder = new ArrayList();
		sqlStr = new StringBuffer(this.convertAskParameter(sqlStr.toString()));
		if (sqlStr != null) {
			int index = sqlStr.toString().indexOf(PARAM_SIGN);
			// ��ռλ��
			if (-1 == index) {
				return null;
			}
			String[] ary = sqlStr.substring(index + 1).split(PARAM_SIGN);
			for (int i = 0; i < ary.length; i++) {
				String[] temp = ary[i].split("\\W");
				paramsOrder.add(temp[0]);
			}
		}

		return paramsOrder;

	}

	/**
	 * ��sql�е�?����ת����ϵͳ����ռλ���Ĳ���
	 * 
	 * @return
	 */
	public String convertAskParameter(String sql) {
		int step = 1;// �����������
		int index = 0;// �ӵ�0λ��ʼ
		while (index >= 0) {
			index = sql.indexOf(REF_SIGN, index);
			sql = sql.replaceFirst("\\" + REF_SIGN, ":" + SYS_PARAMETER_PREFIX
					+ step);
			step++;
		}

		return sql;
	}

	/**
	 * ��ָ�����ȣ���ȡ���length�����ַ���
	 * 
	 * @param length
	 */
	public void removeSuffix(int length) {
		sqlStr = new StringBuffer(sqlStr.substring(0, sqlStr.length() - length));
	}

	public Object clone() {
		Sql cloneSql = new Sql();
		cloneSql.setSqlStr(sqlStr.toString());
		cloneSql.setParameters(parameters);
		cloneSql.setParamIndexs(paramIndexs);
		return cloneSql;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public List getParamIndexs() {
		paramIndexs = this.orderParameters();
		return paramIndexs;
	}

	public void setParamIndexs(List paramIndexs) {
		this.paramIndexs = paramIndexs;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = new StringBuffer(sqlStr);
	}

	public static void main(String[] args) throws AppException {
		LogConfig.init();
		Sql sql = new Sql();
		// sql.append("select dd,bb , zz,aa from WHERE a=? and b=? STS=:STS1 and
		// c=? AND STSDATE =:STSDATE ");
		sql
				.append("select a.CO_NBR,a.CHANNEL_ID,a.CO_METH,a.WORK_AREA_ID,a.STAFF_ID,a.AREA_ID,c.name workName,a.LOCAL_NET_ID,a.APPL_DATE,b.so_nbr,a.contact_info,a.contact_name, d.cso_nbr from CO a, so b, work_area c,cso_item d,cso_item_co e where 1=1 and a.work_area_id=c.work_area_id and a.co_nbr=e.co_nbr and d.cso_item_id = e.cso_item_id and a.co_nbr=b.co_nbr and a.co_nbr=?");
		// sql.append("select * from WHERE ");
		sql.setString(1, "aValue");
		sql.setString(2, "bValue");
		sql.setString("STS1", "sts1Value");
		sql.setString(3, "*%&amp;$^@^**@#^&amp;^$%^^%$#");
		sql.setString("STSDATE", "stsDateValue");
		// System.out.println(sql.getSql().replaceAll(":STS1\\b", "1"));

		// System.out.println(sql.getSql().replaceAll(":STS1\\b", "1"));
		// System.out.println(sql.convertAskParameter(sql.getSql()));
		// System.out.println(sql.getPartitionSql("1"));
		// sql.log(Sql.class);
		// String str = "for the wise";
		// System.out.println(str.replaceAll("\\<the", "11"));

		String s = "select a.CO_NBR,a.CHANNEL_ID,a.CO_METH,a.WORK_AREA_ID,a.STAFF_ID,a.AREA_ID,c.name workName,a.LOCAL_NET_ID,a.APPL_DATE,b.so_nbr,a.contact_info,a.contact_name, d.cso_nbr from CO a, so b, work_area c,cso_item d,cso_item_co e where 1=1 and a.work_area_id=c.work_area_id and a.co_nbr=e.co_nbr and d.cso_item_id = e.cso_item_id and a.co_nbr=b.co_nbr and a.co_nbr=:SYS_PARAMETER_1";
		String str = PartitionUtil.getPartitionSQL(s, "1");
		//System.out.println(str);

	}


}
