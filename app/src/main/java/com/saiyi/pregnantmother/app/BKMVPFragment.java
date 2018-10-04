package com.saiyi.pregnantmother.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sunday.common.activity.BaseMVPFragment;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/16.
 */

public abstract class BKMVPFragment<P extends PresenterImpl> extends BaseMVPFragment<P> {

    private Unbinder mUnBinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //修复ButterKnife框架在分model下开发无法注入的bug
        //https://github.com/JakeWharton/butterknife/issues/1127
        mUnBinder = ButterKnife.bind(this, view);
        initView(view);
        initData();
        initListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnBinder != null){
            mUnBinder.unbind();
        }
    }
}
