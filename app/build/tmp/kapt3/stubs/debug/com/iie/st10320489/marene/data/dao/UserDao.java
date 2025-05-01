package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\fH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/UserDao;", "", "deleteAllTableName", "", "deleteUser", "user", "Lcom/iie/st10320489/marene/data/entities/User;", "(Lcom/iie/st10320489/marene/data/entities/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findUserByEmail", "email", "", "getAllUsers", "Lkotlinx/coroutines/flow/Flow;", "", "getAllUsersNow", "getUserById", "id", "", "getUserIdByEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserNameByEmail", "insertUser", "insertUserNow", "updateUser", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertUserNow(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.User user);
    
    @androidx.room.Query(value = "SELECT * FROM User WHERE userID = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.User> getUserById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM User")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.User>> getAllUsers();
    
    @androidx.room.Query(value = "SELECT * FROM User")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.iie.st10320489.marene.data.entities.User> getAllUsersNow();
    
    @androidx.room.Query(value = "SELECT * FROM User WHERE email = :email LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract com.iie.st10320489.marene.data.entities.User findUserByEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String email);
    
    @androidx.room.Query(value = "SELECT userId FROM User WHERE email = :email")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserIdByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM User")
    public abstract void deleteAllTableName();
    
    @androidx.room.Query(value = "SELECT name FROM User WHERE email = :email LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserNameByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
}