package com.sharath.pharmacy.database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseClient {
    private Context mCtx;
    private static AppDatabaseClient mInstance;

    private AppDatabase appDatabase;

    private AppDatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "Pharmacy").build();
    }

    public static synchronized AppDatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new AppDatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
