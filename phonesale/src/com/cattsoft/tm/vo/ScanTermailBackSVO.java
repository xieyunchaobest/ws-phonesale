package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;
/**
 * ��ȡ/�˻��ն˷���˷��صĽ��
 * @author xueweiwei
 *
 */
public class ScanTermailBackSVO extends GenericVO{

	private String macAddress;//�ն�����
	private String Flag;//���ɹ�����ʶ
	private String remark;//��ע
	
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
