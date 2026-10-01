package com.example.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WhatsAppDatabase.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/example/data/WhatsAppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "dao", "Lcom/example/data/WhatsAppDao;", "Companion", "WhatsAppDatabaseCallback", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public abstract class WhatsAppDatabase extends RoomDatabase {
    private static volatile WhatsAppDatabase INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public abstract WhatsAppDao dao();

    /* JADX INFO: compiled from: WhatsAppDatabase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/data/WhatsAppDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/example/data/WhatsAppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WhatsAppDatabase getDatabase(Context context, CoroutineScope scope) {
            WhatsAppDatabase whatsAppDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scope, "scope");
            WhatsAppDatabase whatsAppDatabase2 = WhatsAppDatabase.INSTANCE;
            if (whatsAppDatabase2 != null) {
                return whatsAppDatabase2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                whatsAppDatabase = (WhatsAppDatabase) Room.databaseBuilder(applicationContext, WhatsAppDatabase.class, "whatsapp_responder_database").addCallback(new WhatsAppDatabaseCallback(scope)).build();
                Companion companion = WhatsAppDatabase.INSTANCE;
                WhatsAppDatabase.INSTANCE = whatsAppDatabase;
            }
            return whatsAppDatabase;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: WhatsAppDatabase.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/example/data/WhatsAppDatabase$WhatsAppDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "populateDefaultTones", "dao", "Lcom/example/data/WhatsAppDao;", "(Lcom/example/data/WhatsAppDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
    static final class WhatsAppDatabaseCallback extends RoomDatabase.Callback {
        private final CoroutineScope scope;

        public WhatsAppDatabaseCallback(CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope;
        }

        public void onCreate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            super.onCreate(db);
            WhatsAppDatabase whatsAppDatabase = WhatsAppDatabase.INSTANCE;
            if (whatsAppDatabase != null) {
                BuildersKt.launch$default(this.scope, Dispatchers.getIO(), (CoroutineStart) null, new WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1(this, whatsAppDatabase, null), 2, (Object) null);
            }
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0093 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x00b3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00d7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object populateDefaultTones(WhatsAppDao dao, Continuation<? super Unit> continuation) {
            WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1 whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1;
            PersonalityTone personalityTone;
            PersonalityTone personalityTone2;
            PersonalityTone personalityTone3;
            if (continuation instanceof WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) {
                whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1 = (WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) continuation;
                if ((whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label & Integer.MIN_VALUE) != 0) {
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label -= Integer.MIN_VALUE;
                } else {
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1 = new WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1(this, continuation);
                }
            } else {
                whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1 = new WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1(this, continuation);
            }
            Object $result = whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PersonalityTone personalityTone4 = new PersonalityTone(0, "Friendly & Warm", "Enthusiastic, welcoming, and uses warm emojis. Perfect for friends and family.", "Reply in a very friendly, enthusiastic, and warm tone. Use emojis naturally (e.g. 😊, 🙌, ✨). Keep the message relatively short, polite, and inviting.", true, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 1;
                    if (dao.insertTone(personalityTone4, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone = new PersonalityTone(0, "Professional & Direct", "Polite, business-appropriate, and structured. Great for work contacts.", "Reply in a highly professional, polite, and respectful tone. Be clear, articulate, and direct. Use proper punctuation, capitalize appropriately, avoid slang, and do not use excessive emojis.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 2;
                    if (dao.insertTone(personalityTone, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone2 = new PersonalityTone(0, "Witty & Sarcastic", "Playful, light-hearted, with a touch of clever banter or polite sarcasm.", "Reply with dry wit and polite sarcasm. Be playful, witty, and clever. Keep it short, cheeky, and fun, but make sure it is not genuinely offensive. Use emojis like 😏 or 😜.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 3;
                    if (dao.insertTone(personalityTone2, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone3 = new PersonalityTone(0, "Chill & Casual", "Relaxed, brief, and laid-back. Good for close peers.", "Reply in a very casual, relaxed, and laid-back tone. Use lowercase letters or casual phrasing naturally (like 'hey', 'lol', 'cool'). Keep it extremely brief and simple.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = SpillingKt.nullOutSpilledVariable(dao);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 4;
                    if (dao.insertTone(personalityTone3, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case BuildConfig.VERSION_CODE /* 1 */:
                    dao = (WhatsAppDao) whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0;
                    ResultKt.throwOnFailure($result);
                    personalityTone = new PersonalityTone(0, "Professional & Direct", "Polite, business-appropriate, and structured. Great for work contacts.", "Reply in a highly professional, polite, and respectful tone. Be clear, articulate, and direct. Use proper punctuation, capitalize appropriately, avoid slang, and do not use excessive emojis.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 2;
                    if (dao.insertTone(personalityTone, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone2 = new PersonalityTone(0, "Witty & Sarcastic", "Playful, light-hearted, with a touch of clever banter or polite sarcasm.", "Reply with dry wit and polite sarcasm. Be playful, witty, and clever. Keep it short, cheeky, and fun, but make sure it is not genuinely offensive. Use emojis like 😏 or 😜.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 3;
                    if (dao.insertTone(personalityTone2, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone3 = new PersonalityTone(0, "Chill & Casual", "Relaxed, brief, and laid-back. Good for close peers.", "Reply in a very casual, relaxed, and laid-back tone. Use lowercase letters or casual phrasing naturally (like 'hey', 'lol', 'cool'). Keep it extremely brief and simple.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = SpillingKt.nullOutSpilledVariable(dao);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 4;
                    if (dao.insertTone(personalityTone3, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    dao = (WhatsAppDao) whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0;
                    ResultKt.throwOnFailure($result);
                    personalityTone2 = new PersonalityTone(0, "Witty & Sarcastic", "Playful, light-hearted, with a touch of clever banter or polite sarcasm.", "Reply with dry wit and polite sarcasm. Be playful, witty, and clever. Keep it short, cheeky, and fun, but make sure it is not genuinely offensive. Use emojis like 😏 or 😜.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = dao;
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 3;
                    if (dao.insertTone(personalityTone2, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    personalityTone3 = new PersonalityTone(0, "Chill & Casual", "Relaxed, brief, and laid-back. Good for close peers.", "Reply in a very casual, relaxed, and laid-back tone. Use lowercase letters or casual phrasing naturally (like 'hey', 'lol', 'cool'). Keep it extremely brief and simple.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = SpillingKt.nullOutSpilledVariable(dao);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 4;
                    if (dao.insertTone(personalityTone3, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 3:
                    dao = (WhatsAppDao) whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0;
                    ResultKt.throwOnFailure($result);
                    personalityTone3 = new PersonalityTone(0, "Chill & Casual", "Relaxed, brief, and laid-back. Good for close peers.", "Reply in a very casual, relaxed, and laid-back tone. Use lowercase letters or casual phrasing naturally (like 'hey', 'lol', 'cool'). Keep it extremely brief and simple.", false, 1, null);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.L$0 = SpillingKt.nullOutSpilledVariable(dao);
                    whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1.label = 4;
                    if (dao.insertTone(personalityTone3, whatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
