package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈姣姣 on 2018/7/9.
 */
public class MessageActivity extends BKMVPActivity {
    @BindView(R.id.Lin_msg)
    LinearLayout LinMsg;
    @BindView(R.id.recyViewTuWen)
    RecyclerView recyViewTuWen;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mTitleBar.setTitle(R.string.msg);
    }

    @OnClick(R.id.Lin_msg)
    public void onViewClicked() {
        openActivity(ChatActivity.class);
    }
}
