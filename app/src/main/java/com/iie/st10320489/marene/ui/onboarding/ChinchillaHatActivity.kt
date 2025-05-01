package com.iie.st10320489.marene.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.iie.st10320489.marene.MainActivity
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.repository.UserSettingsRepository
import com.iie.st10320489.marene.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

<<<<<<< HEAD
class ChinchillaHatActivity : AppCompatActivity() {
=======
class ChinchillaHatActivity : AppCompatActivity() { // (Code With Cal, 2025)
>>>>>>> nathan
    private lateinit var chinchillaImage: ImageView
    private var selectedColor: String = ""
    private var selectedHat: String = ""

    private lateinit var db: AppDatabase
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinchilla_hat)

<<<<<<< HEAD
        db = DatabaseInstance.getDatabase(this)
        userRepository = UserRepository(db.userDao())

=======
        // Initialize database and repository
        db = DatabaseInstance.getDatabase(this)
        userRepository = UserRepository(db.userDao())

        // Set up back button to finish the activity
>>>>>>> nathan
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

<<<<<<< HEAD
        chinchillaImage = findViewById(R.id.chinchillaImage)
        selectedColor = intent.getStringExtra("selectedColor") ?: "black"

=======
        // Initialize chinchilla image view
        chinchillaImage = findViewById(R.id.chinchillaImage)
        // Get selected color from intent or default to "black"
        selectedColor = intent.getStringExtra("selectedColor") ?: "black"

        // Set up click listeners for hat buttons
>>>>>>> nathan
        findViewById<View>(R.id.sailorButton).setOnClickListener {
            selectedHat = "sailor"
            chinchillaImage.setImageResource(getDrawableResource(selectedColor, selectedHat))
        }
        findViewById<View>(R.id.mexicanButton).setOnClickListener {
            selectedHat = "mexican"
            chinchillaImage.setImageResource(getDrawableResource(selectedColor, selectedHat))
        }
        findViewById<View>(R.id.strawberryButton).setOnClickListener {
            selectedHat = "strawberry"
            chinchillaImage.setImageResource(getDrawableResource(selectedColor, selectedHat))
        }
        findViewById<View>(R.id.pirateButton).setOnClickListener {
            selectedHat = "pirate"
            chinchillaImage.setImageResource(getDrawableResource(selectedColor, selectedHat))
<<<<<<< HEAD
        }

=======
        } // (Code With Cal, 2025)

        // Set up next button to save data and move to next activity
>>>>>>> nathan
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val chinchillaString = "${selectedColor}_${selectedHat}"
            saveChinchillaToDatabase(chinchillaString)
            // TODO: Move to next activity if needed
        }
    }

<<<<<<< HEAD
=======
    // Helper method to get drawable resource ID based on color and hat
>>>>>>> nathan
    private fun getDrawableResource(color: String, hat: String): Int {
        return resources.getIdentifier("${color}_${hat}", "drawable", packageName)
    }

<<<<<<< HEAD
=======
    // Save chinchilla selection to the database for the current user
>>>>>>> nathan
    private fun saveChinchillaToDatabase(chinchillaString: String) {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
<<<<<<< HEAD
=======
            // Launch a coroutine on the IO dispatcher to handle database operations
>>>>>>> nathan
            lifecycleScope.launch(Dispatchers.IO) {
                val userId = userRepository.getUserIdByEmail(currentUserEmail)

                if (userId != null) {
                    val userSettings = db.userSettingsDao().getUserSettingsByUserId(userId)

                    if (userSettings != null) {
<<<<<<< HEAD
=======
                        // Update user settings with the selected chinchilla color and hat
>>>>>>> nathan
                        userSettings.color = selectedColor
                        userSettings.chinchilla = chinchillaString
                        db.userSettingsDao().updateUserSettings(userSettings)

<<<<<<< HEAD

                        println("UserSettings updated: color=${userSettings.color}, chinchilla=${userSettings.chinchilla}")


=======
                        // Log update for debugging
                        println("UserSettings updated: color=${userSettings.color}, chinchilla=${userSettings.chinchilla}")

                        // Switch to the main thread to update UI and navigate
>>>>>>> nathan
                        withContext(Dispatchers.Main) {
                            val intent = Intent(this@ChinchillaHatActivity, MainActivity::class.java)
                            intent.putExtra("navigateToHome", true)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }
<<<<<<< HEAD

                    }
                }
            }
        }
    }
}
=======
                    }
                }
            } // (Code With Cal, 2025)
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
>>>>>>> nathan
