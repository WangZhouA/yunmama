package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.action.Action;
import com.sunday.common.event.EventAction;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectionTypeActivity extends BKMVPActivity {

    @BindView(R.id.rl_pregnant)
    RelativeLayout rlPregnant;
    @BindView(R.id.rl_spicy_mother)
    RelativeLayout rlSpicyMother;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_type);
    }

    @Override
    protected void initView() {
        super.initView();
        hiddenTitleBar();
        registerEventBus();
    }

    @OnClick(R.id.rl_pregnant)
    public void onClickPregnant(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(SupplementInfoActivity.BUNDLE_KEY_TYPE, SupplementInfoActivity.BUNDLE_VALUE_PREGNANT);
        openActivity(SupplementInfoActivity.class, bundle);
    }

    @OnClick(R.id.rl_spicy_mother)
    public void onClickSpicyMother(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(SupplementInfoActivity.BUNDLE_KEY_TYPE, SupplementInfoActivity.BUNDLE_VALUE_MOTHER);
        openActivity(SupplementInfoActivity.class, bundle);
    }

    @Override
    public void onMessageEvent(EventAction event) {
        super.onMessageEvent(event);
        if (event == Action.ACTION_SUPPLEMENT_DONE) {
            back();
        }
    }
}
