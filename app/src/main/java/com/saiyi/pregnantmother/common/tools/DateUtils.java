package com.saiyi.pregnantmother.common.tools;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.PMApplication;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {


    /**
     * 输出  yyyy年MM月
     *
     * @param date
     * @return
     */
    public static String formatYM(long date) {
        String[] ymd = com.sunday.common.utils.DateUtils.formatYMD(date).split("/");
        return ymd[0] + PMApplication.getContext().getResources().getString(R.string.year) + ymd[1] + PMApplication.getContext().getResources().getString(R.string.month);
    }

    /**
     * 将string转为日期的long类型
     *
     * @param date 2017-12-12
     * @return
     */
    public static long stringDateTolong(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        return d.getTime();
    }

    public static List<Date> laterSevenDays(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        List<Date> dates = new ArrayList<Date>();
        for (int i = 1; i < 8; i++) {
            calendar.add(Calendar.DATE, i);
            dates.add(calendar.getTime());
            calendar.setTime(date1);
        }
        return dates;
    }

    public static final int SEVEN_DAYS_LATER = 1;
    public static final int SEVEN_DAYS_BEFORE = 2;

    /**
     * 输出该日期前后7天，date指定日期，type，前七天还是后七天。(不包含date天)
     * @param date
     * @param type
     * @return
     */
    public static String[] getSevenDays(long date, int type){
        List<Date> list;
        if(type == SEVEN_DAYS_LATER){
            list = laterSevenDays(date);
        }else{
            list = beforeSevenDays(date);
        }

        String[] dates = new String[list.size()];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<dates.length;i++){
            Date d = list.get(i);
            String s = sdf.format(d);
            dates[i] = s;
        }
        return dates;
    }

    public static List<Date> beforeSevenDays(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        List<Date> dates = new ArrayList<Date>();
        for (int i = -7; i < 0; i++) {
            calendar.add(Calendar.DATE, i);
            dates.add(calendar.getTime());
            calendar.setTime(date1);
        }
        return dates;
    }

}
