package com.saiyi.pregnantmother.my.presenter;

import android.content.Context;

import com.saiyi.pregnantmother.my.model.OrdersMainModel;
import com.saiyi.pregnantmother.my.ui.OrdersMainActivity;
import com.sunday.common.mvp.ModelImpl;
import com.sunday.common.mvp.PresenterImpl;


public class OrdersMainPresenter extends PresenterImpl<OrdersMainActivity,OrdersMainModel>{

    public OrdersMainPresenter(Context context) {
        super(context);
    }

    @Override
    public OrdersMainModel initModel() {
        return new OrdersMainModel();
    }
}