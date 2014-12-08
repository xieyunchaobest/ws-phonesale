package com.cattsoft.sm.vo;

import java.sql.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-26 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class StaffMVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    private PartySVO partySVO = new PartySVO();

    private StaffSVO staffSVO = new StaffSVO();
    
    private String localNetName;
    
    private String areaName;
    
    private String staff112;//��Ӧ112ϵͳ�Ĺ���

    private String deptName;

    private String deptType;

    private String deptSts;

    private Date deptStsDate;

    private String certCode;

    private String certTypeId;

    private String contactAddr;

    private String postalCode;

    private Date certExpDate;

    private String contactId;

    private String partyIdentityId;
    
    private String  sysUserId;//Ĭ�ϴ���
    
    private String passWord;//Ĭ������
    
    private String partyRoleType;
    
    private String sysUserName;//��¼��
    
    //�Ƿ���Ϊ���˶���
    private String isCheckObj;
    //���˱�ʶ
    private String performanceId;
    //����ָ��
    private String performanceIndexId;
    //���˶���
    private String checkObjectId;
    //������
    private String checkStaffId;
    //�Ƿ����ÿ�����/������
    private String isCheckStaff;
    //������ Ȩ��
    private String power;
    //�����˼�¼��ʶ
    private String checkerId;
    //���˶����¼��ʶ
    private String performanceCheckObjId;

    public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getPartyRoleType() {
        return partyRoleType;
    }

    public void setPartyRoleType(String partyRoleType) {
        this.partyRoleType = partyRoleType;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public StaffSVO getStaffSVO() {
        return staffSVO;
    }

    public void setStaffSVO(StaffSVO staffSVO) {
        this.staffSVO = staffSVO;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public Date getCertExpDate() {
        return certExpDate;
    }

    public void setCertExpDate(Date certExpDate) {
        this.certExpDate = certExpDate;
    }

    public String getCertTypeId() {
        return certTypeId;
    }

    public void setCertTypeId(String certTypeId) {
        this.certTypeId = certTypeId;
    }

    public String getContactAddr() {
        return contactAddr;
    }

    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptSts() {
        return deptSts;
    }

    public void setDeptSts(String deptSts) {
        this.deptSts = deptSts;
    }

    public Date getDeptStsDate() {
        return deptStsDate;
    }

    public void setDeptStsDate(Date deptStsDate) {
        this.deptStsDate = deptStsDate;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getPartyIdentityId() {
        return partyIdentityId;
    }

    public String getPerformanceCheckObjId() {
		return performanceCheckObjId;
	}

	public void setPerformanceCheckObjId(String performanceCheckObjId) {
		this.performanceCheckObjId = performanceCheckObjId;
	}

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getIsCheckStaff() {
		return isCheckStaff;
	}

	public void setIsCheckStaff(String isCheckStaff) {
		this.isCheckStaff = isCheckStaff;
	}

	public String getCheckObjectId() {
		return checkObjectId;
	}

	public void setCheckObjectId(String checkObjectId) {
		this.checkObjectId = checkObjectId;
	}

	public String getCheckStaffId() {
		return checkStaffId;
	}

	public void setCheckStaffId(String checkStaffId) {
		this.checkStaffId = checkStaffId;
	}

	public String getPerformanceIndexId() {
		return performanceIndexId;
	}

	public void setPerformanceIndexId(String performanceIndexId) {
		this.performanceIndexId = performanceIndexId;
	}

	public String getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(String performanceId) {
		this.performanceId = performanceId;
	}

	public String getIsCheckObj() {
		return isCheckObj;
	}

	public void setIsCheckObj(String isCheckObj) {
		this.isCheckObj = isCheckObj;
	}

	public void setPartyIdentityId(String partyIdentityId) {
        this.partyIdentityId = partyIdentityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PartySVO getPartySVO() {
        return partySVO;
    }

    public void setPartySVO(PartySVO partySVO) {
        this.partySVO = partySVO;
    }

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getLocalNetName() {
		return localNetName;
	}

	public void setLocalNetName(String localNetName) {
		this.localNetName = localNetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStaff112() {
		return staff112;
	}

	public void setStaff112(String staff112) {
		this.staff112 = staff112;
	}

}
