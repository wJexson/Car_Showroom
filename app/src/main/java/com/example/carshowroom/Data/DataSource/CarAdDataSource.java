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
        carAdList.add(new CarAd("JN1AR34D12A000001")); // Skyline R34
        carAdList.add(new CarAd("WAUZZZF57MA900001")); // RS 5
        carAdList.add(new CarAd("JM1FE1C43B0400001")); // RX-8
        carAdList.add(new CarAd("JM1FD3332P0200001")); // RX-7
        carAdList.add(new CarAd("EK9-1000001")); // Civic
        carAdList.add(new CarAd("WBSBL93435PN63001")); // M3
        carAdList.add(new CarAd("WDDZF8KB7JA421234")); // E63S
        carAdList.add(new CarAd("JT2DE82A020062413")); // Supra A80
        MutableLiveData<List<CarAd>> carAdListLd = new MutableLiveData<>();
        carAdListLd.setValue(carAdList);
        return carAdListLd;
    }
}
