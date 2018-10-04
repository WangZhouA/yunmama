package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.dialog.BaseDialog;
import com.saiyi.pregnantmother.common.view.dialog.PaymentDialog;
import com.saiyi.pregnantmother.home.adapter.GoodsOrderListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Goods;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmationOrderActivity extends BKMVPActivity {

    @BindView(R.id.tv_orders_username)
    TextView tvOrdersUsername;
    @BindView(R.id.tv_orders_userphone)
    TextView tvOrdersUserphone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.ll_orders_info)
    LinearLayout llOrdersInfo;
    @BindView(R.id.rv_orders)
    RecyclerView rvOrders;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_real_payment)
    TextView tvRealPayment;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_place_order)
    TextView tvPlaceOrder;

    private GoodsOrderListAdapter orderListAdapter;
    private PaymentDialog paymentDialog;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_order);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.confirmation_order);
        rvOrders.setLayoutManager(new LinearLayoutManager(this));
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods());
        list.add(new Goods());
        orderListAdapter = new GoodsOrderListAdapter(R.layout.item_goods_order, list);
        rvOrders.setAdapter(orderListAdapter);
        paymentDialog = new PaymentDialog(this);
        paymentDialog.setClick(onDialogClick);
    }

    protected BaseDialog.OnDialogClick onDialogClick = new BaseDialog.OnDialogClick() {
        @Override
        public void onClick(int whichOne) {
            switch (whichOne) {
                case PaymentDialog.WHICH_PAY:
                    openActivity(PaymentSuccessActivity.class);
                    back();
                    break;
                case PaymentDialog.WHICH_ALIPAY:
                    break;
                case PaymentDialog.WHICH_WECHATPAY:
                    break;
            }
        }
    };

    @OnClick({R.id.tv_place_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_place_order:
                paymentDialog.show();
                break;
        }
    }
}