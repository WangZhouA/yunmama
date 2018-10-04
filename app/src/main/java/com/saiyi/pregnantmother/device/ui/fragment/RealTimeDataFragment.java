package com.saiyi.pregnantmother.device.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.device.tools.ChartUtils;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RealTimeDataFragment extends BKMVPFragment {

    @BindView(R.id.line_chart)
    LineChart lineChart;
    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static RealTimeDataFragment newInstance() {
        RealTimeDataFragment fragment = new RealTimeDataFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_real_time_data, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        ChartUtils.initChart(lineChart);
        ChartUtils.notifyDataSetChanged(lineChart, getData());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private List<Entry> getData() {
        List<Entry> values = new ArrayList<>();
        for(int i=0;i<11;i++){
            values.add(new Entry(i, (float) (Math.random()*260)-60));
        }
        return values;
    }
}
