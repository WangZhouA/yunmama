package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;

import butterknife.BindView;


public class DeviceDialog extends BaseDialog implements View.OnClickListener {


    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    public DeviceDialog(@NonNull Context context) {
        super(context, R.style.device_dialog);
    }

    public DeviceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DeviceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        setContentView(R.layout.dialog_device_layout);
    }

    public DeviceDialog setMsgText(String text) {
        tvText.setText(text);
        return this;
    }

    public DeviceDialog setMsgTextColor(@ColorInt int color) {
        tvText.setTextColor(color);;
        return this;
    }

    public DeviceDialog setConfirmText(String text) {
        tvConfirm.setText(text);
        return this;
    }

    public DeviceDialog setConfirmTextColor(@ColorInt int color) {
        tvConfirm.setTextColor(color);
        return this;
    }

    public DeviceDialog setIconImageRes(@DrawableRes int imgRes){
        ivIcon.setImageResource(imgRes);
        return this;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        onWhichOneClick(v.getId());
//        switch (v.getId()){
//            case R.id.tv_manually:
//                onWhichOneClick(WHICH_MANUALLY);
//                break;
//            case R.id.tv_auto:
//                onWhichOneClick(WHICH_AUTO);
//                break;
//        }
    }
}
