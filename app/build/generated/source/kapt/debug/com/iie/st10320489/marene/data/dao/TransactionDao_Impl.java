package com.iie.st10320489.marene.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.iie.st10320489.marene.data.entities.Category;
import com.iie.st10320489.marene.data.entities.Transaction;
import com.iie.st10320489.marene.data.entities.TransactionWithCategory;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
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
public final class TransactionDao_Impl implements TransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Transaction> __insertionAdapterOfTransaction;

  private final EntityInsertionAdapter<Transaction> __insertionAdapterOfTransaction_1;

  private final EntityDeletionOrUpdateAdapter<Transaction> __deletionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter<Transaction> __updateAdapterOfTransaction;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTableName;

  public TransactionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaction = new EntityInsertionAdapter<Transaction>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Transaction` (`transactionId`,`userId`,`name`,`amount`,`transactionMethod`,`location`,`dateTime`,`description`,`photo`,`categoryId`,`subCategoryId`,`expense`,`recurring`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Transaction entity) {
        statement.bindLong(1, entity.getTransactionId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getTransactionMethod() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTransactionMethod());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        if (entity.getDateTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDateTime());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription());
        }
        if (entity.getPhoto() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPhoto());
        }
        statement.bindLong(10, entity.getCategoryId());
        if (entity.getSubCategoryId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getSubCategoryId());
        }
        final int _tmp = entity.getExpense() ? 1 : 0;
        statement.bindLong(12, _tmp);
        final int _tmp_1 = entity.getRecurring() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
      }
    };
    this.__insertionAdapterOfTransaction_1 = new EntityInsertionAdapter<Transaction>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Transaction` (`transactionId`,`userId`,`name`,`amount`,`transactionMethod`,`location`,`dateTime`,`description`,`photo`,`categoryId`,`subCategoryId`,`expense`,`recurring`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Transaction entity) {
        statement.bindLong(1, entity.getTransactionId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getTransactionMethod() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTransactionMethod());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        if (entity.getDateTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDateTime());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription());
        }
        if (entity.getPhoto() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPhoto());
        }
        statement.bindLong(10, entity.getCategoryId());
        if (entity.getSubCategoryId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getSubCategoryId());
        }
        final int _tmp = entity.getExpense() ? 1 : 0;
        statement.bindLong(12, _tmp);
        final int _tmp_1 = entity.getRecurring() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
      }
    };
    this.__deletionAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Transaction` WHERE `transactionId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Transaction entity) {
        statement.bindLong(1, entity.getTransactionId());
      }
    };
    this.__updateAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Transaction` SET `transactionId` = ?,`userId` = ?,`name` = ?,`amount` = ?,`transactionMethod` = ?,`location` = ?,`dateTime` = ?,`description` = ?,`photo` = ?,`categoryId` = ?,`subCategoryId` = ?,`expense` = ?,`recurring` = ? WHERE `transactionId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Transaction entity) {
        statement.bindLong(1, entity.getTransactionId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getTransactionMethod() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTransactionMethod());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        if (entity.getDateTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDateTime());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription());
        }
        if (entity.getPhoto() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPhoto());
        }
        statement.bindLong(10, entity.getCategoryId());
        if (entity.getSubCategoryId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getSubCategoryId());
        }
        final int _tmp = entity.getExpense() ? 1 : 0;
        statement.bindLong(12, _tmp);
        final int _tmp_1 = entity.getRecurring() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
        statement.bindLong(14, entity.getTransactionId());
      }
    };
    this.__preparedStmtOfDeleteAllTableName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM `Transaction`";
        return _query;
      }
    };
  }

  @Override
  public Object insertTransaction(final Transaction transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTransaction.insert(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final Transaction transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTransaction_1.insert(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTransaction(final Transaction transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTransaction.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTransaction(final Transaction transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTransaction.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
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
  public Object getTop5RecentTransactionsByUserId(final int userId,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ? ORDER BY dateTime DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsByUser(final int userId,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Transaction> getTransactionById(final int userId, final int transactionId) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ? AND transactionId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, transactionId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Transaction"}, new Callable<Transaction>() {
      @Override
      @Nullable
      public Transaction call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final Transaction _result;
          if (_cursor.moveToFirst()) {
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _result = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
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
  public Flow<List<Transaction>> getAllTransactions() {
    final String _sql = "SELECT * FROM `Transaction`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Transaction"}, new Callable<List<Transaction>>() {
      @Override
      @NonNull
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _item = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
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

  @Override
  public Object getAllTransactionsWithCategory(
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "SELECT * FROM `Transaction` ORDER BY dateTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsByUserId(final int userId,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ? ORDER BY dateTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Transaction>> getTransactionsByUserAndCategory(final int userId,
      final int categoryId) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ? AND categoryId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, categoryId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"Transaction"}, false, new Callable<List<Transaction>>() {
      @Override
      @Nullable
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _item = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
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

  @Override
  public Object getTransactionWithCategoryById(final int id,
      final Continuation<? super TransactionWithCategory> $completion) {
    final String _sql = "SELECT * FROM `Transaction` WHERE transactionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TransactionWithCategory>() {
      @Override
      @Nullable
      public TransactionWithCategory call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final TransactionWithCategory _result;
          if (_cursor.moveToFirst()) {
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _result = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsByUserIdAndCategoryName(final int userId, final String categoryName,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "\n"
            + "    SELECT `Transaction`.* FROM `Transaction`\n"
            + "    INNER JOIN Category ON `Transaction`.categoryId = Category.categoryID\n"
            + "    WHERE `Transaction`.userId = ?\n"
            + "    AND category.name = ?\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (categoryName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, categoryName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsByUserIdAndSubCategoryName(final int userId,
      final String subCategoryName,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "\n"
            + "    SELECT * FROM `Transaction` \n"
            + "    INNER JOIN SubCategory ON `Transaction`.subCategoryId = SubCategory.subCategoryId\n"
            + "    WHERE `Transaction`.userId = ? AND SubCategory.name = ?\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (subCategoryName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, subCategoryName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMonthlyIncome(final int userId, final String month, final String year,
      final Continuation<? super List<Transaction>> $completion) {
    final String _sql = "\n"
            + "    SELECT * FROM `Transaction` \n"
            + "    WHERE userId = ? \n"
            + "      AND strftime('%m', dateTime) = ? \n"
            + "      AND strftime('%Y', dateTime) = ? \n"
            + "      AND expense = 0\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    _argIndex = 3;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Transaction>>() {
      @Override
      @NonNull
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _item = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMonthlyExpenses(final int userId, final String month, final String year,
      final Continuation<? super List<Transaction>> $completion) {
    final String _sql = "\n"
            + "    SELECT * FROM `Transaction` \n"
            + "    WHERE userId = ? \n"
            + "      AND strftime('%m', dateTime) = ? \n"
            + "      AND strftime('%Y', dateTime) = ? \n"
            + "      AND expense = 1\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    _argIndex = 3;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Transaction>>() {
      @Override
      @NonNull
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _item = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTransactionsWithCategory(final int userId,
      final Continuation<? super List<TransactionWithCategory>> $completion) {
    final String _sql = "SELECT * FROM `Transaction` WHERE userId = ? AND expense = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TransactionWithCategory>>() {
      @Override
      @NonNull
      public List<TransactionWithCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final LongSparseArray<Category> _collectionCategory = new LongSparseArray<Category>();
          while (_cursor.moveToNext()) {
            final long _tmpKey;
            _tmpKey = _cursor.getLong(_cursorIndexOfCategoryId);
            _collectionCategory.put(_tmpKey, null);
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(_collectionCategory);
          final List<TransactionWithCategory> _result = new ArrayList<TransactionWithCategory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionWithCategory _item;
            final Transaction _tmpTransaction;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _tmpTransaction = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            final Category _tmpCategory;
            final long _tmpKey_1;
            _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryId);
            _tmpCategory = _collectionCategory.get(_tmpKey_1);
            _item = new TransactionWithCategory(_tmpTransaction,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMonthlySavings(final int userId, final String month, final String year,
      final Continuation<? super List<Transaction>> $completion) {
    final String _sql = "\n"
            + "    SELECT t.* FROM `Transaction` t\n"
            + "    INNER JOIN Category c ON t.categoryId = c.categoryID\n"
            + "    WHERE t.userId = ? \n"
            + "      AND strftime('%m', t.dateTime) = ? \n"
            + "      AND strftime('%Y', t.dateTime) = ? \n"
            + "      AND c.name = 'Savings'\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    _argIndex = 3;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Transaction>>() {
      @Override
      @NonNull
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransactionId = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTransactionMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "transactionMethod");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "photo");
          final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
          final int _cursorIndexOfSubCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategoryId");
          final int _cursorIndexOfExpense = CursorUtil.getColumnIndexOrThrow(_cursor, "expense");
          final int _cursorIndexOfRecurring = CursorUtil.getColumnIndexOrThrow(_cursor, "recurring");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Transaction _item;
            final int _tmpTransactionId;
            _tmpTransactionId = _cursor.getInt(_cursorIndexOfTransactionId);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpTransactionMethod;
            if (_cursor.isNull(_cursorIndexOfTransactionMethod)) {
              _tmpTransactionMethod = null;
            } else {
              _tmpTransactionMethod = _cursor.getString(_cursorIndexOfTransactionMethod);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPhoto;
            if (_cursor.isNull(_cursorIndexOfPhoto)) {
              _tmpPhoto = null;
            } else {
              _tmpPhoto = _cursor.getString(_cursorIndexOfPhoto);
            }
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final Integer _tmpSubCategoryId;
            if (_cursor.isNull(_cursorIndexOfSubCategoryId)) {
              _tmpSubCategoryId = null;
            } else {
              _tmpSubCategoryId = _cursor.getInt(_cursorIndexOfSubCategoryId);
            }
            final boolean _tmpExpense;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfExpense);
            _tmpExpense = _tmp != 0;
            final boolean _tmpRecurring;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfRecurring);
            _tmpRecurring = _tmp_1 != 0;
            _item = new Transaction(_tmpTransactionId,_tmpUserId,_tmpName,_tmpAmount,_tmpTransactionMethod,_tmpLocation,_tmpDateTime,_tmpDescription,_tmpPhoto,_tmpCategoryId,_tmpSubCategoryId,_tmpExpense,_tmpRecurring);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(
      @NonNull final LongSparseArray<Category> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchLongSparseArray(_map, false, (map) -> {
        __fetchRelationshipCategoryAscomIieSt10320489MareneDataEntitiesCategory(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `categoryId`,`userId`,`name`,`icon`,`colour` FROM `Category` WHERE `categoryId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "categoryId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfCategoryId = 0;
      final int _cursorIndexOfUserId = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfIcon = 3;
      final int _cursorIndexOfColour = 4;
      while (_cursor.moveToNext()) {
        final long _tmpKey;
        _tmpKey = _cursor.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final Category _item_1;
          final int _tmpCategoryId;
          _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
          final int _tmpUserId;
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
          final String _tmpName;
          if (_cursor.isNull(_cursorIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _cursor.getString(_cursorIndexOfName);
          }
          final int _tmpIcon;
          _tmpIcon = _cursor.getInt(_cursorIndexOfIcon);
          final int _tmpColour;
          _tmpColour = _cursor.getInt(_cursorIndexOfColour);
          _item_1 = new Category(_tmpCategoryId,_tmpUserId,_tmpName,_tmpIcon,_tmpColour);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
