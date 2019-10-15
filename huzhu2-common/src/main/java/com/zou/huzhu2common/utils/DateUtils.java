package com.zou.huzhu2common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 17:36
 * Project:  huzhu
 * Description:
 **/
public class DateUtils {

    public static final String ymdhms = "yyyy-MM-dd HH:mm:ss";
    public static final String ymdhms_cns = "yyyy年MM月dd日 HH时mm分ss秒";

    public static final String ymd = "yyyy-MM-dd";
    public static final String ymd_1 = "yyyyMMdd";

    public static final String mdy = "MMM dd yyyy ";

    // 获取当前时间
    public static LocalDateTime getNow(){
        return LocalDateTime.now().withNano(0);
    }

    // 获取当前时间指定格式
    public static String getNow(String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime today = LocalDateTime.now().withNano(0);
        return today.format(formatter);
    }

    // 获取当前时间指定格式日期
    public static String getNowDate(String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate today = LocalDate.now();
        return today.format(formatter);
    }

    // 获取当前时间指格式时间
    public static String getNowTime(String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalTime now = LocalTime.now().withNano(0);
        return now.format(formatter);
    }

    /**
     * 获取指定实践对象的指定格式
     * @param dateTime
     * @param format
     * @return
     */
    public static String getSpecificDateTimeString(LocalDateTime dateTime, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    /**
     * 获取当前时间的指定部分 年月日（当月，当年）时分秒
     * year month dayOfMonth datOfYear hour min second
     * @param type
     * @return
     */
    public static int getNowValue(String type){
        LocalDateTime today = LocalDateTime.now();
        if (type.equals("year"))
            return today.getYear();
        if (type.equals("month"))
            return today.getMonthValue();
        if (type.equals("dayOfMonth"))
            return today.getDayOfMonth();
        if (type.equals("datOfYear"))
            return today.getDayOfYear();
        if (type.equals("hour"))
            return today.getHour();
        if (type.equals("min"))
            return today.getMinute();
        if (type.equals("second"))
            return today.getSecond();
        return 0;
    }

    /**
     * 根据传入的值返回相应的时间，请注意，非反人类，没有就是0
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param min
     * @param second
     * @return
     */
    public static LocalDateTime takeSpecificDateTime(int year, int month, int day, int hour, int min, int second){
        return LocalDateTime.of(year, month, day, hour, min, second);
    }

    /**
     * 比较指定时间与当前 -1 比当前时间小 0 与当前一致 1 比当前时间大
     * @param e1
     * @return
     */
    public static int equalsDateTime(LocalDateTime e1){
        LocalDateTime today = LocalDateTime.now().withNano(0);
        if (today.isAfter(e1)){
            return -1;
        }else if (today.isEqual(e1)){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * 比较指定日期与当前 -1 比当前时间小 0 与当前一致 1 比当前时间大
     * @param e1
     * @return
     */
    public static int equalsDate(LocalDate e1){
        LocalDate today = LocalDate.now();
        if (today.isAfter(e1)){
            return -1;
        }else if (today.isEqual(e1)){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * 比较指定ime与当前 -1 比当前时间小 0 与当前一致 1 比当前时间大
     * @param e1
     * @return
     */
    public static int equalsTime(LocalTime e1){
        LocalTime today = LocalTime.now().withNano(0);
        if (today.isAfter(e1)){
            return -1;
        }else if (today.equals(e1)){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * @Description 将"yyyy-MM-dd HH:mm:ss"格式的字符串转成LocalDateTime对象
     * @Date 18:52 2019/1/23
     * @Param [dateTime]
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime stringToDateTime(String dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(dateTime,df);
        return ldt;
    }

    /**
     * @Description 将LocalDateTime对象转成"yyyy-MM-dd HH:mm:ss"格式的字符串
     * @Date 18:54 2019/1/23
     * @Param [dateTime]
     * @return java.lang.String
     **/
    public static String dateTimeToString(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(dateTime);
        return localTime;
    }

    /**
     * @Description 指定时间加上指定秒
     * @Date 19:01 2019/1/23
     * @Param [dateTime, seconds]
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime addSeconds(LocalDateTime dateTime, int seconds){
        return dateTime.plusSeconds(seconds);
    }

    /**
     * @Description 指定时间加上指定秒
     * @Date 19:01 2019/1/23
     * @Param [dateTime, seconds]
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime addSecondsNow(int seconds){
        LocalDateTime dateTime = getNow();
        return dateTime.plusSeconds(seconds);
    }
}
