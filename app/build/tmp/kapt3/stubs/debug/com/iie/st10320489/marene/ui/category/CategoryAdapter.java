package com.iie.st10320489.marene.ui.category;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/iie/st10320489/marene/ui/category/CategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iie/st10320489/marene/ui/category/CategoryAdapter$CategoryViewHolder;", "categories", "", "Lcom/iie/st10320489/marene/data/entities/Category;", "onCategoryClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateCategories", "newCategories", "CategoryViewHolder", "app_debug"})
public final class CategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.iie.st10320489.marene.ui.category.CategoryAdapter.CategoryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.iie.st10320489.marene.data.entities.Category> categories;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.iie.st10320489.marene.data.entities.Category, kotlin.Unit> onCategoryClick = null;
    
    public CategoryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.iie.st10320489.marene.data.entities.Category> categories, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.iie.st10320489.marene.data.entities.Category, kotlin.Unit> onCategoryClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.iie.st10320489.marene.ui.category.CategoryAdapter.CategoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.ui.category.CategoryAdapter.CategoryViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateCategories(@org.jetbrains.annotations.NotNull()
    java.util.List<com.iie.st10320489.marene.data.entities.Category> newCategories) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/iie/st10320489/marene/ui/category/CategoryAdapter$CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/iie/st10320489/marene/ui/category/CategoryAdapter;Landroid/view/View;)V", "categoryButton", "Landroid/widget/ImageButton;", "getCategoryButton", "()Landroid/widget/ImageButton;", "categoryTitle", "Landroid/widget/TextView;", "getCategoryTitle", "()Landroid/widget/TextView;", "app_debug"})
    public final class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageButton categoryButton = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView categoryTitle = null;
        
        public CategoryViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getCategoryButton() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getCategoryTitle() {
            return null;
        }
    }
}