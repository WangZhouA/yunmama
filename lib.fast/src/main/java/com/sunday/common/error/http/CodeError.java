package com.sunday.common.error.http;

import com.sunday.common.R;
import com.sunday.common.activity.BaseApplication;
import com.sunday.common.error.CustomError;

/**
 * 后台返回状态码枚举 1-100
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
public enum CodeError implements CustomError {

    CODE_UNKNOW(0, R.string.code_unknow),
    CODE1(1, R.string.code1),
    CODE2(2, R.string.code2),
    CODE3(3, R.string.code3),
    CODE4(4, R.string.code4),
    CODE5(5, R.string.code5),
    CODE6(6, R.string.code6),
    CODE7(7, R.string.code7),
    CODE8(8, R.string.code8),
    CODE9(9, R.string.code9),
    CODE10(10, R.string.code10),
    CODE11(11, R.string.code11),
    CODE12(12, R.string.code12),
    CODE13(13, R.string.code13),
    CODE14(14, R.string.code14),
    CODE15(15, R.string.code15),
    CODE16(16, R.string.code16),
    CODE17(17, R.string.code17),
    CODE18(18, R.string.code18),
    CODE19(19, R.string.code19),
    CODE20(20, R.string.code20),
    CODE21(21, R.string.code21),
    CODE22(22, R.string.code22),
    CODE23(23, R.string.code23),
    CODE24(24, R.string.code24),
    CODE25(25, R.string.code25),
    CODE26(26, R.string.code26),
    CODE27(27, R.string.code27),
    CODE28(28, R.string.code28),
    CODE29(29, R.string.code29),
    CODE30(30, R.string.code30),
    CODE31(31, R.string.code31),
    CODE32(32, R.string.code32),
    CODE33(33, R.string.code33),
    CODE34(34, R.string.code34),
    CODE35(35, R.string.code35),
    CODE36(36, R.string.code36),
    CODE37(37, R.string.code37),
    CODE38(38, R.string.code38),
    CODE39(39, R.string.code39);

    private int code;
    private int strId;

    CodeError(int code, int strId){
        this.code = code;
        this.strId = strId;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return BaseApplication.getInstance().getResources().getString(strId);
    }

    @Override
    public void setMsg(int strRes) {
        this.strId = strRes;
    }
}
