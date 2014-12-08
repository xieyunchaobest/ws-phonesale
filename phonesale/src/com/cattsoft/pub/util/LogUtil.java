package com.cattsoft.pub.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

public class LogUtil {
	
	
	/**
	 * ��־debug�쳣��ջ��Ϣ
	 * @param log
	 * @param e
	 */
	public static void  logExceptionStackTrace(Logger log,Exception e){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		e.printStackTrace(p);
		log.error(os.toString());
	}
	
	/**
	 * ��־debug�쳣��ջ��Ϣ
	 * @param log
	 * @param e
	 */
	public static String  getExceptionStackTrace(Logger log,Exception e){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		e.printStackTrace(p);
		log.error(os.toString());
		return os.toString();
	}

}
