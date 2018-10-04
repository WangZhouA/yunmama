package com.saiyi.pregnantmother.device.model.bean;

public class FetalMoveRecordBean {
    private String date;
    private String time;
    private int frequency;
    private int status;

    public FetalMoveRecordBean(String date, String time, int frequency, int status) {
        this.date = date;
        this.time = time;
        this.frequency = frequency;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
