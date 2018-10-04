package com.saiyi.pregnantmother.doctor.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈姣姣 on 2018/7/4.
 */
public class AddDoctorActivity extends BKMVPActivity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.rl_selection_manual)
    RelativeLayout rlSelectionManual;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.rl_selection_scan_qr)
    RelativeLayout rlSelectionScanQr;
    @BindView(R.id.tv_skip)
    TextView tvSkip;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_doctor);
        mTitleBar.setTitle(R.string.selection_doctor);
        tvSkip.setVisibility(View.GONE);


    }

    @OnClick({R.id.iv1, R.id.iv2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv1:
                openActivity(DoctorListActivity.class);
                break;
            case R.id.iv2:
                openActivity(ScanDoctorQrActivity.class);

//                RxPermissions rxPermission = new RxPermissions(this);
//                rxPermission
//                        .requestEach(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
//                        .subscribe(new Consumer<Permission>() {
//                            @Override
//                            public void accept(Permission permission) throws Exception {
//                                if (permission.granted) {
//                                    // 用户已经同意该权限
//                                    openActivity(ScanDoctorQrActivity.class);
//                                } else if (permission.shouldShowRequestPermissionRationale) {
//                                    // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
//                                } else {
//                                    // 用户拒绝了该权限，并且选中『不再询问』
//                                }
//                            }
//                        });
                break;

        }
    }
}
