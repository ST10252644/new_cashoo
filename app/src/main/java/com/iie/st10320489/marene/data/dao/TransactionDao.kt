package com.iie.st10320489.marene.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    // Inserts a transaction; replaces on conflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    // Retrieves top 5 most recent transactions for a specific user
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC LIMIT 5")
    suspend fun getTop5RecentTransactionsByUserId(userId: Int): List<TransactionWithCategory>

    // Retrieves all transactions for a user
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId")
    suspend fun getTransactionsByUser(userId: Int): List<TransactionWithCategory>

    // Inserts a transaction without specifying conflict strategy
    @Insert
    suspend fun insert(transaction: Transaction)

    // Retrieves a transaction by userId and transactionId as a Flow
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId AND transactionId = :transactionId LIMIT 1")
    fun getTransactionById(userId: Int, transactionId: Int): Flow<Transaction?>

    // Retrieves all transactions as a Flow
    @Query("SELECT * FROM `Transaction`")
    fun getAllTransactions(): Flow<List<Transaction>>

    // Updates a given transaction
    @Update
    suspend fun updateTransaction(transaction: Transaction)

    // Deletes a given transaction
    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    // Deletes all entries from the Transaction table
    @Query("DELETE FROM `Transaction`")
    fun deleteAllTableName()

    // Retrieves all transactions with category information ordered by dateTime descending
    @Query("SELECT * FROM `Transaction` ORDER BY dateTime DESC")
    suspend fun getAllTransactionsWithCategory(): List<TransactionWithCategory>

    // Retrieves all transactions for a user ordered by dateTime descending
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC")
    suspend fun getTransactionsByUserId(userId: Int): List<TransactionWithCategory>

    // Retrieves transactions for a user and specific category as LiveData
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId AND categoryId = :categoryId")
    fun getTransactionsByUserAndCategory(userId: Int, categoryId: Int): LiveData<List<Transaction>>

    // Retrieves a transaction by its ID with category information
    @Query("SELECT * FROM `Transaction` WHERE transactionId = :id")
    suspend fun getTransactionWithCategoryById(id: Int): TransactionWithCategory?

    // Retrieves transactions by user ID and category name using a join with Category table
    @Query("""
    SELECT `Transaction`.* FROM `Transaction`
    INNER JOIN Category ON `Transaction`.categoryId = Category.categoryID
    WHERE `Transaction`.userId = :userId
    AND category.name = :categoryName
""")
    suspend fun getTransactionsByUserIdAndCategoryName(userId: Int, categoryName: String): List<TransactionWithCategory>

    // Retrieves transactions by user ID and subcategory name using a join with SubCategory table
    @Query("""
    SELECT * FROM `Transaction` 
    INNER JOIN SubCategory ON `Transaction`.subCategoryId = SubCategory.subCategoryId
    WHERE `Transaction`.userId = :userId AND SubCategory.name = :subCategoryName
""")
    suspend fun getTransactionsByUserIdAndSubCategoryName(userId: Int, subCategoryName: String): List<TransactionWithCategory>

    // Retrieves income transactions for a user for a specific month and year
    @Query("""
    SELECT * FROM `Transaction` 
    WHERE userId = :userId 
      AND strftime('%m', dateTime) = :month 
      AND strftime('%Y', dateTime) = :year 
      AND expense = 0
""")
    suspend fun getMonthlyIncome(userId: Int, month: String, year: String): List<Transaction>

    // Retrieves expense transactions for a user for a specific month and year
    @Query("""
    SELECT * FROM `Transaction` 
    WHERE userId = :userId 
      AND strftime('%m', dateTime) = :month 
      AND strftime('%Y', dateTime) = :year 
      AND expense = 1
""")
    suspend fun getMonthlyExpenses(userId: Int, month: String, year: String): List<Transaction>

    // Retrieves all expense transactions for a user with category information
    @Query("SELECT * FROM `Transaction` WHERE userId = :userId AND expense = 1")
    suspend fun getTransactionsWithCategory(userId: Int): List<TransactionWithCategory>

    // Retrieves savings transactions for a user for a specific month and year using join with Category table
    @Query("""
    SELECT t.* FROM `Transaction` t
    INNER JOIN Category c ON t.categoryId = c.categoryID
    WHERE t.userId = :userId 
      AND strftime('%m', t.dateTime) = :month 
      AND strftime('%Y', t.dateTime) = :year 
      AND c.name = 'Savings'
""")
    suspend fun getMonthlySavings(userId: Int, month: String, year: String): List<Transaction>
}

//Reference List:
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]