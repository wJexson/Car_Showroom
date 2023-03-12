package com.example.carshowroom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {

    private static final String TAG = "ListView";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        ArrayList<Brand> brands = new ArrayList<Brand>();
        String[] all_brands = getResources().getStringArray(R.array.Auto_brands);
        for (String brand: all_brands){
            brands.add(new Brand(brand, R.drawable.logo));
        }
        ListView brandsList = view.findViewById(R.id.brandsList);
        BrandAdapter brandAdapter = new BrandAdapter(getContext(), R.layout.list_item, brands);
        brandsList.setAdapter(brandAdapter);

        brandsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // по позиции получаем выбранный элемент
                String selectedItem = all_brands[position];
                Log.i(TAG, "You clicked on " + selectedItem);
                Toast.makeText(getActivity(),selectedItem,Toast.LENGTH_SHORT).show();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container_view, new MainFragment());
                fr.commit();
            }
        });
        return view;
    }
}
