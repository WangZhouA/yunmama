package com.saiyi.pregnantmother.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.login.model.ForgetPasswordModel;
import com.saiyi.pregnantmother.login.ui.ForgetPasswordActivity;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.StringUtils;

public class ForgetPasswordPresenter extends PresenterImpl<ForgetPasswordActivity, ForgetPasswordModel> {

    private boolean bVCode = false;

    public ForgetPasswordPresenter(Context context) {
        super(context);
    }

    @Override
    public ForgetPasswordModel initModel() {
        return new ForgetPasswordModel();
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

    public boolean backPwd(String phone, String pwd, String prePwd, String identifyCode) {
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
        getView().onRegisterSuccess("已找回密码");
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
