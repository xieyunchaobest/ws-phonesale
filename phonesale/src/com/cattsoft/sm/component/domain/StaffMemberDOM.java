package com.cattsoft.sm.component.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sm.component.dao.IStaffMemberMDAO;
import com.cattsoft.sm.vo.StaffInfoMVO;
import com.cattsoft.sm.vo.StaffWorkAreaSVO;
import com.cattsoft.tm.vo.WoSVO;

public class StaffMemberDOM {

	/**
	 * <br>Description:���ݹ����������в���Ա����Ϣ</br>
	 * @data	2007-6-12
	 * @param	����voList
	 * @return	������Ϣlist
	 * @exception	SysException,AppException
	 */	 
	
	public List findStaff(WoSVO woVo) throws SysException, AppException {
		
		if(null == woVo) 
			throw new AppException("6200002","ȱ�ٷ���������");
		IStaffMemberMDAO staffInfoDao = (IStaffMemberMDAO)DAOFactory.getDAO(IStaffMemberMDAO.class);
		
		StaffInfoMVO staffInfoVo = new StaffInfoMVO();
		List staffInfoList= new ArrayList();
		List staffMemberList = new ArrayList();
		StaffWorkAreaSVO staffWorkAreaVo = new StaffWorkAreaSVO();

		staffWorkAreaVo.setWorkAreaId(woVo.getWorkAreaId());
		staffWorkAreaVo.setAdminFlag( SysConstants.FALSE); // �����߱�־Ϊ"N",���з�ʩ����Ա����  lijixu 20090901
		staffMemberList = staffInfoDao.findStaff(staffWorkAreaVo);
       	
    	for(int i=0;i<staffMemberList.size();i++)
    	{
    		staffInfoVo=(StaffInfoMVO)staffMemberList.get(i);	
    		staffInfoList.add(new LabelValueBean(staffInfoVo.getName(),staffInfoVo.getStaffId()));
    	}
		return staffInfoList;
	}
}
