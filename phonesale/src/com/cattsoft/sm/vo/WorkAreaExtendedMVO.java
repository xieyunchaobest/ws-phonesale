package com.cattsoft.sm.vo;

import java.sql.Date;

import com.cattsoft.pub.vo.GenericVO;

public class WorkAreaExtendedMVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    private String workAreaId;

    private String name;

    private String workTypeId;

    private String localNetId;

    /**
     * ��ǰ��¼Ա����������������������
     */
    private String localNetName;

    /**
     * ��ǰ��½Ա�������������������Ƿ�Ϊ���ı�����
     */

    private String localNetIscenter;

    private String areaId;

    /**
     * ��ǰ��¼Ա����������������������
     */
    private String areaName;

    /**
     * ��ǰ��¼Ա�������������������Ƿ�Ϊ���ķ�����
     */
    private String areaIscenter;

    private String servDeptId;

    /**
     * ��ǰ��¼Ա������������Ӫά��������
     */
    private String servDeptName;

    private String branchId;

    /**
     * ��ǰ��¼Ա������������֧������
     */
    private String branchName;

    private String dispatchLevel;

    private String parentWorkAreaId;

    private String standardCode;

    private String sts;

    private Date stsDate;

    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDispatchLevel() {
        return dispatchLevel;
    }

    public void setDispatchLevel(String dispatchLevel) {
        this.dispatchLevel = dispatchLevel;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentWorkAreaId() {
        return parentWorkAreaId;
    }

    public void setParentWorkAreaId(String parentWorkAreaId) {
        this.parentWorkAreaId = parentWorkAreaId;
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

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public Date getStsDate() {
        return stsDate;
    }

    public void setStsDate(Date stsDate) {
        this.stsDate = stsDate;
    }

    public String getWorkAreaId() {
        return workAreaId;
    }

    public void setWorkAreaId(String workAreaId) {
        this.workAreaId = workAreaId;
    }

    public String getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(String workTypeId) {
        this.workTypeId = workTypeId;
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