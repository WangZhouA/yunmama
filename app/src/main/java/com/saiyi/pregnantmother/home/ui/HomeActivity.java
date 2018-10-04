package com.saiyi.pregnantmother.home.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.action.Action;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.common.view.CheckImageView;
import com.saiyi.pregnantmother.common.view.ViewPagerSlide;
import com.saiyi.pregnantmother.home.ui.fragment.ConsultationFragment;
import com.saiyi.pregnantmother.home.ui.fragment.DataFragment;
import com.saiyi.pregnantmother.home.ui.fragment.HomeFragment;
import com.saiyi.pregnantmother.home.ui.fragment.MyFragment;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.event.EventAction;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.StatusBarUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BKMVPActivity implements View.OnClickListener {

    @BindView(R.id.home_vp)
    ViewPagerSlide homeVp;
    @BindView(R.id.menu_ll)
    LinearLayout menuLl;

    private List<View> tableViews;
    private SparseArray<Fragment> fragments = new SparseArray<>();
    private PagerAdapter pagerAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initView() {
        super.initView();
        hiddenTitleBar();
        initTabs();
        initFragments();
        registerEventBus();
    }

    private void initTabs() {
        tableViews = Arrays.asList(findViewById(R.id.ll_tab1),
                findViewById(R.id.ll_tab2),
                findViewById(R.id.ll_tab3),
                findViewById(R.id.ll_tab4));
        for (View tabView : tableViews) {
            tabView.setOnClickListener(this);
        }
    }

    private void initFragments() {
        fragments.append(0, HomeFragment.newInstance());
        fragments.append(1, ConsultationFragment.newInstance());
        fragments.append(2, DataFragment.newInstance());
        fragments.append(3, MyFragment.newInstance());
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        homeVp.setOffscreenPageLimit(fragments.size());
        homeVp.setAdapter(pagerAdapter);
        homeVp.setSlide(false);
        homeVp.addOnPageChangeListener(mOnPageChangeListener);
        setTabSelected(0);
    }

    OnPageSelectedListener mOnPageChangeListener = new OnPageSelectedListener() {
        @Override
        public void onPageSelected(int position) {
            setTabSelected(position);
            if (position == fragments.size() - 1) {
                StatusBarUtil.setColor(HomeActivity.this, getResources().getColor(R.color.colorAccent));
            }else{
                StatusBarUtil.setColor(HomeActivity.this, getResources().getColor(R.color.status_bar_color));
            }
        }
    };

    private void setTabSelected(int position) {
        if (tableViews == null) return;
        //多添加了一个加号
        for (int i = 0; i < tableViews.size(); i++) {
            boolean isChecked = (i == position);
            ViewGroup tabView = (ViewGroup) tableViews.get(i);
            CheckImageView tableImgCk = (CheckImageView) tabView.getChildAt(0);
            TextView tableNameTv = (TextView) tabView.getChildAt(1);
            tableImgCk.setChecked(isChecked);
            tableNameTv.setEnabled(isChecked);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab1:
            case R.id.ll_tab2:
            case R.id.ll_tab3:
            case R.id.ll_tab4:
                int pos = tableViews.indexOf(v);
                homeVp.setCurrentItem(pos);
                break;
        }
    }

    @OnClick(R.id.ll_tab_add)
    public void onClickAddDevice(View view) {
        Intent intent = new Intent(this, AddDeviceAvtivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
    }



    public void onMessageEvent(EventAction event) {
        super.onMessageEvent(event);
        if (event == Action.ACTION_EXIT) {
            finish();
        }
    }
}
