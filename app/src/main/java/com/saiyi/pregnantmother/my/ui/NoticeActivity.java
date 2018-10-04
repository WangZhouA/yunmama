package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.my.adapter.NoticeListAdapter;
import com.saiyi.pregnantmother.my.model.bean.Notice;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NoticeActivity extends BKMVPActivity {


    @BindView(R.id.rv_notice)
    RecyclerView rvNotice;

    private NoticeListAdapter adapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.notice_bulletin);
        rvNotice.setLayoutManager(new LinearLayoutManager(this));
        List<Notice> notices = new ArrayList<>();
        Notice notice = new Notice("公告", "公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容公告内容", 1, System.currentTimeMillis());
        notices.add(notice);
        notices.add(notice);
        adapter = new NoticeListAdapter(R.layout.item_notice, notices);
        rvNotice.setAdapter(adapter);
    }
}
