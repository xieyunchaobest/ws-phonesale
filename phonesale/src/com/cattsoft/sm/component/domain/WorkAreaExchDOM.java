package com.cattsoft.sm.component.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.MaxId;
import com.cattsoft.sm.component.dao.IExchSDAO;
import com.cattsoft.sm.component.dao.IStaffMDAO;
import com.cattsoft.sm.component.dao.IWorkAreaExchMDAO;
import com.cattsoft.sm.component.dao.IWorkAreaExchSDAO;
import com.cattsoft.sm.component.dao.IWorkAreaMDAO;
import com.cattsoft.sm.component.dao.IWorkAreaSDAO;
import com.cattsoft.sm.vo.WorkAreaExchMVO;
import com.cattsoft.sm.vo.WorkAreaExchSVO;
import com.cattsoft.sm.vo.WorkAreaSVO;
import com.cattsoft.webpub.util.SysDateUtil;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-28 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */

public class WorkAreaExchDOM {

	private Logger log = Logger.getLogger(WorkAreaExchDOM.class);

	private IWorkAreaExchMDAO workAreaExchMDao = (IWorkAreaExchMDAO) DAOFactory
			.getInstance().getDAO(IWorkAreaExchMDAO.class);

	private IWorkAreaExchSDAO workAreaExchDao = (IWorkAreaExchSDAO) DAOFactory
			.getInstance().getDAO(IWorkAreaExchSDAO.class);

	private IWorkAreaSDAO workAreaDao = (IWorkAreaSDAO) DAOFactory
			.getInstance().getDAO(IWorkAreaSDAO.class);
	
	private IExchSDAO exchDao = (IExchSDAO) DAOFactory.getInstance().getDAO(IExchSDAO.class);

	private IWorkAreaMDAO workAreaMDao = (IWorkAreaMDAO) DAOFactory
			.getInstance().getDAO(IWorkAreaMDAO.class);

	private IStaffMDAO staffDao = (IStaffMDAO) DAOFactory.getInstance().getDAO(
			IStaffMDAO.class);

	public List findWorkAreaExchs(WorkAreaExchMVO vo) throws AppException,
			SysException {

		return workAreaExchMDao.findWorkAreaExchs(vo);
	}

	public List findExchsUnSel(WorkAreaExchMVO vo) throws SysException,
			AppException {
		List vos = new ArrayList();
		if (log.isDebugEnabled())
			log.debug("��ʼ��δѡ��ľ��򡣡���������" + vo.getWorkAreaId());

		if (vo.getWorkAreaId() == null)
			return vos;
		// ���ҹ���
		WorkAreaSVO wvo = new WorkAreaSVO();
		wvo.setWorkAreaId(vo.getWorkAreaId());
		vo.setWorkAreaSVO((WorkAreaSVO) workAreaDao.findByPK(wvo));
		if (vo.getWorkAreaSVO().getWorkTypeId().equals("1")) {// 1����Ӫҵ����
			if (log.isDebugEnabled())
				log.debug("�������Ӫҵ������ѡ�ľ��򡣡���");
			vos = workAreaExchMDao.findExchsUnSelNotSo(vo);
		} else {
			if (log.isDebugEnabled())
				log.debug("������Ӫҵ������ѡ�ľ��򡣡���");
			vos = workAreaExchMDao.findExchsUnSelSo(vo);
		}
		return vos;
	}

