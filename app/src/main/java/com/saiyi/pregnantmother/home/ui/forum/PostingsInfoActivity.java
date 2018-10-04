package com.saiyi.pregnantmother.home.ui.forum;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.home.adapter.CommentListAdapter;
import com.saiyi.pregnantmother.home.model.bean.Comment;
import com.saiyi.pregnantmother.login.model.bean.User;
import com.sunday.common.mvp.PresenterImpl;
import com.sunday.common.widgets.NoScrollListview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostingsInfoActivity extends BKMVPActivity {

    @BindView(R.id.nlv_comments)
    NoScrollListview lvComments;
    @BindView(R.id.et_comment)
    EditText etComment;
    @BindView(R.id.tv_send)
    TextView tvSend;

    private CommentListAdapter adapter;
    private Comment cComment;
    private User self = new User("18875900509");

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postings_info);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.forum_info);
        adapter = new CommentListAdapter(this);
        lvComments.setAdapter(adapter);
        this.cComment = new Comment();
        cComment.setCommentsUser(self);
        Comment comment = new Comment(0, "这个好，这个好", null, new User("左左"));
        Comment comment1 = new Comment(0, "我也觉得", new User("左左"), new User("右右"));
        adapter.addComment(comment);
        adapter.addComment(comment1);
        lvComments.setOnItemClickListener(onItemClickListener);
    }

    protected AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Comment comment = (Comment) adapter.getItem(position);
            etComment.setText("");
            etComment.setHint("@"+comment.getCommentsUser().getPhone());
            PostingsInfoActivity.this.cComment.setReplyUser(comment.getCommentsUser());
        }
    };


    @OnClick({R.id.et_comment, R.id.tv_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_comment:
                cComment.setReplyUser(null);
                break;
            case R.id.tv_send:
                cComment.setContent(etComment.getText().toString().trim());
                adapter.addComment(cComment);
                cComment = new Comment();
                etComment.setHint("");
                etComment.setText("");
                tvSend.setFocusable(true);
                break;
        }
    }
}
