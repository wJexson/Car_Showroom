package com.example.carshowroom;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyCarShowroom";
    private EditText skyline_bet_et, rs6_bet_et;
    static final String ACCESS_BET = "ACCESS_BET";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cars_in_stock=(TextView) findViewById(R.id.cars_in_stock);
        cars_in_stock.setText("Автомобили в наличии");
        TextView skyline_title=(TextView) findViewById(R.id.skyline_title);
        skyline_title.setText("Nissan Skyline GT-R (R34)");
        TextView rs6_title=(TextView) findViewById(R.id.rs6_title);
        rs6_title.setText("Audi RS6 (C8)");



        rs6_bet_et = (EditText) findViewById(R.id.rs6_bet_edittext);
        skyline_bet_et = (EditText) findViewById(R.id.skyline_bet_edittext);
        Button skyline_button = (Button) findViewById(R.id.skyline_button);
        Button rs6_button = (Button) findViewById(R.id.rs6_button);
        Intent intent_skyline = new Intent(this, SkylineActivity.class);
        Intent intent_rs6 = new Intent(this, RS6Activity.class);

        skyline_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_skyline.putExtra("skylinebet_key", skyline_bet_et.getText().toString());
                mStartForResultSkyline.launch(intent_skyline);
                Log.i(TAG, "Переход к SkylineActivity");
            }
        });

        rs6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_rs6.putExtra("rs6bet_key", rs6_bet_et.getText().toString());
                mStartForResultRS6.launch(intent_rs6);
                Log.i(TAG, "Переход к RS6Activity");
            }
        });
    }

//    public void show_skyline(View view) {
//        Intent intent = new Intent(this, SkylineActivity.class);
//        intent.putExtra("skylinebet_key", skyline_bet_et.getText().toString());
//        startActivity(intent);
//        Log.i(TAG, "Переход к SkylineActivity");
//    }

//    public void show_rs6(View view) {
//        Intent intent = new Intent(this, RS6Activity.class);
//        intent.putExtra("rs6bet_key", rs6_bet_et.getText().toString());
//        startActivity(intent);
//        Log.i(TAG, "Переход к RS6Activity");
//    }

    public void make_bet_skyline(View v) {
        if (v.getId() == R.id.skyline_bet_button) {
            Intent intent = new Intent(this, SkylineActivity.class);
            intent.putExtra("skylinebet_key", skyline_bet_et.getText().toString());
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Ставка принята";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void make_bet_rs6(View v) {
        if (v.getId() == R.id.rs6_bet_button) {
            Intent intent = new Intent(this, RS6Activity.class);
            intent.putExtra("rs6bet_key", rs6_bet_et.getText().toString());
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Ставка принята";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    ActivityResultLauncher<Intent> mStartForResultSkyline = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onActivityResult(ActivityResult result) {

            TextView your_bet = findViewById(R.id.your_bet_skyline_ru);
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();
                String accessBet = intent.getStringExtra(ACCESS_BET);
                your_bet.setText(your_bet.getText().toString() + "  " + accessBet);
            }
        }
    });

    ActivityResultLauncher<Intent> mStartForResultRS6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onActivityResult(ActivityResult result) {

            TextView your_bet = findViewById(R.id.your_bet_rs6_ru);
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();
                String accessBet = intent.getStringExtra(ACCESS_BET);
                your_bet.setText(your_bet.getText().toString() + "  " + accessBet);
            }
        }
    });
}