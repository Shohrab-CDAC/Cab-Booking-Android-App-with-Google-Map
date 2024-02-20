package com.albrandz.cabocab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome = new FragmentHome();
    FragmentMap fragmentMap = new FragmentMap();
    FragmentSettings fragmentSettings = new FragmentSettings();
    FragmentProfile fragmentProfile = new FragmentProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home_bnb) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                    return true;
                } else if (itemId == R.id.map_bnb) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMap).commit();
                    return true;
                } else if (itemId == R.id.settings_bnb) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentSettings).commit();
                    return true;
                } else if (itemId == R.id.user_bnb) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
