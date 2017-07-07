package com.decodeencode.aes;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesOperation {

	/** 
	 * 加密
	 *  
	 * @param content  含中文的内容
	 * @param password   
	 * @return 
	 */  
	public static byte[] encrypt_old(String content, String password) {
		try {             
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// ����������
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// ��ʼ��   
            byte[] result = cipher.doFinal(byteContent);
            return result; 
	    }catch(Exception e){
			e.printStackTrace();  
			return  null;
		}
	}
	 
	/**
	 * 解密 
	 *    含中文的解密
	 * @param content  
	 * @param password 
	 * @return 
	 */  
	public static byte[] decrypt_old(byte[] content, String password) {  
		try {
        	KeyGenerator kgen = KeyGenerator.getInstance("AES");  
            kgen.init(128, new SecureRandom(password.getBytes()));  
            SecretKey secretKey = kgen.generateKey();  
            byte[] enCodeFormat = secretKey.getEncoded();  
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
            Cipher cipher = Cipher.getInstance("AES");// ����������   
            cipher.init(Cipher.DECRYPT_MODE, key);// ��ʼ��   
            byte[] result = cipher.doFinal(content);  
            return result; // ����   
        }catch(Exception e){
			e.printStackTrace();  
			return  null;
		}
	}
	
	/** 
	 * 加密
	 *  
	 * @param content
	 * @param password 
	 * @return 
	 */  
	public static byte[] encrypt(String content, String password) throws Exception {
        try {
            SecretKeySpec skeySpec = getKey(password);
            final byte[] iv = new byte[16];
            Arrays.fill(iv, (byte) 0x00);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
           
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            
            byte[] clearText = content.getBytes("UTF8");
            return cipher.doFinal(clearText);
        }catch(Exception e){
			e.printStackTrace();  
			return null;
		}
    }
	
	/**
	  * 解密 
	  * 
	  * @param encryptedData  
	  * @param keyBytes  
	  * @return
	  */
	 public static byte[] decrypt(byte[] content, String password) throws Exception {
		 try {
			 SecretKeySpec skeySpec = getKey(password);
	         final byte[] iv = new byte[16];
	         Arrays.fill(iv, (byte) 0x00);
	         IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
	         
	         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	         cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
		     
		     return cipher.doFinal(content);
		 }catch (Exception e) {
			 e.printStackTrace();
			 return null;
		 }
	}
    
    private static SecretKeySpec getKey(String password) throws Exception {
        int keyLength = 128;
        byte[] keyBytes = new byte[keyLength / 8];
        Arrays.fill(keyBytes, (byte) 0x0);
        byte[] passwordBytes = password.getBytes("UTF-8");
        int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
        System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
	
	/** 
	 * @param buf 
	 * @return 
	 */  
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
        	String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {
                    hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
	}
	
	/**
	 * @param hexStr 
	 * @return 
	 */  
	public static byte[] parseHexStr2Byte(String hexStr) {  
		if (hexStr.length() < 1)  
            return null;  
	    byte[] result = new byte[hexStr.length()/2];  
	    for (int i = 0;i< hexStr.length()/2; i++) {  
	            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	            result[i] = (byte) (high * 16 + low);  
	    }  
	    return result;  
	}
	
	
	
    
	
//	public static void main(String[] args) throws Exception {
//		String str = "action=androidLogin&username=13622078641&RegistrationId=07035af2303&resource=10010&opTime=1466580364736";
//		AesOperation aes = new AesOperation();
//		byte[] br = aes.encrypt(str, "GL7SKN4E");
//		System.out.println(aes.parseByte2HexStr(br));
//		
//		String str1 = "57283176779310C86567347748851B3C4775291169B54A679ADFAB23A569A1A3474376664FE5EABAD5C0F4698E539650F2656599ABC5CE1AF614D9BD103C1417AD7562EE4A4F7E506D1F295AE604205628F06F7DACE349DD5222B6E2CDEF0BD2BDE8AC9B0BA92F634DAFA0C3D4DB402D";
//		
//		byte[] br1 = aes.parseHexStr2Byte(str1);
//		System.out.println(new String(aes.decrypt(br1, "GL7SKN4E")));
//	}
	
}
