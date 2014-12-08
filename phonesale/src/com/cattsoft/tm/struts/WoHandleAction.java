package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.alibaba.fastjson.JSON;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.CollectionUtil;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.IntegerUtil;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.sm.vo.StaffWorkAreaMVO;
import com.cattsoft.sm.vo.SysUserExtendedMVO;
import com.cattsoft.sp.vo.StepFailReasonSVO;
import com.cattsoft.tm.delegate.StatiscalReportDelegate;
import com.cattsoft.tm.delegate.WoHandleDelegate;
import com.cattsoft.tm.delegate.WoQueryDelegate;
import com.cattsoft.tm.delegate.WoResponseDelegate;
import com.cattsoft.tm.vo.AdvQueryMVO;
import com.cattsoft.tm.vo.WoMVO;
import com.cattsoft.tm.vo.WoSVO;
import com.cattsoft.webpub.util.ReqUtil;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: ʩ������<br>
 * Date: 2007-6-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author ��С��
 */

public class WoHandleAction extends DispatchAction {
	private static final Logger log = Logger.getLogger(WoHandleAction.class);

	/**
	 * MOS Native ������ȡ�еĹ����б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward searchWO4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		JSONObject requestJsonObject = JSONObject.fromObject(ReqUtil.getRequestStr(request));
		// ��װ��Ҫ�Ĳ�ѯ����
		JSONObject queryVoJsonObject = new JSONObject();
		log.info("responseJson----------info"+requestJsonObject);
		log.debug("responseJson----------debug"+requestJsonObject);
		
		PagInfo pagInfo = new PagInfo();

		if (requestJsonObject != null
				&& !StringUtil.isBlank(requestJsonObject.getString("staffId"))) {
			queryVoJsonObject.put("staffId", requestJsonObject
					.getString("staffId"));
		} else {
			throw new AppException("500002", "�ỰʧЧ���ߵ�ǰ��¼���û����Ϸ�");
		}

		String pageCode = "WoFetchUnBook";
		String workAreaId = requestJsonObject.getString("workAreaId");
		String businessId = null;
		String actTypeList = null;
		String alarmSts = null;

		if (requestJsonObject.has("businessId")) {
			businessId = requestJsonObject.getString("businessId");
		}
		if (requestJsonObject.has("actTypeList")) {
			actTypeList = requestJsonObject.getString("actTypeList");
		}
		if (requestJsonObject.has("alarmSts")) {
			alarmSts = requestJsonObject.getString("alarmSts");
		}

		String localNetId = requestJsonObject.getString("localNetId");
		String areaId = requestJsonObject.getString("areaId");
		log.debug("Ŀǰ����Ϊ��" + workAreaId + ";pageCode:" + pageCode);

		if (StringUtil.isBlank(workAreaId)) {
			throw new AppException("500002", "ϵͳ�Ҳ����û���Ӧ�Ĺ�����Ϣ��");
		}
		queryVoJsonObject.put("localNetId", localNetId);
		queryVoJsonObject.put("areaId", areaId);
		queryVoJsonObject.put("chbWorkAreaId", SysConstants.YES);
		queryVoJsonObject.put("workAreaId", workAreaId);
		queryVoJsonObject.put("pageCode", pageCode);
		queryVoJsonObject.put("businessId", businessId);
		queryVoJsonObject.put("actTypeList", actTypeList);
		queryVoJsonObject.put("alarmSts", alarmSts);

		String culmName = null;
		if (requestJsonObject.has("culmName")
				&& !StringUtil.isBlank(requestJsonObject.getString("culmName"))) {
			culmName = requestJsonObject.getString("culmName");
		} else {
			culmName = SysConstants.COLUMN_SEQ;// ������������
		}
		int pagNo = -1;
		if (!StringUtil.isBlank(requestJsonObject.getString("pageNo"))) {
			String pageNo = requestJsonObject.getString("pageNo");
			pagNo = IntegerUtil.parse(pageNo);
		}
		pagInfo = PagUtil.getPagInfo(pagNo, 20);

		JSONObject pagInfoJsonObject = new JSONObject();

		pagInfoJsonObject.put("count", new Integer(pagInfo.getCount()));
		pagInfoJsonObject.put("pagSize", new Integer(pagInfo.getPagSize()));
		pagInfoJsonObject.put("pagNo", new Integer(pagInfo.getPagNo()));
		pagInfoJsonObject.put("pagCount", new Integer(pagInfo.getPagCount()));
		pagInfoJsonObject.put("rowLimit", new Integer(pagInfo.getRowLimit()));
		// ��װ������һ����Ĳ���
		JSONObject prameterJsonObject = new JSONObject();
		prameterJsonObject.put("queryVo", queryVoJsonObject);
		prameterJsonObject.put("pagInfo", pagInfoJsonObject);
		prameterJsonObject.put("culmName", culmName);

		String responseJson = WoHandleDelegate.getDelegate().query4MOS(
				prameterJsonObject.toString());
//		String responseJson =SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_FETWO_STRING, null, null, null, null, null);
		log.info("responseJson----------more"+responseJson);
		log.debug("responseJson----------more"+responseJson);

		// ��ʼ�������ݣ���δ����
		JSONObject responseJsonObject = JSONObject.fromObject(responseJson);
		String resultViewListJson = responseJsonObject.getJSONArray("viewList")
				.toString();
		if ("[]".equals(resultViewListJson)
				|| StringUtil.isBlank(resultViewListJson)
				|| StringUtil.isBlank(responseJson)) {
			responseJson = StringUtil.getAppException4MOS("û����Ҫ����Ĺ�����");
		}
		ReqUtil.write(response, responseJson);
		return null;
	}

	
	
	
	
	/**
	 * �쵥 FOR MOS -ANDROID
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	/*
	 * public ActionForward fetchWo4MOS(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * AppException, SysException, IOException { JSONObject
	 * requestJsonObject=JSONObject.fromObject(getJSON(request)); String
	 * woNbrAry[]=requestJsonObject.getString("woNbrAry").split(" ; "); String
	 * woStaffId = requestJsonObject.getString("staffId"); if (woNbrAry == null)
	 * throw new AppException("2000001", "��ѡ��Ҫ�ص��Ĺ�����");
	 * 
	 * �����������ŵõ���شӵ����ţ������ӵ��ϵ��쵥
	 * 
	 * List woNbrList = new ArrayList(); for (int i = 0; i < woNbrAry.length;
	 * i++) { WoSVO woSVO = new WoSVO(); woSVO.setWoNbr(woNbrAry[i]);
	 * woNbrList.add(woSVO); } // �����쵥 List failWoMsg =
	 * WoHandleDelegate.getDelegate().fetchBatWo4MOS(woNbrList, woStaffId);
	 * //������δ�� String failMsg = ""; if (failWoMsg.size() > 0) { failMsg =
	 * CollectionUtil.toString(failWoMsg, ";"); failMsg = "�쵥ʧ�ܣ�" + failMsg;
	 * log.warn(failMsg); request.setAttribute("failMsg", failMsg); // throw new
	 * AppException("2000002",failMsg); } else { failMsg = "�ɹ��쵥��"; }
	 * 
	 * // ��XMLд��response. response.setContentType("text/xml;charset=UTF-8"); try
	 * { response.getWriter().write(failMsg); } catch (IOException e) {
	 * log.error(e.getMessage()); throw new SysException("500002",
	 * "responseд�����", e); }
	 * 
	 * return null; }
	 */

	/**
	 * ת�ɴ���
	 * 
	 * @throws IOException
	 */
	public ActionForward woSendTo4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		String infoJsonString = ReqUtil.getRequestStr(request);// ���ǰ̨���͵��û���Ϣ��������ID������ID��ת��ԭ��ID����ע�͹�����
		com.alibaba.fastjson.JSONObject infoJsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(infoJsonString);
		com.alibaba.fastjson.JSONObject userInfoJson = (com.alibaba.fastjson.JSONObject) infoJsonObject
				.get("userInfo");// ~{5C5=SC;'PEO"~}
		SysUserExtendedMVO suve = com.alibaba.fastjson.JSON.parseObject(
				userInfoJson.toString(), SysUserExtendedMVO.class);
		String wonbr = (String) infoJsonObject.get("workOrderNum");
		String remarks = (String) infoJsonObject.get("remark");
		if (suve == null) {
			throw new AppException("50000001", "ϵͳ�Ҳ�����½Ա����Ϣ��");
		}
		String woStaffId = suve.getStaffExtendMVO().getStaffSVO().getStaffId();

