package com.sharath.pharmacy.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.sharath.pharmacy.utils.Constants;

@Entity
public class ItemEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = Constants.ITEM_NAME)
    private String itemName;

    @ColumnInfo(name = Constants.PRICE)
    private String price;

    @ColumnInfo(name = Constants.ITEM_CODE)
    private String itemCode;

    @ColumnInfo(name = Constants.ITEM_PIC)
    private String itemPic;

    @ColumnInfo(name = Constants.MANUFACTURER)
    private String manufacturer;

    @ColumnInfo(name = Constants.MADICINE_TYPE)
    private String madicineType;

    @ColumnInfo(name = Constants.MINIMUM_QTY)
    private String minimumQty;

    @ColumnInfo(name = Constants.PACK)
    private String pack;

    @ColumnInfo(name = Constants.PACK_QTY)
    private String packQty;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMadicineType() {
        return madicineType;
    }

    public void setMadicineType(String madicineType) {
        this.madicineType = madicineType;
    }

    public String getMinimumQty() {
        return minimumQty;
    }

    public void setMinimumQty(String minimumQty) {
        this.minimumQty = minimumQty;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getPackQty() {
        return packQty;
    }

    public void setPackQty(String packQty) {
        this.packQty = packQty;
    }
}
