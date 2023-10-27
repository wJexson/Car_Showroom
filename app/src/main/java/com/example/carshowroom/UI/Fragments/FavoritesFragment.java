package com.example.carshowroom.UI.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carshowroom.Adapters.DiskListAdapter;
import com.example.carshowroom.Models.Disk;
import com.example.carshowroom.Models.User;
import com.example.carshowroom.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FavoritesFragment extends Fragment {

    public interface UserProtocol {
        User getUser();
    }

    UserProtocol userGetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        userGetter = (UserProtocol) context;
    }

    User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = userGetter.getUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView carList = view.findViewById(R.id.favList);
        DiskListAdapter diskListAdapter = new DiskListAdapter(requireActivity(), user.getFavorites());
        diskListAdapter.onClickListener = new DiskListAdapter.OnCarAdClickListener() {
            @Override
            public void onCarAdClick(Disk diskListItem) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Disk.SELECTED_CAR, diskListItem);
                Navigation.findNavController(requireView()).navigate(R.id.action_favoritesFragment_to_carAdFragment, bundle);
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