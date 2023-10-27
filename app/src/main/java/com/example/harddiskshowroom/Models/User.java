package com.example.harddiskshowroom.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class User implements Parcelable {
    public static final String SELECTED_USER = "USER";

    public static final String EMAIL_PATTERN = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n)";
    public static final String PHONE_PATTERN = "(^((\\+7|7|8)+([0-9]){10})$\n)";
    public static final int ADMIN_ID = 1;
    public ArrayList<Disk> favorites = new ArrayList<>();
    private final int ID;
    private final String userName;
    private final String email;
    private final String phone;
    private final String password;

    public User(int id, String userName, String email, String phone, String password) {
        ID = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public User(int id, String userName, String email, String phone, String password, ArrayList<Disk> favorites) {
        ID = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.favorites = favorites;
    }

    protected User(Parcel in) {
        ID = in.readInt();
        userName = in.readString();
        email = in.readString();
        phone = in.readString();
        password = in.readString();
        favorites = in.createTypedArrayList(Disk.CREATOR);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public int getID() {
        return ID;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Disk> getFavorites() {
        return favorites;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeString(userName);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(password);
        parcel.writeTypedList(favorites);
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "favorites=" + favorites +
                ", ID=" + ID +
                ", fullName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}