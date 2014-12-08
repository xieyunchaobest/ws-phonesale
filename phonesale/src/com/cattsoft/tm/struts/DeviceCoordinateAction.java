package com.cattsoft.tm.struts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.DeviceCoordinateDelegate;
import com.cattsoft.tm.vo.ResAttachMVO;
import com.cattsoft.tm.delegate.ResourceQueryDelegate;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xml4mos.xmlbeans.CheckedResultWarehousingRequest;
import com.cattsoft.xml4mos.xmlbeans.CheckedResultWarehousingRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.CheckedResultWarehousingResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DEVICEINFOREQDocument;
import com.cattsoft.xml4mos.xmlbeans.DEVICEINFORSPDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckRequest;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequest;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.ImageDeleteRequest;
import com.cattsoft.xml4mos.xmlbeans.ImageDeleteRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.ImageDeleteResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.QueryDeviceImageRequest;
import com.cattsoft.xml4mos.xmlbeans.QueryDeviceImageRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.QueryDeviceImageResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.UploadDeviceImageRequest;
import com.cattsoft.xml4mos.xmlbeans.UploadDeviceImageRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.UploadDeviceImageResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.CheckedResultWarehousingRequest.Devices.Device;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequest.DictionaryParameters;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequest.DictionaryParameters.DictionaryParameter;
import com.cattsoft.xml4mos.xmlbeans.QueryDeviceImageResponse.DeviceImageInfoReses.DeviceImageInfoRes;
import com.cattsoft.xml4mos.xmlbeans.UploadDeviceImageRequest.DeviceImageInfoReqs;
import com.cattsoft.xml4mos.xmlbeans.UploadDeviceImageRequest.DeviceImageInfoReqs.DeviceImageInfoReq;

/**
 * ��Դ�˲�
 * 
 * @author xieyunchao
 * 
 */
public class DeviceCoordinateAction extends DispatchAction {

	private static final Logger log = Logger
			.getLogger(DeviceCoordinateAction.class);

