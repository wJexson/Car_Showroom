package com.example.carshowroom.UI.Activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.Data.Protocols.UserProtocol;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.Fragments.HomeFragment;
import com.example.carshowroom.UI.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserProtocol, ProfileFragment.UserProtocol, HomeFragment.MainPageController {

    DataBaseHelper dataBaseHelperClass;
    HomeFragment homeFragment;
    User user;
    ImageView userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataBaseHelperClass = new DataBaseHelper(this);
        try {
            dataBaseHelperClass.createDataBase();
        } catch (Exception ignored) {}
        dataBaseHelperClass.openDataBase();
        CarAd.carAds = dataBaseHelperClass.getCarAdsFromDatabase();
        dataBaseHelperClass.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        userImage = findViewById(R.id.userImage);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }


    @Override
    public void setMainPage(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Override
    public ArrayList<CarAd> getCarAds() {
        return CarAd.carAds;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }

}