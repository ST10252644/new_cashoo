package com.iie.st10320489.marene.ui.onboarding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/iie/st10320489/marene/ui/onboarding/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "categoryDao", "Lcom/iie/st10320489/marene/data/dao/CategoryDao;", "(Lcom/iie/st10320489/marene/data/dao/CategoryDao;)V", "mapCategoryResources", "Lkotlin/Pair;", "", "name", "", "saveSelectedCategories", "", "userId", "selectedCategoryNames", "", "app_debug"})
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.iie.st10320489.marene.data.dao.CategoryDao categoryDao = null;
    
    public OnboardingViewModel(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.dao.CategoryDao categoryDao) {
        super();
    }
    
    public final void saveSelectedCategories(int userId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> selectedCategoryNames) {
    }
    
    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> mapCategoryResources(java.lang.String name) {
        return null;
    }
}