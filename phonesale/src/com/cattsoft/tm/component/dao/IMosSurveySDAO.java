/**
 * 
 */
package com.cattsoft.tm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.ISDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

/**
 * @author maxun
 * CreateTime 2012-9-27 ����2:51:42
 */
public interface IMosSurveySDAO extends ISDAO{
	public void add(GenericVO vo) throws AppException, SysException ;

	/**
	 * ������ѯ��SQL��
	 * @return String �� ������ѯ��SQL��
	 */
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException ;

	/**
	 * ������ѯ��SQL��
	 * @return String �� ������ѯ��SQL��
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException ;

	/**
	 * ���µ�SQL��
	 * @return String �� ���µ�SQL��
	 */
	public void update(GenericVO vo) throws AppException, SysException ;

	/**
	 * �������Ӽ�¼��
	 * @return String �� �������ӵ�SQL��
	 */
	public void addBat(List list) throws AppException, SysException ;

	/**
	 * ���ݴ������ɾ��һ������һ����¼��
	 * @return String �� ɾ����SQL��
	 */
	public void delete(GenericVO vo) throws AppException, SysException ;

	/**
	 * ע��һ������һ��
	 * @return String �� ע��һ������һ����SQL��
	 */
	public void unable(GenericVO vo) throws AppException, SysException ;
}
