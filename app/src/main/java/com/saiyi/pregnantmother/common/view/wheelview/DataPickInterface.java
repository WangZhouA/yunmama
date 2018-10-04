package com.saiyi.pregnantmother.common.view.wheelview;

import java.util.List;

/**
 * Created on 2018/4/26.
 */

public interface DataPickInterface<T> {

    public boolean[] getIsVisiables();
    public String[] getVisiableText();
    public List<List<String>> getAdapter();

    public T getSelectIndexs();
}
