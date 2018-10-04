package com.saiyi.pregnantmother.home.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.Goods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListAdapter extends BaseQuickAdapter<Goods, GoodsListAdapter.ViewHolder> {

    public GoodsListAdapter(int layoutResId, @Nullable List<Goods> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, Goods item) {
        helper.tvOriginalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    protected class ViewHolder extends BaseViewHolder{
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_present_price)
        TextView tvPresentPrice;
        @BindView(R.id.tv_original_price)
        TextView tvOriginalPrice;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
