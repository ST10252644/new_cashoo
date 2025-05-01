package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\tH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\t2\u0006\u0010\f\u001a\u00020\rH\'J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00112\u0006\u0010\u0012\u001a\u00020\rH\'J\u001c\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/CategoryDao;", "", "deleteAllTableName", "", "deleteCategory", "category", "Lcom/iie/st10320489/marene/data/entities/Category;", "(Lcom/iie/st10320489/marene/data/entities/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Landroidx/lifecycle/LiveData;", "", "getCategoriesByUser", "userId", "", "getCategoriesForUser", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryById", "Lkotlinx/coroutines/flow/Flow;", "id", "insertCategories", "categories", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCategory", "app_debug"})
@androidx.room.Dao()
public abstract interface CategoryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCategory(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Category")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.iie.st10320489.marene.data.entities.Category>> getAllCategories();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCategories(@org.jetbrains.annotations.NotNull()
    java.util.List<com.iie.st10320489.marene.data.entities.Category> categories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Category WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoriesForUser(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.Category>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Category WHERE categoryID = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.Category> getCategoryById(int id);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCategory(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM Category")
    public abstract void deleteAllTableName();
    
    @androidx.room.Query(value = "SELECT * FROM Category WHERE userId = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.iie.st10320489.marene.data.entities.Category>> getCategoriesByUser(int userId);
}