	public void delWorkAreaExch(String[] workExchIds) throws SysException,
			AppException {
		WorkAreaExchSVO svo = new WorkAreaExchSVO();
		WorkAreaExchSVO Waesvo = new WorkAreaExchSVO();
		WorkAreaSVO wasvo = new WorkAreaSVO();
		Date curDate = SysDateUtil.getCurrentDate();
		if(null!=workExchIds){
			for (int i = 0; i < workExchIds.length; i++) {
				wasvo = (WorkAreaSVO) workAreaMDao.findByWorkExch(workExchIds[i]);
				svo.setWorkAreaExchId(workExchIds[i]);
				Waesvo = (WorkAreaExchSVO) workAreaExchDao.findByPK(svo);
				svo.setWorkAreaId(Waesvo.getWorkAreaId());
				svo.setExchId(Waesvo.getExchId());
				svo.setCreateDate(Waesvo.getCreateDate());
				svo.setSts(Constant.STS_HISTORY);
				svo.setStsDate(curDate);
				workAreaExchMDao.updateWorkAreaExch(svo);
				
			}
		}
	}
	
	
	/**
	 * ɾ������
	 * @author yangkai 2009-9-1
	 * @param workExchIds
	 * @throws SysException
	 * @throws AppException
	 */
	public void delExchWorkArea(String[] workExchIds) throws SysException,AppException {
		WorkAreaExchSVO svo = new WorkAreaExchSVO();		
		for (int i = 0; i < workExchIds.length; i++) {			
			svo.setWorkAreaExchId(workExchIds[i]);
			svo =(WorkAreaExchSVO)workAreaExchDao.findByPK(svo);
			//workAreaExchDao.delete(svo); 
			svo.setExchId(svo.getExchId());
			svo.setWorkAreaId(svo.getWorkAreaId());
			svo.setSts(Constant.STS_IN_USE);
			svo.setCreateDate(svo.getCreateDate());
			svo.setStsDate(SysDateUtil.getCurrentDate());
			workAreaExchMDao.deleteWorkAreaExch(svo);
		}
      }

	public void addWorkAreaExch(String[] exchIds, String workAreaId)
			throws SysException, AppException {
		WorkAreaExchSVO svo = new WorkAreaExchSVO();
		WorkAreaExchSVO wvo = new WorkAreaExchSVO();
		WorkAreaSVO was = new WorkAreaSVO();
		Date curDate = SysDateUtil.getCurrentDate();
		List list = null;
		if(null!= exchIds){
			for (int i = 0; i < exchIds.length; i++) {
				svo.setWorkAreaId(workAreaId);
				svo.setExchId(exchIds[i]);
				was.setWorkAreaId(workAreaId);
				was = (WorkAreaSVO) workAreaDao.findByPK(was);
				list = workAreaExchDao.findByVO(svo);
				if (list != null && list.size() > 0) {
					wvo = (WorkAreaExchSVO) list.get(0);
					wvo.setSts(Constant.STS_IN_USE);
					wvo.setStsDate(curDate);
					workAreaExchMDao.updateWorkAreaExch(wvo);
					
				} else {
					wvo.setWorkAreaExchId(MaxId
							.getSequenceNextVal(Constant.SEQ_WORK_AREA_EXCH_ID));
					wvo.setExchId(exchIds[i]);
					wvo.setWorkAreaId(workAreaId);
					wvo.setSts(Constant.STS_IN_USE);
					wvo.setCreateDate(curDate);
					wvo.setStsDate(curDate);
					workAreaExchMDao.addWorkAreaExch(wvo);
					
				}
			}
		}

	}

	/**
	 * ����WorkAreaId����������Ӧ������ExchSVO
	 * 
	 * @param vo
	 * @return List<ExchSVO>
	 * @throws SysException
	 * @throws AppException
	 */
	public List findExchSVOByWorkAreaId(WorkAreaExchSVO vo)
			throws SysException, AppException {

		return workAreaExchMDao.findExchByWorkAreaSVO(vo);
	}

	/**
	 * ����ExchId���Ҷ�Ӧ������Ա����Ϣ
	 * 
	 * @param vo
	 * @return List<StaffMVO>
	 * @throws SysException
	 * @throws AppException
	 */
	public List findStaffMVOByExchId(WorkAreaExchSVO vo) throws SysException,
			AppException {
		return staffDao.findStaffMVOByExchId(vo);
	}

