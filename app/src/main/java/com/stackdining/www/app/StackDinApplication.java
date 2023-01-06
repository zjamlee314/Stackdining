package com.stackdining.www.app;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

public class StackDinApplication  extends Application {

    //全局上下文
    private static StackDinApplication sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    /**
     * 获取当前上下文
     * @return
     */
    public static StackDinApplication getAppContext() {
        return sContext;
    }
}
