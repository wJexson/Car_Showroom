package com.example.carshowroom;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button skyline_button = view.findViewById(R.id.skyline_button);
        Button rs6_button = view.findViewById(R.id.rs6_button);
        Button skyline_bet_button = view.findViewById(R.id.skyline_bet_button);
        Button rs6_bet_button = view.findViewById(R.id.rs6_bet_button);
        Button listview_button = view.findViewById(R.id.listview_button);

        skyline_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container_view, new SkylineFragment());
                fr.commit();
            }
        });

        rs6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container_view, new RS6Fragment());
                fr.commit();
            }
        });

        listview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container_view, new ListViewFragment());
                fr.commit();
            }
        });

        skyline_bet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText skyline_et = view.findViewById(R.id.skyline_bet_edittext);
                Bundle bet = new Bundle();
                bet.putString("skyline_bet_bundleKey", skyline_et.getText().toString());
                getParentFragmentManager().setFragmentResult("skyline_bet_requestKey", bet);
            }
        });

        rs6_bet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rs6_et = view.findViewById(R.id.rs6_bet_edtttext);
                Bundle bet = new Bundle();
                bet.putString("rs6_bet_bundleKey", rs6_et.getText().toString());
                getParentFragmentManager().setFragmentResult("rs6_bet_requestKey", bet);
            }
        });

        return view;
    }
}