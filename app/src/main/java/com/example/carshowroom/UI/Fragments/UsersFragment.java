package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carshowroom.Adapters.UsersAdapter;
import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.R;


public class UsersFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button back_button = view.findViewById(R.id.back_button);

        RecyclerView usersList = view.findViewById(R.id.usersList);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        dataBaseHelper.openDataBase();
        UsersAdapter usersAdapter = new UsersAdapter(dataBaseHelper.getAllUsers());
        dataBaseHelper.close();
        usersList.setAdapter(usersAdapter);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
    }
}