package com.saiyi.pregnantmother.my.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.my.view.CustomDatePicker;
import com.saiyi.pregnantmother.my.view.LastInputEditText;
import com.saiyi.pregnantmother.my.view.TimeUtil;
import com.sunday.common.mvp.PresenterImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈姣姣 on 2018/7/2.
 */
public class DueDate extends BKMVPActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_dueDate)
    TextView etDueDate;
    @BindView(R.id.tv_userOnClick)
    TextView tvUserOnClick;
    @BindView(R.id.tv_calculation)
    TextView tvCalculation;
    @BindView(R.id.tv_menstruation_time)
    TextView tvMenstruationTime;
    @BindView(R.id.rl_menstruation)
    RelativeLayout rlMenstruation;
    @BindView(R.id.et_menstruation_cycle)
    LastInputEditText etMenstruationCycle;
    @BindView(R.id.rl_menstruation_cycle)
    RelativeLayout rlMenstruationCycle;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.Lin_set)
    LinearLayout LinSet;
    @BindView(R.id.tv_The_baby_already_born)
    TextView tvTheBabyAlreadyBorn;




    CustomDatePicker customDatePicker;
    private boolean show;
    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duedate);

        initDatePicker();

    }

    @OnClick({R.id.rl_menstruation_cycle, R.id.btn_save, R.id.tv_The_baby_already_born,R.id.tv_calculation,R.id.rl_menstruation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_menstruation_cycle:

                break;
            case R.id.rl_menstruation:
                showDialog(tvMenstruationTime.getText().toString());
                break;
            case R.id.btn_save:

                etDueDate.setText(TimeUtil.getCurrentTime());
                Intent   intent = new Intent(DueDate.this, PersonalCenterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("YCQ", etDueDate.getText().toString());
                startActivity(intent);
                finish();

                break;
            case R.id.tv_The_baby_already_born:
                finish();
                break;
            case R.id.tv_calculation:

                if (show==false) {
                    LinSet.setVisibility(View.VISIBLE);
                    show=true;
                }else {
                    LinSet.setVisibility(View.GONE);
                    show=false;
                }
                break;
        }
    }

    /**
     *  时间选择器
     * */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        customDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvMenstruationTime.setText(time.split(" ")[0]);

            }
        }, "2010-01-01 01:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false); // 不显示时和分
        customDatePicker.setIsLoop(false); // 不允许循环滚动

    }
    private  void  showDialog(String time ){

        if (TextUtils.isEmpty(time)){

            customDatePicker.show(TimeUtil.getCurrentTime()+" "+"01:01");
        }else {

            customDatePicker.show(time+" "+"01:01");
        }
    }
}
