package com.iie.st10320489.marene.ui.rewards;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/iie/st10320489/marene/ui/rewards/ClaimsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iie/st10320489/marene/ui/rewards/ClaimsAdapter$ClaimViewHolder;", "claimList", "", "Lcom/iie/st10320489/marene/ui/rewards/ClaimItem;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ClaimViewHolder", "app_debug"})
public final class ClaimsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.iie.st10320489.marene.ui.rewards.ClaimsAdapter.ClaimViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.iie.st10320489.marene.ui.rewards.ClaimItem> claimList = null;
    
    public ClaimsAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.iie.st10320489.marene.ui.rewards.ClaimItem> claimList) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.iie.st10320489.marene.ui.rewards.ClaimsAdapter.ClaimViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.ui.rewards.ClaimsAdapter.ClaimViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/iie/st10320489/marene/ui/rewards/ClaimsAdapter$ClaimViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/iie/st10320489/marene/ui/rewards/ClaimsAdapter;Landroid/view/View;)V", "claimPoints", "Landroid/widget/TextView;", "getClaimPoints", "()Landroid/widget/TextView;", "claimTitle", "getClaimTitle", "imageClaim", "Landroid/widget/ImageView;", "getImageClaim", "()Landroid/widget/ImageView;", "app_debug"})
    public final class ClaimViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imageClaim = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView claimTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView claimPoints = null;
        
        public ClaimViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageClaim() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getClaimTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getClaimPoints() {
            return null;
        }
    }
}