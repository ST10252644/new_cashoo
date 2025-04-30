package com.iie.st10320489.marene.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC LIMIT 5")
    suspend fun getTop5RecentTransactionsByUserId(userId: Int): List<TransactionWithCategory>


    @Insert
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` WHERE transactionID = :id")
    fun getTransactionById(id: Int): Flow<Transaction?>

    @Query("SELECT * FROM `Transaction`")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    //delete all from table
    @Query("DELETE FROM `Transaction`")
    fun deleteAllTableName()


    @Query("SELECT * FROM `Transaction` ORDER BY dateTime DESC")
    suspend fun getAllTransactionsWithCategory(): List<TransactionWithCategory>

    @Query("SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC")
    suspend fun getTransactionsByUserId(userId: Int): List<TransactionWithCategory>

    @Query("SELECT * FROM `Transaction` WHERE userId = :userId AND categoryId = :categoryId")
    fun getTransactionsByUserAndCategory(userId: Int, categoryId: Int): LiveData<List<Transaction>>

    @Query("""
    SELECT `Transaction`.* FROM `Transaction`
    INNER JOIN Category ON `Transaction`.categoryId = Category.categoryID
    WHERE `Transaction`.userId = :userId
    AND category.name = :categoryName
""")
    suspend fun getTransactionsByUserIdAndCategoryName(userId: Int, categoryName: String): List<TransactionWithCategory>

    @Query("SELECT * FROM `Transaction` ORDER BY dateTime DESC")
    fun getAllTransactionsWithCategoryFlow(): Flow<List<TransactionWithCategory>>

}


