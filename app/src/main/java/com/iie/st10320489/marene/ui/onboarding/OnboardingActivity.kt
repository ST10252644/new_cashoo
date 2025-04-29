package com.iie.st10320489.marene.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.ActivityOnboardingBinding
import com.iie.st10320489.marene.ui.onboarding.OnboardingActivity2 // If you want to navigate to the next screen

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button click event
        binding.nextButton.setOnClickListener {
            // Navigate to OnboardingFragment2 or directly to the next activity
            val intent = Intent(this, OnboardingActivity2::class.java) // Or replace this with an activity
            startActivity(intent)
            finish()  // Close the current activity (OnboardingActivity)
        }
    }
}
