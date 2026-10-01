package com.example.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import com.example.BuildConfig;
import com.example.data.WhatsAppMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WhatsAppDashboard.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.WhatsAppDashboardKt$ChatbotTab$1$1", f = "WhatsAppDashboard.kt", i = {}, l = {1266}, m = "invokeSuspend", n = {}, s = {})
final class WhatsAppDashboardKt$ChatbotTab$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ State<List<WhatsAppMessage>> $messages$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WhatsAppDashboardKt$ChatbotTab$1$1(LazyListState lazyListState, State<? extends List<WhatsAppMessage>> state, Continuation<? super WhatsAppDashboardKt$ChatbotTab$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$messages$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WhatsAppDashboardKt$ChatbotTab$1$1(this.$listState, this.$messages$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!WhatsAppDashboardKt.ChatbotTab$lambda$188(this.$messages$delegate).isEmpty()) {
                    this.label = 1;
                    if (LazyListState.animateScrollToItem$default(this.$listState, WhatsAppDashboardKt.ChatbotTab$lambda$188(this.$messages$delegate).size() - 1, 0, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
