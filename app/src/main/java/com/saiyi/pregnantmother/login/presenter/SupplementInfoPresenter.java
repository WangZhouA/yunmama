package com.saiyi.pregnantmother.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.login.model.SupplementInfoModel;
import com.saiyi.pregnantmother.login.ui.SupplementInfoActivity;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.utils.StringUtils;

public class SupplementInfoPresenter extends PresenterImpl<SupplementInfoActivity, SupplementInfoModel> {

    public SupplementInfoPresenter(Context context) {
        super(context);
    }

    @Override
    public SupplementInfoModel initModel() {
        return new SupplementInfoModel();
    }

    public boolean updateUserDate(String name, String age, String phone, String date, String address, int type) {
        getView().showLoadingDialog();
        if (TextUtils.isEmpty(name)) {
            getView().showErrorMsg(StringUtils.getStringByResource(R.string.input_user_name));
            return false;
        } else if (TextUtils.isEmpty(phone)) {
            getView().showErrorMsg(StringUtils.getStringByResource(R.string.input_phone_number));
            return false;
        } else if (TextUtils.isEmpty(date)) {
            if (type == SupplementInfoActivity.BUNDLE_VALUE_PREGNANT) {
                getView().showErrorMsg(StringUtils.getStringByResource(R.string.input_date_childbirth));
            } else {
                getView().showErrorMsg(StringUtils.getStringByResource(R.string.input_baby_birthday));
            }
            return false;
        }
        getView().dismissLoading();
        getView().onSupplementInfoSuccess("设置成功");
//        getModel().
        return true;
    }
}
