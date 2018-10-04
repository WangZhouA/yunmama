package com.saiyi.pregnantmother.login.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.action.Action;
import com.saiyi.pregnantmother.common.view.text.TextChangeWatcher;
import com.saiyi.pregnantmother.login.presenter.LoginPresenter;
import com.sunday.common.event.EventAction;
import com.sunday.common.utils.UiUtil;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BKMVPActivity<LoginPresenter> {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.logger_tv)
    TextView loggerTv;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_go_register)
    TextView tvGoRegist;
    @BindView(R.id.tv_forgot_pwd)
    TextView tvForgotPwd;

    private String registerPhone;

    @Override
    public LoginPresenter initPresenter(Context context) {
        return new LoginPresenter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        hiddenTitleBar();
        initPermission();
    }

    @Override
    protected void initView() {
        super.initView();
        registerEventBus();
        etPhone.addTextChangedListener(createTextWatcher(etPhone));
        etPwd.addTextChangedListener(createTextWatcher(etPwd));
    }

    public TextWatcher createTextWatcher(EditText et) {
        return new TextChangeWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etPwd.getText().toString().trim().length() >= 6 && etPhone.getText().toString().trim().length() == 11) {
                    tvLogin.setEnabled(true);
                } else {
                    tvLogin.setEnabled(false);
                }
            }
        };
    }

    private void initPermission() {
        RxPermissions rxPermission = new RxPermissions(this);
        rxPermission
                .requestEach(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                        }
                    }
                });
    }

    public void showErrorMsg(String msg) {
        UiUtil.setVisibility(loggerTv, View.VISIBLE);
        loggerTv.setText(msg);
    }

    public void showLoginLoading() {
        showCustomLoading(getString(R.string.logining));
    }

    public void dismissLoading() {
        dismissProgressDialog();
    }

    public void loginSuccess() {
        openActivity(SelectionTypeActivity.class);
//        if (!TextUtils.isEmpty(registerPhone) && etPhone.getText().toString().trim().equals(registerPhone)) {
//            //从注册来的登录，去完善资料
//            openActivity(SelectionTypeActivity.class);
//            back();
//        } else {
//            //直接登录
//            openActivity(HomeActivity.class);
//            back();
//        }
    }

    public void loginFaild(String msg) {
        toast(msg);
    }

    @OnClick(R.id.tv_login)
    public void onClickLogin(View view) {
        String uName = etPhone.getText().toString().trim();
        String uPwd = etPwd.getText().toString().trim();
        UiUtil.setVisibility(loggerTv, View.INVISIBLE);
        getPresenter().onLogin(uName, uPwd);
    }

    @OnClick(R.id.tv_go_register)
    public void onClickRegister(View view) {
        openActivityForResult(RegisterActivity.class, RegisterActivity.RESULT_REGISTER_REQUEST);
    }

    @OnClick(R.id.tv_forgot_pwd)
    public void onClickForgetPwd() {
        openActivity(ForgetPasswordActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RegisterActivity.RESULT_REGISTER_REQUEST) {
            if (data != null && data.getExtras() != null) {
                Bundle bundle = data.getExtras();
                //注册成功过来的，提示完善资料界面
                registerPhone = bundle.getString(RegisterActivity.BUNDLE_KEY_REGISTER_RESULT);
                etPhone.setText(registerPhone);
            }
        }
    }

    @Override
    public void onMessageEvent(EventAction event) {
        super.onMessageEvent(event);
        if (event == Action.ACTION_SUPPLEMENT_DONE) {
            back();
        }
    }

    /**
     * 按两次退出
     */
    private long mExitTime;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
               toast(getString(R.string.exit));
                mExitTime = System.currentTimeMillis();

            } else {
                send(Action.ACTION_EXIT);
                System.exit(0);

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
