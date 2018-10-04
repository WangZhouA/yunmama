package com.sunday.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.sunday.common.cache.SharePerferenceHelper;

import java.util.Locale;

/**
 * Created by siwei on 2018/3/26.
 * https://blog.csdn.net/sinat_35721133/article/details/78327111
 * https://www.cnblogs.com/travellife/p/Android-ying-yong-nei-duo-yu-yan-qie-huan.html
 */
public class LanguageUtils {

    enum Language {
        ENGLISH,
        SIMPLIFIED_CHINESE;
    }

    private static final String SP_LANGUAGE_NAME = "language_name";
    private static final String KEY_LANGUAGE = "key_language";

    /**
     * 判断当前语言是否为中文
     */
    public static boolean isChinese(Context context) {
        Locale local = context.getResources().getConfiguration().locale;
        if (local.getLanguage().toLowerCase().endsWith("zh")) {//中文
            return true;
        }
        return false;
    }

    /**
     * 设置语言
     *
     * @param context
     * @param language
     */
    private static void switchLanguage(Context context, Language language) {
        //设置应用语言类型
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();

        if (language == Language.SIMPLIFIED_CHINESE) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        } else {
            config.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(config, dm);
        SharePerferenceHelper sharePerferenceHelper = SharePerferenceHelper.createSharePerference(SP_LANGUAGE_NAME);
        sharePerferenceHelper.putInt(KEY_LANGUAGE, language.ordinal());
    }

    /**
     * 中英文切换，如果当前是英文切中文，如果不是切英文
     *
     * @param context
     */
    public static void doSwitchLanguage(Context context) {
        SharePerferenceHelper sharePerferenceHelper = SharePerferenceHelper.createSharePerference(SP_LANGUAGE_NAME);
        int languageIndex = sharePerferenceHelper.getInt(KEY_LANGUAGE, -1);
        Language language;
        if (languageIndex < 0) {
            language = isChinese(context) ? Language.ENGLISH : Language.SIMPLIFIED_CHINESE;
        } else {
            language = languageIndex == 0 ? Language.SIMPLIFIED_CHINESE : Language.ENGLISH;
        }
        switchLanguage(context, language);
    }

    /**
     * 自动设置语言，如果有设置，把语言设置成已经设置过的
     *
     * @param context
     */
    public static void autoSwitchLanguage(Context context) {
        SharePerferenceHelper sharePerferenceHelper = SharePerferenceHelper.createSharePerference(SP_LANGUAGE_NAME);
        int languageIndex = sharePerferenceHelper.getInt(KEY_LANGUAGE, -1);
        Language language;
        if (languageIndex < 0) {
            language = isChinese(context) ? Language.SIMPLIFIED_CHINESE : Language.ENGLISH;
        } else {
            language = Language.values()[languageIndex];
        }
        switchLanguage(context, language);
    }
}
