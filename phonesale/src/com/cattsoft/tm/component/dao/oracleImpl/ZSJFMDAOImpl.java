package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.tm.component.dao.IZSJFMDAO;
import com.cattsoft.tm.vo.FuncNodeSVO;
import com.cattsoft.tm.vo.TRpgWgrbZdywlzrbSVO;
import com.cattsoft.tm.vo.TRpt2gfzrbSVO;
import com.cattsoft.tm.vo.TRpt3grbSVO;
import com.cattsoft.tm.vo.TRptHfyb3gybSVO;
import com.cattsoft.tm.vo.TRptHfybGjywytbSVO;
import com.cattsoft.tm.vo.TRptJtbbHybrbSVO;
import com.cattsoft.tm.vo.TRptJtbbQsfzrbSVO;
import com.cattsoft.tm.vo.TRptKdywrbSVO;
import com.cattsoft.tm.vo.TRptQdrbGwdywfzrbSVO;
import com.cattsoft.tm.vo.TRptWgjlzdgzSVO;
import com.cattsoft.tm.vo.TRptWgrbKhjllzrbSVO;
import com.cattsoft.tm.vo.TRptWgybKdyfzbbSVO;
import com.cattsoft.tm.vo.TRptZdgzKhjlSVO;
import com.cattsoft.tm.vo.TRptZdywrtbSVO;

public class ZSJFMDAOImpl implements IZSJFMDAO {

