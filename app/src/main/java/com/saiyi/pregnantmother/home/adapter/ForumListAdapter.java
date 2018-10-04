package com.saiyi.pregnantmother.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.Course;
import com.saiyi.pregnantmother.home.model.bean.Forum;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForumListAdapter extends BaseQuickAdapter<Forum, ForumListAdapter.CourseViewHolder> {

    private List<Forum> forums;

    public ForumListAdapter(int layoutResId, @Nullable List<Forum> data) {
        super(layoutResId, data);
        this.forums = data;
    }

    @Override
    protected void convert(CourseViewHolder helper, Forum item) {

    }

    protected class CourseViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;

        public CourseViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
