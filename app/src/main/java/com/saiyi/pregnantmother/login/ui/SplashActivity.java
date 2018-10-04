package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.os.Bundle;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.home.ui.HomeActivity;
import com.saiyi.pregnantmother.login.presenter.SplashPresenter;

public class SplashActivity extends BKMVPActivity<SplashPresenter> {

    @Override
    public SplashPresenter initPresenter(Context context) {
        return new SplashPresenter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected boolean enableSetStatusBarColor() {
        return false;
    }

    @Override
    protected void initView() {
        super.initView();
        hiddenTitleBar();
        getPresenter().waitSpalish();
    }


    /**
     * 跳转到登录页面
     */
    public void goLoginActivity() {
        openActivity(LoginActivity.class);
        finish();
    }

    /**
     * 跳转到主页
     */
    public void goHomeActivity() {
        openActivity(HomeActivity.class);
        finish();
    }
}
