package com.saiyi.pregnantmother.common.view.wheelview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.saiyi.pregnantmother.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created on 2018/4/25.
 */

public class DataPickView {

    private WheelView mWheelViewItem1;
    private WheelView mWheelViewItem2;
    private WheelView mWheelViewItem3;
    private WheelView mWheelViewItem4;
    private WheelView mWheelViewItem5;
    private WheelView mWheelViewItem6;

    private DataPickOptions mPickerOptions;
    private List<WheelView> listWheels = new ArrayList<>();


    private int DEFAULT_START_YEAR = 1900;
    private int DEFAULT_END_YEAR = 2100;
    private int DEFAULT_START_MONTH = 1;
    private int DEFAULT_END_MONTH = 12;
    private int DEFAULT_START_DAY = 1;
    private int DEFAULT_END_DAY = 31;

    private int startYear = DEFAULT_START_YEAR;
    private int endYear = DEFAULT_END_YEAR;
    private int startMonth = DEFAULT_START_MONTH;
    private int endMonth = DEFAULT_END_MONTH;
    private int startDay = DEFAULT_START_DAY;
    private int endDay = DEFAULT_END_DAY; //表示31天的
    private int currentYear;

    private boolean mPickTypes[] = null;

    public DataPickView(Context context, DataPickOptions mPickerOptions, int showType) {
        this.mPickerOptions = mPickerOptions;
        mPickTypes = mPickerOptions.isVisiables;
        showType = mPickerOptions.SHOW_PICKER_TYPE;

        View v = LayoutInflater.from(context).inflate(R.layout.pickerview_data, (ViewGroup) ((Activity) context).getWindow().getDecorView());

        // 时间转轮 自定义控件
        LinearLayout timePickerView = (LinearLayout) v.findViewById(R.id.timepicker);
        timePickerView.setBackgroundColor(Color.parseColor(mPickerOptions.bgColor));
        View bottom_view = (View) v.findViewById(R.id.bottom_view);
        bottom_view.setBackgroundColor(Color.parseColor(mPickerOptions.bgColor));
        initWheelViews(v);
        if (showType == DataPickOptions.TYPE_PICKER_DEFULT)
            initWheelViewsAdapter(mPickerOptions.visiableText, mPickerOptions.isVisiables, mPickerOptions.dataLists);
        else {

            initTimeAdapter(mPickerOptions.date);
        }
    }

    private void initWheelViews(View view) {

        mWheelViewItem1 = (WheelView) view.findViewById(R.id.year);
        mWheelViewItem2 = (WheelView) view.findViewById(R.id.month);
        mWheelViewItem3 = (WheelView) view.findViewById(R.id.day);
        mWheelViewItem4 = (WheelView) view.findViewById(R.id.hour);
        mWheelViewItem5 = (WheelView) view.findViewById(R.id.min);
        mWheelViewItem6 = (WheelView) view.findViewById(R.id.second);
        listWheels.add(mWheelViewItem1);
        listWheels.add(mWheelViewItem2);
        listWheels.add(mWheelViewItem3);
        listWheels.add(mWheelViewItem4);
        listWheels.add(mWheelViewItem5);
        listWheels.add(mWheelViewItem6);
    }

