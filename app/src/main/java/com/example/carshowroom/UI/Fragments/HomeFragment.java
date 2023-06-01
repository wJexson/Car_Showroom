package com.example.carshowroom.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.Data.Protocols.UserProtocol;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.CarAdListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    UserProtocol userGetter;

    public interface MainPageController {
        void setMainPage(HomeFragment homeFragment);

        ArrayList<CarAd> getCarAds();

        void setUser(User user);
    }

    MainPageController mainPageController;
    User user;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainPageController = (MainPageController) context;
        userGetter = (UserProtocol) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Установка пользователя
        user = requireArguments().getParcelable(User.SELECTED_USER);
        if (user != null) {
            mainPageController.setUser(user);
            mainPageController.setMainPage(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView carAdList = view.findViewById(R.id.carAdList);
        CarAdListAdapter carAdListAdapter = new CarAdListAdapter(requireActivity(), mainPageController.getCarAds());
        carAdListAdapter.onClickListener = new CarAdListAdapter.OnCarAdClickListener() {
            @Override
            public void onCarAdClick(CarAd carAdListItem) {
                String car_vin = carAdListItem.getVIN();
                Bundle bundle = new Bundle();
                bundle.putString("carAd_Key", car_vin);
                Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_carAdFragment, bundle);
            }
        };
        carAdList.setAdapter(carAdListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Показ нижней навигации
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}