package com.iie.st10320489.marene.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.iie.st10320489.marene.data.dao.ActivityLogDao;
import com.iie.st10320489.marene.data.dao.ActivityLogDao_Impl;
import com.iie.st10320489.marene.data.dao.CategoryDao;
import com.iie.st10320489.marene.data.dao.CategoryDao_Impl;
import com.iie.st10320489.marene.data.dao.RewardDao;
import com.iie.st10320489.marene.data.dao.RewardDao_Impl;
import com.iie.st10320489.marene.data.dao.RewardHistoryDao;
import com.iie.st10320489.marene.data.dao.RewardHistoryDao_Impl;
import com.iie.st10320489.marene.data.dao.SubCategoryDao;
import com.iie.st10320489.marene.data.dao.SubCategoryDao_Impl;
import com.iie.st10320489.marene.data.dao.TransactionDao;
import com.iie.st10320489.marene.data.dao.TransactionDao_Impl;
import com.iie.st10320489.marene.data.dao.UserDao;
import com.iie.st10320489.marene.data.dao.UserDao_Impl;
import com.iie.st10320489.marene.data.dao.UserSettingsDao;
import com.iie.st10320489.marene.data.dao.UserSettingsDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile UserSettingsDao _userSettingsDao;

  private volatile TransactionDao _transactionDao;

  private volatile CategoryDao _categoryDao;

  private volatile SubCategoryDao _subCategoryDao;

  private volatile RewardDao _rewardDao;

  private volatile RewardHistoryDao _rewardHistoryDao;

  private volatile ActivityLogDao _activityLogDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`userId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `surname` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `cashoos` REAL NOT NULL, `isActive` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `UserSettings` (`userSettingsId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `payday` TEXT NOT NULL, `salary` REAL NOT NULL, `minGoal` REAL NOT NULL, `maxGoal` REAL NOT NULL, `color` TEXT NOT NULL, `chinchilla` TEXT NOT NULL, FOREIGN KEY(`userId`) REFERENCES `User`(`userId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Transaction` (`transactionId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `name` TEXT NOT NULL, `amount` REAL NOT NULL, `transactionMethod` TEXT NOT NULL, `location` TEXT, `dateTime` TEXT NOT NULL, `description` TEXT NOT NULL, `photo` TEXT NOT NULL, `categoryId` INTEGER NOT NULL, `subCategoryId` INTEGER, `expense` INTEGER NOT NULL, `recurring` INTEGER NOT NULL, FOREIGN KEY(`userId`) REFERENCES `User`(`userId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`categoryId`) REFERENCES `Category`(`categoryId`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`subCategoryId`) REFERENCES `SubCategory`(`subCategoryId`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`categoryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `name` TEXT NOT NULL, `icon` INTEGER NOT NULL, `colour` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `SubCategory` (`subCategoryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `userId` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Reward` (`rewardId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `amount` REAL NOT NULL, `type` TEXT NOT NULL, `code` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `RewardHistory` (`historyId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `rewardId` INTEGER NOT NULL, `dateRedeemed` TEXT NOT NULL, `amount` REAL NOT NULL, FOREIGN KEY(`userId`) REFERENCES `User`(`userId`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`rewardId`) REFERENCES `Reward`(`rewardId`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ActivityLog` (`logId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `action` TEXT NOT NULL, `timestamp` TEXT NOT NULL, `details` TEXT, FOREIGN KEY(`userId`) REFERENCES `User`(`userId`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '16d6d7cbcd7f132e6d571780b7f81a84')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `User`");
        db.execSQL("DROP TABLE IF EXISTS `UserSettings`");
        db.execSQL("DROP TABLE IF EXISTS `Transaction`");
        db.execSQL("DROP TABLE IF EXISTS `Category`");
        db.execSQL("DROP TABLE IF EXISTS `SubCategory`");
        db.execSQL("DROP TABLE IF EXISTS `Reward`");
        db.execSQL("DROP TABLE IF EXISTS `RewardHistory`");
        db.execSQL("DROP TABLE IF EXISTS `ActivityLog`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(7);
        _columnsUser.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("surname", new TableInfo.Column("surname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("cashoos", new TableInfo.Column("cashoos", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(db, "User");
        if (!_infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.iie.st10320489.marene.data.entities.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsUserSettings = new HashMap<String, TableInfo.Column>(8);
        _columnsUserSettings.put("userSettingsId", new TableInfo.Column("userSettingsId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("payday", new TableInfo.Column("payday", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("salary", new TableInfo.Column("salary", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("minGoal", new TableInfo.Column("minGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("maxGoal", new TableInfo.Column("maxGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("color", new TableInfo.Column("color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("chinchilla", new TableInfo.Column("chinchilla", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSettings = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUserSettings.add(new TableInfo.ForeignKey("User", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("userId")));
        final HashSet<TableInfo.Index> _indicesUserSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSettings = new TableInfo("UserSettings", _columnsUserSettings, _foreignKeysUserSettings, _indicesUserSettings);
        final TableInfo _existingUserSettings = TableInfo.read(db, "UserSettings");
        if (!_infoUserSettings.equals(_existingUserSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "UserSettings(com.iie.st10320489.marene.data.entities.UserSettings).\n"
                  + " Expected:\n" + _infoUserSettings + "\n"
                  + " Found:\n" + _existingUserSettings);
        }
        final HashMap<String, TableInfo.Column> _columnsTransaction = new HashMap<String, TableInfo.Column>(13);
        _columnsTransaction.put("transactionId", new TableInfo.Column("transactionId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("transactionMethod", new TableInfo.Column("transactionMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("dateTime", new TableInfo.Column("dateTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("photo", new TableInfo.Column("photo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("subCategoryId", new TableInfo.Column("subCategoryId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("expense", new TableInfo.Column("expense", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransaction.put("recurring", new TableInfo.Column("recurring", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransaction = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysTransaction.add(new TableInfo.ForeignKey("User", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("userId")));
        _foreignKeysTransaction.add(new TableInfo.ForeignKey("Category", "NO ACTION", "NO ACTION", Arrays.asList("categoryId"), Arrays.asList("categoryId")));
        _foreignKeysTransaction.add(new TableInfo.ForeignKey("SubCategory", "NO ACTION", "NO ACTION", Arrays.asList("subCategoryId"), Arrays.asList("subCategoryId")));
        final HashSet<TableInfo.Index> _indicesTransaction = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransaction = new TableInfo("Transaction", _columnsTransaction, _foreignKeysTransaction, _indicesTransaction);
        final TableInfo _existingTransaction = TableInfo.read(db, "Transaction");
        if (!_infoTransaction.equals(_existingTransaction)) {
          return new RoomOpenHelper.ValidationResult(false, "Transaction(com.iie.st10320489.marene.data.entities.Transaction).\n"
                  + " Expected:\n" + _infoTransaction + "\n"
                  + " Found:\n" + _existingTransaction);
        }
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(5);
        _columnsCategory.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("icon", new TableInfo.Column("icon", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("colour", new TableInfo.Column("colour", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("Category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(db, "Category");
        if (!_infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "Category(com.iie.st10320489.marene.data.entities.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsSubCategory = new HashMap<String, TableInfo.Column>(3);
        _columnsSubCategory.put("subCategoryId", new TableInfo.Column("subCategoryId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubCategory.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubCategory.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSubCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubCategory = new TableInfo("SubCategory", _columnsSubCategory, _foreignKeysSubCategory, _indicesSubCategory);
        final TableInfo _existingSubCategory = TableInfo.read(db, "SubCategory");
        if (!_infoSubCategory.equals(_existingSubCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "SubCategory(com.iie.st10320489.marene.data.entities.SubCategory).\n"
                  + " Expected:\n" + _infoSubCategory + "\n"
                  + " Found:\n" + _existingSubCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsReward = new HashMap<String, TableInfo.Column>(6);
        _columnsReward.put("rewardId", new TableInfo.Column("rewardId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReward.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReward.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReward.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReward.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReward.put("code", new TableInfo.Column("code", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReward = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReward = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReward = new TableInfo("Reward", _columnsReward, _foreignKeysReward, _indicesReward);
        final TableInfo _existingReward = TableInfo.read(db, "Reward");
        if (!_infoReward.equals(_existingReward)) {
          return new RoomOpenHelper.ValidationResult(false, "Reward(com.iie.st10320489.marene.data.entities.Reward).\n"
                  + " Expected:\n" + _infoReward + "\n"
                  + " Found:\n" + _existingReward);
        }
        final HashMap<String, TableInfo.Column> _columnsRewardHistory = new HashMap<String, TableInfo.Column>(5);
        _columnsRewardHistory.put("historyId", new TableInfo.Column("historyId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRewardHistory.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRewardHistory.put("rewardId", new TableInfo.Column("rewardId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRewardHistory.put("dateRedeemed", new TableInfo.Column("dateRedeemed", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRewardHistory.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRewardHistory = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysRewardHistory.add(new TableInfo.ForeignKey("User", "NO ACTION", "NO ACTION", Arrays.asList("userId"), Arrays.asList("userId")));
        _foreignKeysRewardHistory.add(new TableInfo.ForeignKey("Reward", "NO ACTION", "NO ACTION", Arrays.asList("rewardId"), Arrays.asList("rewardId")));
        final HashSet<TableInfo.Index> _indicesRewardHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRewardHistory = new TableInfo("RewardHistory", _columnsRewardHistory, _foreignKeysRewardHistory, _indicesRewardHistory);
        final TableInfo _existingRewardHistory = TableInfo.read(db, "RewardHistory");
        if (!_infoRewardHistory.equals(_existingRewardHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "RewardHistory(com.iie.st10320489.marene.data.entities.RewardHistory).\n"
                  + " Expected:\n" + _infoRewardHistory + "\n"
                  + " Found:\n" + _existingRewardHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsActivityLog = new HashMap<String, TableInfo.Column>(5);
        _columnsActivityLog.put("logId", new TableInfo.Column("logId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLog.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLog.put("action", new TableInfo.Column("action", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLog.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLog.put("details", new TableInfo.Column("details", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivityLog = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysActivityLog.add(new TableInfo.ForeignKey("User", "NO ACTION", "NO ACTION", Arrays.asList("userId"), Arrays.asList("userId")));
        final HashSet<TableInfo.Index> _indicesActivityLog = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivityLog = new TableInfo("ActivityLog", _columnsActivityLog, _foreignKeysActivityLog, _indicesActivityLog);
        final TableInfo _existingActivityLog = TableInfo.read(db, "ActivityLog");
        if (!_infoActivityLog.equals(_existingActivityLog)) {
          return new RoomOpenHelper.ValidationResult(false, "ActivityLog(com.iie.st10320489.marene.data.entities.ActivityLog).\n"
                  + " Expected:\n" + _infoActivityLog + "\n"
                  + " Found:\n" + _existingActivityLog);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "16d6d7cbcd7f132e6d571780b7f81a84", "428301aed8fa3c133c6a2a524d30c7fe");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","UserSettings","Transaction","Category","SubCategory","Reward","RewardHistory","ActivityLog");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `UserSettings`");
      _db.execSQL("DELETE FROM `Transaction`");
      _db.execSQL("DELETE FROM `Category`");
      _db.execSQL("DELETE FROM `SubCategory`");
      _db.execSQL("DELETE FROM `RewardHistory`");
      _db.execSQL("DELETE FROM `Reward`");
      _db.execSQL("DELETE FROM `ActivityLog`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserSettingsDao.class, UserSettingsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TransactionDao.class, TransactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SubCategoryDao.class, SubCategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RewardDao.class, RewardDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RewardHistoryDao.class, RewardHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ActivityLogDao.class, ActivityLogDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public UserSettingsDao userSettingsDao() {
    if (_userSettingsDao != null) {
      return _userSettingsDao;
    } else {
      synchronized(this) {
        if(_userSettingsDao == null) {
          _userSettingsDao = new UserSettingsDao_Impl(this);
        }
        return _userSettingsDao;
      }
    }
  }

  @Override
  public TransactionDao transactionDao() {
    if (_transactionDao != null) {
      return _transactionDao;
    } else {
      synchronized(this) {
        if(_transactionDao == null) {
          _transactionDao = new TransactionDao_Impl(this);
        }
        return _transactionDao;
      }
    }
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public SubCategoryDao subCategoryDao() {
    if (_subCategoryDao != null) {
      return _subCategoryDao;
    } else {
      synchronized(this) {
        if(_subCategoryDao == null) {
          _subCategoryDao = new SubCategoryDao_Impl(this);
        }
        return _subCategoryDao;
      }
    }
  }

  @Override
  public RewardDao rewardDao() {
    if (_rewardDao != null) {
      return _rewardDao;
    } else {
      synchronized(this) {
        if(_rewardDao == null) {
          _rewardDao = new RewardDao_Impl(this);
        }
        return _rewardDao;
      }
    }
  }

  @Override
  public RewardHistoryDao rewardHistoryDao() {
    if (_rewardHistoryDao != null) {
      return _rewardHistoryDao;
    } else {
      synchronized(this) {
        if(_rewardHistoryDao == null) {
          _rewardHistoryDao = new RewardHistoryDao_Impl(this);
        }
        return _rewardHistoryDao;
      }
    }
  }

  @Override
  public ActivityLogDao activityLogDao() {
    if (_activityLogDao != null) {
      return _activityLogDao;
    } else {
      synchronized(this) {
        if(_activityLogDao == null) {
          _activityLogDao = new ActivityLogDao_Impl(this);
        }
        return _activityLogDao;
      }
    }
  }
}