    private void initWheelViewsAdapter(String[] texts, boolean[] type, List<List<String>> dataLists) {

        for (int i = 0; i < listWheels.size(); i++) {
            if (i < dataLists.size() && dataLists.get(i) != null) {
                listWheels.get(i).setAdapter(new ArrayWheelAdapter(dataLists.get(i)));// 设置数据显示
                //listWheels.get(i).setCurrentItem(mPickerOptions.selectIndexs[i]);

            }
            if (i < texts.length)
                listWheels.get(i).setLabel(texts[i]);// 添加文字
            listWheels.get(i).setCurrentItem(i);// 初始化时显示的数据
            if (i < type.length)
                listWheels.get(i).setVisibility(type[i] ? View.VISIBLE : View.GONE);
            listWheels.get(i).isCenterLabel(true);
            listWheels.get(i).setTextSize(16);
            listWheels.get(i).setCyclic(false);
        }

        for (int i = 0; i < listWheels.size(); i++) {
            if (i < dataLists.size() && dataLists.get(i) != null) {
                listWheels.get(i).setCurrentItem(mPickerOptions.selectIndexs[i]);

            }
        }


//        if (mPickerOptions.dataSelectListener != null) {
//                mPickerOptions.dataSelectListener.onDataSelectIndex(
//                        mWheelViewItem1.getCurrentItem(), mWheelViewItem2.getCurrentItem(),
//                        mWheelViewItem3.getCurrentItem(),mWheelViewItem4.getCurrentItem(),
//                        mWheelViewItem5.getCurrentItem(),mWheelViewItem6.getCurrentItem(), null);
//            }
//        List<String> lists = new ArrayList<>();
//        for (int i=0;i<50;i++){
//            lists.add(""+i);
//        }
//
//
//        // 第一个
//        mWheelViewItem1 = (WheelView) view.findViewById(R.id.year);
//        mWheelViewItem1.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem1.setLabel("");// 添加文字
//        mWheelViewItem1.setCurrentItem(1);// 初始化时显示的数据
//
//        // 第二个
//        mWheelViewItem2 = (WheelView) view.findViewById(R.id.month);
//        mWheelViewItem2.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem2.setLabel("");// 添加文字
//        mWheelViewItem2.setCurrentItem(2);// 初始化时显示的数据
//
//
//        // 第三个
//        mWheelViewItem3 = (WheelView) view.findViewById(R.id.day);
//        mWheelViewItem3.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem3.setLabel("");// 添加文字
//        mWheelViewItem3.setCurrentItem(3);// 初始化时显示的数据
//
//
//        // 第四个
//        mWheelViewItem4 = (WheelView) view.findViewById(R.id.hour);
//        mWheelViewItem4.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem4.setLabel("");// 添加文字
//        mWheelViewItem4.setCurrentItem(4);// 初始化时显示的数据
//
//
//        // 第五个
//        mWheelViewItem5 = (WheelView) view.findViewById(R.id.min);
//        mWheelViewItem5.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem5.setLabel("");// 添加文字
//        mWheelViewItem5.setCurrentItem(5);// 初始化时显示的数据
//
//        // 第六个
//        mWheelViewItem6 = (WheelView) view.findViewById(R.id.second);
//        mWheelViewItem6.setAdapter(new ArrayWheelAdapter(lists));// 设置数据显示
//        mWheelViewItem6.setLabel("");// 添加文字
//        mWheelViewItem6.setCurrentItem(6);// 初始化时显示的数据


    }

    private void setSelectData() {
    }

