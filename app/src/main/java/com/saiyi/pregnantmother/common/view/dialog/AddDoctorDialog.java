package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.sunday.common.logger.Logger;

import butterknife.BindView;


public class AddDoctorDialog extends RemindDialog implements View.OnClickListener{

    public static final int WHICH_MANUALLY = 10;

    public static final int WHICH_AUTO = 11;


    @BindView(R.id.tv_manually)
    TextView tvManually;

    @BindView(R.id.tv_auto)
    TextView tvAuto;

    public AddDoctorDialog(@NonNull Context context) {
        super(context);
    }

    public AddDoctorDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AddDoctorDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        setContentView(R.layout.dialog_doctor_layout);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tvManually.setOnClickListener(this);
        tvAuto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
        switch (v.getId()){
            case R.id.tv_manually:
                onWhichOneClick(WHICH_MANUALLY);
                break;
            case R.id.tv_auto:
                onWhichOneClick(WHICH_AUTO);
                break;
        }
    }
}
