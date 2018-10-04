package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.saiyi.pregnantmother.home.adapter.SkuTypeAdapter;
import com.saiyi.pregnantmother.home.model.bean.SkuAttribute;
import com.sunday.common.widgets.NoScrollListview;

import butterknife.BindView;
import butterknife.OnClick;

public class ProductSkuDialog extends BaseDialog {

     public static final int WHICH_SUBMIT = 10;

    @BindView(R.id.tv_sku_selling_price)
    TextView tvSkuSellingPrice;
    @BindView(R.id.nlv)
    NoScrollListview nlv;
    @BindView(R.id.tv_sku_quantity_label)
    TextView tvSkuQuantityLabel;
    @BindView(R.id.btn_sku_quantity_minus)
    TextView btnSkuQuantityMinus;
    @BindView(R.id.et_sku_quantity_input)
    EditText etSkuQuantityInput;
    @BindView(R.id.btn_sku_quantity_plus)
    TextView btnSkuQuantityPlus;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.iv_sku_logo)
    ImageView ivSkuLogo;

    private Context context;
    private SkuTypeAdapter skuTypeAdapter;

    public ProductSkuDialog(@NonNull Context context) {
        super(context, R.style.CommonBottomDialogStyle);
        this.context = context;
        initView();
    }

    public ProductSkuDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        initView();
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        setContentView(R.layout.dialog_product_sku);
    }

    public void initView() {
        skuTypeAdapter = new SkuTypeAdapter(context);
        nlv.setAdapter(skuTypeAdapter);
        SkuAttribute skuAttribute = new SkuAttribute("1", "数字显示+电池1对（海洋蓝）", false);
        SkuAttribute skuAttribute1 = new SkuAttribute("2", "数字显示+电池1对（樱花粉）", true);
        SkuAttribute skuAttribute2 = new SkuAttribute("3", "数字显示+电池器（古德白）", false);
        skuTypeAdapter.addSkuAttribute(skuAttribute);
        skuTypeAdapter.addSkuAttribute(skuAttribute1);
        skuTypeAdapter.addSkuAttribute(skuAttribute2);
        nlv.setOnItemClickListener(onItemClickListener);

    }

    protected AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (int i = 0; i < skuTypeAdapter.getCount(); i++) {
                SkuAttribute skuAttribute = (SkuAttribute) skuTypeAdapter.getItem(i);
                if (i == position) {
                    skuAttribute.setSelected(true);
                } else {
                    skuAttribute.setSelected(false);
                }
                skuTypeAdapter.setSkuAttribute(i, skuAttribute);
            }
        }
    };


    @OnClick({R.id.btn_sku_quantity_minus, R.id.et_sku_quantity_input, R.id.btn_sku_quantity_plus, R.id.btn_submit, R.id.ll_productsku_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sku_quantity_minus:
                int number = Integer.parseInt(etSkuQuantityInput.getText().toString().trim());
                if (number > 1) {
                    String newQuantity = String.valueOf(number - 1);
                    etSkuQuantityInput.setText(newQuantity);
                    etSkuQuantityInput.setSelection(newQuantity.length());
                    updateQuantityOperator(number - 1);
                }
                break;
            case R.id.btn_sku_quantity_plus:
                String quantity = etSkuQuantityInput.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    return;
                }
                int quantityInt = Integer.parseInt(quantity);
                String newQuantity = String.valueOf(quantityInt + 1);
                etSkuQuantityInput.setText(newQuantity);
                etSkuQuantityInput.setSelection(newQuantity.length());
                updateQuantityOperator(quantityInt + 1);
                break;
            case R.id.btn_submit:
                onWhichOneClick(WHICH_SUBMIT);
                break;
            case R.id.ll_productsku_dialog:
                dismiss();
                break;
        }
    }

    private void updateQuantityOperator(int newQuantity) {
        if (newQuantity <= 1) {
            btnSkuQuantityMinus.setEnabled(false);
            btnSkuQuantityPlus.setEnabled(true);
        } else {
            btnSkuQuantityMinus.setEnabled(true);
            btnSkuQuantityPlus.setEnabled(true);
        }
        etSkuQuantityInput.setEnabled(true);
    }
}
