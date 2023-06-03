package com.example.carshowroom.UI.Fragments;

import android.content.Context;
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

import com.example.carshowroom.Models.User;
import com.example.carshowroom.R;


public class ProfileFragment extends Fragment {


    public interface UserProtocol {
        User getUser();
    }

    UserProtocol userGetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        userGetter = (UserProtocol) context;
    }

    User user;
    TextView username, mail, phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        user = userGetter.getUser();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button exit_button = view.findViewById(R.id.exit_button);
        Button review_button = view.findViewById(R.id.review_button);
        Button about_button = view.findViewById(R.id.about_button);


        Button all_users_button = view.findViewById(R.id.all_users_button);
        if (user.getID() == User.ADMIN_ID) {
            all_users_button.setVisibility(View.VISIBLE);
        } else {
            all_users_button.setVisibility(View.GONE);
        }

        username = view.findViewById(R.id.userName);
        mail = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);

        username.setText(user.getUserName());
        mail.setText(user.getEmail());
        phone.setText(user.getPhone());

        all_users_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_usersFragment);
            }
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

    @Override
    public void onDestroyView() {
        username = null;
        mail = null;
        phone = null;
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        userGetter = null;
        super.onDetach();
    }
}