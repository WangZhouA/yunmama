package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈姣姣 on 2018/7/9.
 */
public class TiCeActivity extends BKMVPActivity {
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
    @BindView(R.id.tv_pay)
    TextView tvPay;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingce);


    }

    @Override
    protected void initView() {
        super.initView();

        mTitleBar.setTitle(R.string.review);
        mTitleBar.setRightText(R.string.skip);
        mTitleBar.showRightText();

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

            }

            @Override
            public void onRightTxtClick(View view) {
                finish();
            }
        });


    }
    private boolean  isplayO;
    private boolean  isplayT;
    private boolean  isplayTH;
    private boolean  isplayF;
    private boolean  isplayFI;
    private boolean  isplayS;
    @OnClick({R.id.img_one, R.id.img_two, R.id.img_three, R.id.img_four, R.id.img_five, R.id.tv_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_one:
                if (isplayO==false){
                    imgOne.setImageResource(R.drawable.star);
                    isplayO=true;
                }else {
                    imgOne.setImageResource(R.drawable.star02);
                    isplayO=false;
                }

                break;
            case R.id.img_two:
                if (isplayT==false){
                    imgTwo.setImageResource(R.drawable.star);
                    isplayT=true;
                }else {
                    imgTwo.setImageResource(R.drawable.star02);
                    isplayT=false;
                }

                break;
            case R.id.img_three:

                if (isplayTH==false){
                    imgThree.setImageResource(R.drawable.star);
                    isplayTH=true;
                }else {
                    imgThree.setImageResource(R.drawable.star02);
                    isplayTH=false;
                }
                break;
            case R.id.img_four:

                if (isplayF==false){
                    imgFour.setImageResource(R.drawable.star);
                    isplayF=true;
                }else {
                    imgFour.setImageResource(R.drawable.star02);
                    isplayF=false;
                }
                break;
            case R.id.img_five:

                if (isplayFI==false){
                    imgFive.setImageResource(R.drawable.star);
                    isplayFI=true;
                }else {
                    imgFive.setImageResource(R.drawable.star02);
                    isplayFI=false;
                }

                break;
            case R.id.tv_pay:
                finish();
                break;
        }
    }
}
