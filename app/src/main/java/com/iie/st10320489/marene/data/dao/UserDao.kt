package com.iie.st10320489.marene.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iie.st10320489.marene.data.entities.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao { // (Code With Cal, 2025)

    // Inserts a user into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserNow(user: User)

    // Retrieves a user by their ID, returning a Flow that emits updates to the user data.
    @Query("SELECT * FROM User WHERE userID = :id")
    fun getUserById(id: Int): Flow<User?>

    // Retrieves all users from the database as a Flow that emits updates to the user list.
    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>

    // Retrieves all users from the database immediately (not a Flow).
    @Query("SELECT * FROM User")
    fun getAllUsersNow(): List<User>

    // Finds a user by their email address. Returns null if no user is found.
    @Query("SELECT * FROM User WHERE email = :email LIMIT 1")
    fun findUserByEmail(email: String?): User?

    // Gets the userId of a user by their email address. Suspend function for use with coroutines.
    @Query("SELECT userId FROM User WHERE email = :email")
    suspend fun getUserIdByEmail(email: String): Int?

    // Updates a user's information in the database. Requires the User to already exist.
    @Update
    suspend fun updateUser(user: User)

    // Deletes a specific user from the database.
    @Delete
    suspend fun deleteUser(user: User)

    // Deletes all users from the User table.
    @Query("DELETE FROM User")
    fun deleteAllTableName()

    // Retrieves the user's name by their email address. Returns null if not found.
    @Query("SELECT name FROM User WHERE email = :email LIMIT 1")
    suspend fun getUserNameByEmail(email: String): String?
} // (Code With Cal, 2025)

//Reference List:
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]