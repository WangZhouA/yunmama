package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;

import com.flyco.tablayout.SlidingTabLayout;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.my.presenter.OrdersMainPresenter;
import com.saiyi.pregnantmother.my.ui.fragment.BabyGrowthCycleFragment;
import com.saiyi.pregnantmother.my.ui.fragment.OrdersAllFragement;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.mvp.PresenterImpl;

import java.util.List;

import butterknife.BindView;

public class OrdersMainActivity extends BKMVPActivity<OrdersMainPresenter>{

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.slid_layout)
    SlidingTabLayout mSlidingTab;
    private String[] mTitles;
    private PagerAdapter mPagerAdapter;
    private SparseArray<Fragment> mFragments = new SparseArray<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersmain);
    }

    @Override
    public OrdersMainPresenter initPresenter(Context context) {
        return new OrdersMainPresenter(context);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.my_order);
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.sousuo);
        mTitles = new String[]{getString(R.string.orders_title_all),
                getString(R.string.orders_title_nopay),
                getString(R.string.orders_title_noship),
                getString(R.string.orders_title_noreceipt),
                getString(R.string.orders_title_receipted),
        };

        for (int i = 0; i < mTitles.length; i++) {
            mFragments.append(i, OrdersAllFragement.newInstance());
        }
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new OnPageSelectedListener() {
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mSlidingTab.setViewPager(mViewPager, mTitles);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initData() {
        super.initData();


    }
}