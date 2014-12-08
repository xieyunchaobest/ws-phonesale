package com.cattsoft.sm.component.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.MaxId;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.pub.util.SysDate;
import com.cattsoft.sm.component.dao.IActionLogSDAO;
import com.cattsoft.sm.component.dao.ISysRoleAllocSDAO;
import com.cattsoft.sm.component.dao.ISysRoleMDAO;
import com.cattsoft.sm.component.dao.ISysRoleSDAO;
import com.cattsoft.sm.component.dao.ISysUserAllocMDAO;
import com.cattsoft.sm.component.dao.ISysUserRoleSDAO;
import com.cattsoft.sm.vo.ActionLogSVO;
import com.cattsoft.sm.vo.SysRoleAllocSVO;
import com.cattsoft.sm.vo.SysRoleSVO;
import com.cattsoft.sm.vo.SysUserAllocSVO;
import com.cattsoft.sm.vo.SysUserRoleSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-21 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author cason_lau
 */
public class SysRoleDOM {
	
    private static Logger log = Logger.getLogger(SysRoleDOM.class);

    ISysRoleSDAO sysRoleDao = (ISysRoleSDAO) DAOFactory.getInstance().getDAO(ISysRoleSDAO.class);

    ISysRoleMDAO sysRoleMDao = (ISysRoleMDAO) DAOFactory.getInstance().getDAO(ISysRoleMDAO.class);

    ISysRoleAllocSDAO allocDao = (ISysRoleAllocSDAO) DAOFactory.getInstance().getDAO(
            ISysRoleAllocSDAO.class);

    ISysUserAllocMDAO sysUserAllocMDao = (ISysUserAllocMDAO) DAOFactory.getInstance().getDAO(
            ISysUserAllocMDAO.class);

    ISysUserRoleSDAO suDao = (ISysUserRoleSDAO) DAOFactory.getInstance().getDAO(
            ISysUserRoleSDAO.class);

    /**
     * ��ѯ���ݷ�Χ��
     * 
     * @param vo
     *            DataRangeSVO
     * @throws SysException
     * @throws AppException
     * @return List
     */

    public List findSysRole(SysRoleSVO vo) throws SysException, AppException {
        List list = sysRoleDao.findByVO(vo);
        log.debug("list=" + list);
        return list;
    }

    /**
     * �������ݷ�Χ��
     * 
     * @param vo
     *            DataRangeSVO
     * @return
     * @throws SysException
     * @throws AppException
     * @return List
     */

    public String addSysRole(SysRoleSVO vo) throws SysException, AppException {
        vo.setCreateDate(SysDate.getCurrentDate());
        vo.setStsDate(SysDate.getCurrentDate());
        vo.setSysRoleId(MaxId.getSequenceNextVal(Constant.SEQ_SYS_ROLE_ID));
        vo.setSts(Constant.STS_IN_USE);
        sysRoleDao.add(vo);
        
        /////////////////////////////////////////////////////////////  add by caizhicun
        SysUserRoleSVO surSvo =new SysUserRoleSVO();
        surSvo.setCreateDate(SysDate.getCurrentDate());
        surSvo.setStsDate(SysDate.getCurrentDate());
        surSvo.setSysUserRoleId(MaxId.getSequenceNextVal(Constant.SEQ_SYS_USER_ROLE_ID));
        surSvo.setSts(Constant.STS_IN_USE);
        surSvo.setSysRoleId(vo.getSysRoleId());
        surSvo.setSysUserId(vo.getSysUserId());
        surSvo.setAllowAuth("T");
        suDao.add(surSvo);
        ///////////////////////////////////////////////////////////
        //��¼������־
        ActionLogSVO actionLog=vo.getActionLog();
        actionLog.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
        actionLog.setActionText(vo.getSysRoleId()+":"+vo.getSysRoleName()+":����");
        IActionLogSDAO actionLogDao=(IActionLogSDAO)com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
        actionLogDao.add(actionLog);
        
        return vo.getSysRoleId();

    }

    /**
     * ��ѯ���ݷ�Χ��
     * 
     * @param vo
     *            DataRangeSVO
     * @return List
     * @throws Exception
     */

    public List findLatestSysRole(HashSet set) throws Exception {
        List list = sysRoleMDao.findLatestSysRole(set);
        return list;
    }

    /**
     * ɾ�����ݷ�Χ
     * 
     * @param vo
     *            DataRangeSVO
     * @throws SysException
     * @throws AppException
     */

