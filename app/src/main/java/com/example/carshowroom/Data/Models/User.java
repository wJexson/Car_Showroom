package com.example.carshowroom.Data.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User {
    public static final String SELECTED_USER = "USER";

    public static final String EMAIL_PATTERN = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n)";
    public static final String PHONE_PATTERN = "(^((\\+7|7|8)+([0-9]){10})$\n)";
    public static final int ADMIN_ID = 1;
    private final int ID;
    private final String fullName;
    private final String email;
    private final String telephone;
    private String password;

    public User(int id, String fullName, String email, String telephone) {
        ID = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }

    public User(int id, String fullName, String email, String telephone, String password) {
        ID = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }
}