package com.cattsoft.sm.component.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.ConstraintAndPriviledgeSVO;
import com.cattsoft.sm.vo.SysUserAllocSVO;
import com.cattsoft.sm.vo.SysUserExtMVO;
import com.cattsoft.sm.vo.SysUserMVO;

public interface ISysUserMDAO extends IDAO {
	
    public SysUserMVO findSysUserByNamePwd(SysUserMVO vo);

    public List findSysUsers(SysUserMVO vo) throws SysException, AppException;

    public int findSysUsersSts(String sysUserName) throws SysException, AppException;

    public PagView findSysUsersBySysUserForPage(SysUserExtMVO voExt, PagInfo pagInfo) throws SysException,
            AppException;
    
    public  List findSysUserAllocListBySysUserId(SysUserAllocSVO vo) throws SysException,
    AppException;
    
    public List  findSysRoleAllocListBySysUserId(SysUserAllocSVO vo) throws SysException,
    AppException;
    
    public List findConstraintAndPriviledgeListBySysUserId(ConstraintAndPriviledgeSVO vo) throws SysException,
    AppException;
    /**
	 * ����쵥������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public String getFetchOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException ;
	/**
	 * ��ûص�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getReturnOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException ;
	/**
	 * ���׷��������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getZhuiDanOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException;
	/**
	 * ����˵�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getBackOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException ;
	/**
	 * ��ôߵ�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getPressOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException;
	/**
	 * ����쳣��������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getExceptionOrderCount(String localNetId, String areaId,String workAreaId) throws AppException,
			SysException;
	
	  /**
	 * ���������Ȩ�޹������쵥������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public String getFetchOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException ;
	/**
	 * ���������Ȩ�޹����Ļص�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getReturnOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException ;
	/**
	 * ���������Ȩ�޹�����׷��������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getZhuiDanOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException;
	/**
	 * ���������Ȩ�޹������˵�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getBackOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException ;
	/**
	 * ���������Ȩ�޹����Ĵߵ�������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getPressOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException;
	/**
	 * ���������Ȩ�޹������쳣��������
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 */
	public int getExceptionOrderCountAll(String localNetId, String areaId,String staffId) throws AppException,
			SysException;
	
	/**
	 * ����������͹���������ͳ�ƽ��
	 * 	,map�з��ص�ֵ��,returnorder,pressorder,exceptionorder
	 * @author wugang
	 * @param localNetId
	 * @param areaId
	 * @param staffId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public Map getAllOrderCount(String localNetId, String areaId,String workAreaId,String staffId)throws AppException,
			SysException;
	
	/**
	 * �����û����������ѯ�û����û��������ִ�Сд
	 * @param sysUserVO
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List findByVOIgnorecase(GenericVO vo)throws AppException,
	SysException;
}
