package com.sunday.common.utils;

import android.view.View;

/**
 * 项目：智能控制     SmartLock
 */
public class ViewUtils {

    public static void addPadding(View view, int padding){
        if(view == null)return;
        view.setPadding(view.getPaddingLeft()+padding, view.getPaddingTop()+padding, view.getPaddingRight()+padding, view.getPaddingBottom()+padding);
    }
}
