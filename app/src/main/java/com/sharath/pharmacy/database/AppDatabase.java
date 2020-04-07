package com.sharath.pharmacy.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sharath.pharmacy.database.dao.ItemDao;
import com.sharath.pharmacy.database.entities.ItemEntity;

@Database(entities = {ItemEntity.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();

}