    private void initTimeAdapter(Calendar calendar) {
        int year = 0, month = 0, day = 0, h = 0, m = 0, s = 0;
        if (calendar != null) {
            //calendar.setTimeInMillis(System.currentTimeMillis());
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            h = calendar.get(Calendar.HOUR_OF_DAY);
            m = calendar.get(Calendar.MINUTE);
            s = calendar.get(Calendar.SECOND);
        }
        // 添加大小月月份并将其转换为list,方便之后的判断
        String[] months_big = {"1", "3", "5", "7", "8", "10", "12"};
        String[] months_little = {"4", "6", "9", "11"};

        final List<String> list_big = Arrays.asList(months_big);
        final List<String> list_little = Arrays.asList(months_little);

        int gravity = Gravity.CENTER;
        currentYear = year;
        // 年

        mWheelViewItem1.setAdapter(new NumericWheelAdapter(startYear, endYear));// 设置"年"的显示数据


        mWheelViewItem1.setCurrentItem(year - startYear);// 初始化时显示的数据
        mWheelViewItem1.setGravity(gravity);
        // 月
        if (startYear == endYear) {//开始年等于终止年
            mWheelViewItem2.setAdapter(new NumericWheelAdapter(startMonth, endMonth));
            mWheelViewItem2.setCurrentItem(month + 1 - startMonth);
        } else if (year == startYear) {
            //起始日期的月份控制
            mWheelViewItem2.setAdapter(new NumericWheelAdapter(startMonth, 12));
            mWheelViewItem2.setCurrentItem(month + 1 - startMonth);
        } else if (year == endYear) {
            //终止日期的月份控制
            mWheelViewItem2.setAdapter(new NumericWheelAdapter(1, endMonth));
            mWheelViewItem2.setCurrentItem(month);
        } else {
            mWheelViewItem2.setAdapter(new NumericWheelAdapter(1, 12));
            mWheelViewItem2.setCurrentItem(month);
        }
        mWheelViewItem2.setGravity(gravity);
        // 日

        if (startYear == endYear && startMonth == endMonth) {
            if (list_big.contains(String.valueOf(month + 1))) {
                if (endDay > 31) {
                    endDay = 31;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, endDay));
            } else if (list_little.contains(String.valueOf(month + 1))) {
                if (endDay > 30) {
                    endDay = 30;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, endDay));
            } else {
                // 闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (endDay > 29) {
                        endDay = 29;
                    }
                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, endDay));
                } else {
                    if (endDay > 28) {
                        endDay = 28;
                    }
                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, endDay));
                }
            }
            mWheelViewItem3.setCurrentItem(day - startDay);
        } else if (year == startYear && month + 1 == startMonth) {
            // 起始日期的天数控制
            if (list_big.contains(String.valueOf(month + 1))) {

                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, 31));
            } else if (list_little.contains(String.valueOf(month + 1))) {

                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, 30));
            } else {
                // 闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, 29));
                } else {

                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(startDay, 28));
                }
            }
            mWheelViewItem3.setCurrentItem(day - startDay);
        } else if (year == endYear && month + 1 == endMonth) {
            // 终止日期的天数控制
            if (list_big.contains(String.valueOf(month + 1))) {
                if (endDay > 31) {
                    endDay = 31;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, endDay));
            } else if (list_little.contains(String.valueOf(month + 1))) {
                if (endDay > 30) {
                    endDay = 30;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, endDay));
            } else {
                // 闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (endDay > 29) {
                        endDay = 29;
                    }
                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, endDay));
                } else {
                    if (endDay > 28) {
                        endDay = 28;
                    }
                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, endDay));
                }
            }
            mWheelViewItem3.setCurrentItem(day - 1);
        } else {
            // 判断大小月及是否闰年,用来确定"日"的数据
            if (list_big.contains(String.valueOf(month + 1))) {

                mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (list_little.contains(String.valueOf(month + 1))) {

                mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, 30));
            } else {
                // 闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, 29));
                } else {

                    mWheelViewItem3.setAdapter(new NumericWheelAdapter(1, 28));
                }
            }
            mWheelViewItem3.setCurrentItem(day - 1);
        }

        mWheelViewItem3.setGravity(gravity);
        mWheelViewItem4.setAdapter(new NumericWheelAdapter(0, 23));

        mWheelViewItem4.setCurrentItem(h);
        mWheelViewItem4.setGravity(gravity);

        mWheelViewItem5.setAdapter(new NumericWheelAdapter(0, 59));

        mWheelViewItem5.setCurrentItem(m);
        mWheelViewItem5.setGravity(gravity);

        mWheelViewItem6.setAdapter(new NumericWheelAdapter(0, 59));
        mWheelViewItem6.setCurrentItem(s);
        mWheelViewItem6.setGravity(gravity);

        // 添加"年"监听
        mWheelViewItem1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int year_num = index + startYear;
                currentYear = year_num;
                int currentMonthItem = mWheelViewItem2.getCurrentItem();//记录上一次的item位置
                // 判断大小月及是否闰年,用来确定"日"的数据
                if (startYear == endYear) {
                    //重新设置月份
                    mWheelViewItem2.setAdapter(new NumericWheelAdapter(startMonth, endMonth));

                    if (currentMonthItem > mWheelViewItem2.getAdapter().getItemsCount() - 1) {
                        currentMonthItem = mWheelViewItem2.getAdapter().getItemsCount() - 1;
                        mWheelViewItem2.setCurrentItem(currentMonthItem);
                    }

                    int monthNum = currentMonthItem + startMonth;

                    if (startMonth == endMonth) {
                        //重新设置日
                        setReDay(year_num, monthNum, startDay, endDay, list_big, list_little);
                    } else if (monthNum == startMonth) {
                        //重新设置日
                        setReDay(year_num, monthNum, startDay, 31, list_big, list_little);
                    } else if (monthNum == endMonth) {
                        setReDay(year_num, monthNum, 1, endDay, list_big, list_little);
                    } else {//重新设置日
                        setReDay(year_num, monthNum, 1, 31, list_big, list_little);
                    }
                } else if (year_num == startYear) {//等于开始的年
                    //重新设置月份
                    mWheelViewItem2.setAdapter(new NumericWheelAdapter(startMonth, 12));

                    if (currentMonthItem > mWheelViewItem2.getAdapter().getItemsCount() - 1) {
                        currentMonthItem = mWheelViewItem2.getAdapter().getItemsCount() - 1;
                        mWheelViewItem2.setCurrentItem(currentMonthItem);
                    }

                    int month = currentMonthItem + startMonth;
                    if (month == startMonth) {
                        //重新设置日
                        setReDay(year_num, month, startDay, 31, list_big, list_little);
                    } else {
                        //重新设置日
                        setReDay(year_num, month, 1, 31, list_big, list_little);
                    }

                } else if (year_num == endYear) {
                    //重新设置月份
                    mWheelViewItem2.setAdapter(new NumericWheelAdapter(1, endMonth));
                    if (currentMonthItem > mWheelViewItem2.getAdapter().getItemsCount() - 1) {
                        currentMonthItem = mWheelViewItem2.getAdapter().getItemsCount() - 1;
                        mWheelViewItem2.setCurrentItem(currentMonthItem);
                    }
                    int monthNum = currentMonthItem + 1;

                    if (monthNum == endMonth) {
                        //重新设置日
                        setReDay(year_num, monthNum, 1, endDay, list_big, list_little);
                    } else {
                        //重新设置日
                        setReDay(year_num, monthNum, 1, 31, list_big, list_little);
                    }

                } else {
                    //重新设置月份
                    mWheelViewItem2.setAdapter(new NumericWheelAdapter(1, 12));
                    //重新设置日
                    setReDay(year_num, mWheelViewItem2.getCurrentItem() + 1, 1, 31, list_big, list_little);
                }

            }
        });


        // 添加"月"监听
        mWheelViewItem2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int month_num = index + 1;

                if (startYear == endYear) {
                    month_num = month_num + startMonth - 1;
                    if (startMonth == endMonth) {
                        //重新设置日
                        setReDay(currentYear, month_num, startDay, endDay, list_big, list_little);
                    } else if (startMonth == month_num) {

                        //重新设置日
                        setReDay(currentYear, month_num, startDay, 31, list_big, list_little);
                    } else if (endMonth == month_num) {
                        setReDay(currentYear, month_num, 1, endDay, list_big, list_little);
                    } else {
                        setReDay(currentYear, month_num, 1, 31, list_big, list_little);
                    }
                } else if (currentYear == startYear) {
                    month_num = month_num + startMonth - 1;
                    if (month_num == startMonth) {
                        //重新设置日
                        setReDay(currentYear, month_num, startDay, 31, list_big, list_little);
                    } else {
                        //重新设置日
                        setReDay(currentYear, month_num, 1, 31, list_big, list_little);
                    }

                } else if (currentYear == endYear) {
                    if (month_num == endMonth) {
                        //重新设置日
                        setReDay(currentYear, mWheelViewItem2.getCurrentItem() + 1, 1, endDay, list_big, list_little);
                    } else {
                        setReDay(currentYear, mWheelViewItem2.getCurrentItem() + 1, 1, 31, list_big, list_little);
                    }

                } else {
                    //重新设置日
                    setReDay(currentYear, month_num, 1, 31, list_big, list_little);
                }

            }
        });

        for (int i = 0; i < mPickTypes.length; i++) {
            listWheels.get(i).setVisibility(mPickTypes[i] ? View.VISIBLE : View.GONE);

            if (i < mPickerOptions.visiableText.length)
                listWheels.get(i).setLabel(mPickerOptions.visiableText[i]);// 添加文字
            listWheels.get(i).isCenterLabel(true);
            listWheels.get(i).setTextSize(16);
        }

    }


    private void setReDay(int year_num, int monthNum, int startD, int endD, List<String> list_big, List<String> list_little) {
        int currentItem = mWheelViewItem3.getCurrentItem();

//        int maxItem;
        if (list_big.contains(String.valueOf(monthNum))) {
            if (endD > 31) {
                endD = 31;
            }
            mWheelViewItem3.setAdapter(new NumericWheelAdapter(startD, endD));
//            maxItem = endD;
        } else if (list_little.contains(String.valueOf(monthNum))) {
            if (endD > 30) {
                endD = 30;
            }
            mWheelViewItem3.setAdapter(new NumericWheelAdapter(startD, endD));
//            maxItem = endD;
        } else {
            if ((year_num % 4 == 0 && year_num % 100 != 0)
                    || year_num % 400 == 0) {
                if (endD > 29) {
                    endD = 29;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startD, endD));
//                maxItem = endD;
            } else {
                if (endD > 28) {
                    endD = 28;
                }
                mWheelViewItem3.setAdapter(new NumericWheelAdapter(startD, endD));
//                maxItem = endD;
            }
        }

        if (currentItem > mWheelViewItem3.getAdapter().getItemsCount() - 1) {
            currentItem = mWheelViewItem3.getAdapter().getItemsCount() - 1;
            mWheelViewItem3.setCurrentItem(currentItem);
        }
    }


    /**
     * 返回获取到的数据
     */
    public String getDatas() {
        String data = "";
        for (int i = 0; i < mPickerOptions.dataLists.size(); i++) {
            if (mPickerOptions.dataLists.get(i) != null) {
                int postion = listWheels.get(i).getCurrentItem();
                data += "" + mPickerOptions.dataLists.get(i).get(postion);
            }
        }
        return data;

    }

    /**
     * 返回获取到的数据
     */
    public String[] getDatasArray() {
        String[] data = new String[mPickerOptions.dataLists.size()];
        for (int i = 0; i < mPickerOptions.dataLists.size(); i++) {
            if (mPickerOptions.dataLists.get(i) != null) {
                int postion = listWheels.get(i).getCurrentItem();
                data[i] = "" + mPickerOptions.dataLists.get(i).get(postion);
            }
        }
        return data;

    }

    /**
     * 返回获取到的数据
     */
    public String getTimeDatas() {
//        StringBuilder sb = new StringBuilder();
//        if (currentYear == startYear) {
//           /* int i = mWheelViewItem2.getCurrentItem() + startMonth;
//            System.out.println("i:" + i);*/
//            if ((mWheelViewItem2.getCurrentItem() + startMonth) == startMonth) {
//                sb.append((mWheelViewItem1.getCurrentItem() + startYear)>10? (mWheelViewItem1.getCurrentItem() + startYear)+"-":
//                        (mWheelViewItem1.getCurrentItem() + startYear)+"-0")
//
//                        .append((mWheelViewItem2.getCurrentItem() + startMonth)>10?(mWheelViewItem2.getCurrentItem() + startMonth)+"-":
//                                (mWheelViewItem2.getCurrentItem() + startMonth)+"-0")
//
//                        .append((mWheelViewItem3.getCurrentItem() + startDay)).append(" ");
//
//            } else {
//                sb.append((mWheelViewItem1.getCurrentItem() + startYear)>10?(mWheelViewItem1.getCurrentItem() + startYear)+"-":
//                        (mWheelViewItem1.getCurrentItem() + startYear)+"-0")
//
//                        .append((mWheelViewItem2.getCurrentItem() + startMonth)>10?(mWheelViewItem2.getCurrentItem() + startMonth)+"-":
//                                (mWheelViewItem2.getCurrentItem() + startMonth)+"-0")
//
//                        .append((mWheelViewItem3.getCurrentItem() + 1)).append(" ");
//
//            }
//
//        } else {
//            sb.append((mWheelViewItem1.getCurrentItem() + startYear)).append("-")
//                    .append((mWheelViewItem2.getCurrentItem() + 1)).append("-")
//                    .append((mWheelViewItem3.getCurrentItem() + 1)).append(" ");
//
//        }
//
//        return sb.toString();


        StringBuilder sb = new StringBuilder();
        if (currentYear == startYear) {
           /* int i = mWheelViewItem2.getCurrentItem() + startMonth;
            System.out.println("i:" + i);*/
            if ((mWheelViewItem2.getCurrentItem() + startMonth) == startMonth) {
                sb.append((mWheelViewItem1.getCurrentItem() + startYear)).append("-")
                        .append((mWheelViewItem2.getCurrentItem() + startMonth)).append("-")
                        .append((mWheelViewItem3.getCurrentItem() + startDay)).append(" ");
            } else {
                sb.append((mWheelViewItem1.getCurrentItem() + startYear)).append("-")
                        .append((mWheelViewItem2.getCurrentItem() + startMonth)).append("-")
                        .append((mWheelViewItem3.getCurrentItem() + 1)).append(" ");
            }

        } else {
            sb.append((mWheelViewItem1.getCurrentItem() + startYear)).append("-")
                    .append((mWheelViewItem2.getCurrentItem() + 1)).append("-")
                    .append((mWheelViewItem3.getCurrentItem() + 1)).append(" ");
        }

        return sb.toString().trim();
    }

}
