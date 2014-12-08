package com.cattsoft.sm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.CollectionFactory;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.component.dao.IStaffMemberMDAO;
import com.cattsoft.sm.vo.StaffInfoMVO;
import com.cattsoft.sm.vo.StaffWorkAreaSVO;

public class StaffMemberMDAOImpl implements IStaffMemberMDAO {

	public List findStaff(GenericVO vo) throws AppException, SysException {

		if (vo == null) {
			
			throw new AppException("100001", "ȱ��DAO��������");
		}
		StaffWorkAreaSVO staffVo = (StaffWorkAreaSVO) vo;
		List res = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);

		Sql sql = new Sql(" SELECT party.NAME,staff.STAFF_ID ");
		sql.append(" FROM STAFF staff,PARTY party,STAFF_WORK_AREA work ");
		sql.append(" WHERE 1=1  and staff.PARTY_ID=party.PARTY_ID ");
		sql.append(" and work.STAFF_ID=staff.STAFF_ID ");
		// Ա��ID
		if (!StringUtil.isBlank(staffVo.getWorkAreaId())
				|| SysConstants.YES.equals(staffVo.getWorkAreaId())) {
			sql.append(" and work.WORK_AREA_ID=:workAreaId ");
			sql.setString("workAreaId", staffVo.getWorkAreaId());
		}
		
		// �����߱�־ ADMIN_FLAG
		if (!StringUtil.isBlank(staffVo.getAdminFlag())
				|| SysConstants.YES.equals(staffVo.getAdminFlag())) {
			sql.append(" and work.ADMIN_FLAG=:adminFlag ");
			sql.setString("adminFlag", staffVo.getAdminFlag().trim());
		}
		
		// lijixu 20100206 ���Ա��������Ա����ĳ������Ȩ�ޱ�ע������ת�ɵ���ҳ�棬Ա�������б��й��˸�Ա��
		sql.append(" AND WORK.STS='A' ");
		sql.append(" AND PARTY.STS='A' ");
		sql.append(" AND STAFF.STS='A' ");

		sql.append(" ORDER BY party.NAME");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				StaffInfoMVO staffInfoVo = new StaffInfoMVO();
				staffInfoVo.setName(rs.getString("NAME"));
				staffInfoVo.setStaffId(rs.getString("STAFF_ID"));
				res.add(staffInfoVo);
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return res;
	}

}
