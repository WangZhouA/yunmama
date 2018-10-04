package com.saiyi.pregnantmother.my.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.my.model.bean.Notice;
import com.saiyi.pregnantmother.my.model.bean.ProductionInspection;
import com.sunday.common.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductionInspectionAdapter extends BaseQuickAdapter<ProductionInspection, ProductionInspectionAdapter.ViewHolder> {


    public ProductionInspectionAdapter(int layoutResId, @Nullable List<ProductionInspection> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, ProductionInspection item) {

    }

    protected class ViewHolder extends BaseViewHolder {


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
