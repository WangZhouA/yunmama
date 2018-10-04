package com.saiyi.pregnantmother.home.ui.school;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.home.model.bean.Course;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyCourseActivity extends BKMVPActivity {

    @BindView(R.id.tv_course_name1)
    TextView tvCourseName1;
    @BindView(R.id.tv_course_introduction)
    TextView tvCourseIntroduction;
    @BindView(R.id.tv_course_name)
    TextView tvCourseName;
    @BindView(R.id.tv_course_price)
    TextView tvCoursePrice;
    @BindView(R.id.cb_alipay)
    CheckBox cbAlipay;
    @BindView(R.id.cb_wechatpay)
    CheckBox cbWechatpay;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    private Course course;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_course);
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
        tvCourseName1.setText(course.getTitle());
        tvCourseIntroduction.setText(course.getIntroduction());
        tvCourseName.setText(course.getTitle());
        tvCoursePrice.setText(course.getPrice());
        tvPrice.setText(course.getPrice());
    }

    @OnClick({R.id.ll_alipay, R.id.ll_wechatpay, R.id.tv_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_alipay:
                cbAlipay.setChecked(true);
                cbWechatpay.setChecked(false);
                break;
            case R.id.ll_wechatpay:
                cbAlipay.setChecked(false);
                cbWechatpay.setChecked(true);
                break;
            case R.id.tv_pay:
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.BUNDLE_KEY_DATA, course);
                openActivity(CourseInfoActivity.class, bundle);
                back();
                break;
        }
    }
}
