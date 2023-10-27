package com.example.harddiskshowroom.UI.Fragments;

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

import com.example.harddiskshowroom.DB.DataBaseHelper;
import com.example.harddiskshowroom.Models.Disk;
import com.example.harddiskshowroom.Models.User;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DiskAdFragment extends Fragment {


    public interface UserProtocol {
        User getUser();
    }

    UserProtocol userGetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        userGetter = (UserProtocol) context;
    }

    Disk disk;
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
        disk = requireArguments().getParcelable(Disk.SELECTED_CAR);
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


        if (user.favorites.contains(disk)) {
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
                    user.favorites.add(disk);
                    dataBaseHelper.addToFavorites(disk.getVIN(), user.getID());

                    fav_butoon.setText("Удалить из избранного");
                    fav_butoon.setBackgroundColor(Color.parseColor("#FF0000"));
                } else {
                    user.favorites.remove(disk);
                    dataBaseHelper.deleteFromFavorites(disk.getVIN(), user.getID());
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


        car_title.setText(disk.getBrand() + " " + disk.getModel());
        car_price.setText(disk.getPrice() + " $");
        car_year.setText(String.valueOf(disk.getYear()));
        car_mileage.setText(disk.getMileage());
        car_engine.setText(disk.getEngine());
        car_body.setText(disk.getBody());
        car_color.setText(disk.getColor());
        car_drive_unit.setText(disk.getDrive_unit());
        car_transmission.setText(disk.getTransmission());
        car_condition.setText(disk.getCondition());
        car_steering_wheel.setText(disk.getSteering_wheel() + " Гб");
        // Получение изображения из ресурсов
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), requireContext().getResources().getIdentifier(disk.getImage(), "drawable", requireContext().getPackageName()));

        // Создание RoundedBitmapDrawable с использованием изображения
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);

        // Установка закругленных углов
        roundedBitmapDrawable.setCornerRadius(20);

        // Установка RoundedBitmapDrawable в качестве фона ImageView
        car_image.setImageDrawable(roundedBitmapDrawable);
    }
}