package com.cattsoft.sm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

/**
 * Title: CRM <br>
 * Description: ϵͳstruts����<br>
 * Date: 2007-8-11 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class StrutsUtil {

	public StrutsUtil() {

	}

	/**
	 * <pre>
	 * ����vo����ƴ��struts��LabelValueBean���ϣ���ҳ���select��ǩʹ�á�
	 * �õ���LabelValueBean���ϰ���new LabelValueBean(&quot;ȫ��&quot;, &quot;-1&quot;)����ѯʱ���ܸ���ʹ�á�
	 * </pre>
	 * 
	 * @param vos
	 *            List
	 * @param labelFld
	 *            String
	 * @param valFld
	 *            String
	 * @throws ReflectUtilException
	 * @return List
	 */
	public static List getSelIncAll(List vos, String labelFld, String valFld)
			throws Exception {
		List retLst = getSel(vos, labelFld, valFld);
		retLst.add(0, new LabelValueBean("ȫ��", "-1"));
		return retLst;
	}

	/**
	 * <pre>
	 * ����vo����ƴ��struts��LabelValueBean���ϣ���ҳ���select��ǩʹ�á�
	 * �õ���LabelValueBean���ϲ�����new LabelValueBean(&quot;ȫ��&quot;, &quot;-1&quot;)�����ӡ��޸�ʱ���ܸ���ʹ�á�
	 * ���磺
	 *     List provinceVOs=SMRegionDelegate.getDelegate().findProvs(new ProvinceVO());
	 *      form.setProvSel(StrutsUtil.getSelIncAll(provinceVOs,&quot;name&quot;,&quot;provId&quot;));
	 *      ���У�formΪSMProvinceActionForm��provinceVOsΪProvinceVO����
	 *      nameΪProvinceVO�����ԣ������Խ���Ϊselect��ǩ��label����
	 *      provIdΪProvinceVO�����ԣ������Խ���Ϊselect��ǩ��value����
	 *      ��ҳ���У�
	 *      &lt; html:select property=&quot;provId&quot; size=&quot;1&quot; &gt;
	 *      &lt; html:optionsCollection property=&quot;provSel&quot;  label=&quot;label&quot; value=&quot;value&quot; /&gt;
	 *      &lt; /html:select &gt;
	 *      ����ɲο�sm�µĳ���
	 * 
	 * </pre>
	 * 
	 * @param vos
	 *            List
	 * @param labelFld
	 *            String
	 * @param valFld
	 *            String
	 * @throws ReflectUtilException
	 * @return List
	 */
	public static List getSel(List vos, String labelFld, String valFld)
			throws Exception {
		List retLst = new ArrayList();
		LabelValueBean option = null;
		Object obj = null;
		Object lbl = null;
		Object val = null;

		// add by zhangshuaia 2013-09-17
		if (!"0".equals(vos) && vos != null) {
			option = new LabelValueBean();
			option.setLabel("��ѡ��...");
			option.setValue("0");
			retLst.add(option);
		}

		if (vos != null) {
			for (int i = 0; i < vos.size(); i++) {
				obj = vos.get(i);
				ReflectUtil l;
				lbl = ReflectUtil.invokeMethod(obj, ReflectUtil
						.getMethodNameByFldName(labelFld));
				val = ReflectUtil.invokeMethod(obj, ReflectUtil
						.getMethodNameByFldName(valFld));
				option = new LabelValueBean(lbl.toString(), val.toString());
				retLst.add(option);
			}
		}
		return retLst;

	}

	public static List getHourSel() {
		List retLst = new ArrayList();
		LabelValueBean option = null;
		for (int i = 0; i < 24; i++) {
			if (i < 10) {
				option = new LabelValueBean("0" + String.valueOf(i), "0"
						+ String.valueOf(i));
			} else
				option = new LabelValueBean(String.valueOf(i), String
						.valueOf(i));
			retLst.add(option);
		}
		return retLst;

	}

	public static List getMinSel() {
		List retLst = new ArrayList();
		LabelValueBean option = null;
		for (int i = 0; i < 61; i++) {
			if (i < 10) {
				option = new LabelValueBean("0" + String.valueOf(i), "0"
						+ String.valueOf(i));
			} else
				option = new LabelValueBean(String.valueOf(i), String
						.valueOf(i));
			retLst.add(option);
		}
		return retLst;

	}

	public static List getSecSel() {
		List retLst = new ArrayList();
		LabelValueBean option = null;
		for (int i = 0; i < 61; i++) {
			if (i < 10) {
				option = new LabelValueBean("0" + String.valueOf(i), "0"
						+ String.valueOf(i));
			} else
				option = new LabelValueBean(String.valueOf(i), String
						.valueOf(i));
			retLst.add(option);
		}
		return retLst;
	}

}
