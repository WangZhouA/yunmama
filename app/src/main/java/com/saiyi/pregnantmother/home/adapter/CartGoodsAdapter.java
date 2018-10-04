package com.saiyi.pregnantmother.home.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.Goods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartGoodsAdapter extends BaseQuickAdapter<Goods, CartGoodsAdapter.ViewHolder> {

    public CartGoodsAdapter(int layoutResId, @Nullable List<Goods> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final ViewHolder helper, Goods item) {
        helper.btnSkuQuantityMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(helper.etSkuQuantityInput.getText().toString().trim());
                if (number > 1) {
                    String newQuantity = String.valueOf(number - 1);
                    helper.etSkuQuantityInput.setText(newQuantity);
                    helper.etSkuQuantityInput.setSelection(newQuantity.length());
                    updateQuantityOperator(helper,number - 1);
                }
            }
        });
        helper.btnSkuQuantityPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = helper.etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    return;
                }
                int quantityInt = Integer.parseInt(quantity);
                String newQuantity = String.valueOf(quantityInt + 1);
                helper.etSkuQuantityInput.setText(newQuantity);
                helper.etSkuQuantityInput.setSelection(newQuantity.length());
                updateQuantityOperator(helper,quantityInt + 1);
            }
        });
    }

    private void updateQuantityOperator(ViewHolder holder, int newQuantity) {
        if (newQuantity <= 1) {
            holder.btnSkuQuantityMinus.setEnabled(false);
            holder.btnSkuQuantityPlus.setEnabled(true);
        } else {
            holder.btnSkuQuantityMinus.setEnabled(true);
            holder.btnSkuQuantityPlus.setEnabled(true);
        }
        holder.etSkuQuantityInput.setEnabled(true);
    }

    protected class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_skuattribute)
        TextView tvSkuattribute;
        @BindView(R.id.btn_sku_quantity_minus)
        TextView btnSkuQuantityMinus;
        @BindView(R.id.et_sku_quantity_input)
        EditText etSkuQuantityInput;
        @BindView(R.id.btn_sku_quantity_plus)
        TextView btnSkuQuantityPlus;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
