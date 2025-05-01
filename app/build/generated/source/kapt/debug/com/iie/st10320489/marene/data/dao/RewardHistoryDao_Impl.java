package com.iie.st10320489.marene.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.iie.st10320489.marene.data.entities.RewardHistory;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RewardHistoryDao_Impl implements RewardHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RewardHistory> __insertionAdapterOfRewardHistory;

  private final EntityDeletionOrUpdateAdapter<RewardHistory> __deletionAdapterOfRewardHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTableName;

  public RewardHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRewardHistory = new EntityInsertionAdapter<RewardHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `RewardHistory` (`historyId`,`userId`,`rewardId`,`dateRedeemed`,`amount`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RewardHistory entity) {
        statement.bindLong(1, entity.getHistoryId());
        statement.bindLong(2, entity.getUserId());
        statement.bindLong(3, entity.getRewardId());
        if (entity.getDateRedeemed() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDateRedeemed());
        }
        statement.bindDouble(5, entity.getAmount());
      }
    };
    this.__deletionAdapterOfRewardHistory = new EntityDeletionOrUpdateAdapter<RewardHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `RewardHistory` WHERE `historyId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RewardHistory entity) {
        statement.bindLong(1, entity.getHistoryId());
      }
    };
    this.__preparedStmtOfDeleteAllTableName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM RewardHistory";
        return _query;
      }
    };
  }

  @Override
  public Object insertHistory(final RewardHistory rewardHistory,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRewardHistory.insert(rewardHistory);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteHistory(final RewardHistory rewardHistory,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRewardHistory.handle(rewardHistory);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public void deleteAllTableName() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTableName.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAllTableName.release(_stmt);
    }
  }

  @Override
  public Flow<RewardHistory> getHistoryById(final int id) {
    final String _sql = "SELECT * FROM RewardHistory WHERE historyId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"RewardHistory"}, new Callable<RewardHistory>() {
      @Override
      @Nullable
      public RewardHistory call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHistoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "historyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfRewardId = CursorUtil.getColumnIndexOrThrow(_cursor, "rewardId");
          final int _cursorIndexOfDateRedeemed = CursorUtil.getColumnIndexOrThrow(_cursor, "dateRedeemed");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final RewardHistory _result;
          if (_cursor.moveToFirst()) {
            final int _tmpHistoryId;
            _tmpHistoryId = _cursor.getInt(_cursorIndexOfHistoryId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final int _tmpRewardId;
            _tmpRewardId = _cursor.getInt(_cursorIndexOfRewardId);
            final String _tmpDateRedeemed;
            if (_cursor.isNull(_cursorIndexOfDateRedeemed)) {
              _tmpDateRedeemed = null;
            } else {
              _tmpDateRedeemed = _cursor.getString(_cursorIndexOfDateRedeemed);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            _result = new RewardHistory(_tmpHistoryId,_tmpUserId,_tmpRewardId,_tmpDateRedeemed,_tmpAmount);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<RewardHistory>> getAllHistory() {
    final String _sql = "SELECT * FROM RewardHistory";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"RewardHistory"}, new Callable<List<RewardHistory>>() {
      @Override
      @NonNull
      public List<RewardHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHistoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "historyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfRewardId = CursorUtil.getColumnIndexOrThrow(_cursor, "rewardId");
          final int _cursorIndexOfDateRedeemed = CursorUtil.getColumnIndexOrThrow(_cursor, "dateRedeemed");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final List<RewardHistory> _result = new ArrayList<RewardHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RewardHistory _item;
            final int _tmpHistoryId;
            _tmpHistoryId = _cursor.getInt(_cursorIndexOfHistoryId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final int _tmpRewardId;
            _tmpRewardId = _cursor.getInt(_cursorIndexOfRewardId);
            final String _tmpDateRedeemed;
            if (_cursor.isNull(_cursorIndexOfDateRedeemed)) {
              _tmpDateRedeemed = null;
            } else {
              _tmpDateRedeemed = _cursor.getString(_cursorIndexOfDateRedeemed);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            _item = new RewardHistory(_tmpHistoryId,_tmpUserId,_tmpRewardId,_tmpDateRedeemed,_tmpAmount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
