package com.sharath.pharmacy.api;

import com.sharath.pharmacy.response.ItemDetailsApiResponse;
import com.sharath.pharmacy.response.ItemsListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //Todo: remove end point when you push code
    @GET("")
    Call<ItemsListApiResponse> fetchItems();

    //Todo: remove end point when you push code
    @GET("")
    Call<ItemDetailsApiResponse> fetchItemDetails(@Query("itemId") String itemId);

}
