package com.saiyi.pregnantmother.my.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.view.dialog.RemindMsgDialog;
import com.saiyi.pregnantmother.login.ui.LoginActivity;
import com.saiyi.pregnantmother.my.ui.photo.LogUtils;
import com.saiyi.pregnantmother.my.ui.photo.PhotoClipActivity;
import com.saiyi.pregnantmother.my.ui.photo.PhotoUtil;
import com.saiyi.pregnantmother.my.view.CircleImageView;
import com.saiyi.pregnantmother.my.view.MyDialog;
import com.saiyi.pregnantmother.my.view.UserInfo;
import com.sunday.common.mvp.PresenterImpl;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class PersonalCenterActivity extends BKMVPActivity {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_arrow1)
    TextView tvArrow1;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.iv_head_img)
    CircleImageView ivHeadImg;
    @BindView(R.id.tv_arrow2)
    TextView tvArrow2;
    @BindView(R.id.rl_head_img)
    RelativeLayout rlHeadImg;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_arrow3)
    TextView tvArrow3;
    @BindView(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNumber;
    @BindView(R.id.tv_arrow4)
    TextView tvArrow4;
    @BindView(R.id.rl_phone_number)
    RelativeLayout rlPhoneNumber;
    @BindView(R.id.tv_childbirth)
    TextView tvChildbirth;
    @BindView(R.id.tv_arrow5)
    TextView tvArrow5;
    @BindView(R.id.rl_childbirth)
    RelativeLayout rlChildbirth;
    @BindView(R.id.tv_doctor)
    TextView tvDoctor;
    @BindView(R.id.tv_arrow6)
    TextView tvArrow6;
    @BindView(R.id.rl_doctor)
    RelativeLayout rlDoctor;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_arrow7)
    TextView tvArrow7;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    PhotoUtil photoUtil;

    UserInfo userInfo;

    private RemindMsgDialog remindMsgDialog;

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);


    }

    @Override
    protected void initView() {
        super.initView();
        mTitleBar.setTitle(R.string.personal_center);
        userInfo = new UserInfo(this);
        remindMsgDialog = new RemindMsgDialog(this);
    }

    @OnClick({R.id.rl_name, R.id.rl_head_img, R.id.rl_birthday, R.id.rl_phone_number, R.id.rl_childbirth, R.id.rl_doctor, R.id.rl_address, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_name:
                startActivityForResult(new Intent(PersonalCenterActivity.this, ReNameActivity.class).putExtra("num", 1), 0x01);
                break;
            case R.id.rl_head_img:
                initPermission();
                break;
            case R.id.rl_birthday:
                startActivityForResult(new Intent(PersonalCenterActivity.this, ReNameActivity.class).putExtra("num", 2), 0x02);
                break;
            case R.id.rl_phone_number:
                startActivityForResult(new Intent(PersonalCenterActivity.this, ReNameActivity.class).putExtra("num", 3), 0x03);
                break;
            case R.id.rl_childbirth:
                startActivityForResult(new Intent(PersonalCenterActivity.this, DueDate.class).putExtra("num", 4), 0x04);
                break;
            case R.id.rl_doctor:
                break;
            case R.id.tv_login:
                showDialog();
                break;
            case R.id.rl_address:
                startActivityForResult(new Intent(PersonalCenterActivity.this, ReNameActivity.class).putExtra("num", 5), 0x05);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            tvName.setText(intent.getStringExtra("name"));
        } else if (!TextUtils.isEmpty(intent.getStringExtra("birthday"))) {
            tvBirthday.setText(intent.getStringExtra("birthday"));
        } else if (!TextUtils.isEmpty(intent.getStringExtra("phone"))) {
            tvPhoneNumber.setText(intent.getStringExtra("phone"));
        } else if (!TextUtils.isEmpty(intent.getStringExtra("YCQ"))) {
            tvChildbirth.setText(intent.getStringExtra("YCQ"));
        } else if (!TextUtils.isEmpty(intent.getStringExtra("adress"))) {
            tvAddress.setText(intent.getStringExtra("adress"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        // 相册返回
        if (PhotoUtil.CAMRA_SETRESULT_CODE == requestCode) {
            if (resultCode == RESULT_OK) {
                // 相册选中图片路径
                String cameraPath = photoUtil.getCameraPath(data);
                LogUtils.d("相相册选中路径  = " + cameraPath);
                startClipActivity(cameraPath);
            }
        }
        // 相机返回
        else if (PhotoUtil.PHOTO_SETRESULT_CODE == requestCode) {
            if (resultCode == RESULT_OK) {
                String photoPath = photoUtil.getPhotoPath();
                LogUtils.d("相机选中路径  = " + photoPath);
                startClipActivity(photoPath);

            }
        }
        // 裁剪返回
        else if (PhotoUtil.PHOTO_CORPRESULT_CODE == requestCode) {
            if (resultCode == RESULT_OK) {
                LogUtils.d("裁剪返回  = ");
                String path = data.getStringExtra("path");
                Log.d("--->pathss", path);
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                ivHeadImg.setImageBitmap(bitmap);
                userInfo.setUserInfo("img", path);

            }
        }
    }


    //点击跳转到图片处理的界面
    public void startClipActivity(String path) {

        Intent intent = new Intent(this, PhotoClipActivity.class);
        intent.putExtra("path", path);
        startActivityForResult(intent, PhotoUtil.PHOTO_CORPRESULT_CODE);
    }


    private void initPermission() {
        RxPermissions rxPermission = new RxPermissions(this);
        rxPermission
                .requestEach(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            photoUtil = new PhotoUtil(PersonalCenterActivity.this);
                            photoUtil.showDialog(getResources().getString(R.string.atlas), getResources().getString(R.string.camera));

                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                        }
                    }
                });
    }


    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.qiangzhi_xiaxian_layout,null);
        final MyDialog builder = new MyDialog(this, 0, 0, view, R.style.MyDialog);
        builder.setCancelable(false);
        Button btn_no_xian_ss=  view.findViewById(R.id.btn_no_xian_ss);
        Button  btn_yes_xiaxian_ss= view.findViewById(R.id.btn_yes_xiaxian_ss);




        //取消按钮
        btn_no_xian_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });

        //确认按钮
        btn_yes_xiaxian_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LoginActivity.class);
                finish();

                builder.dismiss();
            }
        });

        builder.show();
//        remindMsgDialog.setTitleText(getString(R.string.loginout))
//                .hidenMsg()
//                .setComplateText(getString(R.string.confirm))
//                .setComplateTextColorRes(R.color.style_blue)
//                .setClick(new BaseDialog.OnDialogClick() {
//                    @Override
//                    public void onClick(int whichOne) {
//                        switch (whichOne) {
//                            case RemindMsgDialog.WHICH_COMPLATE:
//                                openActivity(LoginActivity.class);
//                                back();
//                                break;
//                        }
//                    }
//                });
//        remindMsgDialog.show();
    }

}
