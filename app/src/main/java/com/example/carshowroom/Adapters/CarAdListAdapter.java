package com.example.carshowroom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carshowroom.Entities.CarAdListItem;
import com.example.carshowroom.R;

import java.util.List;

public class CarAdListAdapter extends RecyclerView.Adapter<CarAdListAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<CarAdListItem> carAdListItems;

    public CarAdListAdapter(Context context, List<CarAdListItem> carAdListItems) {
        this.inflater = LayoutInflater.from(context);
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
        CarAdListItem carAdListItem = carAdListItems.get(position);
        holder.flagView.setImageResource(carAdListItem.getFlagResource());
        holder.nameView.setText(carAdListItem.getName());
        holder.yearView.setText(carAdListItem.getYear());
        holder.priceView.setText(carAdListItem.getPrice());
        holder.colorView.setText(carAdListItem.getColor());
        holder.buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_skylineFragment);
            }
        });
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
        final TextView priceView;
        final Button buttonView;
        public ViewHolder(View view) {
            super(view);
            this.flagView = view.findViewById(R.id.car_image);
            this.nameView = view.findViewById(R.id.car_title);
            this.yearView = view.findViewById(R.id.car_year);
            this.colorView = view.findViewById(R.id.car_color);
            this.priceView = view.findViewById(R.id.car_price);
            this.buttonView = view.findViewById(R.id.car_button);
        }
    }
}
