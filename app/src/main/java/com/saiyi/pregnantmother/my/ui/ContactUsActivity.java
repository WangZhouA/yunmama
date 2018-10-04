package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.text.TextChangeWatcher;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactUsActivity extends BKMVPActivity {

    @BindView(R.id.et_feedback)
    EditText etFeedback;
    @BindView(R.id.tv_sbumit)
    TextView tvSbumit;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.contact_us);
        etFeedback.addTextChangedListener(new TextChangeWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    tvSbumit.setEnabled(true);
                } else {
                    tvSbumit.setEnabled(false);
                }
            }
        });
    }

    @OnClick(R.id.tv_sbumit)
    public void onClickedSbumit() {
        toast("提交成功");
        back();
    }
}
