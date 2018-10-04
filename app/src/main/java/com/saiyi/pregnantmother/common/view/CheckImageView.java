package com.saiyi.pregnantmother.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/3/17.
 */

@SuppressLint("AppCompatCustomView")
public class CheckImageView extends ImageView implements Checkable {

    boolean isChecked = false;
    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };

    public CheckImageView(Context context) {
        super(context);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CheckImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if(isChecked){
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    public void setChecked(boolean b) {
        if(isChecked != b){
            isChecked = b;
            refreshDrawableState();
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
