package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\'J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\'J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\'J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/SubCategoryDao;", "", "deleteAllSubCategories", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllTableName", "deleteSubCategory", "subCategory", "Lcom/iie/st10320489/marene/data/entities/SubCategory;", "(Lcom/iie/st10320489/marene/data/entities/SubCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSubCategories", "Lkotlinx/coroutines/flow/Flow;", "", "getSubCategoriesForUser", "userId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubCategoryById", "id", "insertSubCategory", "app_debug"})
@androidx.room.Dao()
public abstract interface SubCategoryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSubCategory(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.SubCategory subCategory, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM SubCategory WHERE subCategoryID = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.SubCategory> getSubCategoryById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM SubCategory")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.SubCategory>> getAllSubCategories();
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSubCategory(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.SubCategory subCategory, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM SubCategory")
    public abstract void deleteAllTableName();
    
    @androidx.room.Query(value = "SELECT * FROM SubCategory WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSubCategoriesForUser(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.SubCategory>> $completion);
    
    @androidx.room.Query(value = "DELETE FROM SubCategory")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllSubCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}