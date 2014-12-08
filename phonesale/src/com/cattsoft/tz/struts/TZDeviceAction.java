package com.cattsoft.tz.struts;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tz.delegate.TZDeviceDelegate;
import com.cattsoft.webpub.util.ReqUtil;

/**
 * ̨���豸Action
 * @author xieyunchao
 *
 */
public class TZDeviceAction extends DispatchAction{
	
	

	
	

	/**
	 * ���ݲ�ѯ������ʾ�豸�б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showDeviceList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res=null;
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_QUERY_DEVICE,parameter);
		}  catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS(e.getErrMsg());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS(e.getErrMsg());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
		
	}
	
	/**
	 * ��ѯ�豸ͼƬ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showDevicePhotoList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="SUCESS";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_QUERY_PHOTO,parameter);
		}   catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
		
	}
	
	
	/**
	 * ��ѯ�����豸ͼƬ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getSinglePhoto4Device4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_QUERY_SINGLE_PHOTO,parameter);
		}   catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
		
	}
	
	/**
	 *��¼�ɹ����ȡ������Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getCacheInfoAfterLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res=null;
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_CACHE_INFO_IN_LOGIN,parameter);
		}   catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
	}
	
	/**
	 *����豸����Ƭ��Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addTZDeviceInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="SUCESS";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_ADD_DEVICE_INFO,parameter);
		}  catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
	}
	
	/**
	 *ģ����ѯ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward tzFuzzyQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNC_TZ_FUZZY_QUERY,parameter);
		}  catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
	}
	
	
	/**
	 *ɾ���豸����Ƭ��Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteTZDeviceInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="SUCESS";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			res=TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_DELETE_DEVICE_INFO,parameter);
			res="SUCESS";
		}  catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
	}
	
	/**
	 *�����豸����Ƭ��Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updateTZDeviceInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String res="SUCESS";
		try {
			String parameter=ReqUtil.getRequestStr(request);
			TZDeviceDelegate.getDelegate().callIOMService4TZ(SysConstants.FUNCODE_TZ_UPDATE_DEVICE_INFO,parameter);
		}   catch (AppException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		} catch (SysException e) {
			res=com.cattsoft.pub.util.StringUtil.getAppException4MOS("�������˳����쳣��"+e.getMessage());
			e.printStackTrace();
		}
		ReqUtil.write(response, res);
		return null;
	}
	
}
