package com.example.carshowroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    private static final String TAG = "MyCarShowroom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_review_linear);
        setContentView(R.layout.activity_review_relative);
    }

    public void backToMain(View view) {
        finish();
        Log.i(TAG, "Переход к MainActivity");
    }

    public void sendReview(View view) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Отзыв отправлен";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}