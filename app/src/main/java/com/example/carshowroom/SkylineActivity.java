package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class SkylineActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skyline);
        TextView your_bet = (TextView) findViewById(R.id.your_bet_ru);
        String skyline_bet = getIntent().getStringExtra("skylinebet_key");
        your_bet.setText(your_bet.getText().toString() + " " + skyline_bet);
    }
}