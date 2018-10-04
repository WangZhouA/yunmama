package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.CountDownView;
import com.saiyi.pregnantmother.common.view.text.TextChangeWatcher;
import com.saiyi.pregnantmother.login.presenter.ForgetPasswordPresenter;
import com.sunday.common.utils.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPasswordActivity extends BKMVPActivity<ForgetPasswordPresenter> {

    private final int COUNT_DOWN_SECOUND = 60;//倒计时60s

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_valid_code)
    EditText etValidCode;
    @BindView(R.id.cdv_valid_code)
    CountDownView cdvValidCode;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_password_pre)
    EditText etPasswordPre;
    @BindView(R.id.logger_tv)
    TextView loggerTv;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    private boolean isGetCodeing; //正在获取验证码

    @Override
    public ForgetPasswordPresenter initPresenter(Context context) {
        return new ForgetPasswordPresenter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //基本和注册界面类似，用注册界面
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.noEndLine();
        tvTitle.setText(R.string.back_password);
        etPhone.addTextChangedListener(etPhoneTextWatcher);
        etPhone.addTextChangedListener(createTextWatcher(etPhone));
        etValidCode.addTextChangedListener(createTextWatcher(etValidCode));
        etPwd.addTextChangedListener(createTextWatcher(etPwd));
        etPasswordPre.addTextChangedListener(createTextWatcher(etPasswordPre));
    }

    private TextWatcher etPhoneTextWatcher = new TextChangeWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //手机号码长度
            if (s.length() == 11) {
                if (!isGetCodeing) {
                    cdvValidCode.setEnabled(true);
                }
            } else {
                cdvValidCode.setEnabled(false);
            }
        }
    };

    public TextWatcher createTextWatcher(EditText et) {
        return new TextChangeWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etPhone.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etValidCode.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etPwd.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etPasswordPre.getText().toString().trim())) {
                    tvRegister.setEnabled(true);
                } else {
                    tvRegister.setEnabled(false);
                }
            }
        };
    }

    public void showErrorMsg(String msg) {
        UiUtil.setVisibility(loggerTv, View.VISIBLE);
        loggerTv.setText(msg);
    }

    /**
     * 获取验证码成功
     */
    public void getValidCodeSuccess(String msg) {
        startCountDown();
        toast(msg);
    }

    /**
     * 开始倒计时
     */
    public void startCountDown() {
        cdvValidCode.startCountDown(COUNT_DOWN_SECOUND, mCallback);
    }

    CountDownView.CountDownCallBack mCallback = new CountDownView.CountDownCallBack() {
        @Override
        public void onCountDown(int second) {
            cdvValidCode.setText(String.format(getString(R.string.count_str), String.valueOf(second)));
        }

        @Override
        public void onCountComplate() {
            isGetCodeing = false;
            cdvValidCode.setText(getString(R.string.send_valid_code));
            if (etPhone.getText().toString().trim().length() == 11) {
                cdvValidCode.setEnabled(true);
            } else {
                cdvValidCode.setEnabled(false);
            }
        }
    };

    /**
     * 获取验证码失败
     */
    public void getValidCodeFaild(String msg) {
        isGetCodeing = false;
        cdvValidCode.setEnabled(true);
        cdvValidCode.setText(getString(R.string.send_valid_code));
        toast(msg);
    }

    public void showLoadingDialog() {
        showCustomLoading(getString(R.string.registering));
    }

    public void onRegisteFaild(String msg) {
        //loading取消
        dismissProgressDialog();
        toast(msg);
    }

    public void onRegisterSuccess(String msg) {
        dismissProgressDialog();
        toast(msg);
        back();
    }

    @OnClick(R.id.cdv_valid_code)
    protected void onClickGetValidCode(View view) {
        UiUtil.setVisibility(loggerTv, View.INVISIBLE);
        String phone = etPhone.getText().toString().trim();
        if (getPresenter().getValidCode(phone)) {
            isGetCodeing = true;
            cdvValidCode.setEnabled(false);
            cdvValidCode.setText(getString(R.string.sending));
        }
    }

    @OnClick(R.id.tv_register)
    protected void onClickBackPwd(View view) {
        UiUtil.setVisibility(loggerTv, View.INVISIBLE);
        getPresenter().backPwd(etPhone.getText().toString(),
                etPwd.getText().toString(),
                etPasswordPre.getText().toString(),
                etValidCode.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cdvValidCode.release();
    }
}
