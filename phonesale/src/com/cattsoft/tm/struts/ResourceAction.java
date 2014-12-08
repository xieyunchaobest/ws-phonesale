package com.cattsoft.tm.struts;

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
import org.apache.xmlbeans.XmlException;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.ResourceQueryDelegate;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xml4mos.xmlbeans.SystemStatusResponseDocument;

	public class ResourceAction extends DispatchAction{

	private static Logger log = Logger.getLogger(ResourceAction.class);
		
		public ResourceAction(){		
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
		public ActionForward queryDevice(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, SysException, IOException, XmlException {
			log.debug("��Դ��ѯ ");
			
			String requestxml=ReqUtil.getRequestStr(request);
			log.debug("�����ѯЭ��Ϊ��" + requestxml);
			String responsexml=ResourceQueryDelegate.getDelegate().queryDevice(requestxml);
			
			ReqUtil.write(response, responsexml.toString());
			return null;
		}
		
		public ActionForward systemStatus(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, SysException, IOException {
			log.debug("��ʼ�������б� ");
			
			String requestxml=ReqUtil.getRequestStr(request);
			String responsexml=ResourceQueryDelegate.getDelegate().systemStatus(requestxml);
			response.setCharacterEncoding("UTF-8");
			//ע�����Ĳ����� 
			//����Xml
			/*try {
				WoOperateResponseDocument REEE = WoOperateResponseDocument.Factory.parse(requestxml);
			} catch (XmlException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			SystemStatusResponseDocument systemStatusResponseDoc = null;
			try {
				systemStatusResponseDoc = SystemStatusResponseDocument.Factory.parse(responsexml);
			}catch (XmlException e) {
					throw new AppException("", "����XML��ʽ�쳣��"+responsexml);
				}
			ReqUtil.write(response, responsexml.toString());
			return null;
		}
		
		/**
		 * ��Դ�ӿڵ���
		 */
		public ActionForward res4MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			log.debug("��ʼ.��ѯ.....");
			String responseXml = null;
			
			// ���xml�ַ���
			String requestXml = ReqUtil.getRequestStr(request);
			if (StringUtil.isBlank(requestXml)) {
				throw new AppException("", "MOS�ͻ�������Ϊ��");
			}
//			 String urlStr = "http://10.22.1.61:8080/trms/services/RmsInterfaceSvcBoTest";
//					org.apache.axis.client.Service service=new org.apache.axis.client.Service();
//					Call     call    = (Call) service.createCall();//����Callʵ����Ҳ�Ǳ���ģ�
//				     call.setTargetEndpointAddress( new java.net.URL(urlStr) );//ΪCall���÷����λ��
//				        call.setOperationName( "testResQuery" );//ע�ⷽ������HelloWorld.java��һ������
//				         String res = (String) call.invoke( new Object[] {requestXml} );//����String��û�д������
//				                         System.out.println( "ddddddddddddddd"+res );
			
//			  String res =          "<RES_INFO_RSP>"+
//              "<RESP_CODE>0</RESP_CODE>"+
//              "<RESP_DESC>mos��Դ��ѯ�ӿ�:��Դ��Ϣ��ѯ�ɹ�!</RESP_DESC>"+
//              "<RES_INFO>"+
//                "<DEVICE_INFO>"+
//                  "<RES_NAME>BRIP(003)</RES_NAME>"+
//                  "<RES_TYPE>xDSL�˿���Դ����</RES_TYPE>"+
//                  "<RES_ID>7370380</RES_ID>"+
//                  "<MODEL_INFO>"+
//                    "<MODEL_NAME>ZTE-F430</MODEL_NAME>"+
//                  "</MODEL_INFO>"+
//                  "<FACTORY_INFO>"+
//                    "<FACTORY_NAME>������˾</FACTORY_NAME>"+
//                    "<FACTORY_ID>503</FACTORY_ID>"+
//                  "</FACTORY_INFO>"+
//                  "<USED_PORT>"+
//                    "<PORT_NAME>1-1-7-8</PORT_NAME>"+
//                    "<PORT_ID>1178580</PORT_ID>"+
//                  "</USED_PORT>"+
//               "</DEVICE_INFO>"+
//                "<DEVICE_INFO>"+
//                  "<RES_NAME>001</RES_NAME>"+
//                  "<RES_TYPE>�����û��˿���Դ����</RES_TYPE>"+
//                  "<RES_ID>7330002</RES_ID>"+
//                  "<MODEL_INFO>"+
//                    "<MODEL_NAME>DTT-F620</MODEL_NAME>"+
//                  "</MODEL_INFO>"+
//                  "<FACTORY_INFO>"+
//                    "<FACTORY_NAME>����</FACTORY_NAME>"+
//                    "<FACTORY_ID>940</FACTORY_ID>"+
//                  "</FACTORY_INFO>"+
//                  "<USED_PORT>"+
//                    "<PORT_NAME>570-0-11-7</PORT_NAME>"+
//                    "<PORT_ID>105215046</PORT_ID>"+
//                  "</USED_PORT>"+
//                "</DEVICE_INFO>"+
//                "<LINE_INFO>"+
//                  "<CABLE_NAME>BESYW-01-1-0001-91-100</CABLE_NAME>"+
//                  "<LINE_TYPE>���ߵ���</LINE_TYPE>"+
//                  "<CABLE_ID>448256</CABLE_ID>"+
//                  "<DEVICE_INFO>"+
//                    "<RES_NAME>BESYW-01</RES_NAME>"+
//                    "<RES_TYPE>���߼�</RES_TYPE>"+
//                    "<RES_ID>7331439</RES_ID>"+
//                    "<MDF_CONN>"+
//                      "<NAME>1-1-228</NAME>"+
//                      "<ID>12231657</ID>"+
//                    "</MDF_CONN>"+
//                    "<LINK_TYPE>4</LINK_TYPE>"+
//                  "</DEVICE_INFO>"+
//                  "<DEVICE_INFO/>"+
//                  "<DEVICE_INFO>"+
//                    "<RES_NAME>BESYW-01</RES_NAME>"+
//                    "<RES_TYPE>һ��������</RES_TYPE>"+
//                    "<RES_ID>7330985</RES_ID>"+
//                    "<CCP_CONN>"+
//                      "<NAME>1-3-220</NAME>"+
//                      "<ID>24634466</ID>"+
//                    "</CCP_CONN>"+
//                    "<LINK_TYPE>4</LINK_TYPE>"+
//                  "</DEVICE_INFO>"+
//                  "<DEVICE_INFO>"+
//                    "<RES_NAME>004</RES_NAME>"+
//                    "<RES_TYPE>���ߺ�</RES_TYPE>"+
//                    "<RES_ID>7353837</RES_ID>"+
//                    "<DP_CONN>"+
//                      "<NAME>0-0-95</NAME>"+
//                      "<ID>32400353</ID>"+
//                    "</DP_CONN>"+
//                    "<LINK_TYPE>1</LINK_TYPE>"+
//                  "</DEVICE_INFO>"+
//                "</LINE_INFO>"+
//              "</RES_INFO>"+
//              "<CUSTOMER_INFO>"+
//                "<CUST_NAME>�����</CUST_NAME>"+
//                "<CUST_TYPE/>"+
//                "<INSTALL_ADDR>���ɹ��������������򻪰��´���԰����֯���ۺ�¥451��</INSTALL_ADDR>"+
//                "<RES_OVER_ADDR/>"+
//              "</CUSTOMER_INFO>"+
//              "<NBR_INFO>"+
//                "<L_LINE_NBR>8324090</L_LINE_NBR>"+
//                "<P_LINE_NBR>8324090</P_LINE_NBR>"+
//                "<S_LINE_NBR>A9210531</S_LINE_NBR>"+
//              "</NBR_INFO>"+
//            "</RES_INFO_RSP>";
//			
	           String res = ResourceQueryDelegate.getDelegate().resQuery(requestXml);
	           ReqUtil.write(response, res.toString()); 
			return null;
		}
		
		public ActionForward res14MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			log.debug("�û���½��ʼ......");
			String responseXml = null;
			
//			// ���xml�ַ���
			String requestXml = ReqUtil.getRequestStr(request);
			if (StringUtil.isBlank(requestXml)) {
				throw new AppException("", "MOS�ͻ�������Ϊ��");
			}
			
//			 String urlStr = "http://10.22.1.61:8080/trms/services/RmsInterfaceSvcBoTest";
//					org.apache.axis.client.Service service=new org.apache.axis.client.Service();
//					Call     call    = (Call) service.createCall();//����Callʵ����Ҳ�Ǳ���ģ�
//				     call.setTargetEndpointAddress( new java.net.URL(urlStr) );//ΪCall���÷����λ��
//				        call.setOperationName( "testDeviceQuery" );//ע�ⷽ������HelloWorld.java��һ������
//				         String res = (String) call.invoke( new Object[] {requestXml} );//����String��û�д������
//				                         System.out.println( "ddddddddddddddd"+res );
			
			String res = ResourceQueryDelegate.getDelegate().portAndConnQuery(requestXml);
			ReqUtil.write(response, res.toString());
			
			return null;
		}
		
		public ActionForward res24MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			log.debug("��Դ�ı�......");
			String responseXml = null;
			
//			// ���xml�ַ���
			String requestXml = ReqUtil.getRequestStr(request);
			if (StringUtil.isBlank(requestXml)) {
				throw new AppException("", "MOS�ͻ�������Ϊ��");
			}
//			 String urlStr = "http://10.22.1.61:8080/trms/services/RmsInterfaceSvcBoTest";
//					org.apache.axis.client.Service service=new org.apache.axis.client.Service();
//					Call     call    = (Call) service.createCall();//����Callʵ����Ҳ�Ǳ���ģ�
//				     call.setTargetEndpointAddress( new java.net.URL(urlStr) );//ΪCall���÷����λ��
//				        call.setOperationName( "testResChange" );//ע�ⷽ������HelloWorld.java��һ������
//				         String res = (String) call.invoke( new Object[] {requestXml} );//����String��û�д������
//				                         System.out.println( "ddddddddddddddd"+res );
			             
			String res = ResourceQueryDelegate.getDelegate().resChange(requestXml);
			ReqUtil.write(response, res.toString());
			
			return null;
		}
		public ActionForward initChangeTerminal4mos(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		    	log.debug("�ն˱����ʼ��......");
		     	String requestXml = getXML(request);
			    String responseXml = "";
//			   String responseXml = ResourceQueryDelegate.getDelegate().initChangeTerminal(requestXml);
			
				byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
				response.setContentLength(xmlBytes.length);
				response.getOutputStream().write(xmlBytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			
			return null;
		}
		
		public ActionForward changeTerminal4mos(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		    	log.debug("�ն˱���ύ......");
		     	String requestXml = getXML(request);
			    String responseXml = "";
//			   String responseXml = ResourceQueryDelegate.getDelegate().changeTerminal(requestXml);
			
				byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
				response.setContentLength(xmlBytes.length);
				response.getOutputStream().write(xmlBytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			
			return null;
		}
		
		
		public ActionForward deviceModelQuery4mos(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		    	log.debug("�ն����Ͳ�ѯ......");
		     	String requestXml = getXML(request);
			    String responseXml = "";
//			   String responseXml = ResourceQueryDelegate.getDelegate().deviceModelQuery(requestXml);
			
				byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
				response.setContentLength(xmlBytes.length);
				response.getOutputStream().write(xmlBytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			
			return null;
		}
		
	}
