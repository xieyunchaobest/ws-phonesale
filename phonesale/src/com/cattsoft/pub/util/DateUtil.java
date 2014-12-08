package com.cattsoft.pub.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-18 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class DateUtil {
	public static SimpleDateFormat datetimef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat datetimehm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * ��ָ���ĸ�ʽ�����ڶ���ת��Ϊ�ַ���
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String to_char(Date date, String format) {
		if (date == null)
			return null;
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * ��ָ����ʽ���ַ���ת��Ϊ���ڶ���
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws SysException
	 * 
	 */
	public static Date to_date(String dateStr, String format) throws SysException {
		if (StringUtils.isEmpty(dateStr))
			return null;
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			throw new SysException("", "ϵͳת�������ַ���ʱ����", e);
		}
	}

	/**
	 * �õ����ڴ�������������
	 * 
	 * @param date
	 * @param num
	 * @return java.util.Date
	 * @throws AppException
	 */
	public static Date addDays(Date date, int num) throws AppException {
		if (null == date)
			throw new AppException("", "ȱ�ٲ�����");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.DAY_OF_MONTH, num);
		return cal.getTime();
	}
	
	/**
	 * ��ǰʱ��+ָ��ʱ��������Ϊ��λ��
	 * 
	 * by baijm  2010-11-09
	 *
	 * @param date
	 * @param num
	 * @return java.util.Date
	 * @throws AppException
	 */
	public static Date addSeconds(Date date, int num) throws AppException {
		if (null == date)
			throw new AppException("", "ȱ�ٲ�����");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.SECOND, num);
		return cal.getTime();
	}

	/**
	 * ��ȡָ�����ڵ���ʼʱ�䣬�磺2007-6-6 00:00:00
	 * 
	 * @param date
	 * @return
	 * @throws AppException
	 */
	public static Date getStartDateTime(Date date) throws AppException {
		if (null == date)
			throw new AppException("", "ȱ�ٲ�����");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * ���ڣ���ȷ���룩ת�ַ���
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTime2Str(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	/**
	 * ���ڣ���ȷ���գ�ת�ַ���
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "yyyy-MM-dd");
		}
		return str;
	}

	/**
	 * �ַ���ת���ڣ���ȷ���룩
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2DateTime(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "yyyy-MM-dd HH:mm:ss");
		}
		return date;

	}
	/**
	 * �ַ���ת���ڣ���ȷ���֣�
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2DateTimeHM(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "yyyy-MM-dd HH:mm");
		}
		return date;

	}
	
	/**
	 * ���ڣ���ȷ���֣�ת�ַ���
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeHMStr(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "yyyy-MM-dd HH:mm");
		}
		return str;
	}	

	/**
	 * �ַ���ת���ڣ���ȷ���գ�
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2Date(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "yyyy-MM-dd");
		}
		return date;

	}

	/**
	 * ��ȡһ������ʱ��
	 * 
	 * @return
	 * @throws SysException
	 */
	public static Date getForeverDate() throws SysException {
		return to_date("2049-12-31 00:00:00", "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ������ݿ⵱ǰʱ��
	 * 
	 * @return
	 */
	public static Date getDBDate() {
		return SysDate.getCurrentTimestamp();

	}
	
	/**
	 * ������ݿ⵱ǰʱ��
	 * 
	 * @return
	 */
	public static Timestamp getDBTimestamp() {
		return SysDate.getCurrentTimestamp();

	}
	
	/**
	 * ������ݿ⵱ǰʱ���ַ��� ��ȷ����
	 * 
	 * @return
	 */
	public static String getDBDateTimeStr() {
		return DateUtil.dateTime2Str(SysDate.getCurrentTimestamp());

	}
	/**
	 * ������ݿ⵱ǰʱ���ַ���,��ȷ����
	 * 
	 * @return
	 */
	public static String getDateTimeHMStr() {
		return datetimehm.format(SysDate.getCurrentDate());

	}
	/**
	 * �������ڷ�������
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Week(Date date) {
		if (date == null)
			return null;
		return new SimpleDateFormat("E").format(date);
	}
	/**
	 * ����Calendar�е�DAY_OF_WEEKֵ�������
	 * 1-�����գ�2-����һ...
	 * 
	 * @param num
	 * @return
	 */
	public static String getDayOfWeek(int num){
		if(num<1 || num > 7){
			return null;
		}
		String dayOfWeek = null;
		switch(num){
		case 1:
			dayOfWeek = "������";
			break;
		case 2:
			dayOfWeek = "����һ";
			break;
		case 3:
			dayOfWeek = "���ڶ�";
			break;
		case 4:
			dayOfWeek = "������";
			break;
		case 5:
			dayOfWeek = "������";
			break;
		case 6:
			dayOfWeek = "������";
			break;
		case 7:
			dayOfWeek = "������";
			break;
		}
		return dayOfWeek;
	}
	
	/**
	 * �ַ���ת���ڣ�ֻ��Сʱ�ͷ��ӣ�
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2HourMiniTime(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "HH:mm");
		}
		return date;

	}
	
	/**
	 * ����ת�ַ�����ֻ��Сʱ�ͷ��ӣ�
	 * 
	 * @param date
	 * @return
	 */
	public static String HourMiniTime2Str(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "HH:mm");
		}
		return str;
	}
	/**
	 * ��ȡָ��ʱ���Сʱ
	 * 
	 * @param date
	 * @return 
	 * added zdw
	 */
	public static int getHourOfDate(Date date) {
		if (date == null || "".equals(date)) {
			return -1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * �õ�һ�����ж�����
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDateOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		int dateOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		return dateOfMonth;
	}
	
	
	public static Date getTomorrowDay(Date curDate) { 
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(curDate);
		 calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
		 Date date=calendar.getTime(); 
		 return date;
	}
	
    /**
     * @method_name getDBDate4Zx
     * @author lijixu
     * @date 2011-2-11 ����03:37:02
     * @description ������ݿ⵱ǰʱ��,��ʽΪyyyyMMdd HH:mm:ss
     * @description �˷����������ƶ���Ŀʹ��
     * @return
     * @throws AppException
     * @throws SysException 
     * @reviewed_by
     */
	public static Date getDBDate4Zx() throws AppException, SysException {
		Date tempdate = getDBDate();
		String tmpStr = to_char(tempdate, "yyyyMMdd HH:mm:ss");
		Date retDate = to_date(tmpStr,"yyyyMMdd HH:mm:ss");
		return retDate;
	}
	
}
