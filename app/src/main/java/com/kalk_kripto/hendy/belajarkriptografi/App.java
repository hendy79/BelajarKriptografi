package com.kalk_kripto.hendy.belajarkriptografi;

import android.app.Application;

import com.air.sdk.injector.AirpushSdk;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AirpushSdk.init(this);
    }
}
