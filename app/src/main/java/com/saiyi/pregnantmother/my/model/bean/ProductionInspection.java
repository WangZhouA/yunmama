package com.saiyi.pregnantmother.my.model.bean;

public class ProductionInspection {
    private String time;
    private String content;
    private int status;
    private String date;


    public ProductionInspection(String time, String content, int status, String date) {
        this.time = time;
        this.content = content;
        this.status = status;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
