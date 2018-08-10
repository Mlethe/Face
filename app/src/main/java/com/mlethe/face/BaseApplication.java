package com.mlethe.face;

import android.app.Application;

import com.mlethe.face.utils.Tool;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Tool.init(this);
    }
}
