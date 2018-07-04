package com.baizhi.cmfz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtils {

	public static String encryption(String str) throws NoSuchAlgorithmException   {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] code = md.digest(str.getBytes());

		StringBuilder builder = new StringBuilder();

		for (byte b : code) {
			// 1.��ÿ���ֽ�ת�����޷�������������
			int c = b & 0xFF;
			// 0000 0000 1111 1111 255
			// 1110 0001 -31
			// 0000 0000 1110 0001 225

			if (c < 16) {
				//2.���16���µ����֣�ת��ʮ�����ƺ󣬲���2λ������׷��0��Ϊǰ׺
				builder.append("0");
			}
			
			//3.�����ֽ�ת��Ϊʮ�������ַ���������ƴ��
			builder.append(Integer.toHexString(c));
		}
		return builder.toString();
	}

	public static String encryptionCodec(String str){
//		return DigestUtils.md5Hex(str);
		return DigestUtils.sha256Hex(str);
	}

	public static String getRandomSalt(int len){
		char[] chs = "abcdefg1234567ABCDEFG".toCharArray();
		
		Random random = new Random();
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0 ; i < len ; i++){
			 builder.append(chs[random.nextInt(chs.length)]);
		}
		
		return builder.toString();
	}

}
