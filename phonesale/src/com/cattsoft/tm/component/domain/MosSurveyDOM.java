/**
 * 
 */
package com.cattsoft.tm.component.domain;

import java.util.List;

import net.sf.json.JSONObject;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.sp.component.dao.ISoAttachMDAO;
import com.cattsoft.sp.component.dao.ISoAttachSDAO;
import com.cattsoft.sp.vo.SoAttachMVO;
import com.cattsoft.sp.vo.SoAttachSVO;
import com.cattsoft.tm.component.dao.IMosSurveyMDAO;
import com.cattsoft.tm.component.dao.IMosSurveySDAO;
import com.cattsoft.tm.vo.MosSurveyMVO;
import com.cattsoft.tm.vo.MosSurveySVO;

/**
 * @author maxun
 * CreateTime 2012-9-27 ����3:54:06
 */
public class MosSurveyDOM {

	public String addMosSurvey(String paraMapStr) throws SysException, AppException{
		
		com.alibaba.fastjson.JSONObject toOkJsonObject = com.alibaba.fastjson.JSONObject.parseObject(paraMapStr);
		String extSoNbr = (String) toOkJsonObject.get("extSoNbr");//
		String soNbr = (String) toOkJsonObject.get("soNbr");//
		
        String woNbr = (String) toOkJsonObject.get("woNbr");
	    String  contacInfo = (String) toOkJsonObject.get("contacInfo");
	    String localNetId = (String) toOkJsonObject.get("localNetId");
	    String areaId = (String) toOkJsonObject.get("areaId");
	    
		String isExplanation = (String) toOkJsonObject.get("isExplanation");//��δ����Լ��ʱ�����ŷ����Ƿ���ͻ������˽���
		String isFinished = (String) toOkJsonObject.get("isFinished");//�û�ȷ���Ƿ�����˱���װ�������ϣ����� 
		String isReverseInTime = (String)toOkJsonObject.get("isReserseInTime");//�Ƿ��ڹ涨ʱ������ͻ�����ԤԼ 
		String isSatisfaction =  (String) toOkJsonObject.get("isSatisfaction");//�ͻ��Ա��ι����������������
		String isVisitInTime =(String) toOkJsonObject.get("isVisitInTime");//�Ƿ�����ͻ�Լ����ʱ��������ŷ����
		String remarks = (String) toOkJsonObject.get("remark");//��ע
		MosSurveyMVO mosSurveyMVO = new MosSurveyMVO();
		mosSurveyMVO.setMosSurveyId(MaxId.getSequenceNextVal(SysConstants.MOS_SURVEY_ID_SEQ));//����
		mosSurveyMVO.setExtSoNbr(extSoNbr);
		mosSurveyMVO.setIsExplanation(isExplanation);
		mosSurveyMVO.setIsFinished(isFinished);
		mosSurveyMVO.setIsReverseInTime(isReverseInTime);
		mosSurveyMVO.setIsSatisfaction(isSatisfaction);
		mosSurveyMVO.setIsVisitInTime(isVisitInTime);
		mosSurveyMVO.setRemarks(remarks);
		IMosSurveyMDAO mosSurveyDao=(IMosSurveyMDAO) DAOFactory.getDAO(IMosSurveyMDAO.class);
		mosSurveyDao.addWithoutSignature(mosSurveyMVO);
		
		byte[] signatureBytes=toOkJsonObject.getBytes("signatureBytes");
		mosSurveyMVO.setSignatureBytes(signatureBytes);
		mosSurveyDao.updateSignature(mosSurveyMVO);
		/**
		 * ���뵽SO_ATTACH����
		 */
		ISoAttachSDAO soAttachSDAO = (ISoAttachSDAO) DAOFactory.getDAO(ISoAttachSDAO.class);
		ISoAttachMDAO soAttachMDAO = (ISoAttachMDAO) DAOFactory.getDAO(ISoAttachMDAO.class);
		SoAttachSVO soAttachSVO = new SoAttachSVO();
		
		soAttachSVO.setLocalNetId(localNetId);
		soAttachSVO.setWoNbr(woNbr);
		soAttachSVO.setSoNbr(soNbr);
		soAttachSVO.setFileName("�û�ǩ��.jpg");
		soAttachSVO.setRemarks(remarks);
		soAttachSVO.setSts(SysConstants.USE_YES_STS);
		soAttachSVO.setStsDate(DateUtil.getDBDate());
		soAttachSVO.setSoAttachId(MaxId.getSequenceNextVal(SysConstants.SO_ATTACH_ID_SEQ));
		
		soAttachSDAO.add(soAttachSVO);
		soAttachMDAO.updateSoAttach(signatureBytes, soAttachSVO.getSoAttachId());
		
		//���Ͷ���

	    /*String notifyTypeId =SysConstants.NOTIFY_TYPE_SM;
		String notifyConfigId=SysConstants.NOTIFY_CONFIG_ID;
			//���п���Ϊ��,ȥ��ö�������ʱҪ�������
			String woNbrAryStr =woNbr;
			String msgMatchId = SysConstants.MSG_SURVEY_ID;
		   //�¼�����
			String msgEventType = SysConstants.MSG_EVENT_TYPE_MOS;
			String msgContent = "";
			String notifyNbr = contacInfo;//��ϵ����
			 JSONObject json=new JSONObject();
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
		WoHandleDOM woHandleDOM = new WoHandleDOM();*/
		//return	woHandleDOM.sendMsg4MOS(json.toString());
		return null;
		
	}
	public List queryMOSSurvey4MOS(String paraMapStr) throws SysException, AppException{
		IMosSurveySDAO mosSurveyDao=(IMosSurveySDAO) DAOFactory.getDAO(IMosSurveySDAO.class);
		MosSurveySVO mosSurveySVO = new MosSurveySVO();
		mosSurveySVO.setExtSoNbr(paraMapStr);
		List mosSurveyList = mosSurveyDao.findByVO(mosSurveySVO);
		return mosSurveyList;
		
	}
	public String addMOSPicture4MOS(String paraMapStr) throws SysException, AppException{
		/**
		 * ���뵽SO_ATTACH����
		 */
		ISoAttachSDAO soAttachSDAO = (ISoAttachSDAO) DAOFactory.getDAO(ISoAttachSDAO.class);
		ISoAttachMDAO soAttachMDAO = (ISoAttachMDAO) DAOFactory.getDAO(ISoAttachMDAO.class);
		SoAttachSVO soAttachSVO = new SoAttachSVO();
		com.alibaba.fastjson.JSONObject toOkJsonObject = com.alibaba.fastjson.JSONObject.parseObject(paraMapStr);
		byte[] pictureBytes=toOkJsonObject.getBytes("pictureBytes");
		String woNbr = toOkJsonObject.getString("woNbr");
		String localNetId = toOkJsonObject.getString("localNetId");
		String soNbr = toOkJsonObject.getString("soNbr");
		String remark = toOkJsonObject.getString("remark");
		soAttachSVO.setLocalNetId(localNetId);
		soAttachSVO.setWoNbr(woNbr);
		soAttachSVO.setSoNbr(soNbr);
		soAttachSVO.setFileName("������������.jpg");
		soAttachSVO.setForScene("D");
		soAttachSVO.setRemarks(remark);
		soAttachSVO.setSts(SysConstants.USE_YES_STS);
		soAttachSVO.setStsDate(DateUtil.getDBDate());
		soAttachSVO.setSoAttachId(MaxId.getSequenceNextVal(SysConstants.SO_ATTACH_ID_SEQ));
		
		soAttachSDAO.add(soAttachSVO);
		soAttachMDAO.updateSoAttach(pictureBytes, soAttachSVO.getSoAttachId());
		return soAttachSVO.getSoAttachId();
		
	}
	public List queryMOSPicture4MOS(SoAttachMVO paraMapStr) throws SysException, AppException{
		ISoAttachMDAO soAttachMDAO = (ISoAttachMDAO) DAOFactory.getDAO(ISoAttachMDAO.class);
		List pictureList;
		pictureList = soAttachMDAO.findSoAttachListByVO(paraMapStr);
		return pictureList;
	}
	public void deleteMOSPicture4MOS(SoAttachMVO paraMapStr) throws SysException, AppException{
		ISoAttachSDAO soAttachSDAO = (ISoAttachSDAO) DAOFactory.getDAO(ISoAttachSDAO.class);
		soAttachSDAO.delete(paraMapStr);
	}
}
