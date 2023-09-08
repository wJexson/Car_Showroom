package com.example.carshowroom.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carshowroom.DB.DataBaseHelper;
import com.example.carshowroom.Models.User;
import com.example.carshowroom.R;

import java.util.Random;

public class ReviewFragment extends Fragment {


    public interface UserProtocol {
        User getUser();
    }

    UserProtocol userGetter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        userGetter = (UserProtocol) context;
    }

    User user;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseHelper = new DataBaseHelper(getContext());
        try {
            dataBaseHelper.createDataBase();
        } catch (Exception ignored) {
        }
        user = userGetter.getUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView back_button = view.findViewById(R.id.back_button);
        Button send_review_button = view.findViewById(R.id.send_review_button);
        EditText review_et = view.findViewById(R.id.review_et);

        send_review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomValue = random.nextInt(2);
                System.out.println(randomValue);
                if (randomValue == 1) {
                    throw new NullPointerException("This is a simulated crash");
                } else {
                    String review = review_et.getText().toString();
                    dataBaseHelper.openDataBase();
                    dataBaseHelper.addToReviews(user.getID(), review);
                    dataBaseHelper.close();
                    InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(review_et.getWindowToken(), 0);
                    review_et.setText("");
                    Toast.makeText(requireActivity(), "Отзыв отправлен!", Toast.LENGTH_SHORT).show();
                }
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
