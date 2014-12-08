package com.cattsoft.pub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

//import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: CRMϵͳ<br>
 * Description: <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class MaxId {
//	private static Logger log = Logger.getLogger(MaxId.class);

	/**
	 * MaxId
	 */
	public MaxId() {
	}

	/**
	 * getSequenceNextVal:�õ���һ��Sequence
	 * 
	 * @param columnName
	 *            String
	 * @throws AppException
	 * @throws SysException
	 * @throws NamingException
	 * @return long
	 * @throws AppException
	 */
	public static String getSequenceNextVal(String seqName) throws SysException, AppException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		long seq = 0;
		Sql sql = new Sql();
		sql.append("select " + seqName + "_SEQ.nextval from dual");
		// sql.setString("seqName", seqName);
		try {

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(MaxId.class);
			rs = ps.executeQuery();
			if (rs.next()) {
				seq = rs.getLong(1);
				// System.out.println(columnName + "_SEQ is :" + seq);
			}

		} catch (SQLException ex) {
			throw new SysException(SysConstants.FAIL_REASON_SPS_SYS_ERROR, "�����ֶ���" + seqName + "�����ֵʧ��", ex);
		} finally {

			JdbcUtil.close(rs, ps);

		}
		String str = Long.toString(seq);
		return str;

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
		}

		finally {

			JdbcUtil.close(rs, ps);

		}
		return seq;

	}

	/**
	 * getMaxIdFromTable:��MaxIds���и��������õ�ָ���ֶε����ֵ
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
	public static synchronized Long getMaxIdFromMaxIdx(String tableName, String columnName,
			String prefix, String spAreaId) throws SysException, AppException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Long seq = null;
		Sql sql = new Sql();
		sql.append("select MAX_ID");
		sql.append(" from max_ids");

		if (!StringUtil.isBlank(tableName)) {
			sql.append(" where TABLE_NAME=:tableName");
			sql.setString("tableName", tableName);
		}
		if (!StringUtil.isBlank(columnName)) {
			sql.append(" and COLUMN_NAME=:columnName");
			sql.setString("columnName", columnName);
		}
		if (!StringUtil.isBlank(prefix)) {
			sql.append(" and PREFIX=:prefix");
			sql.setString("prefix", prefix);
		} else
			sql.append(" and PREFIX='UNABLE'");
		if (!StringUtil.isBlank(spAreaId)) {
			sql.append(" and SP_AREA_ID=:spAreaId");
			sql.setString("spAreaId", spAreaId);
		} else
			sql.append(" and SP_AREA_ID=0");
		try {

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(MaxId.class);
			rs = ps.executeQuery();
			if (rs.next()) {
				seq = new Long(rs.getLong(1) + 1);
				updateMaxIds(tableName, columnName, prefix, spAreaId, seq);
			} else {
				seq = new Long(2000);
				saveMaxIdx(tableName, columnName, prefix, spAreaId, seq);
			}
		} catch (SQLException ex) {
			throw new SysException("", "��max_ids���в���" + tableName + "���ֶ�" + columnName + "�����ֵʧ��"
					+ "sql is " + sql, ex);
		}

		finally {

			JdbcUtil.close(rs, ps);

		}
		return seq;

	}

	/**
	 * ��MaxIds���и�����������ָ���ֶε����ֵ
	 * 
	 * @param tableName
	 * @param columnName
	 * @param prefix
	 * @param spAreaId
	 * @throws AppException
	 * @throws SysException
	 */
	public static void saveMaxIdx(String tableName, String columnName, String prefix,
			String spAreaId, Long maxId) throws AppException, SysException {
		PreparedStatement ps = null;
		Connection conn = null;
		Sql sql = new Sql();
		sql.append("insert into MAX_IDS(TABLE_NAME,COLUMN_NAME,SP_AREA_ID,MAX_ID,PREFIX)");
		sql.append("VALUES (:tableName,:columnName,:spAreaId,:maxId,:prefix)");
		if (!StringUtil.isBlank(tableName)) {
			sql.setString("tableName", tableName);
		}
		if (!StringUtil.isBlank(columnName)) {
			sql.setString("columnName", columnName);
		}
		if (!StringUtil.isBlank(prefix)) {
			sql.setString("prefix", prefix);
		} else
			sql.setString("prefix", "UNABLE");
		if (!StringUtil.isBlank(spAreaId)) {
			sql.setString("spAreaId", spAreaId);
		} else
			sql.setLong("spAreaId", "0");
		if (maxId != null) {
			sql.setString("maxId", maxId.toString());
		} else
			throw new AppException("", "ȱ��maxId������");
		try {

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(MaxId.class);
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new SysException("", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	public static void updateMaxIds(String tableName, String columnName, String prefix,
			String spAreaId, Long maxId) throws AppException, SysException {
		PreparedStatement ps = null;
		Connection conn = null;
		Sql sql = new Sql();
		sql.append("update MAX_IDS m set ");
		if (maxId != null) {
			sql.append("m.MAX_ID=:maxId where 1=1");
			sql.setString("maxId", maxId.toString());
		} else
			throw new AppException("", "ȱ��maxId����!");
		if (!StringUtil.isBlank(tableName)) {
			sql.append(" and TABLE_NAME=:tableName");
			sql.setString("tableName", tableName);
		} else
			throw new AppException("", "ȱ��tableName����!");
		if (!StringUtil.isBlank(columnName)) {
			sql.append(" and COLUMN_NAME=:columnName");
			sql.setString("columnName", columnName);
		} else
			throw new AppException("", "ȱ��columnName����!");
		if (!StringUtil.isBlank(prefix)) {
			sql.append(" and PREFIX=:prefix");
			sql.setString("prefix", prefix);
		} else {
			sql.append(" and PREFIX=:prefix");
			sql.setString("prefix", "UNABLE");
		}
		if (!StringUtil.isBlank(spAreaId)) {
			sql.append(" and SP_AREA_ID=:spAreaId");
			sql.setString("spAreaId", spAreaId);
		} else {
			sql.append(" and SP_AREA_ID=:spAreaId");
			sql.setLong("spAreaId", "0");
		}
		try {

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(MaxId.class);
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new SysException("", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(ps);
		}
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
	public static void main(String args[]) {
		String s = "ACCT_NBR = " + "22222";
		s = s.substring(0, 11) + "'" + s.substring(11, s.length()) + "'";
		// System.out.print(s);
	}

}
