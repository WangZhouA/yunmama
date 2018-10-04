package com.saiyi.pregnantmother.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.sunday.common.logger.Logger;

/**
 * Created by JingNing on 2018-07-05 11:45
 */
public class ListenScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    public ListenScrollView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
    }

    public ListenScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListenScrollView(Context context) {
        super(context);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(t, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public abstract interface OnScrollChangedListener {
        public abstract void onScrollChanged(int top, int oldTop);
    }
}
