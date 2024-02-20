package com.albrandz.cabocab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Retrieve the phone number passed from LoginActivity
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        TextView textView = findViewById(R.id.tv_phone_number);

        SpannableStringBuilder builder = new SpannableStringBuilder("Enter the 4-digit code sent to your at ");

        // Append the non-clickable phone number


        // Append the clickable phone number
        builder.append(" "); // Add space between the clickable and non-clickable parts
        SpannableString clickablePhoneNumber = new SpannableString(phoneNumber);
        clickablePhoneNumber.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle phone number click action
                Toast.makeText(VerificationActivity.this, "Phone number clicked", Toast.LENGTH_SHORT).show();
            }
        }, 0, clickablePhoneNumber.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickablePhoneNumber.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.dark_blue)), 0, clickablePhoneNumber.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(clickablePhoneNumber);

        // Set the text to the TextView
        textView.setText(builder);
        textView.setMovementMethod(LinkMovementMethod.getInstance()); // Make sure to enable clickable links

        // Set the click listener for the non-clickable part of the phone number
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle phone number click action
                Toast.makeText(VerificationActivity.this, "Phone number clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set support email clickable
        TextView supportTextView = findViewById(R.id.tv_support);
        String emailAddress = "cbc.support@dtc.gov.ae";
        String clickableText = "<u><font color='#0000FF'>" + emailAddress + "</font></u>";
        supportTextView.setText(Html.fromHtml("Please email your query to " + clickableText));
        supportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display toast message with email address
                Toast.makeText(VerificationActivity.this, "Please email your query to " + emailAddress, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to handle the login button click event
    public void onLoginButtonClick(View view) {
        // Navigate to SignupActivity
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

    @Override
    public void onBackPressed() {
        // Go to previous activity when the back button is pressed
        super.onBackPressed();
    }
}
