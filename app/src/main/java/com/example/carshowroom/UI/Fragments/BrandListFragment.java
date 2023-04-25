package com.example.carshowroom.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.R;
import com.example.carshowroom.UI.StateHolder.Adapters.BrandListAdapter;

import java.util.ArrayList;

public class BrandListFragment extends Fragment {

    private static final String TAG = "RecycleView";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        // начальная инициализация списка
        ArrayList<BrandListItem> brandListItems = new ArrayList<BrandListItem>();
        String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
        for (String brand : all_brands) {
            brandListItems.add(new BrandListItem(brand, R.drawable.car_icon));
        }
        // получаем элемент ListView
        RecyclerView brandsList = view.findViewById(R.id.brandsList);
        // определяем слушателя нажатия элемента в списке
        BrandListAdapter.OnBrandClickListener brandClickListener = new BrandListAdapter.OnBrandClickListener() {
            @Override
            public void onBrandClick(BrandListItem brand, int position) {
                String selectedItem = all_brands[position];
                Log.i(TAG, "You clicked on " + selectedItem);
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        BrandListAdapter brandAdapter = new BrandListAdapter(getContext(), brandListItems, brandClickListener);
        // устанавливаем адаптер
        brandsList.setAdapter(brandAdapter);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_brandslistFragment_to_mainFragment);
            }
        });

        return view;
    }
}
