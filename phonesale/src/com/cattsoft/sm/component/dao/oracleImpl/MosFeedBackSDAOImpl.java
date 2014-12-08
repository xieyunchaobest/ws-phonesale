package com.cattsoft.sm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.sm.component.dao.IMosFeedBackSDAO;
import com.cattsoft.sm.vo.MosFeedBackSVO;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.pub.util.StringUtil;

/**
 * ����MosFeedBackSDAOImpl
 * <p>Company: �������</p>
 * @author ����С����
 * @version 1.1  2007-9-23
 */
public class MosFeedBackSDAOImpl implements IMosFeedBackSDAO {
	private static Logger log = Logger.getLogger(MosFeedBackSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * ���ӡ�
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
		if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_FEED_BACK(CREATE_TIME,EMAIL,FEED_DESC,MOS_FEED_BACK_ID,REMARKS,USER_ID)");
		sql
				.append(" VALUES (:createTime,:email,:feedDesc,:mosFeedBackId,:remarks,:userId)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (mosFeedBack.getCreateTime() == null) {
				sql.setNullDate("createTime");
			} else {
				sql.setTimestamp("createTime", mosFeedBack.getCreateTime());
			}

			if (StringUtil.isBlank(mosFeedBack.getEmail())) {
				sql.setNullString("email");
			} else {
				sql.setString("email", mosFeedBack.getEmail());
			}

			if (StringUtil.isBlank(mosFeedBack.getFeedDesc())) {
				sql.setNullString("feedDesc");
			} else {
				sql.setString("feedDesc", mosFeedBack.getFeedDesc());
			}

			if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
				sql.setNullLong("mosFeedBackId");
			} else {
				sql.setLong("mosFeedBackId", mosFeedBack.getMosFeedBackId());
			}

			if (StringUtil.isBlank(mosFeedBack.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", mosFeedBack.getRemarks());
			}

			if (StringUtil.isBlank(mosFeedBack.getUserId())) {
				sql.setNullLong("userId");
			} else {
				sql.setLong("userId", mosFeedBack.getUserId());
			}

			sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * ������ѯ��SQL��
	 * @return String �� ������ѯ��SQL��
	 */
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
		if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}

