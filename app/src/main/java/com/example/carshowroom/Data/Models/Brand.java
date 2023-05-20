package com.example.carshowroom.Data.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "brand_table")
public class Brand {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name; // название


    public Brand(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
