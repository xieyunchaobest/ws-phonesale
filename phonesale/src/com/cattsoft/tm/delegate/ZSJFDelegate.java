package com.cattsoft.tm.delegate;

import java.sql.Connection;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.component.domain.ZSJFDOM;
import com.cattsoft.tm.vo.TRptJtbbQsfzrbSVO;


public class ZSJFDelegate {
	private static Log log = LogFactory.getLog(ZSJFDelegate.class);
	private static ZSJFDelegate delegate = null;
	private ZSJFDelegate() {

	}

	public static ZSJFDelegate getDelegate() {
		if (delegate == null) {
			delegate = new ZSJFDelegate();
		}
		return delegate;
	}	

	public String login(String reqParm) throws AppException,SysException{

		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.login(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	public String getLateVersion4MOS(String reqParm) throws AppException,SysException{

		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.getLateVersion4MOS(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	
	
	/**
	 * �ص��ע֮�ص�ҵ��չ�ձ�
	 * @param reqParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String zdgz4zdywrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.zdgz4zdywrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �����ձ�֮�ص�ҵ��չ�ձ�
	 * @param reqParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsrb4zdywfzrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4zdywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = ret.toString();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �����ձ�֮3Gҵ���ձ�
	 */
	public String hsrb43gyw(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb43gyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �����ձ�֮2Gҵ���ձ�
	 */
	public String hsrb42gyw(String reqParm ) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb42gyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	
	}
	
	/**
	 * �����ձ�֮���ҵ���ձ�
	 */
	public String hsrb4kdyw(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4kdyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	

	/**
	 * �����ձ�֮2G3G�ں�
	 */
	public String hsrb42g3grh(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb42g3grh(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	

	/**
	 * �����ձ�֮�ص�ҵ����װ�ձ�
	 */
	public String hsrb4zdywlz(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4zdywlz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * �����ձ�֮�ͻ�������װ�ձ�
	 */
	public String hsrb4khjllz(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4khjllz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * �����ձ�֮�������м�ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4qsjywfzrb(String reqParm) throws AppException,
			SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.jtrb4qsjywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �޸�����
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String modifyPwd(String reqParm) throws AppException,
			SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.modifyPwd(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �����ձ�֮�������м�ҵ��չ�ձ�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4hybywfzrb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.jtrb4hybywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	

	/**
	 * �����ձ�������ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String qdrb4gwdywfzrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.qdrb4gwdywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * �����±�4�ؼ�ָ���±�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4gjzbyb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb4gjzbyb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * �����±�43Gҵ���±�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb43gywyb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb43gywyb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	
	/**
	 * �����±�4����·�չ���
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4kdyfzqk(String reqParm)  throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb4kdyfzqk(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * �����ձ�4�������ص��ע
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsrb4wgjlzdgz(String reqParm)  throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4wgjlzdgz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative�쳣]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative����ع��쳣]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOMϵͳ�ӿ�svcCallIOMByMosNative���ݿ����ӹر��쳣]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
}

