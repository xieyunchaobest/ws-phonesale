/**
 * 
 */
package com.cattsoft.sm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

/**
 * Title:ϵͳ����-Ա������-�ͻ��ȼ�����<br>
 * Description:�ͻ��ȼ�����MDAO�ӿ�<br>
 * Copyright:Copyright (C) 2009<br>
 * Company:cattsoft<br>
 * 
 * @author � 2009-4-28<br>
 * @version 1.0 <br>
 * 
 */
public interface ICustLevelMDAO extends IDAO {
	/**
	 * ���vo�е���Ϣ��ȡ���������Ϣ<br>
	 * 
	 * @param vo����������Ϣ
	 * @return List �������������Ϣ
	 * @throws AppException
	 * @throws SysException
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException;
	
	
	/**
	   * ������ѯ��SQL��
	   * @return String �� ������ѯ��SQL��
	  */
	 public GenericVO findByPK(GenericVO vo)throws AppException, SysException;
	
	/**
	 * ����ע���ͻ��ȼ�
	 * 
	 * @param voList
	 * @throws AppException
	 * @throws SysException
	 */
	public void unableBat(List voList) throws AppException, SysException;
	
	 /**
	 * ���ݿͻ����ͻ�ÿͻ�����
	 * added by yangkai 20090706
	 * @return 
	 * @throws SysException
	 * @throws AppException
	 */
	public List findCustLevel(String custCat) throws AppException, SysException;

}