	/**
	 * 重点关注之重点业务日报
	 */
	public List zdgz4zdywrb(GenericVO vo) throws AppException, SysException {

		if (vo == null) { 
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptZdywrtbSVO tRptZdywrtb = (TRptZdywrtbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,OPEN_DATE,ZDYW_2GRFZ,ZDYW_2GSYTQLJ,ZDYW_2GYLJ,ZDYW_2GZZS,ZDYW_3GRFZ,ZDYW_3GSYTQLJ,ZDYW_3GYLJ,ZDYW_3GZZS,ZDYW_KDCJDYLJ,ZDYW_KDCJJNLJS,ZDYW_KDCJQNLJS,ZDYW_KDCJRCJ,ZDYW_KDCJSYTQLJ,ZDYW_KDCJZZS,ZDYW_KDJNLJFZ,ZDYW_KDQNLJFZ,ZDYW_KDRQZ,ZDYW_KDSYTQLJ,ZDYW_KDYLJ,ZDYW_KDZZS,ZDYW_QY FROM T_RPT_ZDYWRTB WHERE 1=1 ");
		try {
			sql.append(" and  zdyw_qy in ('校园','网格','渠道','集团','其它' ,'和林','土左','托县','武川','清水河','自营厅','电子渠道','合计') ");
			

			if (tRptZdywrtb.getFlagOpenDate() == 1) {
				if (tRptZdywrtb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					sql.append(" and OPEN_DATE>=:openDate and  OPEN_DATE<:openDatetomorrow");

					sql.setTimestamp("openDate", tRptZdywrtb.getOpenDate());
					sql.setTimestamp("openDatetomorrow",
							DateUtil.getTomorrowDay(tRptZdywrtb.getOpenDate()));

				}
			}
			if (tRptZdywrtb.getFlagZdywQy() == 1) {
				if (StringUtil.isBlank(tRptZdywrtb.getZdywQy())) {
					sql.append(" and ZDYW_QY is null ");
				} else {
					sql.append(" and ZDYW_QY=:zdywQy");
					sql.setString("zdywQy", tRptZdywrtb.getZdywQy());
				}
			}
			
			sql.append(" order by instr('合计',zdyw_qy) asc ");
			
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptZdywrtb = new TRptZdywrtbSVO();
				tRptZdywrtb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptZdywrtb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptZdywrtb.setZdyw2grfz(rs.getString("ZDYW_2GRFZ"));
				tRptZdywrtb.setZdyw2gsytqlj(rs.getString("ZDYW_2GSYTQLJ"));
				tRptZdywrtb.setZdyw2gylj(rs.getString("ZDYW_2GYLJ"));
				tRptZdywrtb.setZdyw2gzzs(rs.getString("ZDYW_2GZZS"));
				tRptZdywrtb.setZdyw3grfz(rs.getString("ZDYW_3GRFZ"));
				tRptZdywrtb.setZdyw3gsytqlj(rs.getString("ZDYW_3GSYTQLJ"));
				tRptZdywrtb.setZdyw3gylj(rs.getString("ZDYW_3GYLJ"));
				tRptZdywrtb.setZdyw3gzzs(rs.getString("ZDYW_3GZZS"));
				tRptZdywrtb.setZdywKdcjdylj(rs.getString("ZDYW_KDCJDYLJ"));
				tRptZdywrtb.setZdywKdcjjnljs(rs.getString("ZDYW_KDCJJNLJS"));
				tRptZdywrtb.setZdywKdcjqnljs(rs.getString("ZDYW_KDCJQNLJS"));
				tRptZdywrtb.setZdywKdcjrcj(rs.getString("ZDYW_KDCJRCJ"));
				tRptZdywrtb.setZdywKdcjsytqlj(rs.getString("ZDYW_KDCJSYTQLJ"));
				tRptZdywrtb.setZdywKdcjzzs(rs.getString("ZDYW_KDCJZZS"));
				tRptZdywrtb.setZdywKdjnljfz(rs.getString("ZDYW_KDJNLJFZ"));
				tRptZdywrtb.setZdywKdqnljfz(rs.getString("ZDYW_KDQNLJFZ"));
				tRptZdywrtb.setZdywKdrqz(rs.getString("ZDYW_KDRQZ"));
				tRptZdywrtb.setZdywKdsytqlj(rs.getString("ZDYW_KDSYTQLJ"));
				tRptZdywrtb.setZdywKdylj(rs.getString("ZDYW_KDYLJ"));
				tRptZdywrtb.setZdywKdzzs(rs.getString("ZDYW_KDZZS"));
				tRptZdywrtb.setZdywQy(rs.getString("ZDYW_QY"));
				res.add(tRptZdywrtb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市日报之重点业务发展日报
	 */
	public List hsrb4zdywfzrb(GenericVO vo) throws AppException, SysException {

		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptZdywrtbSVO tRptZdywrtb = (TRptZdywrtbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,OPEN_DATE,ZDYW_2GRFZ,ZDYW_2GSYTQLJ,ZDYW_2GYLJ,ZDYW_2GZZS,ZDYW_3GRFZ,ZDYW_3GSYTQLJ,ZDYW_3GYLJ,ZDYW_3GZZS,ZDYW_KDCJDYLJ,ZDYW_KDCJJNLJS,ZDYW_KDCJQNLJS,ZDYW_KDCJRCJ,ZDYW_KDCJSYTQLJ,ZDYW_KDCJZZS,ZDYW_KDJNLJFZ,ZDYW_KDQNLJFZ,ZDYW_KDRQZ,ZDYW_KDSYTQLJ,ZDYW_KDYLJ,ZDYW_KDZZS,ZDYW_QY FROM T_RPT_ZDYWRTB WHERE 1=1 ");
		try {
			sql.append(" and  zdyw_qy in ('市区','和林','土左','托县','武川','清水河','合计') ");
			 
			if (tRptZdywrtb.getFlagOpenDate() == 1) {
				if (tRptZdywrtb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					sql.append(" and OPEN_DATE>=:openDate and  OPEN_DATE<:openDatetomorrow");

					sql.setTimestamp("openDate", tRptZdywrtb.getOpenDate());
					sql.setTimestamp("openDatetomorrow",
							DateUtil.getTomorrowDay(tRptZdywrtb.getOpenDate()));
				}
			}
 
			if (tRptZdywrtb.getFlagZdywQy() == 1) {
				if (StringUtil.isBlank(tRptZdywrtb.getZdywQy())) {
					sql.append(" and ZDYW_QY is null ");
				} else {
					sql.append(" and ZDYW_QY=:zdywQy");
					sql.setString("zdywQy", tRptZdywrtb.getZdywQy());
				}
			}
			
			
			sql.append(" order by instr('合计',zdyw_qy) asc ");

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptZdywrtb = new TRptZdywrtbSVO();
				tRptZdywrtb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptZdywrtb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptZdywrtb.setZdyw2grfz(rs.getString("ZDYW_2GRFZ"));
				tRptZdywrtb.setZdyw2gsytqlj(rs.getString("ZDYW_2GSYTQLJ"));
				tRptZdywrtb.setZdyw2gylj(rs.getString("ZDYW_2GYLJ"));
				tRptZdywrtb.setZdyw2gzzs(rs.getString("ZDYW_2GZZS"));
				tRptZdywrtb.setZdyw3grfz(rs.getString("ZDYW_3GRFZ"));
				tRptZdywrtb.setZdyw3gsytqlj(rs.getString("ZDYW_3GSYTQLJ"));
				tRptZdywrtb.setZdyw3gylj(rs.getString("ZDYW_3GYLJ"));
				tRptZdywrtb.setZdyw3gzzs(rs.getString("ZDYW_3GZZS"));
				tRptZdywrtb.setZdywKdcjdylj(rs.getString("ZDYW_KDCJDYLJ"));
				tRptZdywrtb.setZdywKdcjjnljs(rs.getString("ZDYW_KDCJJNLJS"));
				tRptZdywrtb.setZdywKdcjqnljs(rs.getString("ZDYW_KDCJQNLJS"));
				tRptZdywrtb.setZdywKdcjrcj(rs.getString("ZDYW_KDCJRCJ"));
				tRptZdywrtb.setZdywKdcjsytqlj(rs.getString("ZDYW_KDCJSYTQLJ"));
				tRptZdywrtb.setZdywKdcjzzs(rs.getString("ZDYW_KDCJZZS"));
				tRptZdywrtb.setZdywKdjnljfz(rs.getString("ZDYW_KDJNLJFZ"));
				tRptZdywrtb.setZdywKdqnljfz(rs.getString("ZDYW_KDQNLJFZ"));
				tRptZdywrtb.setZdywKdrqz(rs.getString("ZDYW_KDRQZ"));
				tRptZdywrtb.setZdywKdsytqlj(rs.getString("ZDYW_KDSYTQLJ"));
				tRptZdywrtb.setZdywKdylj(rs.getString("ZDYW_KDYLJ"));
				tRptZdywrtb.setZdywKdzzs(rs.getString("ZDYW_KDZZS"));
				tRptZdywrtb.setZdywQy(rs.getString("ZDYW_QY"));
				res.add(tRptZdywrtb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市日报之3G业务日报
	 */
	public List hsrb43gyw(GenericVO vo) throws AppException, SysException {

		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRpt3grbSVO tRpt3grb = (TRpt3grbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,OPEN_DATE,T3GRB_BYFZ,T3GRB_BZ,T3GRB_DQ,T3GRB_HBT,T3GRB_SYTQ,T3GRB_ZZS FROM T_RPT_3GRB WHERE 1=1 ");
		try { 
 
			
			if (tRpt3grb.getFlagOpenDate() == 1) {
				if (tRpt3grb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					String date=DateUtil.date2Str(tRpt3grb.getOpenDate());
					sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
					sql.setString("openDate", date);
					
				}
			}
			if(StringUtil.isBlank(tRpt3grb.getT3grbDq()) || "全部".equals(tRpt3grb.getT3grbDq())) {
				sql.append(" and T3GRB_DQ=:t3grbDq");
				sql.setString("t3grbDq", "全部");
			}else {
				sql.append(" and T3GRB_DQ=:t3grbDq");
				sql.setString("t3grbDq", tRpt3grb.getT3grbDq());
			}


			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRpt3grb = new TRpt3grbSVO();
				tRpt3grb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRpt3grb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRpt3grb.setT3grbByfz(rs.getString("T3GRB_BYFZ"));
				tRpt3grb.setT3grbBz(rs.getString("T3GRB_BZ"));
				tRpt3grb.setT3grbDq(rs.getString("T3GRB_DQ"));
				tRpt3grb.setT3grbHbt(rs.getString("T3GRB_HBT"));
				tRpt3grb.setT3grbSytq(rs.getString("T3GRB_SYTQ"));
				tRpt3grb.setT3grbZzs(rs.getString("T3GRB_ZZS"));
				res.add(tRpt3grb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}
	
	
	public List hsrb43gywDqList() throws AppException,SysException{

		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT distinct T3GRB_DQ FROM T_RPT_3GRB WHERE 1=1 ");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRpgWgrbZdywlzrbSVO tRpgWgrbZdywlzrb = new TRpgWgrbZdywlzrbSVO();
				/**
				 * tRpgWgrbZdywlzrb.setWgCode(rs.getString("WG_CODE"));
				 * tRpgWgrbZdywlzrb.setWgMc(rs.getString("WG_MC"));
				 */
				Map m = new HashMap();
				m.put("diqu", rs.getString("T3GRB_DQ"));
				//m.put("diquCode", rs.getString("WG_CODE"));
				res.add(m);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	
	}

	/**
	 * 呼市日报之2G业务日报
	 */
	public List hsrb42gyw(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRpt2gfzrbSVO tRpt2gfzrb = (TRpt2gfzrbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,GFZRB_DYLJ,GFZRB_OCS_DYLJ,GFZRB_OCS_RFZ,GFZRB_OCS_SYTQLJ,GFZRB_OCS_ZZS,GFZRB_QY,GFZRB_RFZ,GFZRB_SYTQLJ,GFZRB_ZZS,OPEN_DATE FROM T_RPT_2GFZRB WHERE 1=1 ");
		try {
			if (tRpt2gfzrb.getFlagOpenDate() == 1) {
				if (tRpt2gfzrb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					Date d = tRpt2gfzrb.getOpenDate();
					String strdate = DateUtil.date2Str(d);

					sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
					sql.setString("openDate", strdate);
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRpt2gfzrb = new TRpt2gfzrbSVO();
				tRpt2gfzrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRpt2gfzrb.setGfzrbDylj(rs.getString("GFZRB_DYLJ"));
				tRpt2gfzrb.setGfzrbOcsDylj(rs.getString("GFZRB_OCS_DYLJ"));
				tRpt2gfzrb.setGfzrbOcsRfz(rs.getString("GFZRB_OCS_RFZ"));
				tRpt2gfzrb.setGfzrbOcsSytqlj(rs.getString("GFZRB_OCS_SYTQLJ"));
				tRpt2gfzrb.setGfzrbOcsZzs(rs.getString("GFZRB_OCS_ZZS"));
				tRpt2gfzrb.setGfzrbQy(rs.getString("GFZRB_QY"));
				tRpt2gfzrb.setGfzrbRfz(rs.getString("GFZRB_RFZ"));
				tRpt2gfzrb.setGfzrbSytqlj(rs.getString("GFZRB_SYTQLJ"));
				tRpt2gfzrb.setGfzrbZzs(rs.getString("GFZRB_ZZS"));
				tRpt2gfzrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				res.add(tRpt2gfzrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 呼市日报之宽带业务日报
	 */
	public List hsrb4kdyw(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptKdywrbSVO tRptKdywrb = (TRptKdywrbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,KDRBC_ADSL,KDRBC_DYLJ,KDRBC_EPON,KDRBC_GPON,KDRBZ_ADSL,KDRBZ_DYLJ,KDRBZ_EPON,KDRBZ_GPON,KDRB_DQ,OPEN_DATE FROM T_RPT_KDYWRB WHERE 1=1 ");
		try {

			if (tRptKdywrb.getFlagOpenDate() == 1) {
				if (tRptKdywrb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
					String strDate = DateUtil
							.date2Str(tRptKdywrb.getOpenDate());
					sql.setString("openDate", strDate);
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptKdywrb = new TRptKdywrbSVO();
				tRptKdywrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptKdywrb.setKdrbcAdsl(rs.getString("KDRBC_ADSL"));
				tRptKdywrb.setKdrbcDylj(rs.getString("KDRBC_DYLJ"));
				tRptKdywrb.setKdrbcEpon(rs.getString("KDRBC_EPON"));
				tRptKdywrb.setKdrbcGpon(rs.getString("KDRBC_GPON"));
				tRptKdywrb.setKdrbzAdsl(rs.getString("KDRBZ_ADSL"));
				tRptKdywrb.setKdrbzDylj(rs.getString("KDRBZ_DYLJ"));
				tRptKdywrb.setKdrbzEpon(rs.getString("KDRBZ_EPON"));
				tRptKdywrb.setKdrbzGpon(rs.getString("KDRBZ_GPON"));
				tRptKdywrb.setKdrbDq(rs.getString("KDRB_DQ"));
				tRptKdywrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				res.add(tRptKdywrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市日报之重点业务揽装日报
	 */
	public List hsrb4zdywlz(Map m) throws AppException, SysException {

		if (m == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,KD_DYLJ,KD_RFZ,KD_SYTQLJ,KD_ZZS,OCS3G_DYLJ,OCS3G_RFZ,OCS3G_SYTQLJ,OCS3G_ZZS,OPEN_DATE,PT2G_DYLJ,PT2G_RFZ,PT2G_SYTQLJ,PT2G_ZZS,PT3G_DYLJ,PT3G_RFZ,PT3G_SYTQLJ,PT3G_ZZS,WG_CODE,WG_MC FROM T_RPG_WGRB_ZDYWLZRB a WHERE 1=1 ");
		
		try {

			String openDate = (String) m.get("openDate");
			String staffId = (String) m.get("staffId");
			sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
			sql.setString("openDate", openDate);

			sql.append(" and exists (select 1 from staff_td_m_area b where a.wg_code=b.area_code and b.staff_id=:staffId )   ");

			sql.setString("staffId", staffId);

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRpgWgrbZdywlzrbSVO tRpgWgrbZdywlzrb = new TRpgWgrbZdywlzrbSVO();
				tRpgWgrbZdywlzrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRpgWgrbZdywlzrb.setKdDylj(rs.getString("KD_DYLJ"));
				tRpgWgrbZdywlzrb.setKdRfz(rs.getString("KD_RFZ"));
				tRpgWgrbZdywlzrb.setKdSytqlj(rs.getString("KD_SYTQLJ"));
				tRpgWgrbZdywlzrb.setKdZzs(rs.getString("KD_ZZS"));
				tRpgWgrbZdywlzrb.setOcs3gDylj(rs.getString("OCS3G_DYLJ"));
				tRpgWgrbZdywlzrb.setOcs3gRfz(rs.getString("OCS3G_RFZ"));
				tRpgWgrbZdywlzrb.setOcs3gSytqlj(rs.getString("OCS3G_SYTQLJ"));
				tRpgWgrbZdywlzrb.setOcs3gZzs(rs.getString("OCS3G_ZZS"));
				tRpgWgrbZdywlzrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRpgWgrbZdywlzrb.setPt2gDylj(rs.getString("PT2G_DYLJ"));
				tRpgWgrbZdywlzrb.setPt2gRfz(rs.getString("PT2G_RFZ"));
				tRpgWgrbZdywlzrb.setPt2gSytqlj(rs.getString("PT2G_SYTQLJ"));
				tRpgWgrbZdywlzrb.setPt2gZzs(rs.getString("PT2G_ZZS"));
				tRpgWgrbZdywlzrb.setPt3gDylj(rs.getString("PT3G_DYLJ"));
				tRpgWgrbZdywlzrb.setPt3gRfz(rs.getString("PT3G_RFZ"));
				tRpgWgrbZdywlzrb.setPt3gSytqlj(rs.getString("PT3G_SYTQLJ"));
				tRpgWgrbZdywlzrb.setPt3gZzs(rs.getString("PT3G_ZZS"));
				tRpgWgrbZdywlzrb.setWgCode(rs.getString("WG_CODE"));
				tRpgWgrbZdywlzrb.setWgMc(rs.getString("WG_MC"));
				res.add(tRpgWgrbZdywlzrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	public List hsrb4khjllz(Map m) throws AppException, SysException {
		if (m == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String openDate=(String)m.get("openDate");
		String wgCode=(String)m.get("wgCode");
		String wgMc=(String)m.get("wgMC");
		String staffId=(String)m.get("staffId");
		Sql sql=new Sql();
		if(!StringUtil.isBlank(wgMc)) {
			sql.append("select * from ( ");
		}
		
		sql.append(
				"select WG_MC,KHJL_XM, GH_DTFZ,"+
               "GH_DYLJC,"+
               "GH_DYLJFZ,"+
               "KD_DTFZ,"+
               "KD_DYLJC,"+
               "KD_DYLJFZ,"+
               "RH_2G_DTFZ,"+
               "RH_2G_DYLJFZ,"+
               "RH_3G_DTFZ,"+
               "RH_3G_DYLJFZ,"+
               "0 as flag" +
               " FROM T_RPT_WGRB_KHJLLZRB a WHERE 1=1 ");
		sql.append(" and exists (select 1 from staff_td_m_area b where a.wg_code=b.area_code and b.staff_id=:staffId ) " +
				"and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate " );
		if(!StringUtil.isBlank(wgMc)) {
			if(!StringUtil.isBlank(wgMc)) {
				sql.append(" and WG_MC=:wgMc");
				sql.setString("wgMc", wgMc);
			}
		sql.append(" union all "+
				"SELECT '合计','-',sum(GH_DTFZ),"+
               "sum(GH_DYLJC),"+
               "sum(GH_DYLJFZ),"+
               "sum(KD_DTFZ),"+
               "sum(KD_DYLJC),"+
               "sum(KD_DYLJFZ),"+
               "sum(RH_2G_DTFZ),"+
               "sum(RH_2G_DYLJFZ),"+
               "sum(RH_3G_DTFZ),"+
               "sum(RH_3G_DYLJFZ),"+
               "1 as flag "+
          " FROM T_RPT_WGRB_KHJLLZRB a where 1=1 ");
		sql.append(" and exists (select 1 from staff_td_m_area b where a.wg_code=b.area_code and b.staff_id=:staffId ) " +
				"and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate ");
		}
		if(!StringUtil.isBlank(wgMc)) {
			if(!StringUtil.isBlank(wgMc)) {
				sql.append(" and WG_MC=:wgMc");
				sql.setString("wgMc", wgMc);
			}
			sql.append(") order by flag");
		}
	  
		
		//sql.append("");
		
		try {
			//sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
			sql.setString("openDate", openDate);
			
			//sql.append(" and WG_CODE=:wgCode");
			//sql.setString("wgCode",wgCode);
			
			/*if(!StringUtil.isBlank(wgMc)) {
				sql.append(" and WG_MC=:wgMc");
				sql.setString("wgMc", wgMc);
			}*/
			
			
			sql.setString("staffId", staffId);
			
			

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRptWgrbKhjllzrbSVO tRptWgrbKhjllzrb = new TRptWgrbKhjllzrbSVO();
				//tRptWgrbKhjllzrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptWgrbKhjllzrb.setGhDtfz(rs.getString("GH_DTFZ"));
				tRptWgrbKhjllzrb.setGhDyljc(rs.getString("GH_DYLJC"));
				tRptWgrbKhjllzrb.setGhDyljfz(rs.getString("GH_DYLJFZ"));
				tRptWgrbKhjllzrb.setKdDtfz(rs.getString("KD_DTFZ"));
				tRptWgrbKhjllzrb.setKdDyljc(rs.getString("KD_DYLJC"));
				tRptWgrbKhjllzrb.setKdDyljfz(rs.getString("KD_DYLJFZ"));
				tRptWgrbKhjllzrb.setKhjlXm(rs.getString("KHJL_XM"));
				//tRptWgrbKhjllzrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptWgrbKhjllzrb.setRh2gDtfz(rs.getString("RH_2G_DTFZ"));
				tRptWgrbKhjllzrb.setRh2gDyljfz(rs.getString("RH_2G_DYLJFZ"));
				tRptWgrbKhjllzrb.setRh3gDtfz(rs.getString("RH_3G_DTFZ"));
				tRptWgrbKhjllzrb.setRh3gDyljfz(rs.getString("RH_3G_DYLJFZ"));
				//tRptWgrbKhjllzrb.setWgCode(rs.getString("WG_CODE"));
				tRptWgrbKhjllzrb.setWgMc(rs.getString("WG_MC"));
				res.add(tRptWgrbKhjllzrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 获取该去除重复后的呼市日报之客户经理缆桩日报中的部门
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsrb4khlzjlrb() throws AppException, SysException {
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"select area_code wg_code,area_code_name wg_mc from td_m_area a where a.parent_area_code='A001' ");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRpgWgrbZdywlzrbSVO tRpgWgrbZdywlzrb = new TRpgWgrbZdywlzrbSVO();
				/**
				 * tRpgWgrbZdywlzrb.setWgCode(rs.getString("WG_CODE"));
				 * tRpgWgrbZdywlzrb.setWgMc(rs.getString("WG_MC"));
				 */
				Map m = new HashMap();
				m.put("diqu", rs.getString("wg_mc"));
				m.put("diquCode", rs.getString("wg_code"));
				res.add(m);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 获取该去除重复后的呼市月报之客户经理缆桩日报中的部门
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsyb43gyw() throws AppException, SysException {
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT distinct RB_QY FROM T_RPT_HFYB_3GYB WHERE 1=1 ");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRpgWgrbZdywlzrbSVO tRpgWgrbZdywlzrb = new TRpgWgrbZdywlzrbSVO();
				/**
				 * tRpgWgrbZdywlzrb.setWgCode(rs.getString("WG_CODE"));
				 * tRpgWgrbZdywlzrb.setWgMc(rs.getString("WG_MC"));
				 */
				Map m = new HashMap();
				m.put("diqu", rs.getString("RB_QY"));
				// m.put("diquCode", rs.getString("WG_CODE"));
				res.add(m);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 集团日报之区级、市级业务发展日报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4qsjywfzrb(TRptJtbbQsfzrbSVO vo) throws AppException,
			SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptJtbbQsfzrbSVO tRptJtbbQsfzrb = (TRptJtbbQsfzrbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CP_MC,CREATE_DATE,FGS,OPEN_DATE,QGS FROM T_RPT_JTBB_QSFZRB WHERE 1=1 ");
		try {
			if (tRptJtbbQsfzrb.getFlagOpenDate() == 1) {
				if (tRptJtbbQsfzrb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					String adtea = DateUtil.date2Str(tRptJtbbQsfzrb
							.getOpenDate());
					sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
					sql.setString("openDate", adtea);
				}
			}
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptJtbbQsfzrb = new TRptJtbbQsfzrbSVO();
				tRptJtbbQsfzrb.setCpMc(rs.getString("CP_MC"));
				tRptJtbbQsfzrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptJtbbQsfzrb.setFgs(rs.getString("FGS"));
				tRptJtbbQsfzrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptJtbbQsfzrb.setQgs(rs.getString("QGS"));
				res.add(tRptJtbbQsfzrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 集团日报之区级、市级业务发展日报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4hybywfzrb(TRptJtbbHybrbSVO vo) throws AppException,
			SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptJtbbHybrbSVO tRptJtbbHybrb = (TRptJtbbHybrbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,GX_RFZ,GX_YLJ,GX_YLJC,HYB_PQ,OPEN_DATE,RH_2G_RFZ,RH_2G_SYTQLJ,RH_2G_YLJ,RH_2G_ZZS,RH_3G_RFZ,RH_3G_SYTQLJ,RH_3G_YLJ,RH_3G_ZZS,WY_RFZ,WY_YLJ,WY_YLJC FROM T_RPT_JTBB_HYBRB WHERE 1=1 ");
		try {

			if (tRptJtbbHybrb.getFlagOpenDate() == 1) {
				if (tRptJtbbHybrb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					Date adate = tRptJtbbHybrb.getOpenDate();
					String strDate = DateUtil.date2Str(adate);
					sql.append(" and to_char( OPEN_DATE,'yyyy-mm-dd')=:openDate");
					sql.setString("openDate", strDate);
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptJtbbHybrb = new TRptJtbbHybrbSVO();
				tRptJtbbHybrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptJtbbHybrb.setGxRfz(rs.getString("GX_RFZ"));
				tRptJtbbHybrb.setGxYlj(rs.getString("GX_YLJ"));
				tRptJtbbHybrb.setGxYljc(rs.getString("GX_YLJC"));
				tRptJtbbHybrb.setHybPq(rs.getString("HYB_PQ"));
				tRptJtbbHybrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptJtbbHybrb.setRh2gRfz(rs.getString("RH_2G_RFZ"));
				tRptJtbbHybrb.setRh2gSytqlj(rs.getString("RH_2G_SYTQLJ"));
				tRptJtbbHybrb.setRh2gYlj(rs.getString("RH_2G_YLJ"));
				tRptJtbbHybrb.setRh2gZzs(rs.getString("RH_2G_ZZS"));
				tRptJtbbHybrb.setRh3gRfz(rs.getString("RH_3G_RFZ"));
				tRptJtbbHybrb.setRh3gSytqlj(rs.getString("RH_3G_SYTQLJ"));
				tRptJtbbHybrb.setRh3gYlj(rs.getString("RH_3G_YLJ"));
				tRptJtbbHybrb.setRh3gZzs(rs.getString("RH_3G_ZZS"));
				tRptJtbbHybrb.setWyRfz(rs.getString("WY_RFZ"));
				tRptJtbbHybrb.setWyYlj(rs.getString("WY_YLJ"));
				tRptJtbbHybrb.setWyYljc(rs.getString("WY_YLJC"));
				res.add(tRptJtbbHybrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	public List  qdrb4gwdywfzrbwgList() throws AppException,SysException{
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(" select distinct  wangge_type as wg_mc from qudao_wangge_new  ");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRpgWgrbZdywlzrbSVO tRpgWgrbZdywlzrb = new TRpgWgrbZdywlzrbSVO();
				/**
				 * tRpgWgrbZdywlzrb.setWgCode(rs.getString("WG_CODE"));
				 * tRpgWgrbZdywlzrb.setWgMc(rs.getString("WG_MC"));
				 */
				Map m = new HashMap();
				m.put("diqu", rs.getString("wg_mc"));
				//m.put("diquCode", rs.getString("WG_CODE"));
				res.add(m);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}
	public List qdrb4gwdywfzrb(Map m) throws AppException, SysException {
		if (m == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		
		String openDate = (String) m.get("openDate");
		String staffId = (String) m.get("staffId");
		String wg=(String)m.get("diqu");
		
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				" select * "+
 " from (SELECT OCS2G_DYLJSX,"+
          "     OCS2G_RJH,"+
           "    OCS2G_RXS,"+
          "     OCS2G_SYLJJH,"+
          "     PT2G_DYLJ,"+
          "     PT2G_RFZ,"+
          "     PT2G_SYTQ,"+
          "     PT2G_ZZS,"+
          "     PT3G_RFZ,"+
         "      PT4G_DYLJ,"+
          "     PT5G_SYTQ,"+
         "      PT6G_ZZS,"+
         "      WD_MC,"+
         "      WG_CODE,"+
         "      WG_MC,"+
         "      0 as flags"+
        "  FROM T_RPT_QDRB_GWDYWFZRB a"+
        " WHERE 1 = 1"+
           " and to_char(OPEN_DATE, 'yyyy-mm-dd') = :openDate"+
           " and exists (select 1"+
           "        from staff_td_m_area b"+
           "      where a.wg_code = b.area_code "+
           "        and b.staff_id = :staffId)");
		if((!"全部".equals(wg)) && (!StringUtil.isBlank(wg))) {
			sql.append(" and WG_MC=:wgmc");
			sql.setString("wgmc", wg);
		}

sql.append(        
"  union all "+
        
"       SELECT sum(OCS2G_DYLJSX),"+
"              sum(OCS2G_RJH),"+
"              sum(OCS2G_RXS),"+
"               sum(OCS2G_SYLJJH),"+
"              sum(PT2G_DYLJ),"+
"              sum(PT2G_RFZ),"+
"              sum(PT2G_SYTQ),"+
"              sum(PT2G_ZZS),"+
"              sum(PT3G_RFZ),"+
"              sum(PT4G_DYLJ),"+
"              sum(PT5G_SYTQ),"+
"              sum(PT6G_ZZS),"+
"              '-' WD_MC,"+
"              '-' WG_CODE,"+
"              '合计' WG_MC,"+
"              1 as flags"+
"         FROM T_RPT_QDRB_GWDYWFZRB a"+
"        WHERE 1 = 1 "+
"          and to_char(OPEN_DATE, 'yyyy-mm-dd') = :openDate"+
"          and exists (select 1 "+
"                 from staff_td_m_area b "+
"                where a.wg_code = b.area_code "+
"                  and b.staff_id = :staffId )" );
if((!"全部".equals(wg)) && (!StringUtil.isBlank(wg))) {
	sql.append(" and WG_MC=:wgmc");
	sql.setString("wgmc", wg);
}

sql.append(" ) order by flags") ;
		try {
			
			//sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
			sql.setString("openDate", openDate);

			//sql.append(" and exists (select 1 from staff_td_m_area b where a.wg_code=b.area_code and b.staff_id=:staffId )   ");

			sql.setString("staffId", staffId);
			

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				TRptQdrbGwdywfzrbSVO tRptQdrbGwdywfzrb = new TRptQdrbGwdywfzrbSVO();
				//tRptQdrbGwdywfzrb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptQdrbGwdywfzrb.setOcs2gDyljsx(rs.getString("OCS2G_DYLJSX"));
				tRptQdrbGwdywfzrb.setOcs2gRjh(rs.getString("OCS2G_RJH"));
				tRptQdrbGwdywfzrb.setOcs2gRxs(rs.getString("OCS2G_RXS"));
				tRptQdrbGwdywfzrb.setOcs2gSyljjh(rs.getString("OCS2G_SYLJJH"));
				//tRptQdrbGwdywfzrb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptQdrbGwdywfzrb.setPt2gDylj(rs.getString("PT2G_DYLJ"));
				tRptQdrbGwdywfzrb.setPt2gRfz(rs.getString("PT2G_RFZ"));
				tRptQdrbGwdywfzrb.setPt2gSytq(rs.getString("PT2G_SYTQ"));
				tRptQdrbGwdywfzrb.setPt2gZzs(rs.getString("PT2G_ZZS"));
				tRptQdrbGwdywfzrb.setPt3gRfz(rs.getString("PT3G_RFZ"));
				tRptQdrbGwdywfzrb.setPt4gDylj(rs.getString("PT4G_DYLJ"));
				tRptQdrbGwdywfzrb.setPt5gSytq(rs.getString("PT5G_SYTQ"));
				tRptQdrbGwdywfzrb.setPt6gZzs(rs.getString("PT6G_ZZS"));
				tRptQdrbGwdywfzrb.setWdMc(rs.getString("WD_MC"));
				tRptQdrbGwdywfzrb.setWgCode(rs.getString("WG_CODE"));
				tRptQdrbGwdywfzrb.setWgMc(rs.getString("WG_MC"));
				res.add(tRptQdrbGwdywfzrb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市月报4关键指标月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4gjzbyb(TRptHfybGjywytbSVO vo) throws AppException,
			SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptHfybGjywytbSVO tRptHfybGjywytb = (TRptHfybGjywytbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,GH_CZSR_DBZZL,GH_CZSR_DY,GH_CZSR_HBZZL,GH_CZSR_SY,GH_CZSR_TBZZL,GH_CZYHS_DBZZL,GH_CZYHS_DY,GH_CZYHS_HBZZL,GH_CZYHS_SY,GH_CZYHS_TBZZL,GH_DYFZ_DY,GH_DYFZ_SY,GH_DYFZ_ZZL,GH_DYFZ_ZZS,GJYWYTB_QY,KD_CZSR_DBZZL,KD_CZSR_DY,KD_CZSR_HBZZL,KD_CZSR_SY,KD_CZSR_TBZZL,KD_CZYHS_DBZZL,KD_CZYHS_DY,KD_CZYHS_HBZZL,KD_CZYHS_SY,KD_CZYHS_TBZZL,KD_DYFZ_DY,KD_DYFZ_SY,KD_DYFZ_ZZL,KD_DYFZ_ZZS,OCS10G_CZSR_TBZZL,OCS11G_CZSR_DBZZL,OCS12G_CZYHS_DY,OCS13G_CZYHS_SY,OCS14G_CZYHS_HBZZL,OCS15G_CZYHS_TBZZL,OCS16G_CZYHS_DBZZL,OCS3G_DYFZ_DY,OCS4G_DYFZ_SY,OCS5G_DYFZ_ZZS,OCS6G_DYFZ_ZZL,OCS7G_CZSR_DY,OCS8G_CZSR_SY,OCS9G_CZSR_HBZZL,OPEN_DATE,PT2G_CZSR_DBZZL,PT2G_CZSR_DY,PT2G_CZSR_HBZZL,PT2G_CZSR_SY,PT2G_CZSR_TBZZL,PT2G_CZYHS_DBZZL,PT2G_CZYHS_DY,PT2G_CZYHS_HBZZL,PT2G_CZYHS_SY,PT2G_CZYHS_TBZZL,PT2G_DYFZ_DY,PT2G_DYFZ_SY,PT2G_DYFZ_ZZL,PT2G_DYFZ_ZZS,PT3G_CZSR_DBZZL,PT3G_CZSR_DY,PT3G_CZSR_HBZZL,PT3G_CZSR_SY,PT3G_CZSR_TBZZL,PT3G_CZYHS_DBZZL,PT3G_CZYHS_DY,PT3G_CZYHS_HBZZL,PT3G_CZYHS_SY,PT3G_CZYHS_TBZZL,PT3G_DYFZ_DY,PT3G_DYFZ_SY,PT3G_DYFZ_ZZL,PT3G_DYFZ_ZZS,QW_CZSR_DBZZL,QW_CZSR_DY,QW_CZSR_HBZZL,QW_CZSR_SY,QW_CZSR_TBZZL,QW_CZYHS_DBZZL,QW_CZYHS_DY,QW_CZYHS_HBZZL,QW_CZYHS_SY,QW_CZYHS_TBZZL FROM T_RPT_HFYB_GJYWYTB WHERE 1=1 ");
		try {

			if (tRptHfybGjywytb.getFlagOpenDate() == 1) {
				if (tRptHfybGjywytb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					Date date = tRptHfybGjywytb.getOpenDate();
					String strDate = DateUtil.date2Str(date);
					sql.append(" and to_char(OPEN_DATE,'yyyy-mm')=:openDate");
					sql.setString("openDate", strDate.substring(0,7));
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptHfybGjywytb = new TRptHfybGjywytbSVO();
				tRptHfybGjywytb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptHfybGjywytb.setGhCzsrDbzzl(rs.getString("GH_CZSR_DBZZL"));
				tRptHfybGjywytb.setGhCzsrDy(rs.getString("GH_CZSR_DY"));
				tRptHfybGjywytb.setGhCzsrHbzzl(rs.getString("GH_CZSR_HBZZL"));
				tRptHfybGjywytb.setGhCzsrSy(rs.getString("GH_CZSR_SY"));
				tRptHfybGjywytb.setGhCzsrTbzzl(rs.getString("GH_CZSR_TBZZL"));
				tRptHfybGjywytb.setGhCzyhsDbzzl(rs.getString("GH_CZYHS_DBZZL"));
				tRptHfybGjywytb.setGhCzyhsDy(rs.getString("GH_CZYHS_DY"));
				tRptHfybGjywytb.setGhCzyhsHbzzl(rs.getString("GH_CZYHS_HBZZL"));
				tRptHfybGjywytb.setGhCzyhsSy(rs.getString("GH_CZYHS_SY"));
				tRptHfybGjywytb.setGhCzyhsTbzzl(rs.getString("GH_CZYHS_TBZZL"));
				tRptHfybGjywytb.setGhDyfzDy(rs.getString("GH_DYFZ_DY"));
				tRptHfybGjywytb.setGhDyfzSy(rs.getString("GH_DYFZ_SY"));
				tRptHfybGjywytb.setGhDyfzZzl(rs.getString("GH_DYFZ_ZZL"));
				tRptHfybGjywytb.setGhDyfzZzs(rs.getString("GH_DYFZ_ZZS"));
				tRptHfybGjywytb.setGjywytbQy(rs.getString("GJYWYTB_QY"));
				tRptHfybGjywytb.setKdCzsrDbzzl(rs.getString("KD_CZSR_DBZZL"));
				tRptHfybGjywytb.setKdCzsrDy(rs.getString("KD_CZSR_DY"));
				tRptHfybGjywytb.setKdCzsrHbzzl(rs.getString("KD_CZSR_HBZZL"));
				tRptHfybGjywytb.setKdCzsrSy(rs.getString("KD_CZSR_SY"));
				tRptHfybGjywytb.setKdCzsrTbzzl(rs.getString("KD_CZSR_TBZZL"));
				tRptHfybGjywytb.setKdCzyhsDbzzl(rs.getString("KD_CZYHS_DBZZL"));
				tRptHfybGjywytb.setKdCzyhsDy(rs.getString("KD_CZYHS_DY"));
				tRptHfybGjywytb.setKdCzyhsHbzzl(rs.getString("KD_CZYHS_HBZZL"));
				tRptHfybGjywytb.setKdCzyhsSy(rs.getString("KD_CZYHS_SY"));
				tRptHfybGjywytb.setKdCzyhsTbzzl(rs.getString("KD_CZYHS_TBZZL"));
				tRptHfybGjywytb.setKdDyfzDy(rs.getString("KD_DYFZ_DY"));
				tRptHfybGjywytb.setKdDyfzSy(rs.getString("KD_DYFZ_SY"));
				tRptHfybGjywytb.setKdDyfzZzl(rs.getString("KD_DYFZ_ZZL"));
				tRptHfybGjywytb.setKdDyfzZzs(rs.getString("KD_DYFZ_ZZS"));
				tRptHfybGjywytb.setOcs10gCzsrTbzzl(rs
						.getString("OCS10G_CZSR_TBZZL"));
				tRptHfybGjywytb.setOcs11gCzsrDbzzl(rs
						.getString("OCS11G_CZSR_DBZZL"));
				tRptHfybGjywytb.setOcs12gCzyhsDy(rs
						.getString("OCS12G_CZYHS_DY"));
				tRptHfybGjywytb.setOcs13gCzyhsSy(rs
						.getString("OCS13G_CZYHS_SY"));
				tRptHfybGjywytb.setOcs14gCzyhsHbzzl(rs
						.getString("OCS14G_CZYHS_HBZZL"));
				tRptHfybGjywytb.setOcs15gCzyhsTbzzl(rs
						.getString("OCS15G_CZYHS_TBZZL"));
				tRptHfybGjywytb.setOcs16gCzyhsDbzzl(rs
						.getString("OCS16G_CZYHS_DBZZL"));
				tRptHfybGjywytb.setOcs3gDyfzDy(rs.getString("OCS3G_DYFZ_DY"));
				tRptHfybGjywytb.setOcs4gDyfzSy(rs.getString("OCS4G_DYFZ_SY"));
				tRptHfybGjywytb.setOcs5gDyfzZzs(rs.getString("OCS5G_DYFZ_ZZS"));
				tRptHfybGjywytb.setOcs6gDyfzZzl(rs.getString("OCS6G_DYFZ_ZZL"));
				tRptHfybGjywytb.setOcs7gCzsrDy(rs.getString("OCS7G_CZSR_DY"));
				tRptHfybGjywytb.setOcs8gCzsrSy(rs.getString("OCS8G_CZSR_SY"));
				tRptHfybGjywytb.setOcs9gCzsrHbzzl(rs
						.getString("OCS9G_CZSR_HBZZL"));
				tRptHfybGjywytb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptHfybGjywytb.setPt2gCzsrDbzzl(rs
						.getString("PT2G_CZSR_DBZZL"));
				tRptHfybGjywytb.setPt2gCzsrDy(rs.getString("PT2G_CZSR_DY"));
				tRptHfybGjywytb.setPt2gCzsrHbzzl(rs
						.getString("PT2G_CZSR_HBZZL"));
				tRptHfybGjywytb.setPt2gCzsrSy(rs.getString("PT2G_CZSR_SY"));
				tRptHfybGjywytb.setPt2gCzsrTbzzl(rs
						.getString("PT2G_CZSR_TBZZL"));
				tRptHfybGjywytb.setPt2gCzyhsDbzzl(rs
						.getString("PT2G_CZYHS_DBZZL"));
				tRptHfybGjywytb.setPt2gCzyhsDy(rs.getString("PT2G_CZYHS_DY"));
				tRptHfybGjywytb.setPt2gCzyhsHbzzl(rs
						.getString("PT2G_CZYHS_HBZZL"));
				tRptHfybGjywytb.setPt2gCzyhsSy(rs.getString("PT2G_CZYHS_SY"));
				tRptHfybGjywytb.setPt2gCzyhsTbzzl(rs
						.getString("PT2G_CZYHS_TBZZL"));
				tRptHfybGjywytb.setPt2gDyfzDy(rs.getString("PT2G_DYFZ_DY"));
				tRptHfybGjywytb.setPt2gDyfzSy(rs.getString("PT2G_DYFZ_SY"));
				tRptHfybGjywytb.setPt2gDyfzZzl(rs.getString("PT2G_DYFZ_ZZL"));
				tRptHfybGjywytb.setPt2gDyfzZzs(rs.getString("PT2G_DYFZ_ZZS"));
				tRptHfybGjywytb.setPt3gCzsrDbzzl(rs
						.getString("PT3G_CZSR_DBZZL"));
				tRptHfybGjywytb.setPt3gCzsrDy(rs.getString("PT3G_CZSR_DY"));
				tRptHfybGjywytb.setPt3gCzsrHbzzl(rs
						.getString("PT3G_CZSR_HBZZL"));
				tRptHfybGjywytb.setPt3gCzsrSy(rs.getString("PT3G_CZSR_SY"));
				tRptHfybGjywytb.setPt3gCzsrTbzzl(rs
						.getString("PT3G_CZSR_TBZZL"));
				tRptHfybGjywytb.setPt3gCzyhsDbzzl(rs
						.getString("PT3G_CZYHS_DBZZL"));
				tRptHfybGjywytb.setPt3gCzyhsDy(rs.getString("PT3G_CZYHS_DY"));
				tRptHfybGjywytb.setPt3gCzyhsHbzzl(rs
						.getString("PT3G_CZYHS_HBZZL"));
				tRptHfybGjywytb.setPt3gCzyhsSy(rs.getString("PT3G_CZYHS_SY"));
				tRptHfybGjywytb.setPt3gCzyhsTbzzl(rs
						.getString("PT3G_CZYHS_TBZZL"));
				tRptHfybGjywytb.setPt3gDyfzDy(rs.getString("PT3G_DYFZ_DY"));
				tRptHfybGjywytb.setPt3gDyfzSy(rs.getString("PT3G_DYFZ_SY"));
				tRptHfybGjywytb.setPt3gDyfzZzl(rs.getString("PT3G_DYFZ_ZZL"));
				tRptHfybGjywytb.setPt3gDyfzZzs(rs.getString("PT3G_DYFZ_ZZS"));
				tRptHfybGjywytb.setQwCzsrDbzzl(rs.getString("QW_CZSR_DBZZL"));
				tRptHfybGjywytb.setQwCzsrDy(rs.getString("QW_CZSR_DY"));
				tRptHfybGjywytb.setQwCzsrHbzzl(rs.getString("QW_CZSR_HBZZL"));
				tRptHfybGjywytb.setQwCzsrSy(rs.getString("QW_CZSR_SY"));
				tRptHfybGjywytb.setQwCzsrTbzzl(rs.getString("QW_CZSR_TBZZL"));
				tRptHfybGjywytb.setQwCzyhsDbzzl(rs.getString("QW_CZYHS_DBZZL"));
				tRptHfybGjywytb.setQwCzyhsDy(rs.getString("QW_CZYHS_DY"));
				tRptHfybGjywytb.setQwCzyhsHbzzl(rs.getString("QW_CZYHS_HBZZL"));
				tRptHfybGjywytb.setQwCzyhsSy(rs.getString("QW_CZYHS_SY"));
				tRptHfybGjywytb.setQwCzyhsTbzzl(rs.getString("QW_CZYHS_TBZZL"));
				res.add(tRptHfybGjywytb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 呼市月报43G业务月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb43gyb(TRptHfyb3gybSVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptHfyb3gybSVO tRptHfyb3gyb = (TRptHfyb3gybSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,CZYHS_BY,CZYHS_HBZZL,CZYHS_SY,DYCZSR_BY,DYCZSR_HBZZL,DYCZSR_SY,DYFZ_BY,DYFZ_HBZZL,DYFZ_SY,OPEN_DATE,YW FROM T_RPT_HFYB_3GYB WHERE 1=1 ");
		try {

			if (tRptHfyb3gyb.getFlagOpenDate() == 1) {
				if (tRptHfyb3gyb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					Date date = tRptHfyb3gyb.getOpenDate();
					String strDate = DateUtil.date2Str(date);

					sql.append(" and to_char(OPEN_DATE,'yyyy-mm')=:openDate");
					sql.setString("openDate", strDate.substring(0,7));
				}
			}

			if (tRptHfyb3gyb.getFlagRbQy() == 1) {
				if (StringUtil.isBlank(tRptHfyb3gyb.getRbQy())) {
					sql.append(" and RB_QY is null ");
				} else {
					sql.append(" and RB_QY=:rbQy");
					sql.setString("rbQy", tRptHfyb3gyb.getRbQy());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptHfyb3gyb = new TRptHfyb3gybSVO();
				tRptHfyb3gyb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptHfyb3gyb.setCzyhsBy(rs.getString("CZYHS_BY"));
				tRptHfyb3gyb.setCzyhsHbzzl(rs.getString("CZYHS_HBZZL"));
				tRptHfyb3gyb.setCzyhsSy(rs.getString("CZYHS_SY"));
				tRptHfyb3gyb.setDyczsrBy(rs.getString("DYCZSR_BY"));
				tRptHfyb3gyb.setDyczsrHbzzl(rs.getString("DYCZSR_HBZZL"));
				tRptHfyb3gyb.setDyczsrSy(rs.getString("DYCZSR_SY"));
				tRptHfyb3gyb.setDyfzBy(rs.getString("DYFZ_BY"));
				tRptHfyb3gyb.setDyfzHbzzl(rs.getString("DYFZ_HBZZL"));
				tRptHfyb3gyb.setDyfzSy(rs.getString("DYFZ_SY"));
				tRptHfyb3gyb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptHfyb3gyb.setYw(rs.getString("YW"));
				res.add(tRptHfyb3gyb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市月报4宽带月发展情况
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4kdyfzqk(TRptWgybKdyfzbbSVO vo) throws AppException,
			SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptWgybKdyfzbbSVO tRptWgybKdyfzbb = (TRptWgybKdyfzbbSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_DATE,LDL,OPEN_DATE,QZHTLZ,QZWGLZ,QZWLZ,QZZYTLZ,WG_CODE,WG_MC FROM T_RPT_WGYB_KDYFZBB WHERE 1=1 ");
		// ///////////////////////

		try {

			if (tRptWgybKdyfzbb.getFlagOpenDate() == 1) {
				if (tRptWgybKdyfzbb.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {

					Date date = tRptWgybKdyfzbb.getOpenDate();
					String strDate = DateUtil.date2Str(date);

					sql.append(" and to_char(OPEN_DATE,'yyyy-mm')=:openDate");
					sql.setString("openDate", strDate.substring(0, 7));
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptWgybKdyfzbb = new TRptWgybKdyfzbbSVO();
				tRptWgybKdyfzbb.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptWgybKdyfzbb.setLdl(rs.getString("LDL"));
				tRptWgybKdyfzbb.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptWgybKdyfzbb.setQzhtlz(rs.getString("QZHTLZ"));
				tRptWgybKdyfzbb.setQzwglz(rs.getString("QZWGLZ"));
				tRptWgybKdyfzbb.setQzwlz(rs.getString("QZWLZ"));
				tRptWgybKdyfzbb.setQzzytlz(rs.getString("QZZYTLZ"));
				tRptWgybKdyfzbb.setWgCode(rs.getString("WG_CODE"));
				tRptWgybKdyfzbb.setWgMc(rs.getString("WG_MC"));
				res.add(tRptWgybKdyfzbb);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}

	/**
	 * 呼市日报4网格经理重点关注
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsrb4wgjlzdgz(TRptZdgzKhjlSVO vo) throws AppException,
			SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		TRptZdgzKhjlSVO tRptZdgzKhjl = (TRptZdgzKhjlSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CP_MC,CREATE_DATE,ERP_ID,LOGIN_ID,OPEN_DATE,ZDGZ_DTZ,ZDGZ_DYLJ,ZDGZ_DYLJC FROM T_RPT_ZDGZ_KHJL a WHERE 1=1 ");
		try {
			if (tRptZdgzKhjl.getFlagOpenDate() == 1) {
				if (tRptZdgzKhjl.getOpenDate() == null) {
					sql.append(" and OPEN_DATE is null ");
				} else {
					String date=DateUtil.date2Str(tRptZdgzKhjl.getOpenDate());
					sql.append(" and to_char(OPEN_DATE,'yyyy-mm-dd')=:openDate");
					sql.setString("openDate", date);
				}
			}
			
			if (tRptZdgzKhjl.getFlagLoginId() == 1) {
				if (tRptZdgzKhjl.getLoginId() == null) {
					sql.append(" and LOGIN_ID is null ");
				} else {
					sql.append(" and LOGIN_ID=:loginId");
					sql.setString("loginId", vo.getLoginId());
				}
			} 
			
			
			
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				tRptZdgzKhjl = new TRptZdgzKhjlSVO();
				tRptZdgzKhjl.setCpMc(rs.getString("CP_MC"));
				tRptZdgzKhjl.setCreateDate(rs.getTimestamp("CREATE_DATE"));
				tRptZdgzKhjl.setErpId(rs.getString("ERP_ID"));
				tRptZdgzKhjl.setLoginId(rs.getString("LOGIN_ID"));
				tRptZdgzKhjl.setOpenDate(rs.getTimestamp("OPEN_DATE"));
				tRptZdgzKhjl.setZdgzDtz(rs.getString("ZDGZ_DTZ"));
				tRptZdgzKhjl.setZdgzDylj(rs.getString("ZDGZ_DYLJ"));
				tRptZdgzKhjl.setZdgzDyljc(rs.getString("ZDGZ_DYLJC"));
				res.add(tRptZdgzKhjl);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	}
	
	public List getFuncNodeListByUser(SysUserSVO vo) throws AppException,SysException{
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT a.DESCRIPTION,a.FILE_NAME,a.FUNC_NODE_CODE,a.FUNC_NODE_ID,a.FUNC_NODE_NAME,a.FUNC_NODE_TYPE,a.HTML,NODE_TREE_ID,a.SECURITY_LEVEL,a.SHORT_CUT_IMAGE,a.STS,a.STS_DATE,a.SUB_SYSTEM_NAME,a.VERSION "+
				"FROM func_node a ,   sys_user_alloc b WHERE a.func_node_id=b.func_node_id AND b.sys_user_id   =:sysUserId  and  a.sts='A' AND B.STS='A'   order by a.security_level ,a.func_node_id ");
		try {
			sql.setString("sysUserId", vo.getSysUserId());
			
			
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				FuncNodeSVO  funcNode = new FuncNodeSVO();
		           funcNode.setDescription(rs.getString("DESCRIPTION"));
		           funcNode.setFileName(rs.getString("FILE_NAME"));
		           funcNode.setFuncNodeCode(rs.getString("FUNC_NODE_CODE"));
		           funcNode.setFuncNodeId(rs.getString("FUNC_NODE_ID"));
		           funcNode.setFuncNodeName(rs.getString("FUNC_NODE_NAME"));
		           funcNode.setFuncNodeType(rs.getString("FUNC_NODE_TYPE"));
		           funcNode.setHtml(rs.getString("HTML"));
		           funcNode.setNodeTreeId(rs.getString("NODE_TREE_ID"));
		           funcNode.setSecurityLevel(rs.getString("SECURITY_LEVEL"));
		           funcNode.setShortCutImage(rs.getString("SHORT_CUT_IMAGE"));
		           funcNode.setSts(rs.getString("STS"));
		           funcNode.setStsDate(rs.getTimestamp("STS_DATE"));
		           funcNode.setSubSystemName(rs.getString("SUB_SYSTEM_NAME"));
		           funcNode.setVersion(rs.getString("VERSION"));
		           res.add(funcNode);
		              
		              }

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;

	
	}

}
