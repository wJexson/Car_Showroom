package com.example.carshowroom.UI.StateHolder.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.R;

import java.util.List;
import java.util.Objects;

public class BrandListAdapter extends RecyclerView.Adapter<BrandListAdapter.ViewHolder> {

    public interface OnBrandClickListener {
        void onBrandClick(Brand brandListItem, int position);
    }

    private final List<Brand> brandList;

    public BrandListAdapter.OnBrandClickListener onClickListener = null;

    public BrandListAdapter(List<Brand> brandListItems) {
        this.brandList = brandListItems;
    }

    @NonNull
    @Override
    public BrandListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Brand brandListItem = Objects.requireNonNull(brandList).get(position);
        holder.nameView.setText(brandListItem.getName());

        // обработка нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onBrandClick(brandListItem, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(brandList).size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
        }
    }
}
