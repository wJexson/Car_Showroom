package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVBrandAdapter extends RecyclerView.Adapter<RVBrandAdapter.ViewHolder> {

    interface OnBrandClickListener {
        void onBrandClick(Brand brand, int position);
    }

    private final LayoutInflater inflater;
    private final List<Brand> brands;

    private final OnBrandClickListener onClickListener;

    RVBrandAdapter(Context context, List<Brand> brands, OnBrandClickListener onClickListener) {
        this.brands = brands;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RVBrandAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVBrandAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Brand brand = brands.get(position);
        holder.flagView.setImageResource(brand.getFlagResource());
        holder.nameView.setText(brand.getName());

        // обработка нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onBrandClick(brand, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.logo);
            nameView = view.findViewById(R.id.name);
        }
    }
}
