package com.albrandz.cabocab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private NavController navController;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_home);

        // Set up NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Set onClickListener for "Where to go" TextView
        TextView whereToGoTextView = findViewById(R.id.where_to_go_tv);
        whereToGoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mapFragment); // Navigate to the mapFragment
            }
        });

        // Set up bottom navigation item click listeners
        findViewById(R.id.map_bnb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mapFragment); // Navigate to the mapFragment
            }
        });

        findViewById(R.id.settings_bnb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.settingsFragment); // Navigate to the settingsFragment
            }
        });

        findViewById(R.id.user_bnb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.userFragment); // Navigate to the userFragment
            }
        });

        // Set up click listener for home icon to display home fragment
        findViewById(R.id.home_bnb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.homeFragment); // Navigate to the homeFragment
            }
        });
    }
}
