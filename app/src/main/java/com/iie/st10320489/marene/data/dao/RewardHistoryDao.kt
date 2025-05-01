package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.RewardHistory
import kotlinx.coroutines.flow.Flow

@Dao
// DAO for managing reward redemption history, including insert, query, and delete operations
interface RewardHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//(androidbyexample,2024)
    suspend fun insertHistory(rewardHistory: RewardHistory)

    @Query("SELECT * FROM RewardHistory WHERE historyId = :id")
    fun getHistoryById(id: Int): Flow<RewardHistory?>

    @Query("SELECT * FROM RewardHistory")
    fun getAllHistory(): Flow<List<RewardHistory>>

    @Delete
    suspend fun deleteHistory(rewardHistory: RewardHistory)//(Veigen,2022)

    // Delete all records from the RewardHistory table
    @Query("DELETE FROM RewardHistory")
    fun deleteAllTableName()
}