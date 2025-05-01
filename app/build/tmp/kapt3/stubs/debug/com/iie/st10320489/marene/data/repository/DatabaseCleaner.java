package com.iie.st10320489.marene.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/iie/st10320489/marene/data/repository/DatabaseCleaner;", "", "userDao", "Lcom/iie/st10320489/marene/data/dao/UserDao;", "userSettingsDao", "Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;", "transactionDao", "Lcom/iie/st10320489/marene/data/dao/TransactionDao;", "categoryDao", "Lcom/iie/st10320489/marene/data/dao/CategoryDao;", "subCategoryDao", "Lcom/iie/st10320489/marene/data/dao/SubCategoryDao;", "rewardDao", "Lcom/iie/st10320489/marene/data/dao/RewardDao;", "rewardHistoryDao", "Lcom/iie/st10320489/marene/data/dao/RewardHistoryDao;", "activityLogDao", "Lcom/iie/st10320489/marene/data/dao/ActivityLogDao;", "(Lcom/iie/st10320489/marene/data/dao/UserDao;Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;Lcom/iie/st10320489/marene/data/dao/TransactionDao;Lcom/iie/st10320489/marene/data/dao/CategoryDao;Lcom/iie/st10320489/marene/data/dao/SubCategoryDao;Lcom/iie/st10320489/marene/data/dao/RewardDao;Lcom/iie/st10320489/marene/data/dao/RewardHistoryDao;Lcom/iie/st10320489/marene/data/dao/ActivityLogDao;)V", "clearAllData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DatabaseCleaner {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.UserSettingsDao userSettingsDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.SubCategoryDao subCategoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.RewardDao rewardDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.RewardHistoryDao rewardHistoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.ActivityLogDao activityLogDao = null;
    
    public DatabaseCleaner(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.UserSettingsDao userSettingsDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.CategoryDao categoryDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.SubCategoryDao subCategoryDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.RewardDao rewardDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.RewardHistoryDao rewardHistoryDao, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.ActivityLogDao activityLogDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAllData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}