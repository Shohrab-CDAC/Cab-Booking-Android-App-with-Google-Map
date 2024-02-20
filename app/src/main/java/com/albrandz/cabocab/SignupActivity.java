package com.albrandz.cabocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.albrandz.cabocab.HomeActivity;
import com.albrandz.cabocab.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        TextView dobTextView = findViewById(R.id.dob_edt);
        dobTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(); // Open a calendar dialog to select date of birth
            }
        });

        TextView termsPrivacyTextView = findViewById(R.id.tv_terms_privacy);
        makeLinksClickable(termsPrivacyTextView);
    }
    public void onCreateAccountButtonClick(View view) {
        // Navigate to HomeActivity
        Toast.makeText(this, "Welcome to Cabo Cab!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

    private void showDatePickerDialog() {
        // Implement code to show a date picker dialog here
        // For demonstration purposes, let's show a toast message
        Toast.makeText(this, "Date picker dialog will be shown here", Toast.LENGTH_SHORT).show();
    }

    private void makeLinksClickable(TextView textView) {
        SpannableString spannableString = new SpannableString(textView.getText());

        ClickableSpan termsClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click for Terms of Service
                Toast.makeText(SignupActivity.this, "Terms of Service clicked", Toast.LENGTH_SHORT).show();
                // You can navigate to the Terms of Service activity here
            }
        };

        ClickableSpan privacyClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click for Privacy Policy
                Toast.makeText(SignupActivity.this, "Privacy Policy clicked", Toast.LENGTH_SHORT).show();
                // You can navigate to the Privacy Policy activity here
            }
        };

        spannableString.setSpan(termsClickableSpan,29 , 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(privacyClickableSpan, 48, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }

//    public void signUp(View view) {
//        if (validateInputFields()) {
//            // If validation successful, proceed with sign-up
//            Toast.makeText(this, "Welcome to Cabo Cab!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, HomeActivity.class);
//            startActivity(intent);
//            finish(); // Finish the current activity
//        }
//    }

    private boolean validateInputFields() {
        TextView fullNameTextView = findViewById(R.id.full_name_edt);
        TextView emailTextView = findViewById(R.id.email_edt);
        TextView dobTextView = findViewById(R.id.dob_edt);
        TextView passwordTextView = findViewById(R.id.password_edt);

        String fullName = fullNameTextView.getText().toString().trim();
        String email = emailTextView.getText().toString().trim();
        String dob = dobTextView.getText().toString().trim();
        String password = passwordTextView.getText().toString().trim();

//        if (TextUtils.isEmpty(fullName)) {
//            fullNameTextView.setError("Enter full name");
//            return false;
//        }
//        if (TextUtils.isEmpty(email)) {
//            emailTextView.setError("Enter email");
//            return false;
//        }
        // Add more validation rules for other fields as needed

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // Call the default back button behavior
    }
}
