package com.saiyi.pregnantmother.common.view.wheelview;

import android.content.Context;

import java.util.Calendar;
import java.util.List;

/**
 * Created on 2018/4/25.
 */

public class DataPickBuilder{
    private DataPickView dataPickView;
    private Context context;
    private DataPickOptions mPickerOptions;
    private DataPickInterface dataPickInterface;


    public DataPickBuilder(Context context){
        this.context = context;
        mPickerOptions = new DataPickOptions();
    }

    public DataPickView setDadaPickInterface(DataPickInterface dataPickInterface){
        this.dataPickInterface = dataPickInterface;
        mPickerOptions.isVisiables = this.dataPickInterface.getIsVisiables();
        mPickerOptions.visiableText = this.dataPickInterface.getVisiableText();
        mPickerOptions.dataLists = this.dataPickInterface.getAdapter();

        if (mPickerOptions.SHOW_PICKER_TYPE ==1){
            mPickerOptions.selectIndexs = (int[]) this.dataPickInterface.getSelectIndexs();
        }else{
            mPickerOptions.date = (Calendar) this.dataPickInterface.getSelectIndexs();
        }
        return build();
    }

    public DataPickBuilder setIsVisiables(boolean[] isVisiables){
        mPickerOptions.isVisiables = isVisiables;
        return this;
    }

    public DataPickBuilder setVisiableText(String[] visiableText){
        mPickerOptions.visiableText = visiableText;
        return this;
    }

    public DataPickBuilder setAdapter(List<List<String>> datas){
        mPickerOptions.dataLists = datas;
        return this;
    }


    public DataPickBuilder setShowType(int type){
        mPickerOptions.SHOW_PICKER_TYPE = type;
        return this;
    }

    public DataPickView build() {
        dataPickView = new DataPickView(context,mPickerOptions,mPickerOptions.SHOW_PICKER_TYPE);
        return dataPickView;
    }

}