		try {
			remarks = java.net.URLDecoder.decode(remarks, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String workAreaStaffId = (String) infoJsonObject.get("workStaffId");
		String failReasonId = (String) infoJsonObject.get("changeCauseId");
		String localNetId = (String) infoJsonObject.get("localNetId");
		String workAreaId = (String) infoJsonObject.get("workAreaId");

		WoSVO woSVO = new WoSVO();
		// woSVO.setAreaId(areaId);
		woSVO.setLocalNetId(localNetId);
		woSVO.setWoNbr(wonbr);
		woSVO.setWorkAreaId(workAreaId);
		woSVO.setRemarks(remarks);
		// ʩ����Ա
		woSVO.setRtStaffId(workAreaStaffId);
		// ������Ա
		woSVO.setWoStaffId(woStaffId);
		woSVO.setFailReasonId(failReasonId);
		String woSVOJson = com.alibaba.fastjson.JSONObject.toJSONString(woSVO);
		try {
			com.cattsoft.tm.delegate.WoHandleDelegate.getDelegate().sendTo4MOS(
					woSVOJson);
		} catch (Exception e) {
			String s = "ת�ɳ���";
			JSONArray jsonArray = JSONArray.fromObject(s);// ���õ����ַ���ת��JSONArray
			System.out.println("JSON========" + jsonArray);
			ReqUtil.write(rep,jsonArray.toString());
		}
		return null;
	}

	/**
	 * ���Ͷ���
	 */
	public ActionForward sendMsg4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		String jsonString = getJSON(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		String woNbr = (String) jsonObjectRequest.get("woNbr");
		String contacInfo = (String) jsonObjectRequest.get("contacInfo");
		String localNetId = (String) jsonObjectRequest.get("localNetId");
		String areaId = (String) jsonObjectRequest.get("areaId");
		String notifyTypeId = SysConstants.NOTIFY_TYPE_SM;
		String notifyConfigId = SysConstants.NOTIFY_CONFIG_ID;
		// ���п���Ϊ��,ȥ��ö�������ʱҪ�������
		String woNbrAryStr = woNbr;
		String msgMatchId = SysConstants.MSG_MATCH_ID;
		// �¼�����
		String msgEventType = SysConstants.MSG_EVENT_TYPE_MOS;
		String msgContent = "";
		String notifyNbr = contacInfo;// ��ϵ����
		JSONObject json = new JSONObject();
		json.put("toNbr", woNbrAryStr);
		json.put("notifyNbr", contacInfo);
		json.put("localNetId", localNetId);
		json.put("areaId", areaId);
		json.put("notifyTypeId", notifyTypeId);
		json.put("msgContent", msgContent);
		json.put("notifyConfigId", notifyConfigId.split(",")[0]);
		json.put("msgEventType", msgEventType);
		json.put("toObjectType", SysConstants.OBJECT_TYPE_STAFF);
		json.put("toObjectId", "0");
		json.put("fromObjectType", SysConstants.FROM_OBJECT_TYPE_SYSTEM);
		json.put("fromObjectId", "");
		json.put("msgMatchId", msgMatchId);
		json.put("EventType", msgEventType);

		String resultStr = WoHandleDelegate.getDelegate().sendMsg4MOS(
				json.toString());
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		return null;
	}

	// ��
	public ActionForward queryReport4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		String jsonString = getJSON(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		String woStaffId = (String) jsonObjectRequest.get("woStaffId");
		String localNetId = (String) jsonObjectRequest.get("localNetId");
		String areaId = (String) jsonObjectRequest.get("areaId");
		String reportflag = (String) jsonObjectRequest.get("reportflag");
		JSONObject json = new JSONObject();
		json.put("woStaffId", woStaffId);
		json.put("localNetId", localNetId);
		json.put("areaId", areaId);
		json.put("reportflag", reportflag);
		String resultStr = StatiscalReportDelegate.getDelegate()
				.queryReport4MOS(json.toString());
		byte[] jsonBytes;
		try {
			// �п��ܲ�����
			jsonBytes = resultStr.getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ���̲�ѯ4MOS
	 */
	public ActionForward queryProcess4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		log.debug("�����ʼ��������ϸ��ϢqueryProcess4MOS����!");
		// ��request ��ȡ��json������,�Ӷ��������
		String jsonString = ReqUtil.getRequestStr(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		String accNbr = (String) jsonObjectRequest.get("businessnum");
		String extSoNbr = (String) jsonObjectRequest.get("wonum");

		JSONObject json = new JSONObject();
		json.put("accNbr", accNbr);
		json.put("extSoNbr", extSoNbr);
		String resultStr = WoHandleDelegate.getDelegate().queryProcess4MOS(
				json.toString());

		if ("[]".equals(resultStr) || StringUtil.isBlank(resultStr)) {
			resultStr = StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
		}
		if (resultStr.contains("Exception")) {
			resultStr = StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
		}
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		byte[] jsonBytes;
		
			// �п��ܲ�����
			ReqUtil.write(response, resultStr);
		return null;
	}

	/*
	 * ��ϸ�б�4MOS
	 */
	public ActionForward initWoDetail4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		log.debug("�����ʼ��������ϸ��ϢinitWoDetail4MOS����!");
		// ��request ��ȡ��json������,�Ӷ��������
		String jsonString = ReqUtil.getRequestStr(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		String woNbr = (String) jsonObjectRequest.get("woNbr");
		String localNetId = (String) jsonObjectRequest.get("localNetId");

		// String woNbr = request.getParameter("woNbr");
		JSONObject json = new JSONObject();
		json.put("woNbr", woNbr);
		json.put("localNetId", localNetId);
		String resultStr = WoHandleDelegate.getDelegate().initWoDetail4MOS(
				json.toString());
		ReqUtil.write(response, resultStr);
		return null;
	}

	/**
	 * ���Androidǰ̨ҳ�汾������ʼ���������б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward woChangeLocalNet4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		String infoJsonString = ReqUtil.getRequestStr(request);
		// JSONObject infoJsonObject = JSONObject.fromObject(infoJsonString);
		com.alibaba.fastjson.JSONObject infoJsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(infoJsonString);
		// ���ǰ̨���û���Ϣ
		// SysUserExtendedMVO userInfo =
		// com.alibaba.fastjson.JSON.parseObject(infoJsonString,SysUserExtendedMVO.class);
		com.alibaba.fastjson.JSONObject userInfoJson = (com.alibaba.fastjson.JSONObject) infoJsonObject
				.get("userInfo");
		// String workOrderNum = (String) infoJsonObject.get("workOrderNum");
		// ��ñ������б��ַ���
		String changLocalNet = com.cattsoft.tm.delegate.WoHandleDelegate
				.getDelegate().getChangeLocalNet4MOS(userInfoJson.toString());
		// ���������б��ַ���ת����json�ַ������͵�ǰ̨
		JSONArray jsonArray = JSONArray.fromObject(changLocalNet);// ���õ����ַ���ת��JSONArray
		System.out.println("JSON========" + jsonArray);
		ReqUtil.write(rep, jsonArray.toString());
		return null;
	}

	/**
	 * Androidǰ̨ҳ����ݱ�������ʾ�����ݣ���ʼ�������б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward woChangeWorkArea4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		String infoJsonString = ReqUtil.getRequestStr(request);// �õ�ǰ̨���͵Ĺ����źͱ�����ID
		com.alibaba.fastjson.JSONObject infoJsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(infoJsonString);
		String woNbr = (String) infoJsonObject.get("workOrderNum");
		String localNetId = (String) infoJsonObject.get("localNetId");
		WoSVO woVo = new WoSVO();
		woVo.setWoNbr(woNbr);
		List woList = new ArrayList();
		woList.add(woVo);
		Map paraMap = new HashMap();
		paraMap.put(SysConstants.PARA_MAP_WO_LIST, woList);
		String woListString = JSON.toJSONString(woList);
		String workAreaTypeMapString = com.cattsoft.tm.delegate.WoHandleDelegate
				.getDelegate().initSendTo4MOS(woListString);// ��Ҫ�ǵõ�workAreaTypeID
		Map initMap = (Map) JSON.parse(workAreaTypeMapString);
		List wolist = (List) initMap.get("woList");
		String workAreaTypeId = (String) initMap.get("workAreaTypeId");
		com.alibaba.fastjson.JSONObject infoJsonObject1 = new com.alibaba.fastjson.JSONObject();
		infoJsonObject1.put("workAreaTypeId", workAreaTypeId);
		infoJsonObject1.put("localNetId", localNetId);
		// ���ݱ�����ID��ù����б��ַ���
		String changLocalNet = com.cattsoft.tm.delegate.WoHandleDelegate
				.getDelegate()
				.getChangeWorkArea4MOS(infoJsonObject1.toString());
		// ���������б��ַ���ת����json�ַ������͵�ǰ̨
		JSONArray jsonArray = JSONArray.fromObject(changLocalNet);// ���õ����ַ���ת��JSONArray
		System.out.println("JSON========" + jsonArray);
		ReqUtil.write(rep, jsonArray.toString());
		return null;
	}

	/**
	 * ���ת��ԭ��
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward woChangeCause4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		StepFailReasonSVO failreasonsvo = new StepFailReasonSVO();
		String failreasonsvoJson = com.alibaba.fastjson.JSONObject
				.toJSONString(failreasonsvo);
		String failReasonIdListJson = WoHandleDelegate.getDelegate()
				.findfailReasonName4MOS(failreasonsvoJson);
		System.out.println("JSON========" + failReasonIdListJson);
		ReqUtil.write(rep, failReasonIdListJson.toString());
		return null;
	}

	/**
	 * ���ʩ����Ա�б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward getWorkStaff4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		String infoJsonString = ReqUtil.getRequestStr(request);// �õ�ǰ̨���Ĺ���ID
		com.alibaba.fastjson.JSONObject infoJsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(infoJsonString);
		String workAreaId = (String) infoJsonObject.get("workAreaId");
		StaffWorkAreaMVO quryVO = new StaffWorkAreaMVO();
		quryVO.setWorkAreaId(workAreaId);
		String quryVOJson = com.alibaba.fastjson.JSONObject
				.toJSONString(quryVO);
		// List staffList = OptionUtil.getStafflvBean(quryVO);
		String staffListString = WoHandleDelegate.getDelegate()
				.getWorkStaff4MOS(quryVOJson);
		ReqUtil.write(rep, staffListString.toString());
		return null;
	}

	/**
	 * MOS Native ���������еĹ����б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @author maxun CreateTime 2012-8-30 ����2:58:33
	 */
	public ActionForward initWo4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		WoHandleForm woHandleForm = (WoHandleForm) actionForm;
		JSONObject requestJsonObject = JSONObject.fromObject(ReqUtil.getRequestStr(request));
		AdvQueryMVO queryVo = new AdvQueryMVO();
		JSONObject queryVoJsonObject = new JSONObject();
		int lastsize = 0;
		PagInfo pagInfo = new PagInfo();

		if (requestJsonObject != null
				&& !StringUtil.isBlank(requestJsonObject.getString("staffId"))) {
			queryVoJsonObject.put("staffId", requestJsonObject
					.getString("staffId"));
		} else {
			throw new AppException("500002", "�ỰʧЧ���ߵ�ǰ��¼���û����Ϸ�");
		}

		String pageCode = "woSearch";
		String workAreaId = requestJsonObject.getString("workAreaId");
		// String workMode=requestJsonObject.getString("workMode");
		String businessId = null;
		String actTypeList = null;
		String alarmSts = null;
		if (requestJsonObject.has("businessId")) {
			businessId = requestJsonObject.getString("businessId");
		}
		if (requestJsonObject.has("actTypeList")) {
			actTypeList = requestJsonObject.getString("actTypeList");
		}
		if (requestJsonObject.has("alarmSts")) {
			alarmSts = requestJsonObject.getString("alarmSts");
		}

		// if (workMode.equals(SysConstants.WO_WORK_MODE_AUTO)) {//
		// ������Զ�������������ѯ������0����
		// throw new AppException("", "����Ϊ�Զ���������ѯʧ�ܣ�");
		// }
		String localNetId = requestJsonObject.getString("localNetId");
		String areaId = requestJsonObject.getString("areaId");
		log.debug("Ŀǰ����Ϊ��" + workAreaId + ";pageCode:" + pageCode);
		if (StringUtil.isBlank(workAreaId)) {
			throw new AppException("500002", "ϵͳ�Ҳ����û���Ӧ�Ĺ�����Ϣ��");
		}
		queryVoJsonObject.put("localNetId", localNetId);
		queryVoJsonObject.put("areaId", areaId);
		queryVoJsonObject.put("chbWorkAreaId", SysConstants.YES);
		queryVoJsonObject.put("workAreaId", workAreaId);
		queryVoJsonObject.put("pageCode", pageCode);
		queryVoJsonObject.put("businessId", businessId);
		queryVoJsonObject.put("actTypeList", actTypeList);
		queryVoJsonObject.put("alarmSts", alarmSts);

		String culmName = null;
		if (requestJsonObject.has("culmName")
				&& !StringUtil.isBlank(requestJsonObject.getString("culmName"))) {
			culmName = requestJsonObject.getString("culmName");
		} else {
			culmName = SysConstants.COLUMN_SEQ;// ������������
		}
		int pagNo = -1;
		if (!StringUtil.isBlank(requestJsonObject.getString("pageNo"))) {
			String pageNo = requestJsonObject.getString("pageNo");
			pagNo = IntegerUtil.parse(pageNo);
		}
		pagInfo = PagUtil.getPagInfo(pagNo, 20);
		JSONObject pagInfoJsonObject = new JSONObject();
		pagInfoJsonObject.put("count", new Integer(pagInfo.getCount()));
		pagInfoJsonObject.put("pagSize", new Integer(pagInfo.getPagSize()));
		pagInfoJsonObject.put("pagNo", new Integer(pagInfo.getPagNo()));
		pagInfoJsonObject.put("pagCount", new Integer(pagInfo.getPagCount()));
		pagInfoJsonObject.put("rowLimit", new Integer(pagInfo.getRowLimit()));
		JSONObject prameterJsonObject = new JSONObject();
		prameterJsonObject.put("queryVo", queryVoJsonObject);
		prameterJsonObject.put("pagInfo", pagInfoJsonObject);
		prameterJsonObject.put("culmName", culmName);
		String responseJson = WoHandleDelegate.getDelegate().initWoLists4MOS(
				prameterJsonObject.toString());
		JSONObject responseJsonObject = JSONObject.fromObject(responseJson);
		String resultViewListJson = responseJsonObject.getJSONArray("viewList")
				.toString();
		if ("[]".equals(resultViewListJson)
				|| StringUtil.isBlank(resultViewListJson)
				|| StringUtil.isBlank(responseJson)) {
			// throw new AppException("", "û����Ҫ����Ĺ�����");
			responseJson = StringUtil.getAppException4MOS("û����Ҫ����Ĺ�����");
		}
		if (responseJson != null) {
		ReqUtil.write(response, responseJson);
		}
		return null;
	}
	
	
	
	
	
	/**
	 * ����woSearchList�����޸ĺ󷽷�������������ά������ѯ,add by xyc,20120703
	 * 
	 * @throws Exception
	 */
	public ActionForward woSearchList4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��request ��ȡ��json������,�Ӷ��������
		String jsonString = ReqUtil.getRequestStr(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);

		// �Ѷ���ת����Ϊjson�ַ���
		JSONObject json = new JSONObject();
		// String flagnum = request.getParameter("flagnum");
		String flagnum = (String) jsonObjectRequest.get("flagnum");

		if (flagnum != null && !"".equals(flagnum.trim())) {

			if ("basicquery".equals(flagnum)) {
				// ������
				// String woNbr = request.getParameter("workordernum");
				String woNbr = (String) jsonObjectRequest.get("workordernum");
				if (woNbr != null && !"".equals(woNbr.trim())) {
					json.put("chbWoId", SysConstants.YES);
					json.put("woNbr", woNbr);
					json.put("woId", woNbr);
				}
				// ҵ���
				// String accNbr = request.getParameter("businessnum");
				String accNbr = (String) jsonObjectRequest.get("businessnum");

				if (accNbr != null && !"".equals(accNbr.trim())) {
					json.put("chbAccNbr", SysConstants.YES);
					json.put("accNbr", accNbr);
				}

			} else {

				// ������
				// String woNbr = request.getParameter("workordernum");
				String woNbr = (String) jsonObjectRequest.get("workordernum");
				if (woNbr != null && !"".equals(woNbr.trim())) {
					json.put("chbWoId", SysConstants.YES);
					json.put("woNbr", woNbr);
					json.put("woId", woNbr);
				}
				// ҵ���
				// String accNbr = request.getParameter("businessnum");
				String accNbr = (String) jsonObjectRequest.get("businessnum");
				if (accNbr != null && !"".equals(accNbr.trim())) {

					json.put("accNbr", accNbr);
					json.put("chbAccNbr", SysConstants.YES);

				}
				// �����
				// String phyAccNbr=request.getParameter("prscnum");
				String phyAccNbr = (String) jsonObjectRequest.get("prscnum");
				if (phyAccNbr != null && !"".equals(phyAccNbr.trim())) {
					json.put("phyAccNbr", phyAccNbr);
				}

				// �ͻ�����
				// String custName=request.getParameter("cusnamenum");
				String custName = (String) jsonObjectRequest.get("cusnamenum");
				if (custName != null && !"".equals(custName.trim())) {
					json.put("custName", custName);
				}
				// ������
				// String soNbr=request.getParameter("innerwoenum");
				String soNbr = (String) jsonObjectRequest.get("innerwoenum");
				if (soNbr != null && !"".equals(soNbr.trim())) {
					json.put("soNbr", soNbr);
				}
				// �ⲿ����
				// String extSoNbr=request.getParameter("wonum");
				String extSoNbr = (String) jsonObjectRequest.get("wonum");
				if (extSoNbr != null && !"".equals(extSoNbr.trim())) {
					json.put("extSoNbr", extSoNbr);
				}
			}
		}

		json.put("pageCode", "woSearch");
		json.put("chbWorkAreaId", SysConstants.YES);
		request.setAttribute("pageCode", "woSearch");

		// ������������
		json.put("culmName", SysConstants.COLUMN_SEQ);
		int pagNo = -1;
		PagInfo pagInfo = new PagInfo();

		if ("search".equals(request.getParameter("searchtype"))) {
			pagInfo = PagUtil.getPagInfo(pagNo, SysConstants.DEFAULT_PAGE_SIZE);
		} else {
			if ((Integer) jsonObjectRequest.get("pageNo") == null) {
				pagNo = 1;
			} else {
				pagNo = (Integer) jsonObjectRequest.get("pageNo");
			}
			json.put("pagNo", pagNo);
			json.put("pagsize", 20);
		}
		String jsonresult = WoHandleDelegate.getDelegate().initWoList4MOS(
				json.toString());
		if ("[]".equals(jsonresult) || StringUtil.isBlank(jsonresult)) {
			jsonresult = StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
		}

		if (jsonresult.contains("Exception")) {
			jsonresult = StringUtil.getAppException4MOS("��ѯ���Ϊ��!");
		}

		ReqUtil.write(response, jsonresult);
		return null;

	}

	/**
	 * �쵥 FOR MOS -ANDROID
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward fetchWo4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String jsonStr = ReqUtil.getRequestStr(request);
		JSONObject requestJsonObject = JSONObject.fromObject(jsonStr);
		String woNbrAry[] = requestJsonObject.getString("woNbrAry")
				.split(" ; ");
		// String woStaffId = requestJsonObject.getString("staffId");
		if (StringUtil.isBlank(requestJsonObject.getString("woNbrAry")))
			throw new AppException("2000001", "��ѡ��Ҫ�ص��Ĺ�����");

		// �����쵥
		String failWoMsg = WoHandleDelegate.getDelegate().fetchBatWo4MOS(
				jsonStr);
		String failMsg = "";
		List failWoMsgList = new ArrayList();
		if (!StringUtil.isBlank(failWoMsg) && !failWoMsg.equals("[]")) {
			failWoMsgList = JSONArray.fromObject(failWoMsg);
		}
		if (failWoMsgList.size() > 0) {
			failMsg = CollectionUtil.toString(failWoMsgList, ";");
			failMsg = "�쵥ʧ�ܣ�" + failMsg;
			log.warn(failMsg);
			request.setAttribute("failMsg", failMsg);
			// throw new AppException("2000002",failMsg);
		} else {
			failMsg = "�ɹ��쵥!";
		}

		JSONObject responseJson = new JSONObject();
		responseJson.put("failMsg", failMsg);
		if (responseJson != null) {
			ReqUtil.write(response, responseJson.toString());
		}

		return null;
	}

	/**
	 * �ص���ʼ��
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward woReturnInit4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {

		Map toMosMap = new HashMap();
		String paraStr = ReqUtil.getRequestStr(request);
		JSONObject paraMap = JSONObject.fromObject(paraStr);
		String woNbr = paraMap.getString("woNbr");

		List woList = new ArrayList();
		if (StringUtil.isBlank(woNbr))
			throw new AppException("2000001", "��ѡ��ص��Ĺ�����");
		String workAreaId = paraMap.getString("workAreaId");
		String workAreaTypeId = "";

		String retType = paraMap.getString("retType");
		WoSVO woVO = new WoSVO();
		woVO.setWoNbr(woNbr);
		woList.add(woVO);

		if (SysConstants.WO_RET_SUCCESS.equals(retType)) {// 0�����ص���У���Ƿ����������ص�
		} else if (SysConstants.WO_RET_FAIL.equals(retType)) {// 1ʧ�ܻص���У���Ƿ�����ʧ�ܻص�
		}

		Map paramMap = new HashMap();
		String soCat = paraMap.getString("soCat");
		if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
			if(paraMap.containsKey("prodId")){
				String prodId = paraMap.getString("prodId");
				paramMap.put("prodId", prodId);
			}
			if(paraMap.containsKey("localNetId")){
				String localNetId = paraMap.getString("localNetId"); 
				paramMap.put("localNetId", localNetId);
			}
		}
		String woStaffId = "";

		paramMap.put("workAreaTypeId", workAreaTypeId);
		paramMap.put("workAreaTypeIdStr", workAreaTypeId);
		// ������
		paramMap.put("workAreaId", workAreaId);
		// JSONArray woArray = JSONArray.fromObject(woList);
		paramMap.put("woList", woList);
		// --end
		Map map = new HashMap();
		map.put("soCat", soCat);
		map.put("retType", retType);
		map.put("woList", woList);
		map.put("paramMap", paramMap);
		JSONObject mapJson = JSONObject.fromObject(map);

		String resultMapStr = WoHandleDelegate.getDelegate().initReturnWo4MOS(
				mapJson.toString());
		log.debug("web_mos����IOM������ϢΪ��" + resultMapStr);
		JSONObject resultMap = JSONObject.fromObject(resultMapStr);
		// JSONObject overtimeIdList =
		// resultMap.getJSONObject("OVERTIME_LV_BEANS");
		if (SysConstants.WO_RET_SUCCESS.equals(retType)) {// 0�����ص�
			if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
				// this.initWohandleForm(woHandleForm resultMap, request,
				// SysConstants.SO_CAT_FAULT, woStaffId, retType);
				// woHandleForm.setFaultReasonFlag("N");
				JSONObject sucMap = resultMap.getJSONObject("succReturnMap");
				JSONObject faultMap = resultMap.getJSONObject("faultMap");
				List faultReasonList = new ArrayList();
				if (sucMap.containsKey("WO_NOT_ALLOW_LIST")
						&& sucMap.getJSONArray("WO_NOT_ALLOW_LIST") != null
						&& sucMap.getJSONArray("WO_NOT_ALLOW_LIST").size() > 0) {
					toMosMap.put("WO_NOT_ALLOW_LIST", ((JSONObject) (sucMap
							.getJSONArray("WO_NOT_ALLOW_LIST").get(0)))
							.getString("remarks"));
				} else {
					if (sucMap.containsKey("OVERTIME_LV_BEANS")) {
						JSONArray overtimeIdList = sucMap
								.getJSONArray("OVERTIME_LV_BEANS");
						toMosMap.put("overtimeIdList", overtimeIdList);
					}
				}
				toMosMap.put("faultMap", faultMap);
			} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
				// this.initWohandleForm(woHandleForm, resultMap, request,
				// SysConstants.SO_CAT_BUSINESS, woStaffId, retType);
				if (resultMap.containsKey("WO_NOT_ALLOW_LIST")
						&& resultMap.getJSONArray("WO_NOT_ALLOW_LIST") != null
						&& resultMap.getJSONArray("WO_NOT_ALLOW_LIST").size() > 0) {
					toMosMap.put("WO_NOT_ALLOW_LIST", ((JSONObject) (resultMap
							.getJSONArray("WO_NOT_ALLOW_LIST").get(0)))
							.getString("remarks"));
				} else {
					if (resultMap.containsKey("OVERTIME_LV_BEANS")) {
						JSONArray overtimeIdList = resultMap
								.getJSONArray("OVERTIME_LV_BEANS");
						toMosMap.put("overtimeIdList", overtimeIdList);
					}
				}
			}
		} else if (SysConstants.WO_RET_FAIL.equals(retType)) {// 1ʧ�ܻص�
		// if (SysConstants.SO_CAT_FAULT.equals(soCat))
		// this.initWohandleForm(woHandleForm, resultMap, request,
		// SysConstants.SO_CAT_FAULT, woStaffId, retType);
		// else if (SysConstants.SO_CAT_BUSINESS.equals(woHandleForm
		// .getSoSVO().getSoCat().trim()))
		// this.initWohandleForm(woHandleForm, resultMap, request,
		// SysConstants.SO_CAT_BUSINESS, woStaffId, retType);
			JSONArray failReasonList = new JSONArray();
			if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
				JSONObject failMap = resultMap.getJSONObject("failReturnMap");
				if(failMap.get("FAIL_REASON_LV_BEANS")!=null){
					failReasonList = failMap.getJSONArray("FAIL_REASON_LV_BEANS");
				}
				
			} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
				if(resultMap.get("FAIL_REASON_LV_BEANS")!=null){
					failReasonList = resultMap.getJSONArray("FAIL_REASON_LV_BEANS");
				}
			}
			toMosMap.put("failReasonList", failReasonList);
		}
//		rep.setContentType("text/json;charset=utf-8");
//		rep.setCharacterEncoding("UTF-8");
		JSONObject json = JSONObject.fromObject(toMosMap);
		log.debug("web_mos���͵�MOS����ϢΪ��" + json.toString());
		
		ReqUtil.write(rep, json.toString());

		return null;
	}

	/**
	 * ��װ
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward addHandleLater4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		String parameter = ReqUtil.getRequestStr(request);
		String isSuccess = WoHandleDelegate.getDelegate().handleLater4MOS(
				parameter);
		if (isSuccess != null) {
			ReqUtil.write(rep, isSuccess);
		} else {
			ReqUtil.write(rep, "success");
		}
		return null;
	}

	/**
	 * �ص�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward woReturn4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {

		String parameter = ReqUtil.getRequestStr(request);
		JSONObject paraJSON = JSONObject.fromObject(parameter);
		String woStaffId = paraJSON.getString("staffId");
		String retStaffId = woStaffId;
		String woNbr = paraJSON.getString("woNbr");
		String soCat = paraJSON.getString("soCat");
		String returnType = paraJSON.getString("returnType"); // �ص�����
		String remarks = "�ͻ��˷���ת������"; // ��ע
		String failReasonId = null;
		String faultReasonId = null;
		String overtimeId = null;
		if (paraJSON.has("failReasonId")) {
			failReasonId = paraJSON.getString("failReasonId");// ʧ��ԭ��
		}
		if (paraJSON.has("faultReasonId")) {
			faultReasonId = paraJSON.getString("faultReasonId");// ����ԭ��
		}
		if (paraJSON.has("overtimeId")) {
			overtimeId = paraJSON.getString("overtimeId");// ����ԭ��
		}

		// String repairWay = woHandleForm.getRepairWay();// �޸�����
		WoSVO woSVO = new WoSVO();
		woSVO.setWorkComplDate(DateUtil.getDBDate());
		// woSVO.setRepairWay(repairWay);
		woSVO.setRemarks(remarks);
		// woSVO.setOnTheSpotFlag(onTheSpotFlag);
		// woSVO.setMaterialUseFlag(materialUseFlag);

		String failMsg = "";
		String resultCode = "0";// ~{;X5%3I9&~}
		boolean isFail = false;
		Map paramMap = new HashMap();
		paramMap.put("woNbr", woNbr);// ����δ�woNbrAry �ĳ� woNbrList
		paramMap.put("remarks", remarks);
		paramMap.put("failReasonId", failReasonId);
		paramMap.put("faultReasonId", faultReasonId);
		paramMap.put("overtimeId", overtimeId);
		paramMap.put("retStaffId", retStaffId);
		paramMap.put("woStaffId", woStaffId);
		paramMap.put("staffId", woStaffId); 
		paramMap.put("returnType", returnType);
		// paramMap.put("onTheSpotFlag", onTheSpotFlag); // �Ƿ��ֳ�ʩ��
		// paramMap.put("materialUseFlag", materialUseFlag); // �Ƿ�ʹ�ò���
		paramMap.put("workComplDate", DateUtil.getDBDateTimeStr());
		paramMap.put("woSVO", woSVO);
		paramMap.put("procNodeId", "");
		// woHandleForm.getSoFaultExtMVO().setFaultReasonId(faultReasonId);
		// paramMap.put("soFaultExtMVO", woHandleForm.getSoFaultExtMVO());

		// ����ʩ������ص��������
		// WoExtInfoMVO woExtMVO = new WoExtInfoMVO();
		// woExtMVO.setRepairWay(failReasonId);
		// woExtMVO.setMaterialUseFlag(materialUseFlag);
		// paramMap.put("woExtMVO", woExtMVO);
		// SoFaultExtMVO soFaultExtMVO=new SoFaultExtMVO();
		// soFaultExtMVO.setFaultReasonId(faultReasonId);
		// List faultReasonList = new ArrayList();
		// FaultReasonMVO vo=new FaultReasonMVO();
		// vo.setSts(Constant.STS_IN_USE);
		// vo.setFaultReasonId(faultReasonId);
		// faultReasonList=OptionUtil.getFaultReasonList(vo);
		// vo=(FaultReasonMVO)faultReasonList.get(0);
		// soFaultExtMVO.setFaultReasonName(vo.getFaultReasonDesc());
		// soFaultExtMVO.setRemarks(remarks);
		// soFaultExtMVO.setSts(Constant.STS_IN_USE);
		// soFaultExtMVO.setStsDate(DateUtil.getDBDate());
		// paramMap.put("soFaultExtMVO", soFaultExtMVO);

		// �������ݣ�Ϊ�˷������WoHandleDOM�е��߼�
		paramMap.put("processDesc", null);
		paramMap.put("resChangeFlag", null);
		paramMap.put("resChangeContent", null);
		paramMap.put("woDesignId", null);
		paramMap.put("designRemarks", null);
		paramMap.put("soPrptyMVO", null);
		paramMap.put("fetchWoFlag", null);
		paramMap.put("sysStaffId", null);
		paramMap.put("forScene", null);
		paramMap.put("matchCompCode", null);
		paramMap.put("soPrptyMVO", null);
		paramMap.put("exchId", null);
		paramMap.put("accNbr", null);
		paramMap.put("bideOutDate", null);
		paramMap.put("stepResReleaseMap", null);
		paramMap.put("delayFixDate", null);
		JSONObject paramMapJson = JSONObject.fromObject(paramMap);
		paramMapJson.put(SysConstants.RETURN_SYS, SysConstants.MOS_SYS);

		try {

			if (SysConstants.WO_RET_SUCCESS.equals(returnType)) {// 0�����ص�
				Map retMap = null;
				String result = "";

				if (!StringUtil.isBlank(overtimeId)
						&& StringUtil.isBlank(remarks)) {
					resultCode = "1";
					failMsg = "����д����ԭ��";
				} else {
					if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
						String[] componentCodeArry = new String[2];
						componentCodeArry[0] = SysConstants.COMPONENT_CODE_FAULT_HANDLE;
						componentCodeArry[1] = SysConstants.COMPONENT_CODE_SUCCESS_RETURN;
						paramMapJson
								.put("componentCodeArry", componentCodeArry);
						result = WoResponseDelegate.getDelegate().returnWo4MOS(
								paramMapJson.toString());
					} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
						result = WoHandleDelegate.getDelegate()
								.successReturn4MOS(paramMapJson.toString());
					}
					JSONObject retJSON = JSONObject.fromObject(result);
					isFail = true;
					failMsg = "�����ص��ɹ�";
					if (retJSON.getString("resultCode").equals("1")) {
						resultCode = "1";
						isFail = true;
						failMsg = "�����ص�ʧ��";
						if (retJSON.has("resultInfo")) {
							failMsg += " :" + retJSON.getString("resultInfo");
						}
					}
					if (retMap != null) {
						String retCode = (String) retJSON.get("retCode");
						List woList = retJSON.getJSONArray("retObj");
						if (SysConstants.WO_RET_CODE_FOR_PARALLEL_WO
								.equals(retCode)) {
							StringBuffer sb = new StringBuffer();
							sb.append("���ڲ���̨��λ����δ�ص�,���й���������ص�:\\r\\n");
							for (int i = 0; i < woList.size(); i++) {
								// WoSVO wo = (WoSVO) woList.get(i);
								sb.append("������: "
										+ ((JSONObject) (woList.get(i)))
												.get("woNbr") + "\\r\\n");
							}
							failMsg = sb.toString();
						}
					}
				}
			} else if (SysConstants.WO_RET_FAIL.equals(returnType)) {// 1ʧ�ܻص�
				if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
					String[] componentCodeArry = new String[1];
					componentCodeArry[0] = SysConstants.COMPONENT_CODE_FAIL_RETURN;
					paramMapJson.put("componentCodeArry", componentCodeArry);
					String retStr = WoResponseDelegate.getDelegate()
							.returnWo4MOS(paramMapJson.toString());
					JSONObject retMap = JSONObject.fromObject(retStr);
					resultCode = retMap.getString("resultCode");
					if (resultCode.equals("0")) {
						failMsg = "ʧ�ܻص��ɹ�";
					} else {
						failMsg = "�ص�ʧ��";
						if (retMap.has("resultInfo")) {
							failMsg += " :" + retMap.getString("resultInfo");
						}
					}
				} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
					String retStr = WoHandleDelegate.getDelegate()
							.failReturn4MOS(paramMapJson.toString());
					JSONObject retMap = JSONObject.fromObject(retStr);
					resultCode = retMap.getString("resultCode");
					if (resultCode.equals("0")) {
						failMsg = "ʧ�ܻص��ɹ�";
					} else {
						failMsg = "�ص�ʧ��";
						if (retMap.has("resultInfo")) {
							failMsg += " :" + retMap.getString("resultInfo");
						}
					}
				}
				// isFail = true;
				// failMsg = "~{J'0\;X5%3I9&~}!";
			}

		} catch (Exception e) {
			isFail = true;
			resultCode = "1";
			failMsg = failMsg + StringUtil.filterNextLine(e.getMessage());
		}
		if (StringUtil.isBlank(failMsg)) {
			failMsg = "�ص��ɹ�";
		}
//		rep.setContentType("text/json;charset=utf-8");
//		rep.setCharacterEncoding("UTF-8");
		Map map = new HashMap();
		Map detailMap = new HashMap();
		map.put("checkDetail", detailMap);
		detailMap.put("resultCode", resultCode);
		detailMap.put("resultInfo", failMsg);
		JSONObject json = JSONObject.fromObject(map);
		
		ReqUtil.write(rep, json.toString());

		return null;
	}
	
		
	
	/**
	 * ��ʼ���������
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException 
	 * @throws IOException
	 */
	public ActionForward initServDept4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException, IOException {
		String parameter = ReqUtil.getRequestStr(request);
		String result=WoHandleDelegate.getDelegate().initServDept4MOS(parameter);
		ReqUtil.write(rep, result);
		
		return null;
	}
	
	/**
	 * ����ά��
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward modiServDept4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException, IOException {
		String paramJson=ReqUtil.getRequestStr(request);
		WoHandleDelegate.getDelegate().modiServDept4MOS(paramJson);
		ReqUtil.write(rep, SysConstants.YES);
		return null;
	}
	
	/**
	 * ����ά����������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException 
	 */
	public ActionForward chgServDept4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		String paramJson=ReqUtil.getRequestStr(request);
		String res=WoHandleDelegate.getDelegate().chgServDept4MOS(paramJson);
		ReqUtil.write(response, res);
		return null;
	}

