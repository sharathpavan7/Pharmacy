package com.sharath.pharmacy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sharath.pharmacy.R;
import com.sharath.pharmacy.api.ApiAdapter;
import com.sharath.pharmacy.api.ApiService;
import com.sharath.pharmacy.response.ItemsListApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getItemsList();
    }

    private void getItemsList() {

        ApiService apiService = ApiAdapter.getClient
                (this).create(ApiService.class);

        Call<ItemsListApiResponse> serverCom = apiService.fetchItems();

        serverCom.enqueue(new Callback<ItemsListApiResponse>() {

            @Override
            public void onResponse(@NonNull Call<ItemsListApiResponse> call,
                                   @NonNull Response<ItemsListApiResponse> response) {

            }

            @Override
            public void onFailure(@NonNull Call<ItemsListApiResponse> call, @NonNull Throwable t) {

            }
        });

    }
}
