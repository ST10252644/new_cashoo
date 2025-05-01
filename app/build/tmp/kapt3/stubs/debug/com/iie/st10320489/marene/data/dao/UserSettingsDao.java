package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\tH\'J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;", "", "deleteAllTableName", "", "deleteSettings", "userSettings", "Lcom/iie/st10320489/marene/data/entities/UserSettings;", "(Lcom/iie/st10320489/marene/data/entities/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSettings", "Lkotlinx/coroutines/flow/Flow;", "", "getUserSettingsByUserId", "userId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "updateUserSettings", "app_debug"})
@androidx.room.Dao()
public abstract interface UserSettingsDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUserSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM UserSettings WHERE userId = :userId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserSettingsByUserId(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iie.st10320489.marene.data.entities.UserSettings> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM UserSettings")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.UserSettings>> getAllSettings();
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM UserSettings")
    public abstract void deleteAllTableName();
}