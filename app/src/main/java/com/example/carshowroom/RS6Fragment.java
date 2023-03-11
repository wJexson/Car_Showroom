package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class RS6Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rs6, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        getParentFragmentManager().setFragmentResultListener("rs6_bet_requestKey", this, new FragmentResultListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("rs6_bet_bundleKey");
                TextView your_bet = view.findViewById(R.id.your_bet_ru);
                your_bet.setText(your_bet.getText().toString() + "  " + data);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container_view, new MainFragment());
                fr.commit();
            }
        });
        return view;
    }
}
