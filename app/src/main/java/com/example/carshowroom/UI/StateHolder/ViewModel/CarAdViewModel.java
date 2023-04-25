package com.example.carshowroom.UI.StateHolder.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.CarAdListItem;
import com.example.carshowroom.Data.Repositories.CarAdRepository;

import java.util.List;

public class CarAdViewModel extends ViewModel {
    private final MutableLiveData<List<CarAdListItem>> carAdItemListLiveData;

    public CarAdViewModel() {
        carAdItemListLiveData = new MutableLiveData<>();
        CarAdRepository carAdRepository = new CarAdRepository();
        carAdItemListLiveData.setValue(carAdRepository.getCarAdListItemList());
    }

    public LiveData<List<CarAdListItem>> getCarAdItemLiveData() {
        return carAdItemListLiveData;
    }
}
