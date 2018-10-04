package com.sunday.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.sunday.common.R;

/**
 * Created by Administrator on 2015/8/12.
 */
public class PhoneUtils {

    @SuppressLint("MissingPermission")
    public static String getIMEI(Context context){
        TelephonyManager telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    @SuppressLint("MissingPermission")
    public static String getIMSI(Context context){
        TelephonyManager telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSubscriberId();
    }
}
