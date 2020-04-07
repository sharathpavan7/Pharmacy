package com.sharath.pharmacy.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sharath.pharmacy.database.entities.ItemEntity;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM itementity")
    List<ItemEntity> getAll();

    @Insert
    void insert(ItemEntity item);

    @Query("DELETE FROM ItemEntity")
    void deletAll();

}
