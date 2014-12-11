package com.cattsoft.phonesale.struts;

import org.apache.log4j.Logger;

import com.cattsoft.phonesale.vo.AccessToken;
import com.cattsoft.pub.util.WeixinUtil;


/**
 * ��ʱ��ȡ΢��access_token���߳�
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	private static Logger log = Logger.getLogger(TokenThread.class);
	// �������û�Ψһƾ֤
	public static String appid = "";
	// �������û�Ψһƾ֤��Կ
	public static String appsecret = "";
	public static AccessToken accessToken = null;

	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info("��ȡaccess_token�ɹ�����Чʱ��{}�� token:{}="+ accessToken.getExpiresIn()+"   "+ accessToken.getToken());
					// ����7000��
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// ���access_tokenΪnull��60����ٻ�ȡ
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}
		}
	}
}
