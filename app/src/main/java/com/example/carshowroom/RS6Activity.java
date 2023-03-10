package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RS6Activity extends AppCompatActivity {

    private static final String TAG = "MyCarShowroom";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs6);
    }

//    public void onBackClick(View v) {
//        String rs6_bet = getIntent().getStringExtra("rs6bet_key");
//        sendBet(rs6_bet);
//    }
//
//    private void sendBet(String message) {
//        Intent data = new Intent();
//        data.putExtra(MainActivity.ACCESS_BET, message);
//        setResult(RESULT_OK, data);
//        finish();
//        Log.i(TAG, "Переход к MainActivity");
//    }
}