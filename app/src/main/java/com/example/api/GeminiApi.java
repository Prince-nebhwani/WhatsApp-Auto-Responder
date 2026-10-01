package com.example.api;

import com.example.BuildConfig;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: GeminiApi.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/example/api/GeminiApi;", "", "<init>", "()V", "TAG", "", "BASE_URL", "client", "Lokhttp3/OkHttpClient;", "generateReply", "messageText", "senderName", "toneInstructions", "conversationContext", "", "Lkotlin/Pair;", "", "modelOverride", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final class GeminiApi {
    private static final String BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/";
    private static final String TAG = "GeminiApi";
    public static final GeminiApi INSTANCE = new GeminiApi();
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    public static final int $stable = 8;

    private GeminiApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object generateReply$default(GeminiApi geminiApi, String str, String str2, String str3, List list, String str4, Continuation continuation, int i, Object obj) {
        List listEmptyList;
        String str5;
        if ((i & 8) == 0) {
            listEmptyList = list;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if ((i & 16) == 0) {
            str5 = str4;
        } else {
            str5 = null;
        }
        return geminiApi.generateReply(str, str2, str3, listEmptyList, str5, continuation);
    }

    /* JADX INFO: renamed from: com.example.api.GeminiApi$generateReply$2, reason: invalid class name */
    /* JADX INFO: compiled from: GeminiApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.api.GeminiApi$generateReply$2", f = "GeminiApi.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE}, l = {138, 149}, m = "invokeSuspend", n = {"apiKey", "requestJson", "requestBody", "modelsToTry", "lastErrorMsg", "model", "url", "request", "response\\11", "errBody\\11", "maxAttempts", "attempt", "$i$a$-use-GeminiApi$generateReply$2$3\\11\\112\\0", "apiKey", "requestJson", "requestBody", "modelsToTry", "lastErrorMsg", "model", "url", "request", "e", "maxAttempts", "attempt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ List<Pair<String, Boolean>> $conversationContext;
        final /* synthetic */ String $messageText;
        final /* synthetic */ String $modelOverride;
        final /* synthetic */ String $senderName;
        final /* synthetic */ String $toneInstructions;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<Pair<String, Boolean>> list, String str, String str2, String str3, String str4, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$conversationContext = list;
            this.$senderName = str;
            this.$modelOverride = str2;
            this.$toneInstructions = str3;
            this.$messageText = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$conversationContext, this.$senderName, this.$modelOverride, this.$toneInstructions, this.$messageText, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:126:0x04d3 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:135:0x050c  */
        /* JADX WARN: Code duplicated, block: B:138:0x051a A[Catch: all -> 0x0521, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0521, blocks: (B:114:0x0431, B:121:0x047a, B:138:0x051a, B:147:0x058b), top: B:226:0x047a }] */
        /* JADX WARN: Code duplicated, block: B:143:0x0536  */
        /* JADX WARN: Code duplicated, block: B:147:0x058b A[Catch: all -> 0x0521, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0521, blocks: (B:114:0x0431, B:121:0x047a, B:138:0x051a, B:147:0x058b), top: B:226:0x047a }] */
        /* JADX WARN: Code duplicated, block: B:158:0x0606 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:159:0x0607  */
        /* JADX WARN: Code duplicated, block: B:206:0x0799  */
        /* JADX WARN: Code duplicated, block: B:207:0x07af  */
        /* JADX WARN: Code duplicated, block: B:252:0x03d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:97:0x03d9 A[Catch: all -> 0x04f1, TRY_LEAVE, TryCatch #15 {all -> 0x04f1, blocks: (B:95:0x03d3, B:97:0x03d9), top: B:252:0x03d3 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:147:0x058b, B:152:0x059b], limit reached: 266 */
        /* JADX WARN: Path cross not found for [B:252:0x03d3, B:135:0x050c], limit reached: 266 */
        /* JADX WARN: Type inference failed for: r0v10, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r0v13, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object, org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v29 */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r20v1 */
        /* JADX WARN: Type inference failed for: r20v10 */
        /* JADX WARN: Type inference failed for: r20v11 */
        /* JADX WARN: Type inference failed for: r20v8 */
        /* JADX WARN: Type inference failed for: r20v9 */
        /* JADX WARN: Type inference failed for: r26v10 */
        /* JADX WARN: Type inference failed for: r26v11 */
        /* JADX WARN: Type inference failed for: r26v12 */
        /* JADX WARN: Type inference failed for: r26v13 */
        /* JADX WARN: Type inference failed for: r26v14 */
        /* JADX WARN: Type inference failed for: r26v15 */
        /* JADX WARN: Type inference failed for: r26v16 */
        /* JADX WARN: Type inference failed for: r26v17 */
        /* JADX WARN: Type inference failed for: r26v18 */
        /* JADX WARN: Type inference failed for: r26v19 */
        /* JADX WARN: Type inference failed for: r26v20 */
        /* JADX WARN: Type inference failed for: r26v21 */
        /* JADX WARN: Type inference failed for: r26v22 */
        /* JADX WARN: Type inference failed for: r26v23 */
        /* JADX WARN: Type inference failed for: r26v24 */
        /* JADX WARN: Type inference failed for: r26v25 */
        /* JADX WARN: Type inference failed for: r26v26 */
        /* JADX WARN: Type inference failed for: r26v27 */
        /* JADX WARN: Type inference failed for: r26v28 */
        /* JADX WARN: Type inference failed for: r26v29 */
        /* JADX WARN: Type inference failed for: r26v30 */
        /* JADX WARN: Type inference failed for: r26v31 */
        /* JADX WARN: Type inference failed for: r26v32 */
        /* JADX WARN: Type inference failed for: r26v33 */
        /* JADX WARN: Type inference failed for: r26v4 */
        /* JADX WARN: Type inference failed for: r26v5 */
        /* JADX WARN: Type inference failed for: r26v6 */
        /* JADX WARN: Type inference failed for: r26v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r26v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r26v9 */
        /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, org.json.JSONArray] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0620 -> B:205:0x0797). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x065f -> B:205:0x0797). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:202:0x077b -> B:203:0x0781). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:204:0x0789 -> B:205:0x0797). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instruction units count: 2074
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.api.GeminiApi.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object generateReply(String messageText, String senderName, String toneInstructions, List<Pair<String, Boolean>> list, String modelOverride, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(list, senderName, modelOverride, toneInstructions, messageText, null), continuation);
    }
}
