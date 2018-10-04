package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.home.adapter.GoodsListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Goods;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListActivity extends BKMVPActivity {

    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;

    private int type = Constant.BUNDLE_VALUE_FETAL_HEART_METER;
    private GoodsListAdapter goodsListAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            type = bundle.getInt(Constant.BUNDLE_KEY_DEVICE_TYPE);
        }
        switch (type) {
            case Constant.BUNDLE_VALUE_FETAL_HEART_METER:
                mTitleBar.setTitle(R.string.fetal_heart_meter);
                break;
        }
        rvGoods.setLayoutManager(new LinearLayoutManager(this));
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods());
        goodsListAdapter = new GoodsListAdapter(R.layout.item_goods, list);
        goodsListAdapter.setOnItemClickListener(listener);
        rvGoods.setAdapter(goodsListAdapter);
    }

    protected BaseQuickAdapter.OnItemClickListener listener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.BUNDLE_KEY_DEVICE_TYPE, Constant.BUNDLE_VALUE_FETAL_HEART_METER);
            openActivity(GoodsInfoActivity.class, bundle);
        }
    };
}
