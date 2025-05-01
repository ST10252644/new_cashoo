package com.iie.st10320489.marene.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/iie/st10320489/marene/viewmodel/SubCategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/iie/st10320489/marene/data/repository/SubCategoryRepository;", "(Lcom/iie/st10320489/marene/data/repository/SubCategoryRepository;)V", "all", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/iie/st10320489/marene/data/entities/SubCategory;", "getAll", "()Lkotlinx/coroutines/flow/Flow;", "insert", "Lkotlinx/coroutines/Job;", "subCategory", "app_debug"})
public final class SubCategoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.repository.SubCategoryRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.SubCategory>> all = null;
    
    public SubCategoryViewModel(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.repository.SubCategoryRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.SubCategory>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.SubCategory subCategory) {
        return null;
    }
}