package com.saiyi.pregnantmother.home.ui.forum;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.listener.OnPageSelectedListener;
import com.saiyi.pregnantmother.doctor.ui.fragment.DoctorListFragment;
import com.saiyi.pregnantmother.home.model.bean.Forum;
import com.saiyi.pregnantmother.home.ui.forum.fragment.ForumListFragment;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.adapter.PagerAdapter;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForumActivity extends BKMVPActivity {

    private final int[] mTitlesRes = {
            R.string.all_postings,
            R.string.my_postings
    };

    @BindView(R.id.tl_1)
    SegmentTabLayout tl1;
    @BindView(R.id.vp_postings)
    ViewPager vpPostings;

    private String[] mTitles;

    private SparseArray<ForumListFragment> mFragments = new SparseArray<>();
    private PagerAdapter mPagerAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.forum);
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.xiaoxi);
        mTitleBar.setClickListener(navBarOnClickListener);
        initFragments();
    }

    protected NavBar.NavBarOnClickListener navBarOnClickListener = new NavBar.NavBarOnClickListener() {
        @Override
        public void onLeftIconClick(View view) {
            back();
        }

        @Override
        public void onLeftSenIconClick(View view) {

        }

        @Override
        public void onRightIconClick(View view) {
            openActivity(PushPostActivity.class);
        }

        @Override
        public void onRightTxtClick(View view) {

        }
    };

    private void initFragments() {
        mTitles = new String[mTitlesRes.length];
        for (int i = 0; i < mTitlesRes.length; i++) {
            mTitles[i] = getString(mTitlesRes[i]);
            mFragments.append(i, ForumListFragment.newInstance());
        }
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        vpPostings.setOffscreenPageLimit(mFragments.size());
        vpPostings.setAdapter(mPagerAdapter);
        tl1.setTabData(mTitles);
        tl1.setOnTabSelectListener(mOnTabSelectListener);
        vpPostings.addOnPageChangeListener(mOnPageChangeListener);
        vpPostings.setCurrentItem(0);
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
            vpPostings.setCurrentItem(position);
        }

        @Override
        public void onTabReselect(int position) {

        }
    };
}