    public void delSysRole(List vos,List logList) throws SysException, AppException {
    	List list=new ArrayList();
        SysRoleSVO drv = null;
        SysUserRoleSVO suvo = new SysUserRoleSVO();
        SysRoleAllocSVO savo = new SysRoleAllocSVO();
        for (int i = 0; i < vos.size(); i++) {
            drv = (SysRoleSVO) vos.get(i);
            suvo.setSysRoleId(drv.getSysRoleId());
            suvo.setSts(Constant.STS_IN_USE);
            List suLst=suDao.findByVO(suvo) ;
            if (suLst != null&&suLst.size()>0) {
                throw new AppException("222", "���Ϊ"+drv.getSysRoleId() + "�´���Ա��,����ɾ����Ӧ��Ա����Ӧ��ϵ!");
            }
            savo.setSysRoleId(drv.getSysRoleId());
            savo.setSts(Constant.STS_IN_USE);
            List saLst=allocDao.findByVO(savo);
            if (allocDao.findByVO(savo) != null&&saLst.size()>0) {
                throw new AppException("222", "���Ϊ"+drv.getSysRoleId() + "�´����й��ܵ�,����ɾ����Ӧ�Ĺ��ܵ��Ӧ��ϵ!");
            }
            // ��ɫ����Ա��������ɾ����ɫ�����������ں�����ʱ��ס��
            /**
             * log.debug("DataRangeSVO:" + drv); SysUserRoleSVO driv = new SysUserRoleSVO();
             * driv.setRangeId(drv.getDataRangeId());
             * log.debug("dataRangeItemMDao.findDataRangeItem(driv.getRangeId()):" + driv); if
             * (dataRangeItemMDao.findDataRangeItem(driv.getRangeId()) != null)// ��ѯ��ǰ����������޿�ݡ�
             * throw new AppException("3300022", "��ǰ�û����п�ݲ�����ɾ��");
             */
            drv.setStsDate(SysDate.getCurrentDate());
            drv.setSts(Constant.STS_HISTORY);
            
            //��¼������־
            ActionLogSVO actionLog=(ActionLogSVO) logList.get(i);
            actionLog.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
            list.add(actionLog);
            
            sysRoleDao.update(drv);
        }
        IActionLogSDAO actionLogDao=(IActionLogSDAO)com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
        actionLogDao.addBat(list);
    }

    /**
     * �޸����ݷ�Χ
     * 
     * @param vo
     *            DataRangeSVO
     * @throws SysException
     * @throws AppException
     */

    public void modSysRole(SysRoleSVO vo) throws SysException, AppException {
        sysRoleDao.update(vo);
    }

    /**
     * ������ѯ���ݷ�Χ��
     * 
     * @param vo
     *            DataRangeSVO
     * @throws SysException
     * @throws AppException
     * @return List
     */

    public SysRoleSVO findSysRoleById(SysRoleSVO svo) throws SysException, AppException {
        SysRoleSVO vo = (SysRoleSVO) sysRoleDao.findByPK(svo);
        return vo;
    }

    public PagView findSysRolesByPage(SysRoleSVO vo, HashSet set, PagInfo pagInfo) throws Exception {
        return sysRoleDao.findSysRolesByPage(vo, set, pagInfo);
    }

    public List findSysRoleMVO(SysRoleSVO vo) throws SysException, AppException {
        return sysRoleMDao.findSysRoleMVO(vo);
    }

    public void delSysUserRoles(List list) throws SysException, AppException {
        SysUserRoleSVO svo = new SysUserRoleSVO();

        for (int i = 0; i < list.size(); i++) {
            svo = (SysUserRoleSVO) list.get(i);
            svo.setSts(Constant.STS_HISTORY);
            suDao.update(svo);
            /*
             * modify by caiqian 2009-12-8,�ڽ�ɫ��ȡ�������û�ʱ�����û�ID�ͽ�ɫIDɾ��sys_user_alloc�������
             * ֱ��ɾ��,Ϊ�˵�½Ч��,����sysUserAlloc���в����ڽ�ɫ��Ϊ�գ�״̬Ϊp������
             */
            svo = (SysUserRoleSVO) suDao.findByPK(svo);
            SysUserAllocSVO delsvo = new SysUserAllocSVO();
            delsvo.setSysUserId(svo.getSysUserId());
            delsvo.setSysRoleId(svo.getSysRoleId());
            if (delsvo.getSysRoleId() != null && delsvo.getSysUserId() != null){
                sysUserAllocMDao.delBySysRoleAndSysUser(delsvo);
            }
        }
    }
    //add by gaofei
    /**
     * �޸ļ�¼
     * @param vo
     * @throws SysException
     * @throws AppException
     */
    public void updateSysRole(SysRoleSVO vo) throws SysException, AppException {
        sysRoleDao.update(vo);
        //����޸ļ�¼
        ActionLogSVO actionLog=vo.getActionLog();
        actionLog.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
        IActionLogSDAO actionLogDao=(IActionLogSDAO)com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
        actionLogDao.add(actionLog);
    }

}
