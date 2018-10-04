package com.sunday.common.widgets.wheel.helper;

import android.app.Activity;

import com.sunday.common.widgets.wheel.pickview.CharacterPickerView;
import com.sunday.common.widgets.wheel.pickview.CharacterPickerWindow;
import com.sunday.common.widgets.wheel.pickview.OnOptionChangedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siwei on 2018/4/1.
 */

public class TimeOptionHelper {

    private List<String> options1Items = null;
    private List<List<String>> options2Items = null;
    private List<List<List<String>>> options3Items = null;

    private Map<String, List<String>> mMapDatas = new HashMap<>();

    private int yearLength = 20;//年的长度
    private int currentYear, currentMonth, currentDay;//当前的年月日
    private Map<String, Map<String, List<String>>> mYMDData;//年月日数据
    private Map<String, Map<String, List<String>>> mHMSData;//时分秒数据
    private Calendar lastYMDCalendar;//上次的年月日日历

    public TimeOptionHelper() {
    }

    public interface OnDataSelectedListener {

        void onDataSelected(int year, int month, int day);
    }

    /**build年月选择器*/
    public CharacterPickerWindow builderYM(Activity activity, final OnDataSelectedListener listener) {
        //选项选择器
        CharacterPickerWindow mOptions = new CharacterPickerWindow(activity);
        //初始化选项数据
        setYMDataPicture(mOptions.getPickerView());
        //设置默认选中的三级项目
        mOptions.setCurrentPositions(0, 0, 0);
        //监听确定选择按钮
        mOptions.setOnoptionsSelectListener(new OnOptionChangedListener() {
            @Override
            public void onOptionChanged(int option1, int option2, int option3) {
                if (listener != null) {
                    int year = currentYear + option1;
                    int month = (option1 == 0 ? currentMonth + option2 : option2) + 1;
                    int day = (option1 == 0 && option2 == 0 ? currentDay +option2: option2);
                    listener.onDataSelected(year, month, day);
                }
            }
        });
        return mOptions;
    }

    /**build年月日选择器*/
    public CharacterPickerWindow builderYMD(Activity activity, final OnDataSelectedListener listener) {
        //选项选择器
        CharacterPickerWindow mOptions = new CharacterPickerWindow(activity);
        //初始化选项数据
        setYMDDataPicture(mOptions.getPickerView());
        //设置默认选中的三级项目
        mOptions.setCurrentPositions(0, 0, 0);
        //监听确定选择按钮
        mOptions.setOnoptionsSelectListener(new OnOptionChangedListener() {
            @Override
            public void onOptionChanged(int option1, int option2, int option3) {
                if (listener != null) {
                    int year = currentYear + option1;
                    int month = (option1 == 0 ? currentMonth + option2 : option2) + 1;
                    listener.onDataSelected(year, month, 0);
                }
            }
        });
        return mOptions;
    }

    //初始化年月日数据
    private void initYMDData() {
        if(options1Items == null || !isSameDay(lastYMDCalendar)){
            //数据未初始化或者当前年月日发生改变
            if (options1Items == null) {
                options1Items = new ArrayList<>();
                options2Items = new ArrayList<>();
                options3Items = new ArrayList<>();
            }
            options1Items.clear();
            options2Items.clear();
            options3Items.clear();
            Map<String, Map<String, List<String>>> mapYMDatas = getYMData();
            for (Map.Entry<String, Map<String, List<String>>> entry1 : mapYMDatas.entrySet()) {
                String key1 = entry1.getKey();
                Map<String, List<String>> value1 = entry1.getValue();
                options1Items.add(key1);
                List<String> monthList = new ArrayList<>();
                List<List<String>> dayList = new ArrayList<>();
                for (Map.Entry<String, List<String>> entry2 : value1.entrySet()) {
                    monthList.add(entry2.getKey());
                    dayList.add(entry2.getValue());
                }
                options2Items.add(monthList);
                options3Items.add(dayList);
            }
        }
    }

    public void setYMDDataPicture(CharacterPickerView view) {
        initYMDData();
        view.setPicker(options1Items, options2Items, options3Items);
    }

    public void setYMDataPicture(CharacterPickerView view) {
        initYMDData();
        view.setPicker(options1Items, options2Items);
    }

    /**
     * 获取年月的数据
     */
    public Map<String, Map<String, List<String>>> getYMData() {
        if (mYMDData != null && isSameDay(lastYMDCalendar)) {
            //现在的时间和上次记录的是同一天,则年月日数据不需要刷新
            return mYMDData;
        } else {
            //年月日数据未初始化,或者当前年月日时间改变,重新初始化年月日数据
            lastYMDCalendar = Calendar.getInstance();
            Calendar calendar = Calendar.getInstance();
            currentYear = calendar.get(Calendar.YEAR);
            currentMonth = calendar.get(Calendar.MONTH);
            currentDay = calendar.get(Calendar.DAY_OF_MONTH);
            Map<String, Map<String, List<String>>> ymdData = new LinkedHashMap<>();
            for (int year = currentYear; year < (currentYear + yearLength); year++) {
                Map<String, List<String>> monthList = new HashMap<>();
                for (int month = (year == currentYear ? currentMonth : 0); month < 12; month++) {
                    List<String> dayList = new ArrayList<>();
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    //获取该月的最大天数
                    int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                    for (int day = ((year == currentYear && month == currentMonth) ? currentDay : 0); day < monthDays; day++) {
                        dayList.add(getDayStr(day));
                    }
                    monthList.put(getMonthStr(month), dayList);
                }
                ymdData.put(getYearStr(year), monthList);
            }
            return ymdData;
        }
    }

    //判断当前时候为同一天
    private boolean isSameDay(Calendar lastYMDCalendar) {
        if (lastYMDCalendar == null) return false;
        Calendar currentCalendar = Calendar.getInstance();
        boolean isSame = lastYMDCalendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR);
        isSame = isSame && (lastYMDCalendar.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH));
        isSame = isSame && (lastYMDCalendar.get(Calendar.DAY_OF_MONTH) == currentCalendar.get(Calendar.DAY_OF_MONTH));
        return isSame;
    }

    public String getYearStr(int year) {
        return year + "年   ";
    }

    public String getMonthStr(int month) {
        return (month < 9 ? "0" : "") + (month + 1) + " 月  ";
    }

    public String getDayStr(int day) {
        return (day < 10 ? "0" : "") + (day) + "日";
    }

}
