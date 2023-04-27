package com.example.carshowroom.Data.Protocols;

import androidx.lifecycle.LiveData;

import com.example.carshowroom.Data.Models.CarAd;

import java.util.List;

public interface CarAdProtocol {
    LiveData<List<CarAd>> getCarAdList();
}
