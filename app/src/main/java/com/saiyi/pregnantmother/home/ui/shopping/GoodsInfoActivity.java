package com.saiyi.pregnantmother.home.ui.shopping;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.app.BKMVPActivity;
import com.saiyi.pregnantmother.common.constans.Constant;
import com.saiyi.pregnantmother.common.view.dialog.BaseDialog;
import com.saiyi.pregnantmother.common.view.dialog.ProductSkuDialog;
import com.saiyi.pregnantmother.my.ui.OrdersDeatilsActivity;
import com.sunday.common.activity.view.NavBar;
import com.sunday.common.mvp.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsInfoActivity extends BKMVPActivity {

    private static int STATUS_BUY = 1;// 立即购买
    private static int STATUS_CART = 2;// 加入购物车

    @BindView(R.id.tv_original_price)
    TextView tvOriginalPrice;

    private int type = Constant.BUNDLE_VALUE_FETAL_HEART_METER;
    private ProductSkuDialog dialog;
    private int purchaseStatus;     //购买状态，加入购物车还是立即购买

    @Override
    public PresenterImpl initPresenter(Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            type = bundle.getInt(Constant.BUNDLE_KEY_DEVICE_TYPE);
        }
        switch (type) {
            case Constant.BUNDLE_VALUE_FETAL_HEART_METER:
                mTitleBar.setTitle(R.string.fetal_heart_meter);
                break;
        }
        mTitleBar.showRightIcon();
        mTitleBar.setRightImageResource(R.drawable.gouwuche);
        mTitleBar.setClickListener(navBarOnClickListener);
        tvOriginalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        dialog = new ProductSkuDialog(this);
        dialog.setClick(onDialogClick);
    }

    protected NavBar.NavBarOnClickListener navBarOnClickListener = new NavBar.NavBarOnClickListener() {
        @Override
        public void onLeftIconClick(View view) {
            back();
        }

        @Override
        public void onLeftSenIconClick(View view) {

        }

        @Override
        public void onRightIconClick(View view) {
            openActivity(ShoppingCartAcativity.class);
        }

        @Override
        public void onRightTxtClick(View view) {

        }
    };

    protected BaseDialog.OnDialogClick onDialogClick = new BaseDialog.OnDialogClick() {
        @Override
        public void onClick(int whichOne) {
            switch (whichOne) {
                case ProductSkuDialog.WHICH_SUBMIT:
                    dialog.dismiss();
                    if (purchaseStatus == STATUS_CART) {
                        mTitleBar.setRightImageResource(R.drawable.gouwuche02);
                        toast(getString(R.string.add2cart_success));
                    } else {
                        openActivity(ConfirmationOrderActivity.class);
                    }
                    break;
            }
        }
    };

    @OnClick({R.id.tv_shopping_cart, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shopping_cart:
                purchaseStatus = STATUS_CART;
                dialog.show();
                break;
            case R.id.tv_buy:
                purchaseStatus = STATUS_BUY;
                dialog.show();
                break;
        }
    }

}
