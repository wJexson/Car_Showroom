package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.BrandListAdapter;
import com.example.carshowroom.UI.StateHolder.ViewModel.BrandViewModel;

import java.util.List;

public class BrandListFragment extends Fragment {

    private static final String TAG = "BrandList";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button back_button = view.findViewById(R.id.back_button);

        BrandViewModel brandViewModel = new ViewModelProvider(this).get(BrandViewModel.class);
        brandViewModel.brandList.observe(getViewLifecycleOwner(), new Observer<List<Brand>>() {
            @Override
            public void onChanged(List<Brand> brands) {
                BrandListAdapter brandListAdapter = new BrandListAdapter(brands);
                brandListAdapter.onClickListener = new BrandListAdapter.OnBrandClickListener() {
                    @Override
                    public void onBrandClick(Brand brandListItem, int position) {
                        String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
                        String selectedItem = all_brands[position];
                        Log.i(TAG, "You clicked on " + selectedItem);
                        Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
                    }
                };
                RecyclerView brandsList = view.findViewById(R.id.brandsList);
                brandsList.setAdapter(brandListAdapter);
            }
        });


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_brandslistFragment_to_mainFragment);
            }
        });
    }
}
