package com.cattsoft.sm.component.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.pub.util.PasswordUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sm.component.dao.IOrgDeptSDAO;
import com.cattsoft.sm.component.dao.IStaffMDAO;
import com.cattsoft.sm.component.dao.IStaffSDAO;
import com.cattsoft.sm.component.dao.ISysConfigSDAO;
import com.cattsoft.sm.component.dao.ISysUserSDAO;
import com.cattsoft.sm.util.SMMaxId;
import com.cattsoft.sm.vo.ContactMediumSVO;
import com.cattsoft.sm.vo.LocalNetSVO;
import com.cattsoft.sm.vo.OrgDeptSVO;
import com.cattsoft.sm.vo.PartyIdentitySVO;
import com.cattsoft.sm.vo.PartyRoleSVO;
import com.cattsoft.sm.vo.PartySVO;
import com.cattsoft.sm.vo.StaffMVO;
import com.cattsoft.sm.vo.StaffSVO;
import com.cattsoft.sm.vo.SysConfigSVO;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.webpub.util.SysDateUtil;
import com.linkage.component.bean.adm.Encryptor;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-7 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class StaffDOM {

	private IStaffSDAO staffDao = (IStaffSDAO) DAOFactory.getInstance().getDAO(
			IStaffSDAO.class);

	private IStaffMDAO staffMDao = (IStaffMDAO) DAOFactory.getInstance()
			.getDAO(IStaffMDAO.class);

	private IOrgDeptSDAO orgDeptDao = (IOrgDeptSDAO) DAOFactory.getInstance()
			.getDAO(IOrgDeptSDAO.class);

	private ISysUserSDAO sysUserDao = (ISysUserSDAO) DAOFactory.getInstance()
			.getDAO(ISysUserSDAO.class);

	private ISysConfigSDAO sysConfigDao = (ISysConfigSDAO) DAOFactory
			.getInstance().getDAO(ISysConfigSDAO.class);

	private static Logger log = Logger.getLogger(StaffDOM.class);

	/**
	 * ����Ա���õ�Ա����Ӧ����������������Ϣ
	 * 
	 * @param info
	 * @return List
	 * @throws SysException
	 * @throws AppException
	 */
	public List getStaffLocalNetVOs(Long staffId, String systemName)
			throws AppException, SysException {
		List staff = staffMDao.getStaffLocalNetVOs(staffId, systemName);
		if (staff == null) {
			return null;
		}
		return staff;
	}

	/**
	 * ����Ա���õ�Ա����Ӧ����������������Ϣ
	 * 
	 * @param info
	 * @return List
	 * @throws SysException
	 * @throws AppException
	 */
	public List getStaffLocalNetVOs4Mobile(Map paraMap) throws AppException,
			SysException {
		String staffId = (String) paraMap.get(SysConstants.PARA_MAP_STAFF_ID);
		String systemName = (String) paraMap
				.get(SysConstants.PARA_MAP_SYSTEM_NAME);
		List staff = staffMDao.getStaffLocalNetVOs(staffId, systemName);
		if (staff == null) {
			return null;
		}
		return staff;
	}

	public String getStaffLocalNetVOs4MOS(String json) throws AppException,
			SysException {

		JSONObject jsonObject = JSONObject.fromObject(json);

		String systemName = (String) jsonObject.get("systemName");
		String staffId = (String) jsonObject.get("staffId");
		String LocalNetId = (String) jsonObject.get("localNetId");
		List staffLns = staffMDao.getStaffLocalNetVOs(staffId, systemName);
		List staffLnsToJson = new ArrayList();
		for (int i = 0; i < staffLns.size(); i++) {
			LocalNetSVO localNetSVO = (LocalNetSVO) staffLns.get(i);

			java.util.Date stsDate = new java.util.Date(localNetSVO
					.getStsDate().getTime());
			java.util.Date createDate = new java.util.Date(localNetSVO
					.getCreateDate().getTime());
			localNetSVO.setStsDate(stsDate);
			localNetSVO.setCreateDate(createDate);
			staffLnsToJson.add(localNetSVO);
			System.out.print("=======" + localNetSVO.getStsDate());

		}
		JSONArray jsonArray1 = JSONArray.fromObject(staffLnsToJson);
		if (jsonArray1 == null) {
			return null;
		}
		return jsonArray1.toString();
	}

	/**
	 * ����Ա���õ�Ա����Ӧ����������������Ϣ
	 * 
	 * @param info
	 * @return List
	 * @throws SysException
	 * @throws AppException
	 */
	public List getStaffLocalNetVOs(String staffId, String systemName)
			throws AppException, SysException {
		List staff = staffMDao.getStaffLocalNetVOs(staffId, systemName);
		if (staff == null) {
			return null;
		}
		return staff;
	}

	/**
	 * ��ҳ��ѯԱ��(���ݲ��Ų�ѯ,��ѯ���ż��������������ŷ���������Ա����Ϣ)
	 * 
	 * @param ovo
	 * 
	 * @param pagInfo
	 * @throws SysException
	 * @throws AppException
	 * @return pagview
	 */
	public PagView findStaff(StaffMVO ovo, PagInfo pagInfo)
			throws SysException, AppException {
		List oList = null;
		String dpstr = null;
		if (ovo.getPartyRoleType().equals(Constant.PARTY_ROLE_TYPE_ORG_DEPT)) {

			// OrgDeptDOM odom = new OrgDeptDOM();
			// dpstr=odom.findIdByPro(ovo.getStaffSVO().getDeptId());
			dpstr = ovo.getStaffSVO().getDeptId();
			// oList = odom.findSubDeptByMap(ovo.getStaffSVO().getDeptId());
		}
		return staffMDao.findStaffMemberFast(ovo, pagInfo, oList, dpstr);

	}

	/**
	 * ���ݿ���Ŀ�꣬��ȡ����Ŀ�����
	 * 
	 * @param ovo
	 * @param pagInfo
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public PagView findStaffMemberPer(StaffMVO ovo, PagInfo pagInfo)
			throws SysException, AppException {
		List oList = null;
		String dpstr = null;
		if (ovo.getPartyRoleType().equals(Constant.PARTY_ROLE_TYPE_ORG_DEPT)) {
			dpstr = ovo.getStaffSVO().getDeptId();
		}
		return staffMDao.findStaffMemberPer(ovo, pagInfo, oList, dpstr);

	}
	/**
	 * ѡȡ����������ʱ���г�Ա���б�
	 * @param vo
	 * @param pagInfo
	 * @param oList
	 * @param deptIds
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public PagView findStaffMemberForCheker(StaffMVO ovo, PagInfo pagInfo)
			throws SysException, AppException {
		List oList = null;
		String dpstr = null;
		if (Constant.PARTY_ROLE_TYPE_ORG_DEPT.equals(ovo.getPartyRoleType())) {
			dpstr = ovo.getStaffSVO().getDeptId();
		}
		return staffMDao.findStaffMemberForCheker(ovo, pagInfo, oList, dpstr);

	}

	/**
	 * �޸�Ա����Ϣ,ֻ�ǲ��ݵ���(��Ҫ�����޸�Ա������Ӧ��֯�ṹ��Ϣ)
	 * 
	 * @param ovo
	 * @param localNetId
	 * @return void
	 * @throws SysException
	 * @throws AppException
	 */
	public void modStaffOnly(StaffSVO ovo, String localNetId)
			throws SysException, AppException {
		OrgDeptSVO odv = new OrgDeptSVO();
		PartySVO psvo = new PartySVO();
		PartyDOM pdom = new PartyDOM();
		StaffMVO smvo = new StaffMVO();
		try {
			staffDao.update(ovo);
			// ��֯�����޸ĺ�Ӧ���ж��µ���֯�����ı�����ID�ͷ�����ID��ԭ�����Ƿ�һ�£���һ�����޸ġ�
			smvo = staffMDao.findStaffMemberByStaffId(ovo.getStaffId());
			odv.setDeptId(smvo.getStaffSVO().getDeptId());
			odv = (OrgDeptSVO) orgDeptDao.findByPK(odv);
			psvo = smvo.getPartySVO();
			log.debug("psvo:" + psvo);
			log.debug("odv:" + odv);
			if (!odv.getLocalNetId().equals(psvo.getLocalNetId())
					|| !odv.getAreaId().equals(psvo.getAreaId())
					|| !odv.getServDeptId().equals(psvo.getServDeptId())
					|| !odv.getBranchId().equals(psvo.getBranchId())) {// if
				// �������ͷ�������ͬ�����޸�Ա��Party��
				psvo.setLocalNetId(odv.getLocalNetId());
				psvo.setAreaId(odv.getAreaId());
				psvo.setServDeptId(odv.getServDeptId());
				psvo.setBranchId(odv.getBranchId());
				pdom.update(psvo);
			}
		} catch (Exception ex) {
			throw new SysException("333", "modStaffOnly", ex);

		}
		// // ͬ�����Ʒ�//
		//        
		// Date curDate = SysDateUtil.getCurrentDate();
		// String staffId = smvo.getStaffSVO().getStaffId();
		// String officeId = odv.getDeptId();
		// String name = psvo.getName();
		// String passWord = "666666"; // ��ʼ����,Ĭ��
		// String regionId = "311"; // TODO �ݶ���;
		// String actType = "M"; // M��ʾ�޸�
		// Date createDate = curDate;
		// Date effDate = curDate;
		// java.util.Date expDate;
		// try {
		// expDate = DateUtil.to_date("2020-10-17", "yyyy-MM-dd");
		// } catch (Exception e) {
		// throw new AppException("001001", "ͬ��Ա��ʱʱ��ת���쳣");
		// }
		// String operType = "0"; // 0��ʾͬ��Ա��,1��ʾͬ������;
		// SmIsDelegateDOM smIsDelegateDom = new SmIsDelegateDOM();
		// smIsDelegateDom.workStaffSyn(staffId, officeId, name, passWord,
		// regionId, actType,
		// createDate, expDate, effDate, operType);
		// // ͬ�����Ʒ�//

		// ͬ������Դ//
		// String[] backStr = staffMDao.updateStaffMVOByRs(smvo,
		// Constant.STAFF_ACT_TYPE_R);
		// if (backStr[0].equals("-1")) {
		// throw new AppException("3333", "ͬ����Դ����,ԭ��Ϊ:" + backStr[1]);
		// }
		// ͬ������Դ//

	}

	/**
	 * ��ѯԱ����Ϣ(ֻ���ڵ���)
	 * 
	 * @param staffId
	 * @return StaffSVO
	 * @throws SysException
	 * @throws AppException
	 */
	public StaffSVO findStaffByPk(String staffId) throws SysException,
			AppException {
		StaffSVO vo = new StaffSVO();
		vo.setStaffId(staffId);
		return (StaffSVO) staffDao.findByPK(vo);
	}

	/**
	 * ���µ�����Ϣ(��Ҫ���ڸ��¼��ֶ�)
	 * 
	 * @param vo
	 * @throws SysException
	 * @throws AppException
	 */
	public void update(StaffSVO vo) throws SysException, AppException {
		staffDao.update(vo);
	}

	/**
	 * ����������ѯstaffmvo
	 * 
	 * @param staffId
	 * @return Staffmvo
	 * @throws SysException
	 * @throws AppException
	 */
	public StaffMVO findStaffMVOByPK(String staffId) throws SysException,
			AppException {
		return staffMDao.findStaffMemberByStaffId(staffId);
	}

	/**
	 * ���Ӷ��staffmvo
	 * 
	 * @param vo
	 * @throws SysException
	 * @throws AppException
	 */
	public String addStaffMVO(StaffMVO vo) throws Exception, AppException {
		String staffId = null;
		PartySVO psvo = new PartySVO();
		StaffSVO svo = new StaffSVO();
		Date curDate = null;
		Timestamp curTime = null;
		try {
			PartyRoleSVO prsvo = new PartyRoleSVO();
			PartyRoleDOM prdom = new PartyRoleDOM();
			PartyDOM partyDom = new PartyDOM();
			// ȡϵͳ����
			curDate = SysDateUtil.getCurrentDate();
			curTime = SysDateUtil.getCurrentTimestamp();

			svo = vo.getStaffSVO();
			psvo = vo.getPartySVO();

			// �ж��Ƿ�Ϊ�����̴���Ա��,�����Ա���ı�����,������,Ӫά����,֧�ָ��ݴ�������ȡ
			if (vo.getPartyRoleType().equals(Constant.PARTY_ROLE_TYPE_MS_AGENT)) {

				prsvo.setPartyRoleTypeId(Constant.PARTY_ROLE_TYPE_MS_AGENT);
				prsvo.setPartyRoleId(svo.getCompanyCode());
				prsvo = prdom.findByPk(prsvo);
				if (prsvo == null)
					throw new AppException("222", "�����ڴ˴�����!");
				PartySVO apsvo = new PartySVO();
				apsvo.setPartyId(prsvo.getPartyId());
				apsvo = partyDom.findByPk(apsvo);

				psvo.setLocalNetId(apsvo.getLocalNetId());
				psvo.setAreaId(apsvo.getAreaId());
				psvo.setServDeptId(apsvo.getServDeptId());
				psvo.setBranchId(apsvo.getBranchId());

				svo.setDeptType(Constant.STAFF_DEPT_TYPE_E);

			}

			if (vo.getPartyRoleType().equals(Constant.PARTY_ROLE_TYPE_ORG_DEPT)) {
				OrgDeptSVO odvo = new OrgDeptSVO();
				odvo.setDeptId(vo.getStaffSVO().getDeptId());
				odvo = (OrgDeptSVO) orgDeptDao.findByPK(odvo);
				vo.setDeptName(odvo.getDeptName());

				// ��party���ӱ�����,������,ֱ��,Ӫ������ ��ȡ��֯������
				psvo.setLocalNetId(odvo.getLocalNetId());
				psvo.setAreaId(odvo.getAreaId());
				psvo.setServDeptId(odvo.getServDeptId());
				psvo.setBranchId(odvo.getBranchId());

				svo.setDeptType(Constant.STAFF_DEPT_TYPE_I);
				svo.setCompanyCode("0");
			}

			psvo.setSts(Constant.STS_IN_USE);
			psvo.setPartyType(Constant.PARYT_TYPE_I);
			psvo.setCreateDate(curTime);
			psvo.setStsDate(curTime);

			String partyId = partyDom.add(psvo);
			// ������˶�Ӧ֤����Ϣ��,��ϵ��Ϣ���������

			if (vo.getCertCode() != null || vo.getCertTypeId() != null
					|| vo.getCertExpDate() != null) {
				PartyIdentitySVO isvo = new PartyIdentitySVO();
				PartyIdentityDOM pidom = new PartyIdentityDOM();
				isvo.setPartyId(partyId);
				isvo.setLocalNetId(psvo.getLocalNetId());
				isvo.setCertCode(vo.getCertCode());
				isvo.setCertTypeId(vo.getCertTypeId());
				isvo.setCertExpDate(vo.getCertExpDate());
				isvo.setSts(Constant.STS_IN_USE);
				isvo.setCreateDate(curDate);
				isvo.setStsDate(curDate);
				pidom.add(isvo);

			}
			// /����ͨû��contactMedium��
			// if (vo.getPostalCode() != null || vo.getContactAddr() != null) {
			// ContactMediumSVO cmsvo = new ContactMediumSVO();
			// ContactMediumDOM cmdom = new ContactMediumDOM();
			// cmsvo.setPartyId(partyId);
			// cmsvo.setPostalCode(vo.getPostalCode());
			// cmsvo.setContactAddr(vo.getContactAddr());
			// cmsvo.setSts(Constant.STS_IN_USE);
			// cmsvo.setCreateDate(curDate);
			// cmsvo.setStsDate(curDate);
			// cmdom.add(cmsvo);
			// }
			// ��Ա��������¼
			svo.setPartyId(partyId);
			svo.setSts(Constant.STS_IN_USE);
			svo.setCreateDate(curTime);
			svo.setStsDate(curTime);
			svo.setLocalNetId(psvo.getLocalNetId());
			staffId = SMMaxId.getStaffMaxId(psvo.getLocalNetId(), psvo
					.getAreaId());
			svo.setStaffId(staffId);
			int i=0;
			while (staffDao.findByPK(svo) != null) {
				i++;
				staffId = String.valueOf(Long.parseLong(SMMaxId.getStaffMaxId(
						psvo.getLocalNetId(), psvo.getAreaId())) + i);
				svo.setStaffId(staffId);
			}
			staffDao.add(svo);
			// �ж��Ƿ�Ϊ�Զ������û�,�����,�Զ������û�.
			SysConfigSVO scsvo = new SysConfigSVO();
			scsvo.setConfigId("21001");
			scsvo = (SysConfigSVO) sysConfigDao.findByPK(scsvo);
			if (scsvo.getCurValue().equals("Y")) {
				SysUserSVO susvo = new SysUserSVO();
				susvo.setSysUserId(staffId);
				susvo.setPartyRoleId(staffId);
				susvo.setPartyRoleTypeId("7");
				susvo.setSysUserName(staffId);
				susvo.setLocalNetId(psvo.getLocalNetId());
				scsvo.setConfigId("21002");
				scsvo = (SysConfigSVO) sysConfigDao.findByPK(scsvo);
				// added by yangkai 2009-8-26
				// �����㷨ѡ�������N��û��������ʹ��MD5�㷨������Ϊ�����ṩ���㷨
				String flag = SysConfigData.getSysConfigCurValue("110010",
						null, null, null, null, null);
				if (flag == null || flag.equals(SysConstants.PWD_FLAG))
					susvo.setPassword(PasswordUtil.getMD5Str(scsvo
							.getCurValue()));
				else
					susvo.setPassword(Encryptor.fnEncrypt(scsvo.getCurValue(),
							"00linkage"));
				susvo.setCreateDate(curTime);
				susvo.setSts(Constant.STS_IN_USE);
				susvo.setSetPwdTime(curTime);
				susvo.setStsDate(curTime);
				sysUserDao.add(susvo);
				vo.setSysUserId(susvo.getSysUserId());
				vo.setPassWord(susvo.getPassword());
			}

			// ���Ӧ��ɫ������¼
			prsvo.setPartyId(partyId);
			prsvo.setPartyRoleId(staffId);
			prsvo.setPartyRoleTypeId(Constant.PARTY_ROLE_TYPE_STAFF);// 7��ʾΪԱ��
			prsvo.setLocalNetId(psvo.getLocalNetId());
			prdom.add(prsvo);
		} catch (SysException se) {
			throw new SysException("222", "addStaffMVO����", se);
		} catch (AppException se) {
			throw new AppException("111", "addStaffMVO����");
		}
		// // ͬ�����Ʒ�//
		// /*
		// String officeId = svo.getDeptId();
		// String name = psvo.getName();
		// String passWord = "666666"; // ��ʼ����,Ĭ��
		// String regionId = "311"; // TODO �ݶ���;
		// String actType = "A"; // A��ʾ����
		// Date createDate = curDate;
		// Date effDate = curDate;
		// java.util.Date expDate = DateUtil.to_date("2020-10-17",
		// "yyyy-MM-dd");
		// String operType = "0"; // 0��ʾ������Ա��,1��ʾ���ӹ���;
		// SmIsDelegateDOM smIsDelegateDom = new SmIsDelegateDOM();
		// String retStaff = smIsDelegateDom.workStaffSyn(staffId, officeId,
		// name, passWord,
		// regionId,
		// actType, createDate, expDate, effDate, operType);
		// staffId = staffId + "\t" + retStaff;
		// ͬ�����Ʒ�//

		// ͬ������Դ//
		// String[] backStr = staffMDao.updateStaffMVOByRs(vo,
		// Constant.STAFF_ACT_TYPE_A);
		// if (backStr[0].equals("-1")) {
		// throw new AppException("3333", "ͬ����Դ����,ԭ��Ϊ:" + backStr[1]);
		// }

		return staffId;

	}

	/**
	 * ɾ�����staffmvo
	 * 
	 * @param vo
	 * @throws SysException
	 * @throws AppException
	 */
	public void delStaffMVOByOnly(StaffSVO vo) throws SysException,
			AppException {
		SysUserSVO susvo = new SysUserSVO();
		susvo.setPartyRoleId(vo.getStaffId());
		susvo.setPartyRoleTypeId(Constant.PARTY_ROLE_TYPE_STAFF);
		susvo.setSts(Constant.STS_IN_USE);

		List list = sysUserDao.findByVO(susvo);
		// �ж��Ƿ�Ϊ�Զ������û�,�����,�Զ�ɾ�����и�Ա�����û�.
		SysConfigSVO scsvo = new SysConfigSVO();
		scsvo.setConfigId("21001");
		scsvo = (SysConfigSVO) sysConfigDao.findByPK(scsvo);
		if (scsvo.getCurValue().equals("Y")) {
			if (list != null) {
				Iterator it = list.iterator();
				while (it.hasNext()) {
					susvo = (SysUserSVO) it.next();
					susvo.setSts("P");
					sysUserDao.update(susvo);
				}
			}
		} else {
			if (list != null) {
				throw new AppException("111", "ɾ��Ա�����ִ��󣬸�Ա�������û�");
			}
		}
		Date curDate = SysDateUtil.getCurrentDate();
		/*
		 * PartyDOM pdom = new PartyDOM(); PartySVO psvo = new PartySVO();
		 * psvo.setPartyId(vo.getPartyId()); psvo.setStsDate(curDate);
		 * pdom.delete(psvo);
		 * 
		 * PartyIdentityDOM pidom = new PartyIdentityDOM(); ContactMediumDOM
		 * cmdom = new ContactMediumDOM(); PartyIdentitySVO pisvo = new
		 * PartyIdentitySVO(); ContactMediumSVO cmsvo = new ContactMediumSVO();
		 * pisvo.setPartyId(vo.getPartyId()); pisvo.setSts("A");
		 * cmsvo.setPartyId(vo.getPartyId()); cmsvo.setSts("A");
		 * 
		 * List piList = pidom.findByVo(pisvo); if (piList != null) { pisvo =
		 * (PartyIdentitySVO) piList.get(0); pisvo.setStsDate(curDate);
		 * pidom.delete(pisvo); } List cmList = cmdom.findByVo(cmsvo); if
		 * (cmList != null) { cmsvo = (ContactMediumSVO) cmList.get(0);
		 * cmsvo.setStsDate(curDate); cmdom.delete(cmsvo); }
		 */
		vo.setStsDate(SysDateUtil.getCurrentTimestamp());
		vo.setSts(Constant.STS_HISTORY);
		staffDao.update(vo);

		PartyRoleSVO prsvo = new PartyRoleSVO();
		PartyRoleDOM pdom = new PartyRoleDOM();

		prsvo.setPartyRoleId(vo.getStaffId());
		prsvo.setPartyRoleTypeId(Constant.PARTY_ROLE_TYPE_STAFF);
		pdom.delete(prsvo);

		// ͬ�����Ʒ�
		/*
		 * String staffId = vo.getStaffId(); String officeId = vo.getDeptId();
		 * String name = null; String passWord = "666666"; // ��ʼ����,Ĭ�� String
		 * regionId = "311"; // TODO �ݶ���; String actType = "D"; // D��ʾɾ�� Date
		 * createDate = curDate; Date effDate = curDate; java.util.Date expDate;
		 * try { expDate = DateUtil.to_date("2020-10-17", "yyyy-MM-dd"); } catch
		 * (Exception e) { // TODO Auto-generated catch block throw new
		 * AppException("0.0", "ͬ��Ա��ʱ��ת������"); } String operType = "0"; //
		 * 0��ʾͬ��Ա��,1��ʾͬ������; SmIsDelegateDOM smIsDelegateDom = new
		 * SmIsDelegateDOM(); smIsDelegateDom.workStaffSyn(staffId, officeId,
		 * name, passWord, regionId, actType, createDate, expDate, effDate,
		 * operType); // ͬ�����Ʒ� //
		 */
		// ͬ������Դ//
		// StaffMVO mvo = staffMDao.findStaffMemberByStaffId(vo.getStaffId());
		// String[] backStr = staffMDao.updateStaffMVOByRs(mvo,
		// Constant.STAFF_ACT_TYPE_D);
		// if (backStr[0].equals("-1")) {
		// throw new AppException("3333", "ͬ����Դ����,ԭ��Ϊ:" + backStr[1]);
		// } //
		// ͬ������Դ//
	}

	/**
	 * �޸Ķ��staffmvo
	 * 
	 * @param vo
	 * @throws SysException
	 * @throws AppException
	 */
	public void updateStaffMVO(StaffMVO vo) throws Exception {
		StaffSVO svo = vo.getStaffSVO();
		PartySVO psvo = vo.getPartySVO();

		PartyDOM pdom = new PartyDOM();
		Timestamp curTime = SysDateUtil.getCurrentTimestamp();
		Date curDate = SysDateUtil.getCurrentDate();

		// �޸�Ա����Ӧ��party����Ϣ
		psvo.setStsDate(curTime);
		pdom.update(psvo);
		// �޸�party��Ӧ��֤����Ϣ������ϵ��Ϣ
		PartyIdentityDOM pidom = new PartyIdentityDOM();
		ContactMediumDOM cmdom = new ContactMediumDOM();
		PartyIdentitySVO pisvo = new PartyIdentitySVO();
		ContactMediumSVO cmsvo = new ContactMediumSVO();
		pisvo.setPartyId(vo.getPartySVO().getPartyId());
		pisvo.setSts(Constant.STS_IN_USE);
		cmsvo.setPartyId(vo.getPartySVO().getPartyId());
		cmsvo.setSts(Constant.STS_IN_USE);

		List piList = pidom.findByVo(pisvo);
		if (piList == null) {
			if (vo.getCertCode() != null || vo.getCertTypeId() != null
					|| vo.getCertExpDate() != null) {
				pisvo.setLocalNetId(vo.getPartySVO().getLocalNetId());
				pisvo.setCertCode(vo.getCertCode());
				pisvo.setCertTypeId(vo.getCertTypeId());
				pisvo.setCertExpDate(vo.getCertExpDate());
				pisvo.setSts(Constant.STS_IN_USE);
				pisvo.setCreateDate(curDate);
				pisvo.setStsDate(curDate);
				pidom.add(pisvo);

			}
		} else {
			pisvo = (PartyIdentitySVO) piList.get(0);
			pisvo.setCertCode(vo.getCertCode());
			pisvo.setCertTypeId(vo.getCertTypeId());
			pisvo.setCertExpDate(vo.getCertExpDate());
			pisvo.setStsDate(curDate);
			pidom.update(pisvo);
		}

		// �޸�contactMedium����Ϣ
		// List cmList = cmdom.findByVo(cmsvo);
		// if (cmList == null) {
		// if (vo.getPostalCode() != null || vo.getContactAddr() != null) {
		// cmsvo.setSts(Constant.STS_IN_USE);
		// cmsvo.setCreateDate(curDate);
		// cmsvo.setStsDate(curDate);
		// cmdom.add(cmsvo);
		// }
		//
		// } else {
		// cmsvo = (ContactMediumSVO) cmList.get(0);
		// cmsvo.setPostalCode(vo.getPostalCode());
		// cmsvo.setContactAddr(vo.getContactAddr());
		// cmsvo.setStsDate(curDate);
		// cmdom.update(cmsvo);
		// }

		// �޸�Ա����Ϣ
		svo.setStsDate(SysDateUtil.getCurrentTimestamp());
		staffDao.update(svo);
		// ͬ�����Ʒ�//

		// String staffId = svo.getStaffId();
		// String officeId = svo.getDeptId();
		// String name = psvo.getName();
		// String passWord = "666666"; // ��ʼ����,Ĭ��
		// String regionId = "311"; // TODO �ݶ���;
		// String actType = "M"; // M��ʾ�޸�
		// Date createDate = curDate;
		// Date effDate = curDate;
		// java.util.Date expDate = DateUtil.to_date("2020-10-17",
		// "yyyy-MM-dd");
		// String operType = "0"; // 0��ʾͬ��Ա��,1��ʾͬ������;
		// SmIsDelegateDOM smIsDelegateDom = new SmIsDelegateDOM();
		// smIsDelegateDom.workStaffSyn(staffId, officeId, name, passWord,
		// regionId, actType,
		// createDate, expDate, effDate, operType);

		// ͬ�����Ʒ�//

		// ͬ������Դ//
		// vo =
		// staffMDao.findStaffMemberByStaffId(vo.getStaffSVO().getStaffId());
		// String[] backStr = staffMDao.updateStaffMVOByRs(vo,
		// Constant.STAFF_ACT_TYPE_R);
		// if (backStr[0].equals("-1")) {
		// throw new AppException("3333", "ͬ����Դ����,ԭ��Ϊ:" + backStr[1]);
		// }
		// ͬ������Դ//

	}

	/**
	 * ��ѯ���staffmvo
	 * 
	 * @param vo
	 * @return List<StaffMVO>
	 * @throws SysException
	 * @throws AppException
	 */
	public List findStaffMember(StaffMVO vo) throws SysException, AppException {
		return staffMDao.findStaffMember(vo);
	}

	public void delStaffMVO(String[] staffIds) throws SysException,
			AppException {
		String staffId = null;
		StaffSVO vo = new StaffSVO();
		for (int i = 0; i < staffIds.length; i++) {
			staffId = staffIds[i];
			vo.setStaffId(staffId);
			vo = (StaffSVO) staffDao.findByPK(vo);
			this.delStaffMVOByOnly(vo);

		}
	}

	/**
	 * ��ѯ�����޸ĵ�Ա����¼
	 * 
	 * @param set
	 *            HashSet
	 * @return List
	 * @throws Exception
	 */
	public PagView findStaffBySet(HashSet set, PagInfo pagInfo)
			throws Exception {
		return staffMDao.findStaffMemberSet(set, pagInfo);
	}

	public List findStaffMVOByStaffIds(String staffIds) throws Exception {
		List list = staffMDao.findStaffMemberByStaffIds(staffIds);
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				StaffMVO fnv1 = (StaffMVO) o1;
				StaffMVO fnv2 = (StaffMVO) o2;
				return Integer.parseInt(fnv1.getStaffSVO().getStaffId())
						- Integer.parseInt(fnv2.getStaffSVO().getStaffId());
			}
		});

		// Ϊ�˷�ֹ�����ظ���staff
		StaffMVO mvo1 = null;
		StaffMVO mvo2 = null;
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				mvo1 = (StaffMVO) list.get(i);
				mvo2 = (StaffMVO) list.get(i - 1);
				if (mvo1.getStaffSVO().getStaffId().equals(
						mvo2.getStaffSVO().getStaffId())) {
					list.remove(i - 1);
				}
			}

		}
		return staffMDao.findStaffMemberByStaffIds(staffIds);
	}

	/**
	 * ��ѯ���staffmvo(����Ϊ��ȷ��ѯ)
	 * 
	 * @param vo
	 * @return List<StaffMVO>
	 * @throws SysException
	 * @throws AppException
	 */
	public List findStaffMVO(StaffMVO vo) throws SysException, AppException {
		return staffMDao.findStaffMVO(vo);
	}

	/**
	 * ��ҳ��ѯԱ��(�ӿ�)
	 * 
	 * @param ovo
	 * 
	 * @param pagInfo
	 * @throws SysException
	 * @throws AppException
	 * @return pagview
	 */
	public PagView findStaffNotByDept(StaffMVO ovo, PagInfo pagInfo)
			throws SysException, AppException {
		return staffMDao.findStaffMemberFast(ovo, pagInfo, null, null);

	}

	/**
	 * ����������ѯstaffmvo
	 * 
	 * @param staffId
	 * @return Staffmvo
	 * @throws SysException
	 * @throws AppException
	 */
	public String findNameByPK(String staffId) throws SysException,
			AppException {
		return staffMDao.findNameByStaffId(staffId);
	}

}
