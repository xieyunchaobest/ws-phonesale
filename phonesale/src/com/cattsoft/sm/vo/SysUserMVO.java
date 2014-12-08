package com.cattsoft.sm.vo;

import java.sql.Date;
import java.util.Set;

import com.cattsoft.pub.vo.GenericVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-24 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public class SysUserMVO extends GenericVO {
    private static final long serialVersionUID = 1L;

    /**
     * ����sysUserId ��ʶ ����
     */
    private String sysUserId;

    /**
     * ����partyRoleId �־û� ����
     */
    private String partyRoleId;

    /**
     * ����partyRoleTypeId �־û� ����
     */
    private String partyRoleTypeId;

    /**
     * ����sysUserName �־û� ����
     */
    private String sysUserName;

    /**
     * ����password �־û� ����
     */
    private String password;

    /**
     * ����setPwdTime �־û� ����
     */
    private Date setPwdTime;

    /**
     * ����updatePwdTimenullable �־û� ����
     */
    private Date updatePwdTime;

    /**
     * ����lastPwdnullable �־û� ����
     */
    private String lastPwd;

    /**
     * ����createDate �־û� ����
     */
    private Date createDate;

    /**
     * ����sts �־û� ����
     */
    private String sts;

    /**
     * ����stsDate �־û� ����
     */
    private Date stsDate;

    /** ******party���һЩ��Ϣ************** */
    private String partyId;

    private String name;

    private String localNetId;

    private String areaId;

    private String branchId;

    private String servDeptId;

    private String partyType;

    private String partySts;

    private Date partyStsDate;

    /**
     * ����loginLogs �־û� ����
     */
    private Set loginLogs;

    private String loginFlag;

    /** default constructor */
    public SysUserMVO() {
    }

    public String getPartyRoleId() {
        return partyRoleId;
    }

    public void setPartyRoleId(String partyRoleId) {
        this.partyRoleId = partyRoleId;
    }

    public String getPartyRoleTypeId() {
        return partyRoleTypeId;
    }

    public void setPartyRoleTypeId(String partyRoleTypeId) {
        this.partyRoleTypeId = partyRoleTypeId;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * ȡ������sysUserName�ķ���
     * 
     * @return String
     */
    public String getSysUserName() {
        return this.sysUserName;
    }

    /**
     * ����sysUserName�ķ���
     * 
     * @param String
     */
    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    /**
     * ȡ������password�ķ���
     * 
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * ����password�ķ���
     * 
     * @param String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ȡ������setPwdTime�ķ���
     * 
     * @return Date
     */
    public Date getSetPwdTime() {
        return this.setPwdTime;
    }

    /**
     * ����setPwdTime�ķ���
     * 
     * @param Date
     */
    public void setSetPwdTime(Date setPwdTime) {
        this.setPwdTime = setPwdTime;
    }

    /**
     * ȡ������updatePwdTime�ķ���
     * 
     * @return Date
     */
    public Date getUpdatePwdTime() {
        return this.updatePwdTime;
    }

    /**
     * ����updatePwdTime�ķ���
     * 
     * @param Date
     */
    public void setUpdatePwdTime(Date updatePwdTime) {
        this.updatePwdTime = updatePwdTime;
    }

    /**
     * ȡ������lastPwd�ķ���
     * 
     * @return String
     */
    public String getLastPwd() {
        return this.lastPwd;
    }

    /**
     * ����lastPwd�ķ���
     * 
     * @param String
     */
    public void setLastPwd(String lastPwd) {
        this.lastPwd = lastPwd;
    }

    /**
     * ȡ������createDate�ķ���
     * 
     * @return Date
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * ����createDate�ķ���
     * 
     * @param Date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * ȡ������sts�ķ���
     * 
     * @return String
     */
    public String getSts() {
        return this.sts;
    }

    /**
     * ����sts�ķ���
     * 
     * @param String
     */
    public void setSts(String sts) {
        this.sts = sts;
    }

    /**
     * ȡ������stsDate�ķ���
     * 
     * @return Date
     */
    public Date getStsDate() {
        return this.stsDate;
    }

    /**
     * ����stsDate�ķ���
     * 
     * @param Date
     */
    public void setStsDate(Date stsDate) {
        this.stsDate = stsDate;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getLocalNetId() {
        return localNetId;
    }

    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public Set getLoginLogs() {
        return loginLogs;
    }

    public void setLoginLogs(Set loginLogs) {
        this.loginLogs = loginLogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartySts() {
        return partySts;
    }

    public void setPartySts(String partySts) {
        this.partySts = partySts;
    }

    public Date getPartyStsDate() {
        return partyStsDate;
    }

    public void setPartyStsDate(Date partyStsDate) {
        this.partyStsDate = partyStsDate;
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

}
