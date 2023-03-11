package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {

    private final static String TAG = "MainFragment";

    public MainFragment() {
        Log.i(TAG, "Constructor");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
        Toast.makeText(getActivity(), "onAttach", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button skyline_button = view.findViewById(R.id.skyline_button);
        Button rs6_button = view.findViewById(R.id.rs6_button);
        Button skyline_bet_button = view.findViewById(R.id.skyline_bet_button);
        Button rs6_bet_button = view.findViewById(R.id.rs6_bet_button);

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

        Log.i(TAG, "onCreateView");
        Toast.makeText(getActivity(), "onCreateView", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getActivity(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getActivity(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "onStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "onStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "onDetach", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDetach");
    }
}
