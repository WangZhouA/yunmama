package com.saiyi.pregnantmother.home.model.bean;

public class Goods {
    private String image;
    private String name;
    private int present_price; //现价
    private int original_price;//原价

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPresent_price() {
        return present_price;
    }

    public void setPresent_price(int present_price) {
        this.present_price = present_price;
    }

    public int getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }
}
