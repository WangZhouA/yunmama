package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.home.adapter.CourseListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Course;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContentFragment extends BKMVPFragment {

    @BindView(R.id.rv_doctor)
    RecyclerView rvContent;

    private CourseListAdapter mCourseListAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static ContentFragment newInstance() {
        ContentFragment fragment = new ContentFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_list, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("", "婴儿体验课", "免费","婴儿保育体验班婴儿保育体验班婴儿保育体验班婴儿保育体验班"));
        courses.add(new Course("","半天婴儿保育班","¥10.00","婴儿保育体验班婴儿保育体验班婴儿保育体验班婴儿保育体验班"));
        mCourseListAdapter = new CourseListAdapter(R.layout.item_course_home, courses);
        rvContent.setAdapter(mCourseListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
