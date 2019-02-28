package com.general.tools.cryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * AES对称加密:参考https://www.cnblogs.com/lianghui66/archive/2013/03/07/2948494.html
 **/
public class AesSym {
    //定义密钥
    private static String key = "fuxinshigehaoren";
    //定义初始化向量参数
    private static String iv = "aabbccddeeffgghh";

    /**
     * 字符串AES加密
     **/
    public static String encrypt(String mingwen) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //获取密钥
        Key keySpec = new SecretKeySpec(key.getBytes(), "AES");
        //获取初始化向量参数
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        //建cipher实例
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //初始化实例
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        //加密
        byte[] b = cipher.doFinal(mingwen.getBytes());
        //这里用二进制、十六进制转换
        String miwen=parseByte2HexStr(b);
        //输出密文字符串形式，这里用base64强制转字符串会出错。
        return miwen;
    }

    /**
     * 字符串AES解密
     **/
    public static String decrypt(String miwen) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes=parseHexStr2Byte(miwen);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        Key keySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] result = cipher.doFinal(bytes);
        return new String(result);
    }

    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        System.out.println(encrypt("fuxin"));
        System.out.println(decrypt("0C19F90FFDAED67E2629468AA9DD8529"));
    }
    //----------------------------------------------------------------------------------

    /**
     * 由于加密的密文形式为字符数组，并且这个地方要转为字符串的话会报错，所以引入二进制与十六进制之间的转化
     **/
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

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
