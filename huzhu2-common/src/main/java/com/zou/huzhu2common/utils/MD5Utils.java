package com.zou.huzhu2common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 17:26
 * Project:  huzhu
 * Description: MD5工具
 **/
public class MD5Utils {

    /**
     * MD5加密
     * @param str 要加密的字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException
     */
    public static String encryption(String str) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        String result = "";
        try {
            md5.update(str.getBytes());
            byte[] bytes = md5.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0;offset<bytes.length;offset++){
                i = bytes[offset];
                if(i<0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

    /**
     * 对比输入的密码和加密后的密码
     * @param newpasswd 用户输入的密码
     * @param oldpasswd 数据库里加密后的密码
     * @return true | false
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return encryption(newpasswd).equals(oldpasswd);
    }

}
