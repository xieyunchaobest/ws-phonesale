package com.cattsoft.pub.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @file_name VariableHelper.java
 * @author cuilibin(cuilibin@cattsoft.com)
 * @date 2006-8-5 8:13:54
 * @description
 * @reviewed_by
 */

public class VariableHelper {

	public static Long getLong(Object value) {
		Long lon = null;
		try{
    		if (value != null) {
    			if (value instanceof Long) {
    				lon = (Long) value;
    			} else if (value.toString().trim().length() > 0) {
    				lon = new Long(value.toString());
    			}
    		}
		}catch(Exception e){
		    
		}
		return lon;
	}

	public static Double getDouble(Object value) {
		Double d = null;
		if (value != null && value.toString().trim().length() > 0) {
			d = new Double(value.toString().trim());
		}
		return d;
	}

	public static String getString(Object value) {
		String str = null;
		if (value != null && value.toString().trim().length() > 0) {
			str = value.toString().trim();
		}

		return str;
	}
	
	/**
     * @method_name getObject
     * @author cuilibin
     * @date 2009-10-14 ����01:39:10
     * @description ͨ��typeת����������
     * @param <T> 
     * @param obj ��Ҫת���Ķ���
     * @param type ��ȡ��������class
     * @return 
     * @reviewed_by
    */
    public static <T> T getObject(Object obj, Class<T> type) {
        Object result = null;
        if (obj != null && !obj.toString().trim().equals("")) {
            if (type == String.class) {
                if (obj instanceof String) {
                    result = obj;
                } else {
                    result = obj.toString().trim();
                }
            } else if (type == Long.class) {
                result = new Long(obj.toString().trim());
            } else if (type == Double.class) {
                result = new Double(obj.toString().trim());
            } else if (type == Integer.class) {
                result = new Integer(obj.toString().trim());
            } else if (type == Date.class) {
                result = obj;
            } else {
                result = obj;
            }
        } 
      
        return (T) result;
    }
   
	public static Date getDate(Object value) {
		Date date = null;
		if (value != null && value instanceof Date) {
			date = (Date) value;
		}

		return date;
	}

	public static Integer getInteger(Object value) {
		Integer integer = null;
		if (value != null && value.toString().trim().length() > 0) {
			integer = new Integer(value.toString().trim());
		}

		return integer;
	}

	public static int getInt(Object value) {
		int i = 0;
		if (value != null && value.toString().trim().length() > 0) {
			i = Integer.parseInt(value.toString().trim());
		}

		return i;
	}

	public static long getlong(Object value) {
		long lon = 0;
		if (value != null && value.toString().trim().length() > 0) {
			lon = Long.parseLong(value.toString().trim());
		}

		return lon;
	}

	public static String createMessage(List errors) {
		String message = "";
		for (int i = 0; i < errors.size(); i++) {
			if (i == 0) {
				message = message + errors.get(i).toString();
			} else {
				message = message + "\n" + errors.get(i).toString();
			}
		}

		return message;
	}

