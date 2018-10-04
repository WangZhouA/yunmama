package com.sunday.common.http.exception;

import java.io.IOException;

/**
 * 未读取到缓存信息
 */
public class GatewayTimeoutException extends IOException {

    public GatewayTimeoutException() {
        super("response code:504, the cache not find");
    }
}
