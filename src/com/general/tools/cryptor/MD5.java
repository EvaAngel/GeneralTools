package com.general.tools.cryptor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 本类主要实现md5加解密
 **/
public class MD5 {

    public static String md5(String mingwen) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(mingwen.getBytes());
            byte[] hash = messageDigest.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    stringBuilder.append("0" + Integer.toHexString(0xFF & hash[i]));
                } else {
                    stringBuilder.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String str = "admin";
        /*char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(chars[i] + " " + bytes[i]);
            System.out.println();
        }*/
        System.out.println(md5(str));
    }
}
