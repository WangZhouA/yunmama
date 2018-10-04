package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.my.adapter.LogisticsProgressAdapter;
import com.saiyi.pregnantmother.my.model.bean.LogisticsProgress;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JingNing on 2018-07-07 11:26
 */
public class LogisticsAcvtivity extends BKMVPActivity {

    @BindView(R.id.iv_img)
    ImageView ivImg;

    @BindView(R.id.tv_company)
    TextView tvCompany;

    @BindView(R.id.tv_code)
    TextView tvCode;

    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @BindView(R.id.rv_process)
    RecyclerView rvProcess;


    private LogisticsProgressAdapter progressAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.logistics);
        rvProcess.setLayoutManager(new LinearLayoutManager(this));
        List<LogisticsProgress> list = new ArrayList<>();
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXXXXX 已签收 签收人：XXXXXXXXXXXXXXXXX", "2017/03/31 12:50:28"));
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXXXXX进行派件扫描；派件员：XXX；联系电话：13568954856", "2017/03/31 12:50:28"));
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXX 已收入", "2017/03/31 12:50:28"));
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXXXXX 已发出下一站 XXXXXXX", "2017/03/31 12:50:28"));
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXXXXX 已发出下一站 XXXXXXX", "2017/03/31 12:50:28"));
        list.add(new LogisticsProgress("XXXXXXXXXXXXXXXXX 已收入", "2017/03/31 12:50:28"));
        progressAdapter = new LogisticsProgressAdapter(R.layout.item_logistics_process, list, this);
        rvProcess.setAdapter(progressAdapter);
    }
}
