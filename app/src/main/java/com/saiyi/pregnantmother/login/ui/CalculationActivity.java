package com.saiyi.pregnantmother.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.wheelview.DataPickBuilder;
import com.saiyi.pregnantmother.common.view.wheelview.DataPickInterface;
import com.saiyi.pregnantmother.common.view.wheelview.DataPickView;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculationActivity extends BKMVPActivity {

    @BindView(R.id.tv_expected_date_childbirth)
    TextView tvExpectedDateChildbirth;
    @BindView(R.id.tv_calculation)
    TextView tvCalculation;
    @BindView(R.id.tv_menstruation_date)
    TextView tvMenstruationDate;
    @BindView(R.id.tv_menstruation_cycle)
    TextView tvMenstruationCycle;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_baby_been_born)
    TextView tvBabyBeenBorn;
    @BindView(R.id.wv_cancel_tv)
    TextView wvCancelTv;
    @BindView(R.id.wv_confirm_tv)
    TextView wvConfirmTv;
    @BindView(R.id.port_type_wv_ll)
    LinearLayout portTypeWvLl;

    private DataPickView dataPickView;
    private boolean[] mPickTypes = null;
    private String[] mPickTexts = null;
    private List<List<String>> mPickLists = null;

    private boolean isChildbirth;   //是点击预产期出来的日期选择

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mTitleBar.setTitle(R.string.expected_date_childbirth);
    }

    @Override
    protected void initView() {
        super.initView();
        initWheelView();
    }

    public void initWheelView() {
        if (mPickLists == null) {
            mPickLists = new ArrayList<>();//显示每一个滑动控件的数据
        } else {
            mPickLists.clear();
        }
        mPickTypes = new boolean[]{true, true, true, false, false, false};//是否显示异常每一个滑动控件
        mPickTexts = new String[]{"年", "月", "日", "", "", ""};//每一个滑动控件旁边的描述文字

        //调用方式2
        dataPickView = new DataPickBuilder(this).setShowType(2).setDadaPickInterface(new DataPickInterface() {
            @Override
            public boolean[] getIsVisiables() {
                return mPickTypes;
            }

            @Override
            public String[] getVisiableText() {
                return mPickTexts;
            }

            @Override
            public List<List<String>> getAdapter() {
                return mPickLists;
            }

            @Override
            public Calendar getSelectIndexs() {
                //2018-04-22
                Calendar selectedDate = Calendar.getInstance();
                int year = 0;
                int month = 0;
                int day = 0;
                try {
//                    year = Integer.parseInt(mUpdateData.substring(0, mUpdateData.indexOf("-")));
//                    month = Integer.parseInt(mUpdateData.substring(mUpdateData.indexOf("-") + 1, mUpdateData.lastIndexOf("-")));
//                    day = Integer.parseInt(mUpdateData.substring(mUpdateData.lastIndexOf("-") + 1, mUpdateData.length()));
                } catch (Exception e) {
                    return null;
                }

                selectedDate.set(year, month - 1, day, 0, 0, 0);
                return selectedDate;
            }
        });
    }

    public void dimissDatePickView() {
        portTypeWvLl.setVisibility(View.GONE);
    }

    public void showDatePickView() {
        portTypeWvLl.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.wv_cancel_tv, R.id.wv_confirm_tv, R.id.tv_expected_date_childbirth, R.id.tv_menstruation_date, R.id.tv_save, R.id.tv_baby_been_born})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wv_cancel_tv:
                dimissDatePickView();
                break;
            case R.id.wv_confirm_tv:
                dimissDatePickView();
                if (isChildbirth) {
                    tvExpectedDateChildbirth.setText(dataPickView.getTimeDatas());
                } else {
                    tvMenstruationDate.setText(dataPickView.getTimeDatas());
                }
                break;
            case R.id.tv_expected_date_childbirth:
                showDatePickView();
                isChildbirth = true;
                break;
            case R.id.tv_menstruation_date:
                showDatePickView();
                isChildbirth = false;
                break;
            case R.id.tv_save:
                back();
                break;
            case R.id.tv_baby_been_born:
                back();
                break;
        }
    }
}
