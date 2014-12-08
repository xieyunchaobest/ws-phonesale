package com.cattsoft.pub.dao;

import java.util.List;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

public interface ISDAO extends IDAO{
	
	
	/**
	 * ����������vo
	 * 
	 * @param vo
	 * @return
	 */
	public GenericVO findByPK(GenericVO vo)throws AppException,SysException;
	
	
	/**
	 * ���
	 * 
	 * @param vo
	 */
	public void add(GenericVO vo)throws AppException,SysException;
	
	/**
	 * �������
	 * 
	 * @param vos
	 */
	//public void addBat(List vos)throws AppException,SysException;
	
	
	/**
	 * �޸�
	 * 
	 * @param vo
	 */
	public void update(GenericVO vo)throws AppException,SysException;
	
	
	/**
	 * ��������ɾ��
	 * 
	 * @param vo
	 */
	public void delete(GenericVO vo)throws AppException,SysException;
	
	
	

	
	/**
	 * �޸�״̬Ϊͣ��
	 * @param vo
	 */
	//public void unable(GenericVO vo)throws AppException,SysException;
	
	
	/**
	 * ����vo��ѯ
	 * 
	 * @param vo
	 * @return 
	 */
	public List findByVO(GenericVO vo)throws AppException,SysException;
	
}
