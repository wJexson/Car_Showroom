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
import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.R;

import java.util.regex.Pattern;

public class SignUpFragment extends Fragment {

    public static final String USER_NAME = "NAME";

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
        EditText username_et = view.findViewById(R.id.editTextName);
        EditText email_et = view.findViewById(R.id.editTextEmail);
        EditText phone_et = view.findViewById(R.id.editTextPhone);
        EditText password_et = view.findViewById(R.id.editTextPassword);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username_et.getText().toString();
                String pass = password_et.getText().toString();
                String phone = phone_et.getText().toString();
                String mail = email_et.getText().toString();

                if (userName.equals("") || mail.equals("") || phone.equals("") || pass.equals("")) {
                    Toast.makeText(getActivity(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                } else if (Pattern.matches(User.EMAIL_PATTERN, email_et.getText().toString())) {
                    Toast.makeText(getActivity(), "Некорректные данные почты", Toast.LENGTH_SHORT).show();
                } else if (Pattern.matches(User.PHONE_PATTERN, phone_et.getText().toString())) {
                    Toast.makeText(getActivity(), "Некорректные данные номера телефона", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUser = dataBaseHelper.checkUserName(userName);
                    boolean checkEmail = dataBaseHelper.checkEmail(mail);
                    boolean checkPhone = dataBaseHelper.checkPhone(phone);
                    if (!checkUser & !checkEmail & !checkPhone) {
                        User user = dataBaseHelper.insertData(userName, mail, phone, pass);
                        if (user != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString(USER_NAME, username_et.getText().toString());
                            Toast.makeText(getActivity(), "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_mainFragment, bundle);
                        } else {
                            Toast.makeText(getActivity(), "Регистрация не удалась", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Пользователь c такими данными уже существует. Пожалуйста войдите", Toast.LENGTH_SHORT).show();
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