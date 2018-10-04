package com.sunday.common.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/6/23.
 */
public class BaseResponse<T> implements Serializable {

    private boolean success;
    private String message;
    private int code;

    @SerializedName("data")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("success:"+success).append("\tmessage:"+message);
        if(data != null)buffer.append("\tdata:"+data.toString());
        return buffer.toString();
    }
}
