package com.cattsoft.sm.component.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.DevelopMVO;
import com.cattsoft.sm.vo.StaffExtendMVO;
import com.cattsoft.sm.vo.StaffMVO;
import com.cattsoft.sm.vo.StaffSVO;
import com.cattsoft.sm.vo.WorkAreaExchSVO;
import com.cattsoft.sm.vo.WorkAreaSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-26 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public interface IStaffMDAO extends IDAO {
	
    public List getStaffLocalNetVOs(Long staffId, String systemName) throws AppException, SysException;
    
    public List getStaffLocalNetVOs(String staffId, String systemName) throws AppException, SysException;

    public List getWorkStaffList(WorkAreaSVO svo) throws AppException, SysException;
    
    public List findByLabelValueBean(GenericVO vo) throws SysException, AppException;
    
    public StaffMVO findStaffMemberByStaffId(String staffId) throws AppException, SysException;

    public PagView findStaffMemberFast(StaffMVO vo, PagInfo pagInfo,List oList,String deptIds) throws SysException,
            AppException;

    public StaffExtendMVO findStaffExtendMVO(String staffId) throws SysException, AppException;

    public List findStaffMember(StaffMVO vo) throws SysException, AppException;

    public PagView findStaffMemberSet(HashSet set, PagInfo pagInfo) throws Exception;

    public List findDevelopMVO(DevelopMVO dmvo) throws SysException, AppException;
    
    public List findStaffMVOByExchId(WorkAreaExchSVO vo) throws SysException, AppException;
    
    //���ݱ������ͷ�������ȡԱ���б�������γ����Ϣ��
    public List findStaffList(GenericVO vo) throws SysException, AppException ;
    
  //���ݱ������ͷ�������ȡԱ�����ʱ����б�������γ����Ϣ���ų�û��Ѳ���������Ա
	public List findLatestStaffList(GenericVO vo) throws SysException, AppException;
	
	//���ݱ������ͷ�������ȡԱ�����ʱ����б�������γ����Ϣ����Ѳ�������޹�
	public List findLastStaffList(GenericVO vo) throws SysException, AppException;
    
    //���ݸ���Ա�����Ʋ���Ա���б�
	public PagView findStaffListByStaffName(GenericVO vo,PagInfo pagInfo) throws SysException, AppException;
    
	//���ݸ���Ա�����Ʋ���Ա���б�
	public PagView findLatestStaffListByStaffName(GenericVO vo,PagInfo pagInfo) throws SysException, AppException;
    
    public List findStaffMemberByStaffIds(String staffIds) throws AppException, SysException;
    
    public List findStaffMVO(StaffMVO vo) throws SysException, AppException;
    
    public String[] updateStaffMVOByRs(GenericVO vo,String type) throws AppException, SysException;
    
    public String findNameByStaffId(String staffId) throws AppException, SysException;
    
    public GenericVO findStaffMVO (StaffSVO vo)throws AppException, SysException;
    
    public String findStaffIdByPartyId(String partyId) throws AppException, SysException;

    // �����ƶ�ҵ��ͨͬ��Ա������
	public void addUserService(Map paraMap) throws AppException,SysException ;
	
	public void deleteUserService(String code) throws AppException,SysException ;
	
	public void updateUserService(Map paraMap) throws AppException,SysException ;
	
	public List findAllUserService() throws AppException,SysException ;

	public void updateTerminalConfig(String staffId) throws AppException,SysException ;
	//��Ч���˹���
	public PagView findStaffMemberPer(StaffMVO vo, PagInfo pagInfo,List oList,String deptIds) throws SysException,
    AppException;
	//ѡȡ����������ʱ���г�Ա���б�
	public PagView findStaffMemberForCheker(StaffMVO vo, PagInfo pagInfo, List oList,
			String deptIds) throws SysException, AppException;
}
