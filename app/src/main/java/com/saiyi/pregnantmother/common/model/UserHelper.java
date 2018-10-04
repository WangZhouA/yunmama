package com.saiyi.pregnantmother.common.model;

import com.saiyi.pregnantmother.login.model.bean.User;

import org.litepal.crud.DataSupport;

public class UserHelper {

    private User mUser;
    private static UserHelper INSTANCE;

    public static UserHelper instance() {
        if (INSTANCE == null) {
            synchronized (UserHelper.class) {
                INSTANCE = new UserHelper();
            }
        }
        return INSTANCE;
    }

    public void setUser(User user) {
        mUser = user;
    }

    /**
     * 获取用户
     */
    public User getUser() {
        return mUser;
    }

}
