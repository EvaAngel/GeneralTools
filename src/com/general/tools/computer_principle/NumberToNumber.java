package com.general.tools.computer_principle;

import java.math.BigInteger;

/**
 * 本类主要实现进制到进制的转换，其中方法全部为静态方法
 * 并且都是以十进制为中心：包括十进制到二、八、十六进制；二、八、十六进制到十进制
 * **/
public class NumberToNumber {
    /**
     * 主要实现二进制到十进制的转换
     * **/
    public static String binaryToDecimal(String binary)
    {
        //int inBinary=Integer.valueOf(computer_principle_gui);
        return Integer.valueOf(binary,2).toString();
    }
    /**
     * 八进制到十进制的转换
     * **/
    public static String octalToDecimal(String Octal)
    {
        //int inBinary=Integer.valueOf(computer_principle_gui);
        return Integer.valueOf(Octal,8).toString();
    }
    /**
     * 十六进制到十进制的转换
     * **/
    public static String hexToDecimal(String Hexadecimal)
    {
        //int inBinary=Integer.valueOf(computer_principle_gui);
        return Integer.valueOf(Hexadecimal,16).toString();
    }
    //--------------------------------------------------------------------------
    /**
     * 十进制到二进制的转换
     * **/
    public static String decimalToBinary(String decimal)
    {
        int indecimal=Integer.valueOf(decimal);
        return Integer.toBinaryString(indecimal);
    }
    /**
     * 十进制到八进制的转换
     * **/
    public static String decimalToOctal(String decimal)
    {
        int indecimal=Integer.valueOf(decimal);
        return Integer.toOctalString(indecimal);
    }
    /**
     * 十进制到十六进制的转换
     * **/
    public static String decimalToHex(String decimal)
    {
        int indecimal=Integer.valueOf(decimal);
        return Integer.toHexString(indecimal);
    }
    //-------------------------------------------------------------------
    /**
     * 实现二进制到八进制的转换
     * **/
    public static String binaryToOctal(String binary)
    {
        return Integer.toOctalString(Integer.parseInt(binary, 2));
    }
    /**
     * 实现二进制到十六进制的转换
     * **/
    public static String binaryToHex(String binary)
    {
        return  Integer.toHexString(Integer.parseInt(binary, 2));
    }
    /**
     * 实现八进制到二进制的转换
     * **/
    public static String octalToBinary(String octal)
    {
        return Integer.toBinaryString(Integer.valueOf(octal,8));
    }
    /**
     * 实现十六进制到二进制的转换
     * **/
    public static String hexToBinary(String hex)
    {
        return Integer.toBinaryString(Integer.valueOf(hex,16));
    }
    //--------------------------------------------------------------------------
    /**
     * 实现八进制到十六进制的转换
     * **/
    public static String octalToHex(String octal)
    {
        BigInteger bigOctal = new BigInteger(octal,8);
        return bigOctal.toString(16);
    }
    /**
     * 实现十六进制到八进制的转换
     * **/
    public static String hexlToOctal(String hex)
    {
        BigInteger bigOctal = new BigInteger(hex,16);
        return bigOctal.toString(8);
    }
}

