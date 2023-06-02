package com.example.carshowroom.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.carshowroom.R;

import java.util.ArrayList;

public class User implements Parcelable {
    public static final String SELECTED_USER = "USER";

    public static final String EMAIL_PATTERN = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n)";
    public static final String PHONE_PATTERN = "(^((\\+7|7|8)+([0-9]){10})$\n)";
    public ArrayList<Car> favorites = new ArrayList<>();
    private final int ID;
    private final String fullName;
    private final String email;
    private final String telephone;
    private final String password;
    private int image = R.drawable.userimage1;
    String image_name;

    public User(int id, String fullName, String email, String telephone, String password) {
        ID = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;

    }

    public User(int id, String fullName, String email, String telephone, String password, ArrayList<Car> favorites) {
        ID = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.favorites = favorites;
    }

    protected User(Parcel in) {
        ID = in.readInt();
        fullName = in.readString();
        email = in.readString();
        telephone = in.readString();
        password = in.readString();
        image = in.readInt();
        image_name = in.readString();
        favorites = in.createTypedArrayList(Car.CREATOR);
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

    public String getFullName() {
        return fullName;
    }

    public int getID() {
        return ID;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public ArrayList<Car> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Car> favourites) {
        this.favorites = favourites;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeString(fullName);
        parcel.writeString(email);
        parcel.writeString(telephone);
        parcel.writeString(password);
        parcel.writeInt(image);
        parcel.writeString(image_name);
        parcel.writeTypedList(favorites);
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "favorites=" + favorites +
                ", ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", image=" + image +
                ", image_name='" + image_name + '\'' +
                '}';
    }
}