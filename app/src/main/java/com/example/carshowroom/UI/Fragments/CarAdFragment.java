package com.example.carshowroom.UI.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarAdFragment extends Fragment {


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_ad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String car_vin = parseArgs();
        setCarData(car_vin, view);

        Button back_button = view.findViewById(R.id.back_button);
        Button fav_butoon = view.findViewById(R.id.fav_butoon);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_carAdFragment_to_mainFragment);
            }
        });

        fav_butoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Скрытие нижней навигации
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.GONE);
    }

    public String parseArgs() {
        String car_vin = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            car_vin = bundle.getString("carAd_Key");
        }
        return car_vin;
    }

    @SuppressLint("SetTextI18n")
    public void setCarData(String car_vin, View view) {
        TextView car_title = view.findViewById(R.id.car_title);
        TextView car_price = view.findViewById(R.id.car_price);
        TextView car_year = view.findViewById(R.id.year);
        TextView car_mileage = view.findViewById(R.id.mileage);
        TextView car_engine = view.findViewById(R.id.engine);
        TextView car_body = view.findViewById(R.id.body);
        TextView car_color = view.findViewById(R.id.color);
        TextView car_drive_unit = view.findViewById(R.id.drive_unit);
        TextView car_transmission = view.findViewById(R.id.transmission);
        TextView car_condition = view.findViewById(R.id.condition);
        TextView car_steering_wheel = view.findViewById(R.id.steering_wheel);
        ImageView car_image = view.findViewById(R.id.car_image);

        CarAd carAd = new CarAd(car_vin);
        car_title.setText(carAd.getBrand() + " " + carAd.getModel());
        car_price.setText(carAd.getPrice() + " $");
        car_year.setText(carAd.getYear());
        car_mileage.setText(carAd.getMileage());
        car_engine.setText(carAd.getEngine());
        car_body.setText(carAd.getBody());
        car_color.setText(carAd.getColor());
        car_drive_unit.setText(carAd.getDrive_unit());
        car_transmission.setText(carAd.getTransmission());
        car_condition.setText(carAd.getCondition());
        car_steering_wheel.setText(carAd.getSteering_wheel());
        car_image.setImageResource(carAd.getFlagResource());
    }


}
