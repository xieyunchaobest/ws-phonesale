package com.cattsoft.sm.vo;

import com.cattsoft.pub.vo.GenericVO;

public class FileSVO extends GenericVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String fileName=null;
	
	String filePath=null;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
