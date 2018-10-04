package com.saiyi.pregnantmother.home.model.bean;

import com.saiyi.pregnantmother.login.model.bean.User;

public class Comment {
    private int commentsId;
    private String content;
    private User replyUser; // 回复人信息
    private User commentsUser;  // 评论人信息

    public Comment() {
    }

    public Comment(int commentsId, String content, User replyUser, User commentsUser) {
        this.commentsId = commentsId;
        this.content = content;
        this.replyUser = replyUser;
        this.commentsUser = commentsUser;
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    public User getCommentsUser() {
        return commentsUser;
    }

    public void setCommentsUser(User commentsUser) {
        this.commentsUser = commentsUser;
    }
}
