package com.saiyi.pregnantmother.common.action;

import android.os.Bundle;

import com.sunday.common.event.EventAction;

/**
 * App内事件传播Action
 */
public enum Action implements EventAction {

    /**
     *资料完成ok，进入主页
     */
    ACTION_SUPPLEMENT_DONE(0x100, "supplement_done"),
    ACTION_EXIT(0x110, "EXIT");

    private int actionId;
    private String actionName;
    private Bundle actionData;

    Action(int actionId) {
        this.actionId = actionId;
    }

    Action(int actionId, String actionName) {
        this.actionId = actionId;
        this.actionName = actionName;
    }

    Action(int actionId, String actionName, Bundle actionData) {
        this.actionId = actionId;
        this.actionName = actionName;
        this.actionData = actionData;
    }

    @Override
    public int getActionId() {
        return actionId;
    }

    @Override
    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public Bundle getActionData() {
        return actionData;
    }

    @Override
    public void setActionData(Bundle actionData) {
        this.actionData = actionData;
    }
}
