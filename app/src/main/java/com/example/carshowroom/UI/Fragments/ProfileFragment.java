package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView username = view.findViewById(R.id.userName);
        TextView mail = view.findViewById(R.id.email);
        TextView phone = view.findViewById(R.id.phone);
        Button exit_button = view.findViewById(R.id.exit_button);
        Button review_button = view.findViewById(R.id.review_button);
        Button about_button = view.findViewById(R.id.about_button);
        DataBaseHelper dbHelper = new DataBaseHelper(getActivity());

        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);


        User user = dbHelper.getUserById(parseArgs());
        if (user != null) {
            // Используйте данные пользователя для заполнения соответствующих полей во фрагменте
            username.setText(user.getFullName());
            mail.setText(user.getEmail());
            phone.setText(user.getTelephone());
        }


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.mainFragment) {
                Bundle bundle = new Bundle();
                bundle.putInt("userId", parseArgs());
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_mainFragment, bundle);
                return true;
            }
            return false;
        });

        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_reviewFragment);
            }
        });

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_aboutFragment);
            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_authFragment);
            }
        });
    }

    public int parseArgs() {
        int user_id = -1;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            user_id = bundle.getInt("userId");
        }
        return user_id;
    }
}