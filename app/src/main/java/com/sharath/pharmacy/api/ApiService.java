package com.sharath.pharmacy.api;

import com.sharath.pharmacy.response.ItemsListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("")
    Call<ItemsListApiResponse> fetchItems();

}
