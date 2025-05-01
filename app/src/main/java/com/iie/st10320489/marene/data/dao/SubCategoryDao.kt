package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.SubCategory
import kotlinx.coroutines.flow.Flow

@Dao
// DAO for handling database operations related to SubCategory entities
interface SubCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubCategory(subCategory: SubCategory)

    @Query("SELECT * FROM SubCategory WHERE subCategoryID = :id")
    fun getSubCategoryById(id: Int): Flow<SubCategory?>

    @Query("SELECT * FROM SubCategory")
    fun getAllSubCategories(): Flow<List<SubCategory>>

    @Delete
    suspend fun deleteSubCategory(subCategory: SubCategory)//(Veigen,2022)

    // Delete all records from the SubCategory table
    @Query("DELETE FROM SubCategory")
    fun deleteAllTableName()

    @Query("SELECT * FROM SubCategory WHERE userId = :userId")
    suspend fun getSubCategoriesForUser(userId: Int): List<SubCategory>

    @Query("DELETE FROM SubCategory")
    suspend fun deleteAllSubCategories()//(androidbyexample,2024)
}
