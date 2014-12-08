package com.cattsoft.pub.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

public class CollectionFactory {
	
	public static String COLLECTION_LIST = "List"; // ��������List
	
	public static String COLLECTION_SET = "Set"; // ��������Set
	
	public static String COLLECTION_LINKEDLIST = "LinkedList"; // ��������LinkedList
	
	public static String COLLECTION_MAP = "Map"; // ��������Map
	
	
	/**
	 * ���ݲ�������һ��Collection����
	 * @param param
	 * @return	
	 * @throws AppException
	 * @throws SysException 
	 */
	public static Collection createCollection(String param) throws AppException, SysException {
		if (null == param)
			return null;
     
		Collection colObject = null;
		//�����ñ��ȡ��ѯ�������ƵĿ���
		String limittedFlag;
		
			limittedFlag = SysConfigData.getSysConfigCurValue(SysConstants.LIMITTD_QUERY_RECORD, null,
					null, null, null, null);
		
		
		if(!StringUtil.isBlank(limittedFlag)&& SysConstants.TRUE.equals(limittedFlag)){
			
			if(COLLECTION_LIST.equalsIgnoreCase(param)){
				colObject=new LimitedArrayList();				
			}else if(COLLECTION_SET.equalsIgnoreCase(param)){
				colObject=new LimitedHashSet();				
			}else if(COLLECTION_LINKEDLIST.equalsIgnoreCase(param)){
				colObject=new LimitedLinkedList(); 
			}else{
				throw new AppException("610017","���ݲ���:"+param+"�������϶���ʧ�ܣ�û���ҵ�ƥ����! ");
			}
		}else{
			if(COLLECTION_LIST.equalsIgnoreCase(param)){
				colObject=new ArrayList();				
			}else if(COLLECTION_SET.equalsIgnoreCase(param)){
				colObject=new HashSet();				
			}else if(COLLECTION_LINKEDLIST.equalsIgnoreCase(param)){
				colObject=new LinkedList(); 
			}else{
				throw new AppException("610017","���ݲ���:"+param+"�������϶���ʧ�ܣ�û���ҵ�ƥ����! ");
			}
		}
		return colObject;
	}
	
	/**
	 * ���ݲ�������һ��Map����
	 * @param param
	 * @return	 
	 * @throws AppException
	 * @throws SysException 
	 */
	public static Map createMap(String param) throws AppException, SysException {
		if (null == param)
			return null;
     
		Map colObject = null;
		//�����ñ��ȡ��ѯ�������ƵĿ���
		String limittedFlag;
		
			limittedFlag = SysConfigData.getSysConfigCurValue(SysConstants.LIMITTD_QUERY_RECORD, null,
					null, null, null, null);
		
		
		if(!StringUtil.isBlank(limittedFlag)&& SysConstants.TRUE.equals(limittedFlag)){
			
			if(COLLECTION_MAP.equalsIgnoreCase(param)){
				colObject=new LimitedHashMap();				
			}else{
				throw new AppException("610018","���ݲ���:"+param+"�������϶���ʧ�ܣ�û���ҵ�ƥ����! ");
				
			}
		}else{
			if(COLLECTION_MAP.equalsIgnoreCase(param)){
				colObject=new HashMap();				
			}else{
				throw new AppException("610018","���ݲ���:"+param+"�������϶���ʧ�ܣ�û���ҵ�ƥ����! ");
				
			}
		}
		return colObject;
	}

}
