package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.CarAdListAdapter;
import com.example.carshowroom.UI.StateHolder.ViewModel.CarAdListViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.profileFragment) {
                Bundle bundle = new Bundle();
                bundle.putInt("userId", parseArgs());
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_profileFragment, bundle);
                return true;
            }
            return false;
        });


        CarAdListViewModel carAdListViewModel = new ViewModelProvider(this).get(CarAdListViewModel.class);
        carAdListViewModel.carAdList.observe(getViewLifecycleOwner(), new Observer<List<CarAd>>() {
            @Override
            public void onChanged(List<CarAd> carAds) {
                CarAdListAdapter carAdListAdapter = new CarAdListAdapter(carAds);
                carAdListAdapter.onClickListener = new CarAdListAdapter.OnCarAdClickListener() {
                    @Override
                    public void onCarAdClick(CarAd carAdListItem) {
                        String car_vin = carAdListItem.getVIN();
                        Bundle bundle = new Bundle();
                        bundle.putString("carAd_Key", car_vin);
                        Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_carAdFragment, bundle);
                    }
                };
                RecyclerView carAdList = view.findViewById(R.id.carAdList);
                carAdList.setAdapter(carAdListAdapter);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Показ нижней навигации
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    public int parseArgs() {
        int user_id = -1;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            user_id = bundle.getInt("userId");
        }
        return user_id;
    }
}