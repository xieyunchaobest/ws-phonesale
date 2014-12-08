package com.cattsoft.sm.vo;

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
public class SysDeviceSVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    /**
     * ����sysDeviceId ��ʶ ����
     */
    private Long sysDeviceId;

    /**
     * ����sysDeviceName �־û� ����
     */
    private String sysDeviceName;

    /**
     * ����sysDeviceMac �־û� ����
     */
    private String sysDeviceMac;

    /**
     * ����userDevices �־û� ����
     */
    private Set userDevices;

    /**
     * ����loginLogs �־û� ����
     */
    private Set loginLogs;

    /** default constructor */
    public SysDeviceSVO() {
    }

    /**
     * ȡ������sysDeviceId�ķ���
     * 
     * @return Long
     */
    public Long getSysDeviceId() {
        return this.sysDeviceId;
    }

    /**
     * ����sysDeviceId�ķ���
     * 
     * @param Long
     */
    public void setSysDeviceId(Long sysDeviceId) {
        this.sysDeviceId = sysDeviceId;
    }

    /**
     * ȡ������sysDeviceName�ķ���
     * 
     * @return String
     */
    public String getSysDeviceName() {
        return this.sysDeviceName;
    }

    /**
     * ����sysDeviceName�ķ���
     * 
     * @param String
     */
    public void setSysDeviceName(String sysDeviceName) {
        this.sysDeviceName = sysDeviceName;
    }

    /**
     * ȡ������sysDeviceMac�ķ���
     * 
     * @return String
     */
    public String getSysDeviceMac() {
        return this.sysDeviceMac;
    }

    /**
     * ����sysDeviceMac�ķ���
     * 
     * @param String
     */
    public void setSysDeviceMac(String sysDeviceMac) {
        this.sysDeviceMac = sysDeviceMac;
    }

    /**
     * ȡ������userDevices�ķ���
     * 
     * @return Set
     */
    public Set getUserDevices() {
        return this.userDevices;
    }

    /**
     * ����userDevices�ķ���
     * 
     * @param Set
     */
    public void setUserDevices(Set userDevices) {
        this.userDevices = userDevices;
    }

    /**
     * ȡ������loginLogs�ķ���
     * 
     * @return Set
     */
    public Set getLoginLogs() {
        return this.loginLogs;
    }

    /**
     * ����loginLogs�ķ���
     * 
     * @param Set
     */
    public void setLoginLogs(Set loginLogs) {
        this.loginLogs = loginLogs;
    }

}
