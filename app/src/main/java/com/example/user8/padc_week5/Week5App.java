package com.example.user8.padc_week5;

import android.app.Application;
import android.content.Context;

/**
 * Created by user8 on 7/6/2016.
 */
public class Week5App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
