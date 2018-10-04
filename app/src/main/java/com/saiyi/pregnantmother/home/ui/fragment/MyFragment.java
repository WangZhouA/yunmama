package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.my.ui.AppVersionActivity;
import com.saiyi.pregnantmother.my.ui.BabyGrowthCycleActivity;
import com.saiyi.pregnantmother.my.ui.ChartActivity;
import com.saiyi.pregnantmother.my.ui.ContactUsActivity;
import com.saiyi.pregnantmother.my.ui.NoticeActivity;
import com.saiyi.pregnantmother.my.ui.OrdersMainActivity;
import com.saiyi.pregnantmother.my.ui.PersonalCenterActivity;
import com.saiyi.pregnantmother.my.view.CircleImageView;
import com.saiyi.pregnantmother.my.view.UserInfo;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BKMVPFragment {

    @BindView(R.id.iv_user)
    CircleImageView ivUser;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.iv_chart)
    ImageView ivChart;
    @BindView(R.id.tv_chart)
    TextView tvChart;
    UserInfo userInfo;
    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.iv_user, R.id.rl_order, R.id.rl_chart, R.id.rl_exclusive_doctor, R.id.rl_notice_bulletin, R.id.rl_contact_us, R.id.rl_about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_user:
                openActivity(PersonalCenterActivity.class);
                break;
            case R.id.rl_order:
                openActivity(OrdersMainActivity.class);
                break;
            case R.id.rl_chart:
                openActivity(ChartActivity.class);
                break;
            case R.id.rl_exclusive_doctor:
//                openActivity(BabyGrowthCycleActivity.class);
                break;
            case R.id.rl_notice_bulletin:
                openActivity(NoticeActivity.class);
                break;
            case R.id.rl_contact_us:
                openActivity(ContactUsActivity.class);
                break;
            case R.id.rl_about_us:
                openActivity(AppVersionActivity.class);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

         userInfo=new UserInfo(getActivity());
        if (!TextUtils.isEmpty(userInfo.getStringInfo("img"))){
            Bitmap bitmap = BitmapFactory.decodeFile(userInfo.getStringInfo("img"));
            ivUser.setImageBitmap(bitmap);
        }

    }
}
