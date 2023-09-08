package com.example.carshowroom.UI.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Models.Car;
import com.example.carshowroom.Models.User;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;
import java.util.Random;

public class CarAdFragment extends Fragment {


    public interface UserProtocol {
        User getUser();
    }

    UserProtocol userGetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        userGetter = (UserProtocol) context;
    }

    Car car;
    User user;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseHelper = new DataBaseHelper(getContext());
        try {
            dataBaseHelper.createDataBase();
        } catch (Exception ignored) {
        }
        car = requireArguments().getParcelable(Car.SELECTED_CAR);
        user = userGetter.getUser();
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

        ImageView back_button = view.findViewById(R.id.back_button);
        Button fav_butoon = view.findViewById(R.id.fav_butoon);


        if (user.favorites.contains(car)) {
            fav_butoon.setText("Удалить из избранного");
            fav_butoon.setBackgroundColor(Color.parseColor("#FF0000"));
        }


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });

        fav_butoon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                dataBaseHelper.openDataBase();
                if (fav_butoon.getText().equals("Добавить в избранное")) {
                    Random random = new Random();
                    int randomValue = random.nextInt(2);
                    System.out.println(randomValue);
                    if (randomValue == 1) {
                        user.favorites.add(car);
                        dataBaseHelper.addToFavorites(car.getVIN(), user.getID());
                    }

                    fav_butoon.setText("Удалить из избранного");
                    fav_butoon.setBackgroundColor(Color.parseColor("#FF0000"));
                } else {
                    user.favorites.remove(car);
                    dataBaseHelper.deleteFromFavorites(car.getVIN(), user.getID());
                    fav_butoon.setText("Добавить в избранное");
                    fav_butoon.setBackgroundColor(Color.parseColor("#FF000000"));
                }
                dataBaseHelper.close();
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
        car_year.setText(String.valueOf(car.getYear()));
        car_mileage.setText(car.getMileage() + " км");
        car_engine.setText(car.getEngine());
        car_body.setText(car.getBody());
        car_color.setText(car.getColor());
        car_drive_unit.setText(car.getDrive_unit());
        car_transmission.setText(car.getTransmission());
        car_condition.setText(car.getCondition());
        car_steering_wheel.setText(car.getSteering_wheel());
        // Получение изображения из ресурсов
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), requireContext().getResources().getIdentifier(car.getImage(), "drawable", requireContext().getPackageName()));

        // Создание RoundedBitmapDrawable с использованием изображения
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);

        // Установка закругленных углов
        roundedBitmapDrawable.setCornerRadius(20);

        // Установка RoundedBitmapDrawable в качестве фона ImageView
        car_image.setImageDrawable(roundedBitmapDrawable);

        Random random = new Random();
        int randomValue = random.nextInt(3);
        System.out.println(randomValue);
        if (randomValue == 1) {
            car_image.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}
