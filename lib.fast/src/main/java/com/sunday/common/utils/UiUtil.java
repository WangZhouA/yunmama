package com.sunday.common.utils;

import android.content.res.Resources;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


/**
 * UI工具类
 */
public class UiUtil {

    public static double density = 1d;

    public static void setVisibility(View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    public static void setVisibility(View parent, int id, int visibility) {
        if (parent != null) {
            View view = parent.findViewById(id);
            if (view != null) {
                setVisibility(view, visibility);
            }
        }
    }

    public static void requestFocus(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }


    public static int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    public static int px2dip(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, Resources.getSystem()
                .getDisplayMetrics());
    }

    /**
     * 设置文字最长长度
     */
    public static void setTextMaxLength(TextView textView, int maxLength) {
        if (textView == null || maxLength <= 0) return;
        addTextFilters(textView, new InputFilter.LengthFilter(maxLength));
    }

    /**
     * 设置文字过滤
     */
    public static void addTextFilters(TextView textView, InputFilter filter) {
        if (textView == null || filter == null) return;
        InputFilter[] filters = textView.getFilters();
        int filtersLength = filters == null ? 0 : filters.length;
        InputFilter[] setFilters = new InputFilter[filtersLength + 1];
        for (int i = 0; i < filters.length; i++) {
            setFilters[i] = filters[i];
        }
        setFilters[filtersLength] = filter;
        textView.setFilters(setFilters);
    }

}
