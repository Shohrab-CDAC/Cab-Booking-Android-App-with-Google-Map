package com.albrandz.cabocab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        EditText whereToGoEditText = rootView.findViewById(R.id.where_to_go_tv);
        AutoImageSlider autoImageSlider = rootView.findViewById(R.id.autoImageSlider);

        ArrayList<ImageSlidesModel> autoImageList = new ArrayList<>();

        try {
            autoImageList.add(new ImageSlidesModel(R.drawable.cashback, ""));
            autoImageList.add(new ImageSlidesModel(R.drawable.my_albrandz3, ""));
            autoImageList.add(new ImageSlidesModel(R.drawable.hurryup, ""));
            autoImageList.add(new ImageSlidesModel(R.drawable.flatoff, ""));
            autoImageList.add(new ImageSlidesModel(R.drawable.my_albrandz4, ""));
            autoImageList.add(new ImageSlidesModel(R.drawable.my_albrandz5, ""));

            autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT);

            autoImageSlider.setDefaultAnimation();

        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }

        // Set OnClickListener for whereToGoEditText
        whereToGoEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the text of whereToGoEditText to "New Delhi"
                whereToGoEditText.setText("New Delhi");

                // Start a new fragment transaction
                FragmentMap fragmentMap = new FragmentMap();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

                // Replace the current fragment with FragmentMap
                transaction.replace(R.id.container, fragmentMap);

                // Add the transaction to the back stack
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });

        return rootView;
    }
}