		Sql sql = new Sql(
				"SELECT CREATE_TIME,EMAIL,FEED_DESC,MOS_FEED_BACK_ID,REMARKS,USER_ID FROM MOS_FEED_BACK WHERE 1=1  ");
		sql.append(" and MOS_FEED_BACK_ID=:mosFeedBackId");
		sql.setLong("mosFeedBackId", mosFeedBack.getMosFeedBackId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mosFeedBack = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosFeedBack = new MosFeedBackSVO();
				mosFeedBack.setCreateTime(rs.getTimestamp("CREATE_TIME"));
				mosFeedBack.setEmail(rs.getString("EMAIL"));
				mosFeedBack.setFeedDesc(rs.getString("FEED_DESC"));
				mosFeedBack.setMosFeedBackId(rs.getString("MOS_FEED_BACK_ID"));
				mosFeedBack.setRemarks(rs.getString("REMARKS"));
				mosFeedBack.setUserId(rs.getString("USER_ID"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return mosFeedBack;
	}

	/**
	 * ������ѯ��SQL��
	 * @return String �� ������ѯ��SQL��
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_TIME,EMAIL,FEED_DESC,MOS_FEED_BACK_ID,REMARKS,USER_ID FROM MOS_FEED_BACK WHERE 1=1 ");
		try {
			if (mosFeedBack.getFlagCreateTime() == 1) {
				if (mosFeedBack.getCreateTime() == null) {
					sql.append(" and CREATE_TIME is null ");
				} else {
					sql.append(" and CREATE_TIME=:createTime");
					sql.setTimestamp("createTime", mosFeedBack.getCreateTime());
				}
			}

			if (mosFeedBack.getFlagEmail() == 1) {
				if (StringUtil.isBlank(mosFeedBack.getEmail())) {
					sql.append(" and EMAIL is null ");
				} else {
					sql.append(" and EMAIL=:email");
					sql.setString("email", mosFeedBack.getEmail());
				}
			}

			if (mosFeedBack.getFlagFeedDesc() == 1) {
				if (StringUtil.isBlank(mosFeedBack.getFeedDesc())) {
					sql.append(" and FEED_DESC is null ");
				} else {
					sql.append(" and FEED_DESC=:feedDesc");
					sql.setString("feedDesc", mosFeedBack.getFeedDesc());
				}
			}

			if (mosFeedBack.getFlagMosFeedBackId() == 1) {
				if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
					sql.append(" and MOS_FEED_BACK_ID is null ");
				} else {
					sql.append(" and MOS_FEED_BACK_ID=:mosFeedBackId");
					sql
							.setLong("mosFeedBackId", mosFeedBack
									.getMosFeedBackId());
				}
			}

			if (mosFeedBack.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(mosFeedBack.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", mosFeedBack.getRemarks());
				}
			}

			if (mosFeedBack.getFlagUserId() == 1) {
				if (StringUtil.isBlank(mosFeedBack.getUserId())) {
					sql.append(" and USER_ID is null ");
				} else {
					sql.append(" and USER_ID=:userId");
					sql.setLong("userId", mosFeedBack.getUserId());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosFeedBack = new MosFeedBackSVO();
				mosFeedBack.setCreateTime(rs.getTimestamp("CREATE_TIME"));
				mosFeedBack.setEmail(rs.getString("EMAIL"));
				mosFeedBack.setFeedDesc(rs.getString("FEED_DESC"));
				mosFeedBack.setMosFeedBackId(rs.getString("MOS_FEED_BACK_ID"));
				mosFeedBack.setRemarks(rs.getString("REMARKS"));
				mosFeedBack.setUserId(rs.getString("USER_ID"));
				res.add(mosFeedBack);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * ���µ�SQL��
	 * @return String �� ���µ�SQL��
	 */
	public void update(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
		if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MOS_FEED_BACK SET ");
		try {
			if (mosFeedBack.getFlagCreateTime() == 1) {
				sql.append("CREATE_TIME=:createTime,");
				sql.setTimestamp("createTime", mosFeedBack.getCreateTime());
			}

			if (mosFeedBack.getFlagEmail() == 1) {
				sql.append("EMAIL=:email,");
				sql.setString("email", mosFeedBack.getEmail());
			}

			if (mosFeedBack.getFlagFeedDesc() == 1) {
				sql.append("FEED_DESC=:feedDesc,");
				sql.setString("feedDesc", mosFeedBack.getFeedDesc());
			}

			if (mosFeedBack.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", mosFeedBack.getRemarks());
			}

			if (mosFeedBack.getFlagUserId() == 1) {
				sql.append("USER_ID=:userId,");
				sql.setLong("userId", mosFeedBack.getUserId());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			sql.append(" and MOS_FEED_BACK_ID=:mosFeedBackId");
			sql.setLong("mosFeedBackId", mosFeedBack.getMosFeedBackId());

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(ps);
		}

	}

	/**
	 * �������Ӽ�¼��
	 * @return String �� �������ӵ�SQL��
	 */
	public void addBat(List list) throws AppException, SysException {
		if (list == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_FEED_BACK(CREATE_TIME,EMAIL,FEED_DESC,MOS_FEED_BACK_ID,REMARKS,USER_ID)");
		sql
				.append(" VALUES (:createTime,:email,:feedDesc,:mosFeedBackId,:remarks,:userId)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) list.get(i);
				if (mosFeedBack == null) {
					throw new AppException("100001", "ȱ��DAO��������");
				}
				if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
					throw new AppException("100002", "ȱ�ٶ����������");
				}
				if (mosFeedBack.getCreateTime() == null) {
					sql.setNullDate("createTime");
				} else {
					sql.setTimestamp("createTime", mosFeedBack.getCreateTime());
				}

				if (StringUtil.isBlank(mosFeedBack.getEmail())) {
					sql.setNullString("email");
				} else {
					sql.setString("email", mosFeedBack.getEmail());
				}

				if (StringUtil.isBlank(mosFeedBack.getFeedDesc())) {
					sql.setNullString("feedDesc");
				} else {
					sql.setString("feedDesc", mosFeedBack.getFeedDesc());
				}

				if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
					sql.setNullLong("mosFeedBackId");
				} else {
					sql
							.setLong("mosFeedBackId", mosFeedBack
									.getMosFeedBackId());
				}

				if (StringUtil.isBlank(mosFeedBack.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", mosFeedBack.getRemarks());
				}

				if (StringUtil.isBlank(mosFeedBack.getUserId())) {
					sql.setNullLong("userId");
				} else {
					sql.setLong("userId", mosFeedBack.getUserId());
				}

				sql.fillParams(ps);
				sql.log(this.getClass());
				sql.clearParameters();
				ps.addBatch();
			}

			ps.executeBatch();
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * ���ݴ������ɾ��һ������һ����¼��
	 * @return String �� ɾ����SQL��
	 */
	public void delete(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
		if (StringUtil.isBlank(mosFeedBack.getMosFeedBackId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MOS_FEED_BACK WHERE 1=1  ");
		sql.append(" and MOS_FEED_BACK_ID=:mosFeedBackId");
		sql.setLong("mosFeedBackId", mosFeedBack.getMosFeedBackId());

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);

		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * ע��һ������һ��
	 * @return String �� ע��һ������һ����SQL��
	 */
	public void unable(GenericVO vo) throws AppException, SysException {
		MosFeedBackSVO mosFeedBack = (MosFeedBackSVO) vo;
	}
}
