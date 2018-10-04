package com.saiyi.pregnantmother.doctor.presenter;

import android.content.Context;

import com.saiyi.pregnantmother.doctor.model.DoctorListModel;
import com.saiyi.pregnantmother.doctor.ui.DoctorListActivity;
import com.sunday.common.mvp.PresenterImpl;

public class DoctorListPresenter extends PresenterImpl<DoctorListActivity, DoctorListModel> {

    public DoctorListPresenter(Context context) {
        super(context);
    }

    @Override
    public DoctorListModel initModel() {
        return new DoctorListModel();
    }
}
