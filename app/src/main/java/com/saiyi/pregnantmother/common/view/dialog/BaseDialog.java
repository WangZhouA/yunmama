package com.saiyi.pregnantmother.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.sunday.common.logger.Logger;

import butterknife.ButterKnife;

/**
 * Base Dialog
 */
public abstract class BaseDialog extends Dialog {

    private OnDialogClick mClick;

    public BaseDialog(@NonNull Context context) {
        super(context);
        initDialog();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initDialog();
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog();
    }

    public void setClick(OnDialogClick mClick) {
        this.mClick = mClick;
    }

    private void bindView(View view){
        ButterKnife.bind(this, view);
        initView(view);
        initData();
    }

    @Override
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        bindView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(layoutResID, null, false);
        setContentView(view);
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        bindView(view);
    }

    /**初始化弹窗*/
    protected void initDialog(){
    }

    /**初始化view会被回调*/
    protected void initView(View view){};

    /**初始化数据被回调*/
    protected void initData(){};

    /**弹窗中某个按钮被点击,调用该方法会回调OnDialogClick.onClick(whichOne)*/
    protected void onWhichOneClick(int whichOne){
        if(mClick != null){
            mClick.onClick(whichOne);
        }
    }

    public interface OnDialogClick{

        void onClick(int whichOne);
    }

}
