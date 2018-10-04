package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.common.tools.DateUtils;
import com.saiyi.pregnantmother.common.view.ListenScrollView;
import com.saiyi.pregnantmother.home.adapter.PicassoImageLoader;
import com.saiyi.pregnantmother.home.ui.HomeActivity;
import com.saiyi.pregnantmother.my.ui.fragment.BabyGrowthCycleFragment;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.logger.Logger;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.ScreenUtils;
import com.sunday.common.utils.UiUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BKMVPFragment {

    private static final String TAG = "HomeFragment1";

    private static final int AD_DELAY_TIME = 3000;      //轮播间隔时间

    @BindView(R.id.title_bar)
    NavBar titleBar;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.vp_menu)
    ViewPager vpMenu;
    @BindView(R.id.vp_content_type)
    ViewPager vpContentType;
    @BindView(R.id.tl_content)
    TabLayout tlContent;

    @BindView(R.id.vp_baby_grpwth_cycle)
    ViewPager vpBabyGrpwthCycle;

    @BindView(R.id.tl_1)
    SlidingTabLayout tl1;
    @BindView(R.id.lsv_content)
    ListenScrollView lsvContent;

    private String toDayDate;  //今天的日期
    private String currentSelectDate;   //当前选择的日期
    private String calculationDate;     //预产期

    private String[] mTitles;
    private String[] mDates;

    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private PagerAdapter mPagerAdapter;

    private final int[] mTitlesRes = {
            R.string.good_lesson,
            R.string.hot_topic,
            R.string.hot_selling_goods
    };

    private PagerAdapter mPagerAdapterMenu;
    private PagerAdapter mPagerAdapterContent;
    private SparseArray<Fragment> fragmentsMenu = new SparseArray<>();
    private SparseArray<Fragment> fragmentsContent = new SparseArray<>();

    private int screenH; // 滚动内部一屏幕的高度

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
        toDayDate = DateUtils.formatYM(System.currentTimeMillis());
        currentSelectDate = com.sunday.common.utils.DateUtils.formatYMD(System.currentTimeMillis()).replace("/", "-");
        titleBar.hiddenLeftIcon();
        titleBar.setTitle("- " + toDayDate + " -");
        titleBar.noEndLine();
        initDate();
        initBanner();
        initMenuFragment();
        initContentFragment();
    }

    private void initDate() {
        mDates = DateUtils.getSevenDays(System.currentTimeMillis() - 86400000, DateUtils.SEVEN_DAYS_LATER);
        mTitles = dateToDay(mDates);
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.append(i, BabyGrowthCycleFragment.newInstance());
        }
        lsvContent.setOnScrollChangedListener(onScrollChangedListener);
        mPagerAdapter = new PagerAdapter(getChildFragmentManager(), mFragments);
        vpBabyGrpwthCycle.setAdapter(mPagerAdapter);
        vpBabyGrpwthCycle.addOnPageChangeListener(mOnPageChangeListener);
        tl1.setViewPager(vpBabyGrpwthCycle, mTitles);
        screenH = ScreenUtils.getScreenHeight(getContext())-UiUtil.dip2px(44) - ScreenUtils.getStatusHeight(getContext()) - UiUtil.dip2px(80);//titlebar+status+bottom(49+10的margin)
    }

    protected ListenScrollView.OnScrollChangedListener onScrollChangedListener = new ListenScrollView.OnScrollChangedListener() {
        @Override
        public void onScrollChanged(int top, int oldTop) {
            Logger.d("onScrollChanged oldTop=%s, screenH = %s, currentSelectDate = %s", oldTop, screenH, currentSelectDate);
            if (oldTop >= screenH) {
                titleBar.setTitle(R.string.app_name);
            } else {
                titleBar.setTitle("- " + DateUtils.formatYM(DateUtils.stringDateTolong(currentSelectDate)) + " -");
            }
        }
    };

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
                    currentSelectDate = mDates[mDates.length - 1];
                    mDates = DateUtils.getSevenDays(DateUtils.stringDateTolong(currentSelectDate), DateUtils.SEVEN_DAYS_LATER);
                } else if (mFragments.size() != 1 && pos == 0) {
                    vpBabyGrpwthCycle.setCurrentItem(mFragments.size() - 1);
                    currentSelectDate = mDates[0];
                    mDates = DateUtils.getSevenDays(DateUtils.stringDateTolong(currentSelectDate), DateUtils.SEVEN_DAYS_BEFORE);
                }
                titleBar.setTitle("- " + DateUtils.formatYM(DateUtils.stringDateTolong(currentSelectDate)) + " -");
                mTitles = dateToDay(mDates);
                tl1.setViewPager(vpBabyGrpwthCycle, mTitles);
            } else {
                isLast = true;
            }
        }

        @Override
        public void onPageSelected(int position) {
            pos = position;
            currentSelectDate = mDates[position];
            titleBar.setTitle("- " + DateUtils.formatYM(DateUtils.stringDateTolong(currentSelectDate)) + " -");
            BabyGrowthCycleFragment fragment = (BabyGrowthCycleFragment) mPagerAdapter.getItem(position);
            fragment.upDataDate(toDayDate, currentSelectDate);
        }
    };


    /**
     * 初始化广告轮播
     */
    private void initBanner() {
        List<Integer> images = new ArrayList<Integer>();
        images.add(new Integer(R.drawable.test_ad1));
        images.add(new Integer(R.drawable.test_ad1));
        images.add(new Integer(R.drawable.test_ad1));
        images.add(new Integer(R.drawable.test_ad1));
        images.add(new Integer(R.drawable.test_ad1));
        banner.setIndicatorGravity(BannerConfig.RIGHT)
                .setDelayTime(AD_DELAY_TIME)
                .setImages(images)
                .setImageLoader(new PicassoImageLoader())
                .start();
    }

    private void initMenuFragment() {
        fragmentsMenu.append(0, MenuOneFragment.newInstance());
        mPagerAdapterMenu = new PagerAdapter(getChildFragmentManager(), fragmentsMenu);
        vpMenu.setAdapter(mPagerAdapterMenu);
        vpMenu.setOffscreenPageLimit(fragmentsMenu.size());
    }

    private void initContentFragment() {
        for (int i = 0; i < tlContent.getTabCount(); i++) {
            fragmentsContent.append(i, ContentFragment.newInstance());
        }
        mPagerAdapterContent = new PagerAdapter(getChildFragmentManager(), fragmentsContent);
        vpContentType.setOffscreenPageLimit(fragmentsContent.size());
        vpContentType.setAdapter(mPagerAdapterContent);
        tlContent.setupWithViewPager(vpContentType);
        for (int i = 0; i < tlContent.getTabCount(); i++) {
            tlContent.getTabAt(i).setText(mTitlesRes[i]);
        }
        vpContentType.setCurrentItem(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