	public static void main(String[] args) throws SysException, AppException,
			IOException, XmlException {
		int flag = 0;
		String result = "";
		switch (flag) {
		
		case 0:
			DEVICEINFOREQDocument doc0 = DEVICEINFOREQDocument.Factory.newInstance();
			doc0.addNewDEVICEINFOREQ();
//			doc0.getDEVICEINFOREQ().addNewPagInfo();
//			doc0.getDEVICEINFOREQ().getPagInfo().setPageNo("1");
//			doc0.getDEVICEINFOREQ().getPagInfo().setPageSize("25");
			doc0.getDEVICEINFOREQ().setDEVICENAME("64.64/F01-564-6");//64.64/F01-564-6_HW
			doc0.getDEVICEINFOREQ().setDEVICETYPE("60");
//			doc0.getDEVICEINFOREQ().setLOCALNETID("431");
//			doc0.getDEVICEINFOREQ().setAREAID("43101");
//			doc0.getDEVICEINFOREQ().setQueryType("1");
//			doc0.getDEVICEINFOREQ().setQueryType("2");
//			doc0.getDEVICEINFOREQ().setDEVICEID("504640484");
			result = ResourceQueryDelegate.getDelegate().queryDevice(doc0.toString());
			
//			DEVICEINFOREQDocument doc0 = DEVICEINFOREQDocument.Factory.newInstance();
//			doc0.addNewDEVICEINFOREQ();
//			doc0.getDEVICEINFOREQ().setDEVICENAME("zqobd-zt");
//			doc0.getDEVICEINFOREQ().setDEVICETYPE("200");
//			doc0.getDEVICEINFOREQ().setLOCALNETID("432");
//			doc0.getDEVICEINFOREQ().setAREAID("43201");
//			result = ResourceQueryDelegate.getDelegate().queryDevice(doc0.toString());
			
			DEVICEINFORSPDocument resultDoc0 = DEVICEINFORSPDocument.Factory.parse(result);
			log.debug("�������Ϊ��\n" + doc0.toString());
			log.debug("RMS���ؽ��Ϊ��\n" + resultDoc0.toString());
			break;
		
		case 1:// ��Դ�˲� ��ť
			DeviceCheckRequestDocument doc1 = DeviceCheckRequestDocument.Factory
					.newInstance();
			DeviceCheckRequest reqDoc1 = doc1.addNewDeviceCheckRequest();
			reqDoc1.setAccNbr("8229186");//  8229186
			reqDoc1.setLocalNetId("470");
			reqDoc1.addNewPagInfo().setPageNo("1");
			reqDoc1.getPagInfo().setPageSize("10");
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc1.toString(),
					SysConstants.FUNCODE_QUERY_DEVICE_BY_ACC_NBR);
			DeviceCheckResponseDocument resutlDoc1 = DeviceCheckResponseDocument.Factory.parse(result);
			break;
		case 2:// ��Դ�˲� ��ҳ
			DeviceCheckRequestDocument doc2 = DeviceCheckRequestDocument.Factory
					.newInstance();
			DeviceCheckRequest reqDoc2 = doc2.addNewDeviceCheckRequest();
			// reqDoc2.setAccNbr("82291863");
//			 reqDoc2.setLocalNetId("472");
//			reqDoc2.setServiceAreaId("47001");
//			reqDoc2.setResourceName("���");
//			reqDoc2.setResourceType("30005");
			reqDoc2.setResourceName("�����õİ�������103");
			reqDoc2.setResourceType("30003");
//			reqDoc2.setResourceName("���ͺ����б�ʶ001");
//			reqDoc2.setResourceType("30021");//30003 ���־�  30005 ���   30021 ��ʯ
//			reqDoc2.setResourceId("5");
			reqDoc2.addNewPagInfo().setPageNo("1");
			reqDoc2.getPagInfo().setPageSize("5");
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc2.toString(),
					SysConstants.FUNCODE_QUERY_FUNC_DEVICE_BY_NAME);
			DeviceCheckResponseDocument resutlDoc2 = DeviceCheckResponseDocument.Factory.parse(result);
			break;
		case 3:// �ϴ�ͼƬ
			UploadDeviceImageRequestDocument doc3 = UploadDeviceImageRequestDocument.Factory
					.newInstance();
			UploadDeviceImageRequest reqDoc3 = doc3
					.addNewUploadDeviceImageRequest();
			DeviceImageInfoReqs imgReqs = reqDoc3.addNewDeviceImageInfoReqs();
			String imgFile = "C:/Users/FUSHUANG.CATTSOFT/Pictures/hope.jpg";// �������ͼƬ
			String imgFile1 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/rou.jpg";// �������ͼƬ
			String imgFile2 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/rabbit.jpg";// �������ͼƬ
			String imgFile3 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/rabbit1.jpg";// �������ͼƬ
			String imgFile4 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/light3.JPG";// �������ͼƬ
			String imgFile5 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/light2.JPG";// �������ͼƬ
			String imgFile6 = "C:/Users/FUSHUANG.CATTSOFT/Pictures/light1.JPG";// �������ͼƬ
			
