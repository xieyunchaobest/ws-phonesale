package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.tm.delegate.AutoTestConnectDelegate;
import com.cattsoft.webpub.util.ReqUtil;

public class AutoTestConnectAction extends DispatchAction{
	
	public ActionForward initTestStep4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initTestStepProObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String funCode = (String) initTestStepProObject.get("funCode");
		/*
		 * �˴��ɵ����ⲿϵͳ��ȡ���Բ���
		 */
		String returnStr = AutoTestConnectDelegate.getDelegate().initTestStep4MOS(initTestStepProObject.toString());
		if("disconnect".equals(funCode)) {
			returnStr="��·����,�˿ڲ���,�������,��Ԫ����";
		}else {
			returnStr="ģ�����,��������,��·����,�������";
		}
		ReqUtil.write(response, returnStr);
		return null;
	}	
	
	public ActionForward autoTestStep4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initTestStepProObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String funCode = (String) initTestStepProObject.get("funCode");
		/*
		 * �˴��ɵ����ⲿϵͳ��ȡ���Խ��
		 */
		String returnStr = AutoTestConnectDelegate.getDelegate().autoTestStep4MOS(initTestStepProObject.toString());
		if("��·����".equals(funCode)) {
			returnStr="1,���Թ����쳣";
		}else if("�������".equals(funCode)){
			returnStr="0,���Թ����쳣��";
		} else {
			returnStr="0,���Թ���������";
		}
		ReqUtil.write(response, returnStr);
		return null;
	}
	
	/**
	 * ��ôӿͻ��˴����json�ַ���
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException{
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
	
	
}
