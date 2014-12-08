package com.cattsoft.sm.vo;

import com.cattsoft.pub.vo.GenericVO;

/**
 * ��������Ŀͻ���Ϣ����ͨ�����²�ѯ��Ϣ�������ڱ�Ŀͻ� <br>
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-29 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author zhouqian
 */

public class QryBasicCustInfoMVO extends GenericVO {

    private static final long serialVersionUID = 1L;

    // �ͻ����
    private String custId;

    // �ͻ�����
    private String custName;

    // �ͻ�֤����
    private String certCode;

    // �ͻ�֤������
    private String certType;

    // �ͻ�����
    private String custType;

    // �ͻ���ҵ
    private String custVoca;

    // �ͻ�����
    private String custLevel;

    // ���������
    private String areaId;

    // ���������ƣ�����������������������������������DAO�в�δȡ����������DataCache��ȡ��
    private String areaName;

    /** add by zhangchao as follows* */

    // �ͻ����
    private String custSeq;

    // ֤������ID
    private String certTypeId;

    // �ͻ���ҵID
    private String custVocaId;

    // �ͻ�����ID
    private String custTypeId;

    // �ͻ�����ID
    private String partyType;

    // �ͻ�����Id
    private String custLevelId;

    // �ͻ����ڱ�����
    private String localNetId;
    
    /** ���������Ǹ��������(�ͻ����ϼ��ͻ�) */
    //�����˱��
    private String partyId;
    
    //�ϼ��ͻ����
    private String parentCustId;
    
    //�ϼ��ͻ�����
    private String parentCustName;

    public String getParentCustId() {
        return parentCustId;
    }

    public void setParentCustId(String parentCustId) {
        this.parentCustId = parentCustId;
    }

    public String getParentCustName() {
        return parentCustName;
    }

    public void setParentCustName(String parentCustName) {
        this.parentCustName = parentCustName;
    }

    public String getLocalNetId() {
        return localNetId;
    }

    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
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

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustVoca() {
        return custVoca;
    }

    public void setCustVoca(String custVoca) {
        this.custVoca = custVoca;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCertTypeId() {
        return certTypeId;
    }

    public void setCertTypeId(String certTypeId) {
        this.certTypeId = certTypeId;
    }

    public String getCustSeq() {
        return custSeq;
    }

    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getCustTypeId() {
        return custTypeId;
    }

    public void setCustTypeId(String custTypeId) {
        this.custTypeId = custTypeId;
    }

    public String getCustVocaId() {
        return custVocaId;
    }

    public void setCustVocaId(String custVocaId) {
        this.custVocaId = custVocaId;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

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

    public String getCustLevelId() {
        return custLevelId;
    }

    public void setCustLevelId(String custLevelId) {
        this.custLevelId = custLevelId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

}