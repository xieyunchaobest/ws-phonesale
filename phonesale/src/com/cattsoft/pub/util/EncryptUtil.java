package com.cattsoft.pub.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.axis.encoding.Base64;

import com.cattsoft.pub.exception.SysException;


/**
 * ���ܹ�����,
 * @author xieyunchao
 *
 */
public class EncryptUtil {
	
	//3DES��Կ
	static String secretKey ="1!QAZ2@WSXCDE#3$4RFVBGT%5^6YHNMJU7&8*IK<.LO9(0P";
	//����
	private final static String iv = "12481632";

	private final static String encoding = "utf-8";  

	/**
	 * ����3DES����
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptThreeDESECB(String plainText) throws Exception  
	{  
		Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);  
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));  
        return Base64.encode(encryptData);  
	      
	}  
	  
	/**
	 * 3DES����
	 * @param src
	 * @return
	 * @throws SysException 
	 * @throws Exception
	 */
	public static String decryptThreeDESECB(String encryptText) throws SysException  
 {
		String res = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory
					.getInstance("desede");
			Key deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
			byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
			res = new String(decryptData, encoding);
		} catch (Exception e) {
			throw new SysException("11111", "���ܹ��̳��ִ���", e);
		}

		return res;
	}  
}
