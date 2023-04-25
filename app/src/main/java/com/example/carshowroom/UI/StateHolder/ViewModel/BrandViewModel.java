package com.example.carshowroom.UI.StateHolder.ViewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.Data.Repositories.BrandRepository;

import java.util.List;

public class BrandViewModel extends ViewModel {
    private final MutableLiveData<List<BrandListItem>> brandItemListLiveData;

    public BrandViewModel() {
        brandItemListLiveData = new MutableLiveData<>();
        BrandRepository brandRepository = new BrandRepository();
        brandItemListLiveData.setValue(brandRepository.getBrandListItems());

    }

    public MutableLiveData<List<BrandListItem>> getBrandItemListLiveData() {
        return brandItemListLiveData;
    }
}