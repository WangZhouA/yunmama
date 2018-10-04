package com.saiyi.pregnantmother.doctor.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.doctor.presenter.DoctorListPresenter;
import com.saiyi.pregnantmother.doctor.ui.fragment.DoctorListFragment;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.adapter.PagerAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class DoctorListActivity extends BKMVPActivity<DoctorListPresenter> {

    private final int[] mTitlesRes = {
            R.string.newborn_pediatrics,
            R.string.gynaecology_obstetrics,
            R.string.nutriology_department
    };
    @BindView(R.id.im_back_list)
    ImageView imBackList;
    @BindView(R.id.et_list)
    EditText etList;
    @BindView(R.id.lin_list)
    LinearLayout linList;
    @BindView(R.id.rl_dingwei)
    RelativeLayout rlDingwei;
    @BindView(R.id.rl_New_pediatric)
    RelativeLayout rlNewPediatric;
    @BindView(R.id.rl_The_comprehensive_sequencing)
    RelativeLayout rlTheComprehensiveSequencing;
    @BindView(R.id.rl_Consulting_type)
    RelativeLayout rlConsultingType;
    @BindView(R.id.lin_navigation)
    LinearLayout linNavigation;

    private String[] mTitles;

    @BindView(R.id.tl_1)
    SlidingTabLayout tl1;
    @BindView(R.id.vp_doctor_type)
    ViewPager vpDoctorType;

    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private PagerAdapter mPagerAdapter;


    @Override
    public DoctorListPresenter initPresenter(Context context) {
        return new DoctorListPresenter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.doctor);
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.sousuo);
        initFragments();

        mTitleBar.setClickListener(new NavBar.NavBarOnClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                finish();
            }

            @Override
            public void onLeftSenIconClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {
                mTitleBar.setVisibility(View.GONE);
                linList.setVisibility(View.VISIBLE);

            }

            @Override
            public void onRightTxtClick(View view) {

            }
        });


        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("UPTE");
        intentFilter.addAction("DOWN");
        registerReceiver(broadcastReceiver,intentFilter);


    }

    private void initFragments() {
        mTitles = new String[mTitlesRes.length];
        for (int i = 0; i < mTitlesRes.length; i++) {
            mTitles[i] = getString(mTitlesRes[i]);
            mFragments.append(i, DoctorListFragment.newInstance());
        }
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        vpDoctorType.setOffscreenPageLimit(mFragments.size());
        vpDoctorType.setAdapter(mPagerAdapter);
        vpDoctorType.addOnPageChangeListener(mOnPageChangeListener);
        tl1.setViewPager(vpDoctorType, mTitles);
        vpDoctorType.setCurrentItem(0);
    }

    OnPageSelectedListener mOnPageChangeListener = new OnPageSelectedListener() {
        @Override
        public void onPageSelected(int position) {

        }
    };

    @OnClick(R.id.im_back_list)
    public void onViewClicked() {
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
     unregisterReceiver(broadcastReceiver);
    }

    @OnClick({R.id.rl_dingwei, R.id.rl_New_pediatric, R.id.rl_The_comprehensive_sequencing, R.id.rl_Consulting_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_dingwei:
                break;
            case R.id.rl_New_pediatric:
                break;
            case R.id.rl_The_comprehensive_sequencing:
                break;
            case R.id.rl_Consulting_type:
                break;
        }
    }

    private BroadcastReceiver broadcastReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action =intent.getAction();
            if (action.contains("UPTE")){
                linNavigation.setVisibility(View.GONE);
            }else  if (action.contains("DOWN")){
                linNavigation.setVisibility(View.VISIBLE);
            }
        }
    };
}
