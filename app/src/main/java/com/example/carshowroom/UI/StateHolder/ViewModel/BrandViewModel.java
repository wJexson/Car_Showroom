package com.example.carshowroom.UI.StateHolder.ViewModel;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.Data.Repositories.BrandRepository;

import java.util.List;

public class BrandViewModel extends ViewModel {
    private final MutableLiveData<List<BrandListItem>> brandListtemLiveData;

    public BrandViewModel(Context context) {
        brandListtemLiveData = new MutableLiveData<>();
        BrandRepository brandRepository = new BrandRepository(context);
        brandListtemLiveData.setValue(brandRepository.getBrandListItems());

    }

    public MutableLiveData<List<BrandListItem>> getBrandItemListLiveData() {
        return brandListtemLiveData;
    }
}