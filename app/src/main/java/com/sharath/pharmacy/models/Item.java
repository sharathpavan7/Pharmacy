package com.sharath.pharmacy.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.sharath.pharmacy.utils.Constants;

public class Item implements Parcelable {

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };


    @SerializedName(Constants.ITEM_NAME)
    private String itemName;

    @SerializedName(Constants.PRICE)
    private String price;

    @SerializedName(Constants.ITEM_CODE)
    private String itemCode;

    @SerializedName(Constants.ITEM_PIC)
    private String itemPic;

    @SerializedName(Constants.MANUFACTURER)
    private String manufacturer;

    @SerializedName(Constants.MADICINE_TYPE)
    private String madicineType;

    @SerializedName(Constants.MINIMUM_QTY)
    private String minimumQty;

    @SerializedName(Constants.PACK)
    private String pack;

    @SerializedName(Constants.PACK_QTY)
    private String packQty;

    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemPic() {
        return itemPic;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMadicineType() {
        return madicineType;
    }

    public String getMinimumQty() {
        return minimumQty;
    }

    public String getPack() {
        return pack;
    }

    public String getPackQty() {
        return packQty;
    }

    public Item(Parcel in) {
        itemName = in.readString();
        price = in.readString();
        itemCode = in.readString();
        itemPic = in.readString();
        manufacturer = in.readString();
        madicineType = in.readString();
        minimumQty = in.readString();
        pack = in.readString();
        packQty = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeString(price);
        dest.writeString(itemCode);
        dest.writeString(itemPic);
        dest.writeString(manufacturer);
        dest.writeString(madicineType);
        dest.writeString(minimumQty);
        dest.writeString(pack);
        dest.writeString(packQty);
    }
}
