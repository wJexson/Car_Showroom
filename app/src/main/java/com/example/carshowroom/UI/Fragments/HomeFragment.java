package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button brandList_button = view.findViewById(R.id.brandList_button);
        Button review_button = view.findViewById(R.id.review_button);

        CarAdListViewModel carAdListViewModel = new ViewModelProvider(this).get(CarAdListViewModel.class);
        carAdListViewModel.carAdList.observe(getViewLifecycleOwner(), new Observer<List<CarAd>>() {
            @Override
            public void onChanged(List<CarAd> carAds) {
                CarAdListAdapter carAdListAdapter = new CarAdListAdapter(carAds);
                carAdListAdapter.onClickListener = new CarAdListAdapter.OnCarAdClickListener() {
                    @Override
                    public void onCarAdClick(CarAd carAdListItem) {
                        String car_name = carAdListItem.getName();
                        String fileName = "car_brand";
                        File dir = requireContext().getFilesDir();
                        File file_car = new File(dir, fileName);
                        try {
                            FileOutputStream fos = new FileOutputStream(file_car);
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                            writer.write(car_name);
                            writer.close();
                            fos.close();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                        Bundle bundle = new Bundle();
                        bundle.putString("carAd_Key", car_name);
                        Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_carAdFragment, bundle);
                    }
                };
                RecyclerView carAdList = view.findViewById(R.id.carAdList);
                carAdList.setAdapter(carAdListAdapter);
            }
        });

        brandList_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_brandslistFragment);
            }
        });

        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_reviewFragment);
            }
        });
    }
}