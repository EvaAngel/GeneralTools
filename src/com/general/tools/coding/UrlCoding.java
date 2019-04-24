package com.general.tools.coding;

import com.general.tools.computer_principle.NumberToNumber;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlCoding {
    /**
     *
     * 本功能实现url编码
     *
     * 说明：只能实现非字母、数字的url编码，因为对于字母或数字，可以直接转化为ascii码，再转化为16进制
     * **/
    public String enUrlCoding(String str,String code)
    {
        String urlcode=null;
        try {
            urlcode=URLEncoder.encode(str,code);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlcode;
    }
    /**
     * 实现字母、数字的url编码，即进行了一个十六进制转后加入%
     * **/
    public String enUrlCoding2(String str)
    {
        StringBuilder stringBuilder=new StringBuilder();
        if(str.matches("[^0-9]*")) {
            char[] chars = str.toCharArray();
            for(char c:chars)
            {
                String s=NumberToNumber.decimalToHex(String.valueOf((int)c)).toUpperCase();
                stringBuilder.append("%").append(s);
            }
        }
        else
        {
            String s=NumberToNumber.decimalToHex(str).toUpperCase();
            stringBuilder.append("%").append(s);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(new UrlCoding().enUrlCoding("付鑫","UNICODE"));
        System.out.println(new UrlCoding().enUrlCoding("付鑫","UTF-8"));
        System.out.println(new UrlCoding().enUrlCoding2("<img src=@ onerror=alert(/xss/)>"));
        System.out.println(new UrlCoding().enUrlCoding2("123"));
    }
}
