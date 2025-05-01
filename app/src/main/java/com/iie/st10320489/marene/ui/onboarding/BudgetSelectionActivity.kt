package com.iie.st10320489.marene.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.repository.UserRepository
import com.iie.st10320489.marene.databinding.ActivityBudgetSelectionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

<<<<<<< HEAD
class BudgetSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBudgetSelectionBinding
    private val selectedCategories = mutableListOf<String>()
    private val categories = listOf(
=======
class BudgetSelectionActivity : AppCompatActivity() { // (Code With Cal, 2025)

    private lateinit var binding: ActivityBudgetSelectionBinding
    private val selectedCategories = mutableListOf<String>()   // List to hold user-selected categories
    private val categories = listOf(  // Predefined list of budget categories
>>>>>>> nathan
        "House", "Food", "Transport", "Health", "Loans",
        "Entertainment", "Family", "Savings", "Salary"
    )

<<<<<<< HEAD

=======
    // ViewModel instance with factory to provide DAO from database
>>>>>>> nathan
    private val onboardingViewModel: OnboardingViewModel by viewModels {
        OnboardingViewModelFactory(
            categoryDao = DatabaseInstance.getDatabase(application).categoryDao()
        )
<<<<<<< HEAD
    }
=======
    } // (Code With Cal, 2025)
>>>>>>> nathan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBudgetSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategoryViews()
        setupButtons()
    }

<<<<<<< HEAD
=======
    // Dynamically create category views and handle selection logic
>>>>>>> nathan
    private fun setupCategoryViews() {
        categories.forEach { category ->
            val categoryView = TextView(this).apply {
                text = category
                textSize = 16f
                setTextColor(ContextCompat.getColor(context, android.R.color.black))
                setPadding(32, 32, 32, 32)
                background = ContextCompat.getDrawable(context, R.drawable.category_unselected)

                layoutParams = LinearLayout.LayoutParams(
                    resources.getDimensionPixelSize(R.dimen.category_width),
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    bottomMargin = 16
                }

                setOnClickListener {
                    if (selectedCategories.contains(category)) {
                        selectedCategories.remove(category)
                        background = ContextCompat.getDrawable(context, R.drawable.category_unselected)
                    } else {
                        selectedCategories.add(category)
                        background = ContextCompat.getDrawable(context, R.drawable.category_selected)
                    }
                }
            }
            binding.categoriesContainer.addView(categoryView)
        }
<<<<<<< HEAD
    }
=======
    } // (Code With Cal, 2025)
>>>>>>> nathan

    private fun setupButtons() {
        binding.backButton.setOnClickListener {
            finish()
        }

        binding.nextButton.setOnClickListener {
            if (selectedCategories.isNotEmpty()) {

                saveUserSelectedCategories()
            } else {
                Toast.makeText(this, "Please select at least one category", Toast.LENGTH_SHORT).show()
            }
        }
<<<<<<< HEAD
    }
=======
    } // (Code With Cal, 2025)
>>>>>>> nathan


    private fun getCurrentUserEmail(): String {
        val sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE)
        val email = sharedPreferences.getString("currentUserEmail", "")
        Log.d("BudgetSelectionActivity", "Retrieved email: $email")
        return email ?: ""
    }



    private fun saveUserSelectedCategories() {


        val userDao = DatabaseInstance.getDatabase(application).userDao()  // Correct usage
        val userRepository = UserRepository(userDao)
        // Fetch the current user email (assuming you have it saved in SharedPreferences)
        val currentUserEmail = getCurrentUserEmail()

        // Launch a coroutine to fetch the userId asynchronously
        CoroutineScope(Dispatchers.IO).launch {
            val userId = userRepository.getUserIdByEmail(currentUserEmail)  // Suspend function call

            // After getting the userId, save selected categories
            if (userId == null) {
                // Handle the case where the user is not found
                println("User not found for email: $currentUserEmail")
            } else {
                // Proceed with saving the categories
                onboardingViewModel.saveSelectedCategories(userId, selectedCategories)
            }

            // Once the data is saved, navigate to the next screen (ensure this is done on the main thread)
            withContext(Dispatchers.Main) {
                val intent = Intent(this@BudgetSelectionActivity, SavingsGoalActivity::class.java)
                startActivity(intent)
            }
        }
<<<<<<< HEAD
    }

}
=======
    } // (Code With Cal, 2025)

}

//Reference List:
//Android Developers. 2025. Add an Image composition. [online]. Available at: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images#2 [Accessed on 9 April 2025]
//Code With Cal. 2025. Color Picker Android Studio Kotlin Custom Spinner Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=YsKjl8ZbM4g [Accessed on 9 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
//Programming w/ Professor Sluiter. 2023. Learn Kotlin 08 how to use the if conditional statement. [online]. Available at: https://www.youtube.com/watch?v=usFfxlnTPHc [Accessed on 13 April 2025]
//GeeksforGeeks. 2025. Android UI Layouts. [online]. Available at: https://www.geeksforgeeks.org/android-ui-layouts/ [Accessed on 10 April 2025]
//Muhammadumarch. 2023. Implementing Navigation in Your Android App with Android Navigation Component. [online]. Available at: https://medium.com/@muhammadumarch321/implementing-navigation-in-your-android-app-with-android-navigation-component-ff22a3d300a [Accessed on 11 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]

>>>>>>> nathan
