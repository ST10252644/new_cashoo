package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.UserSettings
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSettingsDao { // (Code With Cal, 2025)

    // Inserts a new UserSettings entry into the database.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSettings(userSettings: UserSettings)

    // Retrieves the user settings entry for a specific userId.
    // Returns null if no such entry exists.
    @Query("SELECT * FROM UserSettings WHERE userId = :userId LIMIT 1")
    suspend fun getUserSettingsByUserId(userId: Int): UserSettings?

    // Retrieves all user settings entries as a Flow, which emits updates when the data changes.
    @Query("SELECT * FROM UserSettings")
    fun getAllSettings(): Flow<List<UserSettings>>

    // Updates an existing user settings entry in the database.
    @Update
    suspend fun updateUserSettings(userSettings: UserSettings)

    // Deletes a specific user settings entry from the database.
    @Delete
    suspend fun deleteSettings(userSettings: UserSettings)

    // Deletes all entries from the user settings table.
    @Query("DELETE FROM UserSettings")
    fun deleteAllTableName() // (Code With Cal, 2025)
}

//Reference List:
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]