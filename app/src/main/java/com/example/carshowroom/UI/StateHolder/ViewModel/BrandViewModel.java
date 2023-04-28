package com.example.carshowroom.UI.StateHolder.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.Data.Repositories.BrandRepository;

import java.util.List;

public class BrandViewModel extends ViewModel {

    private final BrandRepository brandRepository = new BrandRepository();
    public LiveData<List<Brand>> brandList = brandRepository.getBrandList();

}