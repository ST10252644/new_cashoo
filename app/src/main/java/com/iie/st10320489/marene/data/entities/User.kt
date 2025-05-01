package com.iie.st10320489.marene.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
<<<<<<< HEAD
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    var cashoos: Double,
    val isActive: Boolean
)
=======
    @PrimaryKey(autoGenerate = true) val userId: Int = 0, // (Android Knowledge, 2024)

    // Stores the user's first name
    val name: String,

    // Stores the user's last name
    val surname: String,

    // Stores the user's email address
    val email: String,

    // Stores the user's password
    val password: String,

    // Stores the user's cash balance (modifiable)
    var cashoos: Double,

    // Indicates whether the user account is active
    val isActive: Boolean
) // (Android Knowledge, 2024)

//Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
>>>>>>> nathan
