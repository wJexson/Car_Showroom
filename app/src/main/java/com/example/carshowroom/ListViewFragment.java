package com.example.carshowroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        Button back_button = view.findViewById(R.id.back_button);

        // получаем элемент ListView
        ListView brandsList = view.findViewById(R.id.brandsList);
        // получаем ресурс
        String[] brands = getResources().getStringArray(R.array.Auto_brands);
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, brands);
        // устанавливаем для списка адаптер
        brandsList.setAdapter(adapter);

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
