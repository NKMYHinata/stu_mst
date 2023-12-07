package com.wdd.studentmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具
 *
 * @Classname DateFormatUtil
 * @Description 日期格式化工具类
 * @Date 2019/7/2 13:22
 * @Created by WDD
 */
public class DateFormatUtil {

    /**
     * 将日期对象格式化为指定格式的字符串
     *
     * @param date 要格式化的日期对象
     * @param format 指定的日期格式，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的日期字符串
     */
    public static String getFormatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date); // 格式化给定的日期
    }
}
