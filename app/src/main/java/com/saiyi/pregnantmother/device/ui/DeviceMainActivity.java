package com.saiyi.pregnantmother.device.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceMainActivity extends BKMVPActivity {

    private int dType;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_main);
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            back();
            return;
        }
        dType = bundle.getInt(Constant.BUNDLE_KEY_DEVICE_TYPE);
        switch (dType) {
            case Constant.BUNDLE_VALUE_FETAL_HEART_METER:
                mTitleBar.setTitle(R.string.fetal_heart_meter_bt);
                break;
            case Constant.BUNDLE_VALUE_HAND_RING:
                mTitleBar.setTitle(R.string.hand_ring_bt);
                break;
        }
    }


    @OnClick({R.id.tv_buy, R.id.tv_blue_tooth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_buy:
                break;
            case R.id.tv_blue_tooth:
                onConnect();
                break;
        }
    }

    private void onConnect() {
        switch (dType) {
            case Constant.BUNDLE_VALUE_FETAL_HEART_METER:
                openActivity(HeartMeterActivity.class);
                break;
            case Constant.BUNDLE_VALUE_HAND_RING:
                openActivity(HandRingActivity.class);
                break;
        }
    }
}
