package com.example.carshowroom.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Adapters.CarAdListAdapter;
import com.example.carshowroom.Entities.CarAdListItem;
import com.example.carshowroom.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList<CarAdListItem> carAdListItems = new ArrayList<CarAdListItem>();
        carAdListItems.add(new CarAdListItem("Nissan Skyline GT-R R34", "2002", "120 000 $", "Серый", R.drawable.skyline));
        carAdListItems.add(new CarAdListItem("Audi RS6 C8", "2021", "200 000 $", "Синий", R.drawable.rs6blue));
        carAdListItems.add(new CarAdListItem("Mazda RX-8", "2003", "9 852 $", "Серый", R.drawable.rx8));
        carAdListItems.add(new CarAdListItem("Mazda RX-7", "2002", "31 332 $", "Серый", R.drawable.rx7));
        carAdListItems.add(new CarAdListItem("Honda Civic TYPE R", "2000", "6 738 $", "Черный", R.drawable.civic));
        RecyclerView carsList = view.findViewById(R.id.carList);
        CarAdListAdapter carAdapter = new CarAdListAdapter(getContext(), carAdListItems);
        carsList.setAdapter(carAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button recyclerview_button = view.findViewById(R.id.recyclerview_button);

        recyclerview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_brandslistFragment);
            }
        });
    }
}