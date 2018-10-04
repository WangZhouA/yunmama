package com.saiyi.pregnantmother.home.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.model.bean.Comment;
import com.saiyi.pregnantmother.login.model.bean.User;
import com.sunday.common.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CommentListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context context;
    private List<Comment> mDatas;



    public CommentListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<Comment>();
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
            convertView = mInflater.inflate(R.layout.item_comment, parent, false);
            holder = new ViewHolder();
            holder.ivHeadImg = (ImageView) convertView.findViewById(R.id.iv_head_img);
            holder.commentUname = (TextView) convertView.findViewById(R.id.tv_comment_uname);
            holder.reply = (TextView) convertView.findViewById(R.id.tv_reply);
            holder.replyUname = (TextView) convertView.findViewById(R.id.tv_reply_uname);
            holder.content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Comment comment = mDatas.get(position);
        User commentUser = comment.getCommentsUser();
        if (commentUser != null) {
            //如果头像有信息显示头像
            //显示评论者的名称
            holder.commentUname.setText(commentUser.getPhone());
        }
        User replyUser = comment.getReplyUser();
        if (replyUser != null) {
            holder.reply.setVisibility(View.VISIBLE);
            holder.replyUname.setVisibility(View.VISIBLE);
            holder.replyUname.setText(" "+replyUser.getPhone()+": ");
        } else {
            holder.reply.setVisibility(View.GONE);
            holder.replyUname.setVisibility(View.GONE);
        }
        holder.content.setText(comment.getContent());
        return convertView;
    }

    private class ViewHolder {
        ImageView ivHeadImg;
        TextView commentUname;
        TextView reply;
        TextView replyUname;
        TextView content;
        TextView date;
    }

    public void addComment(Comment comment) {
        mDatas.add(comment);
        notifyDataSetChanged();
    }

    public void refreshComment(List<Comment> comments) {
        mDatas.clear();
        mDatas.addAll(comments);
        notifyDataSetChanged();
    }
}
