package com.example.carshowroom.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.carshowroom.R;


public class ProfileImagesFragment extends DialogFragment {

//    public interface SetNewPhoto {
//        void setNewPhoto(String photo);
//    }
//
//    SetNewPhoto setNewPhoto;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        setNewPhoto = (SetNewPhoto) context;
//    }

    ImageView usr_img1, usr_img2, usr_img3, usr_img4, usr_img5, usr_img6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_images, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usr_img1 = view.findViewById(R.id.usr_img1);
        usr_img2 = view.findViewById(R.id.usr_img2);
        usr_img3 = view.findViewById(R.id.usr_img3);
        usr_img4 = view.findViewById(R.id.usr_img4);
        usr_img5 = view.findViewById(R.id.usr_img5);
        usr_img6 = view.findViewById(R.id.usr_img6);

//        usr_img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimage1");
//                dismiss();
//            }
//        });
//
//        usr_img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimage2");
//                dismiss();
//            }
//        });
//
//        usr_img3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimage3");
//                dismiss();
//            }
//        });
//
//        usr_img4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimag4");
//                dismiss();
//            }
//        });
//
//        usr_img5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimage5");
//                dismiss();
//            }
//        });
//
//        usr_img6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setNewPhoto.setNewPhoto("userimage6");
//                dismiss();
//            }
//        });
    }
}