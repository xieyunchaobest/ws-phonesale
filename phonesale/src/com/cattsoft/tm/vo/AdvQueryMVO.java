package com.cattsoft.tm.vo;

import java.util.Date;
import java.util.List;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.ActionLogSVO;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: �߼���ѯ������VO<br>
 * Date: 2007-6-8 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */

public class AdvQueryMVO extends GenericVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054071422354644694L;
	//�ж��Ƿ���˲�ѯ
	private String chbCheck;
	private String dutyFlag;
	private String  subProdNameList=null;
	//���N������
	private int lastsize;
	
	private String subProdIdList=null;
	// ��ǰ��¼�û�
	private String staffId;

	// ��������(���ⲿ����)
	private String extSoNbr;

	private String chbExtSoNbr;
	
	private String AddrInfo;
	
	private String chbAddrInfo;
	private String chbDutyFlag;
	
	private String notifyNbr;

	// ��������
	private String woNbr;
	
	// �ڲ�����
	private String soNbr;

	// �������
	private String accNbr;

	// AD�ʺ�
	private String userName;

	// ���ߺ���
	private String shareLineNbr;

	private String chbShareLineNbr;

	// ������
	private String woId;

	// ����״̬
	private String sts;

	// ��������
	private String woType;

	// ��Ʒ
	private String prodIdList;

	private String prodNameList;

	// �ͻ�����
	private String chgServSpecIdList;

	private String chgServSpecNameList;

	// ����ҵ��
	private String businessId;

	// ����
	private String exchIdList;

	private String exchNameList;

	// ����
	private String workAreaId;

	// �ͻ�����
	private String custId;

	private String custName;   

	// �ͻ�����
	private String custLevel;

	// �ͻ�����
	private String custCat;

	// ��������
	private String actType;

	// ������
	private String processLevel;

	// ����״̬ʱ��
	private Date stsDateStart;

	private Date stsDateEnd;

	// ����ʱ��
	private Date toSoDate;

	private Date fromSoDate;

	// �ɵ�ʱ��
	private Date toAsgnDate;

	private Date fromAsgnDate;

	// ����״̬
	private String runSts;

	// ����״̬ʱ��
	private Date fromRunStsDate;

	private Date toRunStsDate;

	// ҵ��״̬
	private String busiSts;

	// ҵ��״̬ʱ��
	private Date fromBusiStsDate;

	private Date toBusiStsDate;

	// ������
	private String localNetId;

	// ������
	private String areaId;

	// ԤԼ��־
	private String bookFlag;

	// TABҳ��ʶ
	private String pageCode;
	
	private String pageCodeId;

	// �ڲ����Ÿ�ѡ��
	private String chbSoNbr;

	// �������checkbox
	private String chbAccNbr;

	// AD�ʺ�checkbox
	private String chbUserName;

	// ������checkbox
	private String chbWoId;

	// ����״̬checkbox
	private String chbSts;

	// ҵ��״̬checkbox
	private String chbBusiSts;

	// ����״̬checkbox
	private String chbRunSts;

	// ��������
	private String chbWoType;
	
	// ��������
	private String chbSoType;
	// ��Ʒ
	private String chbProdIdList;

	// �ͻ�����
	private String chbChgServSpecIdList;

	private String flagCheckChgServSpec;

	// ����ҵ��
	private String chbBusinessId;

	// ����
	private String chbExchIdList;

	// ����
	private String chbWorkAreaId;

	// �ͻ�����
	private String chbCustId;

	// �ͻ�����
	private String chbCustLevel;

	// �ͻ�����
	private String chbCustCat;

	// ��������
	private String chbActTypeId;

	// ������
	private String chbProcessLevel;

	// ����״̬ʱ��
	private String chbStsDate;

	// ����״̬ʱ��

	private String chbRunStsDate;

	// ҵ��״̬ʱ��
	private String chbBusiStsDate;

	// ������
	private String chbLocalNetId = "1";

	// ������
	private String chbAreaId;
	
	//ʩ����Ա
	private String chbStaffId;
	


	// ����ʱ��ѡ��
	private String chbSoDate;

	// �ɵ�ʱ��ѡ��
	private String chbAsgnDate;

	// ԤԼѡ��
	private String chbBookFlag;

	// �ͻ����涨������
	private List tabHandleCustomList;

	// ����tabҳ�м�
	private List tabColumnList;

	// �Ƿ��ѯ��ʷ���־
	private String chbHis = "0";

	// �Ƿ�ѡ�񻷽�
	private String chbStep;

	// ����id
	private String stepId;

	// �ڲ���������
	private String chbNsoNbr;

	private String nsoNbr;

	// �����־
	private String chbDealFlag;

	private String dealFlag;

	// ʩ����ʽ
	private String chbWorkMode;

	private String workMode;

	private String sysUserId;

	private String forScene;
	
	private String pwcNbr;
	
	private String pwcSpeed;
	
	private String port;
	
	// ԤԼ��������ʱ��
	private int bookDueTime;

	// ����ԭ��
	private String chbOverTimeReasonId;

	private String overTimeReasonId;

	private String chbDate = null;

	// ��ʶ���ĸ�ҳ�淢�͵������Ե�����Ӧ��DAO����
	private String pageFlag;

	// CRM���������Ӫҵ��ID
	private String chbSoWorkAreaId;

	private String soWorkAreaId;

	private String chbCoNbr;

	private String coNbr;

	private String isExportExcel;// �Ƿ�������ҳ�͵���excel��ť

	private String servDept;

	private String chbServDept;

	private String woTypeNameList;//�������������б�
	private String soTypeNameList;//�������������б�
	
	private String soType;
	private String soTypeList;//���������б�
	private String woTypeList;//���������б�

	private String actTypeNameList;//װ�����������б�

	private String actTypeList;//װ�������б�
	
	private String chbPhyAccNbr;
	
	private String phyAccNbr;//����̖�a
	
	private String chbMtAreaId;//����checkbox
	
	private String mtAreaId;//����id
	
	private String chbCheckRange;//��鷶Χ��ѡ��
	
	private String checkRange;//��鷶Χ
	
	private String parallelWoRunStsFlag;  //�Ƿ�鿴���й���״̬
	
	private String soSts;  // ����״̬ 
	private String chbSoSts;
	private String woManageReason = null; // ���������ԭ��lijixu 20090629
	
	private String qryFlag = null; // �Ƿ��ѯ��ʷ��,�鵵��yangkai 20091118
	
	private String hisFlag = null; // �Ƿ������ʷ��,sys_config���� lijixu add 2010-7-5 18:6:54
	
	private List msgItemList = null;
	
	//��������	OBJECT_TYPE
	private String objectType = null;
	
	private String objectId = null;
	
	private String eventType = null;
	
	/**��ݲ�ѯ����*/
	private String quickQueryCondition;
	
	private String WoNbrStr = null;
	private String queryCat = null;  //��ͨҵ��,ͣ��ҵ��,����ҵ��
	
	private String workStaffId;//ʩ����
	
	private String curWoStaffId;//��ǰ��½Ա��
	
	private ActionLogSVO actionLogSVO;
	
	// add by baijm 2012-04-12 tag6.7.1.3Ǩ��
	private Date fromCoDate;
	private Date toCoDate;
	
	private String chbCoNbrSimp;
	
	private String alarmSts=null;//2012-9-12 added by maxun Mos Native ��ʱɸѡ
	
	
	public String getAlarmSts() {
		return alarmSts;
	}

	public void setAlarmSts(String alarmSts) {
		this.alarmSts = alarmSts;
	}

	public String getChbCoNbrSimp() {
		return chbCoNbrSimp;
	}

	public void setChbCoNbrSimp(String chbCoNbrSimp) {
		this.chbCoNbrSimp = chbCoNbrSimp;
	}

	public String getFromCoDateStr() {
		String str = "";
		if (null != this.fromCoDate) {
			str = DateUtil.to_char(fromCoDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setFromCoDateStr(String startDatepStr) throws AppException, SysException {
		if (!StringUtil.isBlank(startDatepStr)) {
			this.fromCoDate = DateUtil.to_date(startDatepStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.fromCoDate = null;
	}

	public String getToCoDateStr() {
		String str = "";
		if (null != this.toCoDate) {
			str = DateUtil.to_char(toCoDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setToCoDateStr(String endDatepStr) throws AppException, SysException {
		if (!StringUtil.isBlank(endDatepStr)) {
			this.toCoDate = DateUtil.to_date(endDatepStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.toCoDate = null;
	}
	// add end
		
	public ActionLogSVO getActionLogSVO() {
		return actionLogSVO;
	}

	public void setActionLogSVO(ActionLogSVO actionLogSVO) {
		this.actionLogSVO = actionLogSVO;
	}

	public String getQueryCat() {
		return queryCat;
	}

	public void setQueryCat(String queryCat) {
		this.queryCat = queryCat;
	}
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public List getMsgItemList() {
		return msgItemList;
	}

	public void setMsgItemList(List msgItemList) {
		this.msgItemList = msgItemList;
	}
	
	public String getQuickQueryCondition() {
		return quickQueryCondition;
	}

	public void setQuickQueryCondition(String quickQueryCondition) {
		this.quickQueryCondition = quickQueryCondition;
	}

	public String getWoNbrStr() {
		return WoNbrStr;
	}

	public void setWoNbrStr(String woNbrStr) {
		WoNbrStr = woNbrStr;
	}

	public String getParallelWoRunStsFlag() {
		return parallelWoRunStsFlag;
	}

	public void setParallelWoRunStsFlag(String parallelWoRunStsFlag) {
		this.parallelWoRunStsFlag = parallelWoRunStsFlag;
	}

	public String getChbServDept() {
		return chbServDept;
	}

	public void setChbServDept(String chbServDept) {
		this.chbServDept = chbServDept;
	}

	public String getServDept() {
		return servDept;
	}

	public void setServDept(String servDept) {
		this.servDept = servDept;
	}

	public String getChbSoWorkAreaId() {
		return chbSoWorkAreaId;
	}

	public void setChbSoWorkAreaId(String chbSoWorkAreaId) {
		this.chbSoWorkAreaId = chbSoWorkAreaId;
	}

	public String getSoWorkAreaId() {
		return soWorkAreaId;
	}

	public void setSoWorkAreaId(String soWorkAreaId) {
		this.soWorkAreaId = soWorkAreaId;
	}

	public String getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getAccNbr() {
		return accNbr;
	}

	public void setAccNbr(String accNbr) {
		this.accNbr = accNbr;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getCustCat() {
		return custCat;
	}

	public void setCustCat(String custCat) {
		this.custCat = custCat;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getLocalNetId() {
		return localNetId;
	}

	public void setLocalNetId(String localNetId) {
		this.localNetId = localNetId;
	}

	public String getProcessLevel() {
		return processLevel;
	}

	public void setProcessLevel(String processLevel) {
		this.processLevel = processLevel;
	}

	public String getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(String soNbr) {
		this.soNbr = soNbr;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public Date getStsDateEnd() {
		return stsDateEnd;
	}

	public void setStsDateEnd(Date stsDateEnd) {
		this.stsDateEnd = stsDateEnd;
	}

	public Date getStsDateStart() {
		return stsDateStart;
	}

	public void setStsDateStart(Date stsDateStart) {
		this.stsDateStart = stsDateStart;
	}

	public String getStsDateEndStr() {
		String str = "";
		if (null != this.stsDateEnd) {
			str = DateUtil.to_char(stsDateEnd, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setStsDateEndStr(String stsDateEndStr) throws AppException, SysException {
		if (!StringUtil.isBlank(stsDateEndStr)) {
			this.stsDateEnd = DateUtil.to_date(stsDateEndStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.stsDateEnd = null;
	}

	public String getStsDateStartStr() {
		String str = "";
		if (null != this.stsDateStart) {
			str = DateUtil.to_char(stsDateStart, "yyyy-MM-dd hh24:mm:ss");
		}
		return str;
	}

	public void setStsDateStartStr(String stsDateStartStr) throws AppException, SysException {
		if (!StringUtil.isBlank(stsDateStartStr)) {
			this.stsDateStart = DateUtil.to_date(stsDateStartStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.stsDateStart = null;

	}

	// ����ʱ��
	public String getFromSoDateStr() {
		String str = "";
		if (null != this.fromSoDate) {
			str = DateUtil.to_char(fromSoDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setFromSoDateStr(String startDatepStr) throws AppException, SysException {
		if (!StringUtil.isBlank(startDatepStr)) {
			this.fromSoDate = DateUtil.to_date(startDatepStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.fromSoDate = null;
	}

	public String getToSoDateStr() {
		String str = "";
		if (null != this.toSoDate) {
			str = DateUtil.to_char(toSoDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setToSoDateStr(String endDatepStr) throws AppException, SysException {
		if (!StringUtil.isBlank(endDatepStr)) {
			this.toSoDate = DateUtil.to_date(endDatepStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.toSoDate = null;

	}

	// �ɵ�ʱ��
	public String getFromAsgnDateStr() {
		return DateUtil.dateTime2Str(this.fromAsgnDate);
	}

	public void setFromAsgnDateStr(String fromDateStr) throws AppException, SysException {

		this.fromAsgnDate = DateUtil.str2DateTime(fromDateStr);
	}

	public String getToAsgnDateStr() {

		return DateUtil.dateTime2Str(this.toAsgnDate);
	}

	public void setToAsgnDateStr(String toDateStr) throws AppException, SysException {

		this.toAsgnDate = DateUtil.str2DateTime(toDateStr);

	}

	// ����״̬ʱ��
	// public String getfromBusiStsStr() {
	// return DateUtil.dateTime2Str(this.fromBusiStsDate);
	// }
	//
	// public void setfromBusiStsStr(String fromDateStr) throws AppException, SysException {
	//
	// this.fromBusiStsDate = DateUtil.str2DateTime(fromDateStr);
	// }
	//	
	public String getFromBusiStsDateStr() {
		return DateUtil.dateTime2Str(this.fromBusiStsDate);
	}

	public void setFromBusiStsDateStr(String fromDateStr) throws AppException, SysException {

		this.fromBusiStsDate = DateUtil.str2DateTime(fromDateStr);
	}

	public String getToBusiStsDateStr() {

		return DateUtil.dateTime2Str(this.toBusiStsDate);
	}

	public void setToBusiStsDateStr(String toDateStr) throws AppException, SysException {

		this.toBusiStsDate = DateUtil.str2DateTime(toDateStr);

	}

	// ҵ��״̬ʱ��
	// public String getfromRunStsDateStr() {
	// return DateUtil.dateTime2Str(this.fromRunStsDate);
	// }

	// public void setfromRunStsDateStr(String fromDateStr) throws AppException, SysException {
	//
	// this.fromRunStsDate = DateUtil.str2DateTime(fromDateStr);
	// }
	public String getFromRunStsDateStr() {
		return DateUtil.dateTime2Str(this.fromRunStsDate);
	}

	public void setFromRunStsDateStr(String fromDateStr) throws AppException, SysException {

		this.fromRunStsDate = DateUtil.str2DateTime(fromDateStr);
	}

	public String getToRunStsDateStr() {

		return DateUtil.dateTime2Str(this.toRunStsDate);
	}

	public void setToRunStsDateStr(String toDateStr) throws AppException, SysException {

		this.toRunStsDate = DateUtil.str2DateTime(toDateStr);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getWorkAreaId() {
		return workAreaId;
	}

	public void setWorkAreaId(String workAreaId) {
		this.workAreaId = workAreaId;
	}

	public String getWoType() {
		return woType;
	}

	public void setWoType(String woType) {
		this.woType = woType;
	}

	public String getChbAccNbr() {
		return chbAccNbr;
	}

	public void setChbAccNbr(String chbAccNbr) {
		this.chbAccNbr = chbAccNbr;
	}

	public String getChbAreaId() {
		return chbAreaId;
	}

	public void setChbAreaId(String chbAreaId) {
		this.chbAreaId = chbAreaId;
	}

	public String getChbBusinessId() {
		return chbBusinessId;
	}

	public void setChbBusinessId(String chbBusinessId) {
		this.chbBusinessId = chbBusinessId;
	}

	public String getChbCustCat() {
		return chbCustCat;
	}

	public void setChbCustCat(String chbCustCat) {
		this.chbCustCat = chbCustCat;
	}

	public String getChbCustId() {
		return chbCustId;
	}

	public void setChbCustId(String chbCustId) {
		this.chbCustId = chbCustId;
	}

	public String getChbCustLevel() {
		return chbCustLevel;
	}

	public void setChbCustLevel(String chbCustLevel) {
		this.chbCustLevel = chbCustLevel;
	}

	public String getChbLocalNetId() {
		return chbLocalNetId;
	}

	public void setChbLocalNetId(String chbLocalNetId) {
		this.chbLocalNetId = chbLocalNetId;
	}

	public String getChbProcessLevel() {
		return chbProcessLevel;
	}

	public void setChbProcessLevel(String chbProcessLevel) {
		this.chbProcessLevel = chbProcessLevel;
	}

	public String getChbProdIdList() {
		return chbProdIdList;
	}

	public void setChbProdIdList(String chbProdIdList) {
		this.chbProdIdList = chbProdIdList;
	}

	public String getChbSoNbr() {
		return chbSoNbr;
	}

	public void setChbSoNbr(String chbSoNbr) {
		this.chbSoNbr = chbSoNbr;
	}

	public String getChbSts() {
		return chbSts;
	}

	public void setChbSts(String chbSts) {
		this.chbSts = chbSts;
	}

	public String getChbStsDate() {
		return chbStsDate;
	}

	public void setChbStsDate(String chbStsDate) {
		this.chbStsDate = chbStsDate;
	}

	public String getChbUserName() {
		return chbUserName;
	}

	public void setChbUserName(String chbUserName) {
		this.chbUserName = chbUserName;
	}

	public String getChbWoId() {
		return chbWoId;
	}

	public void setChbWoId(String chbWoId) {
		this.chbWoId = chbWoId;
	}

	public String getChbWorkAreaId() {
		return chbWorkAreaId;
	}

	public void setChbWorkAreaId(String chbWorkAreaId) {
		this.chbWorkAreaId = chbWorkAreaId;
	}

	public String getChbWoType() {
		return chbWoType;
	}

	public void setChbWoType(String chbWoType) {
		this.chbWoType = chbWoType;
	}

	public String getProdIdList() {
		return prodIdList;
	}

	public void setProdIdList(String prodIdList) {
		this.prodIdList = prodIdList;
	}

	public String getProdNameList() {
		return prodNameList;
	}

	public void setProdNameList(String prodNameList) {
		this.prodNameList = prodNameList;
	}

	public String getChgServSpecIdList() {
		return chgServSpecIdList;
	}

	public void setChgServSpecIdList(String chgServSpecIdList) {
		this.chgServSpecIdList = chgServSpecIdList;
	}

	public String getChgServSpecNameList() {
		return chgServSpecNameList;
	}

	public void setChgServSpecNameList(String chgServSpecNameList) {
		this.chgServSpecNameList = chgServSpecNameList;
	}

	public String getChbChgServSpecIdList() {
		return chbChgServSpecIdList;
	}

	public void setChbChgServSpecIdList(String chbChgServSpecIdList) {
		this.chbChgServSpecIdList = chbChgServSpecIdList;
	}

	public String getChbExchIdList() {
		return chbExchIdList;
	}

	public void setChbExchIdList(String chbExchIdList) {
		this.chbExchIdList = chbExchIdList;
	}

	public String getExchIdList() {
		return exchIdList;
	}

	public void setExchIdList(String exchIdList) {
		this.exchIdList = exchIdList;
	}

	public String getExchNameList() {
		return exchNameList;
	}

	public void setExchNameList(String exchNameList) {
		this.exchNameList = exchNameList;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getChbActTypeId() {
		return chbActTypeId;
	}

	public void setChbActTypeId(String chbActTypeId) {
		this.chbActTypeId = chbActTypeId;
	}

	public List getTabHandleCustomList() {
		return tabHandleCustomList;
	}

	public void setTabHandleCustomList(List tabHandleCustomList) {
		this.tabHandleCustomList = tabHandleCustomList;
	}

	public Date getFromAsgnDate() {
		return fromAsgnDate;
	}

	public void setFromAsgnDate(Date fromAsgnDate) {
		this.fromAsgnDate = fromAsgnDate;
	}

	public Date getFromSoDate() {
		return fromSoDate;
	}

	public void setFromSoDate(Date fromSoDate) {
		this.fromSoDate = fromSoDate;
	}

	public Date getToAsgnDate() {
		return toAsgnDate;
	}

	public void setToAsgnDate(Date toAsgnDate) {
		this.toAsgnDate = toAsgnDate;
	}

	public Date getToSoDate() {
		return toSoDate;
	}

	public void setToSoDate(Date toSoDate) {
		this.toSoDate = toSoDate;
	}

	public String getChbAsgnDate() {
		return chbAsgnDate;
	}

	public void setChbAsgnDate(String chbAsgnDate) {
		this.chbAsgnDate = chbAsgnDate;
	}

	public String getChbSoDate() {
		return chbSoDate;
	}

	public void setChbSoDate(String chbSoDate) {
		this.chbSoDate = chbSoDate;
	}

	public Date getFromBusiStsDate() {
		return fromBusiStsDate;
	}

	public void setFromBusiStsDate(Date fromBusiStsDate) {
		this.fromBusiStsDate = fromBusiStsDate;
	}

	public Date getFromRunStsDate() {
		return fromRunStsDate;
	}

	public void setFromRunStsDate(Date fromRunStsDate) {
		this.fromRunStsDate = fromRunStsDate;
	}

	public Date getToBusiStsDate() {
		return toBusiStsDate;
	}

	public void setToBusiStsDate(Date toBusiStsDate) {
		this.toBusiStsDate = toBusiStsDate;
	}

	public Date getToRunStsDate() {
		return toRunStsDate;
	}

	public void setToRunStsDate(Date toRunStsDate) {
		this.toRunStsDate = toRunStsDate;
	}

	public String getChbBusiStsDate() {
		return chbBusiStsDate;
	}

	public void setChbBusiStsDate(String chbBusiStsDate) {
		this.chbBusiStsDate = chbBusiStsDate;
	}

	public String getChbRunStsDate() {
		return chbRunStsDate;
	}

	public void setChbRunStsDate(String chbRunStsDate) {
		this.chbRunStsDate = chbRunStsDate;
	}

	public String getBusiSts() {
		return busiSts;
	}

	public void setBusiSts(String busiSts) {
		this.busiSts = busiSts;
	}

	public String getRunSts() {
		return runSts;
	}

	public void setRunSts(String runSts) {
		this.runSts = runSts;
	}

	public String getChbBusiSts() {
		return chbBusiSts;
	}

	public void setChbBusiSts(String chbBusiSts) {
		this.chbBusiSts = chbBusiSts;
	}

	public String getChbRunSts() {
		return chbRunSts;
	}

	public void setChbRunSts(String chbRunSts) {
		this.chbRunSts = chbRunSts;
	}

	public String getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(String bookFlag) {
		this.bookFlag = bookFlag;
	}

	public String getChbBookFlag() {
		return chbBookFlag;
	}

	public void setChbBookFlag(String chbBookFlag) {
		this.chbBookFlag = chbBookFlag;
	}

	public String getChbHis() {
		return chbHis;
	}

	public void setChbHis(String chbHis) {
		this.chbHis = chbHis;
	}

	public String getChbStep() {
		return chbStep;
	}

	public void setChbStep(String chbStep) {
		this.chbStep = chbStep;
	}

	public String getFlagCheckChgServSpec() {
		return flagCheckChgServSpec;
	}

	public void setFlagCheckChgServSpec(String flagCheckChgServSpec) {
		this.flagCheckChgServSpec = flagCheckChgServSpec;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getNsoNbr() {
		return nsoNbr;
	}

	public void setNsoNbr(String nsoNbr) {
		this.nsoNbr = nsoNbr;
	}

	public String getChbDealFlag() {
		return chbDealFlag;
	}

	public void setChbDealFlag(String chbDealFlag) {
		this.chbDealFlag = chbDealFlag;
	}

	public String getChbWorkMode() {
		return chbWorkMode;
	}

	public void setChbWorkMode(String chbWorkMode) {
		this.chbWorkMode = chbWorkMode;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public String getWorkMode() {
		return workMode;
	}

	public void setWorkMode(String workMode) {
		this.workMode = workMode;
	}

	public String getChbNsoNbr() {
		return chbNsoNbr;
	}

	public void setChbNsoNbr(String chbNsoNbr) {
		this.chbNsoNbr = chbNsoNbr;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getForScene() {
		return forScene;
	}

	public void setForScene(String forScene) {
		this.forScene = forScene;
	}

	public String getChbExtSoNbr() {
		return chbExtSoNbr;
	}

	public void setChbExtSoNbr(String chbExtSoNbr) {
		this.chbExtSoNbr = chbExtSoNbr;
	}

	public String getExtSoNbr() {
		return extSoNbr;
	}

	public void setExtSoNbr(String extSoNbr) {
		this.extSoNbr = extSoNbr;
	}

	public String getChbOverTimeReasonId() {
		return chbOverTimeReasonId;
	}

	public void setChbOverTimeReasonId(String chbOverTimeReasonId) {
		this.chbOverTimeReasonId = chbOverTimeReasonId;
	}

	public String getOverTimeReasonId() {
		return overTimeReasonId;
	}

	public void setOverTimeReasonId(String overTimeReasonId) {
		this.overTimeReasonId = overTimeReasonId;
	}

	public String getChbDate() {
		return chbDate;
	}

	public void setChbDate(String chbDate) {
		this.chbDate = chbDate;
	}

	public List getTabColumnList() {
		return tabColumnList;
	}

	public void setTabColumnList(List tabColumnList) {
		this.tabColumnList = tabColumnList;
	}

	public int getBookDueTime() {
		return bookDueTime;
	}

	public void setBookDueTime(int bookDueTime) {
		this.bookDueTime = bookDueTime;
	}

	public String getCoNbr() {
		return coNbr;
	}

	public void setCoNbr(String coNbr) {
		this.coNbr = coNbr;
	}

	public String getChbCoNbr() {
		return chbCoNbr;
	}

	public void setChbCoNbr(String chbCoNbr) {
		this.chbCoNbr = chbCoNbr;
	}

	public String getIsExportExcel() {
		return isExportExcel;
	}

	public void setIsExportExcel(String isExportExcel) {
		this.isExportExcel = isExportExcel;
	}

	public String getShareLineNbr() {
		return shareLineNbr;
	}

	public void setShareLineNbr(String shareLineNbr) {
		this.shareLineNbr = shareLineNbr;
	}

	public String getChbShareLineNbr() {
		return chbShareLineNbr;
	}

	public void setChbShareLineNbr(String chbShareLineNbr) {
		this.chbShareLineNbr = chbShareLineNbr;
	}

	public String getWoTypeNameList() {
		return woTypeNameList;
	}

	public void setWoTypeNameList(String woTypeNameList) {
		this.woTypeNameList = woTypeNameList;
	}

	public String getWoTypeList() {
		return woTypeList;
	}

	public void setWoTypeList(String woTypeList) {
		this.woTypeList = woTypeList;
	}

	public String getActTypeNameList() {
		return actTypeNameList;
	}

	public void setActTypeNameList(String actTypeNameList) {
		this.actTypeNameList = actTypeNameList;
	}

	public String getActTypeList() {
		return actTypeList;
	}

	public void setActTypeList(String actTypeList) {
		this.actTypeList = actTypeList;
	}

	public String getChbPhyAccNbr() {
		return chbPhyAccNbr;
	}

	public void setChbPhyAccNbr(String chbPhyAccNbr) {
		this.chbPhyAccNbr = chbPhyAccNbr;
	}

	public String getPhyAccNbr() {
		return phyAccNbr;
	}

	public void setPhyAccNbr(String phyAccNbr) {
		this.phyAccNbr = phyAccNbr;
	}

	public String getChbMtAreaId() {
		return chbMtAreaId;
	}

	public void setChbMtAreaId(String chbMtAreaId) {
		this.chbMtAreaId = chbMtAreaId;
	}

	public String getMtAreaId() {
		return mtAreaId;
	}

	public void setMtAreaId(String mtAreaId) {
		this.mtAreaId = mtAreaId;
	}

	public String getChbCheckRange() {
		return chbCheckRange;
	}

	public void setChbCheckRange(String chbCheckRange) {
		this.chbCheckRange = chbCheckRange;
	}

	public String getCheckRange() {
		return checkRange;
	}

	public void setCheckRange(String checkRange) {
		this.checkRange = checkRange;
	}

	public String getChbCheck() {
		return chbCheck;
	}

	public void setChbCheck(String chbCheck) {
		this.chbCheck = chbCheck;
	}

	public String getSubProdNameList() {
		return subProdNameList;
	}

	public void setSubProdNameList(String subProdNameList) {
		this.subProdNameList = subProdNameList;
	}

	public String getSubProdIdList() {
		return subProdIdList;
	}

	public void setSubProdIdList(String subProdIdList) {
		this.subProdIdList = subProdIdList;
	}

	public String getChbSoSts() {
		return chbSoSts;
	}

	public void setChbSoSts(String chbSoSts) {
		this.chbSoSts = chbSoSts;
	}

	public String getSoSts() {
		return soSts;
	}

	public void setSoSts(String soSts) {
		this.soSts = soSts;
	}

	public String getWoManageReason() {
		return woManageReason;
	}

	public void setWoManageReason(String woManageReason) {
		this.woManageReason = woManageReason;
	}

	public String getPageCodeId() {
		return pageCodeId;
	}

	public void setPageCodeId(String pageCodeId) {
		this.pageCodeId = pageCodeId;
	}

	public String getQryFlag() {
		return qryFlag;
	}

	public void setQryFlag(String qryFlag) {
		this.qryFlag = qryFlag;
	}

	public String getChbSoType() {
		return chbSoType;
	}

	public void setChbSoType(String chbSoType) {
		this.chbSoType = chbSoType;
	}

	public String getSoTypeNameList() {
		return soTypeNameList;
	}

	public void setSoTypeNameList(String soTypeNameList) {
		this.soTypeNameList = soTypeNameList;
	}

	public String getSoTypeList() {
		return soTypeList;
	}

	public void setSoTypeList(String soTypeList) {
		this.soTypeList = soTypeList;
	}

	public String getChbStaffId() {
		return chbStaffId;
	}

	public void setChbStaffId(String chbStaffId) {
		this.chbStaffId = chbStaffId;
	}

	public String getSoType() {
		return soType;
	}

	public void setSoType(String soType) {
		this.soType = soType;
	}

	public String getWoNbr() {
		return woNbr;
	}

	public void setWoNbr(String woNbr) {
		this.woNbr = woNbr;
	}

	public String getNotifyNbr() {
		return notifyNbr;
	}

	public void setNotifyNbr(String notifyNbr) {
		this.notifyNbr = notifyNbr;
	}

	public String getWorkStaffId() {
		return workStaffId;
	}

	public void setWorkStaffId(String workStaffId) {
		this.workStaffId = workStaffId;
	}

	public String getCurWoStaffId() {
		return curWoStaffId;
	}

	public void setCurWoStaffId(String curWoStaffId) {
		this.curWoStaffId = curWoStaffId;
	}

	public String getHisFlag() {
		return hisFlag;
	}

	public void setHisFlag(String hisFlag) {
		this.hisFlag = hisFlag;
	}

	public String getAddrInfo() {
		return AddrInfo;
	}

	public void setAddrInfo(String addrInfo) {
		AddrInfo = addrInfo;
	}

	public String getDutyFlag() {
		return dutyFlag;
	}

	public void setDutyFlag(String dutyFlag) {
		this.dutyFlag = dutyFlag;
	}

	public String getChbAddrInfo() {
		return chbAddrInfo;
	}

	public void setChbAddrInfo(String chbAddrInfo) {
		this.chbAddrInfo = chbAddrInfo;
	}

	public String getChbDutyFlag() {
		return chbDutyFlag;
	}

	public void setChbDutyFlag(String chbDutyFlag) {
		this.chbDutyFlag = chbDutyFlag;
	}

	public String getPwcNbr() {
		return pwcNbr;
	}

	public void setPwcNbr(String pwcNbr) {
		this.pwcNbr = pwcNbr;
	}

	public String getPwcSpeed() {
		return pwcSpeed;
	}

	public void setPwcSpeed(String pwcSpeed) {
		this.pwcSpeed = pwcSpeed;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getLastsize() {
		return lastsize;
	}

	public void setLastsize(int lastsize) {
		this.lastsize = lastsize;
	}

	

}
