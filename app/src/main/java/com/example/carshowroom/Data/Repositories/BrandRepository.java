package com.example.carshowroom.Data.Repositories;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository {
    private final List<BrandListItem> brandListItems;

    public BrandRepository() {
        brandListItems = new ArrayList<>();
        String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
        for (String brand : all_brands) {
            brandListItems.add(new BrandListItem(brand, R.drawable.car_icon));
        }
    }

    public List<BrandListItem> getBrandListItems() {
        return brandListItems;
    }
}
