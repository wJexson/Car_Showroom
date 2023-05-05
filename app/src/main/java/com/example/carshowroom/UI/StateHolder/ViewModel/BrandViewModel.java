package com.example.carshowroom.UI.StateHolder.ViewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.Data.Repositories.BrandRepository;

import java.util.List;

public class BrandViewModel extends AndroidViewModel {

    private final BrandRepository brandRepository = new BrandRepository(getApplication());

    public LiveData<List<Brand>> brandList = brandRepository.getBrandList();

    public BrandViewModel(@NonNull Application application) {
        super(application);
    }
}