package com.example.carshowroom.Data.Repositories;

import com.example.carshowroom.Data.Models.CarAdListItem;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdRepository {
    private final List<CarAdListItem> carAdListItems;

    public CarAdRepository() {
        carAdListItems = new ArrayList<>();
        carAdListItems.add(new CarAdListItem("Nissan Skyline GT-R R34", "2002", "120 000 $", "Серый", "Автоматическая", "Полный", R.drawable.skyline));
        carAdListItems.add(new CarAdListItem("Audi RS5 F5", "2021", "125 000 $", "Черный", "Автоматическая", "Полный", R.drawable.rs5));
        carAdListItems.add(new CarAdListItem("Mazda RX-8", "2011", "19 852 $", "Серый", "Механическая", "Задний", R.drawable.rx8));
        carAdListItems.add(new CarAdListItem("Mazda RX-7", "2002", "31 332 $", "Серый", "Механическая", "Задний", R.drawable.rx7));
        carAdListItems.add(new CarAdListItem("Honda Civic TYPE R", "2000", "16 738 $", "Черный", "Механическая", "Передний", R.drawable.civic));
    }

    public List<CarAdListItem> getCarAdListItems() {
        return carAdListItems;
    }
}
