package com.sunday.common.error.http;

import com.sunday.common.R;
import com.sunday.common.activity.BaseApplication;
import com.sunday.common.error.CustomError;

/**
 * Http 自定义异常
 * code 1000-1500
 */
public enum HttpError implements CustomError {

    /**
     * 未知错误
     */
    UNKNOW(1000, R.string.UNKNOW),

    /**
     * 解析错误
     */
    PARSE_ERROR(1001, R.string.PARSE_ERROR),

    /**
     * 网络错误
     */
    NETWORD_ERROR(1002, R.string.NETWORD_ERROR),

    /**
     * 协议出错
     */
    HTTP_ERROR(1003, R.string.HTTP_ERROR),

    /**
     * 证书出错
     */
    SSL_ERROR(1005, R.string.SSL_ERROR),

    /**
     * 参数错误
     */
    PARAMS_ERROR(1006, R.string.PARAMS_ERROR),

    /**
     * 提取验证码失败
     */
    SMS_IDENTIFY_ERROR(1007, R.string.SMS_IDENTIFY_ERROR),

    /***/
    UNKNOW_HOST_ERROR(1008, R.string.UNKNOW_HOST_ERROR);

    private int strRes;
    private int code;

    HttpError(int code, int strRes) {
        this.code = code;
        this.strRes = strRes;
    }

    public String getMsg() {
        return BaseApplication.getInstance().getResources().getString(strRes);
    }

    public void setMsg(int strRes) {
        this.strRes = strRes;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