	/**
	 * ��ôӿͻ��˴����json�ַ���
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException {
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
	
	/**
	 * ԤԼ����
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException 
	 * @throws IOException
	 */
	public ActionForward upDateReservationTimeRecorde4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException, IOException {
		
		String parameter = ReqUtil.getRequestStr(request);
		String result=WoHandleDelegate.getDelegate().upDateReservationTimeRecorde4MOS(parameter);
		ReqUtil.write(rep, result);
		return null;
	}
	
	/**
	 *  ���������еĹ����б�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @author maxun CreateTime 2012-8-30 ����2:58:33
	 */
	public ActionForward initWo4Oss(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException {
		
		WoHandleForm woHandleForm = (WoHandleForm) actionForm;
		JSONObject requestJsonObject = JSONObject.fromObject(request.getSession().getAttribute("sysUserVOExtended"));
		JSONObject staffExtendMVO = requestJsonObject.getJSONObject("staffExtendMVO");
		String localNetId = staffExtendMVO.getString("localNetId");
		String areaId = staffExtendMVO.getString("areaId");
		String staffId =staffExtendMVO.getJSONObject("staffSVO").getString("staffId");
		String culmName = SysConstants.COLUMN_SEQ;// ������������

		String accNbr = request.getParameter("accNbr");
		String extSoNbr = request.getParameter("extSoNbr");
		
		AdvQueryMVO queryVo = new AdvQueryMVO();
		// ��ʼ����ҳĬ����Ϣ
		PagInfo pagInfo = new PagInfo();
		String pagNo = request.getParameter("pageNo");
		String pagCount = request.getParameter("pagCount");
		String pagSize =  request.getParameter("pagSize");
		
		pagInfo.setPagCount(Integer.parseInt(pagCount));
		pagInfo.setPagSize(Integer.parseInt(pagSize));
		pagInfo.setPagNo(Integer.parseInt(pagNo));
		
		queryVo.setLocalNetId(localNetId);
		queryVo.setAreaId(areaId);
		queryVo.setWorkAreaId("0");
		queryVo.setForScene(SysConstants.WO_GUI_SCENE_WO_HANDLE);
		
		JSONObject queryVoJsonObject = new JSONObject();

		if (requestJsonObject != null
				&& !StringUtil.isBlank(staffId)) {
			queryVoJsonObject.put("staffId",staffId);
		} else {
			return mapping.findForward("login");
		}

		String pageCode = "woSearch";

		queryVoJsonObject.put("localNetId",localNetId); //localNetIdΪ0���ܲ�ѯ������
//		queryVoJsonObject.put("localNetId","810");
		queryVoJsonObject.put("areaId", areaId);
		queryVoJsonObject.put("chbWorkAreaId", SysConstants.YES);
		queryVoJsonObject.put("workAreaId","0");
		queryVoJsonObject.put("pageCode", pageCode);
		if(!StringUtil.isBlank(accNbr)){
			queryVoJsonObject.put("accNbr", accNbr);
			request.setAttribute("accNbr",accNbr);
		}
		if(!StringUtil.isBlank(extSoNbr)){
			queryVoJsonObject.put("extSoNbr",extSoNbr);
			request.setAttribute("extSoNbr",extSoNbr);
		}
		
		JSONObject pagInfoJsonObject = new JSONObject();
		pagInfoJsonObject.put("count", new Integer(pagInfo.getCount()));
//		pagInfoJsonObject.put("localNetId","810");   //localNetIdΪ0���ܲ�ѯ������
		pagInfoJsonObject.put("localNetId",localNetId); 
		pagInfoJsonObject.put("areaId", areaId);
		pagInfoJsonObject.put("pagSize", new Integer(pagInfo.getPagSize()));
		pagInfoJsonObject.put("pagNo", new Integer(pagInfo.getPagNo()));
		pagInfoJsonObject.put("pagCount", new Integer(pagInfo.getPagCount()));
		pagInfoJsonObject.put("rowLimit", new Integer(pagInfo.getRowLimit()));
		JSONObject prameterJsonObject = new JSONObject();
		prameterJsonObject.put("queryVo", queryVoJsonObject);
		prameterJsonObject.put("pagInfo", pagInfoJsonObject);
		prameterJsonObject.put("culmName", culmName);
		String responseJson = WoHandleDelegate.getDelegate().initWoLists4MOS(
				prameterJsonObject.toString());
		JSONObject responseJsonObject = JSONObject.fromObject(responseJson);
		
		JSONArray array = responseJsonObject.getJSONArray("viewList");
		String count = responseJsonObject.getString("count");
		pagInfo.setCount(Integer.parseInt(count));
		pagInfo.setPagCount(Integer.parseInt(responseJsonObject.getString("pagCount")));
		if(Integer.parseInt(count)==0){
			pagInfo.setPagNo(Integer.parseInt(responseJsonObject.getString("pagNo")));
		}else{
			pagInfo.setPagNo(Integer.parseInt(responseJsonObject.getString("pagNo")));
		}
		pagInfo.setPagSize(Integer.parseInt(responseJsonObject.getString("pagSize")));

		
		
		List<WoDisplay> displays = new ArrayList<WoDisplay>();
		for (int i = 0; i < array.size(); i++) {
			WoDisplay wo = new WoDisplay();
			JSONObject o = (JSONObject)array.get(i);
			wo.setWoNbr(o.getString("woNbr"));
			wo.setSoNbr(o.getString("soNbr"));
			wo.setSoCat(o.getString("soCat"));
			wo.setExtSoNbr(o.getString("extSoNbr"));
			wo.setAccNbr(o.getString("accNbr"));//ҵ����� 
			wo.setBusinessName(o.getString("businessName"));//ҵ������
			wo.setActTypeName(o.getString("actTypeName"));//װ���־
//			String woStaffName = o.getString("woStaffName"); //ʩ����Ա
			wo.setAsgnDate(date2String(o.getString("asgnDate")));//�ɵ�ʱ��
			wo.setPreAlarmDate(date2String(o.getString("preAlarmDate")));//Ԥ��ʱ��
			wo.setRunStsName(o.getString("runStsName"));//����״̬
			long time = new Date().getTime();
			if(time<Long.parseLong(o.getString("preAlarmDate"))){
				wo.setAlarmType("0");
			}else if(time>Long.parseLong(o.getString("preAlarmDate")) && time<Long.parseLong(o.getString("alarmDate")))
			{
				wo.setAlarmType("1");
			}else{
				wo.setAlarmType("2");
			}
			
//			String runStsDate = o.getString("runStsDate"); //����״̬ʱ��
			wo.setSituated(o.getString("situated"));  //��ַ
			wo.setApplDate(date2String(o.getString("applDate")));//����ʱ��
//			String woRemarks = o.getString("woRemarks"); //������ע
			wo.setRemarks("");
//			String soWorkAreaName = o.getString("soWorkAreaName");//����Ӫҵ��
			wo.setSoWorkAreaName("");
//			String soStaffName = o.getString("soStaffName");//����Ա��
			wo.setSoStaffName("");
			wo.setLocalNetId("");
			wo.setAreaId("");
			wo.setWoTypeName(o.getString("woTypeName"));  //��������
			displays.add(wo);
		} 
		
		request.setAttribute("lists",displays);
		request.setAttribute("pagInfo",pagInfo);
		return mapping.findForward("initHandleAdv");
	}
	
	private String date2String(String d){
		long time = Long.parseLong(d);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		return sdf.format(date);
	}
	
	
//	/**
//	 *  �����ⲿ�����ź�ҵ������ѯ����
//	 * 
//	 * @param mapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws AppException
//	 * @throws SysException
//	 * @throws IOException
//	 * @author maxun CreateTime 2012-8-30 ����2:58:33
//	 */
//	public ActionForward queryWo4Oss(ActionMapping mapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws AppException, SysException,
//			IOException {
//		
//		WoHandleForm woHandleForm = (WoHandleForm) actionForm;
//		JSONObject requestJsonObject = JSONObject.fromObject(request.getSession().getAttribute("sysUserVOExtended"));
//		JSONObject staffExtendMVO = requestJsonObject.getJSONObject("staffExtendMVO");
//		String localNetId = staffExtendMVO.getString("localNetId");
//		String staffId =staffExtendMVO.getJSONObject("staffSVO").getString("staffId");
//
//
//		String pagNo = request.getParameter("pageNo");
//		String pagCount = request.getParameter("pagCount");
//		String pagSize =  request.getParameter("pagSize");
//		PagInfo pagInfo = new PagInfo();
//		pagInfo.setPagNo(Integer.parseInt(pagNo));
//		pagInfo.setPagCount(Integer.parseInt(pagCount));
//		pagInfo.setPagSize(Integer.parseInt(pagSize));
//		
//		String accNbr = request.getParameter("accNbr");
//		String extSoNbr = request.getParameter("extSoNbr");
//		
//		if(StringUtil.isBlank(accNbr) && StringUtil.isBlank(extSoNbr)){
//			String areaId = staffExtendMVO.getString("areaId");
//			String culmName = SysConstants.COLUMN_SEQ;// ������������
//
//			
//			AdvQueryMVO queryVo = new AdvQueryMVO();
//			// ��ʼ����ҳĬ����Ϣ
//			queryVo.setLocalNetId(localNetId);
//			queryVo.setAreaId(areaId);
//			queryVo.setWorkAreaId("0");
//			queryVo.setForScene(SysConstants.WO_GUI_SCENE_WO_HANDLE);
//			
//			JSONObject queryVoJsonObject = new JSONObject();
//
//			if (requestJsonObject != null
//					&& !StringUtil.isBlank(staffId)) {
//				queryVoJsonObject.put("staffId",staffId);
//			} else {
//				return mapping.findForward("login");
//			}
//
//			String pageCode = "woSearch";
//
//			queryVoJsonObject.put("localNetId","810");
//			queryVoJsonObject.put("areaId", areaId);
//			queryVoJsonObject.put("chbWorkAreaId", SysConstants.YES);
//			queryVoJsonObject.put("workAreaId","0");
//			queryVoJsonObject.put("pageCode", pageCode);
//			queryVoJsonObject.put("accNbr", accNbr);
//			queryVoJsonObject.put("extSoNbr",extSoNbr);
//			
//			JSONObject pagInfoJsonObject = new JSONObject();
//			pagInfoJsonObject.put("count", new Integer(pagInfo.getCount()));
//			pagInfoJsonObject.put("localNetId","810");
//			pagInfoJsonObject.put("areaId", areaId);
//			pagInfoJsonObject.put("pagSize", new Integer(pagInfo.getPagSize()));
//			pagInfoJsonObject.put("pagNo", new Integer(pagInfo.getPagNo()));
//			pagInfoJsonObject.put("pagCount", new Integer(pagInfo.getPagCount()));
//			pagInfoJsonObject.put("rowLimit", new Integer(pagInfo.getRowLimit()));
//			JSONObject prameterJsonObject = new JSONObject();
//			prameterJsonObject.put("queryVo", queryVoJsonObject);
//			prameterJsonObject.put("pagInfo", pagInfoJsonObject);
//			prameterJsonObject.put("culmName", culmName);
//			String responseJson = WoHandleDelegate.getDelegate().initWoLists4MOS(
//					prameterJsonObject.toString());
//			JSONObject responseJsonObject = JSONObject.fromObject(responseJson);
//			
//			JSONArray array = responseJsonObject.getJSONArray("viewList");
//			String count = responseJsonObject.getString("count");
//			pagInfo.setCount(Integer.parseInt(count));
//			pagInfo.setPagCount(Integer.parseInt(responseJsonObject.getString("pagCount")));
//			pagInfo.setPagNo(Integer.parseInt(responseJsonObject.getString("pagNo")));
//			pagInfo.setPagSize(Integer.parseInt(responseJsonObject.getString("pagSize")));
//
//			
//			
//			List<WoDisplay> displays = new ArrayList<WoDisplay>();
//			for (int i = 0; i < array.size(); i++) {
//				WoDisplay wo = new WoDisplay();
//				JSONObject o = (JSONObject)array.get(i);
//				wo.setWoNbr(o.getString("woNbr"));
//				wo.setSoNbr(o.getString("soNbr"));
//				wo.setExtSoNbr(o.getString("extSoNbr"));
//				wo.setAccNbr(o.getString("accNbr"));//ҵ����� 
//				wo.setBusinessName(o.getString("businessName"));//ҵ������
//				wo.setActTypeName(o.getString("actTypeName"));//װ���־
////				String woStaffName = o.getString("woStaffName"); //ʩ����Ա
//				wo.setAsgnDate(date2String(o.getString("asgnDate")));//�ɵ�ʱ��
//				wo.setPreAlarmDate(date2String(o.getString("preAlarmDate")));//Ԥ��ʱ��
//				wo.setRunStsName(o.getString("runStsName"));//����״̬
////				String runStsDate = o.getString("runStsDate"); //����״̬ʱ��
//				wo.setSituated(o.getString("situated"));  //��ַ
//				wo.setApplDate(date2String(o.getString("applDate")));//����ʱ��
////				String woRemarks = o.getString("woRemarks"); //������ע
//				wo.setRemarks("");
////				String soWorkAreaName = o.getString("soWorkAreaName");//����Ӫҵ��
//				wo.setSoWorkAreaName("");
////				String soStaffName = o.getString("soStaffName");//����Ա��
//				wo.setSoStaffName("");
//				wo.setLocalNetId("");
//				wo.setAreaId("");
//				wo.setWoTypeName(o.getString("woTypeName"));  //��������
//				displays.add(wo);
//			} 
//			
//			request.setAttribute("lists",displays);
//			request.setAttribute("pagInfo",pagInfo);
//			return mapping.findForward("initHandleAdv");
//		}else{
//			AdvQueryMVO queryVo = new AdvQueryMVO();
//			if(!StringUtil.isBlank(accNbr)){
//				queryVo.setChbAccNbr("1");
//				queryVo.setAccNbr(accNbr.trim());
//			}
//			if(!StringUtil.isBlank(extSoNbr)){
//				queryVo.setChbExtSoNbr("1");
//				queryVo.setExtSoNbr(extSoNbr.trim());
//			}
//			
//			queryVo.setQryFlag("cur");
//			queryVo.setPageFlag("WoQuery");
//			queryVo.setChbLocalNetId("1");
//			queryVo.setLocalNetId(localNetId);
//			queryVo.setSysUserId(staffId);
//			String queryVoString = com.alibaba.fastjson.JSONObject.toJSONString(queryVo);
//			String woList="";
//			woList = WoQueryDelegate.getDelegate().getWoListBySoNbr4MOS(queryVoString);
//			
//			JSONArray array =null;
//			try{
//				 array = JSONArray.fromObject(woList);//���õ����ַ���ת��JSONArray
//			}catch(Exception e){
//				
//			}
//			//���������б��ַ���ת����json�ַ������͵�ǰ̨
//			
//			List<WoDisplay> displays = new ArrayList<WoDisplay>();
//			if(array!=null){
//			for (int i = 0; i < array.size(); i++) {
//				WoDisplay wo = new WoDisplay();
//				JSONObject o = (JSONObject)array.get(i);
//				wo.setWoNbr(o.getString("woNbr"));
//				wo.setSoNbr(o.getString("soNbr"));
//				wo.setExtSoNbr(o.getString("extSoNbr"));
//				wo.setAccNbr(o.getString("accNbr"));//ҵ����� 
//				wo.setBusinessName(o.getString("businessName"));//ҵ������
//				wo.setActTypeName(o.getString("actTypeName"));//װ���־
//				String woStaffName = o.getString("woStaffName"); //ʩ����Ա
//				wo.setWoStaffName(woStaffName);
//				
//				JSONObject asgnDate = (JSONObject)o.get("asgnDate");
//				wo.setAsgnDate(date2String(asgnDate.getString("time")));//�ɵ�ʱ��
//				
//				JSONObject preAlarmDate = (JSONObject)o.get("preAlarmDate");
//				wo.setPreAlarmDate(date2String( preAlarmDate.getString("time")));//Ԥ��ʱ��
//				wo.setRunStsName(o.getString("runStsName"));//����״̬
//				
//				JSONObject runStsDate = (JSONObject)o.get("runStsDate"); //����״̬ʱ��
//				wo.setRunStsDate(date2String(runStsDate.getString("time")));
//				
//				wo.setSituated(o.getString("situated"));  //��ַ
//				
//				JSONObject applDate = (JSONObject)o.get("applDate");
//				wo.setApplDate(date2String(applDate.getString("time")));//����ʱ��
//	//			String woRemarks = o.getString("woRemarks"); //������ע
//				wo.setRemarks("");
//				String soWorkAreaName = o.getString("soWorkAreaName");//����Ӫҵ��
//				wo.setSoWorkAreaName(soWorkAreaName);
//				String soStaffName = o.getString("soStaffName");//����Ա��
//				wo.setSoStaffName(soStaffName);
//				wo.setLocalNetId(o.getString("localNetId"));
//				wo.setAreaId(o.getString("areaId"));
//				wo.setWoTypeName(o.getString("woTypeName"));  //��������
//				displays.add(wo);
//				} 
//				pagInfo.setCount(array.size());
//				pagInfo.setPagCount(array.size()/pagInfo.getPagSize()+1);
//			}else{
//				pagInfo.setCount(0);
//				pagInfo.setPagCount(0);
//			}
//			request.setAttribute("lists",displays);
//			request.setAttribute("pagInfo",pagInfo);
//			return mapping.findForward("initHandleAdv");
//		}
//		
//	}
	
	
	
//	/**
//	 * MOS Native ������ȡ�еĹ����б�
//	 * 
//	 * @param mapping
//	 * @param actionForm
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws AppException
//	 * @throws SysException
//	 * @throws IOException
//	 */
//	public ActionForward searchWO4Oss(ActionMapping mapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response) throws AppException, SysException,
//			IOException {
//		JSONObject requestJsonObject = JSONObject.fromObject(request.getSession().getAttribute("sysUserVOExtended"));
//		
//		// ��װ��Ҫ�Ĳ�ѯ����
//		JSONObject queryVoJsonObject = new JSONObject();
//		log.info("responseJson----------info"+requestJsonObject);
//		log.debug("responseJson----------debug"+requestJsonObject);
//		
//		PagInfo pagInfo = new PagInfo();
//		pagInfo.setCount(1);
//		pagInfo.setPagSize(10);
//		pagInfo.setPagNo(1);
//		
//		JSONObject staffExtendMVO = requestJsonObject.getJSONObject("staffExtendMVO");
//		String localNetId = staffExtendMVO.getString("localNetId");
//		String areaId = staffExtendMVO.getString("areaId");
//		String staffId =staffExtendMVO.getJSONObject("staffSVO").getString("staffId");
//		
//		queryVoJsonObject.put("staffId", staffId);
//
//		String pageCode = "WoFetchUnBook";
//
//		
//		queryVoJsonObject.put("localNetId",localNetId); //localNetIdΪ0��ѯ��������
////		queryVoJsonObject.put("localNetId","810");
//		queryVoJsonObject.put("areaId", areaId);
//		queryVoJsonObject.put("chbWorkAreaId", SysConstants.YES);
//		queryVoJsonObject.put("pageCode", pageCode);
//		queryVoJsonObject.put("workAreaId","0");
//
//		String culmName = SysConstants.COLUMN_SEQ;// ������������
//
//		JSONObject pagInfoJsonObject = new JSONObject();
//
//		pagInfoJsonObject.put("count", new Integer(pagInfo.getCount()));
//		pagInfoJsonObject.put("pagSize", new Integer(pagInfo.getPagSize()));
//		pagInfoJsonObject.put("pagNo", new Integer(pagInfo.getPagNo()));
//		pagInfoJsonObject.put("pagCount", new Integer(pagInfo.getPagCount()));
//		pagInfoJsonObject.put("rowLimit", new Integer(pagInfo.getRowLimit()));
//		// ��װ������һ����Ĳ���
//		JSONObject prameterJsonObject = new JSONObject();
//		prameterJsonObject.put("queryVo", queryVoJsonObject);
//		prameterJsonObject.put("pagInfo", pagInfoJsonObject);
//		prameterJsonObject.put("culmName", culmName);
//		
//		String responseJson = WoHandleDelegate.getDelegate().initWoLists4MOS(
//				prameterJsonObject.toString());
////		String responseJson =SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_FETWO_STRING, null, null, null, null, null);
//		log.info("responseJson----------more"+responseJson);
//		log.debug("responseJson----------more"+responseJson);
//
//		// ��ʼ�������ݣ���δ����
//		JSONObject responseJsonObject = JSONObject.fromObject(responseJson);
//		JSONArray jsonArray = responseJsonObject.getJSONArray("viewList");
//		String count = responseJsonObject.getString("count");
//		String pagCount = responseJsonObject.getString("pagCount");
//		String pagNo = responseJsonObject.getString("pagNo");
//		String pagSize = responseJsonObject.getString("pagSize");
//		String result =count +"@";
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject j = (JSONObject)jsonArray.get(i);
//			String extSoNbr = j.getString("extSoNbr");
//			result += extSoNbr+",";
//			String woNbr = j.getString("woNbr");
//			result += woNbr+",";
//			String soNbr = j.getString("soNbr");
//			result +=soNbr+",";
//			String businessName = j.getString("businessName");
//			result += businessName+",$";
//			if(i==8){
//				break;
//			}
//		}
//		
//		response.setContentType("text/xml;charset=UTF-8");
//		response.getWriter().write(result.substring(0,result.length()-1));
//		return null;
//	}
	
	
	/**
	 * �ص���ʼ��
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward woReturnInit4Oss(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		WoHandleForm woHandleForm =new WoHandleForm();
		Map toMosMap = new HashMap();
		
		
		String woNbr = (String)request.getParameter("woNbrAryStr");
		woHandleForm.setWoNbrAryStr(woNbr);
		String retType=request.getParameter("retType");
		String soCat = request.getParameter("soCat");
		
		List woList = new ArrayList();
		String[] split = woNbr.split(",");
		for (String string : split) {
			WoSVO woVO = new WoSVO();
			woVO.setWoNbr(string);
			woList.add(woVO);
		}

		if (SysConstants.WO_RET_SUCCESS.equals(retType)) {// 0�����ص���У���Ƿ����������ص�
		} else if (SysConstants.WO_RET_FAIL.equals(retType)) {// 1ʧ�ܻص���У���Ƿ�����ʧ�ܻص�
		}

		Map paramMap = new HashMap();
		String woStaffId = "";
		
		JSONObject sysUserVOExtended = (JSONObject)request.getSession().getAttribute("sysUserVOExtended");
		String workAreaId = sysUserVOExtended.getJSONObject("currentWorkAreaVO").getString("workAreaId");
		
		
		paramMap.put("workAreaId",workAreaId);
		paramMap.put("woList", woList);
		Map map = new HashMap();
		map.put("retType", retType);
		map.put("woList", woList);
		map.put("paramMap", paramMap);
		map.put("soCat", soCat);
		map.put("retType", retType);
		JSONObject mapJson = JSONObject.fromObject(map);

		String resultMapStr = WoHandleDelegate.getDelegate().initReturnWo4MOS(
				mapJson.toString());
		log.debug("web_mos����IOM������ϢΪ��" + resultMapStr);
		JSONObject resultMap = JSONObject.fromObject(resultMapStr);
		
		
		JSONObject succReturnMap = null;
		if(retType.equals("0"))
			succReturnMap = (JSONObject)resultMap.get("succReturnMap");
		else if(retType.equals("1")){
			succReturnMap = (JSONObject)resultMap.get("failReturnMap");
		}
		List woAllowList = new ArrayList();
		List woNotAllowList = new ArrayList();
		JSONArray woAllowArray = succReturnMap.getJSONArray("WO_ALLOW_LIST");
		for (int i = 0; i < woAllowArray.size(); i++) {
			WoMVO w = new WoMVO();
			JSONObject o = (JSONObject)woAllowArray.get(i);
			String mainFlag = o.getString("mainFlag");
			w.setMainFlag(mainFlag);
			w.setSoNbr(o.getString("soNbr"));
			w.setWoNbr(o.getString("woNbr"));
			w.setWorkAreaId(o.getString("workAreaId"));
			w.setRemarks(o.getString("remarks"));
			w.setWoStaffId(o.getString("woStaffId"));
			w.setWoStaffName(o.getString("woStaffName"));
			woAllowList.add(w);
		}
		
		JSONArray woNotAllowArray = succReturnMap.getJSONArray("WO_NOT_ALLOW_LIST");
		for (int i = 0; i < woNotAllowArray.size(); i++) {
			WoMVO w = new WoMVO();
			JSONObject o = (JSONObject)woAllowArray.get(i);
			String mainFlag = o.getString("mainFlag");
			w.setMainFlag(mainFlag);
			w.setSoNbr(o.getString("soNbr"));
			w.setWoNbr(o.getString("woNbr"));
			w.setStaffId(o.getString("staffId"));
			w.setWorkAreaId(o.getString("workAreaId"));
			w.setRemarks(o.getString("remarks"));
			w.setWoStaffId(o.getString("woStaffId"));
			w.setWoStaffName(o.getString("woStaffName"));
			woNotAllowList.add(w);
		}
		
		List failReasonIdList =null;
		if(succReturnMap.containsKey("FAIL_REASON_LV_BEANS")){
			 JSONArray array = succReturnMap.getJSONArray("FAIL_REASON_LV_BEANS");
			 failReasonIdList = new ArrayList();
			 for (int i = 0; i < array.size(); i++) {
				 JSONObject b = (JSONObject)array.get(i);
					Map h = new HashMap();
					h.put("label", b.getString("label"));
					h.put("value", b.getString("value"));
					failReasonIdList.add(h);
			}
		}
		
		List overtimeIdList = new ArrayList();
		if(succReturnMap.containsKey("OVERTIME_LV_BEANS")){
			JSONArray overtimeId = succReturnMap.getJSONArray("OVERTIME_LV_BEANS"); //��ʱԭ��
			for (int i = 0; i < overtimeId.size(); i++) {
				JSONObject b = (JSONObject)overtimeId.get(i);
				Map h = new HashMap();
				h.put("label", b.getString("label"));
				h.put("value", b.getString("value"));
				h.put("remarks","��ע");
				overtimeIdList.add(h);
			}
		}
		
		
		List staffListByWorkArea = new ArrayList();
		JSONArray staffListByWorkAreaArray= succReturnMap.getJSONArray("STAFF_LIST_WORK_AREA");
		for (int i = 0; i < staffListByWorkAreaArray.size(); i++) {
			JSONObject b = (JSONObject)staffListByWorkAreaArray.get(i);
			Map h = new HashMap();
			h.put("label", b.getString("label"));
			h.put("value", b.getString("value"));
			staffListByWorkArea.add(h);
		}
		
		List staffListByMaintArea =null;
		JSONArray staffList = succReturnMap.getJSONArray("STAFF_LIST_MAINT_AREA");
		if(staffList.size()>0){
			staffListByMaintArea =new ArrayList();
			for (int i = 0; i < staffList.size(); i++) {
				JSONObject b = (JSONObject)staffList.get(i);
				Map h = new HashMap();
				h.put("label", b.getString("label"));
				h.put("value", b.getString("value"));
				staffListByMaintArea.add(h);
			}
		}
		
		
		String woHandleStaffId = succReturnMap.getString("WO_HANDLE_STAFF_ID");
		String stepWoStaffConfig = succReturnMap.getString("STEP_WO_STAFF_CONFIG");
		
		// ����Ѿ�������ʩ����Ա���õ�½�û�
		if (woHandleStaffId != null
				&& !StringUtil.isBlank(woHandleStaffId.toString())) {
			woStaffId = woHandleStaffId.toString();
		}
		String mainWoStr = "";
		if (woAllowList != null) {
			for (int i = 0; woAllowList != null && i < woAllowList.size(); i++) {
				WoSVO vo = (WoSVO) woAllowList.get(i);
				if (SysConstants.MAIN_FLAG_FOR_MAIN.equals(vo.getMainFlag())
						&& SysConstants.MERG_FLAG_YES.equals(vo.getMergFlag())) {
					mainWoStr += vo.getWoNbr() + ",";
				}
			}
		}

		woHandleForm.setMainWoStr(mainWoStr);
		woHandleForm.setWorkAreaStaffList(staffListByWorkArea);
		woHandleForm.setMaintAreaStaffList(staffListByMaintArea);
		woHandleForm.setWorkAreaStaffId(woStaffId);
		woHandleForm.setMaintAreaStaffId(woStaffId);
		woHandleForm.setFailReasonIdList(failReasonIdList);
		// woHandleForm.setCanChangeWoStaff(canChangeWoStaff);
		woHandleForm.setStepWoStaffConfig(stepWoStaffConfig);

		List soNbrs = new ArrayList();
		String remarks = null;

		if (woAllowList != null) {
			for (int i = 0; i < woAllowList.size(); i++) {
				WoSVO tempWoVo = (WoSVO) woAllowList.get(i);
				soNbrs.add(tempWoVo.getSoNbr());// ����id
				remarks = tempWoVo.getRemarks();
			}
		}


		if (overtimeIdList != null) {
			woHandleForm.setOvertimeIdList(overtimeIdList);
		}

		woHandleForm.setSoNbr(CollectionUtil.toString(soNbrs, ","));
		woHandleForm.setWoAllowList(woAllowList);
		woHandleForm.setWoNotAllowList(woNotAllowList);
		request.setAttribute("soCat",soCat);
		request.setAttribute("WoHandleForm",woHandleForm);
		if("0".equals(retType))
			return mapping.findForward("WoSucceReturn");
		else if("1".equals(retType))
			return mapping.findForward("WoFailReturn");
		return null;
	}
	
	/**
	 * �ص�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param rep
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward woReturn(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws AppException, SysException,
			IOException {
		WoHandleForm form = (WoHandleForm)actionForm;

		JSONObject requestJsonObject = JSONObject.fromObject(request.getSession().getAttribute("sysUserVOExtended"));
		
		if(requestJsonObject==null){
			mapping.findForward("login");
		}
		
		JSONObject staffExtendMVO = requestJsonObject.getJSONObject("staffExtendMVO");
		String woStaffId = staffExtendMVO.getJSONObject("staffSVO").getString("staffId");
	
		String retStaffId = woStaffId;
		
		
		String woNbr = form.getWoNbrAryStr();
		String soCat = request.getParameter("soCat");
		String returnType=request.getParameter("returnType");
		String remarks = request.getParameter("remarks");
		if(StringUtil.isBlank(remarks)){
			remarks="������½�ص�";
		}
		String failReasonId = null;
		String faultReasonId = null;
		String overtimeId = null;
		
		 failReasonId = form.getFailReasonId();
		 faultReasonId = form.getFaultReasonId();
		 overtimeId = form.getOvertimeId();

		WoSVO woSVO = new WoSVO();
		woSVO.setWorkComplDate(DateUtil.getDBDate());
		woSVO.setRemarks(remarks);

		String failMsg = "";
		String resultCode = "0";// ~{;X5%3I9&~}
		boolean isFail = false;
		Map paramMap = new HashMap();
		paramMap.put("woNbr", woNbr);// ����δ�woNbrAry �ĳ� woNbrList
		paramMap.put("remarks", remarks);
		paramMap.put("failReasonId", failReasonId);
		paramMap.put("faultReasonId", faultReasonId);
		paramMap.put("overtimeId", overtimeId);
		paramMap.put("retStaffId", retStaffId);
		paramMap.put("woStaffId", woStaffId);
		paramMap.put("returnType", returnType);
		paramMap.put("workComplDate", DateUtil.getDBDateTimeStr());
		paramMap.put("woSVO", woSVO);
		paramMap.put("procNodeId", "");

		paramMap.put("processDesc", null);
		paramMap.put("resChangeFlag", null);
		paramMap.put("resChangeContent", null);
		paramMap.put("woDesignId", null);
		paramMap.put("designRemarks", null);
		paramMap.put("soPrptyMVO", null);
		paramMap.put("fetchWoFlag", null);
		paramMap.put("sysStaffId", null);
		paramMap.put("forScene", null);
		paramMap.put("matchCompCode", null);
		paramMap.put("soPrptyMVO", null);
		paramMap.put("exchId", null);
		paramMap.put("accNbr", null);
		paramMap.put("bideOutDate", null);
		paramMap.put("stepResReleaseMap", null);
		paramMap.put("delayFixDate", null);
		JSONObject paramMapJson = JSONObject.fromObject(paramMap);
		paramMapJson.put(SysConstants.RETURN_SYS, SysConstants.MOS_SYS);

		try {

			if (SysConstants.WO_RET_SUCCESS.equals(returnType)) {// 0�����ص�
				Map retMap = null;
				String result = "";

				if (!StringUtil.isBlank(overtimeId)
						&& StringUtil.isBlank(remarks)) {
					resultCode = "1";
					failMsg = "~{GkLnP43,FZT-Rr#!~}";
				} else {
					if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
						String[] componentCodeArry = new String[2];
						componentCodeArry[0] = SysConstants.COMPONENT_CODE_FAULT_HANDLE;
						componentCodeArry[1] = SysConstants.COMPONENT_CODE_SUCCESS_RETURN;
						paramMapJson
								.put("componentCodeArry", componentCodeArry);
						result = WoResponseDelegate.getDelegate().returnWo4MOS(
								paramMapJson.toString());
					} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
						result = WoHandleDelegate.getDelegate()
								.successReturn4MOS(paramMapJson.toString());
					}
					JSONObject retJSON = JSONObject.fromObject(result);
					isFail = true;
					failMsg = "�����ص��ɹ�";
					if (retJSON.getString("resultCode").equals("1")) {
						resultCode = "1";
						isFail = true;
						failMsg = "�����ص�ʧ��";
						if (retJSON.has("resultInfo")) {
							failMsg += " :" + retJSON.getString("resultInfo");
						}
					}
					if (retMap != null) {
						String retCode = (String) retJSON.get("retCode");
						List woList = retJSON.getJSONArray("retObj");
						if (SysConstants.WO_RET_CODE_FOR_PARALLEL_WO
								.equals(retCode)) {
							StringBuffer sb = new StringBuffer();
							sb.append("���ڲ���̨��λ����δ�ص�,���й���������ص�:\\r\\n");
							for (int i = 0; i < woList.size(); i++) {
								// WoSVO wo = (WoSVO) woList.get(i);
								sb.append("������: "
										+ ((JSONObject) (woList.get(i)))
												.get("woNbr") + "\\r\\n");
							}
							failMsg = sb.toString();
						}
					}
				}
			} else if (SysConstants.WO_RET_FAIL.equals(returnType)) {// 1ʧ�ܻص�
				if (SysConstants.SO_CAT_FAULT.equals(soCat)) {
					String[] componentCodeArry = new String[1];
					componentCodeArry[0] = SysConstants.COMPONENT_CODE_FAIL_RETURN;
					paramMapJson.put("componentCodeArry", componentCodeArry);
					String retStr = WoResponseDelegate.getDelegate()
							.returnWo4MOS(paramMapJson.toString());
					JSONObject retMap = JSONObject.fromObject(retStr);
					resultCode = retMap.getString("resultCode");
					if (resultCode.equals("0")) {
						failMsg = "ʧ�ܻص��ɹ�";
					} else {
						failMsg = "�ص�ʧ��";
						if (retMap.has("resultInfo")) {
							failMsg += " :" + retMap.getString("resultInfo");
						}
					}
				} else if (SysConstants.SO_CAT_BUSINESS.equals(soCat)) {
					String retStr = WoHandleDelegate.getDelegate()
							.failReturn4MOS(paramMapJson.toString());
					JSONObject retMap = JSONObject.fromObject(retStr);
					resultCode = retMap.getString("resultCode");
					if (resultCode.equals("0")) {
						failMsg = "ʧ�ܻص��ɹ�";
					} else {
						failMsg = "�ص�ʧ��";
						if (retMap.has("resultInfo")) {
							failMsg += " :" + retMap.getString("resultInfo");
						}
					}
				}
			}

		} catch (Exception e) {
			isFail = true;
			resultCode = "1";
			failMsg = failMsg + StringUtil.filterNextLine(e.getMessage());
		}
		if (StringUtil.isBlank(failMsg)) {
			failMsg = "�ص��ɹ�";
		}

		if (isFail) {
			request.setAttribute("failMsg", failMsg);
		}
		return mapping.findForward("autoClose");
	}
}