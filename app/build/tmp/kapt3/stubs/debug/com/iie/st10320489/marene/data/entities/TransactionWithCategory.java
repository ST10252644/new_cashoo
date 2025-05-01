package com.iie.st10320489.marene.data.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/iie/st10320489/marene/data/entities/TransactionWithCategory;", "", "transaction", "Lcom/iie/st10320489/marene/data/entities/Transaction;", "category", "Lcom/iie/st10320489/marene/data/entities/Category;", "(Lcom/iie/st10320489/marene/data/entities/Transaction;Lcom/iie/st10320489/marene/data/entities/Category;)V", "getCategory", "()Lcom/iie/st10320489/marene/data/entities/Category;", "getTransaction", "()Lcom/iie/st10320489/marene/data/entities/Transaction;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class TransactionWithCategory {
    @androidx.room.Embedded()
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.entities.Transaction transaction = null;
    @androidx.room.Relation(parentColumn = "categoryId", entityColumn = "categoryId")
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.entities.Category category = null;
    
    public TransactionWithCategory(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iie.st10320489.marene.data.entities.Transaction getTransaction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iie.st10320489.marene.data.entities.Category getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iie.st10320489.marene.data.entities.Transaction component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iie.st10320489.marene.data.entities.Category component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.iie.st10320489.marene.data.entities.TransactionWithCategory copy(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Category category) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}