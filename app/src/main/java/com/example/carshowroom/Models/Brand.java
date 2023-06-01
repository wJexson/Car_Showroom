package com.example.carshowroom.Models;

import androidx.annotation.NonNull;

public class Brand {

    public String name; // название


    public Brand(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
