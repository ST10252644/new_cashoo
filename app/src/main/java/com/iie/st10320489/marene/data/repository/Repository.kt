package com.iie.st10320489.marene.data.repository

import androidx.lifecycle.LiveData
import com.iie.st10320489.marene.data.dao.*
import com.iie.st10320489.marene.data.entities.*
import kotlinx.coroutines.flow.Flow

// Repository for handling User-related operations
class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    fun getUserById(id: Int): Flow<User?> = userDao.getUserById(id)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    suspend fun getUserIdByEmail(email: String): Int? {
        return userDao.getUserIdByEmail(email)
    }
}

// Repository for managing UserSettings operations
class UserSettingsRepository(private val dao: UserSettingsDao) {

    suspend fun insertUserSettings(userSettings: UserSettings) {
        dao.insertUserSettings(userSettings)
    }

    suspend fun getUserSettingsByUserId(userId: Int): UserSettings? {
        return dao.getUserSettingsByUserId(userId)
    }

    fun getAllSettings(): Flow<List<UserSettings>> {
        return dao.getAllSettings()
    }

    suspend fun updateUserSettings(userSettings: UserSettings) {
        dao.updateUserSettings(userSettings)
    }

    suspend fun deleteUserSettings(userSettings: UserSettings) {
        dao.deleteSettings(userSettings)
    }

    suspend fun deleteAllSettings() {
        dao.deleteAllTableName()
    }
}

// Repository for managing Transactions and their data
class TransactionRepository(private val dao: TransactionDao) {
    suspend fun insert(transaction: Transaction) = dao.insertTransaction(transaction) // Insert transaction
    fun getAll(): Flow<List<Transaction>> = dao.getAllTransactions() // Get all transactions

    // Get a transaction by user ID and transaction ID
    fun getById(userId: Int, transactionId: Int): Flow<Transaction?> = dao.getTransactionById(userId, transactionId)

    suspend fun update(transaction: Transaction) = dao.updateTransaction(transaction)
    suspend fun delete(transaction: Transaction) = dao.deleteTransaction(transaction)

    // Get all transactions along with their categories
    suspend fun getAllTransactions(): List<TransactionWithCategory> {
        return dao.getAllTransactionsWithCategory()
    }

    // Get transactions by user ID
    suspend fun getTransactionsByUserId(userId: Int): List<TransactionWithCategory> {
        return dao.getTransactionsByUserId(userId)
    }
}

// Repository for managing Category data
class CategoryRepository(private val dao: CategoryDao) {
    suspend fun insert(category: Category) = dao.insertCategory(category)
    fun getAll(): LiveData<List<Category>> = dao.getAllCategories()
    fun getById(id: Int): Flow<Category?> = dao.getCategoryById(id)
    suspend fun delete(category: Category) = dao.deleteCategory(category)

    // Get all categories for a specific user
    fun getCategoriesByUser(userId: Int): LiveData<List<Category>> {
        return dao.getCategoriesByUser(userId)
    }
}

// Repository for managing SubCategory data
class SubCategoryRepository(private val dao: SubCategoryDao) {
    suspend fun insert(subCategory: SubCategory) = dao.insertSubCategory(subCategory)
    fun getAll(): Flow<List<SubCategory>> = dao.getAllSubCategories()
    fun getById(id: Int): Flow<SubCategory?> = dao.getSubCategoryById(id)
    suspend fun delete(subCategory: SubCategory) = dao.deleteSubCategory(subCategory)
}

// Repository for managing Reward data
class RewardRepository(private val dao: RewardDao) {
    suspend fun insert(reward: Reward) = dao.insertReward(reward)
    fun getAll(): Flow<List<Reward>> = dao.getAllRewards()
    fun getById(id: Int): Flow<Reward?> = dao.getRewardById(id)
    suspend fun update(reward: Reward) = dao.updateReward(reward)
    suspend fun delete(reward: Reward) = dao.deleteReward(reward)
}

// Repository for managing RewardHistory data
class RewardHistoryRepository(private val dao: RewardHistoryDao) {
    suspend fun insert(history: RewardHistory) = dao.insertHistory(history)
    fun getAll(): Flow<List<RewardHistory>> = dao.getAllHistory()
    fun getById(id: Int): Flow<RewardHistory?> = dao.getHistoryById(id)
    suspend fun delete(history: RewardHistory) = dao.deleteHistory(history)
}

// Repository for managing ActivityLog data
class ActivityLogRepository(private val dao: ActivityLogDao) {
    suspend fun insert(log: ActivityLog) = dao.insertLog(log)
    fun getAll(): Flow<List<ActivityLog>> = dao.getAllLogs()
    fun getById(id: Int): Flow<ActivityLog?> = dao.getLogById(id)
    suspend fun delete(log: ActivityLog) = dao.deleteLog(log)
}


//Bibliography
//AndroidDevelopers, 2024. Save data in a local database using Room. [Online] Available at: hRps://developer.android.com/training/data-storage/room [Accessed 27 April 2025].
//AndroidDevelopers, 2024. Write asynchronous DAO queries. [Online]
//Available at: hRps://developer.android.com/training/data-storage/room/async- queries?authuser=2
//[Accessed 26 April 2025].
//Raikwar, A., 2024. Ge=ng Started with Room Database in Android. [Online]
//Available at: hRps://amitraikwar.medium.com/ge[ng-started-with-room-database-in- android-fa1ca23ce21e
//[Accessed 27 April 2025].
//Raikwar, A., 2023. Ge=ng Started with Room Database in Android. [Online]
//Available at: hRps://developer.android.com/develop#core-areas
//[Accessed 28 April 2025].
//Cal, C. W., 2023. Room Database Android Studio Kotlin Example Tutorial. [Online] Available at: hRps://youtu.be/-LNg-K7SncM?si=y8cbMdvhhp48Pp9-
//[Accessed 27 April 2025].
//College, I. V., 2025. PROG7313 Module-Manual / Module-Outline. Pretoria: Varsity College Pretoria.
//Viegen, F. v., 2022. A PracKcal introducKon to Android Room-3 : EnKty, Dao and Database objects.. [Online]
//Available at: hRps://youtu.be/RstQg7f4Edk?si=8RoAGp-OKPpMNVdY
//[Accessed 28 April 2025].

//androidbyexample, 2024. EnKKes ,Dao and Database -Android By Example. [Online] Available at: hRps://androidbyexample.com/modules/movie-db/STEP-050_Repo.html [Accessed 25 April 2025].
//AndroidDevelopers, 2023. Layouts in Views. [Online]
//Available at: hRps://developer.android.com/developer/ui/views/layout/declaring-layout [Accessed 23 April 2025].
//Kay, R. M., 2022. IntroducKon To Development WithAndroid Studio: XML The Five Minute Language. [Online]
//Available at: hRps://youtu.be/94tm21PIBMs?si=BpJQ9meXr1_ynL2m
//[Accessed 15 April 2025].
//Team, G. D. T., 2024. Add repository and Manual DI. [Online]
//Available at: hRps://developer.android.com/codelabs/basic-android-kotlin-compose-add- repository#0
//[Accessed 22 April 2025].
//Coder, O., 2022. Implament Pie Chart in Android Studio Using Kotlin. [Online] Available at: hRps://youtu.be/TUJHcU0FOkA?si=jk90LRSO1_eyMyIG
//[Accessed 24 April 2025].
//Coder, E. O., 2024. hot to create bar chart | MP Android Chart | Android Studio 2024. [Online]
//Available at: hRps://youtu.be/WdsmQ3Zyn84?si=jz2AtkIRsNEUwNbX
//[Accessed 23 April 2025].
