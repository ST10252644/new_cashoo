package com.iie.st10320489.marene.data.dao

import androidx.room.*
import com.iie.st10320489.marene.data.entities.ActivityLog
import kotlinx.coroutines.flow.Flow

@Dao
// Data Access Object (DAO) for performing CRUD operations on the ActivityLog table
interface ActivityLogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //(androidbyexample,2024);(Veigen,2022)
    suspend fun insertLog(log: ActivityLog)

    @Query("SELECT * FROM ActivityLog WHERE logID = :id")
    fun getLogById(id: Int): Flow<ActivityLog?>

    @Query("SELECT * FROM ActivityLog")
    fun getAllLogs(): Flow<List<ActivityLog>>

    @Delete
    suspend fun deleteLog(log: ActivityLog)//(Veigen,2022)

    // Delete all records from the ActivityLog table
    @Query("DELETE FROM ActivityLog")
    fun deleteAllTableName()
}


