package com.example.data;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: WhatsAppDao_Impl.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00180\u0017H\u0016J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00180\u0017H\u0016J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u0006\u0010!\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00180\u0017H\u0016J\u0018\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010)J\u0016\u0010,\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010%J\u000e\u0010-\u001a\u00020+H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020+2\u0006\u0010(\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010)J\u0016\u00100\u001a\u00020+2\u0006\u0010(\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010)J\u0016\u00101\u001a\u00020+2\u0006\u0010(\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/example/data/WhatsAppDao_Impl;", "Lcom/example/data/WhatsAppDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfWhatsAppMessage", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/WhatsAppMessage;", "__insertAdapterOfScheduledMessage", "Lcom/example/data/ScheduledMessage;", "__insertAdapterOfPersonalityTone", "Lcom/example/data/PersonalityTone;", "insertMessage", "", "msg", "(Lcom/example/data/WhatsAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertScheduledMessage", "(Lcom/example/data/ScheduledMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTone", "tone", "(Lcom/example/data/PersonalityTone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getRecentMessagesBySender", "sender", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllScheduledMessagesFlow", "getPendingScheduledMessages", "currentTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingScheduledMessageForRecipient", "recipient", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTonesFlow", "getToneById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessageById", "", "deleteMessagesBySender", "clearAllMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsSent", "deleteScheduledMessage", "deleteTone", "Companion", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppDao_Impl implements WhatsAppDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<PersonalityTone> __insertAdapterOfPersonalityTone;
    private final EntityInsertAdapter<ScheduledMessage> __insertAdapterOfScheduledMessage;
    private final EntityInsertAdapter<WhatsAppMessage> __insertAdapterOfWhatsAppMessage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public WhatsAppDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfWhatsAppMessage = new EntityInsertAdapter<WhatsAppMessage>() { // from class: com.example.data.WhatsAppDao_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `whatsapp_messages` (`id`,`sender`,`messageText`,`timestamp`,`isIncoming`,`replyText`,`status`,`toneName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, WhatsAppMessage entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getSender());
                statement.bindText(3, entity.getMessageText());
                statement.bindLong(4, entity.getTimestamp());
                statement.bindLong(5, entity.isIncoming() ? 1L : 0L);
                String replyText = entity.getReplyText();
                if (replyText == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindText(6, replyText);
                }
                statement.bindText(7, entity.getStatus());
                String toneName = entity.getToneName();
                if (toneName == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindText(8, toneName);
                }
            }
        };
        this.__insertAdapterOfScheduledMessage = new EntityInsertAdapter<ScheduledMessage>() { // from class: com.example.data.WhatsAppDao_Impl.2
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `scheduled_messages` (`id`,`recipient`,`messageText`,`scheduledTime`,`isSent`,`type`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, ScheduledMessage entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getRecipient());
                statement.bindText(3, entity.getMessageText());
                statement.bindLong(4, entity.getScheduledTime());
                statement.bindLong(5, entity.isSent() ? 1L : 0L);
                statement.bindText(6, entity.getType());
            }
        };
        this.__insertAdapterOfPersonalityTone = new EntityInsertAdapter<PersonalityTone>() { // from class: com.example.data.WhatsAppDao_Impl.3
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `personality_tones` (`id`,`name`,`description`,`promptInstructions`,`isDefault`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, PersonalityTone entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getName());
                statement.bindText(3, entity.getDescription());
                statement.bindText(4, entity.getPromptInstructions());
                statement.bindLong(5, entity.isDefault() ? 1L : 0L);
            }
        };
    }

    @Override // com.example.data.WhatsAppDao
    public Object insertMessage(final WhatsAppMessage msg, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Long.valueOf(WhatsAppDao_Impl.insertMessage$lambda$0(this.f$0, msg, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    static final long insertMessage$lambda$0(WhatsAppDao_Impl this$0, WhatsAppMessage $msg, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfWhatsAppMessage.insertAndReturnId(_connection, $msg);
        return _result;
    }

    @Override // com.example.data.WhatsAppDao
    public Object insertScheduledMessage(final ScheduledMessage msg, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return Long.valueOf(WhatsAppDao_Impl.insertScheduledMessage$lambda$1(this.f$0, msg, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    static final long insertScheduledMessage$lambda$1(WhatsAppDao_Impl this$0, ScheduledMessage $msg, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfScheduledMessage.insertAndReturnId(_connection, $msg);
        return _result;
    }

    @Override // com.example.data.WhatsAppDao
    public Object insertTone(final PersonalityTone tone, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return Long.valueOf(WhatsAppDao_Impl.insertTone$lambda$2(this.f$0, tone, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    static final long insertTone$lambda$2(WhatsAppDao_Impl this$0, PersonalityTone $tone, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfPersonalityTone.insertAndReturnId(_connection, $tone);
        return _result;
    }

    @Override // com.example.data.WhatsAppDao
    public Flow<List<WhatsAppMessage>> getAllMessagesFlow() {
        final String _sql = "SELECT * FROM whatsapp_messages ORDER BY timestamp DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"whatsapp_messages"}, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getAllMessagesFlow$lambda$3(_sql, (SQLiteConnection) obj);
            }
        });
    }

    static final List getAllMessagesFlow$lambda$3(String $_sql, SQLiteConnection _connection) {
        String _tmpReplyText;
        String _tmpToneName;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _tmp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfSender = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sender");
            int _columnIndexOfMessageText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "messageText");
            int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
            int _columnIndexOfIsIncoming = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isIncoming");
            int _columnIndexOfReplyText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "replyText");
            int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
            int _columnIndexOfToneName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "toneName");
            List _result = new ArrayList();
            while (_stmt.step()) {
                int _tmpId = (int) _stmt.getLong(_tmp);
                String _tmpSender = _stmt.getText(_columnIndexOfSender);
                String _tmpMessageText = _stmt.getText(_columnIndexOfMessageText);
                long _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
                int _columnIndexOfId = _tmp;
                int _tmp2 = (int) _stmt.getLong(_columnIndexOfIsIncoming);
                boolean _tmpIsIncoming = _tmp2 != 0;
                if (_stmt.isNull(_columnIndexOfReplyText)) {
                    _tmpReplyText = null;
                } else {
                    String _tmpReplyText2 = _stmt.getText(_columnIndexOfReplyText);
                    _tmpReplyText = _tmpReplyText2;
                }
                String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                if (_stmt.isNull(_columnIndexOfToneName)) {
                    _tmpToneName = null;
                } else {
                    String _tmpToneName2 = _stmt.getText(_columnIndexOfToneName);
                    _tmpToneName = _tmpToneName2;
                }
                WhatsAppMessage _item = new WhatsAppMessage(_tmpId, _tmpSender, _tmpMessageText, _tmpTimestamp, _tmpIsIncoming, _tmpReplyText, _tmpStatus, _tmpToneName);
                _result.add(_item);
                _tmp = _columnIndexOfId;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object getRecentMessagesBySender(final String sender, final int limit, Continuation<? super List<WhatsAppMessage>> continuation) {
        final String _sql = "SELECT * FROM whatsapp_messages WHERE sender = ? ORDER BY timestamp DESC LIMIT ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getRecentMessagesBySender$lambda$4(_sql, sender, limit, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    static final List getRecentMessagesBySender$lambda$4(String $_sql, String $sender, int $limit, SQLiteConnection _connection) throws Throwable {
        String _tmpReplyText;
        String _tmpToneName;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $sender);
            int _tmp = 2;
            try {
                _stmt.bindLong(2, $limit);
                int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
                int _columnIndexOfSender = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sender");
                int _columnIndexOfMessageText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "messageText");
                int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
                int _columnIndexOfIsIncoming = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isIncoming");
                int _columnIndexOfReplyText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "replyText");
                int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
                int _columnIndexOfToneName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "toneName");
                List _result = new ArrayList();
                while (_stmt.step()) {
                    int _argIndex = _tmp;
                    int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                    String _tmpSender = _stmt.getText(_columnIndexOfSender);
                    String _tmpMessageText = _stmt.getText(_columnIndexOfMessageText);
                    long _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
                    int _tmp2 = (int) _stmt.getLong(_columnIndexOfIsIncoming);
                    boolean _tmpIsIncoming = _tmp2 != 0;
                    if (_stmt.isNull(_columnIndexOfReplyText)) {
                        _tmpReplyText = null;
                    } else {
                        String _tmpReplyText2 = _stmt.getText(_columnIndexOfReplyText);
                        _tmpReplyText = _tmpReplyText2;
                    }
                    String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                    if (_stmt.isNull(_columnIndexOfToneName)) {
                        _tmpToneName = null;
                    } else {
                        String _tmpToneName2 = _stmt.getText(_columnIndexOfToneName);
                        _tmpToneName = _tmpToneName2;
                    }
                    WhatsAppMessage _item = new WhatsAppMessage(_tmpId, _tmpSender, _tmpMessageText, _tmpTimestamp, _tmpIsIncoming, _tmpReplyText, _tmpStatus, _tmpToneName);
                    _result.add(_item);
                    _tmp = _argIndex;
                }
                _stmt.close();
                return _result;
            } catch (Throwable th) {
                th = th;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Flow<List<ScheduledMessage>> getAllScheduledMessagesFlow() {
        final String _sql = "SELECT * FROM scheduled_messages ORDER BY scheduledTime ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"scheduled_messages"}, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getAllScheduledMessagesFlow$lambda$5(_sql, (SQLiteConnection) obj);
            }
        });
    }

    static final List getAllScheduledMessagesFlow$lambda$5(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfRecipient = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "recipient");
            int _columnIndexOfMessageText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "messageText");
            int _columnIndexOfScheduledTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scheduledTime");
            int _columnIndexOfIsSent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isSent");
            int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
            List _result = new ArrayList();
            while (_stmt.step()) {
                int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                String _tmpRecipient = _stmt.getText(_columnIndexOfRecipient);
                String _tmpMessageText = _stmt.getText(_columnIndexOfMessageText);
                long _tmpScheduledTime = _stmt.getLong(_columnIndexOfScheduledTime);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsSent);
                boolean _tmpIsSent = _tmp != 0;
                String _tmpType = _stmt.getText(_columnIndexOfType);
                ScheduledMessage _item = new ScheduledMessage(_tmpId, _tmpRecipient, _tmpMessageText, _tmpScheduledTime, _tmpIsSent, _tmpType);
                _result.add(_item);
            }
            _stmt.close();
            return _result;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object getPendingScheduledMessages(final long currentTime, Continuation<? super List<ScheduledMessage>> continuation) {
        final String _sql = "SELECT * FROM scheduled_messages WHERE isSent = 0 AND scheduledTime <= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getPendingScheduledMessages$lambda$6(_sql, currentTime, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    static final List getPendingScheduledMessages$lambda$6(String $_sql, long $currentTime, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        int _tmp = 1;
        try {
            _stmt.bindLong(1, $currentTime);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfRecipient = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "recipient");
            int _columnIndexOfMessageText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "messageText");
            int _columnIndexOfScheduledTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scheduledTime");
            int _columnIndexOfIsSent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isSent");
            int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
            List _result = new ArrayList();
            while (_stmt.step()) {
                int _argIndex = _tmp;
                int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                String _tmpRecipient = _stmt.getText(_columnIndexOfRecipient);
                String _tmpMessageText = _stmt.getText(_columnIndexOfMessageText);
                long _tmpScheduledTime = _stmt.getLong(_columnIndexOfScheduledTime);
                int _tmp2 = (int) _stmt.getLong(_columnIndexOfIsSent);
                boolean _tmpIsSent = _tmp2 != 0;
                String _tmpType = _stmt.getText(_columnIndexOfType);
                ScheduledMessage _item = new ScheduledMessage(_tmpId, _tmpRecipient, _tmpMessageText, _tmpScheduledTime, _tmpIsSent, _tmpType);
                _result.add(_item);
                _tmp = _argIndex;
            }
            _stmt.close();
            return _result;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object getPendingScheduledMessageForRecipient(final String recipient, Continuation<? super ScheduledMessage> continuation) {
        final String _sql = "SELECT * FROM scheduled_messages WHERE isSent = 0 AND recipient = ? ORDER BY scheduledTime ASC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getPendingScheduledMessageForRecipient$lambda$7(_sql, recipient, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    static final ScheduledMessage getPendingScheduledMessageForRecipient$lambda$7(String $_sql, String $recipient, SQLiteConnection _connection) {
        ScheduledMessage _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $recipient);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfRecipient = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "recipient");
            int _columnIndexOfMessageText = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "messageText");
            int _columnIndexOfScheduledTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "scheduledTime");
            int _columnIndexOfIsSent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isSent");
            int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
            if (_stmt.step()) {
                int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                String _tmpRecipient = _stmt.getText(_columnIndexOfRecipient);
                String _tmpMessageText = _stmt.getText(_columnIndexOfMessageText);
                long _tmpScheduledTime = _stmt.getLong(_columnIndexOfScheduledTime);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsSent);
                boolean _tmpIsSent = _tmp != 0;
                String _tmpType = _stmt.getText(_columnIndexOfType);
                _result = new ScheduledMessage(_tmpId, _tmpRecipient, _tmpMessageText, _tmpScheduledTime, _tmpIsSent, _tmpType);
            } else {
                _result = null;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Flow<List<PersonalityTone>> getAllTonesFlow() {
        final String _sql = "SELECT * FROM personality_tones ORDER BY id ASC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"personality_tones"}, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getAllTonesFlow$lambda$8(_sql, (SQLiteConnection) obj);
            }
        });
    }

    static final List getAllTonesFlow$lambda$8(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
            int _columnIndexOfPromptInstructions = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "promptInstructions");
            int _columnIndexOfIsDefault = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isDefault");
            List _result = new ArrayList();
            while (_stmt.step()) {
                int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                String _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpDescription = _stmt.getText(_columnIndexOfDescription);
                String _tmpPromptInstructions = _stmt.getText(_columnIndexOfPromptInstructions);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsDefault);
                boolean _tmpIsDefault = _tmp != 0;
                PersonalityTone _item = new PersonalityTone(_tmpId, _tmpName, _tmpDescription, _tmpPromptInstructions, _tmpIsDefault);
                _result.add(_item);
            }
            _stmt.close();
            return _result;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object getToneById(final int id, Continuation<? super PersonalityTone> continuation) {
        final String _sql = "SELECT * FROM personality_tones WHERE id = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.getToneById$lambda$9(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    static final PersonalityTone getToneById$lambda$9(String $_sql, int $id, SQLiteConnection _connection) {
        PersonalityTone _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
            int _columnIndexOfPromptInstructions = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "promptInstructions");
            int _columnIndexOfIsDefault = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isDefault");
            if (_stmt.step()) {
                int _tmpId = (int) _stmt.getLong(_columnIndexOfId);
                String _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpDescription = _stmt.getText(_columnIndexOfDescription);
                String _tmpPromptInstructions = _stmt.getText(_columnIndexOfPromptInstructions);
                int _tmp = (int) _stmt.getLong(_columnIndexOfIsDefault);
                boolean _tmpIsDefault = _tmp != 0;
                _result = new PersonalityTone(_tmpId, _tmpName, _tmpDescription, _tmpPromptInstructions, _tmpIsDefault);
            } else {
                _result = null;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object deleteMessageById(final int id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM whatsapp_messages WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.deleteMessageById$lambda$10(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteMessageById$lambda$10(String $_sql, int $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object deleteMessagesBySender(final String sender, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM whatsapp_messages WHERE sender = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.deleteMessagesBySender$lambda$11(_sql, sender, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteMessagesBySender$lambda$11(String $_sql, String $sender, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $sender);
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object clearAllMessages(Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM whatsapp_messages";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.clearAllMessages$lambda$12(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit clearAllMessages$lambda$12(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object markAsSent(final int id, Continuation<? super Unit> continuation) {
        final String _sql = "UPDATE scheduled_messages SET isSent = 1 WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.markAsSent$lambda$13(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit markAsSent$lambda$13(String $_sql, int $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object deleteScheduledMessage(final int id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM scheduled_messages WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.deleteScheduledMessage$lambda$14(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteScheduledMessage$lambda$14(String $_sql, int $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.WhatsAppDao
    public Object deleteTone(final int id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM personality_tones WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.WhatsAppDao_Impl$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return WhatsAppDao_Impl.deleteTone$lambda$15(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteTone$lambda$15(String $_sql, int $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            _stmt.step();
            return Unit.INSTANCE;
        } finally {
            _stmt.close();
        }
    }

    /* JADX INFO: compiled from: WhatsAppDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/WhatsAppDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
