package com.sunday.common.event;

import android.os.Bundle;

/**
 * 项目：智能控制     SmartLock
 */
public interface EventAction {

    public int getActionId();

    public void setActionId(int actionId);

    public String getActionName();

    public void setActionName(String actionName);

    public Bundle getActionData();

    public void setActionData(Bundle actionData);
}
