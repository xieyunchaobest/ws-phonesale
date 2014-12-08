package com.cattsoft.sm.component.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.WorkAreaMVO;
import com.cattsoft.sm.vo.WorkAreaSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-26 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public interface IWorkAreaMDAO extends IDAO {

	public List findWorkAreasBySystemStaff(WorkAreaSVO vo, String systemName,
			String staffId) throws SysException;
	
	public List findWorkAreasBySystemStaff4MOS(WorkAreaSVO vo, String systemName,
			String staffId) throws SysException;

	public List findWorkAreasBySystemStaffByMobile(WorkAreaMVO vo, String systemName,
			String staffId) throws SysException;

	public List findSingleWorkAreasBySystemStaff(WorkAreaSVO vo,
			String systemName, String staffId) throws SysException;

	public PagView findBySet(HashSet set, PagInfo pagInfo) throws Exception;

	public PagView findByPage(GenericVO vo, PagInfo pagInfo)
			throws AppException, SysException;

	public GenericVO findByWorkExch(String work_area_exch_id)
			throws SysException, AppException;

	public GenericVO findByPK(GenericVO vo) throws AppException, SysException;

	public void setDefaultWorkArea(String staffId, String workAreaId,
			String subSystemName) throws SysException, AppException;

	public void WorkAreaSync(String actType, String workAreaId,
			String localNetId, String areaId, String name,
			String dispatchLevel, String parentWorkAreaId, String standardCode,
			String sts, Date stsDate, Date createDate, String workMode)
			throws SysException, AppException;

	public void addWorkArea(GenericVO vo) throws AppException, SysException;

	public void updateWorkArea(GenericVO vo) throws AppException, SysException;

	public void deleteWorkArea(GenericVO vo) throws AppException, SysException;

	public List findByVO(GenericVO vo) throws AppException, SysException;
	
	public List findByStepId(String stepId, String localNetId) throws AppException, SysException;

	/**
	 * ���ɹ������� add by zhaodan 2009-7-30
	 * @param waVO
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String getWorkAreaId(WorkAreaMVO waVO) throws AppException, SysException;

	/*------------------------------------- ����������ϵά��---------------------------------------*/
	public List findMaintsSelected(WorkAreaMVO vo) throws AppException,SysException ;
	public List findMaintsUnSel(WorkAreaMVO vo) throws SysException,AppException ;
	public List findWorkAreaId(String maintAreaId, String workTypeId)throws AppException, SysException ;
	public List findWorkAreasByType(WorkAreaSVO vo,String staffId)throws AppException, SysException ;
	
	/*------------------------------------- �����������ϵά��---------------------------------------*/
	public List findServDeptSelected(WorkAreaMVO vo) throws AppException,SysException ;
	public List findServDeptUnSel(WorkAreaMVO vo) throws SysException,AppException ;

	/**
	 * ��ѯ�־ֱ���
	 * ���ڼ�����ͨ��פ�����½����ݽӿ�
	 */
	public String findStationCodeByWoNbr(String woNbr) throws AppException, SysException;
	
	/**
	 * ��ѯ�־ֱ��� �����ô洢����
	 * ���ڼ�����ͨ��פ�����½����ݽӿ�
	 */
	public Map findStationCodeByWoNbr(String woNbr,String type) throws AppException, SysException;
	
	public List getWorkAreasList(GenericVO vo) throws AppException, SysException;
	
}
