package com.saiyi.pregnantmother.app;

import android.content.Context;

import com.saiyi.pregnantmother.R;
import com.sunday.common.config.IBuildConfig;
import com.sunday.common.utils.AppUtil;
import com.sunday.common.utils.StringUtils;

/**
 * Created by Administrator on 2018/3/16.
 */

public class PMBuildConfig implements IBuildConfig {

    private static final boolean DEBUG = true;//当前是否为debug版本

    private static final String BASE_DEBUG_HTTP_URL = "暂时为空";//debug版本下的请求地址
    private static final String BASE_HTTP_URL = "暂时为空";//客户公司的请求地址

    @Override
    public boolean isDebug() {
        return DEBUG;
    }

    @Override
    public String getHttpBaseUrl() {
        return DEBUG ? BASE_DEBUG_HTTP_URL : BASE_HTTP_URL;
    }

    @Override
    public int getVersionCode(Context context) {
        return AppUtil.getVersionCode(context);
    }

    @Override
    public String getVersionName(Context context) {
        return AppUtil.getVersionName(context);
    }

    @Override
    public String getAppName(Context context) {
        return StringUtils.getStringByResource(context, R.string.app_name);
    }
}
