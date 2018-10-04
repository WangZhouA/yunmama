package com.saiyi.pregnantmother.doctor.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.doctor.model.bean.Doctor;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class DoctorListAdapter extends BaseQuickAdapter<Doctor, DoctorListAdapter.DoctorViewHolder> {

    public static final int TYPE_DOCTOR = 0;
    public static final int TYPE_DOCTOR_FIND = 1;

    private List<Doctor> doctors;
    private int type;

    public DoctorListAdapter(int layoutResId, @Nullable List<Doctor> data, int type) {
        super(layoutResId, data);
        this.doctors = data;
        this.type = type;
    }

    @Override
    protected void convert(DoctorViewHolder helper, Doctor item) {
        if (type == TYPE_DOCTOR_FIND) {
            Picasso.with(mContext).load(item.getHeadImg()).placeholder(R.drawable.touxiang).error(R.drawable.touxiang).transform(new CropCircleTransformation()).into(helper.ivHeadImg);
        }
        helper.tvName.setText(item.getName());
        helper.tvLevel.setText(item.getLevel());
        helper.tvStatus.setText(item.getStatus() == 1 ? mContext.getString(R.string.on_line) : mContext.getString(R.string.off_line));
        helper.tvStatus.setTextColor(item.getStatus() == 1 ? mContext.getResources().getColor(R.color.colorAccent) : mContext.getResources().getColor(R.color.hint_text_color));
        helper.tvHospitalName.setText(item.getHospitalName());
        helper.tvDepartment.setText(item.getDepartment());
        helper.tvProfiles.setText(item.getProfiles());
    }

    protected class DoctorViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_head_img)
        ImageView ivHeadImg;

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_level)
        TextView tvLevel;

        @BindView(R.id.tv_status)
        TextView tvStatus;

        @BindView(R.id.tv_hospital_name)
        TextView tvHospitalName;

        @BindView(R.id.tv_department)
        TextView tvDepartment;

        @BindView(R.id.tv_profiles)
        TextView tvProfiles;

        public DoctorViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
