package com.saiyi.pregnantmother.home.ui.school;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.home.ui.forum.fragment.ForumListFragment;
import com.saiyi.pregnantmother.home.ui.school.fragment.CourseListFragment;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;

public class SchoolActivity extends BKMVPActivity {

    private final int[] mTitlesRes = {
            R.string.paid,
            R.string.free
    };

    @BindView(R.id.tl_1)
    SegmentTabLayout tl1;
    @BindView(R.id.vp_course)
    ViewPager vpCourse;

    private String[] mTitles;

    private SparseArray<CourseListFragment> mFragments = new SparseArray<>();
    private PagerAdapter mPagerAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
    }

    @Override
    protected void initView() {
        mTitleBar.setTitle(R.string.school);
        initFragments();
    }

    private void initFragments() {
        mTitles = new String[mTitlesRes.length];
        for (int i = 0; i < mTitlesRes.length; i++) {
            mTitles[i] = getString(mTitlesRes[i]);
            mFragments.append(i, CourseListFragment.newInstance());
        }
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        vpCourse.setOffscreenPageLimit(mFragments.size());
        vpCourse.setAdapter(mPagerAdapter);
        tl1.setTabData(mTitles);
        tl1.setOnTabSelectListener(mOnTabSelectListener);
        vpCourse.addOnPageChangeListener(mOnPageChangeListener);
        vpCourse.setCurrentItem(0);
    }

    protected OnPageSelectedListener mOnPageChangeListener = new OnPageSelectedListener() {
        @Override
        public void onPageSelected(int position) {
            tl1.setCurrentTab(position);
        }
    };

    protected OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelect(int position) {
            vpCourse.setCurrentItem(position);
        }

        @Override
        public void onTabReselect(int position) {

        }
    };
}
