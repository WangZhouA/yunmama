package com.saiyi.pregnantmother.my.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.my.model.bean.Notice;
import com.sunday.common.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticeListAdapter extends BaseQuickAdapter<Notice, NoticeListAdapter.ViewHolder> {


    public NoticeListAdapter(int layoutResId, @Nullable List<Notice> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, Notice item) {
        helper.tvDate.setText(DateUtils.formatLogDate(item.getDate()));
        helper.ivStatus.setVisibility(item.getStatus() == 0 ? View.VISIBLE : View.GONE);
        helper.tvTitle.setText(item.getTitle());
        helper.tvContent.setText(item.getContent());
    }

    protected class ViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_status)
        ImageView ivStatus;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_date)
        TextView tvDate;

        @BindView(R.id.tv_content)
        TextView tvContent;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
