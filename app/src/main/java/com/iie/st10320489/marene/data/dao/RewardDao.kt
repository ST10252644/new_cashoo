package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.Reward
import kotlinx.coroutines.flow.Flow

@Dao
// DAO for performing CRUD operations on the Reward table
interface RewardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//(androidbyexample,2024),//(Veigen,2022)
    suspend fun insertReward(reward: Reward)

    @Query("SELECT * FROM Reward WHERE rewardID = :id")
    fun getRewardById(id: Int): Flow<Reward?>

    @Query("SELECT * FROM Reward")
    fun getAllRewards(): Flow<List<Reward>>

    @Update
    suspend fun updateReward(reward: Reward)//(Veigen,2022)

    @Delete
    suspend fun deleteReward(reward: Reward)

    // Delete all records from the Reward table
    @Query("DELETE FROM Reward")
    fun deleteAllTableName()
}

