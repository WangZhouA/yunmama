package com.saiyi.pregnantmother.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.home.model.bean.Goods;

import java.util.List;

import butterknife.ButterKnife;

public class GoodsOrderListAdapter extends BaseQuickAdapter<Goods, GoodsOrderListAdapter.ViewHolder> {

    public GoodsOrderListAdapter(int layoutResId, @Nullable List<Goods> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(GoodsOrderListAdapter.ViewHolder helper, Goods item) {

    }

    protected class ViewHolder extends BaseViewHolder {

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