	public static Object copy(Object oldObject, Object object)
			throws RuntimeException {
		try {
			Method[] method = object.getClass().getDeclaredMethods();
			for (int i = 0; i < method.length; i++) {
				String methodName = method[i].getName();
				int modifier = method[i].getModifiers();
				if (modifier == 1) {
					if (methodName.startsWith("set")) {
						String methodGetName = Character.toUpperCase(methodName
								.charAt(3))
								+ methodName.substring(4);
						Method methodGet = oldObject.getClass()
								.getDeclaredMethod("get" + methodGetName, null);
						method[i].invoke(object, new Object[] { methodGet
								.invoke(oldObject, null) });
					} else if (methodName.startsWith("get")) {
						String methodSetName = Character.toUpperCase(methodName
								.charAt(3))
								+ methodName.substring(4);
						Method methodSet = object.getClass().getDeclaredMethod(
								"set" + methodSetName,
								new Class[] { method[i].getReturnType() });
						methodSet.invoke(object, new Object[] { method[i]
								.invoke(oldObject, null) });
					}
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new RuntimeException();
		}

		return object;
	}


	/**
	 * @method_name getDatabaseTime()
	 * @author cuilibin
	 * @date 2007-1-14 8:20:24
	 * @description ������ݿ�ʱ��
	 * @return Date
	 * @exception
	 * @modify
	 */
	public static Date getDatabaseTime() {
		return new Date();
	}

	/**
	 * @method_name isExistValue()
	 * @author rzg
	 * @date 2007-4-11 8:20:24
	 * @description �ж϶����Ƿ񱻸�ֵ
	 * @return Date
	 * @exception
	 * @modify
	 */
	public static boolean isExistValue(Object object) {
		boolean boo = false;
		Method[] methods = object.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = (Method) methods[i];
			if (method.getName().startsWith("get")
					&& !method.getName().equals("getClass")) {
				try {
					if (method.invoke(object, null) != null) {
						boo = true;
					}
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		return boo;
	}

	/**
	 * @method_name isExistValue()
	 * @author rzg
	 * @date 2007-4-11 8:20:24
	 * @description ���ݺ��ֵõ�ƴ����д
	 * @return Date
	 * @exception
	 * @modify
	 */

	// ���������λ��ת������
	static final int GB_SP_DIFF = 160;

	// ��Ź���һ�����ֲ�ͬ��������ʼ��λ��
	static final int[] secPosvalueList = { 1601, 1637, 1833, 2078, 2274, 2302,
			2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027,
			4086, 4390, 4558, 4684, 4925, 5249, 5600 };

	// ��Ź���һ�����ֲ�ͬ��������ʼ��λ���Ӧ����
	static final char[] firstLetter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'W', 'X',
			'Y', 'Z' };

	public static String getSpell(final String oriStr) {
		String str = oriStr;
		StringBuffer buffer = new StringBuffer();
		char ch;
		char[] temp;
		for (int i = 0; i < str.length(); i++) { // ���δ���str��ÿ���ַ�
			ch = str.charAt(i);

			if (ch >= 'a' & ch <= 'z') {
				ch = (char) ((int) ch - 32);

			}

			temp = new char[] { ch };
			byte[] uniCode = new String(temp).getBytes();
			if (uniCode[0] < 128 && uniCode[0] > 0) { // �Ǻ���
				buffer.append(temp);
			} else {
				buffer.append(convert(uniCode));
			}
		}
		return buffer.toString();
	}

	/**
	 * ��ȡһ�����ֵ�ƴ������ĸ�� GB�������ֽڷֱ��ȥ160��ת����10��������ϾͿ��Եõ���λ��
	 * ���纺�֡��㡱��GB����0xC4/0xE3���ֱ��ȥ0xA0����0x24/0x43
	 * 0x24ת��10���ƾ���36��0x43��67����ô������λ�����3667���ڶ��ձ��ж���Ϊ��n��
	 */

	static char convert(byte[] bytes) {

		char result = '-';
		int secPosvalue = 0;
		int i;
		for (i = 0; i < bytes.length; i++) {
			bytes[i] -= GB_SP_DIFF;
		}
		secPosvalue = bytes[0] * 100 + bytes[1];
		for (i = 0; i < 23; i++) {
			if (secPosvalue >= secPosvalueList[i]
					&& secPosvalue < secPosvalueList[i + 1]) {
				result = firstLetter[i];
				break;
			}
		}
		return result;
	}
	/**
	 * @method_name isNumeric
	 * @author tubo
	 * @date 2008-5-19 ����11:15:15
	 * @description �ж�һ���ַ����Ƿ�ȫ������,
	 *               ���򷵻�null,�����򷵻ط������ַ�ǰ�����ַ���
	 * @param s
	 * @return 
	 * @reviewed_by
	 */
	public static String returnNotNumberic(String s){
		String str= null;
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if((c > '9') || (c < '0')) {
				str = c+"";
			}
		}
		if(str==null){
			return null;
		}
		return s.substring(0, s.lastIndexOf(str)+1);
	}

}
