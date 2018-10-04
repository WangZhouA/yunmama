package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.saiyi.pregnantmother.R;
import com.sunday.common.utils.UiUtil;

/**
 * 项目：智能控制     SmartLock
 */
public class RemindDialog extends BaseDialog{


    private FrameLayout mConstansyFl;

    private View mDialogView;


    public RemindDialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    public RemindDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RemindDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        mDialogView = View.inflate(getContext(), R.layout.dialog_remind_layout, null);
        mConstansyFl = mDialogView.findViewById(R.id.content_fl);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
    }

    @Override
    public void setContentView(@NonNull View view) {
        mConstansyFl.addView(view);
        super.setContentView(mDialogView);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = View.inflate(getContext(), layoutResID, null);
        mConstansyFl.addView(view);
        super.setContentView(mDialogView);
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        mConstansyFl.addView(view, params);
        super.setContentView(mDialogView);
    }

    protected <T extends RemindDialog> T setViewVisibility(View view, int visibility){
        UiUtil.setVisibility(view, visibility);
        return (T) this;
    }
}
