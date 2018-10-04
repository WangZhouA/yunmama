package com.saiyi.pregnantmother.device.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.dialog.DeviceDialog;
import com.saiyi.pregnantmother.device.ui.fragment.HistoricalFragment;
import com.saiyi.pregnantmother.device.ui.fragment.RealTimeDataFragment;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class HeartMeterActivity extends BKMVPActivity {


    @BindView(R.id.tl_1)
    SlidingTabLayout tl1;
    @BindView(R.id.vp_data)
    ViewPager vpData;

    private String[] mTitles;
    private PagerAdapter mPagerAdapter;
    private SparseArray<Fragment> mFragments = new SparseArray<>();

    private DeviceDialog deviceDialog;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_meter);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.monitoring);
        mTitles = new String[]{getString(R.string.real_time_data),
                getString(R.string.historical_data)
        };
        mFragments.append(0, RealTimeDataFragment.newInstance());
        mFragments.append(1, HistoricalFragment.newInstance());
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        vpData.setAdapter(mPagerAdapter);
        tl1.setViewPager(vpData, mTitles);
        deviceDialog = new DeviceDialog(this);
    }

    @OnClick({R.id.ll_fetal_heart, R.id.ll_fetal_movement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_fetal_heart:
                showFatalHeartExp();
                break;
            case R.id.ll_fetal_movement:
                showFatalMovementExp();
                break;
        }
    }

    private void showFatalHeartExp() {
        dismissExpDialog();
        deviceDialog.setConfirmText(getString(R.string.i_got_it))
                .setIconImageRes(R.drawable.taixinicon02)
                .setMsgText(getString(R.string.fetal_heart_rate_abnormality));
        deviceDialog.show();
    }

    private void showFatalMovementExp() {
        dismissExpDialog();
        deviceDialog.setConfirmText(getString(R.string.i_got_it))
                .setIconImageRes(R.drawable.taidong02)
                .setMsgText(getString(R.string.fetal_movement_abnormality));
        deviceDialog.show();
    }

    //弹窗消失
    private void dismissExpDialog() {
        if (deviceDialog != null && deviceDialog.isShowing()) {
            deviceDialog.dismiss();
        }
    }
}
