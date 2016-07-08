package com.example.user8.padc_week5.utils;

import com.google.gson.Gson;

/**
 * Created by user8 on 7/7/2016.
 */
public class CommonInstances {
    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
