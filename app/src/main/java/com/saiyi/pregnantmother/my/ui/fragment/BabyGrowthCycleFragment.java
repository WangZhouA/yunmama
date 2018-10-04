package com.saiyi.pregnantmother.my.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.common.tools.DateUtils;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BabyGrowthCycleFragment extends BKMVPFragment {

    @BindView(R.id.iv_baby)
    ImageView ivBaby;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_mm)
    TextView tvMm;
    @BindView(R.id.tv_gram)
    TextView tvGram;
    @BindView(R.id.tv_details)
    TextView tvDetails;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static BabyGrowthCycleFragment newInstance() {
        BabyGrowthCycleFragment fragment = new BabyGrowthCycleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baby_growth_cycle, container, false);
        return view;
    }

    public void upDataDate(String toDayDate, String date) {
        if (!toDayDate.equals(date) && ivBaby != null) {
            ivBaby.setImageResource(R.drawable.b13_16);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
