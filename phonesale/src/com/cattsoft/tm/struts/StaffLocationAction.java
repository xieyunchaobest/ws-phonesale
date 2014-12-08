/**
 * 
 */
package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.pub.util.VariableHelper;
import com.cattsoft.sx.delegate.StaffLocationDelegate;
import com.cattsoft.tm.vo.RealPosition;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument.REALPOSITIONREQ;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument.REALPOSITIONREQ.REALPOSITIONLIST;

/**
 * @author wanghaoc
 * CreateTime 2012-10-8 ����10:55:59
 */
public class StaffLocationAction extends DispatchAction{
	
	private static  List<String>  xmllist= null;//�洢����
	private static  Timer timer = null;//��ʱ��
	private static Boolean numflag=true;
	private static Boolean timerflag=true;
    private  List<String> dolist= new ArrayList<String>();
    private  String requestXml="";
    private static   long timeDleay;
    private static   int doOnceMaxNum;
    private static   int sumitNum;
    
	private static final Logger log = Logger.getLogger(WoHandleAction.class);
	
	public static Timer getTimer() {
		if(timer == null){
			timer = new Timer();
	   }
		return timer;
	}

	public static List<String> getXmllist() {
		if(xmllist == null){
			xmllist = new ArrayList<String>();
	   }
		return xmllist;
	}
	
	public ActionForward addStaffLocation4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, ServiceException, InterruptedException  {
 		      requestXml = ReqUtil.getRequestStr(request);
		     log.error("requestXml--------"+requestXml);
		     
		      timeDleay= Long.parseLong(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_INTERVAL, null, null, null, null, null));
		      doOnceMaxNum= Integer.parseInt(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_ONCE_MAXNUM, null, null, null, null, null));
		      sumitNum= Integer.parseInt(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_SUBMIT_NUM, null, null, null, null, null));
		      xmllist=StaffLocationAction.getXmllist();
		      
			    xmllist.add(requestXml);
//			   System.out.println("---------------�յ�����------"+xmllist.size());
			  devRequestMethod();//�ַ���������ʽ��ֱ�Ӵ���Ͷ�ʱ������
		return null;
	}
	
	 /**
	  * @author 
	  *��װ�������ݣ�����λ����Ϣ
	  */
	private void equDataForSendRequest() {
			List<String>  list=new ArrayList<String>();
			if(dolist.size()> doOnceMaxNum/sumitNum ){
				//��5������, Ҫ�ж��Ƿ��ύ�ɹ�
				for(int i=0; i<sumitNum; i++){
					 equData(list, i);
					 sendRealPosition(list);
	     		  }
			  }else{
				     list=dolist;
				     sendRealPosition(list); 
	       }
			   resetReqEnroment();
	}
	
	 /**
	  * ������ɺ��ʼ�����󻷾���
	  */
	private void resetReqEnroment() {
		dolist.clear();
		   if(timer!=null){
		    	timer.cancel();//ʹ����������˳�����
		    	timer=null;
		   }
		   if(!timerflag){
			   timerflag=true;
		   }
		   if(!numflag){
			   numflag=true;
		   }
	}
	
	 /**
	  * ��װ��������
	  */
	private void equData(List<String> list,  int i) {
		
		int[] num = devNum(dolist.size());
		if(i==0){
			 for(int j=0; j<num[0];j++){
				 String strbranch = dolist.get(j);
		    	 list.add(strbranch);
			 }
		 }
		 else {
		     for(int j=num[i-1]; j<num[i];j++){
		          String strbranch = dolist.get(j);
		          list.add(strbranch);
		        }
		 }
	}
	/**
	 * �Զ�ǩ�������û���ʱ��λ�����
	 * @param requestXml
	 * @throws Exception 
	 */
	public ActionForward sendAutoSignatureLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 requestXml = ReqUtil.getRequestStr(request);
		String responseXml = null;	
				    responseXml = StaffLocationDelegate.getDelegate().addAutoSignatureLocation4MOS(requestXml);
				    
				    log.error("responseXml--------��ȡ���صĽ��-"+responseXml );
				          
				    
				    if (responseXml!=null) {
				    	ReqUtil.write(response, responseXml.toString());
					}		
					return null;
	}
	 /**
	  * @author 
	  * ����λ����Ϣ���������
	 * @throws ServiceException 
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	  */
	private void sendRealPosition(List<String>  list) {
			String  requestXml;
//			 System.out.println("-------------��������ǰ��-------"+xmllist.size());
			//��listƴ��xml
			 requestXml=spliceXml(list);
			   log.error("spliceXml---------"+requestXml );
//				 localTest(requestXml);
                String responseXml;
				try {
					    responseXml = StaffLocationDelegate.getDelegate().addStaffLocation4MOS(requestXml);
					    log.error("responseXml--------��ȡ���صĽ��-"+responseXml );
					    deleteFromXmllist(list);
//					    System.out.println("-------------�������߀ʣ------"+xmllist.size());
					    list.clear();        
					    
				} catch (SysException e) {
					  log.error("����쳣1" );
					e.printStackTrace();
				} catch (AppException e) {
					  log.error("����쳣2" );
					e.printStackTrace();
				}
	}
	
	 /**
	  *���ػ��yԇ
	  */
