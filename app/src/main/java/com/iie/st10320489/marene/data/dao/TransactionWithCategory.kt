package com.iie.st10320489.marene.data.entities

import androidx.room.Embedded
import androidx.room.Relation

// Data class that represents a transaction along with its related category
data class TransactionWithCategory(

    @Embedded val transaction: Transaction,


    // Specifies that the 'categoryId' column in the Transaction entity relates to the 'categoryId' column in the Category entity
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val category: Category // The related Category entity will be populated based on the relationship
) // (Code With Cal, 2025)

//Reference List:
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
