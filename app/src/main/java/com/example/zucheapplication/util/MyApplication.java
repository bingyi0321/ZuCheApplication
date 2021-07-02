package com.example.zucheapplication.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * 全局getContext
 * email 1005196988@qq.com
 *
 * @author bingyi
 * @date 2021/6/2/0002 11:26
 */
public class MyApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        return context;
    }
}
