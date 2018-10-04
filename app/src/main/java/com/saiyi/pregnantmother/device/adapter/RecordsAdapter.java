package com.saiyi.pregnantmother.device.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.device.model.bean.FetalMoveRecordBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordsAdapter extends BaseQuickAdapter<FetalMoveRecordBean, RecordsAdapter.ViewHolder> {

    public RecordsAdapter(int layoutResId, @Nullable List<FetalMoveRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, FetalMoveRecordBean item) {
        helper.tvDate.setText(item.getDate());
        helper.tvTime.setText(item.getTime());
        helper.tvFrequency.setText(item.getFrequency() + "");
        int status = item.getStatus();
        if(status == 0){
            helper.tvStatus.setText( mContext.getString(R.string.normal));
            helper.tvStatus.setTextColor( mContext.getResources().getColor(R.color.style_blue));
            helper.tvStatus.setBackground( mContext.getResources().getDrawable(R.drawable.hundreddp_btn_bg_blue_shape));
        }else {
            helper.tvStatus.setText( mContext.getString(R.string.abnormal));
            helper.tvStatus.setTextColor( mContext.getResources().getColor(R.color.style_red));
            helper.tvStatus.setBackground( mContext.getResources().getDrawable(R.drawable.hundreddp_btn_bg_pink_shape));
        }

    }

    protected class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_date)
        TextView tvDate;

        @BindView(R.id.tv_time)
        TextView tvTime;

        @BindView(R.id.tv_frequency)
        TextView tvFrequency;

        @BindView(R.id.tv_status)
        TextView tvStatus;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
