package com.cattsoft.sm.component.domain;

import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.sm.component.dao.IAreaSDAO;
import com.cattsoft.sm.component.dao.ILocalNetSDAO;
import com.cattsoft.sm.component.dao.IPartyMDAO;
import com.cattsoft.sm.component.dao.ISysRoleMDAO;
import com.cattsoft.sm.component.dao.ISysUserRoleSDAO;
import com.cattsoft.sm.vo.SysRoleSVO;
import com.cattsoft.sm.vo.SysUserRoleSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-28 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author cason_lau
 */

public class SysUserRoleDOM {

    private static Logger log = Logger.getLogger(SysUserRoleDOM.class);

    ISysUserRoleSDAO sysUserRoleSDao = (ISysUserRoleSDAO) DAOFactory.getInstance().getDAO(
            ISysUserRoleSDAO.class);

    ISysRoleMDAO sysRoleMDao = (ISysRoleMDAO) DAOFactory.getInstance().getDAO(ISysRoleMDAO.class);

    IPartyMDAO partyMDao = (IPartyMDAO) DAOFactory.getInstance().getDAO(IPartyMDAO.class);

    ILocalNetSDAO localSDao = (ILocalNetSDAO) DAOFactory.getInstance().getDAO(ILocalNetSDAO.class);

    IAreaSDAO areaSDao = (IAreaSDAO) DAOFactory.getInstance().getDAO(IAreaSDAO.class);

    /**
     * ��ѯ�ɷ���Ľ�ɫ��
     * 
     * @param sysRoleId
     * 
     * @throws SysException
     * @throws AppException
     * @return List
     */

    public List findSysRoleAllowAuth(SysRoleSVO vo) throws SysException, AppException {

        return sysRoleMDao.findSysRoleAllowAuth(vo);
        // List list = null;
        // SysUserSVO suv = new SysUserSVO();
        // suv.setSysUserId(sysUserId);
        //
        // PartySVO ps = new PartySVO();
        // List lis =partyMDao.findPartyBySysUserId(suv,localNetId);
        // ps = (PartySVO) lis.get(0);
        //
        // LocalNetSVO lns = new LocalNetSVO();
        // lns.setLocalNetId(ps.getLocalNetId());
        // lns = (LocalNetSVO) localSDao.findByPK(lns);
        //
        // AreaSVO as = new AreaSVO();
        // as.setAreaId(ps.getAreaId());
        // as = (AreaSVO) areaSDao.findByPK(as);
        //
        // // if(lvo.getCenterFlag().equals("Y")) {
        // // //ʡ��˾
        // // list = dao.findSysRoleAllowAuth(sysUserId, pvo.getLocalNetId(),
        // // pvo.getAreaId(),vo, "1"); //�õ���
        // //
        // // }
        // // else if (avo.getAreaId().equals("Y")) {
        // if (as.getIscenter().equals("Y")) {
        // // ���ķ�����
        // list = sysRoleMDao.findSysRoleAllowAuth2(sysUserId, ps.getLocalNetId(), ps.getAreaId(),
        // vo); // �õ���
        //
        // } else {
        //
        // list = sysRoleMDao.findSysRoleAllowAuth3(sysUserId, ps.getLocalNetId(), ps.getAreaId(),
        // vo);
        //
        // }
        // return list;
    }
    /**
	 * Modified by Wangfeng 2008-6-13
	 */
    /**
     * ��ѯ�ɷ���Ľ�ɫ
     * 
     * @param vo
     * @param sysUserId
     * @return
     * @throws SysException
     * @throws AppException
     */
    public List findSysRoleAllowAuth(SysRoleSVO vo, String sysUserId) throws SysException,
    	AppException {
    	// ��ѯ��Ա��ӵ�е����ڵ�ǰ��������ϵͳ�������Ľ�ɫ
    	
    	return sysRoleMDao.findSysRoleBySysUserId(vo, sysUserId);
    }

    /**
     * ��ѯ�û�ӵ�еĽ�ɫ��
     * 
     * @param sysRoleId
     * 
     * @throws SysException
     * @throws AppException
     * @return List
     */

    public List findSysUserRole(SysUserRoleSVO vo) throws SysException, AppException {
        vo.setSts("A");
        List list = sysRoleMDao.findSysUserRole(vo);
        return list;
    }

}
