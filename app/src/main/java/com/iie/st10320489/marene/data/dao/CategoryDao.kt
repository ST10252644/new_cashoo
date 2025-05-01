package com.iie.st10320489.marene.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iie.st10320489.marene.data.entities.Category
import kotlinx.coroutines.flow.Flow

@Dao
// DAO for handling all database operations related to the Category entity
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//(androidbyexample,2024)
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert
    suspend fun insertCategories(categories: List<Category>)

    @Query("SELECT * FROM Category WHERE userId = :userId")
    suspend fun getCategoriesForUser(userId: Int): List<Category>

    @Query("SELECT * FROM Category WHERE categoryID = :id")//(Veigen,2022)
    fun getCategoryById(id: Int): Flow<Category?>

    //@Query("SELECT * FROM Category")
    //fun getAllCategories(): Flow<List<Category>>/

    @Delete
    suspend fun deleteCategory(category: Category)

    // Delete all records from the Category table
    @Query("DELETE FROM Category")
    fun deleteAllTableName()

    @Query("SELECT * FROM Category WHERE userId = :userId")
    fun getCategoriesByUser(userId: Int): LiveData<List<Category>>
}