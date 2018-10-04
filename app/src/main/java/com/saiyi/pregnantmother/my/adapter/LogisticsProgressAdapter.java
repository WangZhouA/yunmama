package com.saiyi.pregnantmother.my.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.my.model.bean.LogisticsProgress;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JingNing on 2018-07-09 11:20
 */
public class LogisticsProgressAdapter extends BaseQuickAdapter<LogisticsProgress, LogisticsProgressAdapter.ViewHolder>{

    private List<LogisticsProgress> list;
    private Context context;
    private int position;

    public LogisticsProgressAdapter(int layoutResId, @Nullable List<LogisticsProgress> data, Context context) {
        super(layoutResId, data);
        this.list = data;
        this.context = context;
        this.position = 1;
    }

    @Override
    protected void convert(ViewHolder helper, LogisticsProgress item) {
        if (position == list.size()) {
            helper.line2.setVisibility(View.INVISIBLE);
        }
        if (position == 1) {
            helper.line1.setVisibility(View.INVISIBLE);
            helper.ivStatus.setImageResource(R.drawable.xuanzhong);
            helper.tvContent.setTextColor(context.getResources().getColor(R.color.style_blue));
            helper.tvDate.setTextColor(context.getResources().getColor(R.color.style_blue));
        }
        helper.tvDate.setText(item.getDate());
        helper.tvContent.setText(item.getContent());
        position++;
    }

    protected class ViewHolder extends BaseViewHolder{
        @BindView(R.id.line1)
        View line1;
        @BindView(R.id.iv_status)
        ImageView ivStatus;
        @BindView(R.id.line2)
        View line2;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_date)
        TextView tvDate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
