package com.saiyi.pregnantmother.login.model;

import android.support.annotation.NonNull;

import com.saiyi.pregnantmother.common.model.UserHelper;
import com.saiyi.pregnantmother.login.model.bean.User;
import com.sunday.common.error.DB.DBError;
import com.sunday.common.error.ErrorEngine;
import com.sunday.common.http.BaseHttpObserver;
import com.sunday.common.http.BaseResponse;
import com.sunday.common.http.ResponseListener;
import com.sunday.common.mvp.ModelImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends ModelImpl {

    public void login(final String phone, final String uPwd, @NonNull ResponseListener<String> listener){
        UserHelper.instance().setUser(new User(phone));
//        LoginService loginService = createRetorfitService(LoginService.class);
//        loginService.login(uName, uPwd)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseHttpObserver<User>(getCompositeDisposable(), listener) {
//                    @Override
//                    public void onResponse(BaseResponse<User> response) {
//                        if(response.isSuccess()){
//                            if(ModelHelper.instance().getUserHelper().login(new Account(uName, uPwd), response.getData())){
//                                dispatchListenerResponse(response.getData());
//                            }else{
//                                dispatchListenerFaild(ErrorEngine.handleCustomError(DBError.UserSaveError));
//                            }
//                        }else{
//                            dispatchListenerFaild(ErrorEngine.handleServiceResultError(response.getCode()));
//                        }
//                    }
//                });
    }
}
