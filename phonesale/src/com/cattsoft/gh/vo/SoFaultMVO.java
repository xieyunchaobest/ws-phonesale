package com.cattsoft.gh.vo;

import java.util.Date;
import java.util.List;

import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;

public class SoFaultMVO extends SoFaultSVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accNbr;
	private String woNbr=null;	
	private String faultDateStr;
	private String stsDateStr;
	private String custName;
	private String soSts;
	private String addrInfo;
	//��ϵ��
	private String contactName;
	//��ϵ��Ϣ
	private String contactInfo;
	//���ù�������
	private String faultDescId;
	//������������
	private String faultPhenomName;
	//���ϵȼ�����
	private String faultLevelName;
	private String chFaultLevelId;
	//������������
	private String faultTypeName;
	private String chFaultTyptId;
	
	private String chFaultTypeId;
	
	private String detailAddr;
	
	private String deviceId;

	//��Ʒ���
	private String prodCatName;
	
	//add by baixd 2009-09-28    start
	private String chProdCatId;
	
	//���ϵ�����
	private String chSoFaultId;
	
	//��������
	private String chSoNbr;
	
	//�������
	private String chSoSeq;
	
	//�ϰ�����
	private String chTopic;
	
	//�ϰ��������
	private String faultCatName;
	private String chFaultCat;
	private List   faultCatList;
	//����ʱ��
	private String chFaultDate;
	private Date fromFaultDate;
	private Date toFaultDate;
	
	//������Դ����
	private String resSystemName;
	//private String resSystem;
	private String chResSystem;
	
	//�ϱ���־
	private String reportFlagName;
	
	
	
	//�������
	private String refFlagName;
	
	//�򵥲�ѯ������
	private String localNetIdSimp;
	private String chbLocalNetIdSimp;
	
	//����������
	private String localNetName;
	//������
	private String areas;
	
	// Ӫά����
	private String servDeptId;

	public String getServDeptId() {
		return servDeptId;
	}
	public void setServDeptId(String servDeptId) {
		this.servDeptId = servDeptId;
	}
	public String getExchId() {
		return exchId;
	}
	public void setExchId(String exchId) {
		this.exchId = exchId;
	}
	// ����
	private String exchId;

	
	//	��ǰ��¼�û�
	private String staffId = null;
	
	private String forScene;
	
	private String quickQueryCondition;
	
