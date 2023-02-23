package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkylineActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skyline);
        TextView your_bet = (TextView) findViewById(R.id.your_bet_ru);
        String skyline_bet = getIntent().getStringExtra("skylinebet_key");
        your_bet.setText(your_bet.getText().toString() + "  " + skyline_bet);
    }

    public void onBackClick(View v) {
        String skyline_bet = getIntent().getStringExtra("skylinebet_key");
        sendBet(skyline_bet);
    }

    private void sendBet(String message) {
        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_BET, message);
        setResult(RESULT_OK, data);
        finish();
    }
}