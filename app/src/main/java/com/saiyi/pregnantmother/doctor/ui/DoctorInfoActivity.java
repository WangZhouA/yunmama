package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.home.ui.HomeActivity;
import com.saiyi.pregnantmother.my.view.MyDialog;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorInfoActivity extends BKMVPActivity {
    @BindView(R.id.img_one)
    ImageView imgOne;
    @BindView(R.id.img_two)
    ImageView imgTwo;
    @BindView(R.id.img_three)
    ImageView imgThree;
    @BindView(R.id.img_four)
    ImageView imgFour;
    @BindView(R.id.img_five)
    ImageView imgFive;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_level)
    TextView tvLevel;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.rl_ylb)
    RelativeLayout rlYlb;
    @BindView(R.id.rl_tuwen)
    RelativeLayout rlTuwen;
    @BindView(R.id.rl_dh_ZX)
    RelativeLayout rlDhZX;
    @BindView(R.id.tv_sc)
    TextView tvSc;
    @BindView(R.id.tv_Expert_introduction)
    TextView tvExpertIntroduction;
    @BindView(R.id.tv_zhankai)
    TextView tvZhankai;
    @BindView(R.id.xiangqing_view)
    RecyclerView xiangqingView;
    @BindView(R.id.tv_exclusive_doctor)
    TextView tvExclusiveDoctor;
    @BindView(R.id.lin_navigation)
    RelativeLayout linNavigation;

    PhoneDialog phoneDialog;


    private int flagState;
    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_info);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.doctor_info);
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.xiaoxi);


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
             openActivity(MessageActivity.class);
            }

            @Override
            public void onRightTxtClick(View view) {

            }
        });

    }

    @OnClick(R.id.tv_exclusive_doctor)
    public void onClickExclusiveDoctor(View view) {
        openActivity(HomeActivity.class);
    }

    @OnClick({R.id.rl_ylb, R.id.rl_tuwen, R.id.rl_dh_ZX, R.id.tv_zhankai, R.id.xiangqing_view})
    public void onViewClicked(View view) {
        Log.e("---->dianji",view.getId()+"");
        switch (view.getId()) {
            case R.id.rl_ylb:
                openActivity(MedicalKitsActivity.class);
                break;
            case R.id.rl_tuwen:
                showDialog();
                break;
            case R.id.rl_dh_ZX:
                showPhone();
                break;
            case R.id.tv_zhankai:
                break;
            case R.id.xiangqing_view:
                break;
        }
    }

    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.qiangzhi_xiaxian_layout,null);
        final MyDialog builder = new MyDialog(this, 0, 0, view, R.style.MyDialog);
        builder.setCancelable(false);
        Button btn_no_xian_ss=  view.findViewById(R.id.btn_no_xian_ss);
        Button  btn_yes_xiaxian_ss= view.findViewById(R.id.btn_yes_xiaxian_ss);
        TextView tvTitle =view.findViewById(R.id.for_tv_titles);
        TextView tvMsg =view.findViewById(R.id.text_for_tv);


        tvTitle.setText(getResources().getString(R.string.one_pic_zixun));
        tvMsg.setText("￥50.00");
        tvMsg.setTextColor(Color.parseColor("#FF0000"));
        btn_yes_xiaxian_ss.setText(getResources().getString(R.string.Immediately_consult));
        //取消按钮
        btn_no_xian_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
        //确认按钮
        btn_yes_xiaxian_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagState=0;
                showDialogZF();
                builder.dismiss();
            }
        });

        builder.show();
    }

    private void showDialogZF() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_zhifufangshi,null);
        final MyDialog builder = new MyDialog(this, view, R.style.MyDialog,1);
        builder.setCancelable(false);

        final     CheckBox cbWechatpay = view.findViewById(R.id.cb_wechatpay);
        final  CheckBox cbAlipay = view.findViewById(R.id.cb_alipay);
        final  TextView tv_pay =  view.findViewById(R.id.tv_pay);
        cbWechatpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cbAlipay.setChecked(false);
                cbWechatpay.setChecked(true);

            }
        });

        cbAlipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cbAlipay.setChecked(true);
                cbWechatpay.setChecked(false);

            }
        });

        tv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagState==0) {
                    startActivity(new Intent(DoctorInfoActivity.this, TuWenZiXunActviity.class));
                }else {
                    startActivity(new Intent(DoctorInfoActivity.this, TiCeActivity.class));
                }
                builder.dismiss();
            }
        });

        builder.show();
    }


    void showPhone(){

        phoneDialog= new PhoneDialog(DoctorInfoActivity.this);
        phoneDialog.setYesOnclickListener(new PhoneDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                flagState=1;
                showDialogZF();
                phoneDialog.dismiss();
            }
        });
        phoneDialog.setNoOnclickListener(new PhoneDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {

                phoneDialog.dismiss();
            }
        });
        phoneDialog.show();
    }
}
