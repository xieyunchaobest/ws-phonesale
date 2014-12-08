package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cattsoft.tm.component.dao.IMosCallLogSDAO;
import com.cattsoft.tm.vo.MosCallLogSVO;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;

/**
 * ����MosCallLogSDAOImpl
 * <p>Company: �������</p>
 * @author ����С����
 * @version 1.0  2007-5-14
 */
public class MosCallLogSDAOImpl implements IMosCallLogSDAO {
	private static Logger log = Logger.getLogger(MosCallLogSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * ���ӡ�
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
		if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_CALL_LOG(BOOK_TIME,CALLED_PHONE_NO,CALLER_PHONE_NO,CALL_DURATION,END_TIME,MOS_CALL_LOG_ID,REMARKS,START_TIME,WO_NBR)");
		sql
				.append(" VALUES (:bookTime,:calledPhoneNo,:callerPhoneNo,:callDuration,:endTime,:mosCallLogId,:remarks,:startTime,:woNbr)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (mosCallLog.getBookTime() == null) {
				sql.setNullDate("bookTime");
			} else {
				sql.setTimestamp("bookTime", mosCallLog.getBookTime());
			}

			if (StringUtil.isBlank(mosCallLog.getCalledPhoneNo())) {
				sql.setNullLong("calledPhoneNo");
			} else {
				sql.setLong("calledPhoneNo", mosCallLog.getCalledPhoneNo());
			}

			if (StringUtil.isBlank(mosCallLog.getCallerPhoneNo())) {
				sql.setNullLong("callerPhoneNo");
			} else {
				sql.setLong("callerPhoneNo", mosCallLog.getCallerPhoneNo());
			}

			if (StringUtil.isBlank(mosCallLog.getCallDuration())) {
				sql.setNullLong("callDuration");
			} else {
				sql.setLong("callDuration", mosCallLog.getCallDuration());
			}

			if (mosCallLog.getEndTime() == null) {
				sql.setNullDate("endTime");
			} else {
				sql.setTimestamp("endTime", mosCallLog.getEndTime());
			}

			if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
				sql.setNullLong("mosCallLogId");
			} else {
				sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());
			}

			if (StringUtil.isBlank(mosCallLog.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", mosCallLog.getRemarks());
			}

			if (mosCallLog.getStartTime() == null) {
				sql.setNullDate("startTime");
			} else {
				sql.setTimestamp("startTime", mosCallLog.getStartTime());
			}

			if (StringUtil.isBlank(mosCallLog.getWoNbr())) {
				sql.setNullLong("woNbr");
			} else {
				sql.setLong("woNbr", mosCallLog.getWoNbr());
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
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
		if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}

		Sql sql = new Sql(
				"SELECT BOOK_TIME,CALLED_PHONE_NO,CALLER_PHONE_NO,CALL_DURATION,END_TIME,MOS_CALL_LOG_ID,REMARKS,START_TIME,WO_NBR FROM MOS_CALL_LOG WHERE 1=1  ");
		sql.append(" and MOS_CALL_LOG_ID=:mosCallLogId");
		sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mosCallLog = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosCallLog = new MosCallLogSVO();
				mosCallLog.setBookTime(rs.getTimestamp("BOOK_TIME"));
				mosCallLog.setCalledPhoneNo(rs.getString("CALLED_PHONE_NO"));
				mosCallLog.setCallerPhoneNo(rs.getString("CALLER_PHONE_NO"));
				mosCallLog.setCallDuration(rs.getString("CALL_DURATION"));
				mosCallLog.setEndTime(rs.getTimestamp("END_TIME"));
				mosCallLog.setMosCallLogId(rs.getString("MOS_CALL_LOG_ID"));
				mosCallLog.setRemarks(rs.getString("REMARKS"));
				mosCallLog.setStartTime(rs.getTimestamp("START_TIME"));
				mosCallLog.setWoNbr(rs.getString("WO_NBR"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC�����쳣��", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return mosCallLog;
	}

	/**
	 * ������ѯ��SQL��
	 * @return String �� ������ѯ��SQL��
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "ȱ��DAO��������");
		}
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT BOOK_TIME,CALLED_PHONE_NO,CALLER_PHONE_NO,CALL_DURATION,END_TIME,MOS_CALL_LOG_ID,REMARKS,START_TIME,WO_NBR FROM MOS_CALL_LOG WHERE 1=1 ");
		try {
			if (mosCallLog.getFlagBookTime() == 1) {
				if (mosCallLog.getBookTime() == null) {
					sql.append(" and BOOK_TIME is null ");
				} else {
					sql.append(" and BOOK_TIME=:bookTime");
					sql.setTimestamp("bookTime", mosCallLog.getBookTime());
				}
			}

			if (mosCallLog.getFlagCalledPhoneNo() == 1) {
				if (StringUtil.isBlank(mosCallLog.getCalledPhoneNo())) {
					sql.append(" and CALLED_PHONE_NO is null ");
				} else {
					sql.append(" and CALLED_PHONE_NO=:calledPhoneNo");
					sql.setLong("calledPhoneNo", mosCallLog.getCalledPhoneNo());
				}
			}

			if (mosCallLog.getFlagCallerPhoneNo() == 1) {
				if (StringUtil.isBlank(mosCallLog.getCallerPhoneNo())) {
					sql.append(" and CALLER_PHONE_NO is null ");
				} else {
					sql.append(" and CALLER_PHONE_NO=:callerPhoneNo");
					sql.setLong("callerPhoneNo", mosCallLog.getCallerPhoneNo());
				}
			}

			if (mosCallLog.getFlagCallDuration() == 1) {
				if (StringUtil.isBlank(mosCallLog.getCallDuration())) {
					sql.append(" and CALL_DURATION is null ");
				} else {
					sql.append(" and CALL_DURATION=:callDuration");
					sql.setLong("callDuration", mosCallLog.getCallDuration());
				}
			}

			if (mosCallLog.getFlagEndTime() == 1) {
				if (mosCallLog.getEndTime() == null) {
					sql.append(" and END_TIME is null ");
				} else {
					sql.append(" and END_TIME=:endTime");
					sql.setTimestamp("endTime", mosCallLog.getEndTime());
				}
			}

			if (mosCallLog.getFlagMosCallLogId() == 1) {
				if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
					sql.append(" and MOS_CALL_LOG_ID is null ");
				} else {
					sql.append(" and MOS_CALL_LOG_ID=:mosCallLogId");
					sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());
				}
			}

			if (mosCallLog.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(mosCallLog.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", mosCallLog.getRemarks());
				}
			}

			if (mosCallLog.getFlagStartTime() == 1) {
				if (mosCallLog.getStartTime() == null) {
					sql.append(" and START_TIME is null ");
				} else {
					sql.append(" and START_TIME=:startTime");
					sql.setTimestamp("startTime", mosCallLog.getStartTime());
				}
			}

			if (mosCallLog.getFlagWoNbr() == 1) {
				if (StringUtil.isBlank(mosCallLog.getWoNbr())) {
					sql.append(" and WO_NBR is null ");
				} else {
					sql.append(" and WO_NBR=:woNbr");
					sql.setLong("woNbr", mosCallLog.getWoNbr());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosCallLog = new MosCallLogSVO();
				mosCallLog.setBookTime(rs.getTimestamp("BOOK_TIME"));
				mosCallLog.setCalledPhoneNo(rs.getString("CALLED_PHONE_NO"));
				mosCallLog.setCallerPhoneNo(rs.getString("CALLER_PHONE_NO"));
				mosCallLog.setCallDuration(rs.getString("CALL_DURATION"));
				mosCallLog.setEndTime(rs.getTimestamp("END_TIME"));
				mosCallLog.setMosCallLogId(rs.getString("MOS_CALL_LOG_ID"));
				mosCallLog.setRemarks(rs.getString("REMARKS"));
				mosCallLog.setStartTime(rs.getTimestamp("START_TIME"));
				mosCallLog.setWoNbr(rs.getString("WO_NBR"));
				res.add(mosCallLog);

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
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
		if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MOS_CALL_LOG SET ");
		try {
			if (mosCallLog.getFlagBookTime() == 1) {
				sql.append("BOOK_TIME=:bookTime,");
				sql.setTimestamp("bookTime", mosCallLog.getBookTime());
			}

			if (mosCallLog.getFlagCalledPhoneNo() == 1) {
				sql.append("CALLED_PHONE_NO=:calledPhoneNo,");
				sql.setLong("calledPhoneNo", mosCallLog.getCalledPhoneNo());
			}

			if (mosCallLog.getFlagCallerPhoneNo() == 1) {
				sql.append("CALLER_PHONE_NO=:callerPhoneNo,");
				sql.setLong("callerPhoneNo", mosCallLog.getCallerPhoneNo());
			}

			if (mosCallLog.getFlagCallDuration() == 1) {
				sql.append("CALL_DURATION=:callDuration,");
				sql.setLong("callDuration", mosCallLog.getCallDuration());
			}

			if (mosCallLog.getFlagEndTime() == 1) {
				sql.append("END_TIME=:endTime,");
				sql.setTimestamp("endTime", mosCallLog.getEndTime());
			}

			if (mosCallLog.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", mosCallLog.getRemarks());
			}

			if (mosCallLog.getFlagStartTime() == 1) {
				sql.append("START_TIME=:startTime,");
				sql.setTimestamp("startTime", mosCallLog.getStartTime());
			}

			if (mosCallLog.getFlagWoNbr() == 1) {
				sql.append("WO_NBR=:woNbr,");
				sql.setLong("woNbr", mosCallLog.getWoNbr());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			sql.append(" and MOS_CALL_LOG_ID=:mosCallLogId");
			sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeQuery();

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
				"INSERT INTO MOS_CALL_LOG(BOOK_TIME,CALLED_PHONE_NO,CALLER_PHONE_NO,CALL_DURATION,END_TIME,MOS_CALL_LOG_ID,REMARKS,START_TIME,WO_NBR)");
		sql
				.append(" VALUES (:bookTime,:calledPhoneNo,:callerPhoneNo,:callDuration,:endTime,:mosCallLogId,:remarks,:startTime,:woNbr)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MosCallLogSVO mosCallLog = (MosCallLogSVO) list.get(i);
				if (mosCallLog == null) {
					throw new AppException("100001", "ȱ��DAO��������");
				}
				if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
					throw new AppException("100002", "ȱ�ٶ����������");
				}
				if (mosCallLog.getBookTime() == null) {
					sql.setNullDate("bookTime");
				} else {
					sql.setTimestamp("bookTime", mosCallLog.getBookTime());
				}

				if (StringUtil.isBlank(mosCallLog.getCalledPhoneNo())) {
					sql.setNullLong("calledPhoneNo");
				} else {
					sql.setLong("calledPhoneNo", mosCallLog.getCalledPhoneNo());
				}

				if (StringUtil.isBlank(mosCallLog.getCallerPhoneNo())) {
					sql.setNullLong("callerPhoneNo");
				} else {
					sql.setLong("callerPhoneNo", mosCallLog.getCallerPhoneNo());
				}

				if (StringUtil.isBlank(mosCallLog.getCallDuration())) {
					sql.setNullLong("callDuration");
				} else {
					sql.setLong("callDuration", mosCallLog.getCallDuration());
				}

				if (mosCallLog.getEndTime() == null) {
					sql.setNullDate("endTime");
				} else {
					sql.setTimestamp("endTime", mosCallLog.getEndTime());
				}

				if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
					sql.setNullLong("mosCallLogId");
				} else {
					sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());
				}

				if (StringUtil.isBlank(mosCallLog.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", mosCallLog.getRemarks());
				}

				if (mosCallLog.getStartTime() == null) {
					sql.setNullDate("startTime");
				} else {
					sql.setTimestamp("startTime", mosCallLog.getStartTime());
				}

				if (StringUtil.isBlank(mosCallLog.getWoNbr())) {
					sql.setNullLong("woNbr");
				} else {
					sql.setLong("woNbr", mosCallLog.getWoNbr());
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
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
		if (StringUtil.isBlank(mosCallLog.getMosCallLogId())) {
			throw new AppException("100002", "ȱ�ٶ����������");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MOS_CALL_LOG WHERE 1=1  ");
		sql.append(" and MOS_CALL_LOG_ID=:mosCallLogId");
		sql.setLong("mosCallLogId", mosCallLog.getMosCallLogId());

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
		MosCallLogSVO mosCallLog = (MosCallLogSVO) vo;
	}
}
