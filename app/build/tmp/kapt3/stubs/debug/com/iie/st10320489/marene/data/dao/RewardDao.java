package com.iie.st10320489.marene.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\tH\'J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/iie/st10320489/marene/data/dao/RewardDao;", "", "deleteAllTableName", "", "deleteReward", "reward", "Lcom/iie/st10320489/marene/data/entities/Reward;", "(Lcom/iie/st10320489/marene/data/entities/Reward;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRewards", "Lkotlinx/coroutines/flow/Flow;", "", "getRewardById", "id", "", "insertReward", "updateReward", "app_debug"})
@androidx.room.Dao()
public abstract interface RewardDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertReward(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Reward reward, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Reward WHERE rewardID = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.iie.st10320489.marene.data.entities.Reward> getRewardById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM Reward")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.iie.st10320489.marene.data.entities.Reward>> getAllRewards();
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateReward(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Reward reward, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteReward(@org.jetbrains.annotations.NotNull()
    com.iie.st10320489.marene.data.entities.Reward reward, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM Reward")
    public abstract void deleteAllTableName();
}