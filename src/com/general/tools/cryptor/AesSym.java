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
import java.util.Base64;

/**
 * AES对称加密:参考https://www.cnblogs.com/lianghui66/archive/2013/03/07/2948494.html
 * 本类仅实现了128位密钥、iv的加解密算法
 **/
public class AesSym {
    //定义密钥
    private static String key = "fuxinshigehaoren";
    //定义初始化向量参数
    private static String iv = "aabbccddeeffgghh";
    /**
     * 字符串AES加密
     **/
    public static String encrypt(String mingwen, String codekey, String key, String codeiv, String iv, String work, String full, String code) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] a, b;
        if (codekey.equals("Base64")) {
            a = Base64.getDecoder().decode(key);
        } else {
            a = key.getBytes();
        }
        //获取密钥
        Key keySpec = new SecretKeySpec(a, "AES");
        if (codeiv.equals("Base64")) {
            b = Base64.getDecoder().decode(iv);
        }
        else {
            b = iv.getBytes();
        }
        //获取初始化向量参数
        IvParameterSpec ivSpec = new IvParameterSpec(b);
        //建cipher实例
        Cipher cipher = Cipher.getInstance("AES/" + work + "/" + full);
        //初始化实例
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        //加密
        byte[] result = cipher.doFinal(mingwen.getBytes());
        System.out.println(result.length);  //这里字节为16的原因在于就是16，然后用16进制表示为32位，没错
        String miwen = null;
        if (code.equals("Base64")) {
            //输出密文字符串形式
            miwen = Base64.getEncoder().encodeToString(result);
        } else if (code.equals("HEX")) {
            //这里用二进制、十六进制转换
            miwen = parseByte2HexStr(result);
        }
        return miwen;
    }
    /**
     * 字符串AES解密,code表示加密后对字符数组使用的编码格式
     **/
    public static String decrypt(String miwen, String codekey, String key, String codeiv, String iv, String work, String full, String code) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes;
        if (code.equals("Base64")) {
            bytes = Base64.getDecoder().decode(miwen);
        } else {
            bytes = parseHexStr2Byte(miwen);
        }
        byte[] a, b;
        if (codekey.equals("Base64")) {
            a = Base64.getDecoder().decode(key);
        } else {
            a = key.getBytes();
        }
        if (codeiv.equals("Base64")) {
            b = Base64.getDecoder().decode(iv);
        }
        else {
            b = iv.getBytes();
        }
        Key keySpec = new SecretKeySpec(a, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(b);
        Cipher cipher = Cipher.getInstance("AES/" + work + "/" + full);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] result = cipher.doFinal(bytes);
        return new String(result);
    }

    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        System.out.println(encrypt("fuxin", "String", key, "String", iv, "CBC", "PKCS5Padding", "Base64"));
        System.out.println(decrypt("0C19F90FFDAED67E2629468AA9DD8529", "String", key, "String", iv, "CBC", "PKCS5Padding", "HEX"));
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
