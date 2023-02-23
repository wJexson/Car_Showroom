package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RS6Activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs6);
        TextView your_bet = (TextView) findViewById(R.id.your_bet_ru);
        String rs6_bet = getIntent().getStringExtra("rs6bet_key");
        your_bet.setText(your_bet.getText().toString() + "  " + rs6_bet);
    }

    public void onBackClick(View v) {
        String rs6_bet = getIntent().getStringExtra("rs6bet_key");
        sendBet(rs6_bet);
    }

    private void sendBet(String message) {
        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_BET, message);
        setResult(RESULT_OK, data);
        finish();
    }
}