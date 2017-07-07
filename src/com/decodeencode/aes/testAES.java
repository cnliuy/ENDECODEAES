package com.decodeencode.aes;

public class testAES {
    /**
     * AES 含中文的加解密
     * 操作
     * 
     * */
	public static void main(String[] args) throws Exception {
		
		AesOperation aes = new AesOperation();
		String content ="我的测试一下 ，，test123";
		String password = "WJSX111";
		//加密
		byte[] br = aes.encrypt_old(content, password) ;
		String jiamiRstpurl = aes.parseByte2HexStr(br);
		System.out.println( jiamiRstpurl ); 
		
		//解密
		byte[] br1 = aes.parseHexStr2Byte(jiamiRstpurl);
		System.out.println(new String(aes.decrypt_old(br1, password) , "UTF-8"));

	}

}
