package com.example.carshowroom.UI.StateHolder.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Repositories.CarAdRepository;

import java.util.List;

public class CarAdViewModel extends ViewModel {
    private final MutableLiveData<List<CarAd>> carAdLiveData;

    public CarAdViewModel() {
        carAdLiveData = new MutableLiveData<>();
        CarAdRepository carAdRepository = new CarAdRepository();
        carAdLiveData.setValue(carAdRepository.getCarAdListItems());
    }

    public LiveData<List<CarAd>> getCarAdItemLiveData() {
        return carAdLiveData;
    }
}
