package com.saiyi.pregnantmother.my.model.bean;

public class Notice {
    private String title;
    private String content;
    private int status;
    private long date;

    public Notice(String title, String content, int status, long date) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
