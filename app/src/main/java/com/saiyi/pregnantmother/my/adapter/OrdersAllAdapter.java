package com.saiyi.pregnantmother.my.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.doctor.model.bean.Doctor;
import com.saiyi.pregnantmother.my.model.bean.OrdersBean;
import com.sunday.common.utils.UiUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersAllAdapter extends BaseQuickAdapter<OrdersBean, OrdersAllAdapter.OrdersAllViewHolder> {


    private List<OrdersBean> doctors;
    private Context context;
    private OnListener onListener;

    public OrdersAllAdapter(int layoutResId, @Nullable List<OrdersBean> data, Context context) {
        super(layoutResId, data);
        this.doctors = data;
        this.context = context;
    }

    @Override
    protected void convert(final OrdersAllViewHolder helper, final OrdersBean item) {
        helper.tvSeeLogistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onListener != null){
                    onListener.onClickSeeLogistics(helper, item);
                }
            }
        });

        helper.tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onListener != null){
                    onListener.onClickpay(helper, item);
                }
            }
        });
    }

    public class OrdersAllViewHolder extends BaseViewHolder {

        /**
         * 商品订单号
         */
        @BindView(R.id.tv_orders_number)
        TextView tvOrdersNumber;

        /**
         * 商品图片
         */
        @BindView(R.id.iv_orders_image)
        ImageView ivOrdersImage;

        /**
         * 商品支付状态
         */
        @BindView(R.id.tv_orders_status)
        TextView tvOrdersStatus;

        /**
         * 商品详情
         */
        @BindView(R.id.tv_orders_goods)
        TextView tvOrdersGoods;

        /**
         * 商品备注
         */
        @BindView(R.id.tv_orders_deatils)
        TextView tvOrdersDeatils;

        /**
         * 商品价格
         */
        @BindView(R.id.tv_orders_price)
        TextView tvOrdersPrice;

        /**
         * 商品购买数量
         */
        @BindView(R.id.tv_orders_buynumber)
        TextView tvOrdersBuynumber;

        /**
         * 商品购买计算详情
         */
        @BindView(R.id.tv_orders_buydeatils)
        TextView tvOrdersBuydeatils;

        /**
         * 查看物流
         */
        @BindView(R.id.tv_see_logistics)
        TextView tvSeeLogistics;

        /**
         * 付款
         */
        @BindView(R.id.tv_pay)
        TextView tvPay;


        public OrdersAllViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnLisetener(OnListener onLisetener){
        this.onListener = onLisetener;
    }

    public interface OnListener {
        void onClickSeeLogistics(OrdersAllViewHolder holder, OrdersBean item);

        void onClickpay(OrdersAllViewHolder holder, OrdersBean item);
    }
}