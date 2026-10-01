package com.example.ui;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.BuildConfig;
import com.example.api.GeminiApi;
import com.example.data.PersonalityTone;
import com.example.data.ScheduledMessage;
import com.example.data.WhatsAppDatabase;
import com.example.data.WhatsAppMessage;
import com.example.data.WhatsAppRepository;
import com.example.receiver.ScheduledMessageReceiver;
import com.example.service.WhatsAppNotificationListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: WhatsAppViewModel.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes7.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020)J\u001e\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204J0\u00105\u001a\u00020)2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001c2\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020!2\u0006\u00109\u001a\u000204H\u0002J\u000e\u0010:\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001cJ\u0018\u0010;\u001a\u00020)2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001cH\u0002J\u001e\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020!J\u000e\u0010@\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001cJ\u000e\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020!J\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020!J\u0006\u0010E\u001a\u00020)J\u0006\u0010F\u001a\u00020)J\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006J"}, d2 = {"Lcom/example/ui/WhatsAppViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repository", "Lcom/example/data/WhatsAppRepository;", "prefs", "Landroid/content/SharedPreferences;", "allMessages", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/data/WhatsAppMessage;", "getAllMessages", "()Lkotlinx/coroutines/flow/StateFlow;", "allScheduledMessages", "Lcom/example/data/ScheduledMessage;", "getAllScheduledMessages", "allTones", "Lcom/example/data/PersonalityTone;", "getAllTones", "isAutoReplyEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isGroupReplyEnabled", "activeToneId", "", "getActiveToneId", "chatbotMessages", "getChatbotMessages", "chatbotSystemInstruction", "", "getChatbotSystemInstruction", "chatbotModel", "getChatbotModel", "useChatbotForReplies", "getUseChatbotForReplies", "isGeneratingChatbotReply", "toggleAutoReply", "", "toggleGroupReply", "setActiveTone", "toneId", "deleteMessage", "id", "clearAllHistory", "scheduleMessage", "recipient", "messageText", "scheduledTime", "", "scheduleAlarm", "context", "Landroid/content/Context;", "msgId", "timeInMillis", "deleteScheduledMessage", "cancelAlarm", "addCustomTone", "name", "description", "promptInstructions", "deleteTone", "updateChatbotSystemInstruction", "instruction", "updateChatbotModel", "model", "toggleUseChatbotForReplies", "clearChatbotHistory", "sendChatbotMessage", "text", "Companion", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppViewModel extends AndroidViewModel {
    public static final String KEY_CHATBOT_INSTRUCTION = "chatbot_system_instruction";
    public static final String KEY_CHATBOT_MODEL = "chatbot_model";
    public static final String KEY_USE_CHATBOT_FOR_REPLIES = "use_chatbot_for_replies";
    private static final String TAG = "WhatsAppViewModel";
    private final MutableStateFlow<Integer> activeToneId;
    private final StateFlow<List<WhatsAppMessage>> allMessages;
    private final StateFlow<List<ScheduledMessage>> allScheduledMessages;
    private final StateFlow<List<PersonalityTone>> allTones;
    private final StateFlow<List<WhatsAppMessage>> chatbotMessages;
    private final MutableStateFlow<String> chatbotModel;
    private final MutableStateFlow<String> chatbotSystemInstruction;
    private final MutableStateFlow<Boolean> isAutoReplyEnabled;
    private final MutableStateFlow<Boolean> isGeneratingChatbotReply;
    private final MutableStateFlow<Boolean> isGroupReplyEnabled;
    private final SharedPreferences prefs;
    private final WhatsAppRepository repository;
    private final MutableStateFlow<Boolean> useChatbotForReplies;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhatsAppViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.isAutoReplyEnabled = StateFlowKt.MutableStateFlow(true);
        this.isGroupReplyEnabled = StateFlowKt.MutableStateFlow(false);
        this.activeToneId = StateFlowKt.MutableStateFlow(1);
        this.chatbotSystemInstruction = StateFlowKt.MutableStateFlow("You are a helpful, extremely fast AI assistant.");
        this.chatbotModel = StateFlowKt.MutableStateFlow("gemini-3.1-flash-lite-preview");
        this.useChatbotForReplies = StateFlowKt.MutableStateFlow(true);
        this.isGeneratingChatbotReply = StateFlowKt.MutableStateFlow(false);
        WhatsAppDatabase db = WhatsAppDatabase.INSTANCE.getDatabase(application, ViewModelKt.getViewModelScope((ViewModel) this));
        this.repository = new WhatsAppRepository(db.dao());
        SharedPreferences sharedPreferences = application.getSharedPreferences(WhatsAppNotificationListener.PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        this.allMessages = FlowKt.stateIn(this.repository.getAllMessages(), ViewModelKt.getViewModelScope((ViewModel) this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), CollectionsKt.emptyList());
        this.allScheduledMessages = FlowKt.stateIn(this.repository.getAllScheduledMessages(), ViewModelKt.getViewModelScope((ViewModel) this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), CollectionsKt.emptyList());
        this.allTones = FlowKt.stateIn(this.repository.getAllTones(), ViewModelKt.getViewModelScope((ViewModel) this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), CollectionsKt.emptyList());
        final Flow<List<WhatsAppMessage>> allMessages = this.repository.getAllMessages();
        this.chatbotMessages = FlowKt.stateIn(new Flow<List<? extends WhatsAppMessage>>() { // from class: com.example.ui.WhatsAppViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$special$$inlined$map$1$2", f = "WhatsAppViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1\\1\\49\\0"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0018  */
                public final Object emit(Object value, Continuation $completion) {
                    AnonymousClass1 anonymousClass1;
                    if ($completion instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) $completion;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1($completion);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1($completion);
                    }
                    Object $result = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                            AnonymousClass1 anonymousClass2 = anonymousClass1;
                            Collection arrayList = new ArrayList();
                            for (Object obj : (List) value) {
                                Object $result2 = $result;
                                if (Intrinsics.areEqual(((WhatsAppMessage) obj).getSender(), "AI_Chatbot_Conversation")) {
                                    arrayList.add(obj);
                                }
                                $result = $result2;
                            }
                            List listReversed = CollectionsKt.reversed((List) arrayList);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass2);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(value);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if ($this$map_u24lambda_u245.emit(listReversed, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                            break;
                        case BuildConfig.VERSION_CODE /* 1 */:
                            int i = anonymousClass1.I$0;
                            Object obj2 = anonymousClass1.L$2;
                            Object obj3 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object objCollect = allMessages.collect(new AnonymousClass2(collector), $completion);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope((ViewModel) this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), CollectionsKt.emptyList());
        this.isAutoReplyEnabled.setValue(Boolean.valueOf(this.prefs.getBoolean(WhatsAppNotificationListener.KEY_AUTO_REPLY, true)));
        this.isGroupReplyEnabled.setValue(Boolean.valueOf(this.prefs.getBoolean(WhatsAppNotificationListener.KEY_GROUP_REPLY, false)));
        this.activeToneId.setValue(Integer.valueOf(this.prefs.getInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, 1)));
        MutableStateFlow<String> mutableStateFlow = this.chatbotSystemInstruction;
        String string = this.prefs.getString(KEY_CHATBOT_INSTRUCTION, "You are a helpful, extremely fast AI assistant.");
        mutableStateFlow.setValue(string != null ? string : "You are a helpful, extremely fast AI assistant.");
        MutableStateFlow<String> mutableStateFlow2 = this.chatbotModel;
        String string2 = this.prefs.getString(KEY_CHATBOT_MODEL, "gemini-3.1-flash-lite-preview");
        mutableStateFlow2.setValue(string2 != null ? string2 : "gemini-3.1-flash-lite-preview");
        this.useChatbotForReplies.setValue(Boolean.valueOf(this.prefs.getBoolean(KEY_USE_CHATBOT_FOR_REPLIES, true)));
    }

    public final StateFlow<List<WhatsAppMessage>> getAllMessages() {
        return this.allMessages;
    }

    public final StateFlow<List<ScheduledMessage>> getAllScheduledMessages() {
        return this.allScheduledMessages;
    }

    public final StateFlow<List<PersonalityTone>> getAllTones() {
        return this.allTones;
    }

    public final MutableStateFlow<Boolean> isAutoReplyEnabled() {
        return this.isAutoReplyEnabled;
    }

    public final MutableStateFlow<Boolean> isGroupReplyEnabled() {
        return this.isGroupReplyEnabled;
    }

    public final MutableStateFlow<Integer> getActiveToneId() {
        return this.activeToneId;
    }

    public final StateFlow<List<WhatsAppMessage>> getChatbotMessages() {
        return this.chatbotMessages;
    }

    public final MutableStateFlow<String> getChatbotSystemInstruction() {
        return this.chatbotSystemInstruction;
    }

    public final MutableStateFlow<String> getChatbotModel() {
        return this.chatbotModel;
    }

    public final MutableStateFlow<Boolean> getUseChatbotForReplies() {
        return this.useChatbotForReplies;
    }

    public final MutableStateFlow<Boolean> isGeneratingChatbotReply() {
        return this.isGeneratingChatbotReply;
    }

    public final void toggleAutoReply() {
        boolean newValue = !((Boolean) this.isAutoReplyEnabled.getValue()).booleanValue();
        this.isAutoReplyEnabled.setValue(Boolean.valueOf(newValue));
        this.prefs.edit().putBoolean(WhatsAppNotificationListener.KEY_AUTO_REPLY, newValue).apply();
        Log.d(TAG, "Toggled Auto Reply to " + newValue);
    }

    public final void toggleGroupReply() {
        boolean newValue = !((Boolean) this.isGroupReplyEnabled.getValue()).booleanValue();
        this.isGroupReplyEnabled.setValue(Boolean.valueOf(newValue));
        this.prefs.edit().putBoolean(WhatsAppNotificationListener.KEY_GROUP_REPLY, newValue).apply();
        Log.d(TAG, "Toggled Group Reply to " + newValue);
    }

    public final void setActiveTone(int toneId) {
        this.activeToneId.setValue(Integer.valueOf(toneId));
        this.prefs.edit().putInt(WhatsAppNotificationListener.KEY_ACTIVE_TONE_ID, toneId).apply();
        Log.d(TAG, "Set active tone to " + toneId);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$deleteMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$deleteMessage$1", f = "WhatsAppViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00021(int i, Continuation<? super C00021> continuation) {
            super(2, continuation);
            this.$id = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppViewModel.this.new C00021(this.$id, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WhatsAppViewModel.this.repository.deleteMessageById(this.$id, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteMessage(int id) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00021(id, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$clearAllHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$clearAllHistory$1", f = "WhatsAppViewModel.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00001(Continuation<? super C00001> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppViewModel.this.new C00001(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WhatsAppViewModel.this.repository.clearAllMessages((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void clearAllHistory() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00001(null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$scheduleMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$scheduleMessage$1", f = "WhatsAppViewModel.kt", i = {0}, l = {137}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
    static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $messageText;
        final /* synthetic */ String $recipient;
        final /* synthetic */ long $scheduledTime;
        Object L$0;
        int label;
        final /* synthetic */ WhatsAppViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00051(String str, String str2, long j, WhatsAppViewModel whatsAppViewModel, Continuation<? super C00051> continuation) {
            super(2, continuation);
            this.$recipient = str;
            this.$messageText = str2;
            this.$scheduledTime = j;
            this.this$0 = whatsAppViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00051(this.$recipient, this.$messageText, this.$scheduledTime, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objInsertScheduledMessage;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ScheduledMessage message = new ScheduledMessage(0, this.$recipient, this.$messageText, this.$scheduledTime, false, "ON_NOTIFICATION", 1, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(message);
                    this.label = 1;
                    objInsertScheduledMessage = this.this$0.repository.insertScheduledMessage(message, (Continuation) this);
                    if (objInsertScheduledMessage == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    objInsertScheduledMessage = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long id = ((Number) objInsertScheduledMessage).longValue();
            this.this$0.scheduleAlarm(this.this$0.getApplication(), (int) id, this.$recipient, this.$messageText, this.$scheduledTime);
            return Unit.INSTANCE;
        }
    }

    public final void scheduleMessage(String recipient, String messageText, long scheduledTime) {
        Intrinsics.checkNotNullParameter(recipient, "recipient");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00051(recipient, messageText, scheduledTime, this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleAlarm(Context context, int msgId, String recipient, String messageText, long timeInMillis) {
        Object systemService = context.getSystemService("alarm");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(context, (Class<?>) ScheduledMessageReceiver.class);
        intent.putExtra("msg_id", msgId);
        intent.putExtra("recipient", recipient);
        intent.putExtra("message_text", messageText);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, msgId, intent, 201326592);
        try {
            alarmManager.setExactAndAllowWhileIdle(0, timeInMillis, pendingIntent);
            Log.d(TAG, "Scheduled alarm for message " + msgId + " at " + timeInMillis);
        } catch (SecurityException e) {
            Log.e(TAG, "Failed to schedule exact alarm due to permission constraints", e);
            alarmManager.set(0, timeInMillis, pendingIntent);
        }
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$deleteScheduledMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$deleteScheduledMessage$1", f = "WhatsAppViewModel.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    static final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00031(int i, Continuation<? super C00031> continuation) {
            super(2, continuation);
            this.$id = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppViewModel.this.new C00031(this.$id, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WhatsAppViewModel.this.repository.deleteScheduledMessage(this.$id, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WhatsAppViewModel.this.cancelAlarm(WhatsAppViewModel.this.getApplication(), this.$id);
            return Unit.INSTANCE;
        }
    }

    public final void deleteScheduledMessage(int id) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00031(id, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelAlarm(Context context, int msgId) {
        Object systemService = context.getSystemService("alarm");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(context, (Class<?>) ScheduledMessageReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, msgId, intent, 201326592);
        alarmManager.cancel(pendingIntent);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$addCustomTone$1, reason: invalid class name */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$addCustomTone$1", f = "WhatsAppViewModel.kt", i = {0}, l = {221}, m = "invokeSuspend", n = {"customTone"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $name;
        final /* synthetic */ String $promptInstructions;
        Object L$0;
        int label;
        final /* synthetic */ WhatsAppViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, WhatsAppViewModel whatsAppViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
            this.$description = str2;
            this.$promptInstructions = str3;
            this.this$0 = whatsAppViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$name, this.$description, this.$promptInstructions, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objInsertTone;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PersonalityTone customTone = new PersonalityTone(0, this.$name, this.$description, this.$promptInstructions, false, 1, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(customTone);
                    this.label = 1;
                    objInsertTone = this.this$0.repository.insertTone(customTone, (Continuation) this);
                    if (objInsertTone == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    objInsertTone = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long toneId = ((Number) objInsertTone).longValue();
            Log.d(WhatsAppViewModel.TAG, "Inserted custom tone " + this.$name + " with id " + toneId);
            return Unit.INSTANCE;
        }
    }

    public final void addCustomTone(String name, String description, String promptInstructions) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(promptInstructions, "promptInstructions");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(name, description, promptInstructions, this, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$deleteTone$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$deleteTone$1", f = "WhatsAppViewModel.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00041(int i, Continuation<? super C00041> continuation) {
            super(2, continuation);
            this.$id = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppViewModel.this.new C00041(this.$id, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WhatsAppViewModel.this.repository.deleteTone(this.$id, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((Number) WhatsAppViewModel.this.getActiveToneId().getValue()).intValue() == this.$id) {
                WhatsAppViewModel.this.setActiveTone(1);
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteTone(int id) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00041(id, null), 2, (Object) null);
    }

    public final void updateChatbotSystemInstruction(String instruction) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        this.chatbotSystemInstruction.setValue(instruction);
        this.prefs.edit().putString(KEY_CHATBOT_INSTRUCTION, instruction).apply();
        Log.d(TAG, "Updated chatbot system instruction: " + instruction);
    }

    public final void updateChatbotModel(String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.chatbotModel.setValue(model);
        this.prefs.edit().putString(KEY_CHATBOT_MODEL, model).apply();
        Log.d(TAG, "Updated chatbot model: " + model);
    }

    public final void toggleUseChatbotForReplies() {
        boolean newValue = !((Boolean) this.useChatbotForReplies.getValue()).booleanValue();
        this.useChatbotForReplies.setValue(Boolean.valueOf(newValue));
        this.prefs.edit().putBoolean(KEY_USE_CHATBOT_FOR_REPLIES, newValue).apply();
        Log.d(TAG, "Toggled useChatbotForReplies to " + newValue);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$clearChatbotHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$clearChatbotHistory$1", f = "WhatsAppViewModel.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
    static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00011(Continuation<? super C00011> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WhatsAppViewModel.this.new C00011(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WhatsAppViewModel.this.repository.deleteMessagesBySender("AI_Chatbot_Conversation", (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Log.d(WhatsAppViewModel.TAG, "Cleared chatbot conversational logs");
            return Unit.INSTANCE;
        }
    }

    public final void clearChatbotHistory() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00011(null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.example.ui.WhatsAppViewModel$sendChatbotMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WhatsAppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.WhatsAppViewModel$sendChatbotMessage$1", f = "WhatsAppViewModel.kt", i = {0, BuildConfig.VERSION_CODE, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4}, l = {273, 278, 283, 297, 306}, m = "invokeSuspend", n = {"userMsg", "userMsg", "userMsg", "history", "contextList", "userMsg", "history", "contextList", "reply", "botMsg", "userMsg", "e", "errorMsg"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
    static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ WhatsAppViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00061(String str, WhatsAppViewModel whatsAppViewModel, Continuation<? super C00061> continuation) {
            super(2, continuation);
            this.$text = str;
            this.this$0 = whatsAppViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00061(this.$text, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00fa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x011a A[Catch: Exception -> 0x0083, all -> 0x027e, TryCatch #4 {Exception -> 0x0083, blocks: (B:19:0x0067, B:22:0x0076, B:36:0x00fb, B:37:0x0114, B:39:0x011a, B:41:0x0129, B:33:0x00de), top: B:89:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0129 A[Catch: Exception -> 0x0083, all -> 0x027e, TRY_LEAVE, TryCatch #4 {Exception -> 0x0083, blocks: (B:19:0x0067, B:22:0x0076, B:36:0x00fb, B:37:0x0114, B:39:0x011a, B:41:0x0129, B:33:0x00de), top: B:89:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0141  */
        /* JADX WARN: Code duplicated, block: B:46:0x0143  */
        /* JADX WARN: Code duplicated, block: B:49:0x0149 A[Catch: all -> 0x027a, Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:62:0x0265, B:59:0x0213, B:43:0x0137, B:49:0x0149, B:51:0x014e, B:52:0x016b, B:54:0x0171, B:55:0x0192), top: B:84:0x0137 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0171 A[Catch: all -> 0x027a, Exception -> 0x027c, LOOP:1: B:52:0x016b->B:54:0x0171, LOOP_END, TryCatch #0 {Exception -> 0x027c, blocks: (B:62:0x0265, B:59:0x0213, B:43:0x0137, B:49:0x0149, B:51:0x014e, B:52:0x016b, B:54:0x0171, B:55:0x0192), top: B:84:0x0137 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0210 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x0211  */
        /* JADX WARN: Code duplicated, block: B:61:0x0264 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:73:0x0295  */
        /* JADX WARN: Code duplicated, block: B:76:0x02e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:77:0x02e7  */
        /* JADX WARN: Code duplicated, block: B:96:0x014c A[SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x007e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('userMsg' com.example.data.WhatsAppMessage)]), block:B:25:0x007e */
        public final Object invokeSuspend(Object $result) throws Throwable {
            boolean z;
            WhatsAppMessage userMsg;
            String localizedMessage;
            Object objInsertMessage;
            Object recentMessagesBySender;
            List history;
            String str;
            Collection arrayList;
            Collection arrayList2;
            List history2;
            List<Pair<String, Boolean>> list;
            Object objGenerateReply;
            List history3;
            WhatsAppMessage whatsAppMessage;
            boolean z2;
            Object objInsertMessage2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            userMsg = new WhatsAppMessage(0, "AI_Chatbot_Conversation", StringsKt.trim(this.$text).toString(), 0L, true, null, "RECEIVED", null, 169, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.label = 1;
                            if (this.this$0.repository.insertMessage(userMsg, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(true));
                            try {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                                this.label = 2;
                                recentMessagesBySender = this.this$0.repository.getRecentMessagesBySender("AI_Chatbot_Conversation", 20, (Continuation) this);
                                if (recentMessagesBySender == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                history = CollectionsKt.reversed((Iterable) recentMessagesBySender);
                                str = this.$text;
                                arrayList = new ArrayList();
                                for (Object obj : history) {
                                    whatsAppMessage = (WhatsAppMessage) obj;
                                    if (whatsAppMessage.getId() != 0) {
                                        z = false;
                                        try {
                                            try {
                                                if (!Intrinsics.areEqual(whatsAppMessage.getMessageText(), StringsKt.trim(str).toString())) {
                                                    z2 = true;
                                                }
                                                if (z2) {
                                                    arrayList.add(obj);
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                Log.e(WhatsAppViewModel.TAG, "Error generating chatbot reply", e);
                                                localizedMessage = e.getLocalizedMessage();
                                                if (localizedMessage == null) {
                                                    localizedMessage = "Failed to generate AI response.";
                                                }
                                                WhatsAppMessage errorMsg = new WhatsAppMessage(0, "AI_Chatbot_Conversation", "Error: " + localizedMessage, 0L, false, null, "FAILED", null, 169, null);
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(errorMsg);
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.label = 5;
                                                objInsertMessage = this.this$0.repository.insertMessage(errorMsg, (Continuation) this);
                                                if (objInsertMessage == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                ((Number) objInsertMessage).longValue();
                                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                            throw th;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    z2 = z;
                                    if (z2) {
                                        arrayList.add(obj);
                                    }
                                    break;
                                }
                                z = false;
                                Iterable<WhatsAppMessage> iterable = (List) arrayList;
                                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                                for (WhatsAppMessage whatsAppMessage2 : iterable) {
                                    arrayList2.add(new Pair(whatsAppMessage2.getMessageText(), Boxing.boxBoolean(whatsAppMessage2.isIncoming())));
                                    history = history;
                                }
                                history2 = history;
                                list = (List) arrayList2;
                                Log.d(WhatsAppViewModel.TAG, "Sending prompt to Gemini. Context Size: " + list.size() + ", Model: " + this.this$0.getChatbotModel().getValue());
                                this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(history2);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                this.label = 3;
                                objGenerateReply = GeminiApi.INSTANCE.generateReply(StringsKt.trim(this.$text).toString(), "AI_Chatbot_Conversation", (String) this.this$0.getChatbotSystemInstruction().getValue(), list, (String) this.this$0.getChatbotModel().getValue(), (Continuation) this);
                                if (objGenerateReply == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                history3 = history2;
                                String reply = (String) objGenerateReply;
                                WhatsAppMessage botMsg = new WhatsAppMessage(0, "AI_Chatbot_Conversation", reply, 0L, false, null, "RECEIVED", null, 169, null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(history3);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(reply);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(botMsg);
                                this.label = 4;
                                objInsertMessage2 = this.this$0.repository.insertMessage(botMsg, (Continuation) this);
                                if (objInsertMessage2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ((Number) objInsertMessage2).longValue();
                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                z = false;
                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                throw th;
                            }
                        case BuildConfig.VERSION_CODE /* 1 */:
                            WhatsAppMessage userMsg2 = (WhatsAppMessage) this.L$0;
                            ResultKt.throwOnFailure($result);
                            userMsg = userMsg2;
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(true));
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.label = 2;
                            recentMessagesBySender = this.this$0.repository.getRecentMessagesBySender("AI_Chatbot_Conversation", 20, (Continuation) this);
                            if (recentMessagesBySender == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            history = CollectionsKt.reversed((Iterable) recentMessagesBySender);
                            str = this.$text;
                            arrayList = new ArrayList();
                            while (r13.hasNext()) {
                                whatsAppMessage = (WhatsAppMessage) obj;
                                if (whatsAppMessage.getId() != 0) {
                                    z = false;
                                    if (!Intrinsics.areEqual(whatsAppMessage.getMessageText(), StringsKt.trim(str).toString())) {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        arrayList.add(obj);
                                    }
                                } else {
                                    z = false;
                                }
                                z2 = z;
                                if (z2) {
                                    arrayList.add(obj);
                                }
                                break;
                            }
                            z = false;
                            Iterable<WhatsAppMessage> iterable2 = (List) arrayList;
                            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                            while (r10.hasNext()) {
                                arrayList2.add(new Pair(whatsAppMessage2.getMessageText(), Boxing.boxBoolean(whatsAppMessage2.isIncoming())));
                                history = history;
                            }
                            history2 = history;
                            list = (List) arrayList2;
                            Log.d(WhatsAppViewModel.TAG, "Sending prompt to Gemini. Context Size: " + list.size() + ", Model: " + this.this$0.getChatbotModel().getValue());
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(history2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            this.label = 3;
                            objGenerateReply = GeminiApi.INSTANCE.generateReply(StringsKt.trim(this.$text).toString(), "AI_Chatbot_Conversation", (String) this.this$0.getChatbotSystemInstruction().getValue(), list, (String) this.this$0.getChatbotModel().getValue(), (Continuation) this);
                            if (objGenerateReply == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            history3 = history2;
                            String reply2 = (String) objGenerateReply;
                            WhatsAppMessage botMsg2 = new WhatsAppMessage(0, "AI_Chatbot_Conversation", reply2, 0L, false, null, "RECEIVED", null, 169, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(history3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(reply2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(botMsg2);
                            this.label = 4;
                            objInsertMessage2 = this.this$0.repository.insertMessage(botMsg2, (Continuation) this);
                            if (objInsertMessage2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ((Number) objInsertMessage2).longValue();
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                            return Unit.INSTANCE;
                        case 2:
                            userMsg = (WhatsAppMessage) this.L$0;
                            ResultKt.throwOnFailure($result);
                            recentMessagesBySender = $result;
                            history = CollectionsKt.reversed((Iterable) recentMessagesBySender);
                            str = this.$text;
                            arrayList = new ArrayList();
                            while (r13.hasNext()) {
                                whatsAppMessage = (WhatsAppMessage) obj;
                                if (whatsAppMessage.getId() != 0) {
                                    z = false;
                                    if (!Intrinsics.areEqual(whatsAppMessage.getMessageText(), StringsKt.trim(str).toString())) {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        arrayList.add(obj);
                                    }
                                } else {
                                    z = false;
                                }
                                z2 = z;
                                if (z2) {
                                    arrayList.add(obj);
                                }
                                break;
                            }
                            z = false;
                            Iterable<WhatsAppMessage> iterable3 = (List) arrayList;
                            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                            while (r10.hasNext()) {
                                arrayList2.add(new Pair(whatsAppMessage2.getMessageText(), Boxing.boxBoolean(whatsAppMessage2.isIncoming())));
                                history = history;
                            }
                            history2 = history;
                            list = (List) arrayList2;
                            Log.d(WhatsAppViewModel.TAG, "Sending prompt to Gemini. Context Size: " + list.size() + ", Model: " + this.this$0.getChatbotModel().getValue());
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(history2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            this.label = 3;
                            objGenerateReply = GeminiApi.INSTANCE.generateReply(StringsKt.trim(this.$text).toString(), "AI_Chatbot_Conversation", (String) this.this$0.getChatbotSystemInstruction().getValue(), list, (String) this.this$0.getChatbotModel().getValue(), (Continuation) this);
                            if (objGenerateReply == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            history3 = history2;
                            String reply3 = (String) objGenerateReply;
                            WhatsAppMessage botMsg3 = new WhatsAppMessage(0, "AI_Chatbot_Conversation", reply3, 0L, false, null, "RECEIVED", null, 169, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(history3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(reply3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(botMsg3);
                            this.label = 4;
                            objInsertMessage2 = this.this$0.repository.insertMessage(botMsg3, (Continuation) this);
                            if (objInsertMessage2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ((Number) objInsertMessage2).longValue();
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                            return Unit.INSTANCE;
                        case 3:
                            List<Pair<String, Boolean>> list2 = (List) this.L$2;
                            history3 = (List) this.L$1;
                            userMsg = (WhatsAppMessage) this.L$0;
                            ResultKt.throwOnFailure($result);
                            list = list2;
                            z = false;
                            objGenerateReply = $result;
                            String reply4 = (String) objGenerateReply;
                            WhatsAppMessage botMsg4 = new WhatsAppMessage(0, "AI_Chatbot_Conversation", reply4, 0L, false, null, "RECEIVED", null, 169, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(history3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(reply4);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(botMsg4);
                            this.label = 4;
                            objInsertMessage2 = this.this$0.repository.insertMessage(botMsg4, (Continuation) this);
                            if (objInsertMessage2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ((Number) objInsertMessage2).longValue();
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                            return Unit.INSTANCE;
                        case 4:
                            WhatsAppMessage userMsg3 = (WhatsAppMessage) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                objInsertMessage2 = $result;
                                userMsg = userMsg3;
                                z = false;
                                ((Number) objInsertMessage2).longValue();
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                userMsg = userMsg3;
                                z = false;
                                Log.e(WhatsAppViewModel.TAG, "Error generating chatbot reply", e);
                                localizedMessage = e.getLocalizedMessage();
                                if (localizedMessage == null) {
                                    localizedMessage = "Failed to generate AI response.";
                                }
                                WhatsAppMessage errorMsg2 = new WhatsAppMessage(0, "AI_Chatbot_Conversation", "Error: " + localizedMessage, 0L, false, null, "FAILED", null, 169, null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(userMsg);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(errorMsg2);
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 5;
                                objInsertMessage = this.this$0.repository.insertMessage(errorMsg2, (Continuation) this);
                                if (objInsertMessage == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ((Number) objInsertMessage).longValue();
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                throw th;
                            }
                            this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                            return Unit.INSTANCE;
                        case 5:
                            WhatsAppMessage userMsg4 = (WhatsAppMessage) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                userMsg = userMsg4;
                                z = false;
                                objInsertMessage = $result;
                                ((Number) objInsertMessage).longValue();
                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                return Unit.INSTANCE;
                            } catch (Throwable th4) {
                                th = th4;
                                z = false;
                                this.this$0.isGeneratingChatbotReply().setValue(Boxing.boxBoolean(z));
                                throw th;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        }
    }

    public final void sendChatbotMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (StringsKt.isBlank(text)) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C00061(text, this, null), 2, (Object) null);
    }
}
