package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;


import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;


public class SMLoginDelegate {
	private static final Logger log = Logger.getLogger(SMLoginDelegate.class);

	private static SMLoginDelegate delegate = null;

	public static SMLoginDelegate getDelegate() {
		if (delegate != null) {

		} else {
			delegate = new SMLoginDelegate();
		}
		return delegate;
	}

	/**
	 * MOS native ��sysconfig��ȡ��MOS��Ҫ�Ļ���
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String getSysConfig4MOS() throws SysException, AppException {

		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
		
		String urlStr = "";
		//�����ʼ��������ʹ�û����ַ
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//û�г�ʼ����ʹ�ó���
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//				null, null);
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(
					SysConstants.SYS_CONFIG_MOS_QUERY_SYS_CONFIG, null, null);
		} catch (RemoteException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (ServiceException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;
	}

	/**
	 * MOS native ��¼
	 * 
	 * @param voJson
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String login4MOS(String voJson) throws SysException, AppException {

		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
		
		String urlStr = "";
		//�����ʼ��������ʹ�û����ַ
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//û�г�ʼ����ʹ�ó���
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//				null, null);
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.FUNCODE_LOGIN,
					null, voJson);
		} catch (RemoteException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�");
		} catch (ServiceException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�");
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;
	}

	/**
	 * MOS Native ��ѯĬ�Ϲ���
	 * 
	 * @param prameter
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String findDefaultWorkAreasBySystemStaff4MOS(String prameter)
			throws SysException, AppException {

		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
		
		String urlStr = "";
		//�����ʼ��������ʹ�û����ַ
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//û�г�ʼ����ʹ�ó���
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//				null, null);
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client
					.svcCallIOMByMosNative(
							SysConstants.FUNCODE_FIND_DEFAULT_WORK_AREA, null,
							prameter);
		} catch (RemoteException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (ServiceException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		}
		log.debug("client: " + client);
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" + StringUtil.getExcetionInfo(vesion)); 
		}
		return vesion;

	}

	// �õ����°汾��Ϣ
	public String getLateVersion4MOS(String mosVersionApp) throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		
		String urlStr = "";
		//�����ʼ��������ʹ�û����ַ
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//û�г�ʼ����ʹ�ó���
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(
					SysConstants.FUNCODE_MOS_VERSION, null, mosVersionApp);
		} catch (RemoteException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		} catch (ServiceException e) {
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;

	}
}
