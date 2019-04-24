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

import static com.general.tools.cryptor.AesSym.parseByte2HexStr;
import static com.general.tools.cryptor.AesSym.parseHexStr2Byte;

/**
 * 该类为DES加解密算法，密钥与iv均为8个字节
 * **/
public class DesSym {
    static String key="abcdefgh";
    static String iv="ABCDEFGH";
    byte [] result=null,result2=null;
    public String encrypt(String mingwen,String codekey,String key,String codeiv,String iv,String work,String full,String code)
    {
        Cipher cipher = null;
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
        Key keySpec= new SecretKeySpec(a,"DES");
        IvParameterSpec ivSpec = new IvParameterSpec(b);
        try {
            cipher = Cipher.getInstance("DES/"+work+"/"+full);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            result = cipher.doFinal(mingwen.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
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
    public String decrypt(String miwen,String codekey,String key,String codeiv,String iv,String work,String full,String code)
    {
        Cipher cipher = null;
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
        Key keySpec= new SecretKeySpec(a,"DES");
        IvParameterSpec ivSpec = new IvParameterSpec(b);
        try {
            cipher = Cipher.getInstance("DES/" + work + "/" + full);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            result2 = cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return new String(result2);
    }
    public static void main(String[] args)
    {
        String miwen=new DesSym().encrypt("fuxin","String",key,"String",iv,"CBC","PKCS5Padding","Base64");
        System.out.println(miwen);
        String mingwen=new DesSym().decrypt(miwen,"String",key,"String",iv,"CBC","PKCS5Padding","Base64");
        System.out.println(mingwen);
    }
}
