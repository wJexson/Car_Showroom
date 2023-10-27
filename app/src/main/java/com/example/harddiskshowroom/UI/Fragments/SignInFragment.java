package com.example.harddiskshowroom.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.harddiskshowroom.DB.DataBaseHelper;
import com.example.carshowroom.R;


public class SignInFragment extends Fragment {

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
        dataBaseHelper.openDataBase();
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username_et.getText().toString();
                String pass = password_et.getText().toString();
                dataBaseHelper.signIn(userName, pass, v);
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