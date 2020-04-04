package com.sharath.pharmacy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sharath.pharmacy.R;
import com.sharath.pharmacy.api.ApiAdapter;
import com.sharath.pharmacy.api.ApiService;
import com.sharath.pharmacy.response.ItemDetailsApiResponse;
import com.sharath.pharmacy.response.ItemsListApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        getItemsDetails();
    }

    private void getItemsDetails() {

        ApiService apiService = ApiAdapter.getClient
                (this).create(ApiService.class);

        Call<ItemDetailsApiResponse> serverCom = apiService.fetchItemDetails("I00131");

        serverCom.enqueue(new Callback<ItemDetailsApiResponse>() {

            @Override
            public void onResponse(@NonNull Call<ItemDetailsApiResponse> call,
                                   @NonNull Response<ItemDetailsApiResponse> response) {

            }

            @Override
            public void onFailure(@NonNull Call<ItemDetailsApiResponse> call, @NonNull Throwable t) {

            }
        });

    }
}
