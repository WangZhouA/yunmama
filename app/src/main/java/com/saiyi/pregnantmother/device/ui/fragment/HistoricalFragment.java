package com.saiyi.pregnantmother.device.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.device.adapter.RecordsAdapter;
import com.saiyi.pregnantmother.device.model.bean.FetalMoveRecordBean;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HistoricalFragment extends BKMVPFragment {

    @BindView(R.id.rv_data)
    RecyclerView rvData;

    private RecordsAdapter adapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static HistoricalFragment newInstance() {
        HistoricalFragment fragment = new HistoricalFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historical, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        List<FetalMoveRecordBean> recordBeans = new ArrayList<FetalMoveRecordBean>();
        recordBeans.add(new FetalMoveRecordBean("04/20", "17:42:35", 5, 0));
        recordBeans.add(new FetalMoveRecordBean("04/20", "17:45:12", 2, 1));
        adapter = new RecordsAdapter(R.layout.item_fetal_move_record, recordBeans);
        rvData.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
