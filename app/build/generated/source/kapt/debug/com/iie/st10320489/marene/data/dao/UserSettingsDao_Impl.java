package com.iie.st10320489.marene.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
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
import com.iie.st10320489.marene.data.entities.UserSettings;
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
public final class UserSettingsDao_Impl implements UserSettingsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserSettings> __insertionAdapterOfUserSettings;

  private final EntityDeletionOrUpdateAdapter<UserSettings> __deletionAdapterOfUserSettings;

  private final EntityDeletionOrUpdateAdapter<UserSettings> __updateAdapterOfUserSettings;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTableName;

  public UserSettingsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserSettings = new EntityInsertionAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `UserSettings` (`userSettingsId`,`userId`,`payday`,`salary`,`minGoal`,`maxGoal`,`color`,`chinchilla`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        statement.bindLong(1, entity.getUserSettingsId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getPayday() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPayday());
        }
        statement.bindDouble(4, entity.getSalary());
        statement.bindDouble(5, entity.getMinGoal());
        statement.bindDouble(6, entity.getMaxGoal());
        if (entity.getColor() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getColor());
        }
        if (entity.getChinchilla() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getChinchilla());
        }
      }
    };
    this.__deletionAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `UserSettings` WHERE `userSettingsId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        statement.bindLong(1, entity.getUserSettingsId());
      }
    };
    this.__updateAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `UserSettings` SET `userSettingsId` = ?,`userId` = ?,`payday` = ?,`salary` = ?,`minGoal` = ?,`maxGoal` = ?,`color` = ?,`chinchilla` = ? WHERE `userSettingsId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        statement.bindLong(1, entity.getUserSettingsId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getPayday() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPayday());
        }
        statement.bindDouble(4, entity.getSalary());
        statement.bindDouble(5, entity.getMinGoal());
        statement.bindDouble(6, entity.getMaxGoal());
        if (entity.getColor() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getColor());
        }
        if (entity.getChinchilla() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getChinchilla());
        }
        statement.bindLong(9, entity.getUserSettingsId());
      }
    };
    this.__preparedStmtOfDeleteAllTableName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM UserSettings";
        return _query;
      }
    };
  }

  @Override
  public Object insertUserSettings(final UserSettings userSettings,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserSettings.insert(userSettings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteSettings(final UserSettings userSettings,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserSettings.handle(userSettings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateUserSettings(final UserSettings userSettings,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserSettings.handle(userSettings);
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
  public Object getUserSettingsByUserId(final int userId,
      final Continuation<? super UserSettings> arg1) {
    final String _sql = "SELECT * FROM UserSettings WHERE userId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserSettingsId = CursorUtil.getColumnIndexOrThrow(_cursor, "userSettingsId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfPayday = CursorUtil.getColumnIndexOrThrow(_cursor, "payday");
          final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
          final int _cursorIndexOfMinGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "minGoal");
          final int _cursorIndexOfMaxGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "maxGoal");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfChinchilla = CursorUtil.getColumnIndexOrThrow(_cursor, "chinchilla");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final int _tmpUserSettingsId;
            _tmpUserSettingsId = _cursor.getInt(_cursorIndexOfUserSettingsId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpPayday;
            if (_cursor.isNull(_cursorIndexOfPayday)) {
              _tmpPayday = null;
            } else {
              _tmpPayday = _cursor.getString(_cursorIndexOfPayday);
            }
            final double _tmpSalary;
            _tmpSalary = _cursor.getDouble(_cursorIndexOfSalary);
            final double _tmpMinGoal;
            _tmpMinGoal = _cursor.getDouble(_cursorIndexOfMinGoal);
            final double _tmpMaxGoal;
            _tmpMaxGoal = _cursor.getDouble(_cursorIndexOfMaxGoal);
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final String _tmpChinchilla;
            if (_cursor.isNull(_cursorIndexOfChinchilla)) {
              _tmpChinchilla = null;
            } else {
              _tmpChinchilla = _cursor.getString(_cursorIndexOfChinchilla);
            }
            _result = new UserSettings(_tmpUserSettingsId,_tmpUserId,_tmpPayday,_tmpSalary,_tmpMinGoal,_tmpMaxGoal,_tmpColor,_tmpChinchilla);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<UserSettings>> getAllSettings() {
    final String _sql = "SELECT * FROM UserSettings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"UserSettings"}, new Callable<List<UserSettings>>() {
      @Override
      @NonNull
      public List<UserSettings> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserSettingsId = CursorUtil.getColumnIndexOrThrow(_cursor, "userSettingsId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfPayday = CursorUtil.getColumnIndexOrThrow(_cursor, "payday");
          final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
          final int _cursorIndexOfMinGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "minGoal");
          final int _cursorIndexOfMaxGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "maxGoal");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfChinchilla = CursorUtil.getColumnIndexOrThrow(_cursor, "chinchilla");
          final List<UserSettings> _result = new ArrayList<UserSettings>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserSettings _item;
            final int _tmpUserSettingsId;
            _tmpUserSettingsId = _cursor.getInt(_cursorIndexOfUserSettingsId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpPayday;
            if (_cursor.isNull(_cursorIndexOfPayday)) {
              _tmpPayday = null;
            } else {
              _tmpPayday = _cursor.getString(_cursorIndexOfPayday);
            }
            final double _tmpSalary;
            _tmpSalary = _cursor.getDouble(_cursorIndexOfSalary);
            final double _tmpMinGoal;
            _tmpMinGoal = _cursor.getDouble(_cursorIndexOfMinGoal);
            final double _tmpMaxGoal;
            _tmpMaxGoal = _cursor.getDouble(_cursorIndexOfMaxGoal);
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final String _tmpChinchilla;
            if (_cursor.isNull(_cursorIndexOfChinchilla)) {
              _tmpChinchilla = null;
            } else {
              _tmpChinchilla = _cursor.getString(_cursorIndexOfChinchilla);
            }
            _item = new UserSettings(_tmpUserSettingsId,_tmpUserId,_tmpPayday,_tmpSalary,_tmpMinGoal,_tmpMaxGoal,_tmpColor,_tmpChinchilla);
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
