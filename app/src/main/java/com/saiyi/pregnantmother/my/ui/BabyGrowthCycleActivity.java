package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.action.Action;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.common.tools.DateUtils;
import com.saiyi.pregnantmother.home.ui.HomeActivity;
import com.saiyi.pregnantmother.my.ui.fragment.BabyGrowthCycleFragment;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.mvp.PresenterImpl;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class BabyGrowthCycleActivity extends BKMVPActivity {

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.vp_baby_grpwth_cycle)
    ViewPager vpBabyGrpwthCycle;

    @BindView(R.id.tl_1)
    SlidingTabLayout tl1;


    private String toDayDate;  //今天的日期
    private String currentSelectDate;   //当前选择的日期
    private String calculationDate;     //预产期

    private String[] mTitles;
    private String[] mDates;

    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private PagerAdapter mPagerAdapter;


    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_crowth_cycle);
    }

    @Override
    protected void initView() {
        super.initView();
        hiddenTitleBar();
        toDayDate = DateUtils.formatYM(System.currentTimeMillis());
        tvDate.setText("-" + toDayDate + "-");
        initDate();
    }

    private void initDate() {
        mDates = DateUtils.getSevenDays(System.currentTimeMillis(),DateUtils.SEVEN_DAYS_LATER);
        mTitles = dateToDay(mDates);
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.append(i, BabyGrowthCycleFragment.newInstance());
        }
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        vpBabyGrpwthCycle.setAdapter(mPagerAdapter);
        vpBabyGrpwthCycle.addOnPageChangeListener(mOnPageChangeListener);
        tl1.setViewPager(vpBabyGrpwthCycle, mTitles);
    }

    public String[] dateToDay(String[] dates) {
        String[] days = new String[dates.length];
        for (int i = 0; i < dates.length; i++) {
            days[i] = dates[i].split("-")[2];
        }
        return days;
    }

    OnPageSelectedListener mOnPageChangeListener = new OnPageSelectedListener() {
        private int pos = 0;
        boolean isLast = true;

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == 2) {
                isLast = false;
            } else if (state == 0 && isLast) {
                if (mFragments.size() != 1 && pos == (mFragments.size() - 1)) {
                    vpBabyGrpwthCycle.setCurrentItem(0);
                    mDates = DateUtils.getSevenDays(DateUtils.stringDateTolong(currentSelectDate),DateUtils.SEVEN_DAYS_LATER);
                    mTitles = dateToDay(mDates);
                    tl1.setViewPager(vpBabyGrpwthCycle, mTitles);
                } else if (mFragments.size() != 1 && pos == 0) {
                    vpBabyGrpwthCycle.setCurrentItem(mFragments.size() - 1);
                }

            } else {
                isLast = true;
            }
        }

        @Override
        public void onPageSelected(int position) {
            pos = position;
            currentSelectDate = mDates[position];
            BabyGrowthCycleFragment fragment = (BabyGrowthCycleFragment) mPagerAdapter.getItem(position);
            fragment.upDataDate(toDayDate, currentSelectDate);
        }
    };

}
