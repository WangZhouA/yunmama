package com.saiyi.pregnantmother.login.presenter;

import android.content.Context;

import com.saiyi.pregnantmother.login.model.SplashModel;
import com.saiyi.pregnantmother.login.ui.SplashActivity;
import com.sunday.common.http.exception.ErrorStatus;
import com.sunday.common.logger.Logger;
import com.sunday.common.mvp.PresenterImpl;

public class SplashPresenter extends PresenterImpl<SplashActivity, SplashModel> {

    private final long SPALISH_WAIT_TIME = 3000;
    private boolean isWaitEnd;//等待时候结束
    private boolean isLoginEnd;//时候登陆结束

    public SplashPresenter(Context context) {
        super(context);
    }

    @Override
    public SplashModel initModel() {
        return new SplashModel();
    }

    public void waitSpalish() {
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getModel().hasLogined()) {
                    //已登录跳转到主页
                    getView().goHomeActivity();
                } else {
                    getView().goLoginActivity();
//                    //在等待时间内完成了登陆
//                    if(isLoginEnd){
//                        getView().goLoginActivity();
//                    }else{
//                        //在等待时间内未完成
//                        isWaitEnd = true;
//                    }
                }
            }
        }, SPALISH_WAIT_TIME);

    }
}
