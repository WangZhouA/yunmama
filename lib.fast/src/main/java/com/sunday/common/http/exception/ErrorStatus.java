package com.sunday.common.http.exception;

import com.sunday.common.error.CustomError;

/**
 * 错误状态
 */
public class ErrorStatus {

    public int code;
    public String msg;

    public ErrorStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorStatus(CustomError error){
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public ErrorStatus() {
    }

    public void setError(CustomError error){
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

}
