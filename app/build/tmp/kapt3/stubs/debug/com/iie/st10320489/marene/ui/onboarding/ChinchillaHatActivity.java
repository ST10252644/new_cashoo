package com.iie.st10320489.marene.ui.onboarding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/iie/st10320489/marene/ui/onboarding/ChinchillaHatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "chinchillaImage", "Landroid/widget/ImageView;", "db", "Lcom/iie/st10320489/marene/data/database/AppDatabase;", "selectedColor", "", "selectedHat", "userRepository", "Lcom/iie/st10320489/marene/data/repository/UserRepository;", "getDrawableResource", "", "color", "hat", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveChinchillaToDatabase", "chinchillaString", "app_debug"})
public final class ChinchillaHatActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.ImageView chinchillaImage;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedColor = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedHat = "";
    private com.iie.st10320489.marene.data.database.AppDatabase db;
    private com.iie.st10320489.marene.data.repository.UserRepository userRepository;
    
    public ChinchillaHatActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final int getDrawableResource(java.lang.String color, java.lang.String hat) {
        return 0;
    }
    
    private final void saveChinchillaToDatabase(java.lang.String chinchillaString) {
    }
}