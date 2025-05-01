package com.iie.st10320489.marene.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "Transaction",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"]),
        ForeignKey(entity = SubCategory::class, parentColumns = ["subCategoryId"], childColumns = ["subCategoryId"])
    ]
)
<<<<<<< HEAD
data class Transaction(
    @PrimaryKey(autoGenerate = true) val transactionId: Int = 0,
    val userId: Int,
    val name: String,
    val amount: Double,
    val transactionMethod: String,
    val location: String?,
    val dateTime: String,
    val description: String,
    val photo: String,
    val categoryId: Int,
    val subCategoryId: Int?,
    val expense: Boolean,
    val recurring: Boolean
)
=======
data class Transaction( // (Android Knowledge, 2024)
    @PrimaryKey(autoGenerate = true) val transactionId: Int = 0,
    // Foreign key reference to the user who made the transaction
    val userId: Int,

    // Name or title of the transaction
    val name: String,

    // Amount of money involved in the transaction
    val amount: Double,

    // Method used for the transaction (e.g., cash, credit card)
    val transactionMethod: String,

    // Optional location where the transaction occurred
    val location: String?,

    // Date and time of the transaction in String format
    val dateTime: String,

    // Detailed description of the transaction
    val description: String,

    // Path or URI to a photo associated with the transaction
    val photo: String,

    // Foreign key reference to the main category of the transaction
    val categoryId: Int,

    // Optional foreign key reference to a subcategory
    val subCategoryId: Int?,

    // Flag indicating whether the transaction is an expense (true) or income (false)
    val expense: Boolean,

    // Flag indicating whether the transaction is recurring
    val recurring: Boolean
) // (Android Knowledge, 2024)

//Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
>>>>>>> nathan
