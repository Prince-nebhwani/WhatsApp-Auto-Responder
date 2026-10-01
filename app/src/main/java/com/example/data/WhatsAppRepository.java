package com.example.data;

import com.example.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: Repository.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010'\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010!J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001fJ\u0018\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u00062"}, d2 = {"Lcom/example/data/WhatsAppRepository;", "", "dao", "Lcom/example/data/WhatsAppDao;", "<init>", "(Lcom/example/data/WhatsAppDao;)V", "allMessages", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/WhatsAppMessage;", "getAllMessages", "()Lkotlinx/coroutines/flow/Flow;", "allScheduledMessages", "Lcom/example/data/ScheduledMessage;", "getAllScheduledMessages", "allTones", "Lcom/example/data/PersonalityTone;", "getAllTones", "insertMessage", "", "msg", "(Lcom/example/data/WhatsAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentMessagesBySender", "sender", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessageById", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessagesBySender", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertScheduledMessage", "(Lcom/example/data/ScheduledMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingScheduledMessages", "currentTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingScheduledMessageForRecipient", "recipient", "markAsSent", "deleteScheduledMessage", "insertTone", "tone", "(Lcom/example/data/PersonalityTone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTone", "getToneById", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppRepository {
    public static final int $stable = 8;
    private final Flow<List<WhatsAppMessage>> allMessages;
    private final Flow<List<ScheduledMessage>> allScheduledMessages;
    private final Flow<List<PersonalityTone>> allTones;
    private final WhatsAppDao dao;

    public WhatsAppRepository(WhatsAppDao dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.dao = dao;
        this.allMessages = this.dao.getAllMessagesFlow();
        this.allScheduledMessages = this.dao.getAllScheduledMessagesFlow();
        this.allTones = this.dao.getAllTonesFlow();
    }

    public final Flow<List<WhatsAppMessage>> getAllMessages() {
        return this.allMessages;
    }

    public final Flow<List<ScheduledMessage>> getAllScheduledMessages() {
        return this.allScheduledMessages;
    }

    public final Flow<List<PersonalityTone>> getAllTones() {
        return this.allTones;
    }

    public final Object insertMessage(WhatsAppMessage msg, Continuation<? super Long> continuation) {
        return this.dao.insertMessage(msg, continuation);
    }

    public static /* synthetic */ Object getRecentMessagesBySender$default(WhatsAppRepository whatsAppRepository, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return whatsAppRepository.getRecentMessagesBySender(str, i, continuation);
    }

    public final Object getRecentMessagesBySender(String sender, int limit, Continuation<? super List<WhatsAppMessage>> continuation) {
        return this.dao.getRecentMessagesBySender(sender, limit, continuation);
    }

    public final Object deleteMessageById(int id, Continuation<? super Unit> continuation) {
        Object objDeleteMessageById = this.dao.deleteMessageById(id, continuation);
        return objDeleteMessageById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteMessageById : Unit.INSTANCE;
    }

    public final Object deleteMessagesBySender(String sender, Continuation<? super Unit> continuation) {
        Object objDeleteMessagesBySender = this.dao.deleteMessagesBySender(sender, continuation);
        return objDeleteMessagesBySender == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteMessagesBySender : Unit.INSTANCE;
    }

    public final Object clearAllMessages(Continuation<? super Unit> continuation) {
        Object objClearAllMessages = this.dao.clearAllMessages(continuation);
        return objClearAllMessages == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClearAllMessages : Unit.INSTANCE;
    }

    public final Object insertScheduledMessage(ScheduledMessage msg, Continuation<? super Long> continuation) {
        return this.dao.insertScheduledMessage(msg, continuation);
    }

    public final Object getPendingScheduledMessages(long currentTime, Continuation<? super List<ScheduledMessage>> continuation) {
        return this.dao.getPendingScheduledMessages(currentTime, continuation);
    }

    public final Object getPendingScheduledMessageForRecipient(String recipient, Continuation<? super ScheduledMessage> continuation) {
        return this.dao.getPendingScheduledMessageForRecipient(recipient, continuation);
    }

    public final Object markAsSent(int id, Continuation<? super Unit> continuation) {
        Object objMarkAsSent = this.dao.markAsSent(id, continuation);
        return objMarkAsSent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMarkAsSent : Unit.INSTANCE;
    }

    public final Object deleteScheduledMessage(int id, Continuation<? super Unit> continuation) {
        Object objDeleteScheduledMessage = this.dao.deleteScheduledMessage(id, continuation);
        return objDeleteScheduledMessage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteScheduledMessage : Unit.INSTANCE;
    }

    public final Object insertTone(PersonalityTone tone, Continuation<? super Long> continuation) {
        return this.dao.insertTone(tone, continuation);
    }

    public final Object deleteTone(int id, Continuation<? super Unit> continuation) {
        Object objDeleteTone = this.dao.deleteTone(id, continuation);
        return objDeleteTone == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTone : Unit.INSTANCE;
    }

    public final Object getToneById(int id, Continuation<? super PersonalityTone> continuation) {
        return this.dao.getToneById(id, continuation);
    }
}
