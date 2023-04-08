package com.example.carshowroom.Fragments;

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

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.R;

public class SkylineFragment extends Fragment {

    private final String CHANNEL_ID = "skyline";

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skyline, container, false);
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
                showNotification();
            }
        });

        return view;
    }

    private void showNotification() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo, options);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Вы забронировали автомобиль Nissan Skyline GT-R R34")
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
