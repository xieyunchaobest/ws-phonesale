package com.cattsoft.pub.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

public class AppException extends GenericException {

	private static final long serialVersionUID = 1L;

	

	public AppException(String errId, String errOwnMsg) {
		this.errId = errId;
		this.errMsg = errOwnMsg;
		this.writeAppException();
	}

	private void writeAppException() {
		Logger log = Logger.getLogger(AppException.class);
		log.error("Ӧ�ô���ţ�" + this.errId);
		log.error("Ӧ�ô�����Ϣ��" + this.errMsg);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		this.printStackTrace(p);
		log.error(os.toString());

	}
}
