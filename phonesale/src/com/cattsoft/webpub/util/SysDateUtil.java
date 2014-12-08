package com.cattsoft.webpub.util;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.SysDate;

/**
 * Title: CRM <br>
 * Description: ����ʱ�丨���ֻ࣬����<b>���ֲ�</b>���� <br>
 * Date: Jun 23, 2007 <br>
 * Copyright (c) 2007 CATTSoft <br>
 */
public class SysDateUtil {
    private static Logger log = Logger.getLogger(SysDateUtil.class);

    /**
     * ��ȡ��ǰ����
     * 
     * @return
     */
    public static Date getCurrentDate() throws AppException, SysException {
        return SysDate.getCurrentDate();
    }

    /**
     * ��ȡ��ǰ���ݿ�����
     * 
     * @return
     * @throws AppException 
     */
    public static Date getCurrentDateFromDB() throws SysException, AppException {
        Date date = null;
        try {
            ConnectionFactory.createConnection();
            date = SysDate.getCurrentDateFromDB();
        } catch (SysException e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage());
            }
            throw new SysException("", e);
        } finally {
            ConnectionFactory.closeConnection();
        }
        return date;
    }

    /**
     * ��ȡ��ǰʱ��
     * 
     * @return
     */
    public static Timestamp getCurrentTimestamp() throws AppException, SysException {
        return SysDate.getCurrentTimestamp();
    }

    /**
     * ��ȡ��ǰ���ݿ�ʱ��
     * 
     * @return
     * @throws AppException 
     */
    public static Timestamp getCurrentTimestampFromDB() throws SysException, AppException {
        Timestamp time = null;
        try {
            ConnectionFactory.createConnection();
            time = SysDate.getCurrentTimestamp();
        } catch (AppException e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage());
            }
            throw new SysException("", e);
        } finally {
            ConnectionFactory.closeConnection();
        }
        return time;
    }
}
