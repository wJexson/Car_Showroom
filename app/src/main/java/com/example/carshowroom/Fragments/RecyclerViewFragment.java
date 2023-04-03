package com.example.carshowroom.Fragments;

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

import com.example.carshowroom.Brand;
import com.example.carshowroom.R;
import com.example.carshowroom.RVBrandAdapter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private static final String TAG = "RecycleView";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        // начальная инициализация списка
        ArrayList<Brand> brands = new ArrayList<Brand>();
        String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
        for (String brand : all_brands) {
            brands.add(new Brand(brand, R.drawable.logo));
        }
        // получаем элемент ListView
        RecyclerView brandsList = view.findViewById(R.id.brandsList);
        // определяем слушателя нажатия элемента в списке
        RVBrandAdapter.OnBrandClickListener brandClickListener = new RVBrandAdapter.OnBrandClickListener() {
            @Override
            public void onBrandClick(Brand brand, int position) {
                String selectedItem = all_brands[position];
                Log.i(TAG, "You clicked on " + selectedItem);
                Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        RVBrandAdapter brandAdapter = new RVBrandAdapter(getContext(), brands, brandClickListener);
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
