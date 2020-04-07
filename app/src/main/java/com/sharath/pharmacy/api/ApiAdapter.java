package com.sharath.pharmacy.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    //Todo: remove base url when you push code
    private static final String BASE_URL = "http://www.orderbuk.com/commandcenter/backend/web/";

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

        //TODO: remove the following logging code
        Interceptor loggingInterceptor = getHttpLoggingInterceptor(context);
        if (loggingInterceptor != null) {
            builder.addInterceptor(loggingInterceptor);
        }

        okHttpClient = builder.build();
        return okHttpClient;
    }

    //TODO: remove following method
    private static Interceptor getHttpLoggingInterceptor(Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(getHttpLoggingLevel(context));
        return interceptor;
    }

    private static HttpLoggingInterceptor.Level getHttpLoggingLevel(Context context) {
        try {
            return HttpLoggingInterceptor.Level.valueOf(String.valueOf(HttpLoggingInterceptor.Level.BODY));
        } catch (Throwable t) {
            //Ignore
        }
        return HttpLoggingInterceptor.Level.NONE;
    }
}