			String[] imgFileArr = new String[] { imgFile4, imgFile3 };
			InputStream in = null;
			byte[] data = null;
			String imgStr;
			// ���ֽ�����Base64����
			BASE64Encoder encoder = new BASE64Encoder();
			try {

				for (int k = 0; k < imgFileArr.length; k++) {
					DeviceImageInfoReq imgReq = imgReqs
							.addNewDeviceImageInfoReq();
					// ��ȡͼƬ�ֽ�����
					in = new FileInputStream(imgFileArr[k]);
					data = new byte[in.available()];
					in.read(data);
					in.close();
					imgStr = encoder.encode(data);// ����Base64��������ֽ������ַ���
					imgReq.setDeviceIdReq("653344");
					imgReq.setDeviceImageStringReq(imgStr);
					imgReq.setDeviceImageExpandedNameReq("jpg");
					imgReq.setLocalNetId("476");
					imgReq.setServiceAreaId("47601");
					imgReq.setDesc("�����ϴ�ͼƬ"+k);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc3.toString(), SysConstants.FUNCODE_UPLOAD_DEVICE_IMAGE);
			
			UploadDeviceImageResponseDocument resultDoc3 = UploadDeviceImageResponseDocument.Factory.parse(result);
			
			break;
		case 4:// ��ȡͼƬ
			QueryDeviceImageRequestDocument doc = QueryDeviceImageRequestDocument.Factory
					.newInstance();
			QueryDeviceImageRequest reqDoc = doc
					.addNewQueryDeviceImageRequest();
			reqDoc.setDeviceId("653344");
			reqDoc.setLocalNetId("476");
			reqDoc.setImageCount("m");
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc.toString(),
					SysConstants.FUNCODE_QUERY_DEVICE_IMAGE_BY_ID);
			BASE64Decoder decoder = new BASE64Decoder();
			OutputStream out;
			String imgFilePath;
			QueryDeviceImageResponseDocument resDoc = QueryDeviceImageResponseDocument.Factory
					.parse(result);
			DeviceImageInfoRes[] imgArr = resDoc.getQueryDeviceImageResponse()
					.getDeviceImageInfoReses().getDeviceImageInfoResArray();
			if (imgArr != null && imgArr.length > 0) {
				try {
					for (int j = 0; j < imgArr.length; j++) {
						imgStr = imgArr[j].getDeviceImageStringRes();
						// Base64����
						byte[] b = decoder.decodeBuffer(imgStr);
						for (int i = 0; i < b.length; ++i) {
							if (b[i] < 0) {// �����쳣����
								b[i] += 256;
							}
						}
						// ������չ��ͼƬ
						imgFilePath = "D:/1/" + imgArr[j].getDesc()+ j + "."
								+ imgArr[j].getExpandedName();// �����ɵ�ͼƬ
						out = new FileOutputStream(imgFilePath);
						out.write(b);
						out.flush();
						out.close();

					}
				} catch (Exception e) {
				}
			}

			
			break;
		case 5:// �ɼ�����
			CheckedResultWarehousingRequestDocument doc5 = CheckedResultWarehousingRequestDocument.Factory
					.newInstance();
			CheckedResultWarehousingRequest reqDoc5 = doc5
					.addNewCheckedResultWarehousingRequest();
			reqDoc5.setLocalNetId("476");
			reqDoc5.setServiceAreaId("47601");
			reqDoc5.setActType("M");
			reqDoc5.addNewDevices();
			for (int n = 1; n <= 1; n++) {
				Device device = reqDoc5.getDevices().addNewDevice();
//				device.setDeviceId("653344" + n);
				device.setDeviceId("303697");
				device.setLatitude("22239.906606"+n);
				device.setLongitude("222116.424858"+n);
				// device.setAttaches();
			}

			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc5.toString(),
					SysConstants.FUNCODE_CHECKED_RESULT_WARE_HOUSING);
			CheckedResultWarehousingResponseDocument resultDoc5 = CheckedResultWarehousingResponseDocument.Factory.parse(result);
			break;
		case 6://ͼƬɾ��
			ImageDeleteRequestDocument doc6 = ImageDeleteRequestDocument.Factory.newInstance();
			ImageDeleteRequest reqDoc6 = doc6.addNewImageDeleteRequest();
			reqDoc6.setDeviceId("653344");
			reqDoc6.setImageId("101");
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc6.toString(),
					SysConstants.FUNCODE_DELETE_DEVICE_IMAGE);
			ImageDeleteResponseDocument resultDoc = ImageDeleteResponseDocument.Factory.parse(result);
			break;
		case 7://�ֵ���ѯ
			DictionaryQueryRequestDocument doc7 = DictionaryQueryRequestDocument.Factory.newInstance();
			DictionaryQueryRequest reqDoc7 = doc7.addNewDictionaryQueryRequest();
			reqDoc7.setDictionaryType("deviceTreaty");//  deviceMode factory deviceTreaty
			reqDoc7.addNewDictionaryParameters();
			for (int n = 1; n <= 1; n++) {
				DictionaryParameter parm = reqDoc7.getDictionaryParameters().addNewDictionaryParameter();
				DictionaryParameter parm1 = reqDoc7.getDictionaryParameters().addNewDictionaryParameter();
				parm.setParameterID("factoryId");//factoryId subType
				parm.setParameterValue("940");//940 6002
				parm1.setParameterID("subType");//factoryId subType
				parm1.setParameterValue("6002");//940 6002
			}			
			result = DeviceCoordinateDelegate.getDelegate().callRmsService(
					doc7.toString(),
					SysConstants.FUNCODE_QUERY_DICTIONARY_BY_PARAMETER);
			DictionaryQueryResponseDocument resultDoc7 = DictionaryQueryResponseDocument.Factory.parse(result);
			break;
		}

		log.debug("��Դ����XML��\n" + result);
	}

	/**
	 * ������ʾ��Ҫ�˲���豸�б� 
	 * �ص�ǰ����Դ�˲�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showDeviceList4MOS(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ���ڽ�����Դ���������ز���
		String resPonseResult = "";
		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject jsonReq = com.alibaba.fastjson.JSONObject.parseObject(jsonstr);
//		String accNbr = jsonReq.getString("accNbr");
		String accNbr = "7370651";// 8229186
//		String localnetId = jsonReq.getString("localNetId");
		String localnetId = "470";// 476
		String resourceType = jsonReq.getString("resourceType");
		String resourceName = jsonReq.getString("localNetId");
		String resourceID = jsonReq.getString("resourceID");
//		String areaId = jsonReq.getString("areaId");
		String areaId = "47001";

		DeviceCheckRequestDocument deviceCheckRequestDocument = DeviceCheckRequestDocument.Factory.newInstance();
		DeviceCheckRequest deviceCheckRequest = deviceCheckRequestDocument.addNewDeviceCheckRequest();
		
		if(accNbr != null && !"".equals(accNbr.trim())){
		deviceCheckRequest.setAccNbr(accNbr);
		}
		if(localnetId != null && !"".equals(localnetId)){
		deviceCheckRequest.setLocalNetId(localnetId);
		}
		if(resourceType != null && !"".equals(resourceType)){
			deviceCheckRequest.setResourceType(resourceType);
		}
		if(resourceName != null && !"".equals(resourceName.trim())){
			deviceCheckRequest.setResourceName(resourceName);
		}
		if(resourceID != null && !"".equals(resourceID.trim())){
			deviceCheckRequest.setResourceId(resourceID);
		}
		if(areaId != null && !"".equals(areaId)){
			deviceCheckRequest.setServiceAreaId(areaId);
		}
		
		com.cattsoft.xml4mos.xmlbeans.DeviceCheckRequest.PagInfo pageInfo = deviceCheckRequest.addNewPagInfo();

		pageInfo.setPageNo("1");
		pageInfo.setPageSize("20");
		// ��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(deviceCheckRequestDocument.toString(),
				SysConstants.FUNCODE_QUERY_DEVICE_BY_ACC_NBR);
		String jsonResult = StringUtil.xml2JSON(result);
		System.out.println("���ص��豸�б�JsonΪ:   " + jsonResult);
		com.alibaba.fastjson.JSONObject jsonDeviceCheckResponse = com.alibaba.fastjson.JSONObject
				.parseObject(jsonResult).getJSONObject("DeviceCheckResponse");
		// �жϷ��ص������Ƿ�����
		String resultKey = jsonDeviceCheckResponse.getString("ResultKey");
		String resultDesc = jsonDeviceCheckResponse.getString("ResultValue");
		if ("1".equals(resultKey)) {
			resPonseResult = StringUtil.getAppException4MOS(resultDesc);
			ReqUtil.write(response, resPonseResult);
			return null;
		} else {
			ReqUtil.write(response, jsonResult);
			return null;
		}
	}

	/**
	 * ������ʾ��Ҫ�˲���豸�б����ã��ϲ���showDeviceList4MOS������
	 * ��ҳ�湦�ܵ�
	 */
	public ActionForward showDeviceListFromFun4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(jsonstr);
		String accNbr = json.getString("accNbr");
		String localnetId = json.getString("localNetId");
		String pageNo = json.getString("");
		String pageSize = json.getString("");
		DeviceCheckRequestDocument doc1 = DeviceCheckRequestDocument.Factory.newInstance();
		DeviceCheckRequest reqDoc1 = doc1.addNewDeviceCheckRequest();

		reqDoc1.setResourceName("�����õİ�������103");
		reqDoc1.setResourceType("30003");

		reqDoc1.setAccNbr(accNbr);
		reqDoc1.setLocalNetId(localnetId);
		reqDoc1.addNewPagInfo().setPageNo(pageNo);
		reqDoc1.getPagInfo().setPageSize(pageSize);

		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(doc1.toString(),
						SysConstants.FUNCODE_QUERY_FUNC_DEVICE_BY_NAME);

		// ��xmlת����json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("����xmlת��Ϊjson=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * ��ȡ��ԴͼƬ,�����豸ID
	 */
	public ActionForward showDevicePicture(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List imageList = new ArrayList();
		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject json = JSONObject.parseObject(jsonstr);
		String localNetId = "470";
		String imageCount = json.getString("imageCount");
		String deviceId = json.getString("deviceId");

		QueryDeviceImageRequestDocument doc = QueryDeviceImageRequestDocument.Factory.newInstance();
		QueryDeviceImageRequest reqDoc = doc.addNewQueryDeviceImageRequest();

		reqDoc.setDeviceId(deviceId);
		reqDoc.setLocalNetId(localNetId);
		reqDoc.setImageCount(imageCount);
		//��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(
				doc.toString(), SysConstants.FUNCODE_QUERY_DEVICE_IMAGE_BY_ID);
		BASE64Decoder decoder = new BASE64Decoder();
		QueryDeviceImageResponseDocument resDoc = QueryDeviceImageResponseDocument.Factory.parse(result);
		String jsonResult = StringUtil.xml2JSON(result);

		com.alibaba.fastjson.JSONObject jsonQueryDeviceImageResponse = com.alibaba.fastjson.JSONObject
				.parseObject(jsonResult).getJSONObject(
						"QueryDeviceImageResponse");
		// �жϷ��ص������Ƿ�����
		String resultKey = jsonQueryDeviceImageResponse.getString("ResultKey");
		String resultDesc = jsonQueryDeviceImageResponse.getString("ResultValue");
		if ("1".equals(resultKey)) {
			String resPonseResult = StringUtil.getAppException4MOS(resultDesc);
			ReqUtil.write(response, resPonseResult);
			return null;
		} else {
			JSONArray jsonDeviceImageInfoReses = jsonQueryDeviceImageResponse.getJSONArray("DeviceImageInfoReses");
			JSONObject deviceImageInfoRes = jsonDeviceImageInfoReses.getJSONObject(0);
			DeviceImageInfoRes[] imgArr = resDoc.getQueryDeviceImageResponse().getDeviceImageInfoReses().getDeviceImageInfoResArray();
			// װ��list����
			if (imgArr != null && imgArr.length > 0) {
				try {
					for (int j = 0; j < imgArr.length; j++) {
						ResAttachMVO resAttachMVO = new ResAttachMVO();
						String imgStr = imgArr[j].getDeviceImageStringRes();
						// Base64����
						byte[] byteResult = decoder.decodeBuffer(imgStr);
						for (int i = 0; i < byteResult.length; ++i) {
							if (byteResult[i] < 0) {// �����쳣����
								byteResult[i] += 256;
							}
						}
						// ���ص�N������
						JSONArray deviceImageInfoResArray = deviceImageInfoRes
								.getJSONArray("DeviceImageInfoRes");
						JSONObject deviceImage = deviceImageInfoResArray
								.getJSONObject(j);
						// һ��Ϊ�˸�jsonObject,�����˸��ֶ�
						String imageId = deviceImage.getString("ImageId");
						String desc = deviceImage.getString("desc");
						String deviceIdRes = deviceImage.getString("DeviceIdRes");

						resAttachMVO.setBytes(byteResult);
						resAttachMVO.setDesc(desc);
						resAttachMVO.setImageId(imageId);
						resAttachMVO.setDeviceId(deviceIdRes);
						imageList.add(resAttachMVO);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			String returnValue = JSON.toJSONString(imageList);
			ReqUtil.write(response, returnValue);
			return null;
		}
	}

	/**
	 * ����豸ͼƬ
	 */
	public ActionForward addDevicePicture(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject json = JSONObject.parseObject(jsonstr);
		// �贫�����������������������ͼƬ
		String deviceId = json.getString("deviceId");
		byte[] pictureBytes = json.getBytes("pictureBytes");
		String localNetId = json.getString("localNetId");
		String areaId = json.getString("areaId");
		String imageExpandedName = json.getString("imageExpandedName");
		String desc = json.getString("desc");

		UploadDeviceImageRequestDocument doc3 = UploadDeviceImageRequestDocument.Factory
				.newInstance();
		UploadDeviceImageRequest reqDoc3 = doc3
				.addNewUploadDeviceImageRequest();
		DeviceImageInfoReqs imgReqs = reqDoc3.addNewDeviceImageInfoReqs();

		String imgStr;
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		DeviceImageInfoReq imgReq = imgReqs.addNewDeviceImageInfoReq();

		imgStr = encoder.encode(pictureBytes);// ����Base64��������ֽ������ַ���
		imgReq.setDeviceIdReq(deviceId);
		imgReq.setDeviceImageStringReq(imgStr);
		imgReq.setDeviceImageExpandedNameReq("jpg");
		imgReq.setLocalNetId("470");
		imgReq.setServiceAreaId("47001");
		imgReq.setDesc(desc);
		//��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(
				doc3.toString(), SysConstants.FUNCODE_UPLOAD_DEVICE_IMAGE);

		// ��xmlת����json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("����xmlת��Ϊjson=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * ɾ���豸ͼƬ
	 */
	public ActionForward delDevicePicture(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject json = JSONObject.parseObject(jsonstr);
		String deviceId = json.getString("deviceId");
		String imageId = json.getString("imageId");

		ImageDeleteRequestDocument doc6 = ImageDeleteRequestDocument.Factory
				.newInstance();
		ImageDeleteRequest reqDoc6 = doc6.addNewImageDeleteRequest();
		reqDoc6.setDeviceId(deviceId);
		reqDoc6.setImageId(imageId);
		//��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(doc6.toString(), SysConstants.FUNCODE_DELETE_DEVICE_IMAGE);
		// ��xmlת����json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("����xmlת��Ϊjson=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * �ɼ��豸����,���ͻ��˴��ݹ����ľ�γ�����괫����Դ��,����
	 */
	public ActionForward collectDeviceCoord(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject json = JSONObject.parseObject(jsonstr);
		String lantitude = json.getString("lantitude");
		String longitude = json.getString("longitude");
		String actType = json.getString("actType");
		String localNetId = json.getString("localNetId");
		String areaId = json.getString("areaId");
		String deviceId = json.getString("deviceId");

		CheckedResultWarehousingRequestDocument doc5 = CheckedResultWarehousingRequestDocument.Factory.newInstance();
		CheckedResultWarehousingRequest reqDoc5 = doc5.addNewCheckedResultWarehousingRequest();

		reqDoc5.setLocalNetId("470");
		reqDoc5.setServiceAreaId("47001");
		reqDoc5.addNewDevices();
		reqDoc5.setActType(actType);

		Device device = reqDoc5.getDevices().addNewDevice();
			device.setDeviceId(deviceId);
			device.setLatitude(lantitude);
			device.setLongitude(longitude);
			// device.setAttaches();
		//��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(doc5.toString(),
				SysConstants.FUNCODE_CHECKED_RESULT_WARE_HOUSING);

		// ��xmlת����json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("����xmlת��Ϊjson=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}
	
	
	/**
	 * ��ѯ��Դ���͵��ֵ��ֵ
	 */
	public ActionForward queryDictionary(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {

		String jsonstr = ReqUtil.getRequestStr(request);
		JSONObject json = JSONObject.parseObject(jsonstr);
		//����XML�ĵ���Ϊ���
		DictionaryQueryRequestDocument doc8 = DictionaryQueryRequestDocument.Factory.newInstance();
		DictionaryQueryRequest reqDoc8 = doc8.addNewDictionaryQueryRequest();
		reqDoc8.setDictionaryType("dictionary");
		DictionaryParameters dicPars = reqDoc8.addNewDictionaryParameters();
		DictionaryParameter dicPar = dicPars.addNewDictionaryParameter();
		dicPar.setParameterID("categoryid");
		dicPar.setParameterValue("20130830");
		//��������
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(
				doc8.toString(),SysConstants.FUNCODE_QUERY_DICTIONARY_BY_PARAMETER);

		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("����ֵ = " + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}
}
