package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyCarShowroom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show_skyline(View view) {
        Intent intent = new Intent(this, SkylineActivity.class);
        startActivity(intent);
        Log.i(TAG, "Переход к подробной информации по авто Nissan Skyline GT-R (R34)");
    }

    public void show_rs6(View view) {
        Intent intent = new Intent(this, RS6Activity.class);
        startActivity(intent);
        Log.i(TAG, "Переход к подробной информации по авто Audi RS6 (C8)");
    }
}