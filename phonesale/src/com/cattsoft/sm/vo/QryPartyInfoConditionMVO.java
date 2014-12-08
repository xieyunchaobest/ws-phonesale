package com.cattsoft.sm.vo;

import com.cattsoft.pub.vo.GenericVO;

public class QryPartyInfoConditionMVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    /** ���� */
    private String name;

    /** ���� */
    private String partyRoleType;

    /** ֤���� */
    private String certCode;

    /** ֤������ */
    private String certType;

    /** ��������� */
    private String localNetId;

    /** ������ */
    private String areaId;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getLocalNetId() {
        return localNetId;
    }

    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyRoleType() {
        return partyRoleType;
    }

    public void setPartyRoleType(String partyRoleType) {
        this.partyRoleType = partyRoleType;
    }
}