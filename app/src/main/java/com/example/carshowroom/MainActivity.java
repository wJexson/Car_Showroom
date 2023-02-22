package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
        Log.i(TAG, "Переход к SkylineActivity");
    }

    public void make_bet_skyline(View v) {
        EditText betText = findViewById(R.id.skyline_bet_edittext);
        int bet = Integer.parseInt(betText.getText().toString());
        Intent intent = new Intent(this, SkylineActivity.class);
        intent.putExtra("skyline_bet", bet);
        startActivity(intent);
        Log.i(TAG, "Переход к SkylineActivity");
    }

    public void show_rs6(View view) {
        Intent intent = new Intent(this, RS6Activity.class);
        startActivity(intent);
        Log.i(TAG, "Переход к RS6Activity");
    }

    public void make_bet_rs6(View v) {
        EditText betText = findViewById(R.id.skyline_bet_edittext);
        int bet = Integer.parseInt(betText.getText().toString());
        Intent intent = new Intent(this, RS6Activity.class);
        intent.putExtra("rs6_bet", bet);
        startActivity(intent);
        Log.i(TAG, "Переход к RS6Activity");
    }
}