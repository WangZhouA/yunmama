package com.saiyi.pregnantmother.doctor.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.doctor.adapter.DoctorListAdapter;
import com.saiyi.pregnantmother.doctor.model.bean.Doctor;
import com.saiyi.pregnantmother.doctor.presenter.IOnScrollListener;
import com.saiyi.pregnantmother.doctor.ui.DoctorInfoActivity;
import com.sunday.common.mvp.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DoctorListFragment extends BKMVPFragment    {

    @BindView(R.id.rv_doctor)
    RecyclerView rvDoctor;

    private DoctorListAdapter doctorListAdapter;


    IOnScrollListener scrollListener;

    public void setScrollListener(IOnScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static DoctorListFragment newInstance() {
        DoctorListFragment fragment = new DoctorListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rvDoctor.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("庄恕", "主任医生", 1, "广州医科大学附属第二医院", "妇产科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctors.add(new Doctor("靳东", "副主任医生", 0, "广州医科大学附属第二医院", "新生儿科", "擅长胆道闭锁，先天性巨结肠，先天性直肠,心血管疾病"));
        doctorListAdapter = new DoctorListAdapter(R.layout.item_doctor, doctors, DoctorListAdapter.TYPE_DOCTOR);
        doctorListAdapter.setOnItemClickListener(onItemDoctorClickListener);
        rvDoctor.setAdapter(doctorListAdapter);
        rvDoctor.addOnScrollListener(onScrollListener);
    }

    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
                 //onScrollStateChanged 方法
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
               //只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                //获取最后一个可见view的位置
                int lastItemPosition = linearManager.findLastVisibleItemPosition();
                //获取第一个可见view的位置
                int firstItemPosition = linearManager.findFirstVisibleItemPosition();
            }

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (dy<0){
                Intent i =new Intent("UPTE");
                getActivity().sendBroadcast(i);
            }else {
                Intent i =new Intent("DOWN");
                getActivity().sendBroadcast(i);
            }
        }
    };

    private BaseQuickAdapter.OnItemClickListener onItemDoctorClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            openActivity(DoctorInfoActivity.class);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
