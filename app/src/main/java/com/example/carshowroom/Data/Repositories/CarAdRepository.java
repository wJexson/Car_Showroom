package com.example.carshowroom.Data.Repositories;

import com.example.carshowroom.Data.Models.CarAdListItem;
import com.example.carshowroom.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdRepository {
    private final List<CarAdListItem> carAdListItems;

    public CarAdRepository() {
        carAdListItems = new ArrayList<>();
        carAdListItems.add(new CarAdListItem("Nissan Skyline GT-R R34", "2002", "120 000 $", "Серый", R.drawable.skyline));
        carAdListItems.add(new CarAdListItem("Audi RS6 C8", "2021", "200 000 $", "Синий", R.drawable.rs6blue));
        carAdListItems.add(new CarAdListItem("Mazda RX-8", "2003", "9 852 $", "Серый", R.drawable.rx8));
        carAdListItems.add(new CarAdListItem("Mazda RX-7", "2002", "31 332 $", "Серый", R.drawable.rx7));
        carAdListItems.add(new CarAdListItem("Honda Civic TYPE R", "2000", "6 738 $", "Черный", R.drawable.civic));
    }

    public List<CarAdListItem> getCarAdListItems() {
        return carAdListItems;
    }
}
