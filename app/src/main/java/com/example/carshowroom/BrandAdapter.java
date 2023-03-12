package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BrandAdapter extends ArrayAdapter<Brand> {

    private final LayoutInflater inflater;
    private final int layout;
    private final List<Brand> brands;

    public BrandAdapter(Context context, int resource, List<Brand> brands) {
        super(context, resource, brands);
        this.brands = brands;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.logo);
        TextView nameView = view.findViewById(R.id.name);

        Brand brand = brands.get(position);

        flagView.setImageResource(brand.getFlagResource());
        nameView.setText(brand.getName());

        return view;
    }

}
