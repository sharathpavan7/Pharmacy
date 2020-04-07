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

        getItemsDetails("");
    }

    private void getItemsDetails(String itemId) {

        ApiService apiService = ApiAdapter.getClient
                (this).create(ApiService.class);

        String item = String.format("UAT05E~143452~%s~", /*"I00131"*/itemId);

        Call<ItemDetailsApiResponse> serverCom = apiService.fetchItemDetails("GETITEMDETAILSNEWV1",
                item);

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
