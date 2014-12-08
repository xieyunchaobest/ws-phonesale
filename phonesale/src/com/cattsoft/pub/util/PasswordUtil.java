package com.cattsoft.pub.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;

/**
 * Title: CRM <br>
 * Description: ���봦�����࣬��Ҫ��������ļ��ܡ��Ƚϡ������㷨����MD5 <br>
 * Date: Jul 31, 2007 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author
 */
public class PasswordUtil {
    /**
     * MD5ת����16�����ַ�����Ҫ�Ļ������ݡ�
     */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f" };

    /**
     * ���ֽ�����ת����16�����ַ�����
     * 
     * @param b
     *            byte[] �ֽ�����
     * @return String 16�����ַ���
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * ��һ���ֽ�ת����16�����ַ�����
     * 
     * @param b
     *            byte �ֽ�
     * @return String 16�����ַ���
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * ����MD5�㷨ת���ַ���
     * 
     * @param oriStr
     *            String Ҫת�����ַ���
     * @throws NoSuchAlgorithmException
     *             �����׳��Ĵ��󣬱�ʾ��֧�ָ����㷨��
     * @return String ת������ַ���
     */
    public static String getMD5Str(String oriStr) throws NoSuchAlgorithmException {
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        String tarStr = byteArrayToHexString(md.digest(oriStr.getBytes()));
        return tarStr;
    }

    /**
     * �ж��ж�Դ�ַ�������MD5���ܺ���Ŀ��MD5�����ַ����Ƿ���ȡ�
     * 
     * @param oriStr
     *            String Դ�ַ���
     * @param md5String
     *            String Ŀ��MD5�����ַ���
     * @throws NoSuchAlgorithmException
     *             �����׳��Ĵ��󣬱�ʾ��֧�ָ����㷨��
     * @return boolean �жϽ��
     */
    public static boolean isEqual(String oriStr, String md5String) throws NoSuchAlgorithmException {
        return getMD5Str(oriStr).equals(md5String);

    }

    /**
     * BASE64 ����
     * 
     * @param bs
     *            byte[]
     * @return String
     */
    public static String getBASE64(byte[] bs) {
        if (bs == null) {
            return null;
        }
        return (new sun.misc.BASE64Encoder()).encode(bs);
    }

    /**
     * �� BASE64 ������ַ��� s ���н���
     * 
     * @param s
     *            String
     * @return byte[]
     */
    public static byte[] getFromBASE64(String s) throws IOException {
        if (s == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = null;
        b = decoder.decodeBuffer(s);
        return b;
    }
}
