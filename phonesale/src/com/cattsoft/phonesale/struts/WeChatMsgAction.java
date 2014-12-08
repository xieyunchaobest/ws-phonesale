package com.cattsoft.phonesale.struts;

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

import com.cattsoft.phonesale.vo.Msg;
import com.cattsoft.webpub.util.WeChatMessageUtil;

public class WeChatMsgAction extends DispatchAction{
	
	private static final Logger log = Logger.getLogger(WeChatMsgAction.class);
	
	public ActionForward receiveMsg(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		String echostr=req.getParameter("echostr");
//		if(!StringUtil.isBlank(echostr)){
//			log.info("echo======================"+echostr);
//			com.cattsoft.webpub.util.ReqUtil.write(rep, echostr);
//		}
		
		String data=getData(req);
		log.info("data====="+data);
		Msg msg=WeChatMessageUtil.recevieMsg(data);
		Msg m=new Msg();
		m.setToUserName(msg.getFromUserName());
		m.setContent("Msg Test!");
		String sendxml=WeChatMessageUtil.getResponeTxt(m);
		log.info("send xml is======"+sendxml);
		com.cattsoft.webpub.util.ReqUtil.write(rep, sendxml);
		return null;
		
	}

	
	/**
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getData(HttpServletRequest request) throws IOException{
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