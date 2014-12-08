package com.cattsoft.pub.util;

import java.util.HashSet;

import org.apache.log4j.Logger;

public class LimitedHashSet extends HashSet {
	public static int COLLECTION_SIZE_MAX = 9999; // ��������¼������
	public static Logger log = Logger.getLogger(LimitedHashSet.class);

	//@Override
	public boolean add(Object o) {
		int maxSize = COLLECTION_SIZE_MAX;
		if(this.size() >= maxSize){
			throw new IndexOutOfBoundsException("�����еļ�¼���������("+maxSize+")���ƣ�");
		}
		return super.add(o);
	}
	
	
	

}
