package com.sunday.common.activity.tool;

import android.content.Context;
import android.content.DialogInterface;

import com.sunday.common.R;
import com.sunday.common.activity.view.LoadingProgress;
import com.sunday.common.widgets.loadingdialog.LoadingStatusDialog;

/**
 * Created by siwei on 2018/3/13.
 * LoadingProgress的帮助类，想实现自定义的loading，继承AbsLoadingProgress即可
 */

public class LoadingProgressHelper {

    private LoadingStatusDialog mLoadingProgress;

    public LoadingProgressHelper(Context context) {
        String loading = context.getString(R.string.loading);
        LoadingStatusDialog.LoadingStatus status = new LoadingStatusDialog.LoadingStatus(LoadingStatusDialog.LEVEL_LOADING, loading, true);
        mLoadingProgress = new LoadingStatusDialog(context, status);
        mLoadingProgress.setCanceledOnTouchOutside(false);
    }

    public LoadingProgressHelper(Context context, LoadingStatusDialog.LoadingStatus status) {
        mLoadingProgress = new LoadingStatusDialog(context, status);
        mLoadingProgress.setCanceledOnTouchOutside(false);
    }

    public void setCancleAble(boolean cancleAble) {
        mLoadingProgress.setCancelable(cancleAble);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener dismissListener) {
        mLoadingProgress.setOnDismissListener(dismissListener);
    }

    public LoadingProgress getLoadingProgress() {
        return mLoadingProgress;
    }

    public boolean isLoadingShowed() {
        if (mLoadingProgress != null) {
            return mLoadingProgress.isShowing();
        }
        return false;
    }

    /**
     * 显示loading
     */
    public void showProgress() {
        if (mLoadingProgress != null && !mLoadingProgress.isShowing()) {
            mLoadingProgress.show();
        }
    }

    public void showProgress(LoadingStatusDialog.LoadingStatus status){
        if(mLoadingProgress != null){
            mLoadingProgress.setLoadingStatus(status);
            if(!mLoadingProgress.isShowing()){
                mLoadingProgress.show();
            }
        }
    }

    /**
     * 隐藏loading
     */
    public void dismissProgress() {
        if (mLoadingProgress != null && mLoadingProgress.isShowing()) {
            mLoadingProgress.dismiss();
        }
    }

    public void destory() {
        dismissProgress();
        mLoadingProgress = null;
    }
}
