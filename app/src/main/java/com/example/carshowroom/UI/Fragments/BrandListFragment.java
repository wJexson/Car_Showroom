package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.BrandListAdapter;
import com.example.carshowroom.UI.StateHolder.ViewModel.BrandViewModel;

public class BrandListFragment extends Fragment implements BrandListAdapter.OnBrandClickListener {

    private static final String TAG = "BrandList";
    private BrandListAdapter brandListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BrandViewModel brandViewModel = new ViewModelProvider(this).get(BrandViewModel.class);
        brandListAdapter = new BrandListAdapter(brandViewModel.getBrandItemListLiveData(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView brandList = view.findViewById(R.id.brandsList);
        brandList.setAdapter(brandListAdapter);
        Button back_button = view.findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_brandslistFragment_to_mainFragment);
            }
        });

        return view;
    }

    @Override
    public void onBrandClick(BrandListItem brandListItem, int position) {
         String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
        String selectedItem = all_brands[position];
        Log.i(TAG, "You clicked on " + selectedItem);
        Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
    }
}
