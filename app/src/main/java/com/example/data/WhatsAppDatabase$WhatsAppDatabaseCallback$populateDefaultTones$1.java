package com.example.data;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: WhatsAppDatabase.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.data.WhatsAppDatabase$WhatsAppDatabaseCallback", f = "WhatsAppDatabase.kt", i = {0, BuildConfig.VERSION_CODE, 2, 3}, l = {52, 60, 68, 76}, m = "populateDefaultTones", n = {"dao", "dao", "dao", "dao"}, s = {"L$0", "L$0", "L$0", "L$0"})
final class WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WhatsAppDatabase.WhatsAppDatabaseCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1(WhatsAppDatabase.WhatsAppDatabaseCallback whatsAppDatabaseCallback, Continuation<? super WhatsAppDatabase$WhatsAppDatabaseCallback$populateDefaultTones$1> continuation) {
        super(continuation);
        this.this$0 = whatsAppDatabaseCallback;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.populateDefaultTones(null, (Continuation) this);
    }
}
