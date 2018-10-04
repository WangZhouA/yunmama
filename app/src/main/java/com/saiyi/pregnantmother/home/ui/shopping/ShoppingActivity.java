package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingActivity extends BKMVPActivity {

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.shopping_mall);
    }


    @OnClick({R.id.fl_fetal_heart, R.id.fl_water_cup})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.fl_fetal_heart:
                bundle.putInt(Constant.BUNDLE_KEY_DEVICE_TYPE, Constant.BUNDLE_VALUE_FETAL_HEART_METER);
                break;
            case R.id.fl_water_cup:
                bundle.putInt(Constant.BUNDLE_KEY_DEVICE_TYPE, Constant.BUNDLE_VALUE_WATER_CUP);
                break;
        }
        openActivity(GoodsListActivity.class, bundle);
    }
}
