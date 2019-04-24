package com.general.tools.cryptor;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;


public class CopySha1 {
    public static boolean validatePassword(String plainPassword, String password) {
        byte[] salt = decodeHex(password.substring(0, 16));
        byte[] hashPassword = sha1(plainPassword.getBytes(), salt, 1024);
        System.out.println(encodeHex(salt)+encodeHex(hashPassword));
        return password.equals(encodeHex(salt) + encodeHex(hashPassword));
    }

    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw unchecked(e);
        }
    }
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, "SHA-1", salt, iterations);
    }

    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for (int i = 1; i < iterations; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            throw unchecked(e);
        }
    }

        public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }
    public static void main(String[] args)
    {
        boolean b= CopySha1.validatePassword("admin","d6a33a2456338a88acec133487d38ccf163abb4575b368b074e327ee");
        System.out.println(b);
        try {
            System.out.println(Hex.decodeHex("d6a33a2456338a88".toCharArray()));
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }
}
