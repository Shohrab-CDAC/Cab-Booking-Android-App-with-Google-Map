package com.albrandz.cabocab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;


import androidx.appcompat.app.AppCompatActivity;

import com.albrandz.cabocab.R;
import com.albrandz.cabocab.VerificationActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_login);

        phoneNumberEditText = findViewById(R.id.login_mobile_number);

        // Set listener for the EditText to detect "Enter" key press
        phoneNumberEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // Check if the "Enter" key is pressed and it's an action down event
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Get the entered phone number
                    String phoneNumber = phoneNumberEditText.getText().toString();

                    // Check if the phone number is valid (10 digits)
                    if (phoneNumber.length() == 10) {
                        // Navigate to the verification screen with OTP sent message
                        Intent intent = new Intent(LoginActivity.this, VerificationActivity.class);
                        intent.putExtra("phoneNumber", phoneNumber);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "OTP sent", Toast.LENGTH_SHORT).show();
                    } else {
                        // Display toast message for incorrect phone number
                        Toast.makeText(LoginActivity.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // Call the default back button behavior
    }
}
