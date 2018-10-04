package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.doctor.adapter.DoctorListAdapter;
import com.saiyi.pregnantmother.doctor.model.bean.Doctor;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDoctorActivity extends BKMVPActivity {

    @BindView(R.id.search_et)
    EditText searchEt;
    @BindView(R.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R.id.rl_find_doctor)
    RelativeLayout rlFindDoctor;

    private DoctorListAdapter doctorListAdapter;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.find_doctor);
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.xiaoxi);

        initDoctorList();
    }

    private void initDoctorList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDoctor.setLayoutManager(layoutManager);
        List<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctorListAdapter = new DoctorListAdapter(R.layout.item_doctor_find, doctors, DoctorListAdapter.TYPE_DOCTOR_FIND);
        rvDoctor.setAdapter(doctorListAdapter);
    }
}
