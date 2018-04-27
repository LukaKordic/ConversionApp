package com.lukakordic.conversionapp;

import android.app.Application;

import com.lukakordic.conversionapp.di.components.AppComponent;
import com.lukakordic.conversionapp.di.components.DaggerAppComponent;

public class App extends Application {

    private static App instance;

    private static AppComponent component = DaggerAppComponent.builder().build();

    public static App getApp() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return component;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
