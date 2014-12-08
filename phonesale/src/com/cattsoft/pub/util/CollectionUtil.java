
package com.cattsoft.pub.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionUtil {
	
	/**
	 * ���ؼ���������ͺ����ݣ���ʽjava.util.List[a,b,c]
	 * @param collection
	 * @return
	 */
	public static String toString(Collection collection){
		if(collection == null) return null;
		
		StringBuffer str = new StringBuffer(collection.getClass().toString());
		str.append(collection.hashCode());
		str.append("[");
		Iterator itor = collection.iterator();
		while(itor.hasNext()){
			str.append(itor.next());
			str.append(",");
		}
		
		str.append("]");
		
		
		return str.toString();
	}
	
	
	/**
	 * ���ذ�ָ����ʶ�ָ��ļ�������
	 * @param collection
	 * @param flag
	 * @return
	 */
	public static String toString(Collection collection,String flag){
		if(collection == null||collection.size() <1) return "";
		
		StringBuffer str = new StringBuffer();
		Iterator itor = collection.iterator();
		while(itor.hasNext()){
			str.append(flag);
			str.append(itor.next().toString());
		}
		
		
		return str.substring(flag.length());
		
	}
	
	
	/**
	 * �������������oriSet���У�tarSet��û�е����ݣ�
	 * 
	 * @param oriSet
	 * @param tarSet
	 * @return
	 */
	public static Set minus(Set oriSet,Set tarSet){
		if(oriSet == null || oriSet.size() == 0) return oriSet;
		if(tarSet == null || tarSet.size() == 0) return oriSet;
		Iterator oriItor = oriSet.iterator();
		Set minusSet = new HashSet();
		while(oriItor.hasNext()){
			Object oriObj = oriItor.next();
			Iterator tarItor = tarSet.iterator();
			boolean isExist = false; 
			while(tarItor.hasNext()){
				Object tarObj = tarItor.next();
				if(tarObj.equals(oriObj)){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				minusSet.add(oriObj);
			}
			
		}
		return minusSet;
		
	}
	
	/**
	 * ��Setת����List
	 * @param set
	 * @return
	 */
	public static List toList(Set set){
		if(set == null){
			return null;
		}
		if(set.size() == 0) return new ArrayList();
		List list = new ArrayList();
		Iterator itor = set.iterator();
		while(itor.hasNext()){
			Object obj = itor.next();
			list.add(obj);
		}
		return list;
	}
	
	
	public static void main(String[] args){
		//List list = new ArrayList();
		//CollectionUtil.toString(list,",");
		
		Set a = new HashSet();
		a.add("1");
		a.add("2");
		a.add("3");
		Set b = new HashSet();
		b.add("3");
		b.add("4");
		
		System.out.println(CollectionUtil.toString(CollectionUtil.minus(a, b)));
	}

}
