package com.cattsoft.pub.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jdom.input.SAXBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
  
 

public class StringUtil {
	private static final Logger log = Logger.getLogger(StringUtil.class);

	/**
	 * ɾ��strָ���ĺ�׺
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public static String removeSuffix(String str, String suffix) throws UtilException {
		if (null == str)
			return null;
		if ("".equals(str.trim()))
			return "";

		if (null == suffix || "".equals(suffix))
			return str;

		if (str.endsWith(suffix)) {
			return str.substring(0, str.length() - suffix.length());
		}

		throw new UtilException(str + " û�а�ָ���ַ���" + suffix + "��β");
	}

	
	/**
	 * �����Ƚ�ȡ�ַ���
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String subString(String str, int length) {
		if (isBlank(str)) {
			return "";
		} else if (str.length() > length) {
			return str.substring(0, length);
		} else {
			return str;
		}
	}

	/**
	 * �Ƿ��ǿյģ�����null��""���ո�
	 * 
	 * @param str
	 * @return
	 * @throws UtilException
	 */
	public static boolean isBlank(String str) {
		if (null == str)
			return true;
		if ("".equals(str.trim()))
			return true;

		return false;
	}

	public static boolean isBlank(Long str) {
		if (null == str)
			return true;
		return false;
	}

	/**
	 * ������ת��String
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString().trim();
	}
	
	
	public static String add(String str,int num){
		int i = num;
		if(!isBlank(str)){
			int intStr = Integer.parseInt(str);
			i = i + intStr;
		}
		
		return Integer.toString(i) ;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if (null == str)
			return "";
		return str;

	}

	/**
	 * �������������ַ����ĺ�
	 * 
	 * @param augend
	 * @param addend
	 * @return
	 * @throws UtilException
	 */
	public static String getSum(String augend, String second, String addend) {
		if (augend == null)
			augend = "0";
		if (second == null)
			second = "0";
		if (addend == null)
			addend = "0";
		int sum = Integer.parseInt(augend) + Integer.parseInt(second) + Integer.parseInt(addend);
		return new Integer(sum).toString();
	}

	public static String change(String str, int n, boolean isLeft) {
		if (str == null || str.length() >= n)
			return str;
		String s = "";
		for (int i = str.length(); i < n; i++)
			s += "0";
		if (isLeft)
			return s + str;
		else
			return str + s;
	}

	public static String getInString(String str) {
		if (str == null)
			return null;
		StringBuffer sb = new StringBuffer("");
		String s[] = str.split(",");
		if (s != null && s.length > 0) {
			for (int i = 0; i < s.length; i++) {
				if (i != 0)
					sb.append(",");
				sb.append("'").append(s[i]).append("'");
			}
		}
		return sb.toString();
	}
	
	public static String subInStringByFlag(String str,String flag) {
		if (isBlank(str))
			return null;
		StringBuffer sb = new StringBuffer(str);
		int index = str.lastIndexOf(flag);
		if (index < 0) {
			return str;
		} else {
			str = sb.delete(sb.length()-flag.length(), sb.length()).toString();
			index = str.indexOf(flag);
			if (index < 0) {
				return str;
			} else {
				return sb.deleteCharAt(0).toString();
			}
		}
	}
	/**
	 * ���ݱ�ʶ��ȡstr�����һ��flag�������
	 * 
	 * @param str
	 * @param flag
	 * @return
	 */
	public static String getLastStr(String str, String flag) {
		if (isBlank(str))
			return null;
		int index = str.lastIndexOf(flag);
		if (index < 0) {
			return str;
		} else {
			return str.substring(index + flag.length());
		}

	}

	/**
	 * ��ȡ������ʽƥ����ַ�������$������һ�£���Ȼƥ��ʱ����������
	 * 
	 * @param str
	 * @return
	 */
	public static String getRegexStr(String str) {
		String ret = "";
		if (isBlank(str))
			return "";
		if (str.indexOf('$', 0) > -1) {
			while (str.length() > 0) {
				if (str.indexOf('$', 0) > -1) {
					ret += str.subSequence(0, str.indexOf('$', 0));
					ret += "\\$";
					str = str.substring(str.indexOf('$', 0) + 1, str.length());
				} else {
					ret += str;
					str = "";
				}
			}

		} else {

			ret = str;
		}

		return ret;

	}
	
	
	/**
	 * ����������ʽ��ȡƥ����ַ����б�
	 * ��ָ���ַ����У���������ʽҪ���ҳ�������ƥ���ϵ��ַ����б�
	 * @param str
	 * @param regx
	 * @return
	 */
	public static List catchStr(String str,String regx){
		if (isBlank(str))
			return null;
		
		List ret = new ArrayList();
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(str);
		int start = 0;
		int end = 0;
		while(matcher.find()){
			start = matcher.start();
			end = matcher.end();
			ret.add(str.substring(start,end));
		}
		return ret;
		
	}

