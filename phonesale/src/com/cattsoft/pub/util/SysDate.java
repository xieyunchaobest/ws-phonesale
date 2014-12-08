package com.cattsoft.pub.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException; 

/**
 * Title: CRM <br>
 * Description: ����ʱ�丨���� <br>
 * Date: Jun 23, 2007 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author wangcl
 */
public class SysDate {

    private static Logger log = Logger.getLogger(SysDate.class);

    private static Long timeInterval = null; // ���ݿ�ʱ���Ӧ�÷�����ʱ���

    static {
        if (timeInterval == null) {
            try {
                Timestamp time = SysDate.getCurrentTimestampFromDB();
                java.util.Date date = new java.util.Date();
                timeInterval = new Long(time.getTime() - date.getTime());
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    log.debug(e.getMessage());
                }
                timeInterval = new Long(0);
            }
        }
    }
    
    
    

    /**
     * ��ȡ��ǰ����
     * 
     * @return
     */
    public static java.sql.Date getCurrentDate() {
        return new java.sql.Date(new java.util.Date().getTime() + timeInterval.longValue());
    }

    /**
     * ��ȡ��ǰ���ݿ����ڣ�ֻ����<b>DAO</b>��<b>DOMAIN</b>�����
     * 
     * @return
     * @throws AppException 
     */
    public static java.sql.Date getCurrentDateFromDB() throws SysException, AppException {
        return (java.sql.Date) getCurrentOracleSysDate(false);
    }

    /**
     * ��ȡ��ǰʱ��
     * 
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new java.sql.Timestamp(new java.util.Date().getTime() + timeInterval.longValue());
    }

    /**
     * ��ȡ��ǰ���ݿ�ʱ�䣬ֻ����<b>DAO</b>��<b>DOMAIN</b>�����
     * 
     * @return
     * @throws AppException 
     */
    public static Timestamp getCurrentTimestampFromDB() throws SysException, AppException {
        return (java.sql.Timestamp) getCurrentOracleSysDate(true);
    }

    /**
     * ȡ��ϵͳ��ǰʱ�����
     * 
     * @return String
     */
    public static String getSysDateYear() {
        Date date = getCurrentDate();
        return getSysDateYear(date);
    }

    /**
     * ȡ��ָ��ʱ�����
     * 
     * @param date
     * @return String
     */
    public static String getSysDateYear(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        String year = String.valueOf(cd.get(Calendar.YEAR));
        return year;
    }

    /**
     * ȡ��ϵͳ��ǰʱ�����
     * 
     * @return String
     */

    public static String getSysDateMonth() {
        Date date = getCurrentDate();
        return getSysDateMonth(date);
    }

    /**
     * ȡ��ָ��ʱ�����
     * 
     * @param date
     * @return String
     */
    public static String getSysDateMonth(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        String month = String.valueOf(cd.get(Calendar.MONTH) + 1);
        if (month.length() == 1)
            month = "0" + month;
        return month;
    }

    private static java.util.Date getCurrentOracleSysDate(boolean showTime) throws SysException, AppException {
        java.util.Date date = null;
        String sql = "select sysdate from dual";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (showTime) {
                    date = rs.getTimestamp(1);
                } else {
                    date = rs.getDate(1);
                }
            }
        } catch (SQLException e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage());
            }
            throw new SysException("", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
        }
        return date;
    }

}
