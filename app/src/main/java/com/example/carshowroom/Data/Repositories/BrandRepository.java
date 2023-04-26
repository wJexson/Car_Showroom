package com.example.carshowroom.Data.Repositories;

import android.content.Context;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository {
    private final List<Brand> brandList;


    public BrandRepository(Context context) {
        brandList = new ArrayList<>();
        String[] all_brands = context.getResources().getStringArray(R.array.Auto_brands);
        for (String brand : all_brands) {
            brandList.add(new Brand(brand, R.drawable.car_icon));
        }
    }


    public List<Brand> getBrandListItems() {
        return brandList;
    }
}
