package com.example.service;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.BuildConfig;
import com.example.api.GeminiApi;
import com.example.data.PersonalityTone;
import com.example.data.ScheduledMessage;
import com.example.data.WhatsAppDatabase;
import com.example.data.WhatsAppMessage;
import com.example.data.WhatsAppRepository;
import com.example.ui.WhatsAppViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: WhatsAppNotificationListener.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/service/WhatsAppNotificationListener;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "repository", "Lcom/example/data/WhatsAppRepository;", "prefs", "Landroid/content/SharedPreferences;", "onCreate", "", "onDestroy", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "replyToNotification", "", "context", "Landroid/content/Context;", "replyText", "", "Companion", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppNotificationListener extends NotificationListenerService {
    public static final String KEY_ACTIVE_TONE_ID = "active_tone_id";
    public static final String KEY_AUTO_REPLY = "is_auto_reply_enabled";
    public static final String KEY_GROUP_REPLY = "is_group_reply_enabled";
    public static final String PREFS_NAME = "whatsapp_responder_prefs";
    private static final String TAG = "WhatsAppListener";
    private static String lastProcessedMessageId;
    private SharedPreferences prefs;
    private WhatsAppRepository repository;
    private final CompletableJob serviceJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.serviceJob));
    public static final int $stable = 8;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Notification Listener Service Created");
        WhatsAppDatabase.Companion companion = WhatsAppDatabase.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        WhatsAppDatabase db = companion.getDatabase(applicationContext, this.serviceScope);
        this.repository = new WhatsAppRepository(db.dao());
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Job.DefaultImpls.cancel$default(this.serviceJob, (CancellationException) null, 1, (Object) null);
        Log.d(TAG, "Notification Listener Service Destroyed");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        Notification notification;
        Bundle extras;
        CharSequence senderCharSeq;
        String string;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        super.onNotificationPosted(sbn);
        String packageName = sbn.getPackageName();
        if (!Intrinsics.areEqual(packageName, "com.whatsapp") || (notification = sbn.getNotification()) == null || (extras = notification.extras) == null || (senderCharSeq = extras.getCharSequence("android.title")) == null) {
            return;
        }
        String sender = senderCharSeq.toString();
        CharSequence textCharSeq = extras.getCharSequence("android.text");
        if (textCharSeq == null) {
            return;
        }
        String messageText = textCharSeq.toString();
        if (!Intrinsics.areEqual(sender, "WhatsApp")) {
            if (!StringsKt.contains$default(sender, "WhatsApp Web", false, 2, (Object) null) && !StringsKt.contains$default(sender, "incoming call", false, 2, (Object) null) && !StringsKt.contains$default(messageText, "new messages", false, 2, (Object) null)) {
                if (Intrinsics.areEqual(messageText, "Draft")) {
                    return;
                }
                boolean isGroup = extras.getBoolean("android.isGroupConversation", false) || StringsKt.contains$default(sender, "@g.us", false, 2, (Object) null) || extras.getCharSequence("android.conversationTitle") != null;
                if (StringsKt.equals(sender, "You", true) || StringsKt.equals(sender, "me", true) || StringsKt.startsWith(messageText, "You:", true) || StringsKt.contains(messageText, "\nYou:", true)) {
                    Log.d(TAG, "Notification is from myself or starts with 'You:'. Skipping reply.");
                    return;
                }
                NotificationCompat.MessagingStyle messagingStyle = NotificationCompat.MessagingStyle.extractMessagingStyleFromNotification(notification);
                List messages = messagingStyle != null ? messagingStyle.getMessages() : null;
                List list = messages;
                if (!(list == null || list.isEmpty())) {
                    NotificationCompat.MessagingStyle.Message lastMessage = (NotificationCompat.MessagingStyle.Message) CollectionsKt.last(messages);
                    CharSequence sender2 = lastMessage.getSender();
                    if (sender2 == null || (string = sender2.toString()) == null) {
                        string = "";
                    }
                    String senderName = string;
                    Log.d(TAG, "Last message in MessagingStyle: sender='" + senderName + "', text='" + ((Object) lastMessage.getText()) + "'");
                    if (StringsKt.equals(senderName, "You", true) || StringsKt.equals(senderName, "me", true) || StringsKt.isBlank(senderName)) {
                        Log.d(TAG, "Last message is from myself. Skipping reply.");
                        return;
                    }
                }
                String messageSignature = sbn.getId() + "_" + sbn.getPostTime() + "_" + messageText.hashCode();
                if (Intrinsics.areEqual(lastProcessedMessageId, messageSignature)) {
                    return;
                }
                lastProcessedMessageId = messageSignature;
                Log.d(TAG, "Intercepted WhatsApp notification: Sender='" + sender + "', Text='" + messageText + "', isGroup=" + isGroup);
                BuildersKt.launch$default(this.serviceScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(sender, messageText, sbn, isGroup, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.example.service.WhatsAppNotificationListener$onNotificationPosted$1, reason: invalid class name */
    /* JADX INFO: compiled from: WhatsAppNotificationListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.service.WhatsAppNotificationListener$onNotificationPosted$1", f = "WhatsAppNotificationListener.kt", i = {BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11}, l = {114, 134, 152, 158, 159, 171, 196, 203, 208, 218, 233, 244}, m = "invokeSuspend", n = {"recentMessages", "incomingMessage", "recentMessages", "incomingMessage", "isAutoReplyEnabled", "isGroupReplyEnabled", "recentMessages", "incomingMessage", "queuedMessage", "isAutoReplyEnabled", "isGroupReplyEnabled", "sentSuccessfully", "recentMessages", "incomingMessage", "queuedMessage", "isAutoReplyEnabled", "isGroupReplyEnabled", "sentSuccessfully", "recentMessages", "incomingMessage", "queuedMessage", "isAutoReplyEnabled", "isGroupReplyEnabled", "sentSuccessfully", "recentMessages", "incomingMessage", "queuedMessage", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "activeToneId", "recentMessages", "incomingMessage", "queuedMessage", "toneInstructions", "toneName", "modelOverride", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "recentMessages", "incomingMessage", "queuedMessage", "toneInstructions", "toneName", "modelOverride", "history", "contextList", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "recentMessages", "incomingMessage", "queuedMessage", "toneInstructions", "toneName", "modelOverride", "history", "contextList", "generatedReply", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "recentMessages", "incomingMessage", "queuedMessage", "toneInstructions", "toneName", "modelOverride", "history", "contextList", "generatedReply", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "sentSuccessfully", "recentMessages", "incomingMessage", "queuedMessage", "toneInstructions", "toneName", "modelOverride", "history", "contextList", "generatedReply", "isAutoReplyEnabled", "isGroupReplyEnabled", "useChatbotForReplies", "sentSuccessfully"}, s = {"L$0", "L$1", "L$0", "L$1", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "Z$0", "Z$1", "Z$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1", "Z$2", "Z$3"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isGroup;
        final /* synthetic */ String $messageText;
        final /* synthetic */ StatusBarNotification $sbn;
        final /* synthetic */ String $sender;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        boolean Z$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, StatusBarNotification statusBarNotification, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sender = str;
            this.$messageText = str2;
            this.$sbn = statusBarNotification;
            this.$isGroup = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppNotificationListener.this.new AnonymousClass1(this.$sender, this.$messageText, this.$sbn, this.$isGroup, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0448  */
        /* JADX WARN: Code duplicated, block: B:105:0x0451  */
        /* JADX WARN: Code duplicated, block: B:109:0x0460  */
        /* JADX WARN: Code duplicated, block: B:111:0x0494  */
        /* JADX WARN: Code duplicated, block: B:113:0x049e  */
        /* JADX WARN: Code duplicated, block: B:116:0x04b1  */
        /* JADX WARN: Code duplicated, block: B:119:0x04dd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:120:0x04de  */
        /* JADX WARN: Code duplicated, block: B:123:0x04e4  */
        /* JADX WARN: Code duplicated, block: B:125:0x04ea  */
        /* JADX WARN: Code duplicated, block: B:127:0x04ee  */
        /* JADX WARN: Code duplicated, block: B:129:0x04f4  */
        /* JADX WARN: Code duplicated, block: B:133:0x0504  */
        /* JADX WARN: Code duplicated, block: B:136:0x053b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:137:0x053c  */
        /* JADX WARN: Code duplicated, block: B:141:0x056e A[LOOP:0: B:139:0x0568->B:141:0x056e, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:144:0x0615 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:145:0x0616  */
        /* JADX WARN: Code duplicated, block: B:148:0x0633  */
        /* JADX WARN: Code duplicated, block: B:150:0x0651  */
        /* JADX WARN: Code duplicated, block: B:151:0x0655  */
        /* JADX WARN: Code duplicated, block: B:154:0x06c2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:155:0x06c3  */
        /* JADX WARN: Code duplicated, block: B:158:0x06d7  */
        /* JADX WARN: Code duplicated, block: B:160:0x06ee  */
        /* JADX WARN: Code duplicated, block: B:162:0x06f4  */
        /* JADX WARN: Code duplicated, block: B:163:0x06f8  */
        /* JADX WARN: Code duplicated, block: B:166:0x0761 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:167:0x0762  */
        /* JADX WARN: Code duplicated, block: B:169:0x0797  */
        /* JADX WARN: Code duplicated, block: B:171:0x079d  */
        /* JADX WARN: Code duplicated, block: B:172:0x07a1  */
        /* JADX WARN: Code duplicated, block: B:175:0x080e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:176:0x080f  */
        /* JADX WARN: Code duplicated, block: B:182:0x01e1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:183:0x0211 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:185:0x01cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:186:0x01cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:35:0x0247  */
        /* JADX WARN: Code duplicated, block: B:38:0x0263 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x026c  */
        /* JADX WARN: Code duplicated, block: B:44:0x0278  */
        /* JADX WARN: Code duplicated, block: B:46:0x0280  */
        /* JADX WARN: Code duplicated, block: B:48:0x0288  */
        /* JADX WARN: Code duplicated, block: B:51:0x0297 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:56:0x02a9  */
        /* JADX WARN: Code duplicated, block: B:59:0x02cb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:63:0x02d6  */
        /* JADX WARN: Code duplicated, block: B:65:0x0317  */
        /* JADX WARN: Code duplicated, block: B:67:0x031f  */
        /* JADX WARN: Code duplicated, block: B:70:0x0347 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:71:0x0348  */
        /* JADX WARN: Code duplicated, block: B:74:0x0355  */
        /* JADX WARN: Code duplicated, block: B:75:0x035a  */
        /* JADX WARN: Code duplicated, block: B:78:0x039e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:79:0x039f  */
        /* JADX WARN: Code duplicated, block: B:81:0x03af  */
        /* JADX WARN: Code duplicated, block: B:83:0x03bc  */
        /* JADX WARN: Code duplicated, block: B:84:0x03c1  */
        /* JADX WARN: Code duplicated, block: B:87:0x040a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:88:0x040b  */
        /* JADX WARN: Code duplicated, block: B:91:0x0414  */
        /* JADX WARN: Code duplicated, block: B:93:0x041c  */
        /* JADX WARN: Code duplicated, block: B:96:0x042f  */
        /* JADX WARN: Code duplicated, block: B:98:0x0435  */
        public final Object invokeSuspend(Object $result) {
            Object recentMessagesBySender;
            List<WhatsAppMessage> recentMessages;
            WhatsAppMessage incomingMessage;
            WhatsAppRepository whatsAppRepository;
            String cleanIncoming;
            String cleanSent;
            SharedPreferences sharedPreferences;
            boolean isAutoReplyEnabled;
            SharedPreferences sharedPreferences2;
            boolean isGroupReplyEnabled;
            WhatsAppRepository whatsAppRepository2;
            Object pendingScheduledMessageForRecipient;
            boolean isAutoReplyEnabled2;
            boolean isGroupReplyEnabled2;
            WhatsAppMessage incomingMessage2;
            List recentMessages2;
            ScheduledMessage queuedMessage;
            SharedPreferences sharedPreferences3;
            boolean useChatbotForReplies;
            WhatsAppNotificationListener whatsAppNotificationListener;
            SharedPreferences sharedPreferences4;
            WhatsAppRepository whatsAppRepository3;
            Object toneById;
            SharedPreferences sharedPreferences5;
            String toneInstructions;
            SharedPreferences sharedPreferences6;
            String toneName;
            boolean useChatbotForReplies2;
            boolean isGroupReplyEnabled3;
            boolean isAutoReplyEnabled3;
            String modelOverride;
            boolean isGroupReplyEnabled4;
            WhatsAppRepository whatsAppRepository4;
            WhatsAppRepository whatsAppRepository5;
            WhatsAppRepository whatsAppRepository6;
            boolean isGroupReplyEnabled5;
            boolean isAutoReplyEnabled4;
            ScheduledMessage queuedMessage2;
            WhatsAppMessage incomingMessage3;
            List recentMessages3;
            WhatsAppRepository whatsAppRepository7;
            WhatsAppRepository whatsAppRepository8;
            WhatsAppRepository whatsAppRepository9;
            ScheduledMessage queuedMessage3;
            WhatsAppMessage incomingMessage4;
            Object recentMessagesBySender2;
            String modelOverride2;
            String modelOverride3;
            List recentMessages4;
            ScheduledMessage queuedMessage4;
            WhatsAppMessage incomingMessage5;
            String toneInstructions2;
            PersonalityTone tone;
            String toneInstructions3;
            List history;
            List list;
            Collection arrayList;
            Iterable<WhatsAppMessage> iterable;
            ScheduledMessage queuedMessage5;
            List<Pair<String, Boolean>> list2;
            Object objGenerateReply;
            String toneName2;
            List history2;
            String toneInstructions4;
            String modelOverride4;
            ScheduledMessage queuedMessage6;
            String generatedReply;
            List history3;
            String toneInstructions5;
            ScheduledMessage queuedMessage7;
            WhatsAppRepository whatsAppRepository10;
            boolean sentSuccessfully;
            WhatsAppNotificationListener whatsAppNotificationListener2;
            WhatsAppRepository whatsAppRepository11;
            boolean isAutoReplyEnabled5;
            String modelOverride5;
            String toneInstructions6;
            ScheduledMessage queuedMessage8;
            List history4;
            List<Pair<String, Boolean>> list3;
            String generatedReply2;
            String toneName3;
            WhatsAppRepository whatsAppRepository12;
            boolean sentSuccessfully2;
            String generatedReply3;
            WhatsAppRepository whatsAppRepository13;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String toneInstructions7 = "repository";
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    WhatsAppRepository whatsAppRepository14 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository14 = null;
                    }
                    this.label = 1;
                    recentMessagesBySender = whatsAppRepository14.getRecentMessagesBySender(this.$sender, 2, (Continuation) this);
                    if (recentMessagesBySender == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    recentMessages = (List) recentMessagesBySender;
                    for (WhatsAppMessage msg : recentMessages) {
                        if (!msg.isIncoming()) {
                            cleanIncoming = StringsKt.trim(StringsKt.removePrefix(StringsKt.removePrefix(this.$messageText, "You:"), "you:")).toString();
                            cleanSent = StringsKt.trim(msg.getMessageText()).toString();
                            if (StringsKt.equals(cleanIncoming, cleanSent, true)) {
                                Log.d(WhatsAppNotificationListener.TAG, "Incoming text matches our recently sent message. Skipping to avoid infinite loop.");
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    incomingMessage = new WhatsAppMessage(0, this.$sender, this.$messageText, this.$sbn.getPostTime(), true, null, "RECEIVED", null, 161, null);
                    whatsAppRepository = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage);
                    this.label = 2;
                    if (whatsAppRepository.insertMessage(incomingMessage, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sharedPreferences = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences = null;
                    }
                    isAutoReplyEnabled = sharedPreferences.getBoolean(WhatsAppNotificationListener.KEY_AUTO_REPLY, true);
                    if (!isAutoReplyEnabled) {
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply is disabled. Skipping reply.");
                        return Unit.INSTANCE;
                    }
                    sharedPreferences2 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences2 = null;
                    }
                    isGroupReplyEnabled = sharedPreferences2.getBoolean(WhatsAppNotificationListener.KEY_GROUP_REPLY, false);
                    if (!this.$isGroup && !isGroupReplyEnabled) {
                        Log.d(WhatsAppNotificationListener.TAG, "Message is from group, but group replies are disabled. Skipping.");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository2 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository2 = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage);
                    this.Z$0 = isAutoReplyEnabled;
                    this.Z$1 = isGroupReplyEnabled;
                    this.label = 3;
                    pendingScheduledMessageForRecipient = whatsAppRepository2.getPendingScheduledMessageForRecipient(this.$sender, (Continuation) this);
                    if (pendingScheduledMessageForRecipient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled2 = isAutoReplyEnabled;
                    isGroupReplyEnabled2 = isGroupReplyEnabled;
                    incomingMessage2 = incomingMessage;
                    recentMessages2 = recentMessages;
                    queuedMessage = (ScheduledMessage) pendingScheduledMessageForRecipient;
                    if (queuedMessage != null) {
                        Log.d(WhatsAppNotificationListener.TAG, "Found scheduled message queued for " + this.$sender + ": '" + queuedMessage.getMessageText() + "'");
                        WhatsAppNotificationListener whatsAppNotificationListener3 = WhatsAppNotificationListener.this;
                        Context applicationContext = WhatsAppNotificationListener.this.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        isGroupReplyEnabled4 = whatsAppNotificationListener3.replyToNotification(applicationContext, this.$sbn, queuedMessage.getMessageText());
                        if (isGroupReplyEnabled4) {
                            whatsAppRepository6 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository6 = null;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = queuedMessage;
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 4;
                            if (whatsAppRepository6.markAsSent(queuedMessage.getId(), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isGroupReplyEnabled5 = isGroupReplyEnabled2;
                            isAutoReplyEnabled4 = isAutoReplyEnabled2;
                            queuedMessage2 = queuedMessage;
                            incomingMessage3 = incomingMessage2;
                            recentMessages3 = recentMessages2;
                            whatsAppRepository7 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository8 = null;
                            } else {
                                whatsAppRepository8 = whatsAppRepository7;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages3);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage2);
                            this.Z$0 = isAutoReplyEnabled4;
                            this.Z$1 = isGroupReplyEnabled5;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 5;
                            if (whatsAppRepository8.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage2.getMessageText(), 0L, false, null, "SENT", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                        } else {
                            Log.e(WhatsAppNotificationListener.TAG, "Failed to reply using scheduled message notification actions.");
                            whatsAppRepository4 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository5 = null;
                            } else {
                                whatsAppRepository5 = whatsAppRepository4;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 6;
                            if (whatsAppRepository5.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage.getMessageText(), 0L, false, null, "FAILED", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    sharedPreferences3 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences3 = null;
                    }
                    useChatbotForReplies = sharedPreferences3.getBoolean(WhatsAppViewModel.KEY_USE_CHATBOT_FOR_REPLIES, true);
                    whatsAppNotificationListener = WhatsAppNotificationListener.this;
                    if (useChatbotForReplies) {
                        sharedPreferences5 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences5 = null;
                        }
                        String string = sharedPreferences5.getString(WhatsAppViewModel.KEY_CHATBOT_INSTRUCTION, "You are a helpful, extremely fast AI assistant.");
                        toneInstructions = string != null ? string : "You are a helpful, extremely fast AI assistant.";
                        sharedPreferences6 = WhatsAppNotificationListener.this.prefs;
                        if (sharedPreferences6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences6 = null;
                        }
                        String string2 = sharedPreferences6.getString(WhatsAppViewModel.KEY_CHATBOT_MODEL, "gemini-3.1-flash-lite-preview");
                        String modelOverride6 = string2 != null ? string2 : "gemini-3.1-flash-lite-preview";
                        toneName = "Chatbot Profile (" + StringsKt.replace$default(modelOverride6, "gemini-", "", false, 4, (Object) null) + ")";
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        toneInstructions7 = "repository";
                        modelOverride = modelOverride6;
                    } else {
                        sharedPreferences4 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences4 = null;
                        }
                        int activeToneId = sharedPreferences4.getInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, 1);
                        whatsAppRepository3 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("repository");
                            whatsAppRepository3 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                        this.Z$0 = isAutoReplyEnabled2;
                        this.Z$1 = isGroupReplyEnabled2;
                        this.Z$2 = useChatbotForReplies;
                        this.I$0 = activeToneId;
                        this.label = 7;
                        toneById = whatsAppRepository3.getToneById(activeToneId, (Continuation) this);
                        if (toneById == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tone = (PersonalityTone) toneById;
                        if (tone != null || (toneInstructions3 = tone.getPromptInstructions()) == null) {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        }
                        if (tone != null || (toneName = tone.getName()) == null) {
                            toneName = "Friendly";
                        }
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        modelOverride = null;
                        toneInstructions = toneInstructions3;
                    }
                    whatsAppRepository9 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        whatsAppRepository9 = null;
                    }
                    queuedMessage3 = queuedMessage;
                    incomingMessage4 = incomingMessage2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage3);
                    this.L$3 = toneInstructions;
                    this.L$4 = toneName;
                    this.L$5 = modelOverride;
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 8;
                    recentMessagesBySender2 = whatsAppRepository9.getRecentMessagesBySender(this.$sender, 10, (Continuation) this);
                    if (recentMessagesBySender2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelOverride2 = modelOverride;
                    modelOverride3 = toneName;
                    recentMessages4 = recentMessages2;
                    queuedMessage4 = queuedMessage3;
                    incomingMessage5 = incomingMessage4;
                    toneInstructions2 = toneInstructions;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    for (WhatsAppMessage whatsAppMessage : iterable) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener4 = WhatsAppNotificationListener.this;
                    Context applicationContext2 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener4.replyToNotification(applicationContext2, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    recentMessagesBySender = $result;
                    recentMessages = (List) recentMessagesBySender;
                    while (r2.hasNext()) {
                        if (!msg.isIncoming()) {
                            cleanIncoming = StringsKt.trim(StringsKt.removePrefix(StringsKt.removePrefix(this.$messageText, "You:"), "you:")).toString();
                            cleanSent = StringsKt.trim(msg.getMessageText()).toString();
                            if (StringsKt.equals(cleanIncoming, cleanSent, true)) {
                                Log.d(WhatsAppNotificationListener.TAG, "Incoming text matches our recently sent message. Skipping to avoid infinite loop.");
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    incomingMessage = new WhatsAppMessage(0, this.$sender, this.$messageText, this.$sbn.getPostTime(), true, null, "RECEIVED", null, 161, null);
                    whatsAppRepository = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage);
                    this.label = 2;
                    if (whatsAppRepository.insertMessage(incomingMessage, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sharedPreferences = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences = null;
                    }
                    isAutoReplyEnabled = sharedPreferences.getBoolean(WhatsAppNotificationListener.KEY_AUTO_REPLY, true);
                    if (!isAutoReplyEnabled) {
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply is disabled. Skipping reply.");
                        return Unit.INSTANCE;
                    }
                    sharedPreferences2 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences2 = null;
                    }
                    isGroupReplyEnabled = sharedPreferences2.getBoolean(WhatsAppNotificationListener.KEY_GROUP_REPLY, false);
                    if (!this.$isGroup) {
                    }
                    whatsAppRepository2 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository2 = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage);
                    this.Z$0 = isAutoReplyEnabled;
                    this.Z$1 = isGroupReplyEnabled;
                    this.label = 3;
                    pendingScheduledMessageForRecipient = whatsAppRepository2.getPendingScheduledMessageForRecipient(this.$sender, (Continuation) this);
                    if (pendingScheduledMessageForRecipient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled2 = isAutoReplyEnabled;
                    isGroupReplyEnabled2 = isGroupReplyEnabled;
                    incomingMessage2 = incomingMessage;
                    recentMessages2 = recentMessages;
                    queuedMessage = (ScheduledMessage) pendingScheduledMessageForRecipient;
                    if (queuedMessage != null) {
                        Log.d(WhatsAppNotificationListener.TAG, "Found scheduled message queued for " + this.$sender + ": '" + queuedMessage.getMessageText() + "'");
                        WhatsAppNotificationListener whatsAppNotificationListener5 = WhatsAppNotificationListener.this;
                        Context applicationContext3 = WhatsAppNotificationListener.this.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                        isGroupReplyEnabled4 = whatsAppNotificationListener5.replyToNotification(applicationContext3, this.$sbn, queuedMessage.getMessageText());
                        if (isGroupReplyEnabled4) {
                            whatsAppRepository6 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository6 = null;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = queuedMessage;
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 4;
                            if (whatsAppRepository6.markAsSent(queuedMessage.getId(), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isGroupReplyEnabled5 = isGroupReplyEnabled2;
                            isAutoReplyEnabled4 = isAutoReplyEnabled2;
                            queuedMessage2 = queuedMessage;
                            incomingMessage3 = incomingMessage2;
                            recentMessages3 = recentMessages2;
                            whatsAppRepository7 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository8 = null;
                            } else {
                                whatsAppRepository8 = whatsAppRepository7;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages3);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage2);
                            this.Z$0 = isAutoReplyEnabled4;
                            this.Z$1 = isGroupReplyEnabled5;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 5;
                            if (whatsAppRepository8.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage2.getMessageText(), 0L, false, null, "SENT", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                        } else {
                            Log.e(WhatsAppNotificationListener.TAG, "Failed to reply using scheduled message notification actions.");
                            whatsAppRepository4 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository5 = null;
                            } else {
                                whatsAppRepository5 = whatsAppRepository4;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 6;
                            if (whatsAppRepository5.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage.getMessageText(), 0L, false, null, "FAILED", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    sharedPreferences3 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences3 = null;
                    }
                    useChatbotForReplies = sharedPreferences3.getBoolean(WhatsAppViewModel.KEY_USE_CHATBOT_FOR_REPLIES, true);
                    whatsAppNotificationListener = WhatsAppNotificationListener.this;
                    if (useChatbotForReplies) {
                        sharedPreferences5 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences5 = null;
                        }
                        String string3 = sharedPreferences5.getString(WhatsAppViewModel.KEY_CHATBOT_INSTRUCTION, "You are a helpful, extremely fast AI assistant.");
                        if (string3 != null) {
                        }
                        sharedPreferences6 = WhatsAppNotificationListener.this.prefs;
                        if (sharedPreferences6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences6 = null;
                        }
                        String string4 = sharedPreferences6.getString(WhatsAppViewModel.KEY_CHATBOT_MODEL, "gemini-3.1-flash-lite-preview");
                        String modelOverride7 = string4 != null ? string4 : "gemini-3.1-flash-lite-preview";
                        toneName = "Chatbot Profile (" + StringsKt.replace$default(modelOverride7, "gemini-", "", false, 4, (Object) null) + ")";
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        toneInstructions7 = "repository";
                        modelOverride = modelOverride7;
                    } else {
                        sharedPreferences4 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences4 = null;
                        }
                        int activeToneId2 = sharedPreferences4.getInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, 1);
                        whatsAppRepository3 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("repository");
                            whatsAppRepository3 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                        this.Z$0 = isAutoReplyEnabled2;
                        this.Z$1 = isGroupReplyEnabled2;
                        this.Z$2 = useChatbotForReplies;
                        this.I$0 = activeToneId2;
                        this.label = 7;
                        toneById = whatsAppRepository3.getToneById(activeToneId2, (Continuation) this);
                        if (toneById == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tone = (PersonalityTone) toneById;
                        if (tone != null) {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        } else {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        }
                        if (tone != null) {
                            toneName = "Friendly";
                        } else {
                            toneName = "Friendly";
                        }
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        modelOverride = null;
                        toneInstructions = toneInstructions3;
                    }
                    whatsAppRepository9 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        whatsAppRepository9 = null;
                    }
                    queuedMessage3 = queuedMessage;
                    incomingMessage4 = incomingMessage2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage3);
                    this.L$3 = toneInstructions;
                    this.L$4 = toneName;
                    this.L$5 = modelOverride;
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 8;
                    recentMessagesBySender2 = whatsAppRepository9.getRecentMessagesBySender(this.$sender, 10, (Continuation) this);
                    if (recentMessagesBySender2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelOverride2 = modelOverride;
                    modelOverride3 = toneName;
                    recentMessages4 = recentMessages2;
                    queuedMessage4 = queuedMessage3;
                    incomingMessage5 = incomingMessage4;
                    toneInstructions2 = toneInstructions;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    while (r23.hasNext()) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener6 = WhatsAppNotificationListener.this;
                    Context applicationContext4 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener6.replyToNotification(applicationContext4, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 2:
                    incomingMessage = (WhatsAppMessage) this.L$1;
                    recentMessages = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    sharedPreferences = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences = null;
                    }
                    isAutoReplyEnabled = sharedPreferences.getBoolean(WhatsAppNotificationListener.KEY_AUTO_REPLY, true);
                    if (!isAutoReplyEnabled) {
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply is disabled. Skipping reply.");
                        return Unit.INSTANCE;
                    }
                    sharedPreferences2 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences2 = null;
                    }
                    isGroupReplyEnabled = sharedPreferences2.getBoolean(WhatsAppNotificationListener.KEY_GROUP_REPLY, false);
                    if (!this.$isGroup) {
                    }
                    whatsAppRepository2 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository2 = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage);
                    this.Z$0 = isAutoReplyEnabled;
                    this.Z$1 = isGroupReplyEnabled;
                    this.label = 3;
                    pendingScheduledMessageForRecipient = whatsAppRepository2.getPendingScheduledMessageForRecipient(this.$sender, (Continuation) this);
                    if (pendingScheduledMessageForRecipient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled2 = isAutoReplyEnabled;
                    isGroupReplyEnabled2 = isGroupReplyEnabled;
                    incomingMessage2 = incomingMessage;
                    recentMessages2 = recentMessages;
                    queuedMessage = (ScheduledMessage) pendingScheduledMessageForRecipient;
                    if (queuedMessage != null) {
                        Log.d(WhatsAppNotificationListener.TAG, "Found scheduled message queued for " + this.$sender + ": '" + queuedMessage.getMessageText() + "'");
                        WhatsAppNotificationListener whatsAppNotificationListener7 = WhatsAppNotificationListener.this;
                        Context applicationContext5 = WhatsAppNotificationListener.this.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
                        isGroupReplyEnabled4 = whatsAppNotificationListener7.replyToNotification(applicationContext5, this.$sbn, queuedMessage.getMessageText());
                        if (isGroupReplyEnabled4) {
                            whatsAppRepository6 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository6 = null;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = queuedMessage;
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 4;
                            if (whatsAppRepository6.markAsSent(queuedMessage.getId(), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isGroupReplyEnabled5 = isGroupReplyEnabled2;
                            isAutoReplyEnabled4 = isAutoReplyEnabled2;
                            queuedMessage2 = queuedMessage;
                            incomingMessage3 = incomingMessage2;
                            recentMessages3 = recentMessages2;
                            whatsAppRepository7 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository8 = null;
                            } else {
                                whatsAppRepository8 = whatsAppRepository7;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages3);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage2);
                            this.Z$0 = isAutoReplyEnabled4;
                            this.Z$1 = isGroupReplyEnabled5;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 5;
                            if (whatsAppRepository8.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage2.getMessageText(), 0L, false, null, "SENT", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                        } else {
                            Log.e(WhatsAppNotificationListener.TAG, "Failed to reply using scheduled message notification actions.");
                            whatsAppRepository4 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository5 = null;
                            } else {
                                whatsAppRepository5 = whatsAppRepository4;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 6;
                            if (whatsAppRepository5.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage.getMessageText(), 0L, false, null, "FAILED", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    sharedPreferences3 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences3 = null;
                    }
                    useChatbotForReplies = sharedPreferences3.getBoolean(WhatsAppViewModel.KEY_USE_CHATBOT_FOR_REPLIES, true);
                    whatsAppNotificationListener = WhatsAppNotificationListener.this;
                    if (useChatbotForReplies) {
                        sharedPreferences5 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences5 = null;
                        }
                        String string5 = sharedPreferences5.getString(WhatsAppViewModel.KEY_CHATBOT_INSTRUCTION, "You are a helpful, extremely fast AI assistant.");
                        if (string5 != null) {
                        }
                        sharedPreferences6 = WhatsAppNotificationListener.this.prefs;
                        if (sharedPreferences6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences6 = null;
                        }
                        String string6 = sharedPreferences6.getString(WhatsAppViewModel.KEY_CHATBOT_MODEL, "gemini-3.1-flash-lite-preview");
                        String modelOverride8 = string6 != null ? string6 : "gemini-3.1-flash-lite-preview";
                        toneName = "Chatbot Profile (" + StringsKt.replace$default(modelOverride8, "gemini-", "", false, 4, (Object) null) + ")";
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        toneInstructions7 = "repository";
                        modelOverride = modelOverride8;
                    } else {
                        sharedPreferences4 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences4 = null;
                        }
                        int activeToneId3 = sharedPreferences4.getInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, 1);
                        whatsAppRepository3 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("repository");
                            whatsAppRepository3 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                        this.Z$0 = isAutoReplyEnabled2;
                        this.Z$1 = isGroupReplyEnabled2;
                        this.Z$2 = useChatbotForReplies;
                        this.I$0 = activeToneId3;
                        this.label = 7;
                        toneById = whatsAppRepository3.getToneById(activeToneId3, (Continuation) this);
                        if (toneById == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tone = (PersonalityTone) toneById;
                        if (tone != null) {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        } else {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        }
                        if (tone != null) {
                            toneName = "Friendly";
                        } else {
                            toneName = "Friendly";
                        }
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        modelOverride = null;
                        toneInstructions = toneInstructions3;
                    }
                    whatsAppRepository9 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        whatsAppRepository9 = null;
                    }
                    queuedMessage3 = queuedMessage;
                    incomingMessage4 = incomingMessage2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage3);
                    this.L$3 = toneInstructions;
                    this.L$4 = toneName;
                    this.L$5 = modelOverride;
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 8;
                    recentMessagesBySender2 = whatsAppRepository9.getRecentMessagesBySender(this.$sender, 10, (Continuation) this);
                    if (recentMessagesBySender2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelOverride2 = modelOverride;
                    modelOverride3 = toneName;
                    recentMessages4 = recentMessages2;
                    queuedMessage4 = queuedMessage3;
                    incomingMessage5 = incomingMessage4;
                    toneInstructions2 = toneInstructions;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    while (r23.hasNext()) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener8 = WhatsAppNotificationListener.this;
                    Context applicationContext6 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener8.replyToNotification(applicationContext6, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 3:
                    boolean sentSuccessfully3 = this.Z$1;
                    boolean isAutoReplyEnabled6 = this.Z$0;
                    WhatsAppMessage incomingMessage6 = (WhatsAppMessage) this.L$1;
                    List recentMessages5 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    pendingScheduledMessageForRecipient = $result;
                    incomingMessage2 = incomingMessage6;
                    recentMessages2 = recentMessages5;
                    isGroupReplyEnabled2 = sentSuccessfully3;
                    isAutoReplyEnabled2 = isAutoReplyEnabled6;
                    queuedMessage = (ScheduledMessage) pendingScheduledMessageForRecipient;
                    if (queuedMessage != null) {
                        Log.d(WhatsAppNotificationListener.TAG, "Found scheduled message queued for " + this.$sender + ": '" + queuedMessage.getMessageText() + "'");
                        WhatsAppNotificationListener whatsAppNotificationListener9 = WhatsAppNotificationListener.this;
                        Context applicationContext7 = WhatsAppNotificationListener.this.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext7, "getApplicationContext(...)");
                        isGroupReplyEnabled4 = whatsAppNotificationListener9.replyToNotification(applicationContext7, this.$sbn, queuedMessage.getMessageText());
                        if (isGroupReplyEnabled4) {
                            whatsAppRepository6 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository6 = null;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = queuedMessage;
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 4;
                            if (whatsAppRepository6.markAsSent(queuedMessage.getId(), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isGroupReplyEnabled5 = isGroupReplyEnabled2;
                            isAutoReplyEnabled4 = isAutoReplyEnabled2;
                            queuedMessage2 = queuedMessage;
                            incomingMessage3 = incomingMessage2;
                            recentMessages3 = recentMessages2;
                            whatsAppRepository7 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository8 = null;
                            } else {
                                whatsAppRepository8 = whatsAppRepository7;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages3);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage2);
                            this.Z$0 = isAutoReplyEnabled4;
                            this.Z$1 = isGroupReplyEnabled5;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 5;
                            if (whatsAppRepository8.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage2.getMessageText(), 0L, false, null, "SENT", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                        } else {
                            Log.e(WhatsAppNotificationListener.TAG, "Failed to reply using scheduled message notification actions.");
                            whatsAppRepository4 = WhatsAppNotificationListener.this.repository;
                            if (whatsAppRepository4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repository");
                                whatsAppRepository5 = null;
                            } else {
                                whatsAppRepository5 = whatsAppRepository4;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                            this.Z$0 = isAutoReplyEnabled2;
                            this.Z$1 = isGroupReplyEnabled2;
                            this.Z$2 = isGroupReplyEnabled4;
                            this.label = 6;
                            if (whatsAppRepository5.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage.getMessageText(), 0L, false, null, "FAILED", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    sharedPreferences3 = WhatsAppNotificationListener.this.prefs;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences3 = null;
                    }
                    useChatbotForReplies = sharedPreferences3.getBoolean(WhatsAppViewModel.KEY_USE_CHATBOT_FOR_REPLIES, true);
                    whatsAppNotificationListener = WhatsAppNotificationListener.this;
                    if (useChatbotForReplies) {
                        sharedPreferences5 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences5 = null;
                        }
                        String string7 = sharedPreferences5.getString(WhatsAppViewModel.KEY_CHATBOT_INSTRUCTION, "You are a helpful, extremely fast AI assistant.");
                        if (string7 != null) {
                        }
                        sharedPreferences6 = WhatsAppNotificationListener.this.prefs;
                        if (sharedPreferences6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences6 = null;
                        }
                        String string8 = sharedPreferences6.getString(WhatsAppViewModel.KEY_CHATBOT_MODEL, "gemini-3.1-flash-lite-preview");
                        String modelOverride9 = string8 != null ? string8 : "gemini-3.1-flash-lite-preview";
                        toneName = "Chatbot Profile (" + StringsKt.replace$default(modelOverride9, "gemini-", "", false, 4, (Object) null) + ")";
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        toneInstructions7 = "repository";
                        modelOverride = modelOverride9;
                    } else {
                        sharedPreferences4 = whatsAppNotificationListener.prefs;
                        if (sharedPreferences4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("prefs");
                            sharedPreferences4 = null;
                        }
                        int activeToneId4 = sharedPreferences4.getInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, 1);
                        whatsAppRepository3 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("repository");
                            whatsAppRepository3 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage);
                        this.Z$0 = isAutoReplyEnabled2;
                        this.Z$1 = isGroupReplyEnabled2;
                        this.Z$2 = useChatbotForReplies;
                        this.I$0 = activeToneId4;
                        this.label = 7;
                        toneById = whatsAppRepository3.getToneById(activeToneId4, (Continuation) this);
                        if (toneById == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tone = (PersonalityTone) toneById;
                        if (tone != null) {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        } else {
                            toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                        }
                        if (tone != null) {
                            toneName = "Friendly";
                        } else {
                            toneName = "Friendly";
                        }
                        useChatbotForReplies2 = useChatbotForReplies;
                        isGroupReplyEnabled3 = isGroupReplyEnabled2;
                        isAutoReplyEnabled3 = isAutoReplyEnabled2;
                        modelOverride = null;
                        toneInstructions = toneInstructions3;
                    }
                    whatsAppRepository9 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        whatsAppRepository9 = null;
                    }
                    queuedMessage3 = queuedMessage;
                    incomingMessage4 = incomingMessage2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage3);
                    this.L$3 = toneInstructions;
                    this.L$4 = toneName;
                    this.L$5 = modelOverride;
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 8;
                    recentMessagesBySender2 = whatsAppRepository9.getRecentMessagesBySender(this.$sender, 10, (Continuation) this);
                    if (recentMessagesBySender2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelOverride2 = modelOverride;
                    modelOverride3 = toneName;
                    recentMessages4 = recentMessages2;
                    queuedMessage4 = queuedMessage3;
                    incomingMessage5 = incomingMessage4;
                    toneInstructions2 = toneInstructions;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    while (r23.hasNext()) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener10 = WhatsAppNotificationListener.this;
                    Context applicationContext8 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext8, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener10.replyToNotification(applicationContext8, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 4:
                    isGroupReplyEnabled4 = this.Z$2;
                    isGroupReplyEnabled5 = this.Z$1;
                    isAutoReplyEnabled4 = this.Z$0;
                    queuedMessage2 = (ScheduledMessage) this.L$2;
                    incomingMessage3 = (WhatsAppMessage) this.L$1;
                    recentMessages3 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    whatsAppRepository7 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repository");
                        whatsAppRepository8 = null;
                    } else {
                        whatsAppRepository8 = whatsAppRepository7;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages3);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage2);
                    this.Z$0 = isAutoReplyEnabled4;
                    this.Z$1 = isGroupReplyEnabled5;
                    this.Z$2 = isGroupReplyEnabled4;
                    this.label = 5;
                    if (whatsAppRepository8.insertMessage(new WhatsAppMessage(0, this.$sender, queuedMessage2.getMessageText(), 0L, false, null, "SENT", "Scheduled Message", 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                    return Unit.INSTANCE;
                case 5:
                    boolean sentSuccessfully4 = this.Z$2;
                    boolean z = this.Z$1;
                    boolean z2 = this.Z$0;
                    ResultKt.throwOnFailure($result);
                    Boxing.boxInt(Log.d(WhatsAppNotificationListener.TAG, "Successfully replied with scheduled message."));
                    return Unit.INSTANCE;
                case 6:
                    boolean z3 = this.Z$2;
                    boolean z4 = this.Z$1;
                    boolean z5 = this.Z$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 7:
                    int i = this.I$0;
                    useChatbotForReplies = this.Z$2;
                    isGroupReplyEnabled2 = this.Z$1;
                    isAutoReplyEnabled2 = this.Z$0;
                    queuedMessage = (ScheduledMessage) this.L$2;
                    incomingMessage2 = (WhatsAppMessage) this.L$1;
                    recentMessages2 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    toneById = $result;
                    tone = (PersonalityTone) toneById;
                    if (tone != null) {
                        toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                    } else {
                        toneInstructions3 = "Reply in a friendly, helpful, and natural tone.";
                    }
                    if (tone != null) {
                        toneName = "Friendly";
                    } else {
                        toneName = "Friendly";
                    }
                    useChatbotForReplies2 = useChatbotForReplies;
                    isGroupReplyEnabled3 = isGroupReplyEnabled2;
                    isAutoReplyEnabled3 = isAutoReplyEnabled2;
                    modelOverride = null;
                    toneInstructions = toneInstructions3;
                    whatsAppRepository9 = WhatsAppNotificationListener.this.repository;
                    if (whatsAppRepository9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        whatsAppRepository9 = null;
                    }
                    queuedMessage3 = queuedMessage;
                    incomingMessage4 = incomingMessage2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage3);
                    this.L$3 = toneInstructions;
                    this.L$4 = toneName;
                    this.L$5 = modelOverride;
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 8;
                    recentMessagesBySender2 = whatsAppRepository9.getRecentMessagesBySender(this.$sender, 10, (Continuation) this);
                    if (recentMessagesBySender2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelOverride2 = modelOverride;
                    modelOverride3 = toneName;
                    recentMessages4 = recentMessages2;
                    queuedMessage4 = queuedMessage3;
                    incomingMessage5 = incomingMessage4;
                    toneInstructions2 = toneInstructions;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    while (r23.hasNext()) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener11 = WhatsAppNotificationListener.this;
                    Context applicationContext9 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext9, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener11.replyToNotification(applicationContext9, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 8:
                    useChatbotForReplies2 = this.Z$2;
                    isGroupReplyEnabled3 = this.Z$1;
                    isAutoReplyEnabled3 = this.Z$0;
                    String modelOverride10 = (String) this.L$5;
                    String toneName4 = (String) this.L$4;
                    String toneInstructions8 = (String) this.L$3;
                    queuedMessage4 = (ScheduledMessage) this.L$2;
                    incomingMessage5 = (WhatsAppMessage) this.L$1;
                    recentMessages4 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    modelOverride2 = modelOverride10;
                    modelOverride3 = toneName4;
                    toneInstructions7 = "repository";
                    recentMessagesBySender2 = $result;
                    toneInstructions2 = toneInstructions8;
                    history = CollectionsKt.reversed((Iterable) recentMessagesBySender2);
                    list = history;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    iterable = list;
                    while (r23.hasNext()) {
                        arrayList.add(new Pair(whatsAppMessage.getMessageText(), Boxing.boxBoolean(whatsAppMessage.isIncoming())));
                        list = list;
                        iterable = iterable;
                        queuedMessage4 = queuedMessage4;
                    }
                    queuedMessage5 = queuedMessage4;
                    list2 = (List) arrayList;
                    Log.d(WhatsAppNotificationListener.TAG, "Generating Gemini reply using tone '" + modelOverride3 + "' with context size " + list2.size());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions2);
                    this.L$4 = modelOverride3;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.label = 9;
                    objGenerateReply = GeminiApi.INSTANCE.generateReply(this.$messageText, this.$sender, toneInstructions2, list2, modelOverride2, (Continuation) this);
                    if (objGenerateReply == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toneName2 = modelOverride3;
                    history2 = history;
                    toneInstructions4 = toneInstructions2;
                    modelOverride4 = modelOverride2;
                    queuedMessage6 = queuedMessage5;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener12 = WhatsAppNotificationListener.this;
                    Context applicationContext10 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext10, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener12.replyToNotification(applicationContext10, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 9:
                    boolean isGroupReplyEnabled6 = this.Z$2;
                    boolean isGroupReplyEnabled7 = this.Z$1;
                    boolean isAutoReplyEnabled7 = this.Z$0;
                    List<Pair<String, Boolean>> list4 = (List) this.L$7;
                    List history5 = (List) this.L$6;
                    modelOverride4 = (String) this.L$5;
                    String toneName5 = (String) this.L$4;
                    String toneInstructions9 = (String) this.L$3;
                    ScheduledMessage queuedMessage9 = (ScheduledMessage) this.L$2;
                    WhatsAppMessage incomingMessage7 = (WhatsAppMessage) this.L$1;
                    List recentMessages6 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    toneInstructions7 = "repository";
                    toneName2 = toneName5;
                    list2 = list4;
                    queuedMessage6 = queuedMessage9;
                    toneInstructions4 = toneInstructions9;
                    incomingMessage5 = incomingMessage7;
                    isGroupReplyEnabled3 = isGroupReplyEnabled7;
                    isAutoReplyEnabled3 = isAutoReplyEnabled7;
                    history2 = history5;
                    objGenerateReply = $result;
                    recentMessages4 = recentMessages6;
                    useChatbotForReplies2 = isGroupReplyEnabled6;
                    generatedReply = (String) objGenerateReply;
                    history3 = history2;
                    toneInstructions5 = toneInstructions4;
                    queuedMessage7 = queuedMessage6;
                    whatsAppRepository10 = null;
                    if (StringsKt.startsWith$default(generatedReply, "Error:", false, 2, (Object) null)) {
                        Log.e(WhatsAppNotificationListener.TAG, "Failed to generate reply: " + generatedReply);
                        whatsAppRepository13 = WhatsAppNotificationListener.this.repository;
                        if (whatsAppRepository13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository13;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.label = 10;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WhatsAppNotificationListener whatsAppNotificationListener13 = WhatsAppNotificationListener.this;
                    Context applicationContext11 = WhatsAppNotificationListener.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext11, "getApplicationContext(...)");
                    sentSuccessfully = whatsAppNotificationListener13.replyToNotification(applicationContext11, this.$sbn, generatedReply);
                    whatsAppNotificationListener2 = WhatsAppNotificationListener.this;
                    if (sentSuccessfully) {
                        whatsAppRepository12 = whatsAppNotificationListener2.repository;
                        if (whatsAppRepository12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                        } else {
                            whatsAppRepository10 = whatsAppRepository12;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                        this.L$8 = generatedReply;
                        this.Z$0 = isAutoReplyEnabled3;
                        this.Z$1 = isGroupReplyEnabled3;
                        this.Z$2 = useChatbotForReplies2;
                        this.Z$3 = sentSuccessfully;
                        this.label = 11;
                        if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "SENT", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sentSuccessfully2 = sentSuccessfully;
                        generatedReply3 = generatedReply;
                        Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                        return Unit.INSTANCE;
                    }
                    whatsAppRepository11 = whatsAppNotificationListener2.repository;
                    if (whatsAppRepository11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(toneInstructions7);
                    } else {
                        whatsAppRepository10 = whatsAppRepository11;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(recentMessages4);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(incomingMessage5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(queuedMessage7);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(toneInstructions5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(toneName2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(modelOverride4);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(history3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(generatedReply);
                    this.Z$0 = isAutoReplyEnabled3;
                    this.Z$1 = isGroupReplyEnabled3;
                    this.Z$2 = useChatbotForReplies2;
                    this.Z$3 = sentSuccessfully;
                    this.label = 12;
                    if (whatsAppRepository10.insertMessage(new WhatsAppMessage(0, this.$sender, generatedReply, 0L, false, null, "FAILED", toneName2, 41, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isAutoReplyEnabled5 = isAutoReplyEnabled3;
                    modelOverride5 = modelOverride4;
                    toneInstructions6 = toneInstructions5;
                    queuedMessage8 = queuedMessage7;
                    history4 = history3;
                    list3 = list2;
                    generatedReply2 = generatedReply;
                    toneName3 = toneName2;
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                case 10:
                    boolean sentSuccessfully5 = this.Z$2;
                    boolean z6 = this.Z$1;
                    boolean z7 = this.Z$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 11:
                    sentSuccessfully2 = this.Z$3;
                    useChatbotForReplies2 = this.Z$2;
                    boolean z8 = this.Z$1;
                    boolean z9 = this.Z$0;
                    generatedReply3 = (String) this.L$8;
                    ResultKt.throwOnFailure($result);
                    Log.d(WhatsAppNotificationListener.TAG, "Auto-reply sent successfully: '" + generatedReply3 + "'");
                    return Unit.INSTANCE;
                case 12:
                    boolean z10 = this.Z$3;
                    boolean z11 = this.Z$2;
                    boolean z12 = this.Z$1;
                    isAutoReplyEnabled5 = this.Z$0;
                    generatedReply2 = (String) this.L$8;
                    list3 = (List) this.L$7;
                    history4 = (List) this.L$6;
                    modelOverride5 = (String) this.L$5;
                    toneName3 = (String) this.L$4;
                    toneInstructions6 = (String) this.L$3;
                    queuedMessage8 = (ScheduledMessage) this.L$2;
                    incomingMessage5 = (WhatsAppMessage) this.L$1;
                    recentMessages4 = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    Log.e(WhatsAppNotificationListener.TAG, "Failed to send auto-reply. No quick reply action found on notification.");
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean replyToNotification(Context context, StatusBarNotification sbn, String replyText) {
        Notification.Action[] actions = sbn.getNotification().actions;
        if (actions == null) {
            return false;
        }
        for (Notification.Action action : actions) {
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (RemoteInput remoteInput : remoteInputs) {
                    String resultKey = remoteInput.getResultKey();
                    if (resultKey != null) {
                        try {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence(resultKey, replyText);
                            RemoteInput.addResultsToIntent(new RemoteInput[]{remoteInput}, intent, bundle);
                            try {
                                action.actionIntent.send(context, 0, intent);
                                return true;
                            } catch (Exception e) {
                                e = e;
                                Log.e(TAG, "Error performing pending intent send", e);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            }
        }
        return false;
    }
}
