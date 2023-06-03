package com.example.carshowroom.UI.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.R;

public class ReviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button back_button = view.findViewById(R.id.back_button);
        Button send_review_button = view.findViewById(R.id.send_review_button);
        EditText review_et = view.findViewById(R.id.review_et);

        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String reviewSP = sharedPrefRead.getString("REVIEW", "");
        review_et.setText(reviewSP);

        send_review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review = review_et.getText().toString();
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString("REVIEW",
                        review);
                editor.apply();
                InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(review_et.getWindowToken(), 0);
                Toast.makeText(requireActivity(), "Отзыв отправлен!", Toast.LENGTH_SHORT).show();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
    }
}
