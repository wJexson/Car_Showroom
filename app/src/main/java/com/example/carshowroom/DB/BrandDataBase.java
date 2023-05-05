package com.example.carshowroom.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.carshowroom.Data.Models.Brand;

@Database(entities = {Brand.class}, version = 1, exportSchema = false)
public abstract class BrandDataBase extends RoomDatabase {
    private static volatile BrandDataBase INSTANCE;

    public abstract BrandDao brandDao();

    public static BrandDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BrandDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BrandDataBase.class, "brand_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
