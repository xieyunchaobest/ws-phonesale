package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;
/**
 * �ն�
 * @author xueweiwei
 *
 */
public class ScanTermailSVO extends GenericVO{

	private String macAddress;//�豸������
    private String StaffId;//�û�id
    private String localNetId;//������
    private String areaId;//������
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getLocalNetId() {
		return localNetId;
	}
	public void setLocalNetId(String localNetId) {
		this.localNetId = localNetId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
