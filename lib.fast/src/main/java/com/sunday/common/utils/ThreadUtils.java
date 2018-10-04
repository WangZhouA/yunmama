package com.sunday.common.utils;

import android.os.Build;
import android.os.HandlerThread;

/**
 * 线程工具类
 */
public class ThreadUtils {

    /**
     * 安全退出HandlerThread
     */
    public static void quitSafely(HandlerThread thread) {
        if (thread != null && thread.isAlive()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                thread.quitSafely();
            } else {
                thread.quit();
            }
        }
    }
}
