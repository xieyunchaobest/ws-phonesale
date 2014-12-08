package com.cattsoft.sm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

public interface IUserDataRangeMDAO extends IDAO {
	/**
	 * ������ѯ�û�Ȩ������
	 * 
	 * @param vo
	 *            <UserDataRangeSVO>
	 * @return List<UserDataRangeSVO>
	 */
	public List findUserDataRangeList(GenericVO vo) throws AppException, SysException;

	/**
	 * ��ѯ��ǰԱ��ӵ�еķ�����
	 * 
	 * @param vo
	 *            <UserDataRangeSVO>
	 */
	public List findUserAreas(GenericVO vo) throws AppException, SysException;

	/**
	 * ��ѯ��ǰԱ��ӵ�еķ�����(���������ظ�distinct��
	 * 
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List findDistinctUserAreas(GenericVO vo) throws AppException, SysException;

	/**
	 * ��ѯ��ǰԱ��ӵ�еı�����
	 * 
	 * @param vo
	 *            <UserDataRangeSVO>
	 */
	public List findUserLocalNets(GenericVO vo) throws AppException, SysException;

	/**
	 * ��ѯ��ǰԱ��ӵ�еı������ڣ����������ظ�distinct��
	 * 
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List findDistinctUserLocalNets(GenericVO vo) throws AppException, SysException;

	/**
	 * ��ȡԱ��
	 * 
	 * @param vo
	 *            <UserDataRangeMVO>
	 */
	public List getStaffs(GenericVO vo) throws AppException, SysException;

	/**
	 * ���ݴ������ɾ��һ������һ����¼��
	 * 
	 * @return String �� ɾ����SQL��
	 */
	public void delete(GenericVO vo) throws AppException, SysException;

	/**
	 * ���ӡ�
	 * 
	 * @return String
	 */
	public void addBat(List list) throws AppException, SysException;

	/**
	 * �����û�Ȩ�޲�ѯ���������߷�����
	 * 
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List findDataRange(GenericVO vo) throws AppException, SysException;
	
	/**
	 * ���ܣ������û�Ȩ�޲�ѯ������
	 * 
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List findLocalNetByRange(GenericVO vo) throws AppException,
			SysException;
}
