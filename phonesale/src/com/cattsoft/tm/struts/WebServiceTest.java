package com.cattsoft.tm.struts;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WebServiceTest {

	public static void main(String[] args) {
		new WebServiceTest().pushMosMsg();
	}
	
	
	public void pushMosMsg()  {
	
		try {
			String endpoint = "http://133.96.71.75:7001/androidpn/services/NotificationManagerService?wsdl";
	         //ֱ������Զ�̵�wsdl�ļ�
	        //���¶�����· 
	         Service service = new Service();
	         Call call = (Call) service.createCall();
	         call.setTargetEndpointAddress(endpoint);
	         
	        String parm="{\"msg\":\"aaa\",\"fromObjectType\":\"adddd\",\"toObjectType\":\"P\",\"toObjectId\":\"111111\"}";

	         
	         call.setOperationName("svrCallBySPS");//WSDL���������Ľӿ�����
	         String  ret  =  (String)  call.invoke(new  Object[] {"sendNotifcationToUser",parm});   
	         System.out.println("result is "+ret);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}


}
