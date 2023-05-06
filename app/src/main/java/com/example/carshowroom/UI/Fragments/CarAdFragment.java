package com.example.carshowroom.UI.Fragments;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

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
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

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
        String car_name = parseArgs();
        setCarData(car_name, view);

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
                showNotification(car_name);
            }
        });
    }

    public String parseArgs() {
        String car_name = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            car_name = bundle.getString("carAd_Key");
        }
        return car_name;
    }

    @SuppressLint("SetTextI18n")
    public void setCarData(String car_name, View view) {
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
        car_title.setText(car_name);
        if (Objects.equals(car_name, "Nissan Skyline GT-R R34")) {
            car_image.setImageResource(R.drawable.skyline);
            car_price.setText("120 000 $");
            car_year.setText("2002");
            car_mileage.setText("42 000 км");
            car_engine.setText("2.5 л / 280 л.с. / Бензин");
            car_body.setText("Купе");
            car_color.setText("Серый");
            car_drive_unit.setText("Полный");
            car_transmission.setText("Автоматическая");
        } else if (Objects.equals(car_name, "Audi RS5 F5")) {
            car_image.setImageResource(R.drawable.rs5);
            car_price.setText("125 000 $");
            car_year.setText("2021");
            car_mileage.setText("20 км");
            car_engine.setText("2.9 л / 450 л.с. / Бензин");
            car_body.setText("Купе");
            car_color.setText("Черный");
            car_drive_unit.setText("Полный");
            car_transmission.setText("Автоматическая");
        } else if (Objects.equals(car_name, "Mazda RX-8")) {
            car_image.setImageResource(R.drawable.rx8);
            car_price.setText("19 852 $");
            car_year.setText("2011");
            car_mileage.setText("190  125 км");
            car_engine.setText("1.3 / 250 л.c. / Бензин");
            car_body.setText("Купе");
            car_color.setText("Серый");
            car_drive_unit.setText("Задний");
            car_transmission.setText("Механическая");
        } else if (Objects.equals(car_name, "Mazda RX-7")) {
            car_image.setImageResource(R.drawable.rx7);
            car_price.setText("31 332 $");
            car_year.setText("2002");
            car_mileage.setText("58 000 км");
            car_engine.setText("1.3 / 280 л.c. / Бензин");
            car_body.setText("Купе");
            car_color.setText("Серый");
            car_drive_unit.setText("Задний");
            car_transmission.setText("Механическая");
        } else if (Objects.equals(car_name, "Honda Civic TYPE R")) {
            car_image.setImageResource(R.drawable.civic);
            car_price.setText("16 738 $");
            car_year.setText("2000");
            car_mileage.setText("168 000 км");
            car_engine.setText("1.6 / 185 л.c. / Бензин");
            car_body.setText("Хэтчбек 3 дв.");
            car_color.setText("Черный");
            car_drive_unit.setText("Передний");
            car_transmission.setText("Механическая");
        }


//        if (allowed) {
//            String fileName = "car_info";
//            String car_info = car_name + "\n" + car_price.getText() + "\n" + car_year.getText() + "\n" + car_mileage.getText()
//                    + "\n" + car_engine.getText() + "\n" + car_body.getText() + "\n" + car_color.getText()
//                    + "\n" + car_drive_unit.getText() + "\n" + car_transmission.getText();
//            System.out.println(car_info);
//            File file_car_info = new File("/storage/emulated/0/Android/data", fileName);
//            try {
//                FileOutputStream fos = new FileOutputStream(file_car_info);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                writer.write(car_info);
//                writer.close();
//                fos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }


    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
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
