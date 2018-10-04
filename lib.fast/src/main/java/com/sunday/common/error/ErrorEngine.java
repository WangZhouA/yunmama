package com.sunday.common.error;


import com.sunday.common.error.http.CodeHelper;
import com.sunday.common.error.http.HttpError;
import com.sunday.common.http.exception.ErrorStatus;
import com.sunday.common.http.exception.GatewayTimeoutException;

import org.apache.http.HttpException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.net.ssl.SSLException;


/**
 * 项目：智能控制     SmartLock
 */
public class ErrorEngine {

    public static ErrorStatus handleHttpException(Throwable t) {
        ErrorStatus apiException = new ErrorStatus();
        if (t instanceof HttpException) {
            apiException.setError(HttpError.HTTP_ERROR);
        } else if (t instanceof JSONException || t instanceof ParseException) {
            apiException.setError(HttpError.PARSE_ERROR);
        } else if (t instanceof ConnectException
                || t instanceof SocketTimeoutException
                || t instanceof GatewayTimeoutException) {
            apiException.setError(HttpError.NETWORD_ERROR);
        } else if (t instanceof UnknownHostException) {
            apiException.setError(HttpError.UNKNOW_HOST_ERROR);
        } else if (t instanceof SSLException) {
            apiException.setError(HttpError.SSL_ERROR);
        } else {
            apiException.setError(HttpError.UNKNOW);
        }
        return apiException;
    }

    public static ErrorStatus handleParamsException() {
        return new ErrorStatus(HttpError.PARAMS_ERROR);
    }

    public static ErrorStatus handleIdentifyError() {
        return new ErrorStatus(HttpError.SMS_IDENTIFY_ERROR);
    }

    public static ErrorStatus handleServiceResultError(int code){
        return CodeHelper.handleCodeError(code);
    }

    public static ErrorStatus handleCustomError(CustomError error){
        return new ErrorStatus(error);
    }

}
