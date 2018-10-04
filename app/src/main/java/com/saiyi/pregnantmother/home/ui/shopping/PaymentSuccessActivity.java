package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.home.adapter.RecommendGoodsAdapter;
import com.saiyi.pregnantmother.home.model.bean.Goods;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentSuccessActivity extends BKMVPActivity {

    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;

    private RecommendGoodsAdapter recommendGoodsAdapter; //推荐商品适配器

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.payment_success);
        rvGoods.setLayoutManager(new GridLayoutManager(this, 2));
        //假数据
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods());
        list.add(new Goods());
        recommendGoodsAdapter = new RecommendGoodsAdapter(R.layout.item_recommend_goods, list);
        rvGoods.setAdapter(recommendGoodsAdapter);
    }

    @OnClick({R.id.tv_back_order, R.id.tv_back_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back_order:
                back();
                break;
            case R.id.tv_back_home:
                back();
                break;
        }
    }
}
