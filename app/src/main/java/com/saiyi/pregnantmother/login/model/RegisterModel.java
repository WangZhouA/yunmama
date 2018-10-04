package com.saiyi.pregnantmother.login.model;

import com.sunday.common.http.ResponseListener;
import com.sunday.common.mvp.ModelImpl;

import io.reactivex.annotations.NonNull;

public class RegisterModel extends ModelImpl {

    /**
     * 获取短信验证码
     */
    public void getValidCode(String phone, final ResponseListener<String> listener) {

    }

    /**
     * 用户注册
     */
    public void register(String phone, String pwd, String identifyCode, @NonNull ResponseListener<String> listener) {
    }
}
