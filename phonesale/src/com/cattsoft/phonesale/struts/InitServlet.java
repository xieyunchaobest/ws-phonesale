package com.cattsoft.phonesale.struts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;


/**
 * ��ʼ��servlet
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(WeChatMsgAction.class);

	public void init() throws ServletException {
		// ��ȡweb.xml�����õĲ���
		TokenThread.appid = getInitParameter("appid");
		TokenThread.appsecret = getInitParameter("appsecret");

		log.info("weixin api appid:{}="+TokenThread.appid);
		log.info("weixin api appsecret:{}="+ TokenThread.appsecret);

		// δ����appid��appsecretʱ������ʾ
		if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
			log.error("appid and appsecret configuration error, please check carefully.");
		} else {
			// ������ʱ��ȡaccess_token���߳�
			new Thread(new TokenThread()).start();
		}
	}
}
