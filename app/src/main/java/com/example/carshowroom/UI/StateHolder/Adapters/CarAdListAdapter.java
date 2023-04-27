package com.example.carshowroom.UI.StateHolder.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;

import java.util.List;
import java.util.Objects;

public class CarAdListAdapter extends RecyclerView.Adapter<CarAdListAdapter.ViewHolder> {

    private final List<CarAd> carAdList;
    public CarAdListAdapter.OnCarAdClickListener onClickListener = null;

    public interface OnCarAdClickListener {
        void onCarAdClick(CarAd carAdListItem);
    }


    public CarAdListAdapter(List<CarAd> carAdListItems) {
        this.carAdList = carAdListItems;
    }


    @NonNull
    @Override
    public CarAdListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_ad_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdListAdapter.ViewHolder holder, int position) {
        CarAd carAdListItem = Objects.requireNonNull(carAdList).get(position);
        holder.flagView.setImageResource(carAdListItem.getFlagResource());
        holder.nameView.setText(carAdListItem.getName());
        holder.yearView.setText(carAdListItem.getYear());
        holder.priceView.setText(carAdListItem.getPrice());
        holder.colorView.setText(carAdListItem.getColor());
        holder.transmissionView.setText(carAdListItem.getTransmission());
        holder.drive_unitView.setText(carAdListItem.getDrive_unit());
        holder.itemView.setOnClickListener(v -> onClickListener.onCarAdClick(carAdListItem));

    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(carAdList).size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;
        final TextView yearView;
        final TextView colorView;
        final TextView priceView;
        final TextView transmissionView;
        final TextView drive_unitView;

        public ViewHolder(View view) {
            super(view);
            this.flagView = view.findViewById(R.id.car_image);
            this.nameView = view.findViewById(R.id.car_title);
            this.yearView = view.findViewById(R.id.car_year);
            this.colorView = view.findViewById(R.id.car_color);
            this.priceView = view.findViewById(R.id.car_price);
            this.transmissionView = view.findViewById(R.id.car_transmission);
            this.drive_unitView = view.findViewById(R.id.car_drive_unit);
        }
    }
}
