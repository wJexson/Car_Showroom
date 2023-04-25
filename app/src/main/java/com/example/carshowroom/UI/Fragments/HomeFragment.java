package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.CarAdListAdapter;
import com.example.carshowroom.UI.StateHolder.ViewModel.CarAdViewModel;

public class HomeFragment extends Fragment {

    private CarAdListAdapter carAdListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarAdViewModel carAdViewModel = new ViewModelProvider(this).get(CarAdViewModel.class);
        carAdListAdapter = new CarAdListAdapter(carAdViewModel.getCarAdItemLiveData());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView carList = view.findViewById(R.id.carList);
        carList.setAdapter(carAdListAdapter);
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