package com.cattsoft.sm.vo;

import com.cattsoft.pub.vo.GenericVO;

public class QryCustInfoConditionMVO extends GenericVO {
	
    private static final long serialVersionUID = 1L;

    // ���������ѯʱ�Ŀͻ����
    private String custId;

    // �������汾�������
    private String localNetId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getLocalNetId() {
        return localNetId;
    }

    public void setLocalNetId(String localNetId) {
        this.localNetId = localNetId;
    }
}