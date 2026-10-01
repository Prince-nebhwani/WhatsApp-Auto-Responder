package com.example.ui;

import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
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
@DebugMetadata(c = "com.example.ui.WhatsAppDashboardKt$WhatsAppDashboard$2$1", f = "WhatsAppDashboard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WhatsAppDashboardKt$WhatsAppDashboard$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $notificationPermissionLauncher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WhatsAppDashboardKt$WhatsAppDashboard$2$1(ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, Continuation<? super WhatsAppDashboardKt$WhatsAppDashboard$2$1> continuation) {
        super(2, continuation);
        this.$notificationPermissionLauncher = managedActivityResultLauncher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WhatsAppDashboardKt$WhatsAppDashboard$2$1(this.$notificationPermissionLauncher, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Build.VERSION.SDK_INT >= 33) {
                    this.$notificationPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