	/**
	 * ����ExchId��StepId���Ҷ�Ӧ�Ĺ�����Ϣ
	 * 
	 * @param vo
	 * @return String
	 * @throws SysException
	 * @throws AppException
	 */
	public String findWorkAreaByExchAndStep(String exchId, String stepId)
			throws SysException, AppException {
		String workAreaId = null;
		workAreaId = workAreaExchMDao.findWorkAreaByExchAndStep(exchId, stepId);
		return workAreaId;
	}

	public List findByVO(WorkAreaExchSVO vo) throws SysException, AppException {
		return workAreaExchDao.findByVO(vo);
	}
	
	/**
	 * @author yangkai 2009-9-1
	 * @param vo
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public List findWorkAreaUnSel(WorkAreaExchMVO vo) throws SysException,
	AppException {
		List vos = new ArrayList();
		if (log.isDebugEnabled())
			log.debug("��ʼ��δѡ��Ĺ�����" + vo.getExchId());
		if (vo.getExchId() == null)
			return vos;
		log.debug("����id:"+vo.getExchId()+";;;��������id��"+vo.getWorkTypeId());
		vos = workAreaExchMDao.findWorkAreaUnSel(vo);		
		return vos;
		}
	
	public String addExchWorkArea(String[] workAreaIds, String exchId)
	throws SysException, AppException {
		String result=null;
		WorkAreaExchSVO wvo = new WorkAreaExchSVO();
		WorkAreaExchMVO mvo=new WorkAreaExchMVO();
		WorkAreaExchMVO lvo=new WorkAreaExchMVO();
		WorkAreaSVO wasvo=new WorkAreaSVO();
		mvo.setExchId(exchId);
		List list = new ArrayList();
		list = workAreaExchMDao.findWorkAreaExchs(mvo);//���й����б�
		Date curDate = SysDateUtil.getCurrentDate();
		for (int i = 0; i < workAreaIds.length; i++) {
			wasvo.setWorkAreaId(workAreaIds[i]);
			wasvo = (WorkAreaSVO) workAreaDao.findByPK(wasvo);
			log.debug("��������Ϊ��"+wasvo.getWorkTypeId());
			for(int j=0;j<list.size();j++){
				lvo=(WorkAreaExchMVO)list.get(j);				
				if((lvo.getWorkAreaId()).equals(wasvo.getWorkAreaId())){//����Ѿ���ӹ����������쳣
					result="�����ظ����乤����";
					return result;
				}
			        //throw new AppException("2300001","�����ظ����乤����");	//������쳣��Ӧ���׳�
				log.debug("lvo.getWorkTypeId():"+lvo.getWorkTypeId());
				log.debug("wasvo.getWorkTypeId():"+wasvo.getWorkTypeId());
		        if((lvo.getWorkTypeId()).equals(wasvo.getWorkTypeId())){
		        	//���Ҫ���ӵĹ����Ĺ������������еĹ���������ͬ�����쳣
		        	result="��������乤��ʱ��ֻ����ÿ��������������ѡ��һ��������";
		        	return result;
			        //throw new AppException("2300002","��������乤��ʱ��ֻ����ÿ��������������ѡ��һ��������");	
		        }		       
			        	
	       }
	       //forѭ�����������û���׳��쳣��˵��������������ͻ�������ִ������	
//		WorkAreaExchSVO vo = new WorkAreaExchSVO();
//		List li=new ArrayList();
//		vo.setExchId(exchId);
//		vo.setWorkAreaId(workAreaIds[i]);
//		li=workAreaExchDao.findByVO(vo);
//		if(li!=null && li.size()>0)
//			result="�Ѵ��ھ�����";
		wvo.setWorkAreaExchId(MaxId
				.getSequenceNextVal(Constant.SEQ_WORK_AREA_EXCH_ID));
		wvo.setExchId(exchId);
		wvo.setWorkAreaId(workAreaIds[i]);
		wvo.setSts(Constant.STS_IN_USE);
		wvo.setCreateDate(curDate);
		wvo.setStsDate(curDate);
		workAreaExchMDao.addWorkAreaExch(wvo);		
	}
		return result;
		
}
	}
