package com.example.carshowroom.UI.StateHolder.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Data.Models.CarAd;
import com.example.carshowroom.R;

import java.util.List;

public class CarAdListAdapter extends RecyclerView.Adapter<CarAdListAdapter.ViewHolder> {
    private final List<CarAd> carAdList;
    private final LayoutInflater inflater;
    public OnCarAdClickListener onClickListener;

    public interface OnCarAdClickListener {
        void onCarAdClick(CarAd carAdListItem);
    }

    public CarAdListAdapter(Context context, List<CarAd> carAdList) {
        this.carAdList = carAdList;
        this.inflater = LayoutInflater.from(context);
    }

    public void setOnCarAdClickListener(OnCarAdClickListener listener) {
        this.onClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.car_ad_list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"DiscouragedApi", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarAd carAdListItem = carAdList.get(position);
        holder.imageView.setImageResource(holder.itemView.getContext().getResources().getIdentifier(carAdListItem.getImage(), "drawable", holder.itemView.getContext().getPackageName()));
        holder.nameView.setText(carAdListItem.getBrand() + " " + carAdListItem.getModel());
        holder.yearView.setText(carAdListItem.getYear());
        holder.priceView.setText(carAdListItem.getPrice() + " $");
        holder.colorView.setText(carAdListItem.getColor());
        holder.transmissionView.setText(carAdListItem.getTransmission());
        holder.drive_unitView.setText(carAdListItem.getDrive_unit());
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.onCarAdClick(carAdListItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carAdList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView;
        TextView yearView;
        TextView colorView;
        TextView priceView;
        TextView transmissionView;
        TextView drive_unitView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.car_image);
            nameView = view.findViewById(R.id.car_title);
            yearView = view.findViewById(R.id.car_year);
            colorView = view.findViewById(R.id.car_color);
            priceView = view.findViewById(R.id.car_price);
            transmissionView = view.findViewById(R.id.car_transmission);
            drive_unitView = view.findViewById(R.id.car_drive_unit);
        }
    }
}

