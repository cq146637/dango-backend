package com.dango.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间格式化工具类
 *
 * @author dango
 * @date 2018/9/7
 */
public class LocalDateTimeUtil {

    /**
     * 将日期时间按指定格式转换
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static String display(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(dateTime);
    }

    /**
     * 将日期时间按格式 yyyy-MM-dd HH:mm:ss 转换
     *
     * @param dateTime
     * @return
     */
    public static String display(LocalDateTime dateTime) {

        return display(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将当前日期时间按指定格式转换
     *
     * @param pattern
     * @return
     */
    public static String displayNow(String pattern) {
        return display(LocalDateTime.now(), pattern);
    }

    /**
     * 将当前日期时间按格式 yyyy-MM-dd HH:mm:ss 转换
     *
     * @return
     */
    public static String displayNow() {
        return display(LocalDateTime.now());
    }
}
