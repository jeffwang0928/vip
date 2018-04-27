package com.jd.common;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 系统工具类
 */
public class ThisSystemUtil {

    public static  String  md5(String inputStr) {
        System.out.println("=======加密前的数据:"+inputStr);
        BigInteger bigInteger=null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
            bigInteger = bigInteger.abs();
        } catch (Exception e) {e.printStackTrace();}
        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static void main(String[] args){
        System.out.println(md5("1"));
    }
}
