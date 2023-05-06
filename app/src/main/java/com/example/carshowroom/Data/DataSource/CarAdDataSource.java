package com.example.carshowroom.Data.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.carshowroom.Data.Models.CarAd;

import java.util.ArrayList;
import java.util.List;

public class CarAdDataSource {


    public LiveData<List<CarAd>> getCarAdList() {
        List<CarAd> carAdList;
        carAdList = new ArrayList<>();
        carAdList.add(new CarAd("JN1AR34D12A000001"));
        carAdList.add(new CarAd("WAUZZZF57MA900001"));
        carAdList.add(new CarAd("JM1FE1C43B0400001"));
        carAdList.add(new CarAd("JM1FD3332P0200001"));
        carAdList.add(new CarAd("EK9-1000001"));
        MutableLiveData<List<CarAd>> carAdListLd = new MutableLiveData<>();
        carAdListLd.setValue(carAdList);
        return carAdListLd;
    }
}
