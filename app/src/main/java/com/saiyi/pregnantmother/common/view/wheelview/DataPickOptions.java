package com.saiyi.pregnantmother.common.view.wheelview;

import java.util.Calendar;
import java.util.List;

/**
 * Created on 2018/4/25.
 */

public class DataPickOptions {

    //常量
    private static final int PICKER_VIEW_BG_COLOR_DEFAULT = 0xFFFFFFFF;
    public int SHOW_PICKER_TYPE = 1;
    public static final int TYPE_PICKER_DEFULT = 1;
    public static final int TYPE_PICKER_TIME = 2;


    public OnDataSelectListener dataSelectListener;

    public OnDataSelectChangeListener dataSelectChangeListener;


    //time picker
    public boolean[] isVisiables = new boolean[]{true, true, true, false, false, false};//是否显示，默认显示
    public String[] visiableText = new String[]{"","","","","","",""};
    public int[] selectIndexs = null;
    public List<List<String>> dataLists;

    public String bgColor = "#FFFFFF";

    public Calendar date;//当前选中时间
    public Calendar startDate;//开始时间
    public Calendar endDate;//终止时间
}
