package com.general.tools.computer_principle;

import java.net.InetAddress;

/**
 *
 * 本类实现十进制整数原码、反码、补码的计算
 * 为什么会出现这些东西？原因在于补码在加减乘除计算时会节约大量步骤，增加效率
 * **/
public class OriginalCode {
    public static String DecimalToInversecode(String decimal)
    {
        //首先判断整数正负，其次转化为二进制分别取值
        byte original=Byte.valueOf(decimal);
        String binary=NumberToNumber.decimalToBinary(String.valueOf(original));
        System.out.println(binary);
        if(Math.abs(original)==original)
        {
            return binary;
        }
        else
        {
            return new StringBuilder(binary).replace(0,1,"1").toString();
        }
    }

}
