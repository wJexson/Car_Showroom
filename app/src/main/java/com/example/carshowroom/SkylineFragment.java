package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class SkylineFragment extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skyline, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        TextView your_bet = view.findViewById(R.id.your_bet_ru);
        String res = getArguments().getString("skyline_bet_Key");
        if (res == null) {
            res = "0";
        }
        your_bet.setText(your_bet.getText().toString() + "  " + res + " $");

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_skylineFragment_to_mainFragment);
            }
        });
        return view;
    }
}
