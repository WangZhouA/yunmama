package com.sunday.common.http.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 编码拦截器(UTF-8)
 */
public class CharsetInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String contentTypeHeads = request.header("Content-Type");
        if (TextUtils.isEmpty(contentTypeHeads)) {
            request.newBuilder()
                    .addHeader("Content-Type", "application/json; charset=UTF-8")
                    //.addHeader("Content-Type", "multipart/form-data; charset=UTF-8")
                    .build();
        }
        return chain.proceed(request);
    }
}
