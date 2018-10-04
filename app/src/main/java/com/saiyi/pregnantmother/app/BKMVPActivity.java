package com.saiyi.pregnantmother.app;

import com.sunday.common.activity.BaseMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/16.
 */

public abstract class BKMVPActivity<P extends PresenterImpl> extends BaseMVPActivity<P> {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //修复ButterKnife框架在分model下开发无法注入的bug
        //https://github.com/JakeWharton/butterknife/issues/1127
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
