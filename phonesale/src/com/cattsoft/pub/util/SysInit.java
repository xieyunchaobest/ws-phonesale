package com.cattsoft.pub.util;

import java.util.HashMap;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * <p>
 * Title: ��ʼ������������
 * </p>
 * <p>
 * Description: ϵͳ���õ��ĳ�ʼ�����������ڱ����С�
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: CATTSoft
 * </p>
 * 
 * @author wangyun
 * @version 1.0
 */

public abstract class SysInit {
	public final static String WEB_CONTEXT = "webContext";

	public final static String DBMAIN = "dbmain";

	public final static String DBTYPE = "dbtype";

	public final static String IF_INS_NEW_HREF = "ifInsNewHref";

	public final static String OS_TYPE = "osType";

	public final static String USE_HREF_AUTH = "useHrefAuth";

	public final static String STARTUP_SYM = "startupSym";

	public final static String IS_EJB_LOCAL = "ejblocal";

	public final static String EJB_LOCAL = "1";

	public final static String EJB_REMOTE = "0";

	// 2005-7-10 mjh ��֯��������ģʽ��A:���������ָL:���㼶��������Ϊ��ǰԱ������֯��L���ںӱ��ͻ��ط��õ���
	public final static String ORG_MNG_MODE = "orgMngMode";

	private static HashMap hm;

	public static boolean isNull() {
		if (hm == null)
			return true;
		return false;
	}

	/**
	 * �õ������ʵ��������ģʽ��
	 */
	public static void instance() {
		if (hm != null)
			return;
		hm = new HashMap();
		hm.put(WEB_CONTEXT, "/web");
		// ejblocal������ʾϵͳ��ʹ��local�ӿڵ���ejb����remote�ӿڵ��á�
		// hm.put(WEB_CONTEXT, "");
		String isEjbRemote  = EJB_REMOTE;
		try {
			isEjbRemote = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_IS_EJB_REMOTE, null, null, null, null, null);
			if("".equals(isEjbRemote)||null==isEjbRemote){
				isEjbRemote  = EJB_REMOTE;
			}
		} catch (SysException e) {
			e.printStackTrace();
		}
		hm.put(IS_EJB_LOCAL, isEjbRemote); // 0 is flase;
		hm.put("dbmain", "ds/hbsps");
		hm.put("dbtype", "oracle");
	}

	/**
	 * �õ������ʵ��������ģʽ��
	 */
	public static void instance(HashMap hm1) {
		if (hm1 == null)
			return;
		hm = hm1;
	}

	/**
	 * ���ݴ����ȡ�ô�����Ϣ
	 * 
	 * @param errId
	 *            String �����
	 * @return String ������Ϣ
	 */
	public static String getRef(String refId) {
		if (hm == null)
			return "ϵͳ��������δ��ʼ����";
		String str = (String) hm.get(refId);
		if (str == null) {

			return "��������Ϊ�գ�";

		}
		return str;
	}
}
