package com.saiyi.pregnantmother.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.login.model.LoginModel;
import com.saiyi.pregnantmother.login.ui.LoginActivity;
import com.sunday.common.http.BaseResponseListener;
import com.sunday.common.http.exception.ErrorStatus;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.StringUtils;

public class LoginPresenter extends PresenterImpl<LoginActivity, LoginModel> {

    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel initModel() {
        return new LoginModel();
    }

    public boolean onLogin(String phone, String upwd) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(upwd)) {
            getView().showErrorMsg(getContext().getString(R.string.input_phone_pwd));
            return false;
        } else if (!StringUtils.isMobileNum(phone)) {
            //不是手机号，显示错误信息
            getView().showErrorMsg(getContext().getString(R.string.phone_format));
            return false;
        }else if(upwd.length() < 6){
            getView().showErrorMsg(getContext().getString(R.string.pwd_number_little));
            return false;
        }
        getView().showLoginLoading();
        getView().dismissLoading();
        getView().loginSuccess();

        getModel().login(phone, upwd, new BaseResponseListener<String>() {
            @Override
            public void onResponse(String data) {
                super.onResponse(data);
                //登录成功
//                getView().dismissLoading();
//                getView().loginSuccess();
            }

            @Override
            public void onFaild(ErrorStatus e) {
                super.onFaild(e);
//                getView().dismissLoading();
//                getView().loginFaild(e.msg);
            }
        });
        return true;
    }
}
