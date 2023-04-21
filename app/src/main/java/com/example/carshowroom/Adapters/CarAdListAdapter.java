package com.example.carshowroom.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Entities.CarAdListItem;
import com.example.carshowroom.R;

import java.util.List;

public class CarAdListAdapter extends RecyclerView.Adapter<CarAdListAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<CarAdListAdapter> carAdListItems;

    public CarAdListAdapter(LayoutInflater inflater, List<CarAdListAdapter> carAdListItems) {
        this.inflater = inflater;
        this.carAdListItems = carAdListItems;
    }


    @NonNull
    @Override
    public CarAdListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.car_ad_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdListAdapter.ViewHolder holder, int position) {
        CarAdListAdapter carAdListItem = carAdListItems.get(position);
//        holder.flagView.setImageResource(carAdListItem.getFlagResource());
//        holder.nameView.setText(carAdListItem.getName());
//        holder.yearView.setText(carAdListItem.getYear());
//        holder.pricetitleView.setText(carAdListItem.getPrice_title());
//        holder.priceView.setText(carAdListItem.getPrice());
//        holder.colorView.setText(carAdListItem.getColor());


    }

    @Override
    public int getItemCount() {
        return carAdListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;
        final TextView yearView;
        final TextView colorView;
        final TextView pricetitleView;
        final TextView priceView;
        final Button buttonView;
        public ViewHolder(View view) {
            super(view);
            this.flagView = view.findViewById(R.id.car_image);
            this.nameView = view.findViewById(R.id.car_title);
            this.yearView = view.findViewById(R.id.car_year);
            this.colorView = view.findViewById(R.id.car_color);
            this.pricetitleView = view.findViewById(R.id.car_price_title);
            this.priceView = view.findViewById(R.id.car_price);
            this.buttonView = view.findViewById(R.id.car_button);
        }
    }
}
