/*
package com.iie.st10320489.marene.ui.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentOnboarding2Binding
import com.iie.st10320489.marene.ui.onboarding.BudgetSelectionActivity

class OnboardingFragment2 : Fragment() {

    private var _binding: FragmentOnboarding2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboarding2Binding.inflate(inflater, container, false)

        // SET UP BUTTON CLICK
        binding.nextButton.setOnClickListener {

            // Navigate to the next activity (e.g., Budget Selection)
            val intent = Intent( BudgetSelectionActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
/**//*

}
*/
