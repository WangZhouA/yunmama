package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;

import com.saiyi.pregnantmother.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PaymentDialog extends BaseDialog {

    public static final int WHICH_PAY = 10;
    public static final int WHICH_ALIPAY = 11;
    public static final int WHICH_WECHATPAY = 12;

    @BindView(R.id.cb_wechatpay)
    CheckBox cbWechatpay;
    @BindView(R.id.cb_alipay)
    CheckBox cbAlipay;

    private Context context;

    public PaymentDialog(@NonNull Context context) {
        super(context, R.style.CommonBottomDialogStyle);
        this.context = context;
        initView();
    }

    public PaymentDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        initView();
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        setContentView(R.layout.dialog_payment);
    }

    public void initView() {

    }

    @OnClick({R.id.ll_wechatpay, R.id.ll_alipay, R.id.tv_pay, R.id.ll_payment_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_wechatpay:
                cbAlipay.setChecked(false);
                cbWechatpay.setChecked(true);
                onWhichOneClick(WHICH_WECHATPAY);
                break;
            case R.id.ll_alipay:
                cbAlipay.setChecked(true);
                cbWechatpay.setChecked(false);
                onWhichOneClick(WHICH_ALIPAY);
                break;
            case R.id.tv_pay:
                onWhichOneClick(WHICH_PAY);
                dismiss();
                break;
            case R.id.ll_payment_dialog:
                dismiss();
                break;
        }
    }

}
