package com.decodeencode.aes;

public class testAES {
    /**
     * AES �����ĵļӽ���
     * ����
     * 
     * */
	public static void main(String[] args) throws Exception {
		
		AesOperation aes = new AesOperation();
		String content ="�ҵĲ���һ�� ����test123";
		String password = "WJSX111";
		//����
		byte[] br = aes.encrypt_old(content, password) ;
		String jiamiRstpurl = aes.parseByte2HexStr(br);
		System.out.println( jiamiRstpurl ); 
		
		//����
		byte[] br1 = aes.parseHexStr2Byte(jiamiRstpurl);
		System.out.println(new String(aes.decrypt_old(br1, password) , "UTF-8"));

	}

}
