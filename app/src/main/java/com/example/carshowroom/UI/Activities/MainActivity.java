package com.example.carshowroom.UI.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Models.Disk;
import com.example.carshowroom.Models.User;
import com.example.carshowroom.Models.UserProtocol;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.Fragments.DiskAdFragment;
import com.example.carshowroom.UI.Fragments.FavoritesFragment;
import com.example.carshowroom.UI.Fragments.HomeFragment;
import com.example.carshowroom.UI.Fragments.ProfileFragment;
import com.example.carshowroom.UI.Fragments.ReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserProtocol, ProfileFragment.UserProtocol, ReviewFragment.UserProtocol,
        DiskAdFragment.UserProtocol, FavoritesFragment.UserProtocol, HomeFragment.MainPageController {

    DataBaseHelper dataBaseHelperClass;
    HomeFragment homeFragment;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelperClass = new DataBaseHelper(this);
        try {
            dataBaseHelperClass.createDataBase();
        } catch (Exception ignored) {
        }
        dataBaseHelperClass.openDataBase();
        Disk.disks = dataBaseHelperClass.getCarAdsFromDatabase();
        dataBaseHelperClass.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }


    @Override
    public void setMainPage(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Override
    public ArrayList<Disk> getCarAds() {
        return Disk.disks;
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