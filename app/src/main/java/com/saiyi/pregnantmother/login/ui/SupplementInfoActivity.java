package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.model.UserHelper;
import com.saiyi.pregnantmother.common.view.text.TextChangeWatcher;
import com.saiyi.pregnantmother.login.presenter.SupplementInfoPresenter;
import com.sunday.common.utils.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SupplementInfoActivity extends BKMVPActivity<SupplementInfoPresenter> {
    /**
     * 用户类型，辣妈？ 孕妇？
     */
    public static final String BUNDLE_KEY_TYPE = "bundle_key_type";
    /**
     * 孕妇
     */
    public static final int BUNDLE_VALUE_PREGNANT = 1;
    /**
     * 辣妈
     */
    public static final int BUNDLE_VALUE_MOTHER = 2;

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.ll_expected_date_childbirth)
    LinearLayout llExpectedDateChildbirth;
    @BindView(R.id.et_baby_birthday)
    EditText etBabyBirthday;
    @BindView(R.id.ll_baby_birthday)
    LinearLayout llBabyBirthday;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.logger_tv)
    TextView loggerTv;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private int userType = BUNDLE_VALUE_PREGNANT;

    @Override
    public SupplementInfoPresenter initPresenter(Context context) {
        return new SupplementInfoPresenter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement_info);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.noEndLine();
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            toast(getString(R.string.unknown_error));
            back();
            return;
        }
        userType = bundle.getInt(BUNDLE_KEY_TYPE);

        if (userType == BUNDLE_VALUE_PREGNANT) {
            llBabyBirthday.setVisibility(View.GONE);
            llExpectedDateChildbirth.setVisibility(View.VISIBLE);
        } else {
            llBabyBirthday.setVisibility(View.VISIBLE);
            llExpectedDateChildbirth.setVisibility(View.GONE);
        }
        etPhone.setText(UserHelper.instance().getUser().getPhone());
    }

    @Override
    protected void initListener() {
        super.initListener();
        etName.addTextChangedListener(createTextWatcher(etName));
        etDate.addTextChangedListener(createTextWatcher(etDate));
        etBabyBirthday.addTextChangedListener(createTextWatcher(etBabyBirthday));
    }

    public TextWatcher createTextWatcher(EditText et) {
        return new TextChangeWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (userType == BUNDLE_VALUE_PREGNANT) {
                    if (!TextUtils.isEmpty(etPhone.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etName.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etDate.getText().toString().trim())) {
                        tvConfirm.setEnabled(true);
                    } else {
                        tvConfirm.setEnabled(false);
                    }
                } else {
                    if (!TextUtils.isEmpty(etPhone.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etName.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etBabyBirthday.getText().toString().trim())) {
                        tvConfirm.setEnabled(true);
                    } else {
                        tvConfirm.setEnabled(false);
                    }
                }
            }
        };
    }

    public void showLoadingDialog() {
        showCustomLoading(getString(R.string.submiting));
    }

    public void dismissLoading() {
        dismissProgressDialog();
    }

    public void showErrorMsg(String msg) {
        UiUtil.setVisibility(loggerTv, View.VISIBLE);
        loggerTv.setText(msg);
    }

    @OnClick(R.id.tv_confirm)
    public void onClickConfirm(View view) {
        String date;
        if (userType == BUNDLE_VALUE_PREGNANT) {
            date = etDate.getText().toString().trim();
        } else {
            date = etBabyBirthday.getText().toString().trim();
        }
        getPresenter().updateUserDate(etName.getText().toString().trim(),
                etAge.getText().toString().trim(),
                etPhone.getText().toString().trim(),
                date, etAddress.getText().toString().trim(),
                userType);
    }

    public void onSupplementInfoSuccess(String msg) {
        openActivity(SelectDoctorActivity.class);
        back();
        toast(msg);
    }

    public void onSupplementInfoFaild(String msg) {
        toast(msg);
    }

    @OnClick(R.id.tv_calculation)
    public void onClickCalculation(View view) {
        openActivity(CalculationActivity.class);
    }
}
