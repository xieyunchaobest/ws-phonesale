package com.cattsoft.pub.jndi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: �������ò��Ҷ�Ӧjndicontext<br>
 * Date: 2007-8-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class JndiFactory {

	private static JndiFactory jndiFactory;

	public static String CONTEXTS_FILE = "context-config.xml";

	private ThreadLocal threadCtxs = new ThreadLocal();

	private ThreadLocal threadCtxNames = new ThreadLocal();

	private static Logger log = Logger.getLogger(JndiFactory.class);
	
	public static final String SYSTEM_PRPTY_CONTEXT_CONFIG_URL_DEFAULT = "default";

	// ���õĶ��context����������
	private ContextConfigDef pro = null;

	// Ĭ��context����
	// private Context defaultCtx = null;

	private String defaultName = "";

	private Map jndiTreeMap = new HashMap();
	
	

	/**
	 * ��ȡJndi����ʵ��
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static JndiFactory getInstance() throws SysException,
			AppException {
		if (null == jndiFactory) {
			if (StringUtil.isBlank(CONTEXTS_FILE)) {
				throw new AppException("","ȱ��context-config.xml�ļ���ַ�������ã�����jvm�������ã�");
			//} else if(SYSTEM_PRPTY_CONTEXT_CONFIG_URL_DEFAULT.equals(CONTEXTS_FILE)){
			//	log.debug("��ʼװ��Ĭ��context-config.xml�ļ�...");
			//	jndiFactory = new JndiFactory();
			//	log.debug("JndiFacotry �����ɹ���");
			}else{
				log.debug("��ʼװ��context-config.xml�ļ���" + CONTEXTS_FILE);
				jndiFactory = new JndiFactory(CONTEXTS_FILE);
				log.debug("JndiFacotry �����ɹ���");
			}
			
		}
		return jndiFactory;
	}

	/**
	 * ��ȡJndi����ʵ��
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *             author ljx
	 */
	synchronized public static JndiFactory getInstance(String contextPath)
			throws SysException, AppException {
		CONTEXTS_FILE = contextPath;
		return getInstance();
	}

	/**
	 * ����jndi���Ʋ���Ĭ��context��Զ��home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	public Object getHome(String jndiName) throws NamingException,
			SysException, AppException {
		return getHome(defaultName, jndiName);
	}

	/**
	 * ����context���ƺ�jndi���Ʋ���Զ��home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws AppException
	 * @throws SysException
	 */
	public Object getHome(String ctxName, String jndiName)
			throws NamingException, SysException, AppException {
		java.lang.Object home = null;

		home = getObject(ctxName, jndiName);
		home = null;// ������Ⱥ�����²��ӻ��浱��ȡ������ʼ�յ�ͬһ���������µ�JNDI���󣬵����޷�Failover
		if (null == home) {
			home = this.getHomeInteface(ctxName, jndiName);
		}

		Object realhome = null;
		try {
			realhome = javax.rmi.PortableRemoteObject
					.narrow(home, Object.class);
		} catch (ClassCastException ex) {
			throw new SysException("", "EJBԶ�̽ӿ�narrow����jndi:" + jndiName, ex);
		}
		return realhome;
	}

	/**
	 * ����jndi���Ʋ���Ĭ��context�ı���home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	public Object getLocalHome(String jndiName) throws NamingException,
			SysException, AppException {
		return getLocalHome(defaultName, jndiName);
	}

	/**
	 * ����context���ƺ�jndi���Ʋ��ұ���home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws AppException
	 * @throws SysException
	 */
	public Object getLocalHome(String ctxName, String jndiName)
			throws NamingException, SysException, AppException {
		java.lang.Object home = null;

		// if(log.isDebugEnabled())log.info("find "+jndiName + " Home in
		// hashtable");
		home = getObject(ctxName, jndiName);
		// if(log.isDebugEnabled())log.info("--"+jndiName + "-- Home :"+ home);
		home = null;// ������Ⱥ�����²��ӻ��浱��ȡ������ʼ�յ�ͬһ���������µ�JNDI���󣬵����޷�Failover
		if (null == home) {
			// if(log.isDebugEnabled())log.info("Not in hashtable,looking up
			// begin");
			home = getHomeInteface(ctxName, jndiName);
			//log.info("looking up -*>" + jndiName + "<*- sucess:" + home);
		}

		log.info("looking up -*>" + jndiName + "<*- sucess :" + home);
		Object realhome = home;

		return realhome;
	}

	/**
	 * ����õ�home�ĺ�������getObject�ò���home��ʱ�����
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	private Object getHomeInteface(String ctxName, String jndiName)
			throws SysException, AppException {
		Object o = null;
		Context ctx = this.getContext(ctxName);
		if (ctx == null)
			throw new AppException("", "ϵͳ�Ҳ�����Ӧ��Context������" + ctxName);
		try {
			o = ctx.lookup(jndiName);
			if (o != null) {
				putObject(ctxName, jndiName, o);
			}
			log.debug("look up sucess: found " + jndiName + ":" + o);
		} catch (NamingException e) {
			throw new SysException("", "ϵͳ�Ҳ�����Ӧ��JNDI��Դ��jndi:" + jndiName, e);
		}
		return o;
	}

	/**
	 * �ڻ����в����Ƿ��Ѿ���ָ�����Ƶ�home
	 * 
	 * @param jndiName
	 * @return
	 */
	synchronized private Object getObject(String ctxName, String jndiName) {
		Object jndiObj = jndiTreeMap.get(ctxName);
		if (jndiObj == null)
			return null;
		Map jndiMap = (Map) jndiObj;
		return jndiMap.get(jndiName);

	}

	/**
	 * ���Ѿ���λ�õ�home���뻺����
	 * 
	 * @param jndiName
	 * @param ref
	 */
	synchronized private void putObject(String ctxName, String jndiName,
			Object ref) {
		Map jndiMap = null;

		Object jndiObj = jndiTreeMap.get(ctxName);
		if (jndiObj == null) {
			jndiMap = new HashMap();
		} else {
			jndiMap = (Map) jndiObj;
		}

		jndiMap.put(jndiName, ref);

	}

	/**
	 * �������ļ�����ʼ��contexts
	 * 
	 * @throws SysException
	 * @throws AppException
	 */
	private JndiFactory() throws SysException, AppException {

		ContextConfigReader ctxReader = new ContextConfigReader();
		InputStream in;

		log.debug("��ʼװ�������ļ�:" + CONTEXTS_FILE);
		in = JndiFactory.class.getClassLoader().getResourceAsStream(
				CONTEXTS_FILE);
		ctxReader.read(in);
		pro = ctxReader.getConfigDef();
		defaultName = pro.getDefaultName();

	}

	/**
	 * �������ļ�����ʼ��contexts
	 * 
	 * @throws SysException
	 * @throws AppException
	 *             author ljx
	 */
	private JndiFactory(String contextPath) throws SysException, AppException {

		ContextConfigReader ctxReader = new ContextConfigReader();
		InputStream in;

		File file = new File(contextPath);
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new SysException("1000005","װ����Χϵͳ���������ļ�ʧ�ܣ�",e);
		}
		ctxReader.read(in);
		pro = ctxReader.getConfigDef();
		defaultName = pro.getDefaultName();

	}

	/**
	 * �����ƶ����ƣ���ȡ��Ӧ���õ�Context������<br>
	 * 1����ǰ�߳���context������һ���µģ����أ�<br>
	 * 2����ǰ�߳�����ͬ��context��ֱ�ӷ��أ�<br>
	 * 3����ǰ�߳�����context,�����Ʋ�ͬ���رյ�ǰ�ĺ󣬴���һ���µģ�<br>
	 * 
	 * @param ctxName
	 * @return
	 * @throws SysException
	 */
	public Context getContext(String ctxName) throws SysException {
		ContextDef ctxDef = (ContextDef) pro.getContexts().get(ctxName);
		Object obj = threadCtxNames.get();
		if (obj != null) {
			String name = (String) obj;
			Object ctxObj = threadCtxs.get();
			// ����һ������context��ֱ�ӷ���
			if (name.equals(ctxName)) {
				return (Context) ctxObj;
			} else {
				// ��ǰcontext����Ҫ���ҷ�Ĭ�ϵģ��رյ�ǰcontext��������context
				Context oriCtx = (Context) ctxObj;
				try {
					// �ر�weblogic��ǰջ���ķ�Ĭ��context
					oriCtx.close();
					log.debug("�ɹ��ر�context:" + name);
					threadCtxNames.set(null);
					threadCtxs.set(null);
				} catch (NamingException e) {
					throw new SysException("1000001", "�ر�ϵͳ����contextʱ�����쳣��"
							+ name, e);

				}

			}
		}
		Context ctx = null;
		try {
			ctx = createContext(ctxDef);
			threadCtxNames.set(ctxName);
			threadCtxs.set(ctx);
		} catch (NamingException e) {
			LogUtil.logExceptionStackTrace(log, e);
			log.error("��ʼ��contextʧ�ܣ�Context_Name:" + ctxDef.getName());
		}

		return ctx;
	}

	private Context createContext(ContextDef ctxDef) throws NamingException {
		Context ctx = null;
		String intialContext = ctxDef.getInitialContext();

		if (!StringUtil.isBlank(intialContext)
				&& intialContext.trim().toUpperCase().equals(
						ContextDef.INITIAL_CONTEXT_TRUE)) {
			ctx = new InitialContext();
		} else {
			Hashtable ht = new Hashtable();
			ht.put(Context.INITIAL_CONTEXT_FACTORY, ctxDef
					.getInitContextFactory().trim());
			ht.put(Context.PROVIDER_URL, ctxDef.getProviderUrl());
			if (!StringUtil.isBlank(ctxDef.getSecurityPrincipal())) {
				ht.put(Context.SECURITY_PRINCIPAL, ctxDef
						.getSecurityPrincipal());
				ht.put(Context.SECURITY_CREDENTIALS, ctxDef
						.getSecurityCredentials());
			}
//			ht.put(weblogic.jndi.WLContext.ENABLE_SERVER_AFFINITY, "true");
			ctx = new InitialContext(ht);
		}
		log.error("�ɹ���ʼ��Context:" + ctxDef.getName() + ":" + ctx.toString());
		threadCtxNames.set(ctxDef.getName());
		threadCtxs.set(ctx);

		return ctx;
	}
	
	
	/**
	 * ��Ե�server��ַ���ʣ����ṩ��Ⱥfailover����
	 * 
	 * @param url
	 * @param principal
	 * @param credentials
	 * @return
	 * @throws NamingException
	 */
	public static Context createContext(String url,String principal,String credentials) throws NamingException {
		Context ctx = null;
		
			Hashtable ht = new Hashtable();
			ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			ht.put(Context.PROVIDER_URL, url);
			if (!StringUtil.isBlank(principal)) {
				ht.put(Context.SECURITY_PRINCIPAL, principal);
				ht.put(Context.SECURITY_CREDENTIALS, credentials);
			}
			//ht.put(weblogic.jndi.WLContext.ENABLE_SERVER_AFFINITY, "true");��server��ַ����
			ctx = new InitialContext(ht);
		
		log.error("�ɹ���ʼ��Context:" + url + ":" + ctx.toString());
		
		return ctx;
	}

	/**
	 * �������ejb��context��ejb��
	 * 
	 * 
	 */
	public void clear() {
		jndiTreeMap.clear();
	}

	public String getDefaultName() {
		return defaultName;
	}

	public static void main(String[] args) throws SysException, AppException {
		//JndiFactory.getInstance();
		log.debug("��ʼ����JndiFactory.java��main()...");
		// String filePath="D:\env\sps\context\context-config.xml";
		String filePath = "D:/env/sps/context/context-config.xml";
		// String filePath1="D:\\env\\sps\\context\\context-config.xml";
		//String contextURL = System.getProperty(SysConstants.SYSTEM_PRPTY_CONTEXT_CONFIG_URL);
		//JndiFactory.getInstance(contextURL);
		//new JndiFactory(filePath);

	}

}
