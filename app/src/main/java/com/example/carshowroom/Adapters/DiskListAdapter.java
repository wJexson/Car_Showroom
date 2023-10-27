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

import com.example.carshowroom.Models.Disk;
import com.example.carshowroom.R;

import java.util.List;

public class DiskListAdapter extends RecyclerView.Adapter<DiskListAdapter.ViewHolder> {
    private final List<Disk> diskList;
    private final LayoutInflater inflater;
    public OnCarAdClickListener onClickListener;

    public interface OnCarAdClickListener {
        void onCarAdClick(Disk diskListItem);
    }

    public DiskListAdapter(Context context, List<Disk> diskList) {
        this.diskList = diskList;
        this.inflater = LayoutInflater.from(context);
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
        Disk diskListItem = diskList.get(position);
        holder.imageView.setImageResource(holder.itemView.getContext().getResources().getIdentifier(diskListItem.getImage(), "drawable", holder.itemView.getContext().getPackageName()));
        holder.nameView.setText(diskListItem.getBrand() + " " + diskListItem.getModel());
        holder.yearView.setText(String.valueOf(diskListItem.getYear()));
        holder.priceView.setText(diskListItem.getPrice() + " $");
        holder.colorView.setText(diskListItem.getColor());
        holder.transmissionView.setText(diskListItem.getTransmission());
        holder.drive_unitView.setText(diskListItem.getDrive_unit());
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.onCarAdClick(diskListItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return diskList.size();
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

