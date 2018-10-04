package com.saiyi.pregnantmother.app;

import android.support.annotation.NonNull;
import com.sunday.common.activity.BaseApplication;
import com.sunday.common.config.IBuildConfig;

/**
 * Created by siwei on 2018/3/16.
 */

public class PMApplication extends BaseApplication {

    @NonNull
    @Override
    public IBuildConfig getBuildConfig() {
        return new PMBuildConfig();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
