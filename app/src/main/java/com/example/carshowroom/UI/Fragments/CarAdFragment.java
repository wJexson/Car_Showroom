package com.example.carshowroom.UI.Fragments;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;

public class CarAdFragment extends Fragment {

    private final String CHANNEL_ID = "CarAd";

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
        Button book_button = view.findViewById(R.id.book_butoon);
        createNotificationChannel();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skylineFragment_to_mainFragment);
            }
        });

        book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarAd carAd = new CarAd(car_vin);
                showNotification(carAd.getName());
            }
        });
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
        ImageView car_image = view.findViewById(R.id.car_image);

        CarAd carAd = new CarAd(car_vin);
        car_title.setText(carAd.getName());
        car_price.setText(carAd.getPrice());
        car_year.setText(carAd.getYear());
        car_mileage.setText(carAd.getMileage());
        car_engine.setText(carAd.getEngine());
        car_body.setText(carAd.getBody());
        car_color.setText(carAd.getColor());
        car_drive_unit.setText(carAd.getDrive_unit());
        car_transmission.setText(carAd.getTransmission());
        car_image.setImageResource(carAd.getFlagResource());
    }


    private void showNotification(String car_name) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo, options);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Вы забронировали автомобиль " + car_name)
                .setContentTitle(getString(R.string.app_name))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(bitmap)
                .setWhen(System.currentTimeMillis());

        Notification notification = notificationBuilder.build();
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
