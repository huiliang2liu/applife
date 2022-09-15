package com.lhl.life;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AppLife implements AppLifeListener {
    private List<AppLifeListener> lifeListeners = new ArrayList<>();
    private LifecycleCallbacks callbacks;


    public AppLife(Context context) {
        callbacks = new LifecycleCallbacks(this);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(callbacks);
    }


    public List<Activity> class2Activity(Class<? extends Activity> clazz) {
        assert clazz != null : "clazz is null";
        return callbacks.class2Activity(clazz);
    }

    public void registerAppLifeListener(AppLifeListener listener) {
        if (listener == null)
            return;
        lifeListeners.add(listener);
    }

    public void unRegisterAppLifeListener(AppLifeListener listener) {
        if (listener == null)
            return;
        lifeListeners.remove(listener);
    }

    void activityDestroy(Activity activity){
        lifeListeners.remove(activity);
    }

    @Override
    public void onAppPause() {
        for (AppLifeListener listener : lifeListeners)
            listener.onAppPause();
    }

    @Override
    public void onAppResume() {
        for (AppLifeListener listener : lifeListeners)
            listener.onAppResume();
    }
}
