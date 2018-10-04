package com.saiyi.pregnantmother.my.model.bean;

/**
 * Created by JingNing on 2018-07-09 11:41
 */
public class LogisticsProgress {
    private String content;
    private String date;

    public LogisticsProgress(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
