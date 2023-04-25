package com.example.carshowroom.UI.StateHolder.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.BrandListItem;
import com.example.carshowroom.R;

import java.util.List;
import java.util.Objects;

public class BrandListAdapter extends RecyclerView.Adapter<BrandListAdapter.ViewHolder> {

    public interface OnBrandClickListener {
        void onBrandClick(BrandListItem brandListItem, int position);
    }

    private final LiveData<List<BrandListItem>> brandListItems;

    private final OnBrandClickListener onClickListener;

    public BrandListAdapter(LiveData<List<BrandListItem>> brandListItems, OnBrandClickListener onClickListener) {
        this.brandListItems = brandListItems;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BrandListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BrandListItem brandListItem = Objects.requireNonNull(brandListItems.getValue()).get(position);
        holder.flagView.setImageResource(brandListItem.getFlagResource());
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
        return Objects.requireNonNull(brandListItems.getValue()).size();
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
