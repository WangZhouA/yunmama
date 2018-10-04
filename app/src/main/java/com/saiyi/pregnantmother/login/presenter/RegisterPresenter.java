package com.saiyi.pregnantmother.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.login.model.RegisterModel;
import com.saiyi.pregnantmother.login.ui.RegisterActivity;
import com.sunday.common.http.BaseResponseListener;
import com.sunday.common.http.exception.ErrorStatus;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.StringUtils;

public class RegisterPresenter extends PresenterImpl<RegisterActivity, RegisterModel> {

    private boolean bVCode = false;

    public RegisterPresenter(Context context) {
        super(context);
    }

    @Override
    public RegisterModel initModel() {
        return new RegisterModel();
    }

    public boolean getValidCode(String phone) {
        if (TextUtils.isEmpty(phone) || (!StringUtils.isMobileNum(phone))) {
            getView().showErrorMsg(getContext().getString(R.string.input_phone_number));
            return false;
        }
        bVCode = true;
        getView().getValidCodeSuccess("获取验证码成功");
//        getModel().getValidCode(phone, new BaseResponseListener<String>() {
//
//            @Override
//            public void onFaild(ErrorStatus e) {
//                super.onFaild(e);
//                getView().getValidCodeFaild(e.msg);
//            }
//
//            @Override
//            public void onResponse(String data) {
//                super.onResponse(data);
//                bVCode = true;
//                getView().getValidCodeSuccess(data);
//            }
//
//        });
        return true;
    }


    public boolean register(String phone, String pwd, String prePwd, String identifyCode) {
        //点击注册按钮
        if (!StringUtils.isMobileNum(phone)) {
            getView().showErrorMsg(getContext().getString(R.string.input_phone_number));
            return false;
        } else if (!bVCode) {
            getView().showErrorMsg(getContext().getString(R.string.not_valid_code));
            return false;
        } else if (TextUtils.isEmpty(identifyCode)) {
            getView().showErrorMsg(getContext().getString(R.string.input_valid_code));
            return false;
        } else if (!StringUtils.equals(pwd, prePwd)) {
            getView().showErrorMsg(getContext().getString(R.string.pwd_inconsistencies));
            return false;
        } else if (pwd.length() < 6) {
            getView().showErrorMsg(getContext().getString(R.string.pwd_number_little));
            return false;
        }
        getView().showLoadingDialog();
        getView().onRegisterSuccess("注册成功");
//        getModel().register(phone, pwd, identifyCode, new BaseResponseListener<String>() {
//            @Override
//            public void onResponse(String data) {
//                super.onResponse(data);
//                //注册完成
//                getView().onRegisterSuccess(data);
//            }
//
//            @Override
//            public void onFaild(ErrorStatus e) {
//                super.onFaild(e);
//                getView().onRegisteFaild(e.msg);
//            }
//        });
        return true;
    }
}
