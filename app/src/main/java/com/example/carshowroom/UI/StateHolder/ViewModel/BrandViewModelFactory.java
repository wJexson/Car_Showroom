package com.example.carshowroom.UI.StateHolder.ViewModel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

public class BrandViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public BrandViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BrandViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new BrandViewModel(context)));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
