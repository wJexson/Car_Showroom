package com.example.carshowroom.UI.StateHolder.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Repositories.CarAdRepository;

import java.util.List;

public class CarAdListViewModel extends AndroidViewModel {
    private final CarAdRepository carAdRepository = new CarAdRepository();
    public LiveData<List<CarAd>> carAdList = carAdRepository.getCarAdList();

    public CarAdListViewModel(@NonNull Application application) {
        super(application);
    }

}
