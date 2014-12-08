package com.cattsoft.pub.util;

import org.apache.log4j.Logger;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-13 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class ObjectUtil {
	private static Logger log = Logger.getLogger(ObjectUtil.class);

	/**
	 * ��������װ��һ��ʵ������
	 * 
	 * @param name
	 * @return
	 * @throws UtilException
	 */
	public static Object createByName(String name) throws UtilException {
		if (null == name)
			return null;
		Class implClass = null;

		try {
			implClass = Class.forName(name);

		} catch (ClassNotFoundException e) {
			log.error( e.getMessage());
			throw new UtilException("�������ִ�������ʧ�ܣ� " + name, e);
		}
		return createByClass(implClass);
	}

	/**
	 * ��������װ��һ��ʵ������
	 * 
	 * @param name
	 * @return
	 * @throws UtilException
	 */
	public static Object createByClass(Class classObj) throws UtilException {
		if (null == classObj)
			return null;

		Object impl = null;

		try {
			impl = classObj.newInstance();

		} catch (InstantiationException e) {
			log.error( e.getMessage());
			throw new UtilException("����Class��������ʧ�ܣ� " + classObj.getName(), e);
		} catch (IllegalAccessException e) {
			log.error( e.getMessage());
			throw new UtilException("����Class��������ʧ�ܣ�" + classObj.getName(), e);
		}
		return impl;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
