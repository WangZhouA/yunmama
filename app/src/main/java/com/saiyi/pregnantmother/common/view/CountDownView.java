package com.saiyi.pregnantmother.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/19.
 */

@SuppressLint("AppCompatCustomView")
public class CountDownView extends TextView {

    private CountDownCallBack mCallback;

    private boolean hasStartCountDown;

    private int currentDown;

    private Handler mHandler = new Handler();

    public CountDownView(Context context) {
        super(context);
        init();
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setClickable(true);
    }

    public void startCountDown(int maxSecound, CountDownCallBack callBack) {
        if (hasStartCountDown) {
            mHandler.removeCallbacks(countDown);
        }
        mCallback = callBack;
        setEnabled(false);
        hasStartCountDown = true;
        currentDown = maxSecound;
        mHandler.postDelayed(countDown, 1000);
    }

    Runnable countDown = new Runnable() {
        @Override
        public void run() {
            currentDown = currentDown - 1;
            mHandler.removeCallbacks(countDown);
            if (currentDown > 0) {//继续倒计时
                if (mCallback != null) {
                    mCallback.onCountDown(currentDown);
                }
                mHandler.postDelayed(countDown, 1000);
            } else {//倒计时完成
                hasStartCountDown = false;
                setEnabled(true);
                if (mCallback != null) {
                    mCallback.onCountComplate();
                }
            }
        }
    };

    /**停止倒计时*/
    public void stopContDown(){
        mHandler.removeCallbacks(countDown);
        if(mCallback != null){
            mCallback.onCountComplate();
        }
    }

    public interface CountDownCallBack {

        /**
         * 正在倒计时
         */
        void onCountDown(int second);

        /**
         * 倒计时完成
         */
        void onCountComplate();
    }

    public void release() {
        mHandler.removeCallbacks(countDown);
        mHandler = null;
    }
}
