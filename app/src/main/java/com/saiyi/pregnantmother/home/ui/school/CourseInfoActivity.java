package com.saiyi.pregnantmother.home.ui.school;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.home.model.bean.Course;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CourseInfoActivity extends BKMVPActivity {

    @BindView(R.id.iv_likes)
    ImageView ivLikes;
    private Course course;

    private int status = 0;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            toast("未知错误");
            back();
        }
        course = (Course) bundle.get(Constant.BUNDLE_KEY_DATA);
        mTitleBar.setTitle(course.getTitle());
    }

    @OnClick(R.id.iv_likes)
    public void onClickLikes(View view) {
        if (status == 0) {
            ivLikes.setImageResource(R.drawable.zan02);
            status = 1;
        } else {
            ivLikes.setImageResource(R.drawable.zan);
            status = 0;
        }
    }
}
