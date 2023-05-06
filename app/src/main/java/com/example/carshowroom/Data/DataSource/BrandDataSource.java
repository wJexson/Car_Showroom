package com.example.carshowroom.Data.DataSource;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.carshowroom.DB.BrandDao;
import com.example.carshowroom.DB.BrandDataBase;
import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class BrandDataSource {
    private final Context context;

    public BrandDataSource(Context context) {
        this.context = context;
    }

    public LiveData<List<Brand>> getBrandList() {
        List<Brand> brandList = new ArrayList<>();

        String[] all_brands = context.getResources().getStringArray(R.array.Auto_brands);


        for (String brand : all_brands) {
            brandList.add(new Brand(brand));
        }

        BrandDataBase dataBase = BrandDataBase.getDatabase(context);
        BrandDao brandDao = dataBase.brandDao();
        dataBase.getQueryExecutor().execute(() -> {
            for (Brand brand : brandList) {
                brandDao.insert(brand);
            }
        });
        return brandDao.getBrandList();
    }
}