	/**
	 * ���˻��з�
	 * 
	 * @param str
	 * @return
	 */
	public static String filterNextLine(String str) {
		if (isBlank(str))
			return "";
		return str.replaceAll("[\n\r\u0085\u2028\u2029]", "");
	}
	public static String lpad(String str ,int length) {  
		if (isBlank(str))
			return "";
		int  j= str.length();
		for(int i=j;i<length;i++){
        	str ="0"+str;
        }
        return str;
    }
	
	/**
	 * �����쳣ҳ��Դ���ַ���������MOS Native����׳����쳣ҳ��
	 * @param errMsg
	 * @return
	 */
	public static String getAppException4MOS(String errMsg) {
		//Modify By Zhangyuc 2013-06-06ȥ��spanԪ�ص�"/"
		String str="<!DOCTYPE html><html><head></head><body><span id=\"errinfospan\">"+errMsg+" </span></body></html>";
		return str;
	}
	
	
	public static boolean isExcetionInfo(String str) {
		if(isBlank(str))return false;
		Document doc=Jsoup.parseBodyFragment(str);
		Element  text=doc.getElementById("errinfospan");
		if(str.startsWith("<!DOCTYPE html")||str.startsWith("<!DOCTYPE HTML") || text!=null ) {
			return true;
		}
		return false;
	}
	
	public static String  getExcetionInfo(String result) {

		Document doc=Jsoup.parseBodyFragment(result);
		Element  ele= doc.getElementById("errinfospan");
		String text="";
        if( ele!=null) {
        	text=ele.text();
        }else {
        	text="�������˳����쳣��";
        }
        return text;
	}
	
	/**
	 * xmlת����Json�ַ���
	 * @param xml
	 * @return
	 */
	 public static  String xml2JSON(String xml) {  
	        JSONObject obj = new JSONObject();  
	        try {  
	            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));  
	            SAXBuilder sb = new SAXBuilder();  
	            org.jdom.Document doc = sb.build(is);  
	            org.jdom.Element root = doc.getRootElement();  
	            obj.put(root.getName(), iterateElement(root));  
	            return obj.toString();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	   
	  
	    /** 
	     * һ���������� 
	     *  
	     * @param element 
	     *            : org.jdom.Element 
	     * @return java.util.Map ʵ�� 
	     */  
	    @SuppressWarnings("unchecked")  
	    private static Map  iterateElement(org.jdom.Element element) {  
        List jiedian = element.getChildren();  
        org.jdom.Element et = null;  
        Map obj = new HashMap();  
        List list = null;  
        for (int i = 0; i < jiedian.size(); i++) {  
            list = new LinkedList();  
            et = (org.jdom.Element) jiedian.get(i);  
            if (et.getTextTrim().equals("")) {  
                if (et.getChildren().size() == 0)  
                    continue;  
                if (obj.containsKey(et.getName())) {  
                    list = (List) obj.get(et.getName());  
                }  
                list.add(iterateElement(et));  
                obj.put(et.getName(), list);  
            } else {  
                if (obj.containsKey(et.getName())) {  
                    list = (List) obj.get(et.getName());  
                }  
                list.add(et.getTextTrim());  
                obj.put(et.getName(), et.getTextTrim());  
            }  
        }  
        return obj;  
    }  
	    

	public static void main(String[] args) throws UtilException {
		//String str = "kkjlj l.class";
		String str = "where instr($GET_PHONE_GROUP_TYPE,'[31]')>0 and nvl(replace($GET_PHONE_GROUP_SPEC_STR,'[31]',''),'N')<>'N' and $GET_PHONE_GROUP_TYPE=1";
		//log.debug(StringUtil.removeSuffix(str, ".class"));

		//System.out.println(StringUtil.getLastStr("com.cattsoft.sp.component.domain.SoManagerDOM","."));

		//String a = "com.cattsoft.sp. \r com \n ponent.domain.SoManagerDOM";
		//System.out.println(StringUtil.filterNextLine(a));
		//System.out.println(StringUtil.subString("aa",10));
		
		//System.out.println(StringUtil.add("1", 11));
		
		System.out.println(StringUtil.catchStr(str,"\\$\\w*\\b").get(0));
		System.out.println(StringUtil.catchStr(str,"\\$\\w*\\b").get(1)); 
		System.out.println(StringUtil.catchStr(str,"\\$\\w*\\b").get(2)); 
	}

}
