package com.example.data;

import com.example.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: Dao.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00040\u0003H'J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u001d\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\fH§@¢\u0006\u0002\u0010\u0015J\u0016\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013J\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00040\u0003H'J\u0018\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020$H§@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0013¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/example/data/WhatsAppDao;", "", "getAllMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/WhatsAppMessage;", "insertMessage", "", "msg", "(Lcom/example/data/WhatsAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentMessagesBySender", "sender", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessageById", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessagesBySender", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllScheduledMessagesFlow", "Lcom/example/data/ScheduledMessage;", "insertScheduledMessage", "(Lcom/example/data/ScheduledMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingScheduledMessages", "currentTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingScheduledMessageForRecipient", "recipient", "markAsSent", "deleteScheduledMessage", "getAllTonesFlow", "Lcom/example/data/PersonalityTone;", "getToneById", "insertTone", "tone", "(Lcom/example/data/PersonalityTone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTone", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public interface WhatsAppDao {
    Object clearAllMessages(Continuation<? super Unit> continuation);

    Object deleteMessageById(int i, Continuation<? super Unit> continuation);

    Object deleteMessagesBySender(String str, Continuation<? super Unit> continuation);

    Object deleteScheduledMessage(int i, Continuation<? super Unit> continuation);

    Object deleteTone(int i, Continuation<? super Unit> continuation);

    Flow<List<WhatsAppMessage>> getAllMessagesFlow();

    Flow<List<ScheduledMessage>> getAllScheduledMessagesFlow();

    Flow<List<PersonalityTone>> getAllTonesFlow();

    Object getPendingScheduledMessageForRecipient(String str, Continuation<? super ScheduledMessage> continuation);

    Object getPendingScheduledMessages(long j, Continuation<? super List<ScheduledMessage>> continuation);

    Object getRecentMessagesBySender(String str, int i, Continuation<? super List<WhatsAppMessage>> continuation);

    Object getToneById(int i, Continuation<? super PersonalityTone> continuation);

    Object insertMessage(WhatsAppMessage whatsAppMessage, Continuation<? super Long> continuation);

    Object insertScheduledMessage(ScheduledMessage scheduledMessage, Continuation<? super Long> continuation);

    Object insertTone(PersonalityTone personalityTone, Continuation<? super Long> continuation);

    Object markAsSent(int i, Continuation<? super Unit> continuation);
}
