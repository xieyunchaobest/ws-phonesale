package com.cattsoft.sx.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.sx.delegate.LoginDelegate;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-24 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public class LoginAction extends DispatchAction {

	private static Logger log = Logger.getLogger(LoginAction.class);

	public final static String CUR_SUB_SYSTEM = "curSubSystem";

	public LoginAction() {
	}

	/**
	 * ��ôӿͻ��˴����XML�ַ���
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getXML(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}

	

	/**
	 * �û���¼
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author maxun
	 */
	public ActionForward spslogin4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.debug("�û���½��ʼ......");      
		String responseXml = null;
		//���xml�ַ���
		String requestXml = getXML(request);
		if (StringUtil.isBlank(requestXml)) {
			throw new AppException("", "MOS�ͻ�������Ϊ��");
		}
		//����Xml
//		LoginRequestDocument loginReqDoc=LoginRequestDocument.Factory.parse(requestXml);
//		UserInfo userInfo = loginReqDoc.getLoginRequest().getUserInfo();
//		if (userInfo.getUserName()==null&&userInfo.getPassWord()==null) {
//			throw new AppException("", "MOS�����û�������ʧ��");
//		}
//		String userName = userInfo.getUserName();
//		String password = userInfo.getPassWord();
//		
//		LoginResponseDocument loginRepDoc = LoginResponseDocument.Factory.newInstance();
//		LoginResponse loginRep = loginRepDoc.addNewLoginResponse();
//		LoginResult loginResult = loginRep.addNewLoginResult();
//		loginResult.setResultCode("0");//0�ɹ���1�û�������2�������3�û������������
//		loginResult.setResultDesc("");
//		loginResult.setStaffId(userName);
//		loginResult.setStaffName("");
		//���Xml
		responseXml = LoginDelegate.getDelegate().login(requestXml);
	//	responseXml = loginRepDoc.toString();
		if (responseXml!=null) {
			byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}		
		return null;
	}	
}
