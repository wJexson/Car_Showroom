package com.example.carshowroom.UI.Fragments;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.Activities.HelloActivity;

public class BookFragment extends Fragment {

    private final String CHANNEL_ID = "BookCar";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button back_button = view.findViewById(R.id.back_button);
        Button book_button = view.findViewById(R.id.book_butoon);
        String car_vin = parseArgs();
        CarAd carAd = new CarAd(car_vin);
        createNotificationChannel();


        book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String car_name = carAd.getName();
                Bundle bundle = new Bundle();
                bundle.putString("carAd_Key", car_vin);
                showNotification(car_name);
                Navigation.findNavController(view).navigate(R.id.action_bookFragment_to_carAdFragment, bundle);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("carAd_Key", car_vin);
                Navigation.findNavController(view).navigate(R.id.action_bookFragment_to_carAdFragment, bundle);
            }
        });
    }

    public String parseArgs() {
        String car_vin = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            car_vin = bundle.getString("car_Key");
        }
        return car_vin;
    }

    private void showNotification(String car_name) {
        Intent intent = new Intent(getActivity(), CarAdFragment.class);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo, options);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Вы забронировали автомобиль " + car_name)
                .setContentTitle(getString(R.string.app_name))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(bitmap)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent);

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
