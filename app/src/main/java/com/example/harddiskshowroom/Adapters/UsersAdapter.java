package com.example.harddiskshowroom.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harddiskshowroom.Models.User;
import com.example.carshowroom.R;

import java.util.List;
import java.util.Objects;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private final List<User> userList;

    public UsersAdapter(List<User> userLis) {
        this.userList = userLis;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        User user = Objects.requireNonNull(userList).get(position);
        holder.userId.setText(String.valueOf(user.getID()));
        holder.userName.setText(user.getUserName());
        holder.userEmail.setText(user.getEmail());
        holder.userPhone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(userList).size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView userId;
        final TextView userName;
        final TextView userEmail;
        final TextView userPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);
            userPhone = itemView.findViewById(R.id.userPhone);
        }
    }
}
