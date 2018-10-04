package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.home.adapter.CartGoodsAdapter;
import com.saiyi.pregnantmother.home.model.bean.Goods;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingCartAcativity extends BKMVPActivity {

    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.tv_subtotal)
    TextView tvSubtotal;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    private boolean isEditor = false;
    private CartGoodsAdapter cartGoodsAdapter;//购物车商品列表适配

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.shopping_cart);
        mTitleBar.showRightText();
        mTitleBar.setRightText(R.string.edit);
        mTitleBar.setRightTextColor(getResources().getColor(R.color.style_red));
        mTitleBar.setClickListener(barOnClickListener);
        rvGoods.setLayoutManager(new LinearLayoutManager(this));
        List<Goods> doctors = new ArrayList<Goods>();
        doctors.add(new Goods());
        doctors.add(new Goods());
        cartGoodsAdapter = new CartGoodsAdapter(R.layout.item_cart_goods, doctors);
        rvGoods.setAdapter(cartGoodsAdapter);
    }

    protected NavBar.NavBarOnClickListener barOnClickListener = new NavBar.NavBarOnClickListener() {
        @Override
        public void onLeftIconClick(View view) {
            back();
        }

        @Override
        public void onLeftSenIconClick(View view) {

        }

        @Override
        public void onRightIconClick(View view) {

        }


        @Override
        public void onRightTxtClick(View view) {
            if (isEditor) {
                exitEditModel();
            } else {
                entryEditModel();
            }
        }
    };

    //进入编辑模式
    private void entryEditModel() {
        mTitleBar.setRightText(R.string.done);
        isEditor = true;
        tvSubmit.setText(R.string.delete);
    }

    //退出编辑模式
    private void exitEditModel() {
        mTitleBar.setRightText(R.string.edit);
        isEditor = false;
        tvSubmit.setText(R.string.go_balance_accounts);
    }

    @OnClick({R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                if (isEditor) {

                } else {
                    back();
                }
                break;
        }
    }
}
