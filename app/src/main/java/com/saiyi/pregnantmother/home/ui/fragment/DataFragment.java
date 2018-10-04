package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.home.ui.data.AddFetalHeartActivity;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class DataFragment extends BKMVPFragment {

    @BindView(R.id.title_bar)
    NavBar titleBar;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static DataFragment newInstance() {
        DataFragment fragment = new DataFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        titleBar.hiddenLeftIcon();
        titleBar.setTitle(R.string.data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                openActivity(AddFetalHeartActivity.class);
                break;
        }
    }
}
