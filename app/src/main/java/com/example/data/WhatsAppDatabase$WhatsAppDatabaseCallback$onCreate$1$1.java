package com.example.data;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WhatsAppDatabase.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.data.WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1", f = "WhatsAppDatabase.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
final class WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WhatsAppDatabase $database;
    int label;
    final /* synthetic */ WhatsAppDatabase.WhatsAppDatabaseCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1(WhatsAppDatabase.WhatsAppDatabaseCallback whatsAppDatabaseCallback, WhatsAppDatabase whatsAppDatabase, Continuation<? super WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = whatsAppDatabaseCallback;
        this.$database = whatsAppDatabase;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WhatsAppDatabase$WhatsAppDatabaseCallback$onCreate$1$1(this.this$0, this.$database, continuation);
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
                if (this.this$0.populateDefaultTones(this.$database.dao(), (Continuation) this) == coroutine_suspended) {
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
