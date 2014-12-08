package com.cattsoft.webpub.struts;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * <p>Title: �¾���ϵͳwebģ��װ�غ�ж��ʱ������õ���</p>
 * <p>Description: ���ཫ������struts-config.xml�У����õ���ʽ���£�</p>
 *  <p>< plug-in className="new97.pub.util.InitStrutsPlugIn" /></p>
 * <p>����webģ��װ�غ�ж�ص�ʱ��ִ��������Ҫִ�еĳ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: CATTSoft</p>
 * @author not attributable
 * @version 1.0
 */
public class InitStrutsPlugIn
    implements PlugIn {
  private static Log log = LogFactory.getLog(InitStrutsPlugIn.class);
  public InitStrutsPlugIn() {
  }

  /**
   * webģ��ж�ص�ʱ��ִ�еĺ���
   */
  public void destroy() {
    /**@todo Implement this org.apache.struts.action.PlugIn method*/
    log.debug("destroy");

  }

  /**
   * webģ��װ�ص�ʱ��ִ�еĺ����������ｫ��ʼ�������š�ϵͳ������hibernate��sessionFactory
   * @param servlet ActionServlet
   * @param config ModuleConfig
   * @throws ServletException
   */
  public void init(ActionServlet servlet, ModuleConfig config) throws
      ServletException {
    /**@todo Implement this org.apache.struts.action.PlugIn method*/
    /*Context ctx = null;
    boolean isIniting = true;
    String initing = null;
    //��鼯Ⱥ���Ƿ��Ѿ���ʼ��ʼ�������û�в����ʼ����׼��jndi��
    try {
      ctx = new InitialContext();
      initing = (String) ctx.lookup("initing");
      if (log.isDebugEnabled()) {
        log.debug(
            "�Ѿ��б�Ļ�����ʼ��ʼ���ˣ�SessionFactory��DataCache�ڱ��������ٳ�ʼ����������ԭ�صȴ���ֱ����Ļ�����ʼ�����");
      }

    }
    catch (NamingException ex) {
      isIniting = false;
    }
    if (initing == null) { //�����Ⱥ��û�п�ʼ��ʼ���������ʼ����׼��jndi��
      try {
        ctx.bind("initing", "yes");
      }
      catch (NamingException ex2) {
      }

    }

    try {
      log.info("init begin....");
      if (log.isDebugEnabled()) {
        log.debug("isIniting----------------------" + isIniting);
      }

//   ERRINFO.instance();
      log.info("init DataCache begin....");
      try {
        DataCache.initial();
      }
      catch (DataCacheException ex1) {
        throw new SysException("9000005", "", ex1);
      }

      log.info("init DataCache end....");
      //��ʼ��SessionFactory���������Լ��ķ������ϣ����󶨵�cluster�ϡ�
      log.info("init SessionFactory begin....");
      try {
        HibernateUtil.createSessionFactory("hibernate/session_factory");
      }
      catch (HibernateUtilException he) {
        throw new SysException("9000005", "", he);
      }
      log.info("init SessionFactory end....");

      log.info("init status begin....");
      BizConfig.instance();
      log.info("init status end....");
      log.info("init JudgeMappingCache begin....");
      try {
        JudgeMappingCache.initial();
      }
      catch (DataCacheException ex1) {
        throw new SysException("9000005", "", ex1);
      }

      log.info("init JudgeMappingCache end....");

      log.info("init sys begin....");
//      if(Sysinit.isNull()){
      HashMap hm = new HashMap();
      SysConfigVO scv = new SysConfigVO();
      scv.setConfigId(new Long(32003));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("WEB_CONTEXT:" + scv.getCurValue());
      hm.put(Sysinit.WEB_CONTEXT, scv.getCurValue());
      scv.setConfigId(new Long(32004));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("EJB_LOCAL:" + scv.getCurValue());
      hm.put(Sysinit.EJB_LOCAL, scv.getCurValue());
      scv.setConfigId(new Long(32005));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("DBMAIN:" + scv.getCurValue());
      hm.put(Sysinit.DBMAIN, scv.getCurValue());
      scv.setConfigId(new Long(32006));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("DBTYPE:" + scv.getCurValue());
      hm.put(Sysinit.DBTYPE, scv.getCurValue());
      scv.setConfigId(new Long(32007));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("IF_INS_NEW_HREF:" + scv.getCurValue());
      hm.put(Sysinit.IF_INS_NEW_HREF, scv.getCurValue());
      scv.setConfigId(new Long(32008));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("USE_HREF_AUTH:" + scv.getCurValue());
      hm.put(Sysinit.USE_HREF_AUTH, scv.getCurValue());
      scv.setConfigId(new Long(31998));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("OS_TYPE:" + scv.getCurValue());
      hm.put(Sysinit.OS_TYPE, scv.getCurValue());
      scv.setConfigId(new Long(31590));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("STARTUP_SYM:" + scv.getCurValue());
      hm.put(Sysinit.STARTUP_SYM, scv.getCurValue());
      //2005-7-10 mjh ��֯��������ģʽ��A:���������ָL:���㼶��������Ϊ��ǰԱ������֯��
      scv.setConfigId(new Long(32009));
      scv = SMSysConfigDelegate.getDelegate().findSysConfigByPK(scv, -1);
      log.info("ORG_MNG_MODE:" + scv.getCurValue());
      hm.put(Sysinit.ORG_MNG_MODE, scv.getCurValue());
      //mjh end
      Sysinit.instance(hm);
//      }else
//        log.info("Sysinit is existed ....");
      log.info("init sys end....");
    }
    catch (SysException ex) {
      throw new ServletException(ex);
    }
    catch (AppException ex) {
      throw new ServletException(ex);
    }

    ConvertUtils.register(new ShortConverter(null), Short.TYPE);
    ConvertUtils.register(new ShortConverter(null), Short.class);
    ConvertUtils.register(new IntegerConverter(null), Integer.TYPE);
    ConvertUtils.register(new IntegerConverter(null), Integer.class);
    ConvertUtils.register(new LongConverter(null), Long.TYPE);
    ConvertUtils.register(new LongConverter(null), Long.class);
    ConvertUtils.register(new FloatConverter(null), Float.TYPE);
    ConvertUtils.register(new FloatConverter(null), Float.class);
    ConvertUtils.register(new DoubleConverter(null), Double.TYPE);
    ConvertUtils.register(new DoubleConverter(null), Double.class);
    ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);*/
  }

}
