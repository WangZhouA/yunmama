package com.saiyi.pregnantmother.home.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPFragment;
import com.saiyi.pregnantmother.common.view.dialog.AddDoctorDialog;
import com.saiyi.pregnantmother.common.view.dialog.BaseDialog;
import com.saiyi.pregnantmother.doctor.ui.AddDoctorActivity;
import com.saiyi.pregnantmother.doctor.ui.DoctorListActivity;
import com.saiyi.pregnantmother.doctor.ui.ScanDoctorQrActivity;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;

public class ConsultationFragment extends BKMVPFragment {

    @BindView(R.id.title_bar)
    NavBar titleBar;

    private AddDoctorDialog mAddDoctorDialog;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static ConsultationFragment newInstance() {
        ConsultationFragment fragment = new ConsultationFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consultation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        titleBar.setTitle(R.string.consultation);
        titleBar.hiddenLeftIcon();
        titleBar.showRightIcon();
        titleBar.setRightImageResource(R.drawable.tianjia);
        mAddDoctorDialog = new AddDoctorDialog(getActivity());
    }

    @Override
    protected void initListener() {
        super.initListener();
        titleBar.setClickListener(new NavBar.NavBarOnClickListener() {
            @Override
            public void onLeftIconClick(View view) {
            }

            @Override
            public void onLeftSenIconClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {
               openActivity(AddDoctorActivity.class );

            }

            @Override
            public void onRightTxtClick(View view) {
            }
        });
    }

    private void showAddDoctorDialog() {
        dismissAddDoctorDialog();
        mAddDoctorDialog.setClick(mAddDoctorClick);
        mAddDoctorDialog.show();
    }

    private final BaseDialog.OnDialogClick mAddDoctorClick = new BaseDialog.OnDialogClick() {
        @Override
        public void onClick(int whichOne) {
            switch (whichOne) {
                case AddDoctorDialog.WHICH_MANUALLY:
                    openActivity(DoctorListActivity.class);
                    break;
                case AddDoctorDialog.WHICH_AUTO:
                    openActivity(ScanDoctorQrActivity.class);
                    break;
            }
        }
    };

    //弹窗消失
    private void dismissAddDoctorDialog() {
        if (mAddDoctorDialog != null && mAddDoctorDialog.isShowing()) {
            mAddDoctorDialog.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
