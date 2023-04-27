package com.example.carshowroom.UI.StateHolder.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Repositories.CarAdRepository;

import java.util.List;

public class CarAdListViewModel extends ViewModel {
    private final CarAdRepository carAdRepository = new CarAdRepository();
    public LiveData<List<CarAd>> carAdList = carAdRepository.getCarAdList();
}
