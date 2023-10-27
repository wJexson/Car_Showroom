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

import com.example.carshowroom.Models.Disk;
import com.example.carshowroom.Models.User;
import com.example.carshowroom.Models.UserProtocol;
import com.example.carshowroom.R;
import com.example.carshowroom.Adapters.DiskListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    UserProtocol userGetter;

    public interface MainPageController {
        void setMainPage(HomeFragment homeFragment);

        ArrayList<Disk> getCarAds();

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
        RecyclerView carList = view.findViewById(R.id.diskList);
        DiskListAdapter diskListAdapter = new DiskListAdapter(requireActivity(), mainPageController.getCarAds());
        diskListAdapter.onClickListener = new DiskListAdapter.OnCarAdClickListener() {
            @Override
            public void onCarAdClick(Disk diskListItem) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Disk.SELECTED_CAR, diskListItem);
                Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_carAdFragment, bundle);
            }
        };
        carList.setAdapter(diskListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Показ нижней навигации
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}