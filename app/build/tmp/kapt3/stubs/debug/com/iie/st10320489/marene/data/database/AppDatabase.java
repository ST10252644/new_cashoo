package com.iie.st10320489.marene.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/iie/st10320489/marene/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "activityLogDao", "Lcom/iie/st10320489/marene/data/dao/ActivityLogDao;", "categoryDao", "Lcom/iie/st10320489/marene/data/dao/CategoryDao;", "rewardDao", "Lcom/iie/st10320489/marene/data/dao/RewardDao;", "rewardHistoryDao", "Lcom/iie/st10320489/marene/data/dao/RewardHistoryDao;", "subCategoryDao", "Lcom/iie/st10320489/marene/data/dao/SubCategoryDao;", "transactionDao", "Lcom/iie/st10320489/marene/data/dao/TransactionDao;", "userDao", "Lcom/iie/st10320489/marene/data/dao/UserDao;", "userSettingsDao", "Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;", "app_debug"})
@androidx.room.Database(entities = {com.iie.st10320489.marene.data.entities.User.class, com.iie.st10320489.marene.data.entities.UserSettings.class, com.iie.st10320489.marene.data.entities.Transaction.class, com.iie.st10320489.marene.data.entities.Category.class, com.iie.st10320489.marene.data.entities.SubCategory.class, com.iie.st10320489.marene.data.entities.Reward.class, com.iie.st10320489.marene.data.entities.RewardHistory.class, com.iie.st10320489.marene.data.entities.ActivityLog.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.UserSettingsDao userSettingsDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.CategoryDao categoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.SubCategoryDao subCategoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.RewardDao rewardDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.RewardHistoryDao rewardHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.iie.st10320489.marene.data.dao.ActivityLogDao activityLogDao();
}