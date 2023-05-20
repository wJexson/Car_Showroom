package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.R;

public class SignUpFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonLogIn = view.findViewById(R.id.buttonLogIn);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);
        EditText username = view.findViewById(R.id.editTextName);
        EditText email = view.findViewById(R.id.editTextEmail);
        EditText phone_number = view.findViewById(R.id.editTextPhone);
        EditText password = view.findViewById(R.id.editTextPassword);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String phone = phone_number.getText().toString();
                String mail = email.getText().toString();

                if (user.equals("") || mail.equals("") || phone.equals("") || pass.equals(""))
                    Toast.makeText(getActivity(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = dataBaseHelper.checkusername(user);
                    if (!checkuser) {
                        Boolean insert = dataBaseHelper.insertData(user, mail, phone, pass);
                        if (insert) {
                            Toast.makeText(getActivity(), "Registered successfully", Toast.LENGTH_SHORT).show();
                            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_mainFragment);
                        } else {
                            Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });
    }
}