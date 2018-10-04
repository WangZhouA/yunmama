package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈姣姣 on 2018/7/5.
 */
public class MedicalKitsActivity extends BKMVPActivity {
    @BindView(R.id.Service_doctor)
    TextView ServiceDoctor;
    @BindView(R.id.tv_one_month)
    TextView tvOneMonth;
    @BindView(R.id.tv_one_month_money)
    TextView tvOneMonthMoney;
    @BindView(R.id.lin_one)
    LinearLayout linOne;
    @BindView(R.id.tv_three_month)
    TextView tvThreeMonth;
    @BindView(R.id.tv_three_month_money)
    TextView tvThreeMonthMoney;
    @BindView(R.id.lin_three)
    LinearLayout linThree;
    @BindView(R.id.tv_one_year)
    TextView tvOneYear;
    @BindView(R.id.tv_one_year_money)
    TextView tvOneYearMoney;
    @BindView(R.id.lin_oneYear)
    LinearLayout linOneYear;
    @BindView(R.id.cb_wechatpay)
    CheckBox cbWechatpay;
    @BindView(R.id.ll_wechatpay)
    LinearLayout llWechatpay;
    @BindView(R.id.cb_alipay)
    CheckBox cbAlipay;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_pay)
    TextView tvPay;


    TextView [] textsViewColor ;
    TextView [] textViewsColorMoney;
    LinearLayout [] linearLayouts ;
    private int flag=0;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalkits);
        textsViewColor =new TextView[]{tvOneMonth,tvThreeMonth,tvOneYear};
        textViewsColorMoney =new TextView[]{tvOneMonthMoney,tvThreeMonthMoney,tvOneYearMoney};
        linearLayouts =new LinearLayout[]{linOne,linThree,linOneYear};
        uiState(flag);
        mTitleBar.setTitle(R.string.Medical_kits);
    }

    @OnClick({R.id.lin_one, R.id.lin_three, R.id.lin_oneYear, R.id.cb_wechatpay, R.id.cb_alipay, R.id.tv_pay})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.lin_one:
                flag=0;
                uiState(flag);
                break;
            case R.id.lin_three:
                flag=1;
                uiState(flag);
                break;
            case R.id.lin_oneYear:
                flag=2;
                uiState(flag);
                break;
            case R.id.cb_wechatpay:
                cbAlipay.setChecked(false);
                cbWechatpay.setChecked(true);
                break;
            case R.id.cb_alipay:
                cbAlipay.setChecked(true);
                cbWechatpay.setChecked(false);
                break;
            case R.id.tv_pay:

                openActivity(ChatActivity.class);
                break;
        }

    }

    private void  uiState(int flag){

        for (int i =0;i<textsViewColor.length;i++){

            if (flag==i){
                textsViewColor[i].setTextColor(Color.parseColor("#FFFFFF"));
                textViewsColorMoney[i].setTextColor(Color.parseColor("#FFFFFF"));
                linearLayouts[i].setBackgroundResource(R.drawable.tc_bg_onclick);
            }else {
                textsViewColor[i].setTextColor(Color.parseColor("#333333"));
                textViewsColorMoney[i].setTextColor(Color.parseColor("#333333"));
                linearLayouts[i].setBackgroundResource(R.drawable.tc_bg);
            }
        }
    }
}
