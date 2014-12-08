package com.cattsoft.sm.vo;

import java.util.List;
import java.util.Map;

import com.cattsoft.pub.vo.GenericVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-24 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public class SysUserExtendedMVO extends GenericVO {

    private static final long serialVersionUID = 1L;

    /**
     * VO��session�е���������
     */
    public final static String SESSION_NAME = "sysUserVOExtended";

    /**
     * ��ǰ�û���SysUserMVO
     */
    private SysUserSVO sysUserSVO;

    /**
     * ��ǰ�û������ʵ���ϵͳ
     */
    private String userSubSystems;

    /**
     * ��ǰ�û���Ӧ��Ա��VO
     */
    private StaffExtendMVO staffExtendMVO;

    /**
     * ��ǰ�û��ɷ��ʵ����й���
     */
    private List staffWorkAreas;

    /**
     * ��ǰ�û������ʵĹ���
     */
    private WorkAreaMVO currentWorkAreaVO;

    /**
     * ��ǰ�û��ɷ��ʵ����й��ܵ�
     */
    private List funcNodeAll;

    /**
     * ��ǰ��¼��־
     */
    private LoginLogSVO loginLogVO;

    /**
     * ��ǰ��¼��־ģʽ
     */
    private int loginMode;

    /**
     * ��ǰ�û�ʧЧ
     */
    private int userValid;

    /**
     * ��ʼ��¼
     */
    private int firstFlag;

    /**
     * ����ʧЧ
     */
    private int passwordValid;

    /**
     * �������ʧЧ����
     */
    private String passwordDay;

    /**
     * ��ǰ��¼��־ID
     */
    private String LoginId;

    /**
     * 
     * �������ļ��ϣ�ֻ��Ϊ�˷���Ӻ�̨�ѹ������������ȡ����actionʹ�ã�����������ݱ��浽ҳ���ϣ�
     */
    private List funcNodeTreeVOs;

    /**
     * �û���ǰ���ʵĹ��ܵ�id
     */
    private String curFuncNodeId;

    /**
     * �û���ǰ���ʵĹ��ܵ�����
     * 
     */
    private String curFuncNodeName; 
    //�û��ܷ��ʵ�ϵͳȨ��
    private String permissAppStr;
    
    private String appInfoURLStr;
    
    private String defaultApp;
    
    //�Ƿ�Ĭ��ϵͳ
    private String flag;
    
    public String getCurFuncNodeName() {
        return curFuncNodeName;
    }

    public void setCurFuncNodeName(String curFuncNodeName) {
        this.curFuncNodeName = curFuncNodeName;
    }

    public List getFuncNodeTreeVOs() {
        return funcNodeTreeVOs;
    }

    public void setFuncNodeTreeVOs(List funcNodeTreeVOs) {
        this.funcNodeTreeVOs = funcNodeTreeVOs;
    }

    public WorkAreaMVO getCurrentWorkAreaVO() {
        return currentWorkAreaVO;
    }

    public void setCurrentWorkAreaVO(WorkAreaMVO currentWorkAreaVO) {
        this.currentWorkAreaVO = currentWorkAreaVO;
    }

    public int getFirstFlag() {
        return firstFlag;
    }

    public void setFirstFlag(int firstFlag) {
        this.firstFlag = firstFlag;
    }

    public List getFuncNodeAll() {
        return funcNodeAll;
    }

    public void setFuncNodeAll(List funcNodeAll) {
        this.funcNodeAll = funcNodeAll;
    }

    public String getLoginId() {
        return LoginId;
    }

    public void setLoginId(String loginId) {
        LoginId = loginId;
    }

    public LoginLogSVO getLoginLogVO() {
        return loginLogVO;
    }

    public void setLoginLogVO(LoginLogSVO loginLogVO) {
        this.loginLogVO = loginLogVO;
    }

    public int getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(int loginMode) {
        this.loginMode = loginMode;
    }

    public int getPasswordValid() {
        return passwordValid;
    }

    public void setPasswordValid(int passwordValid) {
        this.passwordValid = passwordValid;
    }

    public StaffExtendMVO getStaffExtendMVO() {
        return staffExtendMVO;
    }

    public void setStaffExtendMVO(StaffExtendMVO staffExtendMVO) {
        this.staffExtendMVO = staffExtendMVO;
    }

    public List getStaffWorkAreas() {
        return staffWorkAreas;
    }

    public void setStaffWorkAreas(List staffWorkAreas) {
        this.staffWorkAreas = staffWorkAreas;
    }

    public SysUserSVO getSysUserSVO() {
        return sysUserSVO;
    }

    public void setSysUserSVO(SysUserSVO sysUserSVO) {
        this.sysUserSVO = sysUserSVO;
    }

    public String getUserSubSystems() {
        return userSubSystems;
    }

    public void setUserSubSystems(String userSubSystems) {
        this.userSubSystems = userSubSystems;
    }

    public int getUserValid() {
        return userValid;
    }

    public void setUserValid(int userValid) {
        this.userValid = userValid;
    }

    public String getCurFuncNodeId() {
        return curFuncNodeId;
    }

    public void setCurFuncNodeId(String curFuncNodeId) {
        this.curFuncNodeId = curFuncNodeId;
    }

    public String getPasswordDay() {
        return passwordDay;
    }

    public void setPasswordDay(String passwordDay) {
        this.passwordDay = passwordDay;
    }

	public String getAppInfoURLStr() {
		return appInfoURLStr;
	}

	public void setAppInfoURLStr(String appInfoURLStr) {
		this.appInfoURLStr = appInfoURLStr;
	}

	public String getPermissAppStr() {
		return permissAppStr;
	}

	public void setPermissAppStr(String permissAppStr) {
		this.permissAppStr = permissAppStr;
	}

	public String getDefaultApp() {
		return defaultApp;
	}

	public void setDefaultApp(String defaultApp) {
		this.defaultApp = defaultApp;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	} 
	
}
