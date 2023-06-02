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

import com.example.carshowroom.Models.Car;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarAdFragment extends Fragment {

    Car car;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        car = requireArguments().getParcelable(Car.SELECTED_CAR);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_ad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCarData(view);

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

    @SuppressLint({"SetTextI18n", "DiscouragedApi"})
    public void setCarData(View view) {
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

        car_title.setText(car.getBrand() + " " + car.getModel());
        car_price.setText(car.getPrice() + " $");
        car_year.setText(car.getYear());
        car_mileage.setText(car.getMileage() + " км");
        car_engine.setText(car.getEngine());
        car_body.setText(car.getBody());
        car_color.setText(car.getColor());
        car_drive_unit.setText(car.getDrive_unit());
        car_transmission.setText(car.getTransmission());
        car_condition.setText(car.getCondition());
        car_steering_wheel.setText(car.getSteering_wheel());
        car_image.setImageResource(requireContext().getResources().getIdentifier(car.getImage(), "drawable", requireContext().getPackageName()));
    }
}
