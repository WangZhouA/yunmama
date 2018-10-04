package com.saiyi.pregnantmother.my.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;

import com.sunday.common.adapter.PagerAdapter;

public class ReCycleVPAdapter extends PagerAdapter {

    //    当前页面
    private int currentPosition = 0;

    protected Context mContext;

    public ReCycleVPAdapter(FragmentManager fm, SparseArray<? extends Fragment> testFragments) {
        super(fm, testFragments);
    }

}
