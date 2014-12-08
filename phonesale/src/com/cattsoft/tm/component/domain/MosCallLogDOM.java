/**
 * 
 */
package com.cattsoft.tm.component.domain;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tm.component.dao.IMosCallLogSDAO;
import com.cattsoft.tm.vo.MosCallLogSVO;

/**
 * @author maxun
 * CreateTime 2012-9-27 ����3:54:06
 */
public class MosCallLogDOM {
	/**
	 * ��ѯͨ����¼
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 */
	public String queryMosCallLog(String mosCallLogJson) throws AppException, SysException{
		
		JSONObject mosCallLogJsonObject=JSONObject.fromObject(mosCallLogJson);
		MosCallLogSVO mosCallLog=new MosCallLogSVO();
		mosCallLog.setWoNbr(mosCallLogJsonObject.getString("woNbr"));
		
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		List mosCallLogList=mosCallLogDao.findByVO(mosCallLog);
		JSONArray mosCallLogJsonArray=null;
		if(mosCallLogList!=null&&mosCallLogList.size()>0) {
			mosCallLogJsonArray=new JSONArray();
			for(int i=0;i<mosCallLogList.size();i++) {
				MosCallLogSVO mosCallLogSvo=(MosCallLogSVO) mosCallLogList.get(i);
				JSONObject mosCallLogVoJsonObject=new JSONObject();
				mosCallLogVoJsonObject.put("bookTime", mosCallLogSvo.getBookTime().getTime());
				mosCallLogVoJsonObject.put("calledPhoneNo", mosCallLogSvo.getCalledPhoneNo());
				mosCallLogVoJsonObject.put("callerPhoneNo", mosCallLogSvo.getCallerPhoneNo());
				mosCallLogVoJsonObject.put("callDuration", mosCallLogSvo.getCallDuration());
				mosCallLogVoJsonObject.put("endTime", mosCallLogSvo.getEndTime().getTime());
				mosCallLogVoJsonObject.put("mosCallLogId", mosCallLogSvo.getMosCallLogId());
				mosCallLogVoJsonObject.put("remarks", mosCallLogSvo.getRemarks());
				mosCallLogVoJsonObject.put("startTime", mosCallLogSvo.getStartTime().getTime());
				mosCallLogVoJsonObject.put("woNbr", mosCallLogSvo.getWoNbr());
				mosCallLogJsonArray.add(mosCallLogVoJsonObject);
			}
			return mosCallLogJsonArray.toString();
		}
		return null;
	}
	/**
	 * ��ѯͨ����¼����
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 */
	public String queryMosCallLogDetail(String mosCallLogJson) throws AppException, SysException{
		
		JSONObject mosCallLogJsonObject=JSONObject.fromObject(mosCallLogJson);
		MosCallLogSVO mosCallLog=new MosCallLogSVO();
		mosCallLog.setMosCallLogId(mosCallLogJsonObject.getString("mosCallLogId"));
		
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		MosCallLogSVO mosCallLogSvo=(MosCallLogSVO) mosCallLogDao.findByPK(mosCallLog);
		if(mosCallLogSvo!=null) {
				JSONObject mosCallLogVoJsonObject=new JSONObject();
				mosCallLogVoJsonObject.put("bookTime", mosCallLogSvo.getBookTime().getTime());
				mosCallLogVoJsonObject.put("calledPhoneNo", mosCallLogSvo.getCalledPhoneNo());
				mosCallLogVoJsonObject.put("callerPhoneNo", mosCallLogSvo.getCallerPhoneNo());
				mosCallLogVoJsonObject.put("callDuration", mosCallLogSvo.getCallDuration());
				mosCallLogVoJsonObject.put("endTime", mosCallLogSvo.getEndTime().getTime());
				mosCallLogVoJsonObject.put("mosCallLogId", mosCallLogSvo.getMosCallLogId());
				mosCallLogVoJsonObject.put("remarks", mosCallLogSvo.getRemarks());
				mosCallLogVoJsonObject.put("startTime", mosCallLogSvo.getStartTime().getTime());
				mosCallLogVoJsonObject.put("woNbr", mosCallLogSvo.getWoNbr());
				return mosCallLogVoJsonObject.toString();
		}
		return null;
	}
	public void addMosCallLog4MOS(String paraMapStr) throws SysException, AppException{
		com.alibaba.fastjson.JSONObject toOkJsonObject = com.alibaba.fastjson.JSONObject.parseObject(paraMapStr);
		String callerNum = (String) toOkJsonObject.get("callerNum");//���к���
		String calledNum = (String) toOkJsonObject.get("calledNum");//���к���
		String woNum = (String) toOkJsonObject.get("woNum");//��������
		Date startDate = new Date((Long)toOkJsonObject.get("startDate"));//ͨ����ʼʱ��
		Date endDate =  new Date((Long) toOkJsonObject.get("endDate"));//ͨ������ʱ��
		String callTime = toOkJsonObject.get("callTime").toString();//ͨ��ʱ��
		Date reservationDate = new Date((Long) toOkJsonObject.get("reservationDate"));//ԤԼʱ��
		String remark = (String) toOkJsonObject.get("remark");//��ע
		MosCallLogSVO mosCallLogSVO = new MosCallLogSVO();
		mosCallLogSVO.setMosCallLogId(MaxId.getSequenceNextVal(SysConstants.MOS_CALL_LOG_ID_SEQ));
		mosCallLogSVO.setBookTime(reservationDate);
		mosCallLogSVO.setCallDuration(callTime);
		mosCallLogSVO.setCallerPhoneNo(callerNum);
		mosCallLogSVO.setCalledPhoneNo(calledNum);
		mosCallLogSVO.setWoNbr(woNum);
		mosCallLogSVO.setEndTime(endDate);
		mosCallLogSVO.setStartTime(startDate);
		mosCallLogSVO.setRemarks(remark);
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		mosCallLogDao.add(mosCallLogSVO);

	}
}
