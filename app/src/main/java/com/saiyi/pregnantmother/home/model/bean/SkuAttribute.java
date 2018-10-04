package com.saiyi.pregnantmother.home.model.bean;

import android.os.Parcelable;

public class SkuAttribute{
    private String id;
    private String value;
    private boolean isSelected;

    public SkuAttribute() {
    }

    public SkuAttribute(String id, String value, boolean isSelected) {
        this.id = id;
        this.value = value;
        this.isSelected = isSelected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
