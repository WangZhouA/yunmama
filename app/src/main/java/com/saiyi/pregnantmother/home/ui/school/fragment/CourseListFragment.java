package com.saiyi.pregnantmother.home.ui.school.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.home.adapter.CourseListAdapter;
import com.saiyi.pregnantmother.home.adapter.ForumListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Course;
import com.saiyi.pregnantmother.home.model.bean.Forum;
import com.saiyi.pregnantmother.home.ui.forum.PostingsInfoActivity;
import com.saiyi.pregnantmother.home.ui.school.BuyCourseActivity;
import com.saiyi.pregnantmother.home.ui.school.CourseInfoActivity;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CourseListFragment extends BKMVPFragment {
    @BindView(R.id.rv_course)
    RecyclerView rvCourse;

    private CourseListAdapter mCourseListAdapter;


    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static CourseListFragment newInstance() {
        CourseListFragment fragment = new CourseListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rvCourse.setLayoutManager(new GridLayoutManager(getContext(), 2));
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("", "婴儿体验课", "免费", "婴儿保育体验班婴儿保育体验班婴儿保育体验班婴儿保育体验班"));
        courses.add(new Course("", "半天婴儿保育班", "¥10.00", "婴儿保育体验班婴儿保育体验班婴儿保育体验班婴儿保育体验班"));
        mCourseListAdapter = new CourseListAdapter(R.layout.item_course, courses);
        mCourseListAdapter.setOnItemClickListener(onItemCilckCourselistener);
        rvCourse.setAdapter(mCourseListAdapter);
    }

    private BaseQuickAdapter.OnItemClickListener onItemCilckCourselistener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Course course = mCourseListAdapter.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constant.BUNDLE_KEY_DATA, course);
            if(course.getPrice().equals("免费")){
                openActivity(CourseInfoActivity.class, bundle);
            }else{
                openActivity(BuyCourseActivity.class, bundle);
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
