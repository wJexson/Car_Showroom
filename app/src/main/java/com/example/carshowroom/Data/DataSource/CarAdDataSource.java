package com.example.carshowroom.Data.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdDataSource {
    public LiveData<List<CarAd>> getCarAdList() {
        List<CarAd> carAdList;
        carAdList = new ArrayList<>();
        carAdList.add(new CarAd("Nissan Skyline GT-R R34", "2002", "120 000 $", "Серый", "Автоматическая", "Полный", R.drawable.skyline));
        carAdList.add(new CarAd("Audi RS5 F5", "2021", "125 000 $", "Черный", "Автоматическая", "Полный", R.drawable.rs5));
        carAdList.add(new CarAd("Mazda RX-8", "2011", "19 852 $", "Серый", "Механическая", "Задний", R.drawable.rx8));
        carAdList.add(new CarAd("Mazda RX-7", "2002", "31 332 $", "Серый", "Механическая", "Задний", R.drawable.rx7));
        carAdList.add(new CarAd("Honda Civic TYPE R", "2000", "16 738 $", "Черный", "Механическая", "Передний", R.drawable.civic));
        MutableLiveData<List<CarAd>> carAdListLd = new MutableLiveData<>();
        carAdListLd.setValue(carAdList);
        return carAdListLd;
    }
}
