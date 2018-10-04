package com.sunday.common.http;

import com.sunday.common.http.exception.ErrorStatus;

/**
 * Created by Administrator on 2018/3/19.
 */

public interface ResponseListener<T> {

    void onComplete();

    void onResponse(T data);

    void onFaild(ErrorStatus e);

}
