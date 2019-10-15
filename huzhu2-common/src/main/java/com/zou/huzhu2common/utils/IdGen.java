package com.zou.huzhu2common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 17:37
 * Project:  huzhu
 * Description:Id生成器
 **/
public class IdGen {

    /**
     * 获取制定位数十进制随机数
     * @return
     */
    public static String getRandom(int length) {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 获取一个UUID
     * @return
     */
    public static String UUID() {
        String uuid = UUID.randomUUID().toString();    //转化为String对象
        //uuid = uuid.replace("-", "");  //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return uuid;
    }
}
