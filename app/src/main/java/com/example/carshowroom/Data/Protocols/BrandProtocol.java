package com.example.carshowroom.Data.Protocols;

import androidx.lifecycle.LiveData;

import com.example.carshowroom.Data.Models.Brand;

import java.util.List;

public interface BrandProtocol {
    LiveData<List<Brand>> getBrandList();
}
