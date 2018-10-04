package com.sunday.common.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.sunday.common.R;
import com.sunday.common.activity.tool.LoadingProgressHelper;
import com.sunday.common.cache.ACache;
import com.sunday.common.event.EventAction;
import com.sunday.common.utils.StatusBarUtil;
import com.sunday.common.utils.ToastUtils;
import com.sunday.common.widgets.loadingdialog.LoadingStatusDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by siwei on 2015/6/9.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
//    private InputMethodHelper mInputMethodHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setStatusBarColor(getStatusbarColor());

//        mInputMethodHelper =new InputMethodHelper(getActivity());
    }

    /**
     * 设置状态栏颜色
     */
    protected void setStatusBarColor(@ColorInt int color) {
        if (enableSetStatusBarColor()) {
            StatusBarUtil.setColor(getActivity(), color);
        }
    }

    /**
     * 允许设置状态栏颜色
     */
    protected boolean enableSetStatusBarColor() {
        return true;
    }

    /**
     * 获取状态栏颜色
     */
    protected @ColorInt
    int getStatusbarColor() {
        return getResources().getColor(R.color.default_status_bar_color);
    }

    protected void registerEventBus(){
        EventBus.getDefault().register(this);
    }

    /**event bus事件接收*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventAction event) {
        /* Do something */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLoadingHelper != null) {
            mLoadingHelper.destory();
        }
//        mInputMethodHelper.fixInputMethodManagerLeak(getActivity());
//        mInputMethodHelper = null;
        EventBus.getDefault().unregister(this);
    }

    protected abstract void initView(View view);

    protected abstract void initListener();

    protected abstract void initData();

    /**
     * loading帮助类
     */
    private LoadingProgressHelper mLoadingHelper;


    /**
     * 显示loading
     */
    protected LoadingProgressHelper showLoading() {
        dismissProgressDialog();
        LoadingProgressHelper loadingProgressHelper = new LoadingProgressHelper(mContext);
        return showProgress(loadingProgressHelper);
    }

    //显示弹窗
    private @Nullable
    LoadingProgressHelper showProgress(LoadingProgressHelper progressHelper) {
        dismissProgressDialog();
        if (progressHelper != null) {
            mLoadingHelper = progressHelper;
            mLoadingHelper.showProgress();
        }
        return progressHelper;
    }


    /**
     * 创建自定义的弹窗,创建后之前的弹窗会自动消失
     */
    protected LoadingProgressHelper showCustomLoading(LoadingStatusDialog.LoadingStatus defaultStatus) {
        dismissProgressDialog();
        LoadingProgressHelper loadingProgressHelper = new LoadingProgressHelper(mContext, defaultStatus);
        return showProgress(loadingProgressHelper);
    }

    /**
     * 显示自定义提醒信息的loading
     */
    protected LoadingProgressHelper showCustomLoading(String msg) {
        LoadingStatusDialog.LoadingStatus status = new LoadingStatusDialog.LoadingStatus(LoadingStatusDialog.LEVEL_LOADING, msg, true);
        return showCustomLoading(status);
    }

    /**
     * 消失loading
     */
    protected void dismissProgressDialog() {
        if (mLoadingHelper != null) {
            mLoadingHelper.dismissProgress();
        }
    }

    public void toast(String msg) {
        if(mContext != null){
            ToastUtils.showToast(mContext.getApplicationContext(), msg);
        }
    }

    /**
     * 获取缓存
     */
    public ACache getCache() {
        return BaseApplication.getInstance().getCache();
    }

    /**
     * 关闭软键盘
     */
//    protected void closeSoftInput(){
//        mInputMethodHelper.closeSoftInput(getActivity());
//    }

    /**
     * 显示软键盘
     */
//    protected void showSoftInput(EditText et){
//        mInputMethodHelper.showSoftInput(et);
//    }

    protected void openActivity(Class<? extends Activity> pClass) {
        openActivity(pClass, null);
    }


    protected void openActivity(Class<? extends Activity> pClass, Bundle pBundle) {
        Intent intent = new Intent(mContext, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected void openActivityForResult(Class<? extends Activity> pClass, int requestCode){
        openActivityForResult(pClass, null, requestCode);
    }

    protected void openActivityForResult(Class<? extends Activity> pClass, Bundle pBundle, int requestCode){
        Intent intent = new Intent(mContext, pClass);
        if(pBundle != null){
            intent.putExtras(pBundle);
        }
        startActivityForResult(intent, requestCode);
    }

}
