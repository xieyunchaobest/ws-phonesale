package com.cattsoft.sm.component.domain;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.MaxId;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sm.component.dao.IStaffSDAO;
import com.cattsoft.sm.component.dao.IStaffWorkAreaMDAO;
import com.cattsoft.sm.component.dao.IStaffWorkAreaSDAO;
import com.cattsoft.sm.component.dao.IWorkAreaSDAO;
import com.cattsoft.sm.vo.StaffSVO;
import com.cattsoft.sm.vo.StaffWorkAreaMVO;
import com.cattsoft.sm.vo.StaffWorkAreaSVO;
import com.cattsoft.sm.vo.WorkAreaSVO;
import com.cattsoft.sm.component.dao.IActionLogSDAO;
import com.cattsoft.sm.vo.ActionLogSVO;
import com.cattsoft.webpub.util.SysDateUtil;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-10 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class StaffWorkAreaDOM {
	
    private static Logger log = Logger.getLogger(StaffWorkAreaDOM.class);

    private IStaffWorkAreaMDAO staffWorkAreaMDao = (IStaffWorkAreaMDAO) DAOFactory.getInstance()
            .getDAO(IStaffWorkAreaMDAO.class);

    private IStaffWorkAreaSDAO staffWorkAreaSDao = (IStaffWorkAreaSDAO) DAOFactory.getInstance()
            .getDAO(IStaffWorkAreaSDAO.class);

    private IWorkAreaSDAO workAreaDao = (IWorkAreaSDAO) DAOFactory.getInstance().getDAO(
            IWorkAreaSDAO.class);

    private IStaffSDAO staffDao = (IStaffSDAO) DAOFactory.getInstance().getDAO(IStaffSDAO.class);
    
    public List findStaffWorkAreaByMvo(StaffWorkAreaMVO mvo) throws SysException, AppException {
        return staffWorkAreaMDao.findStaffWorkAreaByVo(mvo,mvo.getLocalNetId());

    }

    /**
     * �޸�Ա����Ӧ�Ĺ�����¼
     * 
     * @param vo
     *            StaffWorkAreaVO
     * @throws SysException
     * @throws AppException
     */
    public void modStaffWorkArea(StaffWorkAreaSVO vo) throws SysException, AppException {
        try {
            staffWorkAreaSDao.update(vo);
        } catch (SysException se) {
            throw new SysException("222", "modStaffWorkArea", se);
        }

    }

    public String getWorkStaff4MOS(String staffWorkAreaMVOJson){
    	StaffWorkAreaMVO staffWorkAreaMVO = JSONObject.parseObject(staffWorkAreaMVOJson, StaffWorkAreaMVO.class);
    	List list = null;
       try {
		list = staffWorkAreaMDao.findLabeBeanByStaffWorkArea(staffWorkAreaMVO);
	   } catch (SysException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (AppException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   String listString = JSON.toJSONString(list);
	   return listString;
    }
    /**
     * ��ѯ����staffworkareasvo��Ϣ
     * 
     * @param vo
     * @return List<StaffWorkAreaSVO>
     * @throws SysException
     * @throws AppException
     */
    public List findStaffWorkArea(StaffWorkAreaSVO vo) throws SysException, AppException {
        return staffWorkAreaSDao.findByVO(vo);
    }
    
    
    public List getWorkStaff4MOS(StaffWorkAreaMVO staffWorkAreaMVO){
    	List list = null;
       try {
		list = staffWorkAreaMDao.findLabeBeanByStaffWorkArea(staffWorkAreaMVO);
	   } catch (SysException e) {
		e.printStackTrace();
	   } catch (AppException e) {
		e.printStackTrace();
	   }
	   return list;
    }
    /**
     * ����Ա����Ӧ�Ĺ�����¼
     * 
     * @param vo
     *            StaffWorkAreaVO
     * @throws SysException
     * @throws AppException
     * @return Long
     */
    public void addStaffWorkArea(String[] id, String staffId, String adminStaffId,ActionLogSVO aSVO)
            throws SysException, AppException {
        StaffWorkAreaSVO vo = new StaffWorkAreaSVO();
        vo.setGrantor(adminStaffId);
        vo.setAdminFlag("N");
//        // ͬ�����Ʒ� (����ǰ�ж��Ƿ���Ӫҵ����)
//        String flagStaffWorkArea = "0"; // ���ñ�־λΪ0ʱ,��ʾԱ����ǰ�޶�Ӧ��Ӫҵ����
//        StaffWorkAreaMVO staffWorkAreaMvo = new StaffWorkAreaMVO();
//        staffWorkAreaMvo.setStaffId(staffId);
//        staffWorkAreaMvo.setSts(Constant.STS_IN_USE);
//        List staffWorkAreas = this.findStaffWorkAreaByMvo(staffWorkAreaMvo); //�õ�����ǰԱ����Ӧ���������м�¼
//        // --ͬ�����Ʒ�
        try {
            for (int i = 0; i < id.length; i++) {
                vo.setWorkAreaId(id[i]);
                log.debug(i + "setWorkAreaId:" + vo.getWorkAreaId());
                vo.setStaffId(staffId);

                List list = this.findStaffWorkArea(vo);
                if (list != null && list.size() > 0) {
                    StaffWorkAreaSVO wvo = (StaffWorkAreaSVO) list.get(0);
                    if ("P".equals(wvo.getSts())) {
                        wvo.setSts("A");
                        this.modStaffWorkArea(wvo);
                        //added by yangkai ���Ӽ�¼��־ 2009-07-01
                        aSVO.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
                        aSVO.setActionText(":�޸�"+wvo.getWorkAreaId());
                        aSVO.setActionType(SysConstants.LOG_MOD);
                		IActionLogSDAO sDao = (IActionLogSDAO) com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
                		sDao.add(aSVO);

                    } else {
                        throw new AppException("3250005", "Ӧ�ô���,�Ѿ����ڴ�Ա����Ӧ�˹���");
                    }
                } else {

                    Date curDate = SysDateUtil.getCurrentDate();
                    // ȡ���к�
                    vo
                            .setStaffWorkAreaId(MaxId
                                    .getSequenceNextVal(Constant.SEQ_STAFF_WORK_AREA_ID));

                    // ����ֵ
                    vo.setCreateDate(curDate);
                    vo.setStsDate(curDate);
                    vo.setSts("A");
                    staffWorkAreaSDao.add(vo);
                  //added by yangkai ���Ӽ�¼��־ 2009-07-01
                    aSVO.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
                    aSVO.setActionText(aSVO.getActionText()+vo.getWorkAreaId());
                    IActionLogSDAO sDao = (IActionLogSDAO) com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
            		sDao.add(aSVO);
                }
            }
        } catch (SysException se) {
            throw new SysException("222", "addStaffWorkArea����", se);
        } catch (AppException ae) {
            throw new AppException("3333", "addStaffWorkArea����"+",��¼�ظ����Ѿ����ڴ�Ա����Ӧ�˹���"); // lijixu
        }
//        // ͬ�����Ʒ�
//        if (staffWorkAreas != null) {
//            for (int i = 0; i < staffWorkAreas.size(); i++) {
//                StaffWorkAreaMVO staffWorkAreaMvo1 = (StaffWorkAreaMVO) staffWorkAreas.get(i);
//                WorkAreaSVO workAreaSvo = new WorkAreaSVO();
//                workAreaSvo.setWorkAreaId(staffWorkAreaMvo1.getWorkAreaId());
//                String workType = ((WorkAreaSVO) workAreaDao.findByPK(workAreaSvo)).getWorkTypeId();
//                if ("1".equals(workType)) {
//                    flagStaffWorkArea = "1";
//                    break;
//                }
//            }
//        }
//        if ("0".equals(flagStaffWorkArea)) {
//            for (int i = 0; i < id.length; i++) {
//                String officeId = id[i];
//                WorkAreaSVO workAreaSvo = new WorkAreaSVO();
//                workAreaSvo.setWorkAreaId(officeId);
//                String workType = ((WorkAreaSVO) workAreaDao.findByPK(workAreaSvo)).getWorkTypeId();
//                if ("1".equals(workType)) {
//                    String name = null;
//                    String passWord = null; // ��ʼ����,Ĭ��
//                    String regionId = null; // ��Ϊ��;
//                    String actType = null; // M��ʾ�޸�
//                    Date createDate = null;
//                    Date expDate = null;
//                    java.util.Date effDate = null;
//                    String operType = "1"; // 0��ʾͬ��Ա��,1��ʾͬ������;
//                    SmIsDelegateDOM smIsDelegateDom = new SmIsDelegateDOM();
//                    smIsDelegateDom.workStaffSyn(staffId, officeId, name, passWord, regionId,
//                            actType, createDate, expDate, effDate, operType);
//                    break;
//                }
//            }
//        }
//        // ͬ�����Ʒ�
    }

    /**
     * ɾ��Ա����Ӧ�Ĺ�����Ϣ
     * 
     * @param id
     * @param localNetId
     * @throws SysException
     * @throws AppException
     */
    public void delStaffWorkArea(String[] id,ActionLogSVO aSVO) throws SysException, AppException {
        try {
        	//add by liyaquan 2009-09-15 actionText��������ʹ����̫�󳬹������С�ʴ˱���
        	String actionText = aSVO.getActionText();
            StaffWorkAreaSVO vo = new StaffWorkAreaSVO();
            Date curDate = SysDateUtil.getCurrentDate();
            for (int i = 0; i < id.length; i++) {
                vo.setStsDate(curDate);
                vo.setSts("P");
                vo.setStaffWorkAreaId(id[i]);
                staffWorkAreaSDao.update(vo);
                
                //added by yangkai ���Ӽ�¼��־ 2009-07-01
                /*modi by liyaquan 2009-09-15 actionText��������ʹ����̫�󳬹������С�ʴ˱���*/
                StaffWorkAreaSVO svo = (StaffWorkAreaSVO)staffWorkAreaSDao.findByPK(vo);
                aSVO.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
                //aSVO.setActionText(aSVO.getActionText()+svo.getWorkAreaId());
                aSVO.setActionText(actionText+svo.getWorkAreaId());
                IActionLogSDAO sDao = (IActionLogSDAO) com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
        		sDao.add(aSVO);
            }
        } catch (SysException se) {
            throw new SysException("222", "delStaffWorkArea����", se);
        } catch (AppException ae) {
            throw new AppException("3333", "delStaffWorkArea����");
        }
    }
    
    /**
     * ��Ӳ�����ʾ����
     * @param id
     * @param mvo
     * @param asvo
     */
	public List addDispStaffWorkArea(String[] id, StaffWorkAreaMVO mvo, ActionLogSVO asvo) 
			throws SysException, AppException {
	        try {
				String staffId = mvo.getStaffId();
				String adminFlag = mvo.getAdminFlag();
	        	StaffSVO staffsvo = new StaffSVO();
	        	staffsvo.setStaffId(staffId);
	        	staffsvo = (StaffSVO) staffDao.findByPK(staffsvo);
	        	if(staffsvo == null){
	    			List res = null;
	        		return res;
	        	}else{
	        		StaffWorkAreaSVO vo = new StaffWorkAreaSVO();
	        		vo.setGrantor(mvo.getGrantor());
	        		if (!adminFlag.equals("") && adminFlag != null) {
	        			vo.setAdminFlag(adminFlag);
					} else {
						vo.setAdminFlag("N");
					}
		            for (int i = 0; i < id.length; i++) {
		                vo.setWorkAreaId(id[i]);
		                log.debug(i + "setWorkAreaId:" + vo.getWorkAreaId());
		                vo.setStaffId(staffId);

		                List list = this.findStaffWorkArea(vo);
		                if (list != null && list.size() > 0) {
		                    StaffWorkAreaSVO wvo = (StaffWorkAreaSVO) list.get(0);
		                    if ("P".equals(wvo.getSts())) {
		                        wvo.setSts("A");
		                        this.modStaffWorkArea(wvo);
		                        asvo.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
		                        asvo.setActionText(":�޸�"+wvo.getWorkAreaId());
		                        asvo.setActionType(SysConstants.LOG_MOD);
		                		IActionLogSDAO sDao = (IActionLogSDAO) com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
		                		sDao.add(asvo);
		                    } else {
		                        throw new AppException("3250005", "Ӧ�ô���,�Ѿ����ڴ�Ա����Ӧ�˹���");
		                    }
		                } else {
		                    Date curDate = SysDateUtil.getCurrentDate();
		                    // ȡ���к�
		                    vo.setStaffWorkAreaId(MaxId
		                                    .getSequenceNextVal(Constant.SEQ_STAFF_WORK_AREA_ID));
		                    // ����ֵ
		                    vo.setCreateDate(curDate);
		                    vo.setStsDate(curDate);
		                    vo.setSts("A");
		                    staffWorkAreaSDao.add(vo);
		                    asvo.setActionId(MaxId.getSequenceNextVal(SysConstants.ACTION_LOG_SEQ));
		                    asvo.setActionText(asvo.getActionText()+vo.getWorkAreaId());
		                    IActionLogSDAO sDao = (IActionLogSDAO) com.cattsoft.pub.dao.DAOFactory.getDAO(IActionLogSDAO.class);
		            		sDao.add(asvo);
		                	}
		            	}
		            StaffWorkAreaMVO vvo = new StaffWorkAreaMVO();
		            vvo.setSts("A");
		            vvo.setStaffId(staffId);
		            log.debug("addDispStaffWorkArea:" + vvo.getStaffId());
		            vvo.setLocalNetId(mvo.getLocalNetId());
		            return staffWorkAreaMDao.findStaffWorkAreaByVo(vvo,mvo.getLocalNetId());
	        		}
		        } catch (SysException se) {
		            throw new SysException("222", "addDispStaffWorkArea", se);
		        } catch (AppException ae) {
		            throw new AppException("3333", "addDispStaffWorkArea");
		        }
			}
	
	/**
     * ������ԱȨ����Ϣ
     * @author LIJINGJUN
     * @param vo
     *            StaffWorkAreaVO
     * @throws SysException
     * @throws AppException
     * @return Long
     */
    public void addStaffWorkAreaByVo(StaffWorkAreaSVO vo)
            throws SysException, AppException {
        try {
        	StaffWorkAreaSVO svo = new StaffWorkAreaSVO();
        	String[] idArray = vo.getStaffId().split(",");
        	
        	Date curDate = null;
    		for (int i = 0; i < idArray.length; i++) {
    			if(!"".equals(idArray[i])){
    				svo = new StaffWorkAreaSVO();
        			svo.setStaffId(idArray[i]);
        			svo.setWorkAreaId(vo.getWorkAreaId());
        			svo.setSts("A");
                	List voList = findStaffWorkArea(svo);
                	if(null == voList || voList.size()== 0 ){
                		 curDate = SysDateUtil.getCurrentDate();
                         // ȡ���к�
                		 
                        svo
                                 .setStaffWorkAreaId(MaxId
                                         .getSequenceNextVal(Constant.SEQ_STAFF_WORK_AREA_ID));
                         svo.setAdminFlag(vo.getAdminFlag());
                         svo.setGrantor(vo.getGrantor());
                         svo.setCreateDate(curDate);
                         svo.setStsDate(curDate);
                         svo.setSts("A");
                         staffWorkAreaSDao.add(svo);
        		   }		
    			}
    			
        }
                   
        } catch (SysException se) {
            throw new SysException("222", "addStaffWorkAreaByVo����", se);
        } catch (AppException ae) {
            throw new AppException("3333", "addStaffWorkAreaByVo����");
        }
    }
    
    /**
     * ɾ��Ա����Ӧ�Ĺ�����Ϣ
     * @author LIJINGJUN
     * @param id
     * @param localNetId
     * @throws SysException
     * @throws AppException
     */
    public void delStaffWorkAreaByVo(String workAreaId,String staffId) throws SysException, AppException {
        try {
            StaffWorkAreaSVO vo = new StaffWorkAreaSVO();
            vo.setWorkAreaId(workAreaId);
            vo.setStaffId(staffId);
            vo.setSts("A");
            List voList = findStaffWorkArea(vo);
            if(null != voList && voList.size()!=0){
            	vo = (StaffWorkAreaSVO)voList.get(0);
            	 Date curDate = SysDateUtil.getCurrentDate();
                 vo.setStsDate(curDate);
                 vo.setSts("P");
                 staffWorkAreaSDao.update(vo);
            }
           
        } catch (SysException se) {
            throw new SysException("222", "delStaffWorkArea����", se);
        } catch (AppException ae) {
            throw new AppException("3333", "delStaffWorkArea����");
        }
    }
}
