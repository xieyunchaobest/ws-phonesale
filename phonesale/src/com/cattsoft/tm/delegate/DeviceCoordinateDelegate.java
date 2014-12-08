package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IMos2Rms;
import com.cattsoft.im.service.webservice.client.IMos2RmsService;
import com.cattsoft.im.service.webservice.client.IMos2RmsServiceLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;

/**
 * ��Դ�˲�
 * @author xieyunchao
 *
 */
public class DeviceCoordinateDelegate {
	
	private static final Logger log = Logger.getLogger(DeviceCoordinateDelegate.class);

	private static DeviceCoordinateDelegate delegate = new DeviceCoordinateDelegate();

	public static DeviceCoordinateDelegate getDelegate() {
		return delegate;
	}

	/**
	 * �޲ι��캯��
	 */
	public DeviceCoordinateDelegate() {
	}
	
	
	/**
	 * ������Դwebservice����
	 * @param jsonStr
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String callRmsService(String jsonStr,String funcCode) throws SysException, AppException  {
		log.debug("�����������Ϊ��" + jsonStr);
		IMos2RmsService service = new IMos2RmsServiceLocator();
		IMos2Rms client=null;
		String res=null;
		String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.MOS_SERVICE_ADDR_FOR_RMS_TEMP, null, null, null, null, null);
//		String urlStr = "http://10.22.1.15:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://10.21.1.29:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://192.168.100.233:1991/trms/services/Mos2RmsService";
//		urlStr = "http://10.22.1.41:8080/trms/services/Mos2RmsService";
		log.debug("����webservice��ַΪ��" + urlStr);
		URL url;
		String responseFromRms = null;
		try {
			url = new URL(urlStr);
			client = service.getIMos2RmsPort(url);
			responseFromRms = client.mos2Rms(funcCode, "", jsonStr);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
			
		}
		log.debug("res: " + res);
		if(StringUtil.isExcetionInfo(responseFromRms)){
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" + StringUtil.getExcetionInfo(responseFromRms)); 
		}
		return responseFromRms;
	}
	
	/**
	 * ������Դwebservice����
	 * @param jsonStr
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
//	public String showDeviceList4MOS(String jsonStr,String funcCode) throws SysException, AppException  {
//		com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument doc=com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument.Factory.newInstance();
//		DeviceCheckResponse deviceCheck=doc.addNewDeviceCheckResponse();
//		deviceCheck.setLocalNetId("1111");
//		deviceCheck.setServiceAreaId("12222");
//		deviceCheck.setResultKey("0");
//		deviceCheck.setResultValue("�ɹ�");
//		
//		DeviceCheckInfos checkInfos=deviceCheck.addNewDeviceCheckInfos();
//		DeviceCheckInfo info1=checkInfos.addNewDeviceCheckInfo();
//		info1.setDeviceId("1111");
//		info1.setDeviceName("�����г�Ч·����С��231098-A������");
//		info1.setDeviceInstallAddress("�����г�Ч·����С��32��¥�����վ�Ա�");
//		info1.setDeviceFactoryId("111");
//		info1.setDeviceFactoryName("��Ϊ");
//		info1.setDeviceModel("CB-201");
//		info1.setLatitude("116.282962");
//		info1.setLongitude("39.987946");
//		
//		DeviceCheckInfo info2=checkInfos.addNewDeviceCheckInfo();
//		info2.setDeviceId("1111");
//		info2.setDeviceName("�����г�Ч·����С��231098-A������");
//		info2.setDeviceInstallAddress("�����г�Ч·����С��32��¥�����վ�Ա�");
//		info2.setDeviceFactoryId("111");
//		info2.setDeviceFactoryName("��Ϊ");
//		info2.setDeviceModel("CB-201");
//		info2.setLatitude("");
//		info2.setLongitude("");
//		
//		
//		DeviceCheckInfo info3=checkInfos.addNewDeviceCheckInfo();
//		info3.setDeviceId("1111");
//		info3.setDeviceName("�����г�Ч·����С��231098-A������");
//		info3.setDeviceInstallAddress("�����г�Ч·����С��32��¥�����վ�Ա�");
//		info3.setDeviceFactoryId("111");
//		info3.setDeviceFactoryName("��Ϊ");
//		info3.setDeviceModel("CB-201");
//		info3.setLatitude("");
//		info3.setLongitude("");
//		
//		DeviceCheckInfo info4=checkInfos.addNewDeviceCheckInfo();
//		info4.setDeviceId("1111");
//		info4.setDeviceName("�����г�Ч·����С��231098-A������");
//		info4.setDeviceInstallAddress("�����г�Ч·����С��32��¥�����վ�Ա�");
//		info4.setDeviceFactoryId("111");
//		info4.setDeviceFactoryName("��Ϊ");
//		info4.setDeviceModel("CB-201");
//		info4.setLatitude("116.282962");
//		info4.setLongitude("39.987946");
//		
//		System.out.println("doc==========="+doc.toString());
//		return doc.toString();
		
//	}

}
