package com.lhl.applife;

import android.app.Application;
import android.util.Log;

import com.lhl.life.AppLife;
import com.lhl.life.AppLifeListener;

public class MyApplication extends Application {
    public AppLife life;
    @Override
    public void onCreate() {
        super.onCreate();
        life =  new AppLife(this);
        life.registerAppLifeListener(new AppLifeListener() {
            @Override
            public void onAppPause() {
                Log.e("=====","onAppPause");
            }

            @Override
            public void onAppResume() {
                Log.e("=====","onAppResume");
            }
        });
    }
}
