package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.action.Action;
import com.saiyi.pregnantmother.doctor.ui.DoctorListActivity;
import com.saiyi.pregnantmother.doctor.ui.ScanDoctorQrActivity;
import com.saiyi.pregnantmother.home.ui.HomeActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.OnClick;

public class SelectDoctorActivity extends BKMVPActivity {

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_doctor);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.noEndLine();
    }

    @OnClick({R.id.rl_selection_manual, R.id.rl_selection_scan_qr, R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_selection_manual:
                openActivity(DoctorListActivity.class);
                break;
            case R.id.rl_selection_scan_qr:
                openActivity(ScanDoctorQrActivity.class);
                break;
            case R.id.tv_skip:
                openActivity(HomeActivity.class);
                back();
                send(Action.ACTION_SUPPLEMENT_DONE);
                break;
        }
    }
}
