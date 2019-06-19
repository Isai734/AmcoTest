package com.amco.tv.service;



import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author isaicastro .
 */

public class OkHttpClient {

    private static final String TAG = OkHttpClient.class.getSimpleName();
    private static OkHttpClient INSTANCE = null;
    private okhttp3.OkHttpClient okHttpClien;

    private static OkHttpClient getInstance() {
        if (INSTANCE == null)
            INSTANCE = new OkHttpClient();
        return INSTANCE;
    }

    private OkHttpClient() {
        {
            okHttpClien = new okhttp3.OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
        }
    }

    public static okhttp3.OkHttpClient create() {
        return OkHttpClient.getInstance().okHttpClien;
    }
}
