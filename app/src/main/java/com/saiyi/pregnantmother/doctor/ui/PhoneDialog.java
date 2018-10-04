package com.saiyi.pregnantmother.doctor.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.saiyi.pregnantmother.R;


/**
 * Created by 陈姣姣 on 2017/4/24.
 */
public class PhoneDialog extends Dialog implements View.OnClickListener{

    private Button yes;//确定按钮
    private Button no;//取消按钮


    private RelativeLayout rlO;
    private RelativeLayout rlT;
    private RelativeLayout rlTH;
    private RelativeLayout rlF;
    private RelativeLayout rlFI;
    private RelativeLayout rlS;

    private ImageView imO;
    private ImageView imT;
    private ImageView imTH;
    private ImageView imF;
    private ImageView imFI;
    private ImageView imS;


    RelativeLayout rlArrays[];
    ImageView imArrays [] ;


    private int flag=0;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener( onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener( onYesOnclickListener onYesOnclickListener) {
        this.yesOnclickListener = onYesOnclickListener;
    }

    public PhoneDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_phone_zixun);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });






    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        rlO.setOnClickListener(this);
        rlT.setOnClickListener(this);
        rlTH.setOnClickListener(this);
        rlF.setOnClickListener(this);
        rlFI.setOnClickListener(this);
        rlS.setOnClickListener(this);
    }

    /**
     * 初始化界面控件
     */
    private void initView() {

        yes =findViewById(R.id.btn_yes_xiaxian_ss);
        no =findViewById(R.id.btn_no_xian_ss);

        rlO=findViewById(R.id.rl_O);
        rlT=findViewById(R.id.rl_T);
        rlTH=findViewById(R.id.rl_TH);
        rlF=findViewById(R.id.rl_F);
        rlFI=findViewById(R.id.rl_FI);
        rlS=findViewById(R.id.rl_S);


        imO =findViewById(R.id.im_O);
        imT =findViewById(R.id.im_T);
        imTH =findViewById(R.id.im_TH);
        imF =findViewById(R.id.im_F);
        imFI =findViewById(R.id.im_FI);
        imS =findViewById(R.id.im_S);


        rlArrays =new RelativeLayout[]{rlO,rlT,rlTH,rlF,rlFI,rlS};
        imArrays  =new ImageView[]{imO,imT,imTH,imF,imFI,imS};
        UiState(flag);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.rl_O:
                flag=0;
                UiState(flag);
                break;
            case R.id.rl_T:
                flag=1;
                UiState(flag);
                break;
            case R.id.rl_TH:
                flag=2;
                UiState(flag);
                break;
            case R.id.rl_F:
                flag=3;
                UiState(flag);
                break;
            case R.id.rl_FI:
                flag=4;
                UiState(flag);
                break;
            case R.id.rl_S:
                flag=5;
                UiState(flag);
                break;

        }
    }


    private void UiState( int flag){

        for (int i=0; i<rlArrays.length;i++){

            if (i==flag){
                rlArrays[i].setBackgroundResource(R.drawable.phone_bg);
                imArrays[i].setVisibility(View.VISIBLE);
            }else {
                rlArrays[i].setBackgroundResource(R.drawable.et_bg);
                imArrays[i].setVisibility(View.INVISIBLE);
            }

        }

    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

    /**
     *  选中的是那一个状态
     * */
    private int  getFlag(){

        return  flag;
    }
}




