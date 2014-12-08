package com.cattsoft.pub.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class LimitedHashMap extends HashMap{
	
	public static int COLLECTION_SIZE_MAX = 9999; // ��������¼������
	public static Logger log = Logger.getLogger(LimitedLinkedList.class);

	//@Override
	public Object put(Object key, Object value) {
		int maxSize = COLLECTION_SIZE_MAX;
		if(this.size() >= maxSize){
			throw new IndexOutOfBoundsException("�����еļ�¼���������("+maxSize+")���ƣ�");
		}
		return super.put(key, value);
	}

	//@Override
	public void putAll(Map m) {
		int maxSize = COLLECTION_SIZE_MAX;
		if(this.size() >= maxSize){
			throw new IndexOutOfBoundsException("�����еļ�¼���������("+maxSize+")���ƣ�");
		}
		super.putAll(m);
	}
	
	

}
