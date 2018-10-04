package com.saiyi.pregnantmother.home.model.bean;

import java.io.Serializable;

public class Course implements Serializable{
    private String imgFile;
    private String title;
    private String price;
    private String introduction;

    public Course(String imgFile, String title, String price, String introduction) {
        this.imgFile = imgFile;
        this.title = title;
        this.price = price;
        this.introduction = introduction;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
