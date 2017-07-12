package com.decodeencode.aes;

public class testAES {
    /**
     * AES  
     * 
     * 
     * */
	public static void main(String[] args) throws Exception {
		
		AesOperation aes = new AesOperation();
		String content ="我的测试一下，，test123我的测试一下，，test123123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123"
				+"我的测试一下，，test123我的测试一下，，test123123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一123我的测试一我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123我的测试一下，，test123";
		String password = "WJSX111";
		// 
		//byte[] br = aes.encrypt_old(content, password) ;
		//String jiamiRstpurl = aes.parseByte2HexStr(br);
		//System.out.println( jiamiRstpurl ); 
		
		// 
		//byte[] br1 = aes.parseHexStr2Byte(jiamiRstpurl);
		//System.out.println(new String(aes.decrypt_old(br1, password) , "UTF-8"));
		
		

		byte[] br = aes.encrypt(content, password) ;
		String jiamiRstpurl = aes.parseByte2HexStr(br);
		

		System.out.println( jiamiRstpurl ); 
		jiamiRstpurl ="86B3FD63FCE92571008DA721A7090DEE36408AFBEDA1413D61985BB6BB40B9EB7E3F7CABF6ED5E65BC33E4978526F67C58D14FD57F16C99D2AE8BBDB63064CC87339F544ED68E898221122F560090B1327940F22FF4385DFC8EAEDC8CE69B623E0863B4B9BC82FB43EF43ECB197FA8F5DDD078F9B9CFFBA858F5AF83959E22FFC49F8BD0792B4805A891766AAF287135D3A20644AB35D282CF0E757AEE45EB7E";
		byte[] br1 = aes.parseHexStr2Byte(jiamiRstpurl);
		System.out.println(new String(aes.decrypt(br1, password) , "UTF-8"));

	}

}
