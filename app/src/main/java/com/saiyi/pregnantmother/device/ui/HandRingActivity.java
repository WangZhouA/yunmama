package com.saiyi.pregnantmother.device.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

public class HandRingActivity extends BKMVPActivity {

    @BindView(R.id.rg_frequency)
    RadioGroup rgFrequency;
    @BindView(R.id.rl_frequency)
    RelativeLayout rlFrequency;
    @BindView(R.id.tv_intermediate_frequency)
    TextView tvIntermediateFrequency;
    @BindView(R.id.tv_low_frequency)
    TextView tvLowFrequency;
    @BindView(R.id.tv_high_frequency)
    TextView tvHighFrequency;
    @BindView(R.id.tv_middle_low_frequency)
    TextView tvMiddleLowFrequency;
    @BindView(R.id.tv_middle_high_frequency)
    TextView tvMiddleHighFrequency;


    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_ring);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.hand_ring);
        rgFrequency.setOnCheckedChangeListener(frequencyOnCheckedChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener frequencyOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_low_frequency:
                    tvLowFrequency.setTextColor(getResources().getColor(R.color.style_blue));
                    tvMiddleLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvIntermediateFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    break;
                case R.id.rb_middle_low_frequency:
                    tvLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleLowFrequency.setTextColor(getResources().getColor(R.color.style_blue));
                    tvIntermediateFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    break;
                case R.id.rb_intermediate_frequency:
                    tvLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvIntermediateFrequency.setTextColor(getResources().getColor(R.color.style_blue));
                    tvMiddleHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    break;
                case R.id.rb_middle_high_frequency:
                    tvLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvIntermediateFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleHighFrequency.setTextColor(getResources().getColor(R.color.style_blue));
                    tvHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    break;
                case R.id.rb_high_frequency:
                    tvLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleLowFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvIntermediateFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvMiddleHighFrequency.setTextColor(getResources().getColor(R.color.hint_text_color));
                    tvHighFrequency.setTextColor(getResources().getColor(R.color.style_blue));
                    break;
            }
        }
    };

    @OnCheckedChanged(R.id.cb_dev_switch)
    protected void onCheckDevSwitch(CompoundButton buttonView, boolean isChecked){
        if (isChecked) {
        } else {
        }
    }
}
