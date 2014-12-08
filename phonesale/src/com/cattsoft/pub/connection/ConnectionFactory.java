package com.cattsoft.pub.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: ͨ�����õ����ӳء�����Դ��ȡ����<br>
 * Date: 2007-8-17 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class ConnectionFactory {
	private static Logger log = Logger.getLogger(ConnectionFactory.class);

	private static final String CONNECTIONS_FILE = "connection-config.xml";

	// ���õĶ��connection��ThreadLocal
	// private Map threadConns = new HashMap();

	private ThreadLocal threadConn = new ThreadLocal();

	private Map dataSourceMap = new HashMap();

	// Ĭ��dataSource����
	private DataSource defaultDataSource = null;

	private String defaultName = "";

	private static ConnectionFactory instance;

	private ConnectionFactory(String path) throws SysException, AppException {
		ConnectionConfigReader connReader = new ConnectionConfigReader();
		InputStream in;

		log.debug("��ʼװ�������ļ�:" + CONNECTIONS_FILE);
		in = ConnectionFactory.class.getClassLoader().getResourceAsStream(CONNECTIONS_FILE);
		connReader.read(in);
		ConnectionConfigDef pro = connReader.getConfigDef();
		Iterator itor = pro.getConnections().keySet().iterator();
		String connName = null;
		DataSource ds = null;
		while (itor.hasNext()) {
			connName = (String) itor.next();
			ConnectionDef connDef = (ConnectionDef) pro.getConnections().get(connName);
			String datasource = connDef.getDatasource();
			if (!StringUtil.isBlank(datasource)) {
				ds = getJNDIDataSource(connDef);
			} else {
				ds = getDBCPDataSource(connDef);
			}
			if (null == ds) {
				log.error("ϵͳ��ȡ���ӵ�����Դʧ�ܣ�" + connName);
			}
			log.debug("ds: " + ds);
			dataSourceMap.put(connName, ds);

		}
		Object obj = dataSourceMap.get(pro.getDefaultName());
		if (obj == null)
			throw new AppException("", "ϵͳδ�ҵ�Ĭ������Դ��");
		this.defaultDataSource = (DataSource) obj;
		this.defaultName = pro.getDefaultName();
		log.info("Ĭ������Դ:" + defaultName + "/" + defaultDataSource);

		try {
			Connection conn = defaultDataSource.getConnection();
			log.debug("connection:" + conn);
			JdbcUtil.close(conn);

		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new SysException("", "ϵͳ��ȡĬ�����ӵ�����Դʧ�ܣ�", e);
		}
		log.debug("�ɹ�װ�����������ļ���" + CONNECTIONS_FILE);

	}

	/**
	 * ���DBCP���ӳص�����Դ
	 * 
	 * @return
	 */
	private DataSource getDBCPDataSource(ConnectionDef connDef) {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(connDef.getDriverClass());
		ds.setUsername(connDef.getUserName());
		ds.setPassword(connDef.getPassword());
		ds.setUrl(connDef.getUrl());
		//ds.setTestOnBorrow(true);//�ӳ���ȡ������ʱ��������飬������ʮ�ֱ���
		ds.setMaxActive(Integer.parseInt(connDef.getPoolMaxActive()));
		ds.setMaxIdle(Integer.parseInt(connDef.getPoolMaxIdle()));
		ds.setMaxWait(Integer.parseInt(connDef.getPoolMaxWait()));
		ds.setValidationQuery("select * from dual");
		ds.setTestOnBorrow(true);
		ds.setTestOnReturn(true);
		ds.setTestWhileIdle(true);
		return ds;

	}

	/**
	 * ���JNDI������Դ
	 * 
	 * @return
	 */
	private DataSource getJNDIDataSource(ConnectionDef connDef) {
		DataSourceUtil.setJNDI(connDef.getDatasource());
		return DataSourceUtil.getDataSource();

	}

	/**
	 * ��ʼ���������ú�����Դ
	 * 
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory(String path) throws SysException,
			AppException {
		if (null == instance) {
			instance = new ConnectionFactory(path);
		}
	}

	/**
	 * ��ʼ���������ú�����Դ
	 * 
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory() throws SysException, AppException {
		if (null == instance) {
			instance = new ConnectionFactory(null);
		}
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection() throws AppException, SysException {
		if (null == instance) {
			// throw new AppException("","ϵͳδ��ʼ��ConnectionFactory��");
			initConnectionFactory();
		}
		return createConnection(instance.defaultName);
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection(String name) throws AppException, SysException {
		if (null == instance) {
			// throw new AppException("","ϵͳδ��ʼ��ConnectionFactory��");
			initConnectionFactory();
		}
		ThreadLocal threadConn = instance.threadConn;
		Object objConn = threadConn.get();
		if (objConn == null) {
			log.debug("��ȡ������ ...");
			Connection conn = null;
			try {
				Object obj = instance.dataSourceMap.get(name);
				if (obj == null)
					throw new AppException("", "ϵͳδ�ҵ�Ĭ������Դ��");
				DataSource ds = (DataSource) obj;
				conn = ds.getConnection();
				log.debug("�ɹ���������:" + conn);
				threadConn.set(conn);
			} catch (SQLException e) {
				log.debug("ϵͳ��������ʧ�ܣ�");
				throw new SysException("", "ϵͳ��������ʧ�ܣ�", e);
			}

		} else {
			// ���֮ǰ�������ӣ������ر�
			throw new AppException("1000002", "ϵͳ���ֵ�ǰ�߳��Ѵ���һ���������ӣ����ȹر��������ӻ�ֱ��ʹ�õ�ǰ���ӣ�");

		}
		return (Connection) threadConn.get();
	}

	/**
	 * ��õ�ǰ�̶߳�Ӧ������
	 * 
	 * @return
	 * @throws SysException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws AppException, SysException {
		Object objConn = instance.threadConn.get();
		if (null == objConn) {
			throw new AppException("100001", "ϵͳ��ǰ�޿�������!");
		}
		Connection conn = (Connection) objConn;
		return conn;
	}

	/**
	 * �ύ��ǰ���ӵ�����
	 * 
	 * @throws AppException
	 * @throws SysException
	 */
	public static void commit() throws AppException, SysException {
		Object objConn = instance.threadConn.get();
		if (null == objConn) {
			throw new AppException("100001", "ϵͳ��ǰ�޿�������!");
		}
		Connection conn = (Connection) objConn;

		try {
			conn.commit();
		} catch (SQLException e) {
			throw new SysException("100001", "ϵͳ�����ύ����!", e);
		}
	}

	/**
	 * �ع���ǰ���ӵ�����
	 * 
	 * @throws AppException
	 * @throws SysException
	 */
	public static void rollback() throws AppException, SysException {
		Object objConn = instance.threadConn.get();
		if (null == objConn) {
			throw new AppException("100001", "ϵͳ��ǰ�޿�������!");
		}
		Connection conn = (Connection) objConn;

		try {
			conn.rollback();
		} catch (SQLException e) {
			throw new SysException("100001", "ϵͳ�����ύ����!", e);
		}
	}

	/**
	 * �ͷŵ�ǰ����
	 * 
	 * @throws SysException
	 * @throws AppException
	 * 
	 */
	public static void closeConnection() throws SysException, AppException {
		Object objConn = instance.threadConn.get();
		if (objConn == null)
			throw new AppException("100001", "ϵͳ�Ҳ���Ҫ�رյ����ӣ�");
		Connection conn = (Connection) objConn;
		if (conn != null) {
			log.debug("�ͷ����ӣ�" + conn);
			JdbcUtil.close(conn);
			instance.threadConn.set(null);
		}
	}

	public static void main(String[] args) throws SysException, AppException {
		ConnectionFactory.initConnectionFactory();
	}

}
