package com.saiyi.pregnantmother.home.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringChain;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.device.ui.DeviceMainActivity;
import com.sunday.common.mvp.PresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddDeviceAvtivity extends BKMVPActivity {

    @BindView(R.id.ll_fetal_heart_meter)
    LinearLayout llFetalHeartMeter;
    @BindView(R.id.ll_water_cup)
    LinearLayout llWaterCup;
    @BindView(R.id.ll_weighing)
    LinearLayout llWeighing;
    @BindView(R.id.ll_ear_thermometer)
    LinearLayout llEarThermometer;
    @BindView(R.id.ll_hand_ring)
    LinearLayout llHandRing;
    @BindView(R.id.ll_coming_soon)
    LinearLayout llComingSoon;
    @BindView(R.id.iv_colse)
    ImageView ivColse;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.rl_menu)
    RelativeLayout rlMenu;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
    }

    @Override
    protected void initView() {
        super.initView();
        hiddenTitleBar();
        startAnim();
    }

    private void startAnim() {
        SpringChain springChain = SpringChain.create(40, 6, 50, 7);
        int childCount = rlMenu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = rlMenu.getChildAt(i);

            springChain.addSpring(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    view.setTranslationY((float) spring.getCurrentValue());
                }
            });
        }

        List<Spring> springs = springChain.getAllSprings();
        for (int i = 0; i < springs.size(); i++) {
            springs.get(i).setCurrentValue(400);
        }

        springChain.setControlSpringIndex(2).getControlSpring().setEndValue(0);

        Animation circle_anim = AnimationUtils.loadAnimation(this, R.anim.add_rotate_left);
        circle_anim.setFillAfter(true);
        if (circle_anim != null) {
            ivColse.startAnimation(circle_anim);  //开始动画
        }
    }

    @OnClick({R.id.ll_fetal_heart_meter, R.id.ll_water_cup, R.id.ll_weighing, R.id.ll_ear_thermometer, R.id.ll_hand_ring, R.id.ll_coming_soon, R.id.iv_colse, R.id.ll_root})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.ll_fetal_heart_meter:
                bundle.putInt(Constant.BUNDLE_KEY_DEVICE_TYPE, Constant.BUNDLE_VALUE_FETAL_HEART_METER);
                openActivity(DeviceMainActivity.class, bundle);
                back();
                break;
            case R.id.ll_water_cup:
                break;
            case R.id.ll_weighing:
                break;
            case R.id.ll_ear_thermometer:
                break;
            case R.id.ll_hand_ring:
                bundle.putInt(Constant.BUNDLE_KEY_DEVICE_TYPE, Constant.BUNDLE_VALUE_HAND_RING);
                openActivity(DeviceMainActivity.class, bundle);
                back();
                break;
            case R.id.ll_coming_soon:
                break;
            case R.id.iv_colse:
                back();
                break;
            case R.id.ll_root:
                back();
                break;
        }
    }

    @Override
    public void back() {
        finish();
        overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
    }
}
