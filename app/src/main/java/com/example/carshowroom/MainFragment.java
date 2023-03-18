package com.example.carshowroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button skyline_button = view.findViewById(R.id.skyline_button);
        Button rs6_button = view.findViewById(R.id.rs6_button);
        Button recyclerview_button = view.findViewById(R.id.recyclerview_button);
        Button skyline_bet_button = view.findViewById(R.id.skyline_bet_button);
        Button rs6_bet_button = view.findViewById(R.id.rs6_bet_button);


        skyline_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_skylineFragment);
            }
        });

        rs6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_rs6Fragment);
            }
        });

        recyclerview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_brandslistFragment);
            }
        });

        skyline_bet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText skyline_et = view.findViewById(R.id.skyline_bet_edittext);
                String bet_data = skyline_et.getText().toString();
                if (bet_data.equals("")) {
                    bet_data = "0";
                }
                Bundle bet = new Bundle();
                bet.putString("skyline_bet_Key", bet_data);
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_skylineFragment, bet);
            }
        });

        rs6_bet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rs6_et = view.findViewById(R.id.rs6_bet_edtttext);
                String bet_data = rs6_et.getText().toString();
                if (bet_data.equals("")) {
                    bet_data = "0";
                }
                Bundle bet = new Bundle();
                bet.putString("rs6_bet_Key", bet_data);
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_rs6Fragment, bet);
            }
        });

        return view;
    }
}