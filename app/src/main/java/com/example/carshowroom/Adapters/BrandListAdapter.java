package com.example.carshowroom.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.R;
import com.example.carshowroom.Entities.BrandListItem;

import java.util.List;

public class BrandListAdapter extends RecyclerView.Adapter<BrandListAdapter.ViewHolder> {

    public interface OnBrandClickListener {
        void onBrandClick(BrandListItem brandListItem, int position);
    }

    private final LayoutInflater inflater;
    private final List<BrandListItem> brandListItems;

    private final OnBrandClickListener onClickListener;

    public BrandListAdapter(Context context, List<BrandListItem> brandListItems, OnBrandClickListener onClickListener) {
        this.brandListItems = brandListItems;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BrandListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.brand_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BrandListItem brandListItem = brandListItems.get(position);
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
        return brandListItems.size();
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
