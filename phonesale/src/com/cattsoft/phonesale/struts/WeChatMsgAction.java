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
import com.cattsoft.pub.util.WeixinUtil;
import com.cattsoft.webpub.util.WeChatMessageUtil;

public class WeChatMsgAction extends DispatchAction{
	
	private static final Logger log = Logger.getLogger(WeChatMsgAction.class);
	public static final String appid="wxd55d712d4731636f";
	public static final String secret="c1b5f1260d402f6e90433bc6145c554d";
	
	
	
	public ActionForward receiveMsg(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
//		String echostr=req.getParameter("echostr");
//		if(!StringUtil.isBlank(echostr)){
//			log.info("echo======================"+echostr);a
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

	public ActionForward registerInit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
		String code=req.getParameter("code");
		log.info("code======"+code);
		
		
		return null;
	}
	
	public ActionForward register(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
		String phoneNo=req.getParameter("phoneNo");
		String callName=req.getParameter("calName");
		String checkNo=req.getParameter("checkNo");
		String code=req.getParameter("code");
		code="asfafsfasfasdfafasdf";
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?" +
				"appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		com.alibaba.fastjson.JSONObject tokenJson=WeixinUtil.httpRequest(url, "GET", null);
		String jsonstr=tokenJson.toString();
		log.info("token json is ====="+jsonstr); 
		String accessToken=tokenJson.getString("access_token");
		String expiresIn=tokenJson.getString("expires_in");
		String refreshToken=tokenJson.getString("refresh_token");
		String openId=tokenJson.getString("openid");
		
		
		String urlGetUserInfo="https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openId;
		com.alibaba.fastjson.JSONObject userInfoJson=WeixinUtil.httpRequest(urlGetUserInfo, "GET", null);
		String nickName=userInfoJson.getString("nickName");
		
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
