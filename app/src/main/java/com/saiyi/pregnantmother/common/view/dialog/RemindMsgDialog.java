package com.saiyi.pregnantmother.common.view.dialog;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.saiyi.pregnantmother.R;
import com.sunday.common.utils.UiUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by JingNing on 2018-07-07 10:14
 */
public class RemindMsgDialog extends RemindDialog {

    /**取消按钮*/
    public static final int WHICH_CANCLE = 10;

    /**确定按钮*/
    public static final int WHICH_COMPLATE = 11;

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.msg_tv)
    TextView msgTv;

    @BindView(R.id.cancle_tv)
    TextView cancleTv;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.complate_tv)
    TextView complateTv;

    public RemindMsgDialog(@NonNull Context context) {
        super(context);
    }

    public RemindMsgDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RemindMsgDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initDialog() {
        super.initDialog();
        setContentView(R.layout.remind_msg_dialog);
    }

    public RemindMsgDialog setTitleText(CharSequence text) {
        titleTv.setText(text);
        return this;
    }

    public RemindMsgDialog setMsgText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            msgTv.setVisibility(View.GONE);
            return this;
        }
        msgTv.setText(text);
        return this;
    }

    public RemindMsgDialog showTitle() {
        return setViewVisibility(titleTv, View.VISIBLE);
    }

    public RemindMsgDialog hidenTitle() {
        return setViewVisibility(titleTv, View.GONE);
    }

    public RemindMsgDialog showMsg() {
        return setViewVisibility(msgTv, View.VISIBLE);
    }

    public RemindMsgDialog hidenMsg() {
        return setViewVisibility(msgTv, View.GONE);
    }

    public RemindMsgDialog showComplate() {
        UiUtil.setVisibility(complateTv, View.VISIBLE);
        UiUtil.setVisibility(line, View.VISIBLE);
        return this;
    }

    public RemindMsgDialog hidenComplate() {
        UiUtil.setVisibility(complateTv, View.GONE);
        UiUtil.setVisibility(line, View.GONE);
        return this;
    }

    public RemindMsgDialog showCancle() {
        UiUtil.setVisibility(cancleTv, View.VISIBLE);
        UiUtil.setVisibility(line, View.VISIBLE);
        return this;
    }

    public RemindMsgDialog hidenCancle() {
        UiUtil.setVisibility(cancleTv, View.GONE);
        UiUtil.setVisibility(line, View.GONE);
        return this;
    }

    public RemindMsgDialog setComplateText(String text) {
        complateTv.setText(text);
        return this;
    }

    public RemindMsgDialog setCancleText(String text) {
        cancleTv.setText(text);
        return this;
    }

    public RemindMsgDialog setCancleTextColor(@ColorInt int color) {
        cancleTv.setTextColor(color);
        return this;
    }

    public RemindMsgDialog setCancleTextColorRes(@ColorRes int colorRes) {
        cancleTv.setTextColor(getContext().getResources().getColor(colorRes));
        return this;
    }

    public RemindMsgDialog setComplateTextColor(@ColorInt int color) {
        complateTv.setTextColor(color);
        return this;
    }

    public RemindMsgDialog setComplateTextColorRes(@ColorRes int colorRes) {
        complateTv.setTextColor(getContext().getResources().getColor(colorRes));
        return this;
    }

    protected <T extends RemindDialog> T setViewVisibility(View view, int visibility) {
        UiUtil.setVisibility(view, visibility);
        return (T) this;
    }


    @OnClick({R.id.cancle_tv, R.id.complate_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancle_tv:
                onWhichOneClick(WHICH_CANCLE);
                dismiss();
                break;
            case R.id.complate_tv:
                onWhichOneClick(WHICH_COMPLATE);
                dismiss();
                break;
        }
    }
}
