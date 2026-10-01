package com.example.data;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.example.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: WhatsAppDatabase_Impl.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/data/WhatsAppDatabase_Impl;", "Lcom/example/data/WhatsAppDatabase;", "<init>", "()V", "_whatsAppDao", "Lkotlin/Lazy;", "Lcom/example/data/WhatsAppDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "dao", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppDatabase_Impl extends WhatsAppDatabase {
    public static final int $stable = 8;
    private final Lazy<WhatsAppDao> _whatsAppDao = LazyKt.lazy(new Function0() { // from class: com.example.data.WhatsAppDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            return WhatsAppDatabase_Impl._whatsAppDao$lambda$0(this.f$0);
        }
    });

    static final WhatsAppDao_Impl _whatsAppDao$lambda$0(WhatsAppDatabase_Impl this$0) {
        return new WhatsAppDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m3createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: com.example.data.WhatsAppDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(1, "42c6fb51a34c4f77748f2079d271572e", "b46e3e1bfe43abb8be99fe7317b70844");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `whatsapp_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sender` TEXT NOT NULL, `messageText` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `isIncoming` INTEGER NOT NULL, `replyText` TEXT, `status` TEXT NOT NULL, `toneName` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `scheduled_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recipient` TEXT NOT NULL, `messageText` TEXT NOT NULL, `scheduledTime` INTEGER NOT NULL, `isSent` INTEGER NOT NULL, `type` TEXT NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `personality_tones` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `promptInstructions` TEXT NOT NULL, `isDefault` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '42c6fb51a34c4f77748f2079d271572e')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `whatsapp_messages`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `scheduled_messages`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `personality_tones`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                this.this$0.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                Map _columnsWhatsappMessages = new LinkedHashMap();
                _columnsWhatsappMessages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsWhatsappMessages.put("sender", new TableInfo.Column("sender", "TEXT", true, 0, (String) null, 1));
                _columnsWhatsappMessages.put("messageText", new TableInfo.Column("messageText", "TEXT", true, 0, (String) null, 1));
                _columnsWhatsappMessages.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                _columnsWhatsappMessages.put("isIncoming", new TableInfo.Column("isIncoming", "INTEGER", true, 0, (String) null, 1));
                _columnsWhatsappMessages.put("replyText", new TableInfo.Column("replyText", "TEXT", false, 0, (String) null, 1));
                _columnsWhatsappMessages.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsWhatsappMessages.put("toneName", new TableInfo.Column("toneName", "TEXT", false, 0, (String) null, 1));
                Set _foreignKeysWhatsappMessages = new LinkedHashSet();
                Set _indicesWhatsappMessages = new LinkedHashSet();
                TableInfo _infoWhatsappMessages = new TableInfo("whatsapp_messages", _columnsWhatsappMessages, _foreignKeysWhatsappMessages, _indicesWhatsappMessages);
                TableInfo _existingWhatsappMessages = TableInfo.Companion.read(connection, "whatsapp_messages");
                if (!_infoWhatsappMessages.equals(_existingWhatsappMessages)) {
                    return new RoomOpenDelegate.ValidationResult(false, "whatsapp_messages(com.example.data.WhatsAppMessage).\n Expected:\n" + _infoWhatsappMessages + "\n Found:\n" + _existingWhatsappMessages);
                }
                Map _columnsScheduledMessages = new LinkedHashMap();
                _columnsScheduledMessages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsScheduledMessages.put("recipient", new TableInfo.Column("recipient", "TEXT", true, 0, (String) null, 1));
                _columnsScheduledMessages.put("messageText", new TableInfo.Column("messageText", "TEXT", true, 0, (String) null, 1));
                _columnsScheduledMessages.put("scheduledTime", new TableInfo.Column("scheduledTime", "INTEGER", true, 0, (String) null, 1));
                _columnsScheduledMessages.put("isSent", new TableInfo.Column("isSent", "INTEGER", true, 0, (String) null, 1));
                _columnsScheduledMessages.put("type", new TableInfo.Column("type", "TEXT", true, 0, (String) null, 1));
                Set _foreignKeysScheduledMessages = new LinkedHashSet();
                Set _indicesScheduledMessages = new LinkedHashSet();
                TableInfo _infoScheduledMessages = new TableInfo("scheduled_messages", _columnsScheduledMessages, _foreignKeysScheduledMessages, _indicesScheduledMessages);
                TableInfo _existingScheduledMessages = TableInfo.Companion.read(connection, "scheduled_messages");
                if (!_infoScheduledMessages.equals(_existingScheduledMessages)) {
                    return new RoomOpenDelegate.ValidationResult(false, "scheduled_messages(com.example.data.ScheduledMessage).\n Expected:\n" + _infoScheduledMessages + "\n Found:\n" + _existingScheduledMessages);
                }
                Map _columnsPersonalityTones = new LinkedHashMap();
                _columnsPersonalityTones.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsPersonalityTones.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                _columnsPersonalityTones.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                _columnsPersonalityTones.put("promptInstructions", new TableInfo.Column("promptInstructions", "TEXT", true, 0, (String) null, 1));
                _columnsPersonalityTones.put("isDefault", new TableInfo.Column("isDefault", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysPersonalityTones = new LinkedHashSet();
                Set _indicesPersonalityTones = new LinkedHashSet();
                TableInfo _infoPersonalityTones = new TableInfo("personality_tones", _columnsPersonalityTones, _foreignKeysPersonalityTones, _indicesPersonalityTones);
                TableInfo _existingPersonalityTones = TableInfo.Companion.read(connection, "personality_tones");
                return !_infoPersonalityTones.equals(_existingPersonalityTones) ? new RoomOpenDelegate.ValidationResult(false, "personality_tones(com.example.data.PersonalityTone).\n Expected:\n" + _infoPersonalityTones + "\n Found:\n" + _existingPersonalityTones) : new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
        return _openDelegate;
    }

    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, new String[]{"whatsapp_messages", "scheduled_messages", "personality_tones"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"whatsapp_messages", "scheduled_messages", "personality_tones"});
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(WhatsAppDao.class), WhatsAppDao_Impl.INSTANCE.getRequiredConverters());
        return _typeConvertersMap;
    }

    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set _autoMigrationSpecsSet = new LinkedHashSet();
        return _autoMigrationSpecsSet;
    }

    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        List _autoMigrations = new ArrayList();
        return _autoMigrations;
    }

    @Override // com.example.data.WhatsAppDatabase
    public WhatsAppDao dao() {
        return (WhatsAppDao) this._whatsAppDao.getValue();
    }
}
