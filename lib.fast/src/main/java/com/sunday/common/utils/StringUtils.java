package com.sunday.common.utils;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.text.TextUtils;

import com.sunday.common.activity.BaseApplication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/6/23.
 */
public class StringUtils {

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() == 0 && str1.length() == str2.length()) return true;
        return str1.equalsIgnoreCase(str2);
    }


    public static boolean equals(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() == str2.length() && str1.length() == 0) return true;
        return str1.equals(str2);
    }

    /**
     * 匹配指定长度的字母和数字
     */
    public static boolean matchLengthLetterAndNum(String str, int length) {
        if (TextUtils.isEmpty(str)) return false;
        String regex = "[a-z0-9A-Z]{" + length + "}";
        return str.matches(regex);
    }

    /**
     * 匹配指定长度的数字
     */
    public static boolean matchLengthNum(String str, int length) {
        if (TextUtils.isEmpty(str)) return false;
        String numRegex = "^\\d{" + length + "}$";
        return str.matches(numRegex);
    }

    /**
     * 判断当前是否为数字
     */
    public static boolean matchNum(String str) {
        if (TextUtils.isEmpty(str)) return false;
        String numRegex = "^\\d+$";
        return str.matches(numRegex);
    }

    /**
     * 匹配账号密码格式
     */
    public static boolean matchesUserPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) return false;
        String userPwdRegex = "[a-z0-9A-Z]{6,12}";
        return pwd.matches(userPwdRegex);
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNum(String mobiles) {
        /*
        移动：134、135、136、137、138、139、147、150、151、157(TD)、158、159、187、188, 198
		联通：130、131、132、152、155、156、185、186、166
		电信：133、153、180、189、199、（1349卫通）
		总结起来就是第一位必定为1，第二位必定为345678，其他位置的可以为0-9
		*/
        //"[1]"代表第1位为数字1，"[345678]"代表第二位可以为3、4、5、6、7、8、9中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "^[1][3456789]\\d{9}$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 验证邮箱地址是否正确
     */
    public static boolean isEmailAddress(String address) {
        if (TextUtils.isEmpty(address)) return false;
        String emailRegex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return address.matches(emailRegex);
    }

    /**
     * 获取手机号的省略版手机号如:152****9452
     */
    public static String getOmitTelStr(String telStr) {
        if (TextUtils.isEmpty(telStr)) return "";
        if (isMobileNum(telStr)) {
            //电话号码的3-6位省略
            return hiddenStr(telStr, 3, 6, '*');
        }
        return telStr;
    }

    /**
     * 隐藏指定范围的字符为*号
     */
    public static String hiddenStr(String str, int start, int end, char placeChar) {
        if (TextUtils.isEmpty(str)) return "";
        int startIndex = Math.max(0, start);
        int endIndex = Math.min(end, str.length());
        StringBuffer sb = new StringBuffer(str);
        for (int i = startIndex; i <= endIndex; i++) {
            sb.setCharAt(i, placeChar);
        }
        return sb.toString();
    }

    /**
     * 提取短信验证码(通过提取指定长度的数字的方式)
     */
    public static String getIdentifyCode(String smsBody, int codeLength) {
        Pattern pattern = Pattern.compile("\\d{" + codeLength + "}");
        Matcher matcher = pattern.matcher(smsBody);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static String listToString(Set<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String inputStreamToString(InputStream in) {
        StringBuffer out = new StringBuffer();
        try {
            byte[] b = new byte[4096];
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return out.toString();
        }
        return out.toString();
    }


    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    //  把 map 集合转化成 string
    public static String mapToString(HashMap<String, String> map) {
//        Iterator it = emails.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry m=(Map.Entry)it.next();
//            logger.info("email-" + m.getKey() + ":" + m.getValue());
//        }
        String str = "?";
        boolean flag = false;
        StringBuilder result = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            if (flag) {
                result.append("&");
            } else {
                flag = true;
            }
            result.append(m.getKey() + "=" + m.getValue());

        }
        return str + result.toString();
    }

    public static String getStringByResource(Context context, int strRes) {
        if (context != null) {
            return context.getResources().getString(strRes);
        }
        return "";
    }

    public static String getStringByResource(int strRes) {
        return getStringByResource(BaseApplication.getInstance().getApplicationContext(), strRes);
    }

    public static String getStringFormatByResource(int strRes, Object... args) {
        return String.format(getStringByResource(BaseApplication.getInstance().getApplicationContext(), strRes), args);
    }
}
