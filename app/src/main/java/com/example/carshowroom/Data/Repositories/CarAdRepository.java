package com.example.carshowroom.Data.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.carshowroom.Data.DataSource.CarAdDataSource;
import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Protocols.CarAdProtocol;

import java.util.List;

public class CarAdRepository implements CarAdProtocol {
    private final CarAdDataSource carAdDataSource = new CarAdDataSource();

    public void takeCarTitle(CarAd carAd, Context context) {
        carAdDataSource.takeCarTitle(carAd, context);
    }

    @Override
    public LiveData<List<CarAd>> getCarAdList() {
        return carAdDataSource.getCarAdList();
    }
}