//	add by baixd 2009-09-28    end
	
	private String [] soFaultIdArr;
	
	public String[] getSoFaultIdArr() {
		return soFaultIdArr;
	}
	public void setSoFaultIdArr(String[] soFaultIdArr) {
		this.soFaultIdArr = soFaultIdArr;
	}
	public String getForScene() {
		return forScene;
	}
	public void setForScene(String forScene) {
		this.forScene = forScene;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getLocalNetName() {
		return localNetName;
	}
	public void setLocalNetName(String localNetName) {
		this.localNetName = localNetName;
	}
	public String getProdCatName() {
		return prodCatName;
	}
	public void setProdCatName(String prodCatName) {
		this.prodCatName = prodCatName;
	}
	public String getFaultLevelName() {
		return faultLevelName;
	}
	public void setFaultLevelName(String faultLevelName) {
		this.faultLevelName = faultLevelName;
	}
	public String getFaultTypeName() {
		return faultTypeName;
	}
	public void setFaultTypeName(String faultTypeName) {
		this.faultTypeName = faultTypeName;
	}
	public String getFaultPhenomName() {
		return faultPhenomName;
	}
	public void setFaultPhenomName(String faultPhenomName) {
		this.faultPhenomName = faultPhenomName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getSoSts() {
		return soSts;
	}
	public void setSoSts(String soSts) {
		this.soSts = soSts;
	}
	
	public String getFaultDateStr(){
		return faultDateStr;
	}
	
	public void setFaultDateStr(String faultDateStr){
		this.faultDateStr = faultDateStr;
	}
	//	����ʱ��	
	public String getFromFaultDateTimeStr() {
		String str = "";
		if( null != this.fromFaultDate){
			str = DateUtil.to_char(fromFaultDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}
	
	public void setFromFaultDateTimeStr(String faultDateStr) throws SysException{
		if( ! StringUtil.isBlank(faultDateStr)){
			this.fromFaultDate = DateUtil.to_date(faultDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.faultDateStr = null;
	}
	
	public String getToFaultDateTimeStr() {
		String str = "";
		if( null != this.toFaultDate){
			str = DateUtil.to_char(toFaultDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}
	
	public void setToFaultDateTimeStr(String faultDateStr) throws SysException{
		if( ! StringUtil.isBlank(faultDateStr)){
			this.toFaultDate = DateUtil.to_date(faultDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.faultDateStr = null;
	}
	
	public String getStsDateStr() {
		return stsDateStr;
	}
	public void setStsDateStr(String stsDateStr)  {
		this.stsDateStr = stsDateStr;
	}
	public String getAccNbr() {
		return accNbr;
	}
	public void setAccNbr(String accNbr) {
		this.accNbr = accNbr;
	}
	public String getFaultDescId() {
		return faultDescId;
	}
	public void setFaultDescId(String faultDescId) {
		this.faultDescId = faultDescId;
	}

	public String getChbLocalNetIdSimp() {
		return chbLocalNetIdSimp;
	}
	public void setChbLocalNetIdSimp(String chbLocalNetIdSimp) {
		this.chbLocalNetIdSimp = chbLocalNetIdSimp;
	}
	public String getFaultCatName() {
		return faultCatName;
	}
	public void setFaultCatName(String faultCatName) {
		this.faultCatName = faultCatName;
	}
	public String getRefFlagName() {
		return refFlagName;
	}
	public void setRefFlagName(String refFlagName) {
		this.refFlagName = refFlagName;
	}
	public String getReportFlagName() {
		return reportFlagName;
	}
	public void setReportFlagName(String reportFlagName) {
		this.reportFlagName = reportFlagName;
	}
	public String getResSystemName() {
		return resSystemName;
	}
	public void setResSystemName(String resSystemName) {
		this.resSystemName = resSystemName;
	}
	public String getLocalNetIdSimp() {
		return localNetIdSimp;
	}
	public void setLocalNetIdSimp(String localNetIdSimp) {
		this.localNetIdSimp = localNetIdSimp;
	}
	public String getChProdCatId() {
		return chProdCatId;
	}
	public void setChProdCatId(String chProdCatId) {
		this.chProdCatId = chProdCatId;
	}
	public String getChSoNbr() {
		return chSoNbr;
	}
	public void setChSoNbr(String chSoNbr) {
		this.chSoNbr = chSoNbr;
	}
	public String getChSoSeq() {
		return chSoSeq;
	}
	public void setChSoSeq(String chSoSeq) {
		this.chSoSeq = chSoSeq;
	}
	public String getChSoFaultId() {
		return chSoFaultId;
	}
	public void setChSoFaultId(String chSoFaultId) {
		this.chSoFaultId = chSoFaultId;
	}
	public String getChFaultCat() {
		return chFaultCat;
	}
	public void setChFaultCat(String chFaultCat) {
		this.chFaultCat = chFaultCat;
	}
	
	public String getQuickQueryCondition() {
		return quickQueryCondition;
	}
	public void setQuickQueryCondition(String quickQueryCondition) {
		this.quickQueryCondition = quickQueryCondition;
	}
	public String getChTopic() {
		return chTopic;
	}
	public void setChTopic(String chTopic) {
		this.chTopic = chTopic;
	}
	public String getChFaultLevelId() {
		return chFaultLevelId;
	}
	public void setChFaultLevelId(String chFaultLevelId) {
		this.chFaultLevelId = chFaultLevelId;
	}
	public String getChResSystem() {
		return chResSystem;
	}
	public void setChResSystem(String chResSystem) {
		this.chResSystem = chResSystem;
	}
	public String getChFaultTyptId() {
		return chFaultTyptId;
	}
	public void setChFaultTyptId(String chFaultTyptId) {
		this.chFaultTyptId = chFaultTyptId;
	}
	public Date getFromFaultDate() {
		return fromFaultDate;
	}
	public void setFromFaultDate(Date fromFaultDate) {
		this.fromFaultDate = fromFaultDate;
	}
	public Date getToFaultDate() {
		return toFaultDate;
	}
	public void setToFaultDate(Date toFaultDate) {
		this.toFaultDate = toFaultDate;
	}
	public String getChFaultDate() {
		return chFaultDate;
	}
	public void setChFaultDate(String chFaultDate) {
		this.chFaultDate = chFaultDate;
	}
	public List getFaultCatList() {
		return faultCatList;
	}
	public void setFaultCatList(List faultCatList) {
		this.faultCatList = faultCatList;
	}
	public String getAreas() {
		return areas;
	}
	public void setAreas(String areas) {
		this.areas = areas;
	}
	public String getAddrInfo() {
		return addrInfo;
	}
	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getChFaultTypeId() {
		return chFaultTypeId;
	}
	public void setChFaultTypeId(String chFaultTypeId) {
		this.chFaultTypeId = chFaultTypeId;
	}
	public String getWoNbr() {
		return woNbr;
	}
	public void setWoNbr(String woNbr) {
		this.woNbr = woNbr;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
