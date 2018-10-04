package com.sunday.common.error.http;

import com.sunday.common.error.CustomError;
import com.sunday.common.http.exception.ErrorStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 1  手机号或邮箱已注册
 * 2  手机号或邮箱未注册
 * 3  手机号或邮箱已注册
 * 4  发送验证码成功
 * 5  发送验证码失败
 * 6  手机或邮箱格式不正确
 * 7  用户不存在
 * 8  密码错误
 * 9  登录成功
 * 10 手机或邮箱不能为空
 * 11 请输入密码
 * 12 请输入验证码
 * 13 用户已注册
 * 14 用户未注册
 * 15 验证码错误
 * 16 注册成功
 * 17 找回密码成功
 * 18 上传失败
 * 19 上传成功
 * 20 旧密码错误
 * 21 修改失败
 * 22 修改成功
 * 23 没有数据
 * 24 查询成功
 * 25 记录不能为空
 * 26 删除失败
 * 27 删除成功
 * 28 反馈失败
 * 29 反馈成功
 * 30 设备绑定失败
 * 31 设备已绑定
 * 32 管理员密码错误
 * 33 删除设备失败
 * 34 添加成功
 * 35 该手机号未注册用户
 * 36 已添加钥匙给该用户
 * 37 添加失败
 * 38 设备钥匙已超过40
 * 39 该设备键盘密码已存在
 * </pre>
 */
public class CodeHelper {

    private final static Map<Integer, CustomError> codeMap = new HashMap<>();

    static {
        codeMap.put(1, CodeError.CODE1);
        codeMap.put(2, CodeError.CODE2);
        codeMap.put(3, CodeError.CODE3);
        codeMap.put(4, CodeError.CODE4);
        codeMap.put(5, CodeError.CODE5);
        codeMap.put(6, CodeError.CODE6);
        codeMap.put(7, CodeError.CODE7);
        codeMap.put(8, CodeError.CODE8);
        codeMap.put(9, CodeError.CODE9);
        codeMap.put(10, CodeError.CODE10);
        codeMap.put(11, CodeError.CODE11);
        codeMap.put(12, CodeError.CODE12);
        codeMap.put(13, CodeError.CODE13);
        codeMap.put(14, CodeError.CODE14);
        codeMap.put(15, CodeError.CODE15);
        codeMap.put(16, CodeError.CODE16);
        codeMap.put(17, CodeError.CODE17);
        codeMap.put(18, CodeError.CODE18);
        codeMap.put(19, CodeError.CODE19);
        codeMap.put(20, CodeError.CODE20);
        codeMap.put(21, CodeError.CODE21);
        codeMap.put(22, CodeError.CODE22);
        codeMap.put(23, CodeError.CODE23);
        codeMap.put(24, CodeError.CODE23);
        codeMap.put(25, CodeError.CODE25);
        codeMap.put(26, CodeError.CODE26);
        codeMap.put(27, CodeError.CODE27);
        codeMap.put(28, CodeError.CODE28);
        codeMap.put(29, CodeError.CODE29);
        codeMap.put(30, CodeError.CODE30);
        codeMap.put(31, CodeError.CODE31);
        codeMap.put(32, CodeError.CODE32);
        codeMap.put(33, CodeError.CODE33);
        codeMap.put(34, CodeError.CODE34);
        codeMap.put(35, CodeError.CODE35);
        codeMap.put(36, CodeError.CODE36);
        codeMap.put(37, CodeError.CODE37);
        codeMap.put(38, CodeError.CODE38);
        codeMap.put(39, CodeError.CODE39);
    }

    public static ErrorStatus handleCodeError(int code) {
        ErrorStatus exception = new ErrorStatus();
        if (codeMap.containsKey(code)) {
            exception.setError(codeMap.get(code));
        } else {
            exception.setError(CodeError.CODE_UNKNOW);
        }
        return exception;
    }

}
