package com.saiyi.pregnantmother.doctor.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.sunday.common.mvp.PresenterImpl;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import io.reactivex.functions.Consumer;

public class ScanDoctorQrActivity extends BKMVPActivity implements QRCodeView.Delegate {

    public static final int CAMERA_OK = 1000;

    @BindView(R.id.zxingview)
    ZXingView zxingview;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanqr_doctor);
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.scan_qr);
    }

    @Override
    protected void onStart() {
        super.onStart();
        zxingview.startCamera();
        zxingview.startSpotAndShowRect();
    }

    @Override
    protected void initListener() {
        zxingview.setDelegate(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        zxingview.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zxingview.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        openActivity(DoctorInfoActivity.class);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
