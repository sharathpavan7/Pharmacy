package com.sharath.pharmacy.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static final String BASE_URL = "";

    private static Retrofit retrofit = null;
    private static volatile OkHttpClient okHttpClient;

    public static Retrofit getClient(Context context) {
        OkHttpClient okHttpClient = getHttpClient(context);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getHttpClient(Context context) {
        if (okHttpClient != null) return okHttpClient;
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(1, TimeUnit.MINUTES)
                //.callTimeout(0, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);

        okHttpClient = builder.build();
        return okHttpClient;
    }
}
