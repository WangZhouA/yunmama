package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.os.Bundle;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

/**
 * Created by 陈姣姣 on 2018/7/6.
 */
public class ChatActivity extends BKMVPActivity {
    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_chat);
       mTitleBar.setTitle("黄海燕");

    }
}
