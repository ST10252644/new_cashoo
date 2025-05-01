package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\tH\'J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u00a7@\u00a2\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\'J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0018J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\'J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0018J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010$J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010$J\u001c\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010)\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006+"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/TransactionDao;", "", "deleteAllTableName", "", "deleteTransaction", "transaction", "Lcom/iie/st10320489/marene/data/entities/Transaction;", "(Lcom/iie/st10320489/marene/data/entities/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "getAllTransactionsWithCategory", "Lcom/iie/st10320489/marene/data/entities/TransactionWithCategory;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthlyExpenses", "userId", "", "month", "", "year", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthlyIncome", "getMonthlySavings", "getTop5RecentTransactionsByUserId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionById", "transactionId", "getTransactionWithCategoryById", "id", "getTransactionsByUser", "getTransactionsByUserAndCategory", "Landroidx/lifecycle/LiveData;", "categoryId", "getTransactionsByUserId", "getTransactionsByUserIdAndCategoryName", "categoryName", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByUserIdAndSubCategoryName", "subCategoryName", "getTransactionsWithCategory", "insert", "insertTransaction", "updateTransaction", "app_debug"})
@androidx.room.Dao()
public abstract interface TransactionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC LIMIT 5")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTop5RecentTransactionsByUserId(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByUser(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId AND transactionId = :transactionId LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.Transaction> getTransactionById(int userId, int transactionId);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction`")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.Transaction>> getAllTransactions();
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM `Transaction`")
    public abstract void deleteAllTableName();
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` ORDER BY dateTime DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllTransactionsWithCategory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId ORDER BY dateTime DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByUserId(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId AND categoryId = :categoryId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.iie.st10320489.marene.data.entities.Transaction>> getTransactionsByUserAndCategory(int userId, int categoryId);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE transactionId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionWithCategoryById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.iie.st10320489.marene.data.entities.TransactionWithCategory> $completion);
    
    @androidx.room.Query(value = "\n    SELECT `Transaction`.* FROM `Transaction`\n    INNER JOIN Category ON `Transaction`.categoryId = Category.categoryID\n    WHERE `Transaction`.userId = :userId\n    AND category.name = :categoryName\n")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByUserIdAndCategoryName(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM `Transaction` \n    INNER JOIN SubCategory ON `Transaction`.subCategoryId = SubCategory.subCategoryId\n    WHERE `Transaction`.userId = :userId AND SubCategory.name = :subCategoryName\n")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByUserIdAndSubCategoryName(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String subCategoryName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM `Transaction` \n    WHERE userId = :userId \n      AND strftime(\'%m\', dateTime) = :month \n      AND strftime(\'%Y\', dateTime) = :year \n      AND expense = 0\n")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMonthlyIncome(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    java.lang.String year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.Transaction>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT * FROM `Transaction` \n    WHERE userId = :userId \n      AND strftime(\'%m\', dateTime) = :month \n      AND strftime(\'%Y\', dateTime) = :year \n      AND expense = 1\n")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMonthlyExpenses(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    java.lang.String year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.Transaction>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Transaction` WHERE userId = :userId AND expense = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsWithCategory(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> $completion);
    
    @androidx.room.Query(value = "\n    SELECT t.* FROM `Transaction` t\n    INNER JOIN Category c ON t.categoryId = c.categoryID\n    WHERE t.userId = :userId \n      AND strftime(\'%m\', t.dateTime) = :month \n      AND strftime(\'%Y\', t.dateTime) = :year \n      AND c.name = \'Savings\'\n")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMonthlySavings(int userId, @org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    java.lang.String year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.iie.st10320489.marene.data.entities.Transaction>> $completion);
}