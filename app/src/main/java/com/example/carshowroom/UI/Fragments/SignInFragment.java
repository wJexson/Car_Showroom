package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.R;


public class SignInFragment extends Fragment {

    public static final String USER_NAME = "NAME";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonLogIn = view.findViewById(R.id.buttonLogIn);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);
        EditText username_et = view.findViewById(R.id.editTextName);
        EditText password_et = view.findViewById(R.id.editTextPassword);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = username_et.getText().toString();
                String pass = password_et.getText().toString();

                if (userName.equals("") || pass.equals(""))
                    Toast.makeText(getActivity(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = dataBaseHelper.checkUserNamePassword(userName, pass);
                    if (checkuserpass) {
                        Toast.makeText(getActivity(), "Вход успешен", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_mainFragment);
                    } else {
                        Toast.makeText(getActivity(), "Недействительные учетные данные", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });
    }
}