package com.sharath.pharmacy.response;

import com.google.gson.annotations.SerializedName;
import com.sharath.pharmacy.models.Item;
import com.sharath.pharmacy.utils.Constants;

import java.util.ArrayList;

public class ItemsListApiResponse {

    @SerializedName(Constants.ITEM_LIST)
    public ArrayList<Item> itemArrayList;

}
