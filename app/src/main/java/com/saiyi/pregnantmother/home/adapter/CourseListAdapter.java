package com.saiyi.pregnantmother.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.Course;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseListAdapter extends BaseQuickAdapter<Course, CourseListAdapter.CourseViewHolder> {

    private List<Course> courses;

    public CourseListAdapter(int layoutResId, @Nullable List<Course> data) {
        super(layoutResId, data);
        this.courses = data;
    }

    @Override
    protected void convert(CourseViewHolder helper, Course item) {
        helper.tvTitle.setText(item.getTitle());
        helper.tvPrice.setTextColor(item.getPrice().equals("免费") ? mContext.getResources().getColor(R.color.style_blue) : mContext.getResources().getColor(R.color.style_red));
        helper.tvPrice.setText(item.getPrice());
        helper.tvIntroduction.setTag(item.getIntroduction());
    }

    protected class CourseViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_introduction)
        TextView tvIntroduction;

        public CourseViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
