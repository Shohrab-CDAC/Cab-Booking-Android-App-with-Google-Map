package com.albrandz.cabocab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentMap extends Fragment {

    private EditText sourceEditText;
    private EditText destinationEditText;

    public FragmentMap() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        // Initialize source and destination EditText
        sourceEditText = rootView.findViewById(R.id.sourceEditText);
        destinationEditText = rootView.findViewById(R.id.destinationEditText);

        // Set OnClickListener to the source EditText
        sourceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fill source EditText with "Your location"
                sourceEditText.setText("Your location");
            }
        });

        // Set OnClickListener to the destination EditText
        destinationEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display suggestion "New Delhi"
                destinationEditText.setText("New Delhi");

                // Start MapActivity when suggestion is clicked
                startMapActivity("New Delhi");
            }
        });

        return rootView;
    }

    private void startMapActivity(String location) {
        // Start MapActivity with the selected location
        Intent intent = new Intent(getActivity(), MapActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);
    }
}
