package com.sunday.common.utils;

import com.sunday.common.logger.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.annotations.Nullable;

/**
 * 时间工具类
 */
public class DateUtils {

    /**
     * 字符串转时间,格式化:年(年的后两位)月日时分
     */
    public static Date parseLockYMDHM(String dateStr) {
        try {
            return createLockYMDHMFormat("", "", "", "").parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串转时间,格式化:年/月/日
     */
    public static @Nullable
    Date parseYMD(String dateStr) {
        try {
            return createFormatYMD("/", "/").parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 转时间:时:分
     */
    public static Date parseHM(String dateStr) {
        try {
            return createFormatHM(":").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转时间,格式化:时:分:秒
     */
    public static @Nullable
    Date parseHMS(String dateStr) {
        try {
            return createFormatHMS(":", ":").parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 格式化:年/月/日
     */
    public static String formatYMD(long date) {
        return createFormatYMD("/", "/").format(new Date(date));
    }

    /**
     * 格式化:时:分
     */
    public static String formatHM(long date) {
        return createFormatHM(":").format(new Date(date));
    }

    /**
     * 格式化:时:分:秒
     */
    public static String formatHMS(long date) {
        return createFormatHMS(":", ":").format(new Date(date));
    }

    /**
     * 创建格式化日期
     *
     * @param delimiterHM 小时和分钟的分隔符
     * @param delimiterMS 分钟和秒钟的分隔符
     */
    public static SimpleDateFormat createFormatHMS(String delimiterHM, String delimiterMS) {
        String format = "HH" + delimiterHM + "mm" + delimiterMS + "ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 创建格式化日期
     *
     * @param delimiterHM 小时和分钟的分隔符
     */
    public static SimpleDateFormat createFormatHM(String delimiterHM) {
        String format = "HH" + delimiterHM + "mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 创建格式化日期
     *
     * @param delimiterYM 年和月的分隔符
     * @param delimiterMD 月和日的分隔符
     */
    public static SimpleDateFormat createFormatYMD(String delimiterYM, String delimiterMD) {
        String format = "yyyy" + delimiterYM + "MM" + delimiterMD + "dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 创建格式化日期
     *
     * @param delimiterYM 年和月的分隔符
     * @param delimiterMD 月和日的分隔符
     * @param delimiterDH 日和时的分隔符
     * @param delimiterHM 时和分的分隔符
     * @param delimiterMS 分和秒的分隔符
     */
    public static SimpleDateFormat createYMDHMSFormat(String delimiterYM, String delimiterMD, String delimiterDH, String delimiterHM, String delimiterMS) {
        String format = "yyyy" + delimiterYM + "MM" + delimiterMD + "dd" + delimiterDH + "HH" + delimiterHM + "mm" + delimiterMS + "ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 创建格式化日期 年月日时分
     *
     * @param delimiterYM 年和月的分隔符
     * @param delimiterMD 月和日的分隔符
     * @param delimiterDH 日和时的分隔符
     * @param delimiterHM 时和分的分隔符
     */
    public static SimpleDateFormat createYMDHMFormat(String delimiterYM, String delimiterMD, String delimiterDH, String delimiterHM) {
        String format = "yyyy" + delimiterYM + "MM" + delimiterMD + "dd" + delimiterDH + "HH" + delimiterHM + "mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 格式化:年月日时分秒
     *
     * @param date 时间
     */
    public static String formatDate(long date) {
        return createYMDHMSFormat("", "", "", "", "").format(new Date(date));
    }

    /**
     * 格式化:年-月-日 时:分:秒
     *
     * @param date 时间
     */
    public static String formatLogDate(long date) {
        return createYMDHMSFormat("-", "-", " ", ":", ":").format(new Date(date));
    }

    /**
     * 转换:年-月-日 时:分:秒格式的时间
     *
     * @param dateStr 时间
     */
    public static Date parseLogDate(String dateStr) {
        SimpleDateFormat simpleDateFormat = createYMDHMSFormat("-", "-", " ", ":", ":");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化:年(后两位)月日时分秒
     *
     * @param delimiterYM 年和月的分隔符
     * @param delimiterMD 月和日的分隔符
     * @param delimiterDH 日和时的分隔符
     * @param delimiterHM 时和分的分隔符
     * @param delimiterMS 分和秒的分隔符
     */
    public static SimpleDateFormat createLockYMDHMSFormat(String delimiterYM, String delimiterMD, String delimiterDH, String delimiterHM, String delimiterMS) {
        String format = "yy" + delimiterYM + "MM" + delimiterMD + "dd" + delimiterDH + "HH" + delimiterHM + "mm" + delimiterMS + "ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }

    /**
     * 格式化:年(后两位)月日时分
     *
     * @param delimiterYM 年和月的分隔符
     * @param delimiterMD 月和日的分隔符
     * @param delimiterDH 日和时的分隔符
     * @param delimiterHM 时和分的分隔符
     */
    public static SimpleDateFormat createLockYMDHMFormat(String delimiterYM, String delimiterMD, String delimiterDH, String delimiterHM) {
        String format = "yy" + delimiterYM + "MM" + delimiterMD + "dd" + delimiterDH + "HH" + delimiterHM + "mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat;
    }
}
