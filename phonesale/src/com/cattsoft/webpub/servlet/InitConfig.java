package com.cattsoft.webpub.servlet;

import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.cattsoft.pub.LogConfig;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.config.SysConfig;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.jndi.JndiFactory;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysDate;


public class InitConfig extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(InitConfig.class);

	private ServletConfig config;

	private static final String DAO_CONFIG = "DAOConfig";

	private static final String CONNECTION_CONFIG = "ConnectionConfig";

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// ��ʼ��dao����
		config = this.getServletConfig();
		LogConfig.init();
		log.debug("complete log init .");
		String connConfigStr = config
				.getInitParameter(CONNECTION_CONFIG.trim());
		String DAOConfigStr = System
			.getProperty(SysConstants.SYSTEM_PRPTY_DAO_CONFIG_URL);
		if(StringUtil.isBlank(DAOConfigStr)){
			DAOConfigStr = config.getInitParameter(DAO_CONFIG).trim();
		}
		String cacheMode=null;
		try {
			//log.debug("��ʼװ��JMS������ʵʱ����ʵ����Ϣ�ڴ��¼...");
			//JMSDispatcher.getInstance().initProcInstMsgSendRecord(SysConstants.REAL_TIME);
			
//			log.debug("��ʼװ��Connection����...");
			log.debug("��ʼװ��DAO����...");
			DAOFactory.initDAOFactory(DAOConfigStr);
			
			log.debug("��ʼ��ʼ��sps��������...");
			// DataCache.initial();
			//add by xieyunchao 20130411����Ӧ�ÿ���������������������һ�ݣ����������ܷ������ݿ⣬����������Ҫ��sys_config.properties�ļ���ȡ
			Properties p=  SysConfig.getConfig();
			cacheMode=p.getProperty("DATABASE_CACHE");
			if(SysConstants.FALSE.equals(cacheMode)){
				com.cattsoft.pub.util.DataCache.initPropertiesHashMap();
			}else{
				ConnectionFactory.initConnectionFactory(connConfigStr);
				ConnectionFactory.createConnection();
				com.cattsoft.pub.util.DataCache.initial();
			}
			
			SysDate.getCurrentDate();
			// ��ʼ������������
			//log.debug("��ʼ��ʼ��wfs��������...");
			//WMCachePool.initCachePool();
			//log.debug("��ɳ�ʼ����������");

			//HashMap hm = new HashMap(); // ��ʼ����½������
		//	hm.put(SysInit.ORG_MNG_MODE, "A");
			//hm.put(SysInit.WEB_CONTEXT, "/web");
			
			//SysInit.instance(hm);

			//���������weblogic�ϣ������context-config�ļ�
			if(SysConstants.TRUE.equals(p.getProperty("CONTEXT_CONFIG"))){
				String contextURL = System
						.getProperty(SysConstants.SYSTEM_PRPTY_CONTEXT_CONFIG_URL);
				JndiFactory.getInstance(contextURL);
			}

			/*// �����汾
			String version = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_RELEASED_VERSION, null, null, null,
					null, null);
			if (version != null) {
				this.getServletContext().setAttribute("RELEASE_VERSION",
						version);
			}
			String smallVersion =SysConfigData.getSysConfigCurValue(
				SysConstants.SYS_CONFIG_RELEASED_SMALL_VERSION, null, null, null,
				null, null);
			if (smallVersion != null) {
				this.getServletContext().setAttribute("RELEASE_SMALL_VERSION",
						smallVersion);
			}	
				
			// ����ʱ��
			String releaseDate = SysConfig.getConfig().getProperty(
					"system.buildTime");
			if (releaseDate != null) {
				this.getServletContext().setAttribute("RELEASE_TIME",
						releaseDate);
			}
			// �ͻ�����
			String customName = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_CUSTOM_NAME_HB_CUCC, null, null,
					null, null, null);
			if (customName != null) {
				this.getServletContext()
						.setAttribute("CUSTOM_NAME", customName);
			}*/
		} catch (SysException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		} catch (AppException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		} catch (DataCacheException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			try {
				if(SysConstants.TRUE.equals(cacheMode)){
					ConnectionFactory.closeConnection();
				}
				
			} catch (SysException e) {
				log.error(e.getMessage());
				throw new RuntimeException(e);
			} catch (AppException e) {
				log.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}

	}
}
