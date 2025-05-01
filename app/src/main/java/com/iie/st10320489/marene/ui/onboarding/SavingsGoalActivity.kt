package com.iie.st10320489.marene.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.UserSettings
import com.iie.st10320489.marene.data.repository.UserRepository
import kotlinx.coroutines.*

class SavingsGoalActivity : AppCompatActivity() {

    // Declare UI elements for Spinner, SeekBars, and TextViews
    private lateinit var spinner: Spinner
    private lateinit var salarySlider: SeekBar
    private lateinit var minSavingsSlider: SeekBar
    private lateinit var maxSpendingSlider: SeekBar
    private lateinit var salaryValue: TextView
    private lateinit var minSavingsValue: TextView
    private lateinit var maxSpendingValue: TextView // (Code With Cal, 2025)

    // onCreate method is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_goal)

        // Set up the back button to finish the activity when clicked
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }


        spinner = findViewById(R.id.paydaySpinner)
        val items = arrayOf("Select your payday", "Weekly", "Bi-weekly", "Monthly")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter // (Code With Cal, 2025)

        // Initialize the SeekBars and TextViews for salary, minimum savings, and maximum spending
        salarySlider = findViewById(R.id.salarySlider)
        minSavingsSlider = findViewById(R.id.minSavingsSlider)
        maxSpendingSlider = findViewById(R.id.maxSpendingSlider)

        salaryValue = findViewById(R.id.salaryValue)
        minSavingsValue = findViewById(R.id.minSavingsValue)
        maxSpendingValue = findViewById(R.id.maxSpendingValue)

        // Set up listeners for salary slider to update the displayed salary value dynamically
        salarySlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                salaryValue.text = "R" + progress.toString() // Display salary with "R" as currency symbol
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set up listeners for minimum savings slider to update the displayed minimum savings value dynamically
        minSavingsSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                minSavingsValue.text = "R" + progress.toString() // Display minimum savings with "R" as currency symbol
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set up listeners for maximum spending slider to update the displayed maximum spending value dynamically
        maxSpendingSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                maxSpendingValue.text = "R" + progress.toString() // Display maximum spending with "R" as currency symbol
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set up the "Next" button to save the user settings when clicked
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            saveUserSettings() // (Code With Cal, 2025)
        }
    }

    // Method to get the current user's email from SharedPreferences
    private fun getCurrentUserEmail(): String {
        val sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE)
        return sharedPreferences.getString("currentUserEmail", "") ?: ""
    }

    // Method to save user settings to the database
    private fun saveUserSettings() {
        // Get the DAO objects for interacting with the database
        val userDao = DatabaseInstance.getDatabase(application).userDao()
        val userSettingsDao = DatabaseInstance.getDatabase(application).userSettingsDao()
        val userRepository = UserRepository(userDao)

        // Get the values from the UI elements (spinner and sliders)
        val selectedPayday = spinner.selectedItem.toString()
        val salary = salarySlider.progress.toDouble()
        val minGoal = minSavingsSlider.progress.toDouble()
        val maxGoal = maxSpendingSlider.progress.toDouble() // (Code With Cal, 2025)

        // Get the current user's email
        val currentUserEmail = getCurrentUserEmail()

        // Perform the database operations in a background thread (using Coroutine)
        CoroutineScope(Dispatchers.IO).launch {
            // Fetch user ID from the database using the current user's email
            val userId = userRepository.getUserIdByEmail(currentUserEmail)

            // If the user ID is found, save the settings to the database
            if (userId != null) {
                val userSettings = UserSettings(
                    userId = userId,
                    payday = selectedPayday,
                    salary = salary,
                    minGoal = minGoal,
                    maxGoal = maxGoal,
                    color = "",
                    chinchilla = ""
                ) // (Code With Cal, 2025)

                // Print the created UserSettings object for debugging purposes
                println("UserSettings created: $userSettings")

                // Insert the new user settings into the database
                userSettingsDao.insertUserSettings(userSettings)

                // After the settings are saved, show a success message and move to the next screen
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@SavingsGoalActivity, "Settings saved", Toast.LENGTH_SHORT).show()

                    // Navigate to the next activity (ChinchillaActivity)
                    val intent = Intent(this@SavingsGoalActivity, ChinchillaActivity::class.java)
                    startActivity(intent)
                }
            } else {
                // If user ID is not found, show an error message
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@SavingsGoalActivity, "Error: User not found.", Toast.LENGTH_SHORT).show()
                }
            }
        }
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

