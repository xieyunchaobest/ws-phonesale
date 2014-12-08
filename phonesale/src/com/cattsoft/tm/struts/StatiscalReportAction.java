package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.StatiscalReportDelegate;
import com.cattsoft.webpub.util.ReqUtil;

public class StatiscalReportAction extends DispatchAction  {

	//ͳ�Ʊ���
	public ActionForward queryReport4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException, IOException {
		String jsonString = ReqUtil.getRequestStr(request);
        JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
        String woStaffId = (String) jsonObjectRequest.get("woStaffId");
	  //  String localNetId = (String) jsonObjectRequest.get("localNetId");
	   // String areaId = (String) jsonObjectRequest.get("areaId");
	    String reportflag = (String) jsonObjectRequest.get("reportflag");
			 JSONObject json=new JSONObject();
			    json.put("woStaffId", woStaffId);
				//json.put("localNetId", localNetId);
				//json.put("areaId", areaId);
				json.put("reportflag", reportflag);
		String resultStr = StatiscalReportDelegate.getDelegate().queryReport4MOS(json.toString());
	
//		if("[]".equals(resultStr)||StringUtil.isBlank(resultStr)) {
//			throw new AppException("", "û������ѯ����Ϣ��");
//		}
		
       if(resultStr.contains("Exception")) {
			throw new AppException("", "û������ѯ����Ϣ��");
		}
		byte[] jsonBytes;
		//�п��ܲ�����
		ReqUtil.write(response, resultStr);
	return null;
	}
	
	
	//�����б�
	public ActionForward queryReportList4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException, IOException {
		 //��request ��ȡ��json������,�Ӷ��������
		String jsonString = ReqUtil.getRequestStr(request);
        JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		//�Ѷ���ת����Ϊjson�ַ���
		JSONObject json=new JSONObject();
		//װ�����
		String reportflag = (String) jsonObjectRequest.get("reportflag");
		    if(reportflag != null && !"".equals(reportflag.trim())){
		    	if ("mend".equals(reportflag)){
		    		  json.put("reportflag", reportflag);
		    		  String timeflag = (String) jsonObjectRequest.get("timeflag");
		    		  if(timeflag != null && !"".equals(timeflag.trim())){
		    	 		 json.put("timeflag", timeflag);
		    	 	   }
		    	 	   String reportType =(String) jsonObjectRequest.get("reportType");
		    	 	   if(reportType != null && !"".equals(reportType.trim())){
		    	 		 json.put("reportType", reportType);
		    	  	   }
		    	 	  String woStaffId =(String) jsonObjectRequest.get("woStaffId");
		    	 	  if(woStaffId != null && !"".equals(woStaffId.trim())){
			    	 		 json.put("woStaffId", woStaffId);
			    	  	   }
		    	}else{
		    		//��װ��set ��������
		    		  json.put("reportflag", reportflag);
		    		 
		    		  //�¡���  
		    		  String timeflag = (String) jsonObjectRequest.get("timeflag");
		    		  if(timeflag != null && !"".equals(timeflag.trim())){
		    	 		 json.put("timeflag", timeflag);
		    	 	   }
		    		   //��������ʱ����ʱ 
		    	 	   String reportType =(String) jsonObjectRequest.get("reportType");
		    	 	   if(reportType != null && !"".equals(reportType.trim())){
		    	 		 json.put("reportType", reportType);
		    	  	   }
		    	 	  String woStaffId =(String) jsonObjectRequest.get("woStaffId");
		    	 	  if(woStaffId != null && !"".equals(woStaffId.trim())){
			    	 		 json.put("woStaffId", woStaffId);
			    	  	   }
		    	}
		    }
		  
			// ������������
			json.put("culmName", SysConstants.REPORT_COLUMN_SEQ);
			int pagNo = -1;
			PagInfo pagInfo = new PagInfo();
				
				if( (Integer)jsonObjectRequest.get("pageNo")==null)
				{ 
				pagNo=1;
			    }
				else{
					pagNo=(Integer)jsonObjectRequest.get("pageNo");
				}
				json.put("pagNo", pagNo);
				json.put("pagsize", 20);
				
    String jsonresult = StatiscalReportDelegate.getDelegate().queryReportList4MOS(json.toString());
		
    if("[]".equals(jsonresult)||StringUtil.isBlank(jsonresult)) {
    	jsonresult=StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
	}
    
    if(jsonresult.contains("Exception")) {
    	jsonresult=StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
	}
    
	byte[] jsonBytes;
	ReqUtil.write(response, jsonresult);
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