//	private void localTest(String requestXml) throws ServiceException,
//			MalformedURLException {
//		String urlStr = "http://192.168.100.233:1991/trms/services/RmsForMosService";
//		 org.apache.axis.client.Service service=new org.apache.axis.client.Service();
//		 Call call;
//		 call = (Call) service.createCall();
//		 call.setTargetEndpointAddress( new java.net.URL(urlStr) );
//		 call.setOperationName( "realPosition" );
//		 try {
//			String	responseXml = (String) call.invoke( new Object[] {requestXml} );
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	 /**
	  *ƴ�Ӷ��xml
	  */
	private String spliceXml(List<String> list) {
		List<RealPosition> positionList = new ArrayList<RealPosition>();
//		spliceXml---------<REAL_POSITION_REQ/>
		//��ȡ���xml�����Ϣ��
		for(int j=0; j<list.size();j++){
			String xmlString = list.get(j);
	      	REALPOSITIONREQDocument doc;
	    	try {
	    		
				doc = REALPOSITIONREQDocument.Factory.parse(xmlString);
			  	REALPOSITIONREQ req = doc.getREALPOSITIONREQ();
		    	REALPOSITIONLIST[] realPositonList = req.getREALPOSITIONLISTArray();
		    	
		    	if(realPositonList != null && realPositonList.length>0 ){
		     		for (int i=0 ; i<realPositonList.length ;i++){
		     			
	        			Integer terminalId = VariableHelper.getInteger(realPositonList[i].getTERMINALID());
	                    Integer terminalType = VariableHelper.getInteger(realPositonList[i].getTERMINALTYPE());
	                    String  mobileNbr = VariableHelper.getString(realPositonList[i].getMOBILENBR());
	                    Double  longTitude = VariableHelper.getDouble(realPositonList[i].getLONGTITUDE());//����
	                    Double  laTitude = VariableHelper.getDouble(realPositonList[i].getLATITUDE());//γ��
//	                    Date receiveTime = VariableHelper.getDate(DateUtil.str2DateTime(realPositonList[i].getRECEIVETIME()));		//ʱ��
	                    String receiveTime = VariableHelper.getString(realPositonList[i].getRECEIVETIME());		//ʱ��
	                    Double altitude = VariableHelper.getDouble(realPositonList[i].getALTITUDE());//�߶�
	                    Double vilocity = VariableHelper.getDouble(realPositonList[i].getVELOCITY());//�ٶ�
	                    Double angle =  VariableHelper.getDouble(realPositonList[i].getANGLE());//����
	                    Integer state = VariableHelper.getInteger(realPositonList[i].getSTATE());//״̬
	                  
	                    RealPosition  r = new RealPosition();
	                    r.setTerminalId(terminalId);
	                    r.setTerminalType(terminalType);
	                    r.setMobileNbr(mobileNbr);
	                    r.setLongTitude(longTitude);
	                    r.setLaTitude(laTitude);
	                    r.setReceiveTime(receiveTime);
	                    r.setAltitude(altitude);
	                    r.setVilocity(vilocity);
	                    r.setAngle(angle);
	                    r.setState(state);
	                    positionList.add(r);
	        		}
	        		
	        	}
			} catch (XmlException e) {
		       log.error("------����xml ����" );
				e.printStackTrace();
			}
		}
		//ƴ�ӳ�һ���µ�xml
		REALPOSITIONREQDocument returnDoc = REALPOSITIONREQDocument.Factory.newInstance();
        REALPOSITIONREQ rmReturn = returnDoc.addNewREALPOSITIONREQ();
        
		for(int k=0;k<positionList.size();k++){
	        REALPOSITIONLIST posList = rmReturn.addNewREALPOSITIONLIST();
			posList.setTERMINALID(getStr(positionList.get(k).getTerminalId()));
			posList.setTERMINALTYPE(getStr(positionList.get(k).getTerminalType()));
			posList.setMOBILENBR(getStr(positionList.get(k).getMobileNbr()));
			posList.setLONGTITUDE(getStr(positionList.get(k).getLongTitude()));
			posList.setLATITUDE(getStr(positionList.get(k).getLaTitude()));
			posList.setALTITUDE(getStr(positionList.get(k).getAltitude()));
			posList.setRECEIVETIME(getStr(positionList.get(k).getReceiveTime()));
			posList.setVELOCITY(getStr(positionList.get(k).getVilocity()));
			posList.setANGLE(getStr(positionList.get(k).getAngle()));
			posList.setSTATE(getStr(positionList.get(k).getState()));
		}
	
	  String  returnString ="<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>"+returnDoc.toString();
		return returnString;
	}	
	/**
	  * ��ȡ����ֵ
	  */
	private String getStr(Object o){
	   String str="";
		if(o!=null){
			return o.toString();
		}
		return  str;
	}
	
	/**
	  * �ӻ�����ɾ���������list
	  */
	private void deleteFromXmllist(List<String> list) {
		for(int k=0; k < list.size();k++){
		 String strbranch = list.get(k);
		 xmllist.remove(strbranch);
		}
	}
	
	 /**
	  * ���䴦������ʽ
	  */
	private synchronized  void devRequestMethod(){
		
    		if(xmllist.size()>=doOnceMaxNum && numflag){
//    			 System.out.println("-------------�M����������-----"+xmllist.size());
    			timerflag=false;
    			for(int i=xmllist.size()-doOnceMaxNum; i<xmllist.size(); i++){
    				String str=(String)xmllist.get(i);
    				dolist.add(str);
    			}
    			equDataForSendRequest(); 
    		}else{ 
    		//��ֻҪ�жϸ���С��200ʱ���Ϳ�ʼ��ʱ������һ���Ӻ����жϸ��������Ƿ��ٴ����С�
    			if(timer==null && timerflag){
    			  timer = StaffLocationAction.getTimer();
    			  timer.schedule(new MyTask(), timeDleay);
    			}
    		}
    	}
		
	 /**
	  * 
	  * ��ʱ��������
	  */
    class MyTask extends java.util.TimerTask{
    	@Override
    	public void run() {
    		if(xmllist.size()<doOnceMaxNum ){
    			  numflag=false;	
// 				 System.out.println("-------------�r�g���_ʼ����-----"+xmllist.size());
    			for(int i=0; i<xmllist.size(); i++){
    				String str=(String)xmllist.get(i);
    				dolist.add(str);
    			}
    			equDataForSendRequest();
    	      }else{
    	    	   numflag=true;	
    	    	   timer=null;
//   				 System.out.println("-------------�r�g������������������������---"+xmllist.size());
    	    	   devRequestMethod();
    	       }
    		}
     }		
    /**
	  * @author 
	  * ����ƽ��
	  */
	 private  int[] devNum(int i) {
		   int[] array1=  new int[sumitNum];
		   for(int j=0 ; j<array1.length; j++){
			   if(j==0){
				   array1[j]=i/sumitNum;
				   i=i-array1[j];
			   }else{
			   array1[j]=i/(sumitNum-j);
			      i=i-array1[j];
			    }
			   if(j>=1){
			   array1[j]=array1[j-1]+array1[j];
			   }
		   }
		return array1;
	  }
	
	public ActionForward getSendLocationInterval(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		String sendLocationInterval=SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SEND_LOCATION_INTERVAL, null, null, null, null, null);
		
		if (sendLocationInterval!=null) {
			ReqUtil.write(response, sendLocationInterval.toString());
		}
		return null;
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
}
