package com.example.yefrigaitan.phocus;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Justin Won on 1/21/2018.
 */

public class AppContext extends Application {
    private AppContext instance;

    public void onCreate() {
        super.onCreate();
        instance = this;
        startBinderMode();
    }

    public void startBinderMode(){
        startService(new Intent(this, Binder.class));
    }
}
