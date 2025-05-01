package com.iie.st10320489.marene;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.InputType;
import android.widget.ImageView;


import androidx.room.*;


import androidx.appcompat.app.AppCompatActivity;

import com.iie.st10320489.marene.data.database.AppDatabase;
import com.iie.st10320489.marene.data.entities.User;
import com.iie.st10320489.marene.ui.onboarding.OnboardingActivity;
import com.iie.st10320489.marene.ui.onboarding.OnboardingActivity2;

import java.util.List;

public class SignupActivity extends AppCompatActivity { // (Android Knowledge, 2024)

    // Method to check if the password meets the complexity requirements
    private boolean isPasswordStrong(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") && // At least one uppercase letter
                password.matches(".*[0-9].*") && // At least one digit
                password.matches(".*[!@#\\$%^&*].*"); // At least one special character
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // Set the layout for the signup screen

        // Initialize the Room database
        AppDatabase db;
        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "cashoo_database")
                .allowMainThreadQueries() // Allow queries on main thread (not recommended for production)
                .build();

        // Find view references
        Button signupButton = findViewById(R.id.signupLoginButton);
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText surnameEditText = findViewById(R.id.surnameEditText);
        EditText emailEditText = findViewById(R.id.signupEmailEditText);
        EditText passwordEditText = findViewById(R.id.createPasswordEditText);
        EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        ImageView toggleCreatePassword = findViewById(R.id.toggleCreatePassword);
        ImageView toggleConfirmPassword = findViewById(R.id.toggleConfirmPassword);
        EditText createPasswordEditText = findViewById(R.id.createPasswordEditText);

        // Flags to keep track of password visibility
        final boolean[] isCreatePasswordVisible = {false};
        final boolean[] isConfirmPasswordVisible = {false}; // (Android Knowledge, 2024)

        // Toggle password visibility for "Create Password" field
        toggleCreatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCreatePasswordVisible[0]) {
                    createPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    toggleCreatePassword.setImageResource(R.drawable.ic_eye_off); // Set eye-off icon
                } else {
                    createPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    toggleCreatePassword.setImageResource(R.drawable.ic_eye); // Set eye icon
                }
                createPasswordEditText.setSelection(createPasswordEditText.length()); // Keep cursor at end
                isCreatePasswordVisible[0] = !isCreatePasswordVisible[0]; // Toggle flag
            }
        });

        // Toggle password visibility for "Confirm Password" field
        toggleConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConfirmPasswordVisible[0]) {
                    confirmPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    toggleConfirmPassword.setImageResource(R.drawable.ic_eye_off); // Set eye-off icon
                } else {
                    confirmPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    toggleConfirmPassword.setImageResource(R.drawable.ic_eye); // Set eye icon
                }
                confirmPasswordEditText.setSelection(confirmPasswordEditText.length()); // Keep cursor at end
                isConfirmPasswordVisible[0] = !isConfirmPasswordVisible[0]; // Toggle flag
            }
        }); // (Android Knowledge, 2024)

        // Set click listener for the signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String name = nameEditText.getText().toString();
                String surname = surnameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Validate input
                if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SignupActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else if (!isPasswordStrong(password)) {
                    Toast.makeText(SignupActivity.this, "Password is not complex enough. Use 8+ chars, uppercase, number, and symbol.", Toast.LENGTH_LONG).show();
                } else {
                    // If all validations pass, create user in a new thread
                    new Thread(() -> {
                        User newUser = new User(0, name, surname, email, password, 0.0, true);
                        db.userDao().insertUserNow(newUser); // Insert user into database

                        // Save user email and ID in shared preferences
                        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("currentUserEmail", newUser.getEmail());
                        editor.putInt("currentUserId", newUser.getUserId());
                        editor.apply();

                        // Notify user and navigate to onboarding screen
                        runOnUiThread(() -> {
                            Toast.makeText(SignupActivity.this, "Account created!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignupActivity.this, OnboardingActivity.class);
                            startActivity(intent);
                            finish(); // Close current activity
                        });
                    }).start();
                }
            }
        });

        // Set click listener for "Already have an account?" text
        TextView signInText = findViewById(R.id.signUpText);
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class)); // Navigate to login screen
            }
        });
    } // (Android Knowledge, 2024)
}

//Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
