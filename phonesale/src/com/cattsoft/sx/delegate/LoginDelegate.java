package com.cattsoft.sx.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.RmsServiceForMos;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosDelegate;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sp.delegate.SoManagerDelegate;

public class LoginDelegate {

	private static Logger log = Logger.getLogger(SoManagerDelegate.class);
	private static LoginDelegate delegateInstance = null;

	private LoginDelegate() {

	}

	public static LoginDelegate getDelegate() {
		if (delegateInstance == null)
			return new LoginDelegate();
		return delegateInstance;
	}

	public String login(String paramStr) throws AppException, SysException {
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			
			String urlStr = "";
			//�����ʼ��������ʹ�û����ַ
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//û�г�ʼ����ʹ�ó���
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
//			String urlStr = SysConstants.SYS_CONFIG_MOS_SERVER_ADDR;
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosLoginRep = client.login(paramStr);
			return mosLoginRep;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL��ַ����");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "����Զ��webservice����ʧ�ܣ�");
		}
		return null;

	}
}
