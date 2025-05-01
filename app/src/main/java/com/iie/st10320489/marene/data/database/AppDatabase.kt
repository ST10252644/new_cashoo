package com.iie.st10320489.marene.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.iie.st10320489.marene.data.dao.ActivityLogDao
import com.iie.st10320489.marene.data.dao.CategoryDao
import com.iie.st10320489.marene.data.dao.RewardDao
import com.iie.st10320489.marene.data.dao.RewardHistoryDao
import com.iie.st10320489.marene.data.dao.SubCategoryDao
import com.iie.st10320489.marene.data.dao.TransactionDao
import com.iie.st10320489.marene.data.dao.UserDao
import com.iie.st10320489.marene.data.dao.UserSettingsDao
import com.iie.st10320489.marene.data.entities.ActivityLog
import com.iie.st10320489.marene.data.entities.Category
import com.iie.st10320489.marene.data.entities.Reward
import com.iie.st10320489.marene.data.entities.RewardHistory
import com.iie.st10320489.marene.data.entities.SubCategory
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.data.entities.User
import com.iie.st10320489.marene.data.entities.UserSettings


@Database(//(Raikwar, 2024), (Raikwar, 2023)
    // List of all entities (tables) used in the database
    entities = [
        User::class,
        UserSettings::class,
        Transaction::class,
        Category::class,
        SubCategory::class,
        Reward::class,
        RewardHistory::class,
        ActivityLog::class
    ],    // (AndroidDevelopers, 2024), (AndroidDevelopers, 2024), (Raikwar, 2024), (Raikwar, 2023), (Cal, 2023)
    version = 5, // Database version (increment when schema changes)
    exportSchema = false // Disables schema export; set to true if schema versioning is needed
)
abstract class AppDatabase : RoomDatabase() {


    abstract fun userDao(): UserDao
    abstract fun userSettingsDao(): UserSettingsDao
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun subCategoryDao(): SubCategoryDao
    abstract fun rewardDao(): RewardDao
    abstract fun rewardHistoryDao(): RewardHistoryDao
    abstract fun activityLogDao(): ActivityLogDao
}//((Raikwar, 2024), (Raikwar, 2023),(Cal, 2023), (College, 2025))


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
