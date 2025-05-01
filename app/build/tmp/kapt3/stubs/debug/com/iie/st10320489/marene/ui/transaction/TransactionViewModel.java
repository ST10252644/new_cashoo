package com.iie.st10320489.marene.ui.transaction;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/iie/st10320489/marene/ui/transaction/TransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iie/st10320489/marene/data/repository/TransactionRepository;", "(Lcom/iie/st10320489/marene/data/repository/TransactionRepository;)V", "_transactions", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/iie/st10320489/marene/data/entities/TransactionWithCategory;", "transactions", "Lkotlinx/coroutines/flow/StateFlow;", "getTransactions", "()Lkotlinx/coroutines/flow/StateFlow;", "loadTransactions", "", "userId", "", "app_debug"})
public final class TransactionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.repository.TransactionRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> _transactions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> transactions = null;
    
    public TransactionViewModel(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.repository.TransactionRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.iie.st10320489.marene.data.entities.TransactionWithCategory>> getTransactions() {
        return null;
    }
    
    public final void loadTransactions(int userId) {
    }
}