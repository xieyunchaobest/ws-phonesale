package com.cattsoft.sm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.ISDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

/**
 * Title:ϵͳ����-Ա������-֤�����͹���<br>
 * Description:֤�����͹���SDAO�ӿ�<br>
 * Copyright:Copyright (C) 2009<br>
 * Company:cattsoft<br>
 * 
 * @author � 2009-4-28<br>
 * @version 1.0 <br>
 * 
 */
public interface ICertTypeSDAO extends ISDAO {
	
	/**
	 * ���Ӽ�¼��
	 * 
	 * @return
	 */
	public void add(GenericVO vo) throws AppException, SysException;

	/**
	 * ������ѯ��SQL��
	 * 
	 * @return GenericVO �� ����VO��
	 */
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException;

	/**
	 * ������ѯ��SQL��
	 * 
	 * @return List �� ����VO�б�
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException;

	/**
	 * �������ݿ���SQL��
	 * 
	 * @return
	 */
	public void update(GenericVO vo) throws AppException, SysException;

	/**
	 * �������Ӽ�¼��
	 * 
	 * @return
	 */
	public void addBat(List list) throws AppException, SysException;

	/**
	 * ���ݴ������ɾ��һ������һ����¼��
	 * 
	 * @return
	 */
	public void delete(GenericVO vo) throws AppException, SysException;

	
}