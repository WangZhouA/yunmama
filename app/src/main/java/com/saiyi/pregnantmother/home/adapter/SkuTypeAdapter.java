package com.saiyi.pregnantmother.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.SkuAttribute;

import java.util.ArrayList;
import java.util.List;

public class SkuTypeAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context context;
    private List<SkuAttribute> mDatas;

    public SkuTypeAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<SkuAttribute>();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_skuattribute, parent, false);
            holder = new ViewHolder();
            holder.tvSkuAttribute = convertView.findViewById(R.id.tv_skuattribute);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SkuAttribute skuAttribute = mDatas.get(position);
        holder.tvSkuAttribute.setText(skuAttribute.getValue());
        if (skuAttribute.isSelected()) {
            holder.tvSkuAttribute.setBackgroundResource(R.drawable.fourdp_btn_bg_blue_shape);
            holder.tvSkuAttribute.setTextColor(context.getResources().getColor(R.color.style_blue));
        } else {
            holder.tvSkuAttribute.setBackgroundResource(R.drawable.fourdp_btn_bg_black_shape);
            holder.tvSkuAttribute.setTextColor(context.getResources().getColor(R.color.title_text_color1));
        }

        return convertView;
    }

    private class ViewHolder {
        TextView tvSkuAttribute;
    }

    public void addSkuAttribute(SkuAttribute skuAttribute) {
        mDatas.add(skuAttribute);
        notifyDataSetChanged();
    }

    public void setSkuAttribute(int position, SkuAttribute skuAttribute) {
        mDatas.set(position, skuAttribute);
        notifyDataSetChanged();
    }

    public void refreshSkuAttribute(List<SkuAttribute> skuAttributes) {
        mDatas.clear();
        mDatas.addAll(skuAttributes);
        notifyDataSetChanged();
    }
}
