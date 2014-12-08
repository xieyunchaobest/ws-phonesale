package com.cattsoft.sm.component.domain;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.sm.component.dao.IActionLogSDAO;
import com.cattsoft.sm.component.dao.ISysAreaConfigSDAO;
import com.cattsoft.sm.component.dao.ISysConfigSDAO;
import com.cattsoft.sm.vo.ActionLogSVO;
import com.cattsoft.sm.vo.SysAreaConfigSVO;
import com.cattsoft.sm.vo.SysConfigSVO;
import com.cattsoft.webpub.util.SysDateUtil;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-7 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public class SysConfigDOM {
	
    private ISysConfigSDAO sysConfigDao = (ISysConfigSDAO) DAOFactory.getInstance().getDAO(
            ISysConfigSDAO.class);

    private ISysAreaConfigSDAO sysAreaConfigDao = (ISysAreaConfigSDAO) DAOFactory.getInstance()
            .getDAO(ISysAreaConfigSDAO.class);

    /**
     * ����������ѯ����SysConfigSVO
     * 
     * @param vo
     * @return SysConfigSVO
     * @throws SysException
     * @throws AppException
     */
    public SysConfigSVO findSysConfigByPK(SysConfigSVO vo) throws AppException, SysException {
        SysConfigSVO sysconfig = sysConfigDao.findSysConfigByPK(vo);
        if (sysconfig == null) {
            return null;
        }
        return sysconfig;
    }

    /**
     * ������Ӧ��������ѯ����SysConfigSVO
     * 
     * @param vo
     * @return List<SysConfigSVO>
     * @throws SysException
     * @throws AppException
     */
    public List findByVo(SysConfigSVO vo, String localNetId) throws SysException, AppException {
    	return sysConfigDao.findByLocalNet(vo, localNetId);
    }
    
    /**
     * ������Ӧ��������ѯ����SysConfigSVO
     * 
     * @param vo
     * @return List<SysConfigSVO>
     * @throws SysException
     * @throws AppException
     */
    public List findBySysName(SysConfigSVO vo) throws SysException, AppException {
    	return sysConfigDao.findByVO(vo);
    }

    /**
     * �޸ĵ���SysConfigSVO
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     */
    public void update(SysConfigSVO vo) throws SysException, AppException {
        SysConfigSVO svo = new SysConfigSVO();
        svo.setConfigId(vo.getConfigId());
        svo = (SysConfigSVO) sysConfigDao.findByPK(svo);
        if (!svo.getConfigType().equals(vo.getConfigType())) {
            SysAreaConfigSVO scvo = new SysAreaConfigSVO();
            scvo.setConfigId(vo.getConfigId());
            List list = sysAreaConfigDao.findByVO(scvo);
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    scvo = (SysAreaConfigSVO) it.next();
                    sysAreaConfigDao.delete(scvo);
                }
            }
        }
        sysConfigDao.update(vo);
        //��¼��ǰ�����Ĳ���
        ActionLogSVO actionLog=vo.getActionLog();
        actionLog.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
        IActionLogSDAO actionLogDao=(IActionLogSDAO)com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
		actionLogDao.add(actionLog);
    }

    /**
     * ɾ������SysConfigSVO
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     */
    public void delete(SysConfigSVO vo) throws SysException, AppException {
        sysConfigDao.delete(vo);

    }

    /**
     * ���ӵ���SysConfigSVO
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     */
    public void add(SysConfigSVO vo) throws SysException, AppException {

        if (sysConfigDao.findByPK(vo) != null) {
            throw new AppException("333", "����Ѿ�����!");
        }
        vo.setCreateDate(SysDateUtil.getCurrentDate());
        sysConfigDao.add(vo);

    }

    public PagView findSysConfigsByPage(SysConfigSVO vo, HashSet set, PagInfo pagInfo)
            throws Exception {
        return sysConfigDao.findSysConfigsByPage(vo, set, pagInfo);
    }

    /**
     * ��������id,������id,��ѯ��Ӧ������ֵ
     * 
     * @param configId
     * @param spAreaId
     * @return
     * @throws AppException
     * @throws SysException
     */
    public String getValue(String configId, String spAreaId) throws AppException, SysException {
        SysConfigSVO svo = new SysConfigSVO();
        svo.setConfigId(configId);
        svo = sysConfigDao.findSysConfigByPK(svo);
        if (svo == null) {
            throw new AppException("2222", "�����ڴ�ϵͳ����");

        }
        return svo.getCurValue();
    }

}
