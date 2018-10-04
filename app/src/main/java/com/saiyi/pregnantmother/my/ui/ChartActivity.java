package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.my.adapter.NoticeListAdapter;
import com.saiyi.pregnantmother.my.adapter.ProductionInspectionAdapter;
import com.saiyi.pregnantmother.my.model.bean.Notice;
import com.saiyi.pregnantmother.my.model.bean.ProductionInspection;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChartActivity extends BKMVPActivity {


    @BindView(R.id.rv_productioninspection)
    RecyclerView rvProductioninspection;

    private ProductionInspectionAdapter adapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.registration_production_inspection);
        rvProductioninspection.setLayoutManager(new LinearLayoutManager(this));
        List<ProductionInspection> list = new ArrayList<>();
        ProductionInspection inspection = new ProductionInspection("怀孕1个月", "体重、血压、腹围、宫高、血常规、尿常规、白带常规、肝功能", 1, "2018-03-14");
        list.add(inspection);
        list.add(inspection);
        adapter = new ProductionInspectionAdapter(R.layout.item_inspection, list);
        rvProductioninspection.setAdapter(adapter);
    }
}
