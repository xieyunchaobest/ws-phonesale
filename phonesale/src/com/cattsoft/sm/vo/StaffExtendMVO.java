package com.cattsoft.sm.vo;

import com.cattsoft.pub.vo.GenericVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-26 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class StaffExtendMVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    /**
     * ��ǰ��¼Ա����Ϣ
     */
    private StaffSVO staffSVO = new StaffSVO();

    /**
     * ��ǰ��¼Ա��������ID
     */
    private String partyId;

    /**
     * ��ǰ��¼Ա������������
     */
    private String partyName;

    /**
     * ��ǰ��¼Ա������������������
     */
    private String localNetId;

    /**
     * ��ǰ��¼Ա����������������������
     */
    private String localNetName;

    /**
     * ��ǰ��¼Ա�������������������Ƿ�Ϊ���ı�����
     */
    private String localNetIscenter;

    /**
     * ��ǰ��¼Ա������������������
     */
    private String areaId;

    /**
     * ��ǰ��¼Ա����������������������
     */
    private String areaName;

    /**
     * ��ǰ��¼Ա�������������������Ƿ�Ϊ���ķ�����
     */
    private String areaIscenter;

    /**
     * ��ǰ��¼Ա������������Ӫά����
     */
    private String servDeptId;

    /**
     * ��ǰ��¼Ա������������Ӫά��������
     */
    private String servDeptName;

    /**
     * ��ǰ��¼Ա������������֧��
     */
    private String branchId;

    /**
     * ��ǰ��¼Ա������������֧������
     */
    private String branchName;

    /**
     * ��ǰ��¼Ա��������״̬
     */
    private String partySts;

    /**
     * ��ǰ��¼Ա������������
     */
    private String partyType;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocalNetId() {
        return localNetId;
    }

    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
    }

    public String getLocalNetName() {
        return localNetName;
    }

    public void setLocalNetName(String localNetName) {
        this.localNetName = localNetName;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartySts() {
        return partySts;
    }

    public void setPartySts(String partySts) {
        this.partySts = partySts;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getServDeptId() {
        return servDeptId;
    }

    public void setServDeptId(String servDeptId) {
        this.servDeptId = servDeptId;
    }

    public String getServDeptName() {
        return servDeptName;
    }

    public void setServDeptName(String servDeptName) {
        this.servDeptName = servDeptName;
    }

    public StaffSVO getStaffSVO() {
        return staffSVO;
    }

    public void setStaffSVO(StaffSVO staffSVO) {
        this.staffSVO = staffSVO;
    }

    public String getAreaIscenter() {
        return areaIscenter;
    }

    public void setAreaIscenter(String areaIscenter) {
        this.areaIscenter = areaIscenter;
    }

    public String getLocalNetIscenter() {
        return localNetIscenter;
    }

    public void setLocalNetIscenter(String localNetIscenter) {
        this.localNetIscenter = localNetIscenter;
    }

}
