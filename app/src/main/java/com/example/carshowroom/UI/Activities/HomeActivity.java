package com.example.carshowroom.UI.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.Data.Protocols.UserProtocol;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.Fragments.HomeFragment;
import com.example.carshowroom.UI.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements UserProtocol, ProfileFragment.UserProtocol, HomeFragment.MainPageController {

    HomeFragment homeFragment;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }
}