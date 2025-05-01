package com.iie.st10320489.marene.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/iie/st10320489/marene/data/repository/CategoryRepository;", "", "dao", "Lcom/iie/st10320489/marene/data/dao/CategoryDao;", "(Lcom/iie/st10320489/marene/data/dao/CategoryDao;)V", "delete", "", "category", "Lcom/iie/st10320489/marene/data/entities/Category;", "(Lcom/iie/st10320489/marene/data/entities/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Landroidx/lifecycle/LiveData;", "", "getById", "Lkotlinx/coroutines/flow/Flow;", "id", "", "getCategoriesByUser", "userId", "insert", "app_debug"})
public final class CategoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.CategoryDao dao = null;
    
    public CategoryRepository(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.CategoryDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.iie.st10320489.marene.data.entities.Category>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.Category> getById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.iie.st10320489.marene.data.entities.Category>> getCategoriesByUser(int userId) {
        return null;
    }
}