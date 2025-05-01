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
import com.iie.st10320489.marene.data.entities.ActivityLog;
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
public final class ActivityLogDao_Impl implements ActivityLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ActivityLog> __insertionAdapterOfActivityLog;

  private final EntityDeletionOrUpdateAdapter<ActivityLog> __deletionAdapterOfActivityLog;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTableName;

  public ActivityLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfActivityLog = new EntityInsertionAdapter<ActivityLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ActivityLog` (`logId`,`userId`,`action`,`timestamp`,`details`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ActivityLog entity) {
        statement.bindLong(1, entity.getLogId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getAction() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAction());
        }
        if (entity.getTimestamp() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTimestamp());
        }
        if (entity.getDetails() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDetails());
        }
      }
    };
    this.__deletionAdapterOfActivityLog = new EntityDeletionOrUpdateAdapter<ActivityLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `ActivityLog` WHERE `logId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ActivityLog entity) {
        statement.bindLong(1, entity.getLogId());
      }
    };
    this.__preparedStmtOfDeleteAllTableName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ActivityLog";
        return _query;
      }
    };
  }

  @Override
  public Object insertLog(final ActivityLog log, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfActivityLog.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteLog(final ActivityLog log, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfActivityLog.handle(log);
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
  public Flow<ActivityLog> getLogById(final int id) {
    final String _sql = "SELECT * FROM ActivityLog WHERE logID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ActivityLog"}, new Callable<ActivityLog>() {
      @Override
      @Nullable
      public ActivityLog call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "logId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final ActivityLog _result;
          if (_cursor.moveToFirst()) {
            final int _tmpLogId;
            _tmpLogId = _cursor.getInt(_cursorIndexOfLogId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpAction;
            if (_cursor.isNull(_cursorIndexOfAction)) {
              _tmpAction = null;
            } else {
              _tmpAction = _cursor.getString(_cursorIndexOfAction);
            }
            final String _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getString(_cursorIndexOfTimestamp);
            }
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            _result = new ActivityLog(_tmpLogId,_tmpUserId,_tmpAction,_tmpTimestamp,_tmpDetails);
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
  public Flow<List<ActivityLog>> getAllLogs() {
    final String _sql = "SELECT * FROM ActivityLog";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ActivityLog"}, new Callable<List<ActivityLog>>() {
      @Override
      @NonNull
      public List<ActivityLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "logId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
          final List<ActivityLog> _result = new ArrayList<ActivityLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ActivityLog _item;
            final int _tmpLogId;
            _tmpLogId = _cursor.getInt(_cursorIndexOfLogId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpAction;
            if (_cursor.isNull(_cursorIndexOfAction)) {
              _tmpAction = null;
            } else {
              _tmpAction = _cursor.getString(_cursorIndexOfAction);
            }
            final String _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getString(_cursorIndexOfTimestamp);
            }
            final String _tmpDetails;
            if (_cursor.isNull(_cursorIndexOfDetails)) {
              _tmpDetails = null;
            } else {
              _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
            }
            _item = new ActivityLog(_tmpLogId,_tmpUserId,_tmpAction,_tmpTimestamp,_tmpDetails);
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
