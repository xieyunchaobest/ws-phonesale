package com.cattsoft.webpub.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.GenericException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.BizConfig;
import com.cattsoft.pub.util.DataCache;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.pub.vo.GenericVO;

import com.cattsoft.sm.vo.StatusSVO;
import com.cattsoft.sm.vo.SysConfigSVO;
import com.cattsoft.sm.vo.SysUserExtendedMVO;

import com.cattsoft.sm.vo.WorkAreaSVO;


/**
 * Title: CRMϵͳ<br>
 * Description:���������б��ʼ���ķ��� <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class OptionUtil {
	private static final Logger log = Logger.getLogger(OptionUtil.class);

	


	/**
	 * ����ָ�������ֶ�������status�����л�ȡ������Ϣ�б�
	 * 
	 * @param tableName
	 * @param columnName
	 * @return List<LabelValueBean<StsWords,StsId>>
	 * @throws SysException
	 * @throws AppException
	 */
	public static List getStatuslvBean(String tableName, String columnName)
			throws SysException, AppException {
		// List statusList = new ArrayList();
		// Map statusCache = DataCache.get(DataCache.STATUS);
		// String key = tableName + DataCache.STATUS_SPLIT_WORD + columnName;
		// log.debug( "��ȡstatus������Ϣ��" + key);
		// Object obj = statusCache.get(key);
		// if (null == obj) {
		// throw new AppException("", "����status���ã��Ƿ����" + key + "��Ӧ��Ϣ!");
		// }
		// Map valueMap = (Map) obj;
		// Iterator itor = valueMap.keySet().iterator();
		// while (itor.hasNext()) {
		// String stsId = (String) itor.next();
		// String stsWord = (String) valueMap.get(stsId);
		// LabelValueBean lvBean = new LabelValueBean();
		// lvBean.setLabel(stsWord);
		// lvBean.setValue(stsId);
		// statusList.add(lvBean);
		// }
		List statusList = new ArrayList();
		try {
			Map statusMap = BizConfig.getStatusHashMap(tableName, columnName);
			statusList = getlvBean(statusMap);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statusList;
	}

	/**
	 * ���ܣ����ݱ������ֶ�����status����ȡ��ֵ
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public static Map getStatusMap(String tableName, String columnName)
			throws SysException, AppException {
		Map map = new HashMap();
		try {
			map = BizConfig.getStatusHashMap(tableName, columnName);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * ����map���LabelValueBean��list
	 * 
	 * @param labelValueMap
	 *            <id,label>
	 * @return
	 */
	public static List getlvBean(Map labelValueMap) {
		List lvBeans = new ArrayList();
		if (labelValueMap == null)
			return lvBeans;
		LabelValueBean lvBean = null;
		Iterator itor = labelValueMap.keySet().iterator();
		while (itor.hasNext()) {
			lvBean = new LabelValueBean();
			String id = (String) itor.next();
			String label = (String) labelValueMap.get(id);
			lvBean.setLabel(label);
			lvBean.setValue(id);
			lvBeans.add(lvBean);
		}

		return lvBeans;
	}
	

	public static List getSurveyResultlvBean() throws SysException,
			AppException {
		List list = getStatuslvBean("WO_ITEM", "STS");
		return list;
	}
	
	
	/**
	 * ʩ������ģ��(status��STEP/WORK_MODE)
	 * 
	 * ʩ����ʽ WORK_MODE A �Զ�ʩ�� M �˹�ʩ��
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 */
	public static List getWorkModeNoAMlvBean() throws SysException,
			AppException {
		List list = getStatuslvBean("STEP_CONFIG", "WORK_MODE");
		List ret = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			LabelValueBean lvBean = (LabelValueBean) list.get(i);
			if (!lvBean.getValue()
					.equals(SysConstants.WO_WORK_MODE_AUTO_MANUAL)) {
				ret.add(lvBean);
			}
		}
		return ret;
	}

	/**
	 * ʩ������ģ��(status��WORK_AREA/WORK_MODE)
	 * 
	 * ʩ����ʽ WORK_MODE A �Զ�ʩ�� M �˹�ʩ��
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 */
	public static List getWorkModeNoAMlvBean(String workMode)
			throws SysException, AppException {
		List list = getStatuslvBean("STEP_CONFIG", "WORK_MODE");
		List ret = new ArrayList();
		// ������˹��Զ�
		if (workMode.equals(SysConstants.WO_WORK_MODE_AUTO_MANUAL)) {
			return getWorkModeNoAMlvBean();
		} else {
			for (int i = 0; i < list.size(); i++) {
				LabelValueBean lvBean = (LabelValueBean) list.get(i);
				if (lvBean.getValue().equals(workMode)) {
					ret.add(lvBean);
					break;
				}
			}
		}
		return ret;
	}


}