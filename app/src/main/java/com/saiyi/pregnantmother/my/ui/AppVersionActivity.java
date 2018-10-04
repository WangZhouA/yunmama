package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.logger.Logger;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppVersionActivity extends BKMVPActivity {

    @BindView(R.id.appversion_tv)
    TextView appversionTv;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appversion);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(getString(R.string.about_us));
        appversionTv.setText(AppUtil.getVersionName(this));
    }
}
