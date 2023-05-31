package com.example.carshowroom.UI.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carshowroom.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1200);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(HelloActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}