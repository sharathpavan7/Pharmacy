package com.sharath.pharmacy.api;

import com.sharath.pharmacy.response.ItemDetailsApiResponse;
import com.sharath.pharmacy.response.ItemsListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //Todo: remove end point when you push code
    @GET("?idx=GETCATEGORYITEMLISTRATEASCRXV1&data=UAT05E~0001~143452~")
    Call<ItemsListApiResponse> fetchItems();

    //Todo: remove end point when you push code
    //@GET("?idx=GETITEMDETAILSNEWV1&data=UAT05E~143452~I00131~")
    @GET("api2/")
    Call<ItemDetailsApiResponse> fetchItemDetails(@Query("idx") String querry1,
                                                  @Query("data") String querry2 );

}
