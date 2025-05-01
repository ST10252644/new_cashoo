package com.iie.st10320489.marene.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/iie/st10320489/marene/data/repository/UserSettingsRepository;", "", "dao", "Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;", "(Lcom/iie/st10320489/marene/data/dao/UserSettingsDao;)V", "deleteAllSettings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserSettings", "userSettings", "Lcom/iie/st10320489/marene/data/entities/UserSettings;", "(Lcom/iie/st10320489/marene/data/entities/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSettings", "Lkotlinx/coroutines/flow/Flow;", "", "getUserSettingsByUserId", "userId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "updateUserSettings", "app_debug"})
public final class UserSettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.UserSettingsDao dao = null;
    
    public UserSettingsRepository(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.UserSettingsDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertUserSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserSettingsByUserId(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iie.st10320489.marene.data.entities.UserSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.UserSettings>> getAllSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUserSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUserSettings(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}