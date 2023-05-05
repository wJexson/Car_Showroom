package com.example.carshowroom.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.carshowroom.Data.Models.Brand;

import java.util.List;

@Dao
public interface BrandDao {
    @Query("SELECT * FROM brand_table")
    LiveData<List<Brand>> getBrandList();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Brand brand);
}
