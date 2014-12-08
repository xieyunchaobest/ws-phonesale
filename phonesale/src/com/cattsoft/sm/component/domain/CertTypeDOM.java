package com.cattsoft.sm.component.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.sm.component.dao.ICertTypeMDAO;
import com.cattsoft.sm.component.dao.ICertTypeSDAO;
import com.cattsoft.sm.vo.CertTypeMVO;
import com.cattsoft.sm.vo.CertTypeSVO;
import com.cattsoft.sm.component.dao.IActionLogSDAO;
import com.cattsoft.sm.vo.ActionLogSVO;

/**
 * Title: ϵͳ����-Ա������-�ͻ����͹���<br>
 * Description: �ͻ����͹���DOM <br>
 * Date: 2007-7-30 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * Modify by yangkai 2009-04-28
 * @author anzhiqiang
 */
public class CertTypeDOM {	

    private static Logger log = Logger.getLogger(CertTypeDOM.class);
    public List findCertTypeByVO(CertTypeSVO vo) throws AppException, SysException {
    	ICertTypeSDAO certTypeSDao = (ICertTypeSDAO) DAOFactory.getInstance().getDAO(
                ICertTypeSDAO.class);    	
    	return certTypeSDao.findByVO(vo);
    }
    
    /**
	 * ���ܣ���ѯ�ͻ�����
	 * 
	 * @param CertTypeSVO:�ͻ��������ݽṹ
	 * @throws SysException
	 * @throws AppException
	 * @return List<WorkTypeSVO>
	 * @author modified by yangkai change method name
	 */
	public List find(CertTypeSVO vo) throws AppException, SysException {
		ICertTypeMDAO dao = (ICertTypeMDAO) DAOFactory.getInstance().getDAO(ICertTypeMDAO.class);
		return dao.findByVO(vo);
	}

	/**
	 * ���ܣ����ӿͻ�����
	 * 
	 * @param CertTypeMVO:�ͻ��������ݽṹ
	 * @throws SysException
	 * @throws AppException
	 * 
	 */
	public void add(CertTypeMVO vo) throws AppException, SysException {
		log.debug("�������ӿͻ�����add������");
		ICertTypeSDAO dao = (ICertTypeSDAO)DAOFactory.getInstance().getDAO(ICertTypeSDAO.class);
		String certTypeId = MaxId
				.getSequenceNextVal(SysConstants.CERT_TYPE_ID_SEQ);// �����ͻ���������
		vo.setCertTypeId(certTypeId);
		dao.add(vo);
		ActionLogSVO actionLog = vo.getActionLog();
		actionLog.setActionId(MaxId
				.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
		actionLog.setActionText(certTypeId + actionLog.getActionText());
		IActionLogSDAO sDao = (IActionLogSDAO) DAOFactory.getInstance().getDAO(IActionLogSDAO.class);
		sDao.add(actionLog);
	}

	/**
	 * ���ܣ��޸Ŀͻ����ͳ�ʼ��
	 * 
	 * @param CertTypeMVO:�ͻ��������ݽṹ
	 * @throws SysException
	 * @throws AppException
	 * @return CertTypeMVO
	 */
	public CertTypeMVO updateInit(CertTypeMVO mvo) throws AppException,
			SysException {
		ICertTypeMDAO dao = (ICertTypeMDAO) DAOFactory
				.getInstance().getDAO(ICertTypeMDAO.class);
		return (CertTypeMVO) dao.findByPK(mvo);
	}

	/**
	 * ���ܣ��޸Ŀͻ�����
	 * 
	 * @param CertTypeMVO:�ͻ��������ݽṹ
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public void update(CertTypeMVO vo) throws AppException, SysException {
		ICertTypeSDAO dao = (ICertTypeSDAO) DAOFactory
				.getInstance().getDAO(ICertTypeSDAO.class);
		dao.update(vo);
		ActionLogSVO actionLog = vo.getActionLog();
		actionLog.setActionId(MaxId
				.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
		IActionLogSDAO sDao = (IActionLogSDAO) DAOFactory
				.getInstance().getDAO(IActionLogSDAO.class);
		sDao.add(actionLog);
	}

	/**
	 * ���ܣ�ע���ͻ�����
	 * 
	 * @param CertTypeList:�ͻ��������ݽṹ
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public void unable(List certTypeList) throws AppException, SysException {
		if (certTypeList == null)
			throw new AppException("", "ע�����϶���Ϊnull");
		ICertTypeMDAO dao = (ICertTypeMDAO) DAOFactory.getInstance().getDAO(ICertTypeMDAO.class);
		IActionLogSDAO sDao = (IActionLogSDAO) DAOFactory.getInstance().getDAO(IActionLogSDAO.class);
		dao.unableBat(certTypeList);
		if (certTypeList != null && certTypeList.size() > 0) {
			List list = new ArrayList();
			for (int i = 0; i < certTypeList.size(); i++) {
				CertTypeMVO mvo = (CertTypeMVO) certTypeList.get(i);
				ActionLogSVO svo = (ActionLogSVO) mvo.getActionLog();
				svo.setActionId(MaxId
						.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
				list.add(svo);
			}
			sDao.addBat(list);
		}
	}

}
