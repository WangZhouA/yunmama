package com.saiyi.pregnantmother.my.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.my.adapter.OrdersAllAdapter;
import com.saiyi.pregnantmother.my.model.bean.OrdersBean;
import com.saiyi.pregnantmother.my.ui.LogisticsAcvtivity;
import com.saiyi.pregnantmother.my.ui.OrdersDeatilsActivity;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrdersAllFragement extends BKMVPFragment {

    @BindView(R.id.recyView)
    RecyclerView recyView;

    private OrdersAllAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_ordersall, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static OrdersAllFragement newInstance() {
        OrdersAllFragement fragment = new OrdersAllFragement();
        return fragment;
    }

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        recyView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<OrdersBean> doctors = new ArrayList<OrdersBean>();
        for (int i=0;i<5;i++){
            OrdersBean bean = new OrdersBean();
            doctors.add(bean);
        }

        adapter = new OrdersAllAdapter(R.layout.item_ordersall, doctors, getActivity());
        adapter.setOnLisetener(new OrdersAllAdapter.OnListener() {
            @Override
            public void onClickSeeLogistics(OrdersAllAdapter.OrdersAllViewHolder holder, OrdersBean item) {
                openActivity(LogisticsAcvtivity.class);
            }

            @Override
            public void onClickpay(OrdersAllAdapter.OrdersAllViewHolder holder, OrdersBean item) {
                openActivity(OrdersDeatilsActivity.class);
            }
        });
        recyView.setAdapter(adapter);
    }
}