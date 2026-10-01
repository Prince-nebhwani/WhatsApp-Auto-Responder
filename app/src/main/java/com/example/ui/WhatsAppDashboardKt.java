package com.example.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ExpandLessKt;
import androidx.compose.material.icons.filled.ExpandMoreKt;
import androidx.compose.material.icons.filled.ForumKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material.icons.filled.SmartToyKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material.icons.outlined.ChatBubbleOutlineKt;
import androidx.compose.material.icons.outlined.CircleKt;
import androidx.compose.material.icons.outlined.PsychologyKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationBarItemColors;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SuggestionChipDefaults;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.example.BuildConfig;
import com.example.data.PersonalityTone;
import com.example.data.ScheduledMessage;
import com.example.data.WhatsAppMessage;
import com.example.ui.theme.ColorKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WhatsAppDashboard.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a]\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a9\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u0010\u001e\u001a#\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\tH\u0007¢\u0006\u0002\u0010\"\u001a#\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u0010&\u001ah\u0010'\u001a\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2K\u0010)\u001aG\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010*H\u0007¢\u0006\u0002\u0010/\u001a?\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00142\f\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u00104\u001a\u000e\u00105\u001a\u00020\f2\u0006\u00106\u001a\u000207\u001a\u001f\u00108\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u00109\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\nH\u0007¢\u0006\u0002\u0010:¨\u0006;²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u008a\u0084\u0002²\u0006\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\tX\u008a\u0084\u0002²\u0006\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020\fX\u008a\u008e\u0002²\u0006\f\u0010>\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u008a\u0084\u0002²\u0006\n\u0010D\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010E\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010F\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010G\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010H\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"WhatsAppDashboard", "", "viewModel", "Lcom/example/ui/WhatsAppViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/example/ui/WhatsAppViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ChatsTab", "messages", "", "Lcom/example/data/WhatsAppMessage;", "isAutoReplyEnabled", "", "isGroupReplyEnabled", "tones", "Lcom/example/data/PersonalityTone;", "activeToneId", "", "onChatClick", "Lkotlin/Function1;", "", "(Lcom/example/ui/WhatsAppViewModel;Ljava/util/List;ZZLjava/util/List;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ChatRowItem", "chat", "Lcom/example/ui/LatestChatSummary;", "onClick", "Lkotlin/Function0;", "(Lcom/example/ui/LatestChatSummary;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PersonalitiesTab", "onAddToneClick", "(Lcom/example/ui/WhatsAppViewModel;Ljava/util/List;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SchedulerTab", "scheduledMessages", "Lcom/example/data/ScheduledMessage;", "(Lcom/example/ui/WhatsAppViewModel;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ScheduledRowItem", "msg", "onDelete", "(Lcom/example/data/ScheduledMessage;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddToneDialog", "onDismiss", "onSave", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "description", "prompt", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "ChatHistoryDetailDialog", "sender", "logs", "onDeleteAll", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "isNotificationServiceEnabled", "context", "Landroid/content/Context;", "ChatbotTab", "ChatBubble", "(Lcom/example/data/WhatsAppMessage;Landroidx/compose/runtime/Composer;I)V", "app", "currentTab", "showAddToneDialog", "selectedChatSender", "isPermissionGranted", "recipient", "messageText", "delayMinutesString", "selectedDelayPreset", "systemInstruction", "activeModel", "useChatbotForReplies", "isGenerating", "textInput", "showSettings"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WhatsAppDashboardKt {
    static final Unit AddToneDialog$lambda$172(Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        AddToneDialog(function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ChatBubble$lambda$252(WhatsAppMessage whatsAppMessage, int i, Composer composer, int i2) {
        ChatBubble(whatsAppMessage, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ChatHistoryDetailDialog$lambda$187(String str, List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ChatHistoryDetailDialog(str, list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ChatRowItem$lambda$100(LatestChatSummary latestChatSummary, Function0 function0, int i, Composer composer, int i2) {
        ChatRowItem(latestChatSummary, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$244(WhatsAppViewModel whatsAppViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ChatbotTab(whatsAppViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ChatsTab$lambda$89(WhatsAppViewModel whatsAppViewModel, List list, boolean z, boolean z2, List list2, int i, Function1 function1, int i2, Composer composer, int i3) {
        ChatsTab(whatsAppViewModel, list, z, z2, list2, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit PersonalitiesTab$lambda$108(WhatsAppViewModel whatsAppViewModel, List list, int i, Function0 function0, int i2, Composer composer, int i3) {
        PersonalitiesTab(whatsAppViewModel, list, i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ScheduledRowItem$lambda$150(ScheduledMessage scheduledMessage, Function0 function0, int i, Composer composer, int i2) {
        ScheduledRowItem(scheduledMessage, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$142(WhatsAppViewModel whatsAppViewModel, List list, int i, Composer composer, int i2) {
        SchedulerTab(whatsAppViewModel, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$60(WhatsAppViewModel whatsAppViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WhatsAppDashboard(whatsAppViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x043d  */
    /* JADX WARN: Code duplicated, block: B:103:0x045f  */
    /* JADX WARN: Code duplicated, block: B:106:0x046a  */
    /* JADX WARN: Code duplicated, block: B:107:0x046c  */
    /* JADX WARN: Code duplicated, block: B:112:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:121:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0289  */
    /* JADX WARN: Code duplicated, block: B:73:0x0324  */
    /* JADX WARN: Code duplicated, block: B:75:0x034a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0358  */
    /* JADX WARN: Code duplicated, block: B:86:0x039f  */
    /* JADX WARN: Code duplicated, block: B:89:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:90:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:93:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:95:0x0401  */
    /* JADX WARN: Code duplicated, block: B:99:0x042f  */
    public static final void WhatsAppDashboard(final WhatsAppViewModel viewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Object objMutableIntStateOf;
        Object objMutableStateOf$default;
        Object objMutableStateOf$default2;
        Object objMutableStateOf$default3;
        Object obj;
        Object obj2;
        LifecycleOwner lifecycleOwner;
        WhatsAppDashboardKt$WhatsAppDashboard$2$1 whatsAppDashboardKt$WhatsAppDashboard$2$1;
        final MutableState showAddToneDialog$delegate;
        final WhatsAppViewModel whatsAppViewModel;
        String str;
        String strWhatsAppDashboard$lambda$13;
        Iterable iterableWhatsAppDashboard$lambda$0;
        Collection arrayList;
        Object objRememberedValue;
        Function0 function0;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Function0 function1;
        Object obj3;
        Composer $composer2;
        Object objRememberedValue3;
        Object obj4;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer3 = $composer.startRestartGroup(1505967044);
        ComposerKt.sourceInformation($composer3, "C(WhatsAppDashboard)P(1)55@2189L7,58@2274L29,59@2364L29,60@2430L29,61@2519L29,62@2610L29,63@2687L29,66@2768L33,69@2875L34,71@2989L42,74@3101L66,77@3287L7,78@3322L368,78@3299L391,93@3900L8,91@3796L112,95@3935L184,95@3914L205,177@7551L11,104@4275L1535,142@5832L1678,179@7623L6111,103@4248L9486:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            whatsAppViewModel = viewModel;
            $composer2 = $composer3;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1505967044, $dirty, -1, "com.example.ui.WhatsAppDashboard (WhatsAppDashboard.kt:54)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Context context = (Context) objConsume;
            final State messages$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllMessages(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            final State scheduledMessages$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllScheduledMessages(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            final State tones$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllTones(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            final State isAutoReplyEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.isAutoReplyEnabled(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            final State isGroupReplyEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.isGroupReplyEnabled(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            final State activeToneId$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getActiveToneId(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 0, 7);
            ComposerKt.sourceInformationMarkerStart($composer3, -169625211, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue5 = $composer3.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objMutableIntStateOf = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(objMutableIntStateOf);
            } else {
                objMutableIntStateOf = objRememberedValue5;
            }
            final MutableIntState currentTab$delegate = (MutableIntState) objMutableIntStateOf;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -169621786, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue6 = $composer3.rememberedValue();
            if (objRememberedValue6 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue6;
            }
            final MutableState showAddToneDialog$delegate2 = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -169618130, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue7 = $composer3.rememberedValue();
            if (objRememberedValue7 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default2);
            } else {
                objMutableStateOf$default2 = objRememberedValue7;
            }
            final MutableState selectedChatSender$delegate = (MutableState) objMutableStateOf$default2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -169614522, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue8 = $composer3.rememberedValue();
            if (objRememberedValue8 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isNotificationServiceEnabled(context)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default3);
            } else {
                objMutableStateOf$default3 = objRememberedValue8;
            }
            final MutableState isPermissionGranted$delegate = (MutableState) objMutableStateOf$default3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final LifecycleOwner lifecycleOwner2 = (LifecycleOwner) objConsume2;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -169607148, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChangedInstance3 = $composer3.changedInstance(context) | $composer3.changedInstance(lifecycleOwner2);
            Object objRememberedValue9 = $composer3.rememberedValue();
            if (zChangedInstance3 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda61
                    public final Object invoke(Object obj5) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$21$lambda$20(lifecycleOwner2, context, isPermissionGranted$delegate, (DisposableEffectScope) obj5);
                    }
                };
                $composer3.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(unit, (Function1) obj, $composer3, 6);
            ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart($composer3, -169589012, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue10 = $composer3.rememberedValue();
            if (objRememberedValue10 == Composer.Companion.getEmpty()) {
                obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda62
                    public final Object invoke(Object obj5) {
                        ((Boolean) obj5).booleanValue();
                        return Unit.INSTANCE;
                    }
                };
                $composer3.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue10;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ManagedActivityResultLauncher notificationPermissionLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) obj2, $composer3, 48);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -169587716, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChangedInstance4 = $composer3.changedInstance(notificationPermissionLauncher);
            Object objRememberedValue11 = $composer3.rememberedValue();
            if (!zChangedInstance4) {
                lifecycleOwner = lifecycleOwner2;
                if (objRememberedValue11 != Composer.Companion.getEmpty()) {
                    whatsAppDashboardKt$WhatsAppDashboard$2$1 = objRememberedValue11;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit2, (Function2) whatsAppDashboardKt$WhatsAppDashboard$2$1, $composer3, 6);
                final boolean isApiKeyConfigured = BuildConfig.GEMINI_API_KEY.length() > 0;
                long j = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getBackground-0d7_KjU();
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1392603008, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda63
                    public final Object invoke(Object obj5, Object obj6) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$26(isApiKeyConfigured, isPermissionGranted$delegate, isAutoReplyEnabled$delegate, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                }, $composer3, 54);
                Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(246062495, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda64
                    public final Object invoke(Object obj5, Object obj6) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36(currentTab$delegate, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                }, $composer3, 54);
                Modifier modifier4 = modifier3;
                Function3 function3 = new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda65
                    public final Object invoke(Object obj5, Object obj6, Object obj7) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48(isApiKeyConfigured, isPermissionGranted$delegate, context, currentTab$delegate, viewModel, messages$delegate, isAutoReplyEnabled$delegate, isGroupReplyEnabled$delegate, tones$delegate, activeToneId$delegate, selectedChatSender$delegate, showAddToneDialog$delegate2, scheduledMessages$delegate, (PaddingValues) obj5, (Composer) obj6, ((Integer) obj7).intValue());
                    }
                };
                showAddToneDialog$delegate = showAddToneDialog$delegate2;
                whatsAppViewModel = viewModel;
                ScaffoldKt.Scaffold-TvnljyQ(modifierFillMaxSize$default, function2RememberComposableLambda, function2RememberComposableLambda2, (Function2) null, (Function2) null, 0, j, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-688259563, true, function3, $composer3, 54), $composer3, 805306800, 440);
                if (WhatsAppDashboard$lambda$10(showAddToneDialog$delegate)) {
                    $composer3.startReplaceGroup(-952477474);
                    ComposerKt.sourceInformation($composer3, "307@13835L29,308@13887L139,306@13796L240");
                    str = "CC(remember):WhatsAppDashboard.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer3, -169271071, str);
                    objRememberedValue3 = $composer3.rememberedValue();
                    if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                        obj4 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda67
                            public final Object invoke() {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$50$lambda$49(showAddToneDialog$delegate);
                            }
                        };
                        $composer3.updateRememberedValue(obj4);
                    } else {
                        obj4 = objRememberedValue3;
                    }
                    Function0 function2 = (Function0) obj4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, -169269297, str);
                    zChangedInstance2 = $composer3.changedInstance(whatsAppViewModel);
                    objRememberedValue4 = $composer3.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                        objRememberedValue4 = new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda68
                            public final Object invoke(Object obj5, Object obj6, Object obj7) {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$52$lambda$51(whatsAppViewModel, showAddToneDialog$delegate, (String) obj5, (String) obj6, (String) obj7);
                            }
                        };
                        $composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    AddToneDialog(function2, (Function3) objRememberedValue4, $composer3, 6);
                } else {
                    str = "CC(remember):WhatsAppDashboard.kt#9igjgp";
                    $composer3.startReplaceGroup(-966162114);
                }
                $composer3.endReplaceGroup();
                strWhatsAppDashboard$lambda$13 = WhatsAppDashboard$lambda$13(selectedChatSender$delegate);
                if (strWhatsAppDashboard$lambda$13 == null) {
                    $composer3.startReplaceGroup(-952159787);
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceGroup(-952159786);
                    ComposerKt.sourceInformation($composer3, "*321@14296L29,322@14353L125,318@14189L299");
                    iterableWhatsAppDashboard$lambda$0 = WhatsAppDashboard$lambda$0(messages$delegate);
                    arrayList = new ArrayList();
                    for (Object obj5 : iterableWhatsAppDashboard$lambda$0) {
                        MutableState showAddToneDialog$delegate3 = showAddToneDialog$delegate;
                        Iterable iterable = iterableWhatsAppDashboard$lambda$0;
                        if (Intrinsics.areEqual(((WhatsAppMessage) obj5).getSender(), strWhatsAppDashboard$lambda$13)) {
                            arrayList.add(obj5);
                        }
                        showAddToneDialog$delegate = showAddToneDialog$delegate3;
                        iterableWhatsAppDashboard$lambda$0 = iterable;
                    }
                    final List list = (List) arrayList;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1874739617, str);
                    objRememberedValue = $composer3.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda69
                            public final Object invoke() {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$59$lambda$55$lambda$54(selectedChatSender$delegate);
                            }
                        };
                        $composer3.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1874737697, str);
                    zChangedInstance = $composer3.changedInstance(list) | $composer3.changedInstance(whatsAppViewModel);
                    objRememberedValue2 = $composer3.rememberedValue();
                    if (!zChangedInstance) {
                        function1 = function0;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            obj3 = objRememberedValue2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ChatHistoryDetailDialog(strWhatsAppDashboard$lambda$13, list, function1, (Function0) obj3, $composer3, 384);
                        $composer2 = $composer3;
                        Unit unit3 = Unit.INSTANCE;
                        $composer2.endReplaceGroup();
                        Unit unit4 = Unit.INSTANCE;
                    } else {
                        function1 = function0;
                    }
                    obj3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda70
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$59$lambda$58$lambda$57(list, whatsAppViewModel, selectedChatSender$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(obj3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ChatHistoryDetailDialog(strWhatsAppDashboard$lambda$13, list, function1, (Function0) obj3, $composer3, 384);
                    $composer2 = $composer3;
                    Unit unit5 = Unit.INSTANCE;
                    $composer2.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                lifecycleOwner = lifecycleOwner2;
            }
            whatsAppDashboardKt$WhatsAppDashboard$2$1 = new WhatsAppDashboardKt$WhatsAppDashboard$2$1(notificationPermissionLauncher, null);
            $composer3.updateRememberedValue(whatsAppDashboardKt$WhatsAppDashboard$2$1);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit2, (Function2) whatsAppDashboardKt$WhatsAppDashboard$2$1, $composer3, 6);
            final boolean isApiKeyConfigured2 = BuildConfig.GEMINI_API_KEY.length() > 0;
            long j2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getBackground-0d7_KjU();
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1392603008, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda63
                public final Object invoke(Object obj6, Object obj7) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$26(isApiKeyConfigured2, isPermissionGranted$delegate, isAutoReplyEnabled$delegate, (Composer) obj6, ((Integer) obj7).intValue());
                }
            }, $composer3, 54);
            Function2 function2RememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(246062495, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda64
                public final Object invoke(Object obj6, Object obj7) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36(currentTab$delegate, (Composer) obj6, ((Integer) obj7).intValue());
                }
            }, $composer3, 54);
            Modifier modifier5 = modifier3;
            Function3 function4 = new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda65
                public final Object invoke(Object obj6, Object obj7, Object obj8) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48(isApiKeyConfigured2, isPermissionGranted$delegate, context, currentTab$delegate, viewModel, messages$delegate, isAutoReplyEnabled$delegate, isGroupReplyEnabled$delegate, tones$delegate, activeToneId$delegate, selectedChatSender$delegate, showAddToneDialog$delegate2, scheduledMessages$delegate, (PaddingValues) obj6, (Composer) obj7, ((Integer) obj8).intValue());
                }
            };
            showAddToneDialog$delegate = showAddToneDialog$delegate2;
            whatsAppViewModel = viewModel;
            ScaffoldKt.Scaffold-TvnljyQ(modifierFillMaxSize$default2, function2RememberComposableLambda3, function2RememberComposableLambda4, (Function2) null, (Function2) null, 0, j2, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-688259563, true, function4, $composer3, 54), $composer3, 805306800, 440);
            if (WhatsAppDashboard$lambda$10(showAddToneDialog$delegate)) {
                $composer3.startReplaceGroup(-952477474);
                ComposerKt.sourceInformation($composer3, "307@13835L29,308@13887L139,306@13796L240");
                str = "CC(remember):WhatsAppDashboard.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, -169271071, str);
                objRememberedValue3 = $composer3.rememberedValue();
                if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    obj4 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda67
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$50$lambda$49(showAddToneDialog$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(obj4);
                } else {
                    obj4 = objRememberedValue3;
                }
                Function0 function5 = (Function0) obj4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -169269297, str);
                zChangedInstance2 = $composer3.changedInstance(whatsAppViewModel);
                objRememberedValue4 = $composer3.rememberedValue();
                if (!zChangedInstance2) {
                }
                objRememberedValue4 = new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda68
                    public final Object invoke(Object obj6, Object obj7, Object obj8) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$52$lambda$51(whatsAppViewModel, showAddToneDialog$delegate, (String) obj6, (String) obj7, (String) obj8);
                    }
                };
                $composer3.updateRememberedValue(objRememberedValue4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                AddToneDialog(function5, (Function3) objRememberedValue4, $composer3, 6);
            } else {
                str = "CC(remember):WhatsAppDashboard.kt#9igjgp";
                $composer3.startReplaceGroup(-966162114);
            }
            $composer3.endReplaceGroup();
            strWhatsAppDashboard$lambda$13 = WhatsAppDashboard$lambda$13(selectedChatSender$delegate);
            if (strWhatsAppDashboard$lambda$13 == null) {
                $composer3.startReplaceGroup(-952159787);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(-952159786);
                ComposerKt.sourceInformation($composer3, "*321@14296L29,322@14353L125,318@14189L299");
                iterableWhatsAppDashboard$lambda$0 = WhatsAppDashboard$lambda$0(messages$delegate);
                arrayList = new ArrayList();
                while (r18.hasNext()) {
                    MutableState showAddToneDialog$delegate4 = showAddToneDialog$delegate;
                    Iterable iterable2 = iterableWhatsAppDashboard$lambda$0;
                    if (Intrinsics.areEqual(((WhatsAppMessage) obj5).getSender(), strWhatsAppDashboard$lambda$13)) {
                        arrayList.add(obj5);
                    }
                    showAddToneDialog$delegate = showAddToneDialog$delegate4;
                    iterableWhatsAppDashboard$lambda$0 = iterable2;
                }
                final List list2 = (List) arrayList;
                ComposerKt.sourceInformationMarkerStart($composer3, -1874739617, str);
                objRememberedValue = $composer3.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda69
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$59$lambda$55$lambda$54(selectedChatSender$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1874737697, str);
                zChangedInstance = $composer3.changedInstance(list2) | $composer3.changedInstance(whatsAppViewModel);
                objRememberedValue2 = $composer3.rememberedValue();
                if (!zChangedInstance) {
                    function1 = function0;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        obj3 = objRememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ChatHistoryDetailDialog(strWhatsAppDashboard$lambda$13, list2, function1, (Function0) obj3, $composer3, 384);
                    $composer2 = $composer3;
                    Unit unit7 = Unit.INSTANCE;
                    $composer2.endReplaceGroup();
                    Unit unit8 = Unit.INSTANCE;
                } else {
                    function1 = function0;
                }
                obj3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda70
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$59$lambda$58$lambda$57(list2, whatsAppViewModel, selectedChatSender$delegate);
                    }
                };
                $composer3.updateRememberedValue(obj3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ChatHistoryDetailDialog(strWhatsAppDashboard$lambda$13, list2, function1, (Function0) obj3, $composer3, 384);
                $composer2 = $composer3;
                Unit unit9 = Unit.INSTANCE;
                $composer2.endReplaceGroup();
                Unit unit10 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda71
                public final Object invoke(Object obj6, Object obj7) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$60(whatsAppViewModel, modifier2, $changed, i, (Composer) obj6, ((Integer) obj7).intValue());
                }
            });
        }
    }

    private static final List<WhatsAppMessage> WhatsAppDashboard$lambda$0(State<? extends List<WhatsAppMessage>> state) {
        return (List) state.getValue();
    }

    private static final List<ScheduledMessage> WhatsAppDashboard$lambda$1(State<? extends List<ScheduledMessage>> state) {
        return (List) state.getValue();
    }

    private static final List<PersonalityTone> WhatsAppDashboard$lambda$2(State<? extends List<PersonalityTone>> state) {
        return (List) state.getValue();
    }

    private static final boolean WhatsAppDashboard$lambda$3(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean WhatsAppDashboard$lambda$4(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final int WhatsAppDashboard$lambda$5(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final int WhatsAppDashboard$lambda$7(MutableIntState $currentTab$delegate) {
        return ((IntState) $currentTab$delegate).getIntValue();
    }

    private static final boolean WhatsAppDashboard$lambda$10(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void WhatsAppDashboard$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String WhatsAppDashboard$lambda$13(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final boolean WhatsAppDashboard$lambda$16(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void WhatsAppDashboard$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final DisposableEffectResult WhatsAppDashboard$lambda$21$lambda$20(final LifecycleOwner $lifecycleOwner, final Context $context, final MutableState $isPermissionGranted$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda72
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                WhatsAppDashboardKt.WhatsAppDashboard$lambda$21$lambda$20$lambda$18($context, $isPermissionGranted$delegate, lifecycleOwner, event);
            }
        };
        $lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: com.example.ui.WhatsAppDashboardKt$WhatsAppDashboard$lambda$21$lambda$20$$inlined$onDispose$1
            public void dispose() {
                $lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    static final void WhatsAppDashboard$lambda$21$lambda$20$lambda$18(Context $context, MutableState $isPermissionGranted$delegate, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            WhatsAppDashboard$lambda$17($isPermissionGranted$delegate, isNotificationServiceEnabled($context));
        }
    }

    static final Unit WhatsAppDashboard$lambda$26(final boolean $isApiKeyConfigured, final MutableState $isPermissionGranted$delegate, final State $isAutoReplyEnabled$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C120@4947L681,138@5746L11,137@5673L113,105@4289L1511:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392603008, $changed, -1, "com.example.ui.WhatsAppDashboard.<anonymous> (WhatsAppDashboard.kt:105)");
            }
            AppBarKt.LargeTopAppBar-oKE7A98(ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$181000871$app(), (Modifier) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1748717476, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$26$lambda$25($isApiKeyConfigured, $isPermissionGranted$delegate, $isAutoReplyEnabled$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), 0.0f, 0.0f, (WindowInsets) null, TopAppBarDefaults.INSTANCE.largeTopAppBarColors-zjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU(), 0L, 0L, 0L, 0L, $composer, TopAppBarDefaults.$stable << 15, 30), (TopAppBarScrollBehavior) null, $composer, 3078, 374);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$26$lambda$25(boolean $isApiKeyConfigured, MutableState $isPermissionGranted$delegate, State $isAutoReplyEnabled$delegate, RowScope $this$LargeTopAppBar, Composer $composer, int $changed) {
        long alertYellow;
        Intrinsics.checkNotNullParameter($this$LargeTopAppBar, "$this$LargeTopAppBar");
        ComposerKt.sourceInformation($composer, "C129@5349L261:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1748717476, $changed, -1, "com.example.ui.WhatsAppDashboard.<anonymous>.<anonymous> (WhatsAppDashboard.kt:122)");
            }
            if (WhatsAppDashboard$lambda$16($isPermissionGranted$delegate) && $isApiKeyConfigured && WhatsAppDashboard$lambda$3($isAutoReplyEnabled$delegate)) {
                alertYellow = ColorKt.getSuccessGreen();
            } else {
                alertYellow = (WhatsAppDashboard$lambda$16($isPermissionGranted$delegate) && $isApiKeyConfigured) ? ColorKt.getAlertYellow() : ColorKt.getErrorRed();
            }
            long statusColor = alertYellow;
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(16), 0.0f, 11, (Object) null), Dp.constructor-impl(12)), RoundedCornerShapeKt.getCircleShape()), statusColor, (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36(final MutableIntState $currentTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C144@5908L11,145@5998L14,146@6028L1472,143@5846L1654:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246062495, $changed, -1, "com.example.ui.WhatsAppDashboard.<anonymous> (WhatsAppDashboard.kt:143)");
            }
            NavigationBarKt.NavigationBar-HsRjFd4(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer, 6)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface-0d7_KjU(), 0L, 0.0f, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1670428312, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda60
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36$lambda$35($currentTab$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196608, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36$lambda$35(final MutableIntState $currentTab$delegate, RowScope $this$NavigationBar, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter($this$NavigationBar, "$this$NavigationBar");
        ComposerKt.sourceInformation($composer, "C149@6143L18,147@6046L334,156@6494L18,154@6397L346,163@6857L18,161@6760L361,170@7235L18,168@7138L348:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$NavigationBar) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1670428312, $dirty2, -1, "com.example.ui.WhatsAppDashboard.<anonymous>.<anonymous> (WhatsAppDashboard.kt:147)");
            }
            boolean z = WhatsAppDashboard$lambda$7($currentTab$delegate) == 0;
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.Companion, "nav_chats_tab");
            ComposerKt.sourceInformationMarkerStart($composer, -1036157174, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36$lambda$35$lambda$28$lambda$27($currentTab$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem($this$NavigationBar, z, (Function0) obj, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$748742419$app(), modifierTestTag, false, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m13getLambda$234369898$app(), false, (NavigationBarItemColors) null, (MutableInteractionSource) null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z2 = WhatsAppDashboard$lambda$7($currentTab$delegate) == 1;
            Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.Companion, "nav_chatbot_tab");
            ComposerKt.sourceInformationMarkerStart($composer, -1036145942, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue2 = $composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36$lambda$35$lambda$30$lambda$29($currentTab$delegate);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem($this$NavigationBar, z2, (Function0) obj2, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m12getLambda$1823756484$app(), modifierTestTag2, false, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m10getLambda$1701888001$app(), false, (NavigationBarItemColors) null, (MutableInteractionSource) null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z3 = WhatsAppDashboard$lambda$7($currentTab$delegate) == 2;
            Modifier modifierTestTag3 = TestTagKt.testTag(Modifier.Companion, "nav_personality_tab");
            ComposerKt.sourceInformationMarkerStart($composer, -1036134326, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue3 = $composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                obj3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36$lambda$35$lambda$32$lambda$31($currentTab$delegate);
                    }
                };
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = objRememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem($this$NavigationBar, z3, (Function0) obj3, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m18getLambda$641523749$app(), modifierTestTag3, false, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m14getLambda$519655266$app(), false, (NavigationBarItemColors) null, (MutableInteractionSource) null, $composer, ($dirty2 & 14) | 1600896, 464);
            boolean z4 = WhatsAppDashboard$lambda$7($currentTab$delegate) == 3;
            Modifier modifierTestTag4 = TestTagKt.testTag(Modifier.Companion, "nav_scheduler_tab");
            ComposerKt.sourceInformationMarkerStart($composer, -1036122230, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue4 = $composer.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                obj4 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$36$lambda$35$lambda$34$lambda$33($currentTab$delegate);
                    }
                };
                $composer.updateRememberedValue(obj4);
            } else {
                obj4 = objRememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            NavigationBarKt.NavigationBarItem($this$NavigationBar, z4, (Function0) obj4, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$540708986$app(), modifierTestTag4, false, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$662577469$app(), false, (NavigationBarItemColors) null, (MutableInteractionSource) null, $composer, ($dirty2 & 14) | 1600896, 464);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36$lambda$35$lambda$28$lambda$27(MutableIntState $currentTab$delegate) {
        $currentTab$delegate.setIntValue(0);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36$lambda$35$lambda$30$lambda$29(MutableIntState $currentTab$delegate) {
        $currentTab$delegate.setIntValue(1);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36$lambda$35$lambda$32$lambda$31(MutableIntState $currentTab$delegate) {
        $currentTab$delegate.setIntValue(2);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$36$lambda$35$lambda$34$lambda$33(MutableIntState $currentTab$delegate) {
        $currentTab$delegate.setIntValue(3);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$48(boolean $isApiKeyConfigured, MutableState $isPermissionGranted$delegate, final Context $context, MutableIntState $currentTab$delegate, final WhatsAppViewModel $viewModel, final State $messages$delegate, final State $isAutoReplyEnabled$delegate, final State $isGroupReplyEnabled$delegate, final State $tones$delegate, final State $activeToneId$delegate, final MutableState $selectedChatSender$delegate, final MutableState $showAddToneDialog$delegate, final State $scheduledMessages$delegate, PaddingValues innerPadding, Composer $composer, int $changed) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C180@7649L6079:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if (($dirty & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-688259563, $dirty, -1, "com.example.ui.WhatsAppDashboard.<anonymous> (WhatsAppDashboard.kt:180)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            Composer composer2 = $composer;
            ComposerKt.sourceInformationMarkerStart(composer2, -1566665280, "C275@12651L1067,275@12590L1128:WhatsAppDashboard.kt#naom5h");
            if (WhatsAppDashboard$lambda$16($isPermissionGranted$delegate)) {
                composer2.startReplaceGroup(-1574654601);
            } else {
                composer2.startReplaceGroup(-1566736488);
                ComposerKt.sourceInformation(composer2, "189@8004L11,189@7962L69,195@8295L2306,188@7914L2687");
                CardKt.Card(TestTagKt.testTag(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), "permission_warning_card"), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getErrorContainer-0d7_KjU(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(113632984, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda38
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41($context, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 196614, 24);
            }
            composer2.endReplaceGroup();
            if ($isApiKeyConfigured) {
                composer2.startReplaceGroup(-1574654601);
            } else {
                composer2.startReplaceGroup(-1564026282);
                ComposerKt.sourceInformation(composer2, "240@10720L59,242@10878L20,239@10672L1857");
                CardKt.Card(TestTagKt.testTag(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), "api_key_warning_card"), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(ColorKt.getAlertYellow(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, composer2, (CardDefaults.$stable << 12) | 6, 14), (CardElevation) null, BorderStroke.copy-D5KLDUw$default(CardDefaults.INSTANCE.outlinedCardBorder(false, composer2, CardDefaults.$stable << 3, 1), 0.0f, Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.getAlertYellow()), Color.box-impl(ColorKt.getAlertYellow())}), 0L, 0L, 0, 14, (Object) null), 1, (Object) null), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1503363791$app(), composer2, 196614, 8);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            CrossfadeKt.Crossfade(Integer.valueOf(WhatsAppDashboard$lambda$7($currentTab$delegate)), (Modifier) null, (FiniteAnimationSpec) null, "TabTransition", ComposableLambdaKt.rememberComposableLambda(227520145, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda39
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$46($viewModel, $messages$delegate, $isAutoReplyEnabled$delegate, $isGroupReplyEnabled$delegate, $tones$delegate, $activeToneId$delegate, $selectedChatSender$delegate, $showAddToneDialog$delegate, $scheduledMessages$delegate, ((Integer) obj).intValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 27648, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:31:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:32:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:35:0x0208  */
    /* JADX WARN: Code duplicated, block: B:38:0x021b  */
    /* JADX WARN: Code duplicated, block: B:39:0x021e  */
    /* JADX WARN: Code duplicated, block: B:43:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:47:0x03db  */
    /* JADX WARN: Code duplicated, block: B:50:0x0428  */
    static final Unit WhatsAppDashboard$lambda$48$lambda$47$lambda$41(final Context $context, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        int i;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer;
        Composer composer2;
        boolean zChangedInstance;
        Object obj;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C196@8317L2266:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113632984, $changed, -1, "com.example.ui.WhatsAppDashboard.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:196)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor2;
                $composer.createNode(function0);
            } else {
                function0 = constructor2;
                $composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting()) {
                i = 6;
            } else {
                i = 6;
                if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i4 = ((i >> 6) & 112) | 6;
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -415476458, "C197@8386L839,212@9250L40,215@9506L10,216@9578L11,213@9315L317,218@9657L41,229@10345L11,229@10301L62,220@9769L478,219@9723L838:WhatsAppDashboard.kt#naom5h");
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier2 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier2);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i5 = ((((384 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer.useNode();
                }
                composer = Updater.constructor-impl($composer);
                Updater.set-impl(composer, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer.getInserting()) {
                    composer2 = $composer;
                } else {
                    composer2 = $composer;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    }
                    Updater.set-impl(composer, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    int i6 = (i5 >> 6) & 14;
                    Composer composer4 = composer2;
                    ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i7 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer4, -439999274, "C201@8660L11,198@8468L304,204@8801L40,208@9063L11,209@9147L10,205@8870L329:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), "Warning", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getError-0d7_KjU(), composer4, 432, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer4, 6);
                    TextKt.Text--4IGK_g("Notification Access Required", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getTitleMedium(), composer4, 196614, 0, 65498);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                    TextKt.Text--4IGK_g("This app must read incoming notifications to auto-reply. Please grant access in System Settings.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                    ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
                    Modifier modifierAlign = columnScope.align(Modifier.Companion, Alignment.Companion.getEnd());
                    ComposerKt.sourceInformationMarkerStart($composer, -567549236, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance = $composer.changedInstance($context);
                    Object objRememberedValue = $composer.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                            public final Object invoke() {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ButtonKt.Button((Function0) obj, modifierAlign, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1526848574$app(), $composer, 805306368, 492);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.set-impl(composer, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i8 = (i5 >> 6) & 14;
                Composer composer5 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i9 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer5, -439999274, "C201@8660L11,198@8468L304,204@8801L40,208@9063L11,209@9147L10,205@8870L329:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), "Warning", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getError-0d7_KjU(), composer5, 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer5, 6);
                TextKt.Text--4IGK_g("Notification Access Required", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getTitleMedium(), composer5, 196614, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                TextKt.Text--4IGK_g("This app must read incoming notifications to auto-reply. Please grant access in System Settings.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                ButtonColors buttonColors2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
                Modifier modifierAlign2 = columnScope.align(Modifier.Companion, Alignment.Companion.getEnd());
                ComposerKt.sourceInformationMarkerStart($composer, -567549236, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer.changedInstance($context);
                Object objRememberedValue2 = $composer.rememberedValue();
                if (zChangedInstance) {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) obj, modifierAlign2, false, (Shape) null, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1526848574$app(), $composer, 805306368, 492);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i10 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i11 = ((i >> 6) & 112) | 6;
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -415476458, "C197@8386L839,212@9250L40,215@9506L10,216@9578L11,213@9315L317,218@9657L41,229@10345L11,229@10301L62,220@9769L478,219@9723L838:WhatsAppDashboard.kt#naom5h");
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier3 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifier3);
            constructor = ComposeUiNode.Companion.getConstructor();
            int i12 = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor;
                $composer.createNode(function1);
            } else {
                function1 = constructor;
                $composer.useNode();
            }
            composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting()) {
                composer2 = $composer;
                if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.set-impl(composer, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i13 = (i12 >> 6) & 14;
                Composer composer6 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer6, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                int i14 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer6, -439999274, "C201@8660L11,198@8468L304,204@8801L40,208@9063L11,209@9147L10,205@8870L329:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), "Warning", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getError-0d7_KjU(), composer6, 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer6, 6);
                TextKt.Text--4IGK_g("Notification Access Required", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getTitleMedium(), composer6, 196614, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                TextKt.Text--4IGK_g("This app must read incoming notifications to auto-reply. Please grant access in System Settings.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                ButtonColors buttonColors3 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
                Modifier modifierAlign3 = columnScope2.align(Modifier.Companion, Alignment.Companion.getEnd());
                ComposerKt.sourceInformationMarkerStart($composer, -567549236, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer.changedInstance($context);
                Object objRememberedValue3 = $composer.rememberedValue();
                if (zChangedInstance) {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                        public final Object invoke() {
                            return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) obj, modifierAlign3, false, (Shape) null, buttonColors3, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1526848574$app(), $composer, 805306368, 492);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = $composer;
            }
            composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.set-impl(composer, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            int i15 = (i12 >> 6) & 14;
            Composer composer7 = composer2;
            ComposerKt.sourceInformationMarkerStart(composer7, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope4 = RowScopeInstance.INSTANCE;
            int i16 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer7, -439999274, "C201@8660L11,198@8468L304,204@8801L40,208@9063L11,209@9147L10,205@8870L329:WhatsAppDashboard.kt#naom5h");
            IconKt.Icon-ww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), "Warning", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getError-0d7_KjU(), composer7, 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer7, 6);
            TextKt.Text--4IGK_g("Notification Access Required", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getTitleMedium(), composer7, 196614, 0, 65498);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            TextKt.Text--4IGK_g("This app must read incoming notifications to auto-reply. Please grant access in System Settings.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnErrorContainer-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            ButtonColors buttonColors4 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
            Modifier modifierAlign4 = columnScope2.align(Modifier.Companion, Alignment.Companion.getEnd());
            ComposerKt.sourceInformationMarkerStart($composer, -567549236, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance = $composer.changedInstance($context);
            Object objRememberedValue4 = $composer.rememberedValue();
            if (zChangedInstance) {
                obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda73
                    public final Object invoke() {
                        return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38($context);
                    }
                };
                $composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, modifierAlign4, false, (Shape) null, buttonColors4, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1526848574$app(), $composer, 805306368, 492);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$48$lambda$47$lambda$41$lambda$40$lambda$39$lambda$38(Context $context) {
        try {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            $context.startActivity(intent);
        } catch (Exception e) {
            Intent intent2 = new Intent("android.settings.SETTINGS");
            $context.startActivity(intent2);
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$48$lambda$47$lambda$46(WhatsAppViewModel $viewModel, State $messages$delegate, State $isAutoReplyEnabled$delegate, State $isGroupReplyEnabled$delegate, State $tones$delegate, State $activeToneId$delegate, final MutableState $selectedChatSender$delegate, final MutableState $showAddToneDialog$delegate, State $scheduledMessages$delegate, int tabIndex, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposerKt.sourceInformation($composer, "C:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(tabIndex) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(227520145, $dirty2, -1, "com.example.ui.WhatsAppDashboard.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:276)");
            }
            switch (tabIndex) {
                case 0:
                    $composer.startReplaceGroup(-396470002);
                    ComposerKt.sourceInformation($composer, "284@13088L27,277@12724L413");
                    List<WhatsAppMessage> listWhatsAppDashboard$lambda$0 = WhatsAppDashboard$lambda$0($messages$delegate);
                    boolean zWhatsAppDashboard$lambda$3 = WhatsAppDashboard$lambda$3($isAutoReplyEnabled$delegate);
                    boolean zWhatsAppDashboard$lambda$4 = WhatsAppDashboard$lambda$4($isGroupReplyEnabled$delegate);
                    List<PersonalityTone> listWhatsAppDashboard$lambda$2 = WhatsAppDashboard$lambda$2($tones$delegate);
                    int iWhatsAppDashboard$lambda$5 = WhatsAppDashboard$lambda$5($activeToneId$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer, -396458740, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    Object objRememberedValue = $composer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda58
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$46$lambda$43$lambda$42($selectedChatSender$delegate, (String) obj3);
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ChatsTab($viewModel, listWhatsAppDashboard$lambda$0, zWhatsAppDashboard$lambda$3, zWhatsAppDashboard$lambda$4, listWhatsAppDashboard$lambda$2, iWhatsAppDashboard$lambda$5, (Function1) obj, $composer, 1572864);
                    $composer.endReplaceGroup();
                    break;
                case BuildConfig.VERSION_CODE /* 1 */:
                    $composer.startReplaceGroup(-396456288);
                    ComposerKt.sourceInformation($composer, "286@13163L79");
                    ChatbotTab($viewModel, null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                    break;
                case 2:
                    $composer.startReplaceGroup(-396452759);
                    ComposerKt.sourceInformation($composer, "293@13466L28,289@13268L248");
                    List<PersonalityTone> listWhatsAppDashboard$lambda$3 = WhatsAppDashboard$lambda$2($tones$delegate);
                    int iWhatsAppDashboard$lambda$6 = WhatsAppDashboard$lambda$5($activeToneId$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer, -396446643, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    Object objRememberedValue2 = $composer.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda59
                            public final Object invoke() {
                                return WhatsAppDashboardKt.WhatsAppDashboard$lambda$48$lambda$47$lambda$46$lambda$45$lambda$44($showAddToneDialog$delegate);
                            }
                        };
                        $composer.updateRememberedValue(obj2);
                    } else {
                        obj2 = objRememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    PersonalitiesTab($viewModel, listWhatsAppDashboard$lambda$3, iWhatsAppDashboard$lambda$6, (Function0) obj2, $composer, 3072);
                    $composer.endReplaceGroup();
                    break;
                case 3:
                    $composer.startReplaceGroup(-396444095);
                    ComposerKt.sourceInformation($composer, "295@13542L144");
                    SchedulerTab($viewModel, WhatsAppDashboard$lambda$1($scheduledMessages$delegate), $composer, 0);
                    $composer.endReplaceGroup();
                    break;
                default:
                    $composer.startReplaceGroup(581695825);
                    $composer.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$48$lambda$47$lambda$46$lambda$43$lambda$42(MutableState $selectedChatSender$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedChatSender$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$48$lambda$47$lambda$46$lambda$45$lambda$44(MutableState $showAddToneDialog$delegate) {
        WhatsAppDashboard$lambda$11($showAddToneDialog$delegate, true);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$50$lambda$49(MutableState $showAddToneDialog$delegate) {
        WhatsAppDashboard$lambda$11($showAddToneDialog$delegate, false);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$52$lambda$51(WhatsAppViewModel $viewModel, MutableState $showAddToneDialog$delegate, String name, String desc, String prompt) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        $viewModel.addCustomTone(name, desc, prompt);
        WhatsAppDashboard$lambda$11($showAddToneDialog$delegate, false);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$59$lambda$55$lambda$54(MutableState $selectedChatSender$delegate) {
        $selectedChatSender$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    static final Unit WhatsAppDashboard$lambda$59$lambda$58$lambda$57(List $chatLogs, WhatsAppViewModel $viewModel, MutableState $selectedChatSender$delegate) {
        Iterator it = $chatLogs.iterator();
        while (it.hasNext()) {
            $viewModel.deleteMessage(((WhatsAppMessage) it.next()).getId());
        }
        $selectedChatSender$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    public static final void ChatsTab(final WhatsAppViewModel viewModel, final List<WhatsAppMessage> list, final boolean isAutoReplyEnabled, final boolean isGroupReplyEnabled, final List<PersonalityTone> list2, final int activeToneId, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Object next;
        Function0 function0;
        Function0 function2;
        Object objSortedWith;
        Object next2;
        Object arrayList;
        Object obj;
        Function0 function3;
        Function0 function4;
        Composer composer;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(list, "messages");
        Intrinsics.checkNotNullParameter(list2, "tones");
        Intrinsics.checkNotNullParameter(function1, "onChatClick");
        Composer $composer2 = $composer.startRestartGroup(404077161);
        ComposerKt.sourceInformation($composer2, "C(ChatsTab)P(6,3,1,2,5)342@14820L8508:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isAutoReplyEnabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(isGroupReplyEnabled) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(list2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(activeToneId) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(404077161, $dirty, -1, "com.example.ui.ChatsTab (WhatsAppDashboard.kt:339)");
            }
            Iterator<T> it = list2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PersonalityTone) next).getId() == activeToneId));
            final PersonalityTone activeTone = (PersonalityTone) next;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            int $dirty2 = $dirty;
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer composer2 = Updater.constructor-impl($composer2);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i3 = ((6 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 2059404172, "C345@14984L11,345@14942L69,350@15175L4638,344@14902L4911,451@19850L1030,477@20978L400:WhatsAppDashboard.kt#naom5h");
            CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1378790015, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda42
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72(activeTone, isAutoReplyEnabled, viewModel, isGroupReplyEnabled, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer2, 54), $composer2, 196614, 24);
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i4 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor2;
                $composer2.createNode(function2);
            } else {
                function2 = constructor2;
                $composer2.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer2);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 803390713, "C461@20241L10,462@20303L11,458@20107L234:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Recent Intercepts", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196614, 0, 65498);
            if (list.isEmpty()) {
                $composer2.startReplaceGroup(783419923);
            } else {
                $composer2.startReplaceGroup(803654026);
                ComposerKt.sourceInformation($composer2, "466@20441L31,467@20564L11,467@20518L64,465@20399L457");
                ComposerKt.sourceInformationMarkerStart($composer2, 718662446, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChangedInstance = $composer2.changedInstance(viewModel);
                Object objRememberedValue = $composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda43
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$75$lambda$74$lambda$73(viewModel);
                        }
                    };
                    $composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ButtonKt.TextButton((Function0) objRememberedValue, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, $composer2, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m5getLambda$1249510153$app(), $composer2, 805306368, 494);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1595949181, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged = $composer2.changed(list);
            int i7 = 0;
            Object objRememberedValue2 = $composer2.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                Collection arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    boolean z = zChanged;
                    if (!Intrinsics.areEqual(((WhatsAppMessage) obj2).getSender(), "AI_Chatbot_Conversation")) {
                        arrayList2.add(obj2);
                    }
                    zChanged = z;
                }
                Iterable iterable = (List) arrayList2;
                int i8 = 0;
                Map linkedHashMap = new LinkedHashMap();
                for (Object obj3 : iterable) {
                    Iterable iterable2 = iterable;
                    String sender = ((WhatsAppMessage) obj3).getSender();
                    Map map = linkedHashMap;
                    int i9 = i8;
                    Object obj4 = map.get(sender);
                    if (obj4 == null) {
                        arrayList = new ArrayList();
                        map.put(sender, arrayList);
                    } else {
                        arrayList = obj4;
                    }
                    ((List) arrayList).add(obj3);
                    iterable = iterable2;
                    linkedHashMap = map;
                    i8 = i9;
                    i7 = i7;
                }
                Map map2 = linkedHashMap;
                int i10 = 0;
                Collection arrayList3 = new ArrayList(map2.size());
                Map map3 = map2;
                int i11 = 0;
                for (Map.Entry entry : map3.entrySet()) {
                    int i12 = i10;
                    String str = (String) entry.getKey();
                    List list3 = (List) entry.getValue();
                    Iterator it2 = list3.iterator();
                    if (it2.hasNext()) {
                        next2 = it2.next();
                        if (it2.hasNext()) {
                            long timestamp = ((WhatsAppMessage) next2).getTimestamp();
                            do {
                                Object next3 = it2.next();
                                long timestamp2 = ((WhatsAppMessage) next3).getTimestamp();
                                if (timestamp < timestamp2) {
                                    next2 = next3;
                                    timestamp = timestamp2;
                                }
                            } while (it2.hasNext());
                        }
                    } else {
                        next2 = null;
                    }
                    Intrinsics.checkNotNull(next2);
                    arrayList3.add(new LatestChatSummary(str, (WhatsAppMessage) next2, list3.size()));
                    i10 = i12;
                    map3 = map3;
                    i11 = i11;
                    objRememberedValue2 = objRememberedValue2;
                }
                objSortedWith = CollectionsKt.sortedWith((List) arrayList3, new Comparator() { // from class: com.example.ui.WhatsAppDashboardKt$ChatsTab$lambda$88$lambda$81$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((LatestChatSummary) t2).getLatestMessage().getTimestamp()), Long.valueOf(((LatestChatSummary) t).getLatestMessage().getTimestamp()));
                    }
                });
                $composer2.updateRememberedValue(objSortedWith);
            } else {
                objSortedWith = objRememberedValue2;
            }
            final List list4 = (List) objSortedWith;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (list4.isEmpty()) {
                $composer2.startReplaceGroup(2065652841);
                ComposerKt.sourceInformation($composer2, "486@21429L1550");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default);
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                int i13 = ((((48 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function3 = constructor3;
                    $composer2.createNode(function3);
                } else {
                    function3 = constructor3;
                    $composer2.useNode();
                }
                Composer composer4 = Updater.constructor-impl($composer2);
                Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i14 = (i13 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i15 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 811496147, "C492@21623L1342:WhatsAppDashboard.kt#naom5h");
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                Modifier modifier2 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32));
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = $composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer2, modifier2);
                Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                int i16 = ((((390 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function4 = constructor4;
                    $composer2.createNode(function4);
                } else {
                    function4 = constructor4;
                    $composer2.useNode();
                }
                Composer composer5 = Updater.constructor-impl($composer2);
                Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer5.getInserting()) {
                    composer = $composer2;
                } else {
                    composer = $composer2;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    }
                    Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    int i17 = (i16 >> 6) & 14;
                    Composer composer6 = composer;
                    ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i18 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer6, -152711702, "C499@21978L11,496@21798L306,502@22125L41,505@22312L10,506@22381L11,503@22187L298,509@22506L40,512@22755L10,513@22824L11,510@22567L380:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(ChatBubbleOutlineKt.getChatBubbleOutline(Icons.Outlined.INSTANCE), "No Chats", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer6, 432, 0);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer6, 6);
                    TextKt.Text--4IGK_g("No WhatsApp notifications captured yet", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getBodyMedium(), composer6, 6, 0, 65018);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer6, 6);
                    TextKt.Text--4IGK_g("Make sure notifications are enabled for WhatsApp, and notification permission is granted in settings.", (Modifier) null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getLabelSmall(), composer6, 6, 0, 65018);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                int i19 = (i16 >> 6) & 14;
                Composer composer7 = composer;
                ComposerKt.sourceInformationMarkerStart(composer7, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                int i110 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer7, -152711702, "C499@21978L11,496@21798L306,502@22125L41,505@22312L10,506@22381L11,503@22187L298,509@22506L40,512@22755L10,513@22824L11,510@22567L380:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(ChatBubbleOutlineKt.getChatBubbleOutline(Icons.Outlined.INSTANCE), "No Chats", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer7, 432, 0);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer7, 6);
                TextKt.Text--4IGK_g("No WhatsApp notifications captured yet", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getBodyMedium(), composer7, 6, 0, 65018);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer7, 6);
                TextKt.Text--4IGK_g("Make sure notifications are enabled for WhatsApp, and notification permission is granted in settings.", (Modifier) null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelSmall(), composer7, 6, 0, 65018);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(2067181544);
                ComposerKt.sourceInformation($composer2, "522@23149L163,519@23009L303");
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
                ComposerKt.sourceInformationMarkerStart($composer2, -1595879946, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChangedInstance2 = $composer2.changedInstance(list4) | (($dirty2 & 3670016) == 1048576);
                Object objRememberedValue3 = $composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda45
                        public final Object invoke(Object obj5) {
                            return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$87$lambda$86(list4, function1, (LazyListScope) obj5);
                        }
                    };
                    $composer2.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyColumn(modifierWeight$default, (LazyListState) null, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, $composer2, 24576, 238);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda46
                public final Object invoke(Object obj5, Object obj6) {
                    return WhatsAppDashboardKt.ChatsTab$lambda$89(viewModel, list, isAutoReplyEnabled, isGroupReplyEnabled, list2, activeToneId, function1, $changed, (Composer) obj5, ((Integer) obj6).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:107:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:109:0x0995  */
    /* JADX WARN: Code duplicated, block: B:112:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:113:0x09a7  */
    /* JADX WARN: Code duplicated, block: B:116:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:119:0x09eb  */
    /* JADX WARN: Code duplicated, block: B:120:0x09ee  */
    /* JADX WARN: Code duplicated, block: B:123:0x0b0b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0b31  */
    /* JADX WARN: Code duplicated, block: B:28:0x023a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0246  */
    /* JADX WARN: Code duplicated, block: B:32:0x024c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0363  */
    /* JADX WARN: Code duplicated, block: B:46:0x036f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0375  */
    /* JADX WARN: Code duplicated, block: B:58:0x0449  */
    /* JADX WARN: Code duplicated, block: B:59:0x044c  */
    /* JADX WARN: Code duplicated, block: B:70:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:73:0x060a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0610  */
    /* JADX WARN: Code duplicated, block: B:85:0x0722  */
    /* JADX WARN: Code duplicated, block: B:88:0x072e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0734  */
    static final Unit ChatsTab$lambda$88$lambda$72(PersonalityTone $activeTone, boolean $isAutoReplyEnabled, final WhatsAppViewModel $viewModel, boolean $isGroupReplyEnabled, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        int i;
        Composer composer;
        Composer composer2;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer3;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Function0 function2;
        Composer composer4;
        String str;
        boolean zChangedInstance;
        Object obj;
        int currentCompositeKeyHash3;
        Function0 constructor3;
        Function0 function3;
        Composer composer5;
        int currentCompositeKeyHash4;
        Function0 constructor4;
        Function0 function4;
        Composer composer6;
        boolean zChangedInstance2;
        Object obj2;
        int currentCompositeKeyHash5;
        Function0 constructor5;
        Function0 function5;
        Composer composer7;
        int i2;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C351@15189L4614:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378790015, $changed, -1, "com.example.ui.ChatsTab.<anonymous>.<anonymous> (WhatsAppDashboard.kt:351)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
            int i3 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor6;
                $composer.createNode(function0);
            } else {
                function0 = constructor6;
                $composer.useNode();
            }
            Composer composer8 = Updater.constructor-impl($composer);
            Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer8.getInserting()) {
                i = 6;
                composer = $composer;
            } else {
                i = 6;
                composer = $composer;
                if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                }
                Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i4 = (i3 >> 6) & 14;
                composer2 = composer;
                ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -400429635, "C356@15438L11,352@15250L290,360@15574L1378,390@17088L11,388@16970L184,393@17172L1308:WhatsAppDashboard.kt#naom5h");
                FontWeight semiBold = FontWeight.Companion.getSemiBold();
                TextKt.Text--4IGK_g("Automation Engine", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, semiBold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 199734, 0, 131024);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i6 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function1 = constructor;
                    composer2.createNode(function1);
                } else {
                    function1 = constructor;
                    composer2.useNode();
                }
                composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i7 = (i6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                int i8 = ((438 >> 6) & 112) | 6;
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2006525478, "C365@15812L665,380@16683L155,379@16602L31,377@16498L436:WhatsAppDashboard.kt#naom5h");
                Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                int i9 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function2 = constructor2;
                    composer2.createNode(function2);
                } else {
                    function2 = constructor2;
                    composer2.useNode();
                }
                composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i10 = (i9 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, 1652682096, "C369@16048L10,366@15877L217,373@16329L10,374@16401L11,371@16119L336:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Auto-Reply Service", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, 196614, 0, 65502);
                if ($isAutoReplyEnabled) {
                    str = "Listening for incoming WhatsApp messages...";
                } else {
                    str = "Idle. Notifications will not be replied.";
                }
                TextKt.Text--4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 0, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SwitchColors switchColors = SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 54, SwitchDefaults.$stable << 18, 65532);
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.Companion, "auto_reply_switch");
                ComposerKt.sourceInformationMarkerStart(composer2, 1459318214, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = composer2.changedInstance($viewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda29
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72$lambda$71$lambda$65$lambda$64$lambda$63($viewModel, ((Boolean) obj3).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SwitchKt.Switch($isAutoReplyEnabled, (Function1) obj, modifierTestTag, (Function2) null, false, switchColors, (MutableInteractionSource) null, composer2, 384, 88);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DividerKt.Divider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), 0.0f, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer2, 6, 2);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                int i12 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function3 = constructor3;
                    composer2.createNode(function3);
                } else {
                    function3 = constructor3;
                    composer2.useNode();
                }
                composer5 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer5, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash4);
                }
                Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                int i13 = (i12 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                int i14 = ((438 >> 6) & 112) | 6;
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 777626775, "C398@17410L592,413@18210L155,412@18128L32,410@18023L439:WhatsAppDashboard.kt#naom5h");
                Modifier modifierWeight$default2 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default2);
                constructor4 = ComposeUiNode.Companion.getConstructor();
                int i15 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function4 = constructor4;
                    composer2.createNode(function4);
                } else {
                    function4 = constructor4;
                    composer2.useNode();
                }
                composer6 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash5);
                }
                Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                int i16 = (i15 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                int i17 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -289729968, "C402@17648L10,399@17475L219,406@17854L10,407@17926L11,404@17719L261:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Reply to Group Chats", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, 196614, 0, 65502);
                TextKt.Text--4IGK_g("Automatically answer messages in groups.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SwitchColors switchColors2 = SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 54, SwitchDefaults.$stable << 18, 65532);
                Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.Companion, "group_reply_switch");
                ComposerKt.sourceInformationMarkerStart(composer2, 1549127344, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance($viewModel);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda30
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72$lambda$71$lambda$69$lambda$68$lambda$67($viewModel, ((Boolean) obj3).booleanValue());
                        }
                    };
                    composer2.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SwitchKt.Switch($isGroupReplyEnabled, (Function1) obj2, modifierTestTag2, (Function2) null, false, switchColors2, (MutableInteractionSource) null, composer2, 384, 88);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if ($activeTone != null) {
                    composer2.startReplaceGroup(-397285244);
                    ComposerKt.sourceInformation(composer2, "424@18670L11,422@18544L196,426@18761L1010");
                    DividerKt.Divider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), 0.0f, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer2, 6, 2);
                    Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Modifier modifier2 = Modifier.Companion;
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifier2);
                    constructor5 = ComposeUiNode.Companion.getConstructor();
                    int i18 = ((((384 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        function5 = constructor5;
                        composer2.createNode(function5);
                    } else {
                        function5 = constructor5;
                        composer2.useNode();
                    }
                    composer7 = Updater.constructor-impl(composer2);
                    Updater.set-impl(composer7, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer7.getInserting()) {
                        i2 = 384;
                    } else {
                        i2 = 384;
                        if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        }
                        Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                        int i19 = (i18 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope rowScope3 = RowScopeInstance.INSTANCE;
                        int i20 = ((i2 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer2, -2059933943, "C430@19027L11,427@18839L294,433@19158L39,436@19330L10,434@19222L213,441@19568L10,442@19641L11,439@19460L289:WhatsAppDashboard.kt#naom5h");
                        IconKt.Icon-ww6aTOc(PsychologyKt.getPsychology(Icons.Outlined.INSTANCE), "Active Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer2, 432, 0);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer2, 6);
                        TextKt.Text--4IGK_g("Active Tone: ", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
                        TextKt.Text--4IGK_g($activeTone.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196608, 0, 65498);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                    }
                    composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composer7.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash6);
                    Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                    int i110 = (i18 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope4 = RowScopeInstance.INSTANCE;
                    int i21 = ((i2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2059933943, "C430@19027L11,427@18839L294,433@19158L39,436@19330L10,434@19222L213,441@19568L10,442@19641L11,439@19460L289:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(PsychologyKt.getPsychology(Icons.Outlined.INSTANCE), "Active Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer2, 432, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer2, 6);
                    TextKt.Text--4IGK_g("Active Tone: ", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
                    TextKt.Text--4IGK_g($activeTone.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196608, 0, 65498);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                } else {
                    composer2.startReplaceGroup(-415699337);
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
            composer8.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash);
            Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i22 = (i3 >> 6) & 14;
            composer2 = composer;
            ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            int i23 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -400429635, "C356@15438L11,352@15250L290,360@15574L1378,390@17088L11,388@16970L184,393@17172L1308:WhatsAppDashboard.kt#naom5h");
            FontWeight semiBold2 = FontWeight.Companion.getSemiBold();
            TextKt.Text--4IGK_g("Automation Engine", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, semiBold2, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 199734, 0, 131024);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically4, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default3);
            constructor = ComposeUiNode.Companion.getConstructor();
            int i24 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function1 = constructor;
                composer2.createNode(function1);
            } else {
                function1 = constructor;
                composer2.useNode();
            }
            composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
            }
            composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash7);
            Updater.set-impl(composer3, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
            int i25 = (i24 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i26 = ((438 >> 6) & 112) | 6;
            RowScope rowScope5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -2006525478, "C365@15812L665,380@16683L155,379@16602L31,377@16498L436:WhatsAppDashboard.kt#naom5h");
            Modifier modifierWeight$default3 = RowScope.weight$default(rowScope5, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default3);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            int i27 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function2 = constructor2;
                composer2.createNode(function2);
            } else {
                function2 = constructor2;
                composer2.useNode();
            }
            composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer4.getInserting()) {
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash8);
            Updater.set-impl(composer4, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            int i111 = (i27 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope5 = ColumnScopeInstance.INSTANCE;
            int i112 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, 1652682096, "C369@16048L10,366@15877L217,373@16329L10,374@16401L11,371@16119L336:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Auto-Reply Service", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, 196614, 0, 65502);
            if ($isAutoReplyEnabled) {
                str = "Listening for incoming WhatsApp messages...";
            } else {
                str = "Idle. Notifications will not be replied.";
            }
            TextKt.Text--4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SwitchColors switchColors3 = SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 54, SwitchDefaults.$stable << 18, 65532);
            Modifier modifierTestTag3 = TestTagKt.testTag(Modifier.Companion, "auto_reply_switch");
            ComposerKt.sourceInformationMarkerStart(composer2, 1459318214, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance = composer2.changedInstance($viewModel);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChangedInstance) {
            }
            obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj3) {
                    return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72$lambda$71$lambda$65$lambda$64$lambda$63($viewModel, ((Boolean) obj3).booleanValue());
                }
            };
            composer2.updateRememberedValue(obj);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SwitchKt.Switch($isAutoReplyEnabled, (Function1) obj, modifierTestTag3, (Function2) null, false, switchColors3, (MutableInteractionSource) null, composer2, 384, 88);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DividerKt.Divider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), 0.0f, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer2, 6, 2);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically5 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(spaceBetween4, centerVertically5, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default4);
            constructor3 = ComposeUiNode.Companion.getConstructor();
            int i113 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function3 = constructor3;
                composer2.createNode(function3);
            } else {
                function3 = constructor3;
                composer2.useNode();
            }
            composer5 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer5.getInserting()) {
            }
            composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash9);
            Updater.set-impl(composer5, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
            int i114 = (i113 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i115 = ((438 >> 6) & 112) | 6;
            RowScope rowScope6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 777626775, "C398@17410L592,413@18210L155,412@18128L32,410@18023L439:WhatsAppDashboard.kt#naom5h");
            Modifier modifierWeight$default4 = RowScope.weight$default(rowScope6, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default4);
            constructor4 = ComposeUiNode.Companion.getConstructor();
            int i116 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function4 = constructor4;
                composer2.createNode(function4);
            } else {
                function4 = constructor4;
                composer2.useNode();
            }
            composer6 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer6.getInserting()) {
            }
            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash10);
            Updater.set-impl(composer6, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
            int i117 = (i116 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope6 = ColumnScopeInstance.INSTANCE;
            int i118 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -289729968, "C402@17648L10,399@17475L219,406@17854L10,407@17926L11,404@17719L261:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Reply to Group Chats", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, 196614, 0, 65502);
            TextKt.Text--4IGK_g("Automatically answer messages in groups.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SwitchColors switchColors4 = SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 54, SwitchDefaults.$stable << 18, 65532);
            Modifier modifierTestTag4 = TestTagKt.testTag(Modifier.Companion, "group_reply_switch");
            ComposerKt.sourceInformationMarkerStart(composer2, 1549127344, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance2 = composer2.changedInstance($viewModel);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance2) {
                obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72$lambda$71$lambda$69$lambda$68$lambda$67($viewModel, ((Boolean) obj3).booleanValue());
                    }
                };
                composer2.updateRememberedValue(obj2);
            } else {
                obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.ChatsTab$lambda$88$lambda$72$lambda$71$lambda$69$lambda$68$lambda$67($viewModel, ((Boolean) obj3).booleanValue());
                    }
                };
                composer2.updateRememberedValue(obj2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SwitchKt.Switch($isGroupReplyEnabled, (Function1) obj2, modifierTestTag4, (Function2) null, false, switchColors4, (MutableInteractionSource) null, composer2, 384, 88);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if ($activeTone != null) {
                composer2.startReplaceGroup(-397285244);
                ComposerKt.sourceInformation(composer2, "424@18670L11,422@18544L196,426@18761L1010");
                DividerKt.Divider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), 0.0f, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer2, 6, 2);
                Alignment.Vertical centerVertically6 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier3 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer2, modifier3);
                constructor5 = ComposeUiNode.Companion.getConstructor();
                int i119 = ((((384 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function5 = constructor5;
                    composer2.createNode(function5);
                } else {
                    function5 = constructor5;
                    composer2.useNode();
                }
                composer7 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer7, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer7, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash11 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer7.getInserting()) {
                    i2 = 384;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    }
                    Updater.set-impl(composer7, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
                    int i1110 = (i119 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope7 = RowScopeInstance.INSTANCE;
                    int i28 = ((i2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2059933943, "C430@19027L11,427@18839L294,433@19158L39,436@19330L10,434@19222L213,441@19568L10,442@19641L11,439@19460L289:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(PsychologyKt.getPsychology(Icons.Outlined.INSTANCE), "Active Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer2, 432, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer2, 6);
                    TextKt.Text--4IGK_g("Active Tone: ", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
                    TextKt.Text--4IGK_g($activeTone.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196608, 0, 65498);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                } else {
                    i2 = 384;
                }
                composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composer7.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash11);
                Updater.set-impl(composer7, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
                int i1111 = (i119 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope8 = RowScopeInstance.INSTANCE;
                int i29 = ((i2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -2059933943, "C430@19027L11,427@18839L294,433@19158L39,436@19330L10,434@19222L213,441@19568L10,442@19641L11,439@19460L289:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(PsychologyKt.getPsychology(Icons.Outlined.INSTANCE), "Active Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer2, 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer2, 6);
                TextKt.Text--4IGK_g("Active Tone: ", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
                TextKt.Text--4IGK_g($activeTone.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196608, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            } else {
                composer2.startReplaceGroup(-415699337);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatsTab$lambda$88$lambda$72$lambda$71$lambda$65$lambda$64$lambda$63(WhatsAppViewModel $viewModel, boolean it) {
        $viewModel.toggleAutoReply();
        return Unit.INSTANCE;
    }

    static final Unit ChatsTab$lambda$88$lambda$72$lambda$71$lambda$69$lambda$68$lambda$67(WhatsAppViewModel $viewModel, boolean it) {
        $viewModel.toggleGroupReply();
        return Unit.INSTANCE;
    }

    static final Unit ChatsTab$lambda$88$lambda$75$lambda$74$lambda$73(WhatsAppViewModel $viewModel) {
        $viewModel.clearAllHistory();
        return Unit.INSTANCE;
    }

    static final Unit ChatsTab$lambda$88$lambda$87$lambda$86(final List $uniqueChats, final Function1 $onChatClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$ChatsTab$lambda$88$lambda$87$lambda$86$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m23invoke((LatestChatSummary) p1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m23invoke(LatestChatSummary latestChatSummary) {
                return null;
            }
        };
        $this$LazyColumn.items($uniqueChats.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatsTab$lambda$88$lambda$87$lambda$86$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke($uniqueChats.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatsTab$lambda$88$lambda$87$lambda$86$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Object obj;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final LatestChatSummary latestChatSummary = (LatestChatSummary) $uniqueChats.get(it);
                $composer.startReplaceGroup(1977618025);
                ComposerKt.sourceInformation($composer, "C*524@23251L28,524@23216L64:WhatsAppDashboard.kt#naom5h");
                ComposerKt.sourceInformationMarkerStart($composer, 340889878, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChanged = ((((i & 112) ^ 48) > 32 && $composer.changed(latestChatSummary)) || (i & 48) == 32) | $composer.changed($onChatClick);
                Object objRememberedValue = $composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    final Function1 function2 = $onChatClick;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatsTab$1$4$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m22invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m22invoke() {
                            function2.invoke(latestChatSummary.getSender());
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                WhatsAppDashboardKt.ChatRowItem(latestChatSummary, (Function0) obj, $composer, (i >> 3) & 14);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void ChatRowItem(LatestChatSummary chat, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object obj;
        Object obj2;
        final LatestChatSummary latestChatSummary;
        Intrinsics.checkNotNullParameter(chat, "chat");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1167558863);
        ComposerKt.sourceInformation($composer2, "C(ChatRowItem)539@23550L166,545@23800L11,545@23758L69,549@23951L13,550@23971L4279,544@23722L4528:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(chat) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            latestChatSummary = chat;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1167558863, $dirty, -1, "com.example.ui.ChatRowItem (WhatsAppDashboard.kt:538)");
            }
            long timestamp = chat.getLatestMessage().getTimestamp();
            ComposerKt.sourceInformationMarkerStart($composer2, -1037599817, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged = $composer2.changed(timestamp);
            Object objRememberedValue = $composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(chat.getLatestMessage().getTimestamp()));
                $composer2.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            final String timeString = (String) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $dirty2 = $dirty;
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16));
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1037587138, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean z = ($dirty2 & 112) == 32;
            Object objRememberedValue2 = $composer2.rememberedValue();
            if (z || objRememberedValue2 == Composer.Companion.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatRowItem$lambda$92$lambda$91(function0);
                    }
                };
                $composer2.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            latestChatSummary = chat;
            CardKt.Card(ClickableKt.clickable-XHw0xAI$default(modifierFillMaxWidth$default, false, (String) null, (Role) null, (Function0) obj2, 7, (Object) null), shape, cardColors, (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(625066403, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return WhatsAppDashboardKt.ChatRowItem$lambda$99(latestChatSummary, timeString, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, $composer2, 54), $composer2, 196608, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ChatRowItem$lambda$100(latestChatSummary, function0, $changed, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    static final Unit ChatRowItem$lambda$92$lambda$91(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x0876  */
    /* JADX WARN: Code duplicated, block: B:122:0x0a7a  */
    static final Unit ChatRowItem$lambda$99(LatestChatSummary $chat, String $timeString, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        Function0 function1;
        Function0 function2;
        Function0 function3;
        Function0 function4;
        String messageText;
        String str;
        long j;
        Function0 function5;
        Composer composer;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C551@23981L4263:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625066403, $changed, -1, "com.example.ui.ChatRowItem.<anonymous> (WhatsAppDashboard.kt:551)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(14));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((390 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl($composer);
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i3 = ((390 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1771858390, "C562@24375L11,558@24216L532,573@24762L40,575@24816L3418:WhatsAppDashboard.kt#naom5h");
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier2);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i4 = ((((48 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor2;
                $composer.createNode(function1);
            } else {
                function1 = constructor2;
                $composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1689571789, "C569@24697L11,565@24501L233:WhatsAppDashboard.kt#naom5h");
            String upperCase = StringsKt.take($chat.getSender(), 1).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.Text--4IGK_g(upperCase, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifierWeight$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            int i7 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function2 = constructor3;
                $composer.createNode(function2);
            } else {
                function2 = constructor3;
                $composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            int i8 = (i7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -331964301, "C576@24873L835,596@25742L40,598@25800L2420:WhatsAppDashboard.kt#naom5h");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            int i10 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function3 = constructor4;
                $composer.createNode(function3);
            } else {
                function3 = constructor4;
                $composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl($composer);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            int i11 = (i10 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i12 = ((438 >> 6) & 112) | 6;
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1865451041, "C584@25261L10,581@25111L344,591@25571L10,592@25640L11,589@25476L214:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g($chat.getSender(), RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null), 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 196608, 3120, 55260);
            Intrinsics.checkNotNull($timeString);
            TextKt.Text--4IGK_g($timeString, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default2);
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            int i13 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function4 = constructor5;
                $composer.createNode(function4);
            } else {
                function4 = constructor5;
                $composer.useNode();
            }
            Composer composer6 = Updater.constructor-impl($composer);
            Updater.set-impl(composer6, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composer6.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            int i14 = (i13 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i15 = ((438 >> 6) & 112) | 6;
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -112949321, "C610@26384L10,611@26452L11,608@26288L366,617@26676L39,641@27647L555:WhatsAppDashboard.kt#naom5h");
            if ($chat.getLatestMessage().isIncoming()) {
                messageText = $chat.getLatestMessage().getMessageText();
            } else {
                messageText = "Replied: " + $chat.getLatestMessage().getMessageText();
            }
            TextKt.Text--4IGK_g(messageText, RowScope.weight$default(rowScope3, Modifier.Companion, 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 0, 3120, 55288);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            switch ($chat.getLatestMessage().getStatus()) {
                case "RECEIVED":
                    $composer.startReplaceGroup(-111787628);
                    ComposerKt.sourceInformation($composer, "633@27377L11");
                    long j2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    $composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    str = "New";
                    j = j2;
                    break;
                case "SENT":
                    $composer.startReplaceGroup(-112119576);
                    $composer.endReplaceGroup();
                    long successGreen = ColorKt.getSuccessGreen();
                    Unit unit2 = Unit.INSTANCE;
                    str = "Sent";
                    j = successGreen;
                    break;
                case "FAILED":
                    $composer.startReplaceGroup(-111953974);
                    $composer.endReplaceGroup();
                    long errorRed = ColorKt.getErrorRed();
                    Unit unit3 = Unit.INSTANCE;
                    str = "Failed";
                    j = errorRed;
                    break;
                default:
                    $composer.startReplaceGroup(-111606154);
                    $composer.endReplaceGroup();
                    String status = $chat.getLatestMessage().getStatus();
                    long alertYellow = ColorKt.getAlertYellow();
                    Unit unit4 = Unit.INSTANCE;
                    str = status;
                    j = alertYellow;
                    break;
            }
            Modifier modifier3 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Color.copy-wmQWz5c$default(j, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier($composer, modifier3);
            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
            int i16 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function5 = constructor6;
                $composer.createNode(function5);
            } else {
                function5 = constructor6;
                $composer.useNode();
            }
            Composer composer7 = Updater.constructor-impl($composer);
            Updater.set-impl(composer7, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer7.getInserting()) {
                composer = $composer;
            } else {
                composer = $composer;
                if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                }
                Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                int i17 = (i16 >> 6) & 14;
                Composer composer8 = composer;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i18 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer8, -1930788801, "C647@27950L230:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g(str, (Modifier) null, j, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer8, 199680, 0, 131026);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
            composer7.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
            int i19 = (i16 >> 6) & 14;
            Composer composer9 = composer;
            ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i110 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer9, -1930788801, "C647@27950L230:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g(str, (Modifier) null, j, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer9, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer9);
            ComposerKt.sourceInformationMarkerEnd(composer9);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0535  */
    /* JADX WARN: Code duplicated, block: B:87:0x0537  */
    /* JADX WARN: Code duplicated, block: B:94:0x0557  */
    /* JADX WARN: Code duplicated, block: B:97:0x059f  */
    public static final void PersonalitiesTab(WhatsAppViewModel viewModel, final List<PersonalityTone> list, int activeToneId, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 function1;
        Function0 function2;
        Function0 function3;
        Composer composer;
        int $dirty;
        Composer $composer2;
        boolean z;
        final WhatsAppViewModel whatsAppViewModel;
        boolean zChangedInstance;
        Object obj;
        final int i;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(list, "tones");
        Intrinsics.checkNotNullParameter(function0, "onAddToneClick");
        Composer $composer3 = $composer.startRestartGroup(-1333717801);
        ComposerKt.sourceInformation($composer3, "C(PersonalitiesTab)P(3,2)667@28418L6428:WhatsAppDashboard.kt#naom5h");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(activeToneId) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        if (($dirty2 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            whatsAppViewModel = viewModel;
            i = activeToneId;
            $composer2 = $composer3;
            $dirty = $dirty2;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1333717801, $dirty2, -1, "com.example.ui.PersonalitiesTab (WhatsAppDashboard.kt:666)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            int $dirty3 = $dirty2;
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor;
                $composer3.createNode(function1);
            } else {
                function1 = constructor;
                $composer3.useNode();
            }
            Composer composer2 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i3 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -820941260, "C668@28470L1306,702@29914L4926,699@29786L5054:WhatsAppDashboard.kt#naom5h");
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i5 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function2 = constructor2;
                $composer3.createNode(function2);
            } else {
                function2 = constructor2;
                $composer3.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i6 = (i5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1595981726, "C675@28726L530,690@29425L11,690@29370L84,688@29269L497:WhatsAppDashboard.kt#naom5h");
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer3, modifier2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            int i8 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function3 = constructor3;
                $composer3.createNode(function3);
            } else {
                function3 = constructor3;
                $composer3.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting()) {
                composer = $composer3;
            } else {
                composer = $composer3;
                if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                }
                Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i9 = (i8 >> 6) & 14;
                Composer composer5 = composer;
                ComposerKt.sourceInformationMarkerStart(composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer5, 352470833, "C679@28896L10,680@28962L11,676@28751L253,684@29131L10,685@29196L11,682@29021L221:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("AI Personalities", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getTitleMedium(), composer5, 196614, 0, 65498);
                TextKt.Text--4IGK_g("Select or define response rules", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getLabelSmall(), composer5, 6, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                $dirty = $dirty3;
                $composer2 = $composer3;
                ButtonKt.FilledTonalButton(function0, TestTagKt.testTag(Modifier.Companion, "add_personality_button"), false, (Shape) null, ButtonDefaults.INSTANCE.filledTonalButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), 0L, 0L, 0L, $composer3, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m11getLambda$1746998653$app(), $composer3, (($dirty3 >> 9) & 14) | 805306416, 492);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                Arrangement.Vertical vertical2 = vertical;
                ComposerKt.sourceInformationMarkerStart($composer3, -857721205, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChangedInstance2 = $composer2.changedInstance(list);
                if (($dirty & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                whatsAppViewModel = viewModel;
                zChangedInstance = zChangedInstance2 | z | $composer2.changedInstance(whatsAppViewModel);
                Object objRememberedValue = $composer3.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    i = activeToneId;
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda33
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.PersonalitiesTab$lambda$107$lambda$106$lambda$105(list, i, whatsAppViewModel, (LazyListScope) obj2);
                        }
                    };
                    $composer3.updateRememberedValue(obj);
                } else {
                    i = activeToneId;
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LazyDslKt.LazyColumn(modifierWeight$default, (LazyListState) null, (PaddingValues) null, false, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, $composer3, 24576, 238);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            int i11 = (i8 >> 6) & 14;
            Composer composer6 = composer;
            ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer6, 352470833, "C679@28896L10,680@28962L11,676@28751L253,684@29131L10,685@29196L11,682@29021L221:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("AI Personalities", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getTitleMedium(), composer6, 196614, 0, 65498);
            TextKt.Text--4IGK_g("Select or define response rules", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getLabelSmall(), composer6, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer6);
            ComposerKt.sourceInformationMarkerEnd(composer6);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            $dirty = $dirty3;
            $composer2 = $composer3;
            ButtonKt.FilledTonalButton(function0, TestTagKt.testTag(Modifier.Companion, "add_personality_button"), false, (Shape) null, ButtonDefaults.INSTANCE.filledTonalButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), 0L, 0L, 0L, $composer3, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m11getLambda$1746998653$app(), $composer3, (($dirty3 >> 9) & 14) | 805306416, 492);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Arrangement.Vertical vertical3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Vertical vertical4 = vertical3;
            ComposerKt.sourceInformationMarkerStart($composer3, -857721205, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChangedInstance3 = $composer2.changedInstance(list);
            if (($dirty & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            whatsAppViewModel = viewModel;
            zChangedInstance = zChangedInstance3 | z | $composer2.changedInstance(whatsAppViewModel);
            Object objRememberedValue2 = $composer3.rememberedValue();
            if (!zChangedInstance) {
                i = activeToneId;
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda33
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.PersonalitiesTab$lambda$107$lambda$106$lambda$105(list, i, whatsAppViewModel, (LazyListScope) obj2);
                    }
                };
                $composer3.updateRememberedValue(obj);
            } else {
                i = activeToneId;
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda33
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.PersonalitiesTab$lambda$107$lambda$106$lambda$105(list, i, whatsAppViewModel, (LazyListScope) obj2);
                    }
                };
                $composer3.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LazyDslKt.LazyColumn(modifierWeight$default2, (LazyListState) null, (PaddingValues) null, false, vertical4, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, $composer3, 24576, 238);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final WhatsAppViewModel whatsAppViewModel2 = whatsAppViewModel;
            final int $dirty4 = i;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda44
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.PersonalitiesTab$lambda$108(whatsAppViewModel2, list, $dirty4, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    static final Unit PersonalitiesTab$lambda$107$lambda$106$lambda$105(final List $tones, final int $activeToneId, final WhatsAppViewModel $viewModel, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$lambda$107$lambda$106$lambda$105$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m26invoke((PersonalityTone) p1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m26invoke(PersonalityTone personalityTone) {
                return null;
            }
        };
        $this$LazyColumn.items($tones.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$lambda$107$lambda$106$lambda$105$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke($tones.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$lambda$107$lambda$106$lambda$105$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                long j;
                boolean z;
                Brush brush;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final PersonalityTone personalityTone = (PersonalityTone) $tones.get(it);
                $composer.startReplaceGroup(-1557116009);
                ComposerKt.sourceInformation($composer, "C*706@30070L300,714@30469L20,723@30963L36,724@31018L3798,705@30022L4794:WhatsAppDashboard.kt#naom5h");
                boolean z2 = personalityTone.getId() == $activeToneId;
                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                if (z2) {
                    $composer.startReplaceGroup(-1557094310);
                    ComposerKt.sourceInformation($composer, "708@30181L11");
                    j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-1556980633);
                    ComposerKt.sourceInformation($composer, "710@30296L11");
                    j = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU();
                    $composer.endReplaceGroup();
                }
                final boolean z3 = z2;
                CardColors cardColors = cardDefaults.cardColors-ro_MJ88(j, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20));
                BorderStroke borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, $composer, CardDefaults.$stable << 3, 1);
                if (z3) {
                    $composer.startReplaceGroup(-1556691155);
                    ComposerKt.sourceInformation($composer, "716@30614L11,716@30649L11");
                    z = false;
                    brush = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU()), Color.box-impl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU())}), 0L, 0L, 0, 14, (Object) null);
                    $composer.endReplaceGroup();
                } else {
                    z = false;
                    $composer.startReplaceGroup(-1556533427);
                    $composer.endReplaceGroup();
                    brush = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0L, 0L, 0, 14, (Object) null);
                }
                BorderStroke borderStroke = BorderStroke.copy-D5KLDUw$default(borderStrokeOutlinedCardBorder, 0.0f, brush, 1, (Object) null);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 781081503, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChangedInstance = $composer.changedInstance($viewModel);
                if ((((i & 112) ^ 48) > 32 && $composer.changed(personalityTone)) || (i & 48) == 32) {
                    z = true;
                }
                boolean z4 = zChangedInstance | z;
                Object objRememberedValue = $composer.rememberedValue();
                if (z4 || objRememberedValue == Composer.Companion.getEmpty()) {
                    final WhatsAppViewModel whatsAppViewModel = $viewModel;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$1$2$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m24invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m24invoke() {
                            whatsAppViewModel.setActiveTone(personalityTone.getId());
                        }
                    };
                    $composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                final WhatsAppViewModel whatsAppViewModel2 = $viewModel;
                CardKt.Card(ClickableKt.clickable-XHw0xAI$default(modifierFillMaxWidth$default, false, (String) null, (Role) null, (Function0) objRememberedValue, 7, (Object) null), shape, cardColors, (CardElevation) null, borderStroke, ComposableLambdaKt.rememberComposableLambda(1584081133, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$1$2$1$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                        invoke((ColumnScope) p1, (Composer) p2, ((Number) p3).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code duplicated, block: B:100:0x077f  */
                    /* JADX WARN: Code duplicated, block: B:103:0x07b0  */
                    /* JADX WARN: Code duplicated, block: B:106:0x07c3  */
                    /* JADX WARN: Code duplicated, block: B:107:0x07c6  */
                    /* JADX WARN: Code duplicated, block: B:111:0x08dc  */
                    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:28:0x01de  */
                    /* JADX WARN: Code duplicated, block: B:31:0x01ea  */
                    /* JADX WARN: Code duplicated, block: B:32:0x01f0  */
                    /* JADX WARN: Code duplicated, block: B:43:0x02fa  */
                    /* JADX WARN: Code duplicated, block: B:46:0x0306  */
                    /* JADX WARN: Code duplicated, block: B:47:0x030c  */
                    /* JADX WARN: Code duplicated, block: B:58:0x03a2  */
                    /* JADX WARN: Code duplicated, block: B:59:0x03a9  */
                    /* JADX WARN: Code duplicated, block: B:62:0x03b3  */
                    /* JADX WARN: Code duplicated, block: B:63:0x03c1  */
                    /* JADX WARN: Code duplicated, block: B:66:0x042f  */
                    /* JADX WARN: Code duplicated, block: B:67:0x0447  */
                    /* JADX WARN: Code duplicated, block: B:70:0x04aa  */
                    /* JADX WARN: Code duplicated, block: B:76:0x04dc  */
                    /* JADX WARN: Code duplicated, block: B:78:0x051b  */
                    /* JADX WARN: Code duplicated, block: B:81:0x064f  */
                    /* JADX WARN: Code duplicated, block: B:84:0x065b  */
                    /* JADX WARN: Code duplicated, block: B:85:0x0661  */
                    /* JADX WARN: Code duplicated, block: B:88:0x0694  */
                    /* JADX WARN: Code duplicated, block: B:91:0x06a7  */
                    /* JADX WARN: Code duplicated, block: B:92:0x06aa  */
                    /* JADX WARN: Code duplicated, block: B:96:0x076d  */
                    /* JADX WARN: Code duplicated, block: B:99:0x0779  */
                    public final void invoke(ColumnScope $this$Card, Composer $composer2, int $changed2) {
                        Function0 function0;
                        boolean z5;
                        int i2;
                        int currentCompositeKeyHash;
                        Function0 constructor;
                        Function0 function2;
                        Composer composer;
                        int currentCompositeKeyHash2;
                        Function0 constructor2;
                        Function0 function3;
                        Composer composer2;
                        ImageVector circle;
                        long successGreen;
                        long j2;
                        int currentCompositeKeyHash3;
                        Function0 constructor3;
                        Function0 function4;
                        Composer composer3;
                        Composer composer4;
                        Composer composer5;
                        int currentCompositeKeyHash4;
                        Function0 constructor4;
                        Function0 function5;
                        Composer composer6;
                        Composer composer7;
                        boolean zChangedInstance2;
                        Object obj;
                        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
                        ComposerKt.sourceInformation($composer2, "C725@31040L3758:WhatsAppDashboard.kt#naom5h");
                        if (($changed2 & 17) == 16 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1584081133, $changed2, -1, "com.example.ui.PersonalitiesTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:725)");
                        }
                        Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
                        final PersonalityTone personalityTone2 = personalityTone;
                        final WhatsAppViewModel whatsAppViewModel3 = whatsAppViewModel2;
                        boolean z6 = z3;
                        ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifier);
                        Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                        int i3 = ((((6 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            function0 = constructor5;
                            $composer2.createNode(function0);
                        } else {
                            function0 = constructor5;
                            $composer2.useNode();
                        }
                        Composer composer8 = Updater.constructor-impl($composer2);
                        Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer8.getInserting()) {
                            z5 = z6;
                            i2 = 6;
                            if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                            }
                            Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                            int i4 = (i3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                            int i5 = ((i2 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -137427955, "C726@31109L2120,762@33255L40,766@33430L10,767@33502L11,764@33321L235,770@33582L41,776@33872L11,772@33649L1127:WhatsAppDashboard.kt#naom5h");
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default2);
                            constructor = ComposeUiNode.Companion.getConstructor();
                            int i6 = ((((438 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                function2 = constructor;
                                $composer2.createNode(function2);
                            } else {
                                function2 = constructor;
                                $composer2.useNode();
                            }
                            composer = Updater.constructor-impl($composer2);
                            Updater.set-impl(composer, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                            }
                            Updater.set-impl(composer, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            int i7 = (i6 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i8 = ((438 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -497484412, "C731@31387L1014:WhatsAppDashboard.kt#naom5h");
                            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Modifier modifier2 = Modifier.Companion;
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = $composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer2, modifier2);
                            constructor2 = ComposeUiNode.Companion.getConstructor();
                            int i9 = ((((384 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                function3 = constructor2;
                                $composer2.createNode(function3);
                            } else {
                                function3 = constructor2;
                                $composer2.useNode();
                            }
                            composer2 = Updater.constructor-impl($composer2);
                            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composer2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3);
                            }
                            Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                            int i10 = (i9 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i11 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, 653137654, "C732@31473L418,738@31924L40,742@32181L10,739@31997L374:WhatsAppDashboard.kt#naom5h");
                            if (z5) {
                                circle = CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE);
                            } else {
                                circle = CircleKt.getCircle(Icons.Outlined.INSTANCE);
                            }
                            ImageVector imageVector = circle;
                            if (z5) {
                                $composer2.startReplaceGroup(575265559);
                                $composer2.endReplaceGroup();
                                successGreen = ColorKt.getSuccessGreen();
                            } else {
                                $composer2.startReplaceGroup(575266971);
                                ComposerKt.sourceInformation($composer2, "735@31760L11");
                                successGreen = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                                $composer2.endReplaceGroup();
                            }
                            IconKt.Icon-ww6aTOc(imageVector, "Selected state", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), successGreen, $composer2, 432, 0);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                            String name = personalityTone2.getName();
                            FontWeight bold = FontWeight.Companion.getBold();
                            TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium();
                            if (z5) {
                                $composer2.startReplaceGroup(575283506);
                                ComposerKt.sourceInformation($composer2, "743@32277L11");
                                j2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                            } else {
                                $composer2.startReplaceGroup(575284756);
                                ComposerKt.sourceInformation($composer2, "743@32316L11");
                                j2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                            }
                            $composer2.endReplaceGroup();
                            TextKt.Text--4IGK_g(name, (Modifier) null, j2, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, titleMedium, $composer2, 196608, 0, 65498);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (personalityTone2.isDefault()) {
                                $composer2.startReplaceGroup(-528677605);
                            } else {
                                $composer2.startReplaceGroup(-496409054);
                                ComposerKt.sourceInformation($composer2, "749@32598L33,748@32540L633");
                                ComposerKt.sourceInformationMarkerStart($composer2, -708747576, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                                zChangedInstance2 = $composer2.changedInstance(whatsAppViewModel3) | $composer2.changed(personalityTone2);
                                Object objRememberedValue2 = $composer2.rememberedValue();
                                if (!zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$1$2$1$1$2$1$1$2$1
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m25invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                        public final void m25invoke() {
                                            whatsAppViewModel3.deleteTone(personalityTone2.getId());
                                        }
                                    };
                                    $composer2.updateRememberedValue(obj);
                                } else {
                                    obj = objRememberedValue2;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                IconButtonKt.IconButton((Function0) obj, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$482963775$app(), $composer2, 196656, 28);
                            }
                            $composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer2, 6);
                            TextKt.Text--4IGK_g(personalityTone2.getDescription(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), $composer2, 0, 0, 65530);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                            Modifier modifier3 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getBackground-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(10));
                            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = $composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer2, modifier3);
                            constructor3 = ComposeUiNode.Companion.getConstructor();
                            int i12 = ((((0 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                function4 = constructor3;
                                $composer2.createNode(function4);
                            } else {
                                function4 = constructor3;
                                $composer2.useNode();
                            }
                            composer3 = Updater.constructor-impl($composer2);
                            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer3, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer3.getInserting()) {
                                composer4 = $composer2;
                                if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                }
                                Updater.set-impl(composer3, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                int i13 = (i12 >> 6) & 14;
                                composer5 = composer4;
                                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                int i14 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer5, 1679320255, "C779@34019L731:WhatsAppDashboard.kt#naom5h");
                                ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Modifier modifier4 = Modifier.Companion;
                                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap5 = composer5.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer5, modifier4);
                                constructor4 = ComposeUiNode.Companion.getConstructor();
                                int i15 = ((((0 << 3) & 112) << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer5.startReusableNode();
                                if (composer5.getInserting()) {
                                    function5 = constructor4;
                                    composer5.createNode(function5);
                                } else {
                                    function5 = constructor4;
                                    composer5.useNode();
                                }
                                composer6 = Updater.constructor-impl(composer5);
                                Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer6.getInserting()) {
                                    composer7 = composer5;
                                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    }
                                    Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                                    int i16 = (i15 >> 6) & 14;
                                    Composer composer9 = composer7;
                                    ComposerKt.sourceInformationMarkerStart(composer9, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                    int i17 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart(composer9, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                                    TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer9, 199686, 0, 131026);
                                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer9, 6);
                                    TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer9, 3072, 0, 131058);
                                    ComposerKt.sourceInformationMarkerEnd(composer9);
                                    ComposerKt.sourceInformationMarkerEnd(composer9);
                                    composer7.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer7);
                                    ComposerKt.sourceInformationMarkerEnd(composer7);
                                    ComposerKt.sourceInformationMarkerEnd(composer7);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    $composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                composer7 = composer5;
                                composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash5);
                                Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                                int i18 = (i15 >> 6) & 14;
                                Composer composer10 = composer7;
                                ComposerKt.sourceInformationMarkerStart(composer10, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                                int i19 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer10, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                                TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer10, 199686, 0, 131026);
                                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer10, 6);
                                TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer10, 3072, 0, 131058);
                                ComposerKt.sourceInformationMarkerEnd(composer10);
                                ComposerKt.sourceInformationMarkerEnd(composer10);
                                composer7.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            composer4 = $composer2;
                            composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composer3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash4);
                            Updater.set-impl(composer3, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                            int i110 = (i12 >> 6) & 14;
                            composer5 = composer4;
                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                            int i111 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer5, 1679320255, "C779@34019L731:WhatsAppDashboard.kt#naom5h");
                            ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Modifier modifier5 = Modifier.Companion;
                            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                            CompositionLocalMap currentCompositionLocalMap6 = composer5.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer5, modifier5);
                            constructor4 = ComposeUiNode.Companion.getConstructor();
                            int i112 = ((((0 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                function5 = constructor4;
                                composer5.createNode(function5);
                            } else {
                                function5 = constructor4;
                                composer5.useNode();
                            }
                            composer6 = Updater.constructor-impl(composer5);
                            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer6.getInserting()) {
                                composer7 = composer5;
                                if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                }
                                Updater.set-impl(composer6, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                                int i113 = (i112 >> 6) & 14;
                                Composer composer11 = composer7;
                                ComposerKt.sourceInformationMarkerStart(composer11, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
                                int i114 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer11, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                                TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer11, 199686, 0, 131026);
                                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer11, 6);
                                TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer11, 3072, 0, 131058);
                                ComposerKt.sourceInformationMarkerEnd(composer11);
                                ComposerKt.sourceInformationMarkerEnd(composer11);
                                composer7.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            composer7 = composer5;
                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash6);
                            Updater.set-impl(composer6, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                            int i115 = (i112 >> 6) & 14;
                            Composer composer12 = composer7;
                            ComposerKt.sourceInformationMarkerStart(composer12, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScope columnScope5 = ColumnScopeInstance.INSTANCE;
                            int i116 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer12, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                            TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer12, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer12, 199686, 0, 131026);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer12, 6);
                            TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer12, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer12, 3072, 0, 131058);
                            ComposerKt.sourceInformationMarkerEnd(composer12);
                            ComposerKt.sourceInformationMarkerEnd(composer12);
                            composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        z5 = z6;
                        i2 = 6;
                        composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        composer8.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash);
                        Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                        int i20 = (i3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope columnScope6 = ColumnScopeInstance.INSTANCE;
                        int i21 = ((i2 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -137427955, "C726@31109L2120,762@33255L40,766@33430L10,767@33502L11,764@33321L235,770@33582L41,776@33872L11,772@33649L1127:WhatsAppDashboard.kt#naom5h");
                        Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap7 = $composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default3);
                        constructor = ComposeUiNode.Companion.getConstructor();
                        int i22 = ((((438 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            function2 = constructor;
                            $composer2.createNode(function2);
                        } else {
                            function2 = constructor;
                            $composer2.useNode();
                        }
                        composer = Updater.constructor-impl($composer2);
                        Updater.set-impl(composer, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer.getInserting()) {
                        }
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash7);
                        Updater.set-impl(composer, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
                        int i23 = (i22 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope rowScope3 = RowScopeInstance.INSTANCE;
                        int i24 = ((438 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -497484412, "C731@31387L1014:WhatsAppDashboard.kt#naom5h");
                        Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier6 = Modifier.Companion;
                        MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap8 = $composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier($composer2, modifier6);
                        constructor2 = ComposeUiNode.Companion.getConstructor();
                        int i25 = ((((384 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            function3 = constructor2;
                            $composer2.createNode(function3);
                        } else {
                            function3 = constructor2;
                            $composer2.useNode();
                        }
                        composer2 = Updater.constructor-impl($composer2);
                        Updater.set-impl(composer2, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                        }
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash8);
                        Updater.set-impl(composer2, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
                        int i117 = (i25 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope rowScope4 = RowScopeInstance.INSTANCE;
                        int i118 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 653137654, "C732@31473L418,738@31924L40,742@32181L10,739@31997L374:WhatsAppDashboard.kt#naom5h");
                        if (z5) {
                            circle = CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE);
                        } else {
                            circle = CircleKt.getCircle(Icons.Outlined.INSTANCE);
                        }
                        ImageVector imageVector2 = circle;
                        if (z5) {
                            $composer2.startReplaceGroup(575265559);
                            $composer2.endReplaceGroup();
                            successGreen = ColorKt.getSuccessGreen();
                        } else {
                            $composer2.startReplaceGroup(575266971);
                            ComposerKt.sourceInformation($composer2, "735@31760L11");
                            successGreen = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                            $composer2.endReplaceGroup();
                        }
                        IconKt.Icon-ww6aTOc(imageVector2, "Selected state", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), successGreen, $composer2, 432, 0);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                        String name2 = personalityTone2.getName();
                        FontWeight bold2 = FontWeight.Companion.getBold();
                        TextStyle titleMedium2 = MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium();
                        if (z5) {
                            $composer2.startReplaceGroup(575283506);
                            ComposerKt.sourceInformation($composer2, "743@32277L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            $composer2.startReplaceGroup(575284756);
                            ComposerKt.sourceInformation($composer2, "743@32316L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                        }
                        $composer2.endReplaceGroup();
                        TextKt.Text--4IGK_g(name2, (Modifier) null, j2, 0L, (FontStyle) null, bold2, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, titleMedium2, $composer2, 196608, 0, 65498);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        if (personalityTone2.isDefault()) {
                            $composer2.startReplaceGroup(-496409054);
                            ComposerKt.sourceInformation($composer2, "749@32598L33,748@32540L633");
                            ComposerKt.sourceInformationMarkerStart($composer2, -708747576, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                            zChangedInstance2 = $composer2.changedInstance(whatsAppViewModel3) | $composer2.changed(personalityTone2);
                            Object objRememberedValue3 = $composer2.rememberedValue();
                            if (zChangedInstance2) {
                                obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$1$2$1$1$2$1$1$2$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m25invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m25invoke() {
                                        whatsAppViewModel3.deleteTone(personalityTone2.getId());
                                    }
                                };
                                $composer2.updateRememberedValue(obj);
                            } else {
                                obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$PersonalitiesTab$1$2$1$1$2$1$1$2$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m25invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m25invoke() {
                                        whatsAppViewModel3.deleteTone(personalityTone2.getId());
                                    }
                                };
                                $composer2.updateRememberedValue(obj);
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            IconButtonKt.IconButton((Function0) obj, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$482963775$app(), $composer2, 196656, 28);
                        } else {
                            $composer2.startReplaceGroup(-528677605);
                        }
                        $composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer2, 6);
                        TextKt.Text--4IGK_g(personalityTone2.getDescription(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), $composer2, 0, 0, 65530);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                        Modifier modifier7 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getBackground-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(10));
                        ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = $composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier($composer2, modifier7);
                        constructor3 = ComposeUiNode.Companion.getConstructor();
                        int i119 = ((((0 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            function4 = constructor3;
                            $composer2.createNode(function4);
                        } else {
                            function4 = constructor3;
                            $composer2.useNode();
                        }
                        composer3 = Updater.constructor-impl($composer2);
                        Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer3.getInserting()) {
                            composer4 = $composer2;
                            if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            }
                            Updater.set-impl(composer3, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                            int i1110 = (i119 >> 6) & 14;
                            composer5 = composer4;
                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                            int i1111 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer5, 1679320255, "C779@34019L731:WhatsAppDashboard.kt#naom5h");
                            ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Modifier modifier8 = Modifier.Companion;
                            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                            CompositionLocalMap currentCompositionLocalMap10 = composer5.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer5, modifier8);
                            constructor4 = ComposeUiNode.Companion.getConstructor();
                            int i1112 = ((((0 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer5.startReusableNode();
                            if (composer5.getInserting()) {
                                function5 = constructor4;
                                composer5.createNode(function5);
                            } else {
                                function5 = constructor4;
                                composer5.useNode();
                            }
                            composer6 = Updater.constructor-impl(composer5);
                            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer6, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer6.getInserting()) {
                                composer7 = composer5;
                                if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                }
                                Updater.set-impl(composer6, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                                int i1113 = (i1112 >> 6) & 14;
                                Composer composer13 = composer7;
                                ComposerKt.sourceInformationMarkerStart(composer13, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScope columnScope7 = ColumnScopeInstance.INSTANCE;
                                int i1114 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer13, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                                TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer13, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer13, 199686, 0, 131026);
                                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer13, 6);
                                TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer13, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer13, 3072, 0, 131058);
                                ComposerKt.sourceInformationMarkerEnd(composer13);
                                ComposerKt.sourceInformationMarkerEnd(composer13);
                                composer7.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            composer7 = composer5;
                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash10);
                            Updater.set-impl(composer6, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                            int i1115 = (i1112 >> 6) & 14;
                            Composer composer14 = composer7;
                            ComposerKt.sourceInformationMarkerStart(composer14, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScope columnScope8 = ColumnScopeInstance.INSTANCE;
                            int i1116 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer14, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                            TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer14, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer14, 199686, 0, 131026);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer14, 6);
                            TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer14, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer14, 3072, 0, 131058);
                            ComposerKt.sourceInformationMarkerEnd(composer14);
                            ComposerKt.sourceInformationMarkerEnd(composer14);
                            composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        composer4 = $composer2;
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash9);
                        Updater.set-impl(composer3, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                        int i1117 = (i119 >> 6) & 14;
                        composer5 = composer4;
                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                        int i1118 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer5, 1679320255, "C779@34019L731:WhatsAppDashboard.kt#naom5h");
                        ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier9 = Modifier.Companion;
                        MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                        CompositionLocalMap currentCompositionLocalMap11 = composer5.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer5, modifier9);
                        constructor4 = ComposeUiNode.Companion.getConstructor();
                        int i1119 = ((((0 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer5.startReusableNode();
                        if (composer5.getInserting()) {
                            function5 = constructor4;
                            composer5.createNode(function5);
                        } else {
                            function5 = constructor4;
                            composer5.useNode();
                        }
                        composer6 = Updater.constructor-impl(composer5);
                        Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer6, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash11 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer6.getInserting()) {
                            composer7 = composer5;
                            if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            }
                            Updater.set-impl(composer6, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
                            int i11110 = (i1119 >> 6) & 14;
                            Composer composer15 = composer7;
                            ComposerKt.sourceInformationMarkerStart(composer15, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScope columnScope9 = ColumnScopeInstance.INSTANCE;
                            int i11111 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer15, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                            TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer15, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer15, 199686, 0, 131026);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer15, 6);
                            TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer15, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer15, 3072, 0, 131058);
                            ComposerKt.sourceInformationMarkerEnd(composer15);
                            ComposerKt.sourceInformationMarkerEnd(composer15);
                            composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            ComposerKt.sourceInformationMarkerEnd(composer5);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        composer7 = composer5;
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composer6.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash11);
                        Updater.set-impl(composer6, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
                        int i11112 = (i1119 >> 6) & 14;
                        Composer composer16 = composer7;
                        ComposerKt.sourceInformationMarkerStart(composer16, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope columnScope10 = ColumnScopeInstance.INSTANCE;
                        int i11113 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer16, -1788995472, "C784@34313L11,780@34060L306,786@34399L40,790@34658L11,787@34472L248:WhatsAppDashboard.kt#naom5h");
                        TextKt.Text--4IGK_g("INSTRUCTIONS TO GEMINI:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer16, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer16, 199686, 0, 131026);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), composer16, 6);
                        TextKt.Text--4IGK_g(personalityTone2.getPromptInstructions(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer16, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer16, 3072, 0, 131058);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        ComposerKt.sourceInformationMarkerEnd(composer16);
                        composer7.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, 196608, 8);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:60:0x045c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0468  */
    /* JADX WARN: Code duplicated, block: B:64:0x046e  */
    /* JADX WARN: Code duplicated, block: B:67:0x049f  */
    /* JADX WARN: Code duplicated, block: B:70:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:71:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:74:0x0567  */
    /* JADX WARN: Code duplicated, block: B:80:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:84:0x060e  */
    public static final void SchedulerTab(WhatsAppViewModel viewModel, final List<ScheduledMessage> list, Composer $composer, final int $changed) {
        Object objMutableStateOf$default;
        Object objMutableStateOf$default2;
        Object objMutableStateOf$default3;
        Object objMutableStateOf$default4;
        MutableState recipient$delegate;
        ColumnScope columnScope;
        boolean zChangedInstance;
        Object obj;
        Composer composer;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function0;
        Composer composer2;
        Composer composer3;
        final WhatsAppViewModel whatsAppViewModel = viewModel;
        Intrinsics.checkNotNullParameter(whatsAppViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(list, "scheduledMessages");
        Composer $composer2 = $composer.startRestartGroup(-1164163817);
        ComposerKt.sourceInformation($composer2, "C(SchedulerTab)P(1)806@34985L31,807@35040L31,808@35102L31,811@35212L39,821@35439L6969:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(whatsAppViewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1164163817, $dirty2, -1, "com.example.ui.SchedulerTab (WhatsAppDashboard.kt:805)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2069926826, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue = $composer2.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue;
            }
            MutableState recipient$delegate2 = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2069925066, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue2 = $composer2.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default2);
            } else {
                objMutableStateOf$default2 = objRememberedValue2;
            }
            final MutableState messageText$delegate = (MutableState) objMutableStateOf$default2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2069923082, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue3 = $composer2.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default3);
            } else {
                objMutableStateOf$default3 = objRememberedValue3;
            }
            final MutableState delayMinutesString$delegate = (MutableState) objMutableStateOf$default3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2069919554, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue4 = $composer2.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default4);
            } else {
                objMutableStateOf$default4 = objRememberedValue4;
            }
            final MutableState selectedDelayPreset$delegate = (MutableState) objMutableStateOf$default4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final List presetOptions = CollectionsKt.listOf(new Pair[]{new Pair("2 Min", 2), new Pair("10 Min", 10), new Pair("1 Hour", 60), new Pair("4 Hours", 240), new Pair("24 Hours", 1440)});
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxSize$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor2);
            } else {
                $composer2.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer2);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting()) {
                recipient$delegate = recipient$delegate2;
            } else {
                recipient$delegate = recipient$delegate2;
                if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i2 = (i >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i3 = ((6 >> 6) & 112) | 6;
                columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 62846455, "C825@35621L10,826@35679L11,822@35491L279,831@35862L11,831@35820L69,836@36053L5183,830@35780L5456,950@41409L10,951@41467L11,947@41281L277:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Schedule WhatsApp Message", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196662, 0, 65496);
                whatsAppViewModel = viewModel;
                final MutableState recipient$delegate3 = recipient$delegate;
                CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2010272513, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135(whatsAppViewModel, recipient$delegate3, messageText$delegate, presetOptions, selectedDelayPreset$delegate, delayMinutesString$delegate, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, $composer2, 54), $composer2, 196614, 24);
                TextKt.Text--4IGK_g("Scheduled Message Queue", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(10), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196662, 0, 65496);
                if (list.isEmpty()) {
                    $composer2.startReplaceGroup(68707066);
                    ComposerKt.sourceInformation($composer2, "956@41615L419");
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default);
                    constructor = ComposeUiNode.Companion.getConstructor();
                    int i4 = ((((48 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        function0 = constructor;
                        $composer2.createNode(function0);
                    } else {
                        function0 = constructor;
                        $composer2.useNode();
                    }
                    composer2 = Updater.constructor-impl($composer2);
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer2.getInserting()) {
                        composer3 = $composer2;
                    } else {
                        composer3 = $composer2;
                        if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        int i5 = (i4 >> 6) & 14;
                        Composer composer5 = composer3;
                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer5, -971031518, "C964@41909L10,965@41974L11,962@41809L211:WhatsAppDashboard.kt#naom5h");
                        TextKt.Text--4IGK_g("No scheduled messages", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getBodyMedium(), composer5, 6, 0, 65530);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        $composer2.endReplaceGroup();
                        composer = $composer2;
                    }
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    int i7 = (i4 >> 6) & 14;
                    Composer composer6 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i8 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer6, -971031518, "C964@41909L10,965@41974L11,962@41809L211:WhatsAppDashboard.kt#naom5h");
                    TextKt.Text--4IGK_g("No scheduled messages", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getBodyMedium(), composer6, 6, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    $composer2.endReplaceGroup();
                    composer = $composer2;
                } else {
                    $composer2.startReplaceGroup(69149653);
                    ComposerKt.sourceInformation($composer2, "972@42204L188,969@42064L328");
                    Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
                    ComposerKt.sourceInformationMarkerStart($composer2, -967595927, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance = $composer2.changedInstance(list) | $composer2.changedInstance(whatsAppViewModel);
                    Object objRememberedValue5 = $composer2.rememberedValue();
                    if (!zChangedInstance || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda32
                            public final Object invoke(Object obj2) {
                                return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$140$lambda$139(list, whatsAppViewModel, (LazyListScope) obj2);
                            }
                        };
                        $composer2.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LazyDslKt.LazyColumn(modifierWeight$default, (LazyListState) null, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, $composer2, 24576, 238);
                    composer = $composer2;
                    composer.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i9 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i10 = ((6 >> 6) & 112) | 6;
            columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 62846455, "C825@35621L10,826@35679L11,822@35491L279,831@35862L11,831@35820L69,836@36053L5183,830@35780L5456,950@41409L10,951@41467L11,947@41281L277:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Schedule WhatsApp Message", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196662, 0, 65496);
            whatsAppViewModel = viewModel;
            final MutableState recipient$delegate4 = recipient$delegate;
            CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2010272513, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135(whatsAppViewModel, recipient$delegate4, messageText$delegate, presetOptions, selectedDelayPreset$delegate, delayMinutesString$delegate, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer2, 54), $composer2, 196614, 24);
            TextKt.Text--4IGK_g("Scheduled Message Queue", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(10), 7, (Object) null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196662, 0, 65496);
            if (list.isEmpty()) {
                $composer2.startReplaceGroup(68707066);
                ComposerKt.sourceInformation($composer2, "956@41615L419");
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default2);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i11 = ((((48 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function0 = constructor;
                    $composer2.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer2.useNode();
                }
                composer2 = Updater.constructor-impl($composer2);
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting()) {
                    composer3 = $composer2;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    int i12 = (i11 >> 6) & 14;
                    Composer composer7 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i13 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer7, -971031518, "C964@41909L10,965@41974L11,962@41809L211:WhatsAppDashboard.kt#naom5h");
                    TextKt.Text--4IGK_g("No scheduled messages", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getBodyMedium(), composer7, 6, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    $composer2.endReplaceGroup();
                    composer = $composer2;
                } else {
                    composer3 = $composer2;
                }
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i14 = (i11 >> 6) & 14;
                Composer composer8 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                int i15 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer8, -971031518, "C964@41909L10,965@41974L11,962@41809L211:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("No scheduled messages", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer8, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer8, MaterialTheme.$stable).getBodyMedium(), composer8, 6, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $composer2.endReplaceGroup();
                composer = $composer2;
            } else {
                $composer2.startReplaceGroup(69149653);
                ComposerKt.sourceInformation($composer2, "972@42204L188,969@42064L328");
                Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                Arrangement.Vertical vertical2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
                ComposerKt.sourceInformationMarkerStart($composer2, -967595927, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer2.changedInstance(list) | $composer2.changedInstance(whatsAppViewModel);
                Object objRememberedValue6 = $composer2.rememberedValue();
                if (zChangedInstance) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda32
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$140$lambda$139(list, whatsAppViewModel, (LazyListScope) obj2);
                        }
                    };
                    $composer2.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda32
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$140$lambda$139(list, whatsAppViewModel, (LazyListScope) obj2);
                        }
                    };
                    $composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyColumn(modifierWeight$default2, (LazyListState) null, (PaddingValues) null, false, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, $composer2, 24576, 238);
                composer = $composer2;
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.SchedulerTab$lambda$142(whatsAppViewModel, list, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String SchedulerTab$lambda$110(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String SchedulerTab$lambda$113(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String SchedulerTab$lambda$116(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final Integer SchedulerTab$lambda$119(MutableState<Integer> mutableState) {
        return (Integer) ((State) mutableState).getValue();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0770  */
    /* JADX WARN: Code duplicated, block: B:103:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x046c  */
    /* JADX WARN: Code duplicated, block: B:58:0x049d  */
    /* JADX WARN: Code duplicated, block: B:61:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:69:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0529  */
    /* JADX WARN: Code duplicated, block: B:73:0x053c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0554  */
    /* JADX WARN: Code duplicated, block: B:77:0x058f  */
    /* JADX WARN: Code duplicated, block: B:78:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:82:0x0666  */
    /* JADX WARN: Code duplicated, block: B:83:0x0674  */
    /* JADX WARN: Code duplicated, block: B:93:0x0700  */
    static final Unit SchedulerTab$lambda$141$lambda$135(final WhatsAppViewModel $viewModel, final MutableState $recipient$delegate, final MutableState $messageText$delegate, List $presetOptions, final MutableState $selectedDelayPreset$delegate, final MutableState $delayMinutesString$delegate, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        Object obj;
        Function0 function1;
        Composer composer;
        Composer composer2;
        int i;
        int i2;
        List<Pair> list;
        int i3;
        Object objRememberedValue;
        Object obj2;
        boolean z;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Integer numSchedulerTab$lambda$119;
        boolean z2;
        boolean z3;
        boolean zChanged;
        Object objRememberedValue3;
        int i4;
        long j;
        long j2;
        Composer composer3;
        long j3;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C837@36067L5159:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2010272513, $changed, -1, "com.example.ui.SchedulerTab.<anonymous>.<anonymous> (WhatsAppDashboard.kt:837)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i5 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i6 = (i5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1818342069, "C841@36257L18,839@36163L501,850@36682L41,855@36875L20,853@36779L513,865@37310L41,870@37504L10,872@37618L11,868@37407L248,875@37689L40,877@37747L1318,901@39083L41,906@39286L122,904@39183L606,918@39807L41,935@40882L11,935@40838L64,921@39904L674,920@39866L1346:WhatsAppDashboard.kt#naom5h");
            String strSchedulerTab$lambda$110 = SchedulerTab$lambda$110($recipient$delegate);
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), "schedule_recipient_input");
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, -1742461145, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue4 = $composer.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$122$lambda$121($recipient$delegate, (String) obj3);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(strSchedulerTab$lambda$110, (Function1) obj, modifierTestTag, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m19getLambda$809792625$app(), (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1867191885$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, shape, (TextFieldColors) null, $composer, 102236592, 0, 0, 6291128);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            String strSchedulerTab$lambda$113 = SchedulerTab$lambda$113($messageText$delegate);
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(80)), "schedule_text_input");
            Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, -1742441367, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue5 = $composer.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$124$lambda$123($messageText$delegate, (String) obj3);
                    }
                };
                $composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(strSchedulerTab$lambda$113, (Function1) objRememberedValue5, modifierTestTag2, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m8getLambda$1576294650$app(), (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m9getLambda$1679590844$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, shape2, (TextFieldColors) null, $composer, 102236592, 0, 0, 6291128);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            TextKt.Text--4IGK_g("Select Delay Time:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i8 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor2;
                $composer.createNode(function1);
            } else {
                function1 = constructor2;
                $composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl($composer);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting()) {
                composer = $composer;
            } else {
                composer = $composer;
                if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i9 = (i8 >> 6) & 14;
                composer2 = composer;
                i = 0;
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                i2 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, 1389863394, "C:WhatsAppDashboard.kt#naom5h");
                composer2.startReplaceGroup(-2033375245);
                ComposerKt.sourceInformation(composer2, "*884@38113L149,888@38300L15,889@38377L337,883@38059L966");
                list = $presetOptions;
                i3 = 0;
                for (Pair pair : list) {
                    Iterable iterable = list;
                    final String str = (String) pair.component1();
                    int i10 = i3;
                    final int iIntValue = ((Number) pair.component2()).intValue();
                    numSchedulerTab$lambda$119 = SchedulerTab$lambda$119($selectedDelayPreset$delegate);
                    int i11 = i;
                    if (numSchedulerTab$lambda$119 == null && numSchedulerTab$lambda$119.intValue() == iIntValue) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1908884601, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChanged = composer2.changed(iIntValue);
                    Composer composer6 = composer2;
                    objRememberedValue3 = composer6.rememberedValue();
                    if (zChanged) {
                        i4 = i2;
                    } else {
                        i4 = i2;
                        if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                        }
                        Function0 function2 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-264027724, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda23
                            public final Object invoke(Object obj3, Object obj4) {
                                return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$127(str, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54);
                        SuggestionChipDefaults suggestionChipDefaults = SuggestionChipDefaults.INSTANCE;
                        if (z3) {
                            composer2.startReplaceGroup(-1908872411);
                            ComposerKt.sourceInformation(composer2, "890@38478L11");
                            j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-1908871427);
                            composer2.endReplaceGroup();
                            j = Color.Companion.getTransparent-0d7_KjU();
                        }
                        long j4 = j;
                        if (z3) {
                            composer2.startReplaceGroup(-1908868231);
                            ComposerKt.sourceInformation(composer2, "891@38617L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer2.startReplaceGroup(-1908866974);
                            ComposerKt.sourceInformation(composer2, "891@38656L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer2.endReplaceGroup();
                        composer3 = composer2;
                        ChipColors chipColors = suggestionChipDefaults.suggestionChipColors-5tl4gsc(j4, j2, 0L, 0L, 0L, 0L, composer3, SuggestionChipDefaults.$stable << 18, 60);
                        float f = Dp.constructor-impl(1);
                        if (z3) {
                            composer3.startReplaceGroup(-1908859719);
                            ComposerKt.sourceInformation(composer3, "895@38883L11");
                            j3 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer3.startReplaceGroup(-1908857916);
                            ComposerKt.sourceInformation(composer3, "895@38922L11");
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer3.endReplaceGroup();
                        ChipKt.SuggestionChip(function2, function2RememberComposableLambda, (Modifier) null, false, (Function2) null, (Shape) null, chipColors, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f, j3), (MutableInteractionSource) null, composer3, 48, 700);
                        composer2 = composer3;
                        list = iterable;
                        i3 = i10;
                        i = i11;
                        i2 = i4;
                    }
                    objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$126$lambda$125(iIntValue, $selectedDelayPreset$delegate, $delayMinutesString$delegate);
                        }
                    };
                    composer6.updateRememberedValue(objRememberedValue3);
                    Function0 function3 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-264027724, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj3, Object obj4) {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$127(str, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54);
                    SuggestionChipDefaults suggestionChipDefaults2 = SuggestionChipDefaults.INSTANCE;
                    if (z3) {
                        composer2.startReplaceGroup(-1908872411);
                        ComposerKt.sourceInformation(composer2, "890@38478L11");
                        j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-1908871427);
                        composer2.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j5 = j;
                    if (z3) {
                        composer2.startReplaceGroup(-1908868231);
                        ComposerKt.sourceInformation(composer2, "891@38617L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer2.startReplaceGroup(-1908866974);
                        ComposerKt.sourceInformation(composer2, "891@38656L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer2.endReplaceGroup();
                    composer3 = composer2;
                    ChipColors chipColors2 = suggestionChipDefaults2.suggestionChipColors-5tl4gsc(j5, j2, 0L, 0L, 0L, 0L, composer3, SuggestionChipDefaults.$stable << 18, 60);
                    float f2 = Dp.constructor-impl(1);
                    if (z3) {
                        composer3.startReplaceGroup(-1908859719);
                        ComposerKt.sourceInformation(composer3, "895@38883L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer3.startReplaceGroup(-1908857916);
                        ComposerKt.sourceInformation(composer3, "895@38922L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer3.endReplaceGroup();
                    ChipKt.SuggestionChip(function3, function2RememberComposableLambda2, (Modifier) null, false, (Function2) null, (Shape) null, chipColors2, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f2, j3), (MutableInteractionSource) null, composer3, 48, 700);
                    composer2 = composer3;
                    list = iterable;
                    i3 = i10;
                    i = i11;
                    i2 = i4;
                }
                Composer composer7 = composer2;
                composer7.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
                String strSchedulerTab$lambda$116 = SchedulerTab$lambda$116($delayMinutesString$delegate);
                Modifier modifierTestTag3 = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), "schedule_delay_input");
                Shape shape3 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer, -1742364113, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue = $composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda24
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$131$lambda$130($delayMinutesString$delegate, $selectedDelayPreset$delegate, (String) obj3);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OutlinedTextFieldKt.OutlinedTextField(strSchedulerTab$lambda$116, (Function1) obj2, modifierTestTag3, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1717616775$app(), (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1614320581$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, shape3, (TextFieldColors) null, $composer, 102236592, 0, 0, 6291128);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer, 6);
                if (!StringsKt.isBlank(SchedulerTab$lambda$110($recipient$delegate)) || StringsKt.isBlank(SchedulerTab$lambda$113($messageText$delegate)) || (SchedulerTab$lambda$119($selectedDelayPreset$delegate) == null && StringsKt.toIntOrNull(SchedulerTab$lambda$116($delayMinutesString$delegate)) == null)) {
                    z = false;
                } else {
                    z = true;
                }
                Shape shape4 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
                Modifier modifierTestTag4 = TestTagKt.testTag(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), "schedule_submit_button");
                ComposerKt.sourceInformationMarkerStart($composer, -1742343785, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer.changedInstance($viewModel);
                objRememberedValue2 = $composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda25
                        public final Object invoke() {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$133$lambda$132($viewModel, $selectedDelayPreset$delegate, $delayMinutesString$delegate, $recipient$delegate, $messageText$delegate);
                        }
                    };
                    $composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) objRememberedValue2, modifierTestTag4, z, shape4, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m7getLambda$1500628507$app(), $composer, 805306416, 480);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer5.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i12 = (i8 >> 6) & 14;
            composer2 = composer;
            i = 0;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, 1389863394, "C:WhatsAppDashboard.kt#naom5h");
            composer2.startReplaceGroup(-2033375245);
            ComposerKt.sourceInformation(composer2, "*884@38113L149,888@38300L15,889@38377L337,883@38059L966");
            list = $presetOptions;
            i3 = 0;
            while (r81.hasNext()) {
                Iterable iterable2 = list;
                final String str2 = (String) pair.component1();
                int i13 = i3;
                final int iIntValue2 = ((Number) pair.component2()).intValue();
                numSchedulerTab$lambda$119 = SchedulerTab$lambda$119($selectedDelayPreset$delegate);
                int i14 = i;
                if (numSchedulerTab$lambda$119 == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z3 = z2;
                ComposerKt.sourceInformationMarkerStart(composer2, -1908884601, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChanged = composer2.changed(iIntValue2);
                Composer composer8 = composer2;
                objRememberedValue3 = composer8.rememberedValue();
                if (zChanged) {
                    i4 = i2;
                    if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function4 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-264027724, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj3, Object obj4) {
                            return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$127(str2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54);
                    SuggestionChipDefaults suggestionChipDefaults3 = SuggestionChipDefaults.INSTANCE;
                    if (z3) {
                        composer2.startReplaceGroup(-1908872411);
                        ComposerKt.sourceInformation(composer2, "890@38478L11");
                        j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-1908871427);
                        composer2.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j6 = j;
                    if (z3) {
                        composer2.startReplaceGroup(-1908868231);
                        ComposerKt.sourceInformation(composer2, "891@38617L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer2.startReplaceGroup(-1908866974);
                        ComposerKt.sourceInformation(composer2, "891@38656L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer2.endReplaceGroup();
                    composer3 = composer2;
                    ChipColors chipColors3 = suggestionChipDefaults3.suggestionChipColors-5tl4gsc(j6, j2, 0L, 0L, 0L, 0L, composer3, SuggestionChipDefaults.$stable << 18, 60);
                    float f3 = Dp.constructor-impl(1);
                    if (z3) {
                        composer3.startReplaceGroup(-1908859719);
                        ComposerKt.sourceInformation(composer3, "895@38883L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer3.startReplaceGroup(-1908857916);
                        ComposerKt.sourceInformation(composer3, "895@38922L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer3.endReplaceGroup();
                    ChipKt.SuggestionChip(function4, function2RememberComposableLambda3, (Modifier) null, false, (Function2) null, (Shape) null, chipColors3, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f3, j3), (MutableInteractionSource) null, composer3, 48, 700);
                    composer2 = composer3;
                    list = iterable2;
                    i3 = i13;
                    i = i14;
                    i2 = i4;
                } else {
                    i4 = i2;
                }
                objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$126$lambda$125(iIntValue2, $selectedDelayPreset$delegate, $delayMinutesString$delegate);
                    }
                };
                composer8.updateRememberedValue(objRememberedValue3);
                Function0 function5 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Function2 function2RememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-264027724, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$127(str2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54);
                SuggestionChipDefaults suggestionChipDefaults4 = SuggestionChipDefaults.INSTANCE;
                if (z3) {
                    composer2.startReplaceGroup(-1908872411);
                    ComposerKt.sourceInformation(composer2, "890@38478L11");
                    j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1908871427);
                    composer2.endReplaceGroup();
                    j = Color.Companion.getTransparent-0d7_KjU();
                }
                long j7 = j;
                if (z3) {
                    composer2.startReplaceGroup(-1908868231);
                    ComposerKt.sourceInformation(composer2, "891@38617L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer2.startReplaceGroup(-1908866974);
                    ComposerKt.sourceInformation(composer2, "891@38656L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer2.endReplaceGroup();
                composer3 = composer2;
                ChipColors chipColors4 = suggestionChipDefaults4.suggestionChipColors-5tl4gsc(j7, j2, 0L, 0L, 0L, 0L, composer3, SuggestionChipDefaults.$stable << 18, 60);
                float f4 = Dp.constructor-impl(1);
                if (z3) {
                    composer3.startReplaceGroup(-1908859719);
                    ComposerKt.sourceInformation(composer3, "895@38883L11");
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer3.startReplaceGroup(-1908857916);
                    ComposerKt.sourceInformation(composer3, "895@38922L11");
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer3.endReplaceGroup();
                ChipKt.SuggestionChip(function5, function2RememberComposableLambda4, (Modifier) null, false, (Function2) null, (Shape) null, chipColors4, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f4, j3), (MutableInteractionSource) null, composer3, 48, 700);
                composer2 = composer3;
                list = iterable2;
                i3 = i13;
                i = i14;
                i2 = i4;
            }
            Composer composer9 = composer2;
            composer9.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer9);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            String strSchedulerTab$lambda$117 = SchedulerTab$lambda$116($delayMinutesString$delegate);
            Modifier modifierTestTag5 = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), "schedule_delay_input");
            Shape shape5 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, -1742364113, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$131$lambda$130($delayMinutesString$delegate, $selectedDelayPreset$delegate, (String) obj3);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(strSchedulerTab$lambda$117, (Function1) obj2, modifierTestTag5, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1717616775$app(), (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1614320581$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, shape5, (TextFieldColors) null, $composer, 102236592, 0, 0, 6291128);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer, 6);
            if (StringsKt.isBlank(SchedulerTab$lambda$110($recipient$delegate))) {
                z = false;
            } else {
                z = false;
            }
            Shape shape6 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            ButtonColors buttonColors2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
            Modifier modifierTestTag6 = TestTagKt.testTag(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), "schedule_submit_button");
            ComposerKt.sourceInformationMarkerStart($composer, -1742343785, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance = $composer.changedInstance($viewModel);
            objRememberedValue2 = $composer.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$133$lambda$132($viewModel, $selectedDelayPreset$delegate, $delayMinutesString$delegate, $recipient$delegate, $messageText$delegate);
                    }
                };
                $composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        return WhatsAppDashboardKt.SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$133$lambda$132($viewModel, $selectedDelayPreset$delegate, $delayMinutesString$delegate, $recipient$delegate, $messageText$delegate);
                    }
                };
                $composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) objRememberedValue2, modifierTestTag6, z, shape6, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m7getLambda$1500628507$app(), $composer, 805306416, 480);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$122$lambda$121(MutableState $recipient$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $recipient$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$124$lambda$123(MutableState $messageText$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $messageText$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$126$lambda$125(int $minutes, MutableState $selectedDelayPreset$delegate, MutableState $delayMinutesString$delegate) {
        $selectedDelayPreset$delegate.setValue(Integer.valueOf($minutes));
        $delayMinutesString$delegate.setValue("");
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$129$lambda$128$lambda$127(String $label, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C888@38302L11:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-264027724, $changed, -1, "com.example.ui.SchedulerTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:888)");
            }
            TextKt.Text--4IGK_g($label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$131$lambda$130(MutableState $delayMinutesString$delegate, MutableState $selectedDelayPreset$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $delayMinutesString$delegate.setValue(it);
        $selectedDelayPreset$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$135$lambda$134$lambda$133$lambda$132(WhatsAppViewModel $viewModel, MutableState $selectedDelayPreset$delegate, MutableState $delayMinutesString$delegate, MutableState $recipient$delegate, MutableState $messageText$delegate) {
        Integer numSchedulerTab$lambda$119 = SchedulerTab$lambda$119($selectedDelayPreset$delegate);
        int minutes = (numSchedulerTab$lambda$119 == null && (numSchedulerTab$lambda$119 = StringsKt.toIntOrNull(SchedulerTab$lambda$116($delayMinutesString$delegate))) == null) ? 0 : numSchedulerTab$lambda$119.intValue();
        if (!StringsKt.isBlank(SchedulerTab$lambda$110($recipient$delegate)) && !StringsKt.isBlank(SchedulerTab$lambda$113($messageText$delegate)) && minutes > 0) {
            long scheduledTime = System.currentTimeMillis() + ((long) (minutes * 60 * 1000));
            $viewModel.scheduleMessage(SchedulerTab$lambda$110($recipient$delegate), SchedulerTab$lambda$113($messageText$delegate), scheduledTime);
            $recipient$delegate.setValue("");
            $messageText$delegate.setValue("");
            $delayMinutesString$delegate.setValue("");
            $selectedDelayPreset$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }

    static final Unit SchedulerTab$lambda$141$lambda$140$lambda$139(final List $scheduledMessages, final WhatsAppViewModel $viewModel, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$SchedulerTab$lambda$141$lambda$140$lambda$139$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m28invoke((ScheduledMessage) p1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m28invoke(ScheduledMessage scheduledMessage) {
                return null;
            }
        };
        $this$LazyColumn.items($scheduledMessages.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.example.ui.WhatsAppDashboardKt$SchedulerTab$lambda$141$lambda$140$lambda$139$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke($scheduledMessages.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$SchedulerTab$lambda$141$lambda$140$lambda$139$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Object obj;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final ScheduledMessage scheduledMessage = (ScheduledMessage) $scheduledMessages.get(it);
                $composer.startReplaceGroup(1402424702);
                ComposerKt.sourceInformation($composer, "C*974@42315L44,974@42276L84:WhatsAppDashboard.kt#naom5h");
                ComposerKt.sourceInformationMarkerStart($composer, -1478779939, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChangedInstance = ((((i & 112) ^ 48) > 32 && $composer.changed(scheduledMessage)) || (i & 48) == 32) | $composer.changedInstance($viewModel);
                Object objRememberedValue = $composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    final WhatsAppViewModel whatsAppViewModel = $viewModel;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$SchedulerTab$1$3$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m27invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m27invoke() {
                            whatsAppViewModel.deleteScheduledMessage(scheduledMessage.getId());
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                WhatsAppDashboardKt.ScheduledRowItem(scheduledMessage, (Function0) obj, $composer, (i >> 3) & 14);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void ScheduledRowItem(final ScheduledMessage msg, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(function0, "onDelete");
        Composer $composer2 = $composer.startRestartGroup(-1450368193);
        ComposerKt.sourceInformation($composer2, "C(ScheduledRowItem)983@42513L152,989@42749L11,989@42707L69,992@42870L2962,988@42671L3161:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(msg) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1450368193, $dirty, -1, "com.example.ui.ScheduledRowItem (WhatsAppDashboard.kt:982)");
            }
            long scheduledTime = msg.getScheduledTime();
            ComposerKt.sourceInformationMarkerStart($composer2, 2060541111, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged = $composer2.changed(scheduledTime);
            Object objRememberedValue = $composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault()).format(new Date(msg.getScheduledTime()));
                $composer2.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            final String dateString = (String) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(418899121, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda40
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ScheduledRowItem$lambda$149(msg, dateString, function0, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer2, 54), $composer2, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda41
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.ScheduledRowItem$lambda$150(msg, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:96:0x080b  */
    static final Unit ScheduledRowItem$lambda$149(ScheduledMessage $msg, String $dateString, Function0 $onDelete, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        Function0 function1;
        Function0 function2;
        Function0 function3;
        Function0 function4;
        Composer composer;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C993@42880L2946:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(418899121, $changed, -1, "com.example.ui.ScheduledRowItem.<anonymous> (WhatsAppDashboard.kt:993)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(14));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((390 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl($composer);
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i3 = ((390 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1838799057, "C999@43065L2751:WhatsAppDashboard.kt#naom5h");
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifierWeight$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor2;
                $composer.createNode(function1);
            } else {
                function1 = constructor2;
                $composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1601550624, "C1000@43122L739,1018@43879L40,1022@44029L10,1023@44093L11,1020@43937L202,1026@44157L40,1028@44215L1587:WhatsAppDashboard.kt#naom5h");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, centerVertically2, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            int i7 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function2 = constructor3;
                $composer.createNode(function2);
            } else {
                function2 = constructor3;
                $composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            int i8 = (i7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i9 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -906397839, "C1008@43521L10,1005@43360L203,1012@43679L10,1013@43748L11,1010@43584L259:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("To: " + $msg.getRecipient(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 196608, 0, 65502);
            Intrinsics.checkNotNull($dateString);
            TextKt.Text--4IGK_g($dateString, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 196608, 0, 65498);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            TextKt.Text--4IGK_g($msg.getMessageText(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 0, 0, 65530);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default2);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            int i10 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function3 = constructor4;
                $composer.createNode(function3);
            } else {
                function3 = constructor4;
                $composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl($composer);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            int i11 = (i10 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            int i12 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 575903406, "C1036@44669L554,1051@45292L492:WhatsAppDashboard.kt#naom5h");
            String str = $msg.isSent() ? "SENT / NOTIFIED" : "PENDING AUTO-SEND";
            long successGreen = $msg.isSent() ? ColorKt.getSuccessGreen() : ColorKt.getAlertYellow();
            Modifier modifier2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Color.copy-wmQWz5c$default(successGreen, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier($composer, modifier2);
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            int i13 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function4 = constructor5;
                $composer.createNode(function4);
            } else {
                function4 = constructor5;
                $composer.useNode();
            }
            Composer composer6 = Updater.constructor-impl($composer);
            Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer6.getInserting()) {
                composer = $composer;
            } else {
                composer = $composer;
                if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                }
                Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                int i14 = (i13 >> 6) & 14;
                Composer composer7 = composer;
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i15 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer7, 327761874, "C1042@44972L229:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g(str, (Modifier) null, successGreen, TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer7, 199680, 0, 131026);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                IconButtonKt.IconButton($onDelete, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1855552259$app(), $composer, 196656, 28);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            composer6.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            int i16 = (i13 >> 6) & 14;
            Composer composer8 = composer;
            ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i17 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer8, 327761874, "C1042@44972L229:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g(str, (Modifier) null, successGreen, TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer8, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton($onDelete, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1855552259$app(), $composer, 196656, 28);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void AddToneDialog(final Function0<Unit> function0, final Function3<? super String, ? super String, ? super String, Unit> function3, Composer $composer, final int $changed) {
        Object objMutableStateOf$default;
        Object objMutableStateOf$default2;
        Object objMutableStateOf$default3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "onSave");
        Composer $composer3 = $composer.startRestartGroup(-1161054613);
        ComposerKt.sourceInformation($composer3, "C(AddToneDialog)1073@45986L31,1074@46041L31,1075@46091L31,1107@47494L250,1115@47770L102,1080@46245L1223,1077@46128L1750:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161054613, $dirty, -1, "com.example.ui.AddToneDialog (WhatsAppDashboard.kt:1072)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 918018698, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue = $composer3.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue;
            }
            final MutableState name$delegate = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 918020458, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue2 = $composer3.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default2);
            } else {
                objMutableStateOf$default2 = objRememberedValue2;
            }
            final MutableState description$delegate = (MutableState) objMutableStateOf$default2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 918022058, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue3 = $composer3.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(objMutableStateOf$default3);
            } else {
                objMutableStateOf$default3 = objRememberedValue3;
            }
            final MutableState prompt$delegate = (MutableState) objMutableStateOf$default3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1542420771, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.AddToneDialog$lambda$162(function3, name$delegate, description$delegate, prompt$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(919139169, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.AddToneDialog$lambda$163(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$295857567$app(), ComposableLambdaKt.rememberComposableLambda(2131700414, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.AddToneDialog$lambda$171(name$delegate, description$delegate, prompt$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, ($dirty & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.AddToneDialog$lambda$172(function0, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String AddToneDialog$lambda$152(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String AddToneDialog$lambda$155(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final String AddToneDialog$lambda$158(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x016a  */
    /* JADX WARN: Code duplicated, block: B:29:0x017e  */
    /* JADX WARN: Code duplicated, block: B:32:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:33:0x020c  */
    /* JADX WARN: Code duplicated, block: B:36:0x028d  */
    /* JADX WARN: Code duplicated, block: B:37:0x029f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0309  */
    static final Unit AddToneDialog$lambda$171(final MutableState $name$delegate, final MutableState $description$delegate, final MutableState $prompt$delegate, Composer $composer, int $changed) {
        int i;
        Object objRememberedValue;
        Object obj;
        Object objRememberedValue2;
        Object obj2;
        Object objRememberedValue3;
        Object obj3;
        ComposerKt.sourceInformation($composer, "C1081@46259L1199:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2131700414, $changed, -1, "com.example.ui.AddToneDialog.<anonymous> (WhatsAppDashboard.kt:1081)");
            }
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((48 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            Composer composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting()) {
                i = 48;
            } else {
                i = 48;
                if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1158468730, "C1084@46424L13,1082@46335L310,1091@46758L20,1089@46662L339,1098@47109L15,1096@47018L426:WhatsAppDashboard.kt#naom5h");
                String strAddToneDialog$lambda$152 = AddToneDialog$lambda$152($name$delegate);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 101179125, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue = $composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda35
                        public final Object invoke(Object obj4) {
                            return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$165$lambda$164($name$delegate, (String) obj4);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd((Composer) r2);
                OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$152, (Function1) obj, modifierFillMaxWidth$default, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1556702766$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m4getLambda$1247695825$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, (Composer) r2, 14156208, 0, 0, 8388408);
                String strAddToneDialog$lambda$155 = AddToneDialog$lambda$155($description$delegate);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 101189820, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue2 = $composer.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda36
                        public final Object invoke(Object obj4) {
                            return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$167$lambda$166($description$delegate, (String) obj4);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$155, (Function1) obj2, modifierFillMaxWidth$default2, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m15getLambda$535911145$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1676504792$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 0, 0, 8388408);
                String strAddToneDialog$lambda$158 = AddToneDialog$lambda$158($prompt$delegate);
                Modifier modifier2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(120));
                ComposerKt.sourceInformationMarkerStart($composer, 101201047, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue3 = $composer.rememberedValue();
                if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    obj3 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda37
                        public final Object invoke(Object obj4) {
                            return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$169$lambda$168($prompt$delegate, (String) obj4);
                        }
                    };
                    $composer.updateRememberedValue(obj3);
                } else {
                    obj3 = objRememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$158, (Function1) obj3, modifier2, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1487588406$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m16getLambda$594962953$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 0, 0, 8388408);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i5 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1158468730, "C1084@46424L13,1082@46335L310,1091@46758L20,1089@46662L339,1098@47109L15,1096@47018L426:WhatsAppDashboard.kt#naom5h");
            String strAddToneDialog$lambda$153 = AddToneDialog$lambda$152($name$delegate);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 101179125, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda35
                    public final Object invoke(Object obj4) {
                        return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$165$lambda$164($name$delegate, (String) obj4);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd((Composer) r2);
            OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$153, (Function1) obj, modifierFillMaxWidth$default3, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1556702766$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m4getLambda$1247695825$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, (Composer) r2, 14156208, 0, 0, 8388408);
            String strAddToneDialog$lambda$156 = AddToneDialog$lambda$155($description$delegate);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 101189820, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue2 = $composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                obj2 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda36
                    public final Object invoke(Object obj4) {
                        return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$167$lambda$166($description$delegate, (String) obj4);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$156, (Function1) obj2, modifierFillMaxWidth$default4, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m15getLambda$535911145$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1676504792$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 0, 0, 8388408);
            String strAddToneDialog$lambda$159 = AddToneDialog$lambda$158($prompt$delegate);
            Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(120));
            ComposerKt.sourceInformationMarkerStart($composer, 101201047, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue3 = $composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                obj3 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda37
                    public final Object invoke(Object obj4) {
                        return WhatsAppDashboardKt.AddToneDialog$lambda$171$lambda$170$lambda$169$lambda$168($prompt$delegate, (String) obj4);
                    }
                };
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = objRememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(strAddToneDialog$lambda$159, (Function1) obj3, modifier3, false, false, (TextStyle) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1487588406$app(), ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m16getLambda$594962953$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 0, 0, 8388408);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$171$lambda$170$lambda$165$lambda$164(MutableState $name$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $name$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$171$lambda$170$lambda$167$lambda$166(MutableState $description$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $description$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$171$lambda$170$lambda$169$lambda$168(MutableState $prompt$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $prompt$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$162(final Function3 $onSave, MutableState $name$delegate, MutableState $description$delegate, MutableState $prompt$delegate, Composer $composer, int $changed) {
        Object obj;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        ComposerKt.sourceInformation($composer, "C1109@47542L37,1108@47508L226:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542420771, $changed, -1, "com.example.ui.AddToneDialog.<anonymous> (WhatsAppDashboard.kt:1108)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 502645384, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged = $composer.changed($onSave);
            Object objRememberedValue = $composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                mutableState = $name$delegate;
                mutableState2 = $description$delegate;
                mutableState3 = $prompt$delegate;
                obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda26
                    public final Object invoke() {
                        return WhatsAppDashboardKt.AddToneDialog$lambda$162$lambda$161$lambda$160($onSave, mutableState, mutableState2, mutableState3);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                mutableState = $name$delegate;
                mutableState2 = $description$delegate;
                mutableState3 = $prompt$delegate;
                obj = objRememberedValue;
            }
            Function0 function0 = (Function0) obj;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(function0, (Modifier) null, (StringsKt.isBlank(AddToneDialog$lambda$152(mutableState)) || StringsKt.isBlank(AddToneDialog$lambda$155(mutableState2)) || StringsKt.isBlank(AddToneDialog$lambda$158(mutableState3))) ? false : true, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1549228851$app(), $composer, 805306368, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$162$lambda$161$lambda$160(Function3 $onSave, MutableState $name$delegate, MutableState $description$delegate, MutableState $prompt$delegate) {
        $onSave.invoke(AddToneDialog$lambda$152($name$delegate), AddToneDialog$lambda$155($description$delegate), AddToneDialog$lambda$158($prompt$delegate));
        return Unit.INSTANCE;
    }

    static final Unit AddToneDialog$lambda$163(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1116@47784L78:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(919139169, $changed, -1, "com.example.ui.AddToneDialog.<anonymous> (WhatsAppDashboard.kt:1116)");
            }
            ButtonKt.TextButton($onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$533862532$app(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ChatHistoryDetailDialog(final String sender, final List<WhatsAppMessage> list, final Function0<Unit> function0, final Function0<Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(list, "logs");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function1, "onDeleteAll");
        Composer $composer3 = $composer.startRestartGroup(106778351);
        ComposerKt.sourceInformation($composer3, "C(ChatHistoryDetailDialog)P(3!1,2)1223@52901L97,1132@48106L562,1144@48685L4190,1130@48039L4965:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(sender) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(106778351, $dirty, -1, "com.example.ui.ChatHistoryDetailDialog (WhatsAppDashboard.kt:1129)");
            }
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(-989218905, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda53
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$173(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), (Modifier) null, (Function2) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(2136205091, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda54
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$175(sender, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(1843819266, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda56
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$186(list, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer3, 54), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, (($dirty >> 6) & 14) | 1769520, 0, 16284);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda57
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$187(sender, list, function0, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ChatHistoryDetailDialog$lambda$175(String $sender, Function0 $onDeleteAll, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1133@48120L538:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136205091, $changed, -1, "com.example.ui.ChatHistoryDetailDialog.<anonymous> (WhatsAppDashboard.kt:1133)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            Composer composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -2020531406, "C1138@48338L97,1139@48452L192:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g($sender, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 196608, 3120, 120798);
            IconButtonKt.IconButton($onDeleteAll, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$77748290$app(), $composer, 196608, 30);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0145  */
    /* JADX WARN: Code duplicated, block: B:30:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:33:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:34:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:37:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:40:0x020e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0211  */
    /* JADX WARN: Code duplicated, block: B:44:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:50:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:54:0x033d  */
    static final Unit ChatHistoryDetailDialog$lambda$186(final List $logs, Composer $composer, int $changed) {
        Function0 function0;
        int i;
        boolean zChangedInstance;
        Object obj;
        Composer composer;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer2;
        Composer composer3;
        ComposerKt.sourceInformation($composer, "C1145@48699L4166:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1843819266, $changed, -1, "com.example.ui.ChatHistoryDetailDialog.<anonymous> (WhatsAppDashboard.kt:1145)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(300));
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor2;
                $composer.createNode(function0);
            } else {
                function0 = constructor2;
                $composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer);
            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting()) {
                i = i2;
            } else {
                i = i2;
                if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 855448256, "C:WhatsAppDashboard.kt#naom5h");
                if ($logs.isEmpty()) {
                    $composer.startReplaceGroup(855349861);
                    ComposerKt.sourceInformation($composer, "1151@48886L153");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxSize$default);
                    constructor = ComposeUiNode.Companion.getConstructor();
                    int i5 = ((((54 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function1 = constructor;
                        $composer.createNode(function1);
                    } else {
                        function1 = constructor;
                        $composer.useNode();
                    }
                    composer2 = Updater.constructor-impl($composer);
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer2.getInserting()) {
                        composer3 = $composer;
                    } else {
                        composer3 = $composer;
                        if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        int i6 = (i5 >> 6) & 14;
                        Composer composer5 = composer3;
                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i7 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer5, 163490347, "C1152@48988L29:WhatsAppDashboard.kt#naom5h");
                        TextKt.Text--4IGK_g("No logs for this chat", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer5, 6, 0, 131070);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        $composer.endReplaceGroup();
                        composer = $composer;
                    }
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    int i8 = (i5 >> 6) & 14;
                    Composer composer6 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i9 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer6, 163490347, "C1152@48988L29:WhatsAppDashboard.kt#naom5h");
                    TextKt.Text--4IGK_g("No logs for this chat", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer6, 6, 0, 131070);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    $composer.endReplaceGroup();
                    composer = $composer;
                } else {
                    $composer.startReplaceGroup(855658714);
                    ComposerKt.sourceInformation($composer, "1159@49297L3536,1155@49085L3748");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart($composer, -2050600852, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance = $composer.changedInstance($logs);
                    Object objRememberedValue = $composer.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj2) {
                                return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183($logs, (LazyListScope) obj2);
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    composer = $composer;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default2, (LazyListState) null, (PaddingValues) null, true, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer, 27654, 230);
                    composer.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                r7.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer) r7);
                ComposerKt.sourceInformationMarkerEnd((Composer) r7);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i10 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            int i11 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 855448256, "C:WhatsAppDashboard.kt#naom5h");
            if ($logs.isEmpty()) {
                $composer.startReplaceGroup(855349861);
                ComposerKt.sourceInformation($composer, "1151@48886L153");
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxSize$default3);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i12 = ((((54 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer.useNode();
                }
                composer2 = Updater.constructor-impl($composer);
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting()) {
                    composer3 = $composer;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    int i13 = (i12 >> 6) & 14;
                    Composer composer7 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                    int i14 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer7, 163490347, "C1152@48988L29:WhatsAppDashboard.kt#naom5h");
                    TextKt.Text--4IGK_g("No logs for this chat", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer7, 6, 0, 131070);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    $composer.endReplaceGroup();
                    composer = $composer;
                } else {
                    composer3 = $composer;
                }
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i15 = (i12 >> 6) & 14;
                Composer composer8 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
                int i16 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer8, 163490347, "C1152@48988L29:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("No logs for this chat", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer8, 6, 0, 131070);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $composer.endReplaceGroup();
                composer = $composer;
            } else {
                $composer.startReplaceGroup(855658714);
                ComposerKt.sourceInformation($composer, "1159@49297L3536,1155@49085L3748");
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Vertical vertical2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart($composer, -2050600852, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer.changedInstance($logs);
                Object objRememberedValue2 = $composer.rememberedValue();
                if (zChangedInstance) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183($logs, (LazyListScope) obj2);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183($logs, (LazyListScope) obj2);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                composer = $composer;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default4, (LazyListState) null, (PaddingValues) null, true, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer, 27654, 230);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            r7.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer) r7);
            ComposerKt.sourceInformationMarkerEnd((Composer) r7);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183(final List $logs, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m20invoke((WhatsAppMessage) p1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m20invoke(WhatsAppMessage whatsAppMessage) {
                return null;
            }
        };
        $this$LazyColumn.items($logs.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke($logs.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatHistoryDetailDialog$lambda$186$lambda$185$lambda$184$lambda$183$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Object obj;
                Function0 function0;
                Function0 function2;
                Function0 function3;
                Function0 function4;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                WhatsAppMessage whatsAppMessage = (WhatsAppMessage) $logs.get(it);
                $composer.startReplaceGroup(-155988103);
                ComposerKt.sourceInformation($composer, "C*1166@49749L208,1171@49987L2798:WhatsAppDashboard.kt#naom5h");
                boolean zIsIncoming = whatsAppMessage.isIncoming();
                long cosmicBubbleIncoming = zIsIncoming ? ColorKt.getCosmicBubbleIncoming() : ColorKt.getEmeraldAccentLight();
                long cosmicTextPrimary = zIsIncoming ? ColorKt.getCosmicTextPrimary() : androidx.compose.ui.graphics.ColorKt.Color(4279311137L);
                Alignment.Companion companion = Alignment.Companion;
                Alignment.Horizontal start = zIsIncoming ? companion.getStart() : companion.getEnd();
                long timestamp = whatsAppMessage.getTimestamp();
                ComposerKt.sourceInformationMarkerStart($composer, 410618981, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                boolean zChanged = $composer.changed(timestamp);
                Object objRememberedValue = $composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    obj = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(whatsAppMessage.getTimestamp()));
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                String str = (String) obj;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function0 = constructor;
                    $composer.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer.useNode();
                }
                Composer composer = Updater.constructor-impl($composer);
                Updater.set-impl(composer, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 34209020, "C1175@50187L2568:WhatsAppDashboard.kt#naom5h");
                Modifier modifier = SizeKt.widthIn-VpY3zN4$default(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(16), zIsIncoming ? Dp.constructor-impl(16) : Dp.constructor-impl(4), zIsIncoming ? Dp.constructor-impl(4) : Dp.constructor-impl(16))), cosmicBubbleIncoming, (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8)), 0.0f, Dp.constructor-impl(220), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                int i5 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function2 = constructor2;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer.useNode();
                }
                Composer composer2 = Updater.constructor-impl($composer);
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i6 = (i5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1201171427, "C1189@51050L1671:WhatsAppDashboard.kt#naom5h");
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Modifier modifier2 = Modifier.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifier2);
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                int i8 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function3 = constructor3;
                    $composer.createNode(function3);
                } else {
                    function3 = constructor3;
                    $composer.useNode();
                }
                Composer composer3 = Updater.constructor-impl($composer);
                Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i9 = (i8 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i10 = ((0 >> 6) & 112) | 6;
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 535102160, "C1190@51099L239,1195@51379L40,1196@51460L1223:WhatsAppDashboard.kt#naom5h");
                long j = cosmicTextPrimary;
                TextKt.Text--4IGK_g(whatsAppMessage.getMessageText(), (Modifier) null, j, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131058);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
                Modifier modifierAlign = columnScope2.align(Modifier.Companion, Alignment.Companion.getEnd());
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap4 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer, modifierAlign);
                Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                int i11 = ((((384 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function4 = constructor4;
                    $composer.createNode(function4);
                } else {
                    function4 = constructor4;
                    $composer.useNode();
                }
                Composer composer4 = Updater.constructor-impl($composer);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                int i12 = (i11 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i13 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1713927627, "C1209@52373L268:WhatsAppDashboard.kt#naom5h");
                if (zIsIncoming || whatsAppMessage.getToneName() == null) {
                    $composer.startReplaceGroup(-1765273021);
                } else {
                    $composer.startReplaceGroup(-1713897930);
                    ComposerKt.sourceInformation($composer, "1201@51821L461");
                    TextKt.Text--4IGK_g(whatsAppMessage.getToneName(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null), Color.copy-wmQWz5c$default(j, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199728, 0, 131024);
                }
                $composer.endReplaceGroup();
                Intrinsics.checkNotNull(str);
                TextKt.Text--4IGK_g(str, (Modifier) null, Color.copy-wmQWz5c$default(j, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), TextUnitKt.getSp(9), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131058);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    static final Unit ChatHistoryDetailDialog$lambda$173(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1224@52915L73:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-989218905, $changed, -1, "com.example.ui.ChatHistoryDetailDialog.<anonymous> (WhatsAppDashboard.kt:1224)");
            }
            ButtonKt.Button($onDismiss, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m17getLambda$627724873$app(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final boolean isNotificationServiceEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String pkgName = context.getPackageName();
        String flat = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        String str = flat;
        if (!(str == null || str.length() == 0)) {
            List<String> names = StringsKt.split$default(flat, new String[]{":"}, false, 0, 6, (Object) null);
            for (String name : names) {
                ComponentName cn = ComponentName.unflattenFromString(name);
                if (cn != null && Intrinsics.areEqual(cn.getPackageName(), pkgName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0971  */
    /* JADX WARN: Code duplicated, block: B:127:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:131:0x09db  */
    /* JADX WARN: Code duplicated, block: B:135:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:138:0x0ab5  */
    /* JADX WARN: Code duplicated, block: B:139:0x0abb  */
    /* JADX WARN: Code duplicated, block: B:142:0x0aec  */
    /* JADX WARN: Code duplicated, block: B:146:0x0b02 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x0ba1  */
    /* JADX WARN: Code duplicated, block: B:151:0x0bb1  */
    /* JADX WARN: Code duplicated, block: B:154:0x0c5f  */
    /* JADX WARN: Code duplicated, block: B:158:0x0c6c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:162:0x0cd2  */
    /* JADX WARN: Code duplicated, block: B:50:0x0249  */
    /* JADX WARN: Code duplicated, block: B:53:0x0255  */
    /* JADX WARN: Code duplicated, block: B:54:0x0259  */
    /* JADX WARN: Code duplicated, block: B:57:0x0288  */
    /* JADX WARN: Code duplicated, block: B:60:0x029b  */
    /* JADX WARN: Code duplicated, block: B:61:0x029e  */
    /* JADX WARN: Code duplicated, block: B:65:0x041c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0428  */
    /* JADX WARN: Code duplicated, block: B:69:0x042e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0461  */
    /* JADX WARN: Code duplicated, block: B:76:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:80:0x051c  */
    /* JADX WARN: Code duplicated, block: B:82:0x053e  */
    /* JADX WARN: Code duplicated, block: B:86:0x054c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:92:0x05ce  */
    public static final void ChatbotTab(WhatsAppViewModel viewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Object objMutableStateOf$default;
        int i2;
        Object objMutableStateOf$default2;
        MutableState showSettings$delegate;
        WhatsAppDashboardKt$ChatbotTab$1$1 whatsAppDashboardKt$ChatbotTab$1$1;
        MeasurePolicy measurePolicyColumnMeasurePolicy;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer;
        Composer composer2;
        MeasurePolicy measurePolicy;
        Composer composer3;
        ColumnScope columnScope;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Function0 function0;
        Composer composer4;
        final State messages$delegate;
        boolean zChanged;
        Object obj;
        int currentCompositeKeyHash3;
        Function0 constructor3;
        Function0 function1;
        Composer composer5;
        Object objRememberedValue;
        boolean zChanged2;
        Object obj2;
        Function0 function2;
        Function0 function3;
        boolean zChangedInstance;
        Object objRememberedValue2;
        final WhatsAppViewModel whatsAppViewModel = viewModel;
        Intrinsics.checkNotNullParameter(whatsAppViewModel, "viewModel");
        Composer $composer2 = $composer.startRestartGroup(1726953796);
        ComposerKt.sourceInformation($composer2, "C(ChatbotTab)P(1)1251@53667L29,1252@53761L29,1253@53837L29,1254@53930L29,1255@54019L29,1257@54071L31,1258@54127L34,1260@54183L23,1263@54305L115,1263@54261L159,1276@55002L17554:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(whatsAppViewModel) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1726953796, $dirty, -1, "com.example.ui.ChatbotTab (WhatsAppDashboard.kt:1250)");
            }
            State messages$delegate2 = FlowExtKt.collectAsStateWithLifecycle(whatsAppViewModel.getChatbotMessages(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State systemInstruction$delegate = FlowExtKt.collectAsStateWithLifecycle(whatsAppViewModel.getChatbotSystemInstruction(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State activeModel$delegate = FlowExtKt.collectAsStateWithLifecycle(whatsAppViewModel.getChatbotModel(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State useChatbotForReplies$delegate = FlowExtKt.collectAsStateWithLifecycle(whatsAppViewModel.getUseChatbotForReplies(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            final State isGenerating$delegate = FlowExtKt.collectAsStateWithLifecycle(whatsAppViewModel.isGeneratingChatbotReply(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            ComposerKt.sourceInformationMarkerStart($composer2, 1745239331, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue3 = $composer2.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue3;
            }
            final MutableState textInput$delegate = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1745241126, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            Object objRememberedValue4 = $composer2.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                i2 = 0;
                objMutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(objMutableStateOf$default2);
            } else {
                i2 = 0;
                objMutableStateOf$default2 = objRememberedValue4;
            }
            MutableState showSettings$delegate2 = (MutableState) objMutableStateOf$default2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int i4 = i2;
            LazyListState listState = LazyListStateKt.rememberLazyListState(i4, i4, $composer2, i4, 3);
            Integer numValueOf = Integer.valueOf(ChatbotTab$lambda$188(messages$delegate2).size());
            Boolean boolValueOf = Boolean.valueOf(ChatbotTab$lambda$192(isGenerating$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, 1745246903, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged3 = $composer2.changed(messages$delegate2) | $composer2.changed(listState);
            Object objRememberedValue5 = $composer2.rememberedValue();
            if (zChanged3) {
                showSettings$delegate = showSettings$delegate2;
            } else {
                showSettings$delegate = showSettings$delegate2;
                if (objRememberedValue5 != Composer.Companion.getEmpty()) {
                    whatsAppDashboardKt$ChatbotTab$1$1 = objRememberedValue5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(numValueOf, boolValueOf, (Function2) whatsAppDashboardKt$ChatbotTab$1$1, $composer2, 0);
                final List presetRoles = CollectionsKt.listOf(new Triple[]{new Triple("⚡ Lite Fast", "Reply in 1-2 extremely short, simple, and casual sentences.", "gemini-3.1-flash-lite-preview"), new Triple("💼 Pro Agent", "Reply in a highly professional, well-structured, formal, and polite manner.", "gemini-3.5-flash"), new Triple("🧠 Deep Brain", "Reply with deep analytical reasoning, highly logical structure, and robust depth.", "gemini-3.1-pro-preview"), new Triple("😏 Witty Buddy", "Reply with clever banter, dry sarcasm, playful wit, and a touch of modern slang.", "gemini-3.5-flash")});
                Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifier4);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i5 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor);
                } else {
                    $composer2.useNode();
                }
                composer = Updater.constructor-impl($composer2);
                Updater.set-impl(composer, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer.getInserting()) {
                    composer2 = $composer2;
                    measurePolicy = measurePolicyColumnMeasurePolicy;
                } else {
                    composer2 = $composer2;
                    measurePolicy = measurePolicyColumnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    }
                    Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    int i6 = (i5 >> 6) & 14;
                    composer3 = composer2;
                    ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                    int i7 = ((0 >> 6) & 112) | 6;
                    columnScope = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 792601090, "C1284@55266L11,1283@55207L118,1290@55489L8923,1282@55167L9245,1451@64468L1151,1581@70531L40,1584@70602L1948:WhatsAppDashboard.kt#naom5h");
                    Modifier modifier5 = modifier3;
                    whatsAppViewModel = viewModel;
                    final MutableState showSettings$delegate3 = showSettings$delegate;
                    Composer composer6 = composer2;
                    CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(365315884, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda55
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226(showSettings$delegate3, whatsAppViewModel, useChatbotForReplies$delegate, activeModel$delegate, presetRoles, systemInstruction$delegate, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composer3, 54), composer3, 196614, 24);
                    Modifier modifier6 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifier6);
                    constructor2 = ComposeUiNode.Companion.getConstructor();
                    int i8 = ((((438 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        function0 = constructor2;
                        composer3.createNode(function0);
                    } else {
                        function0 = constructor2;
                        composer3.useNode();
                    }
                    composer4 = Updater.constructor-impl(composer3);
                    Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    int i9 = (i8 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i10 = ((438 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer3, 644981233, "C1461@64863L10,1462@64925L11,1458@64725L238:WhatsAppDashboard.kt#naom5h");
                    TextKt.Text--4IGK_g("Conversational Thread", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 196614, 0, 65498);
                    if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                        composer3.startReplaceGroup(580745636);
                    } else {
                        composer3.startReplaceGroup(645248390);
                        ComposerKt.sourceInformation(composer3, "1466@65063L35,1467@65190L11,1467@65144L64,1465@65021L574");
                        ComposerKt.sourceInformationMarkerStart(composer3, -117731519, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                        zChangedInstance = $composer2.changedInstance(whatsAppViewModel);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (!zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda66
                                public final Object invoke() {
                                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$229$lambda$228$lambda$227(whatsAppViewModel);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$2005371894$app(), composer3, 805306368, 494);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ChatbotTab$lambda$188(messages$delegate2).isEmpty() || ChatbotTab$lambda$192(isGenerating$delegate)) {
                        composer3.startReplaceGroup(804281610);
                        ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                        Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                        Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                        ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                        messages$delegate = messages$delegate2;
                        zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                        Object objRememberedValue6 = composer3.rememberedValue();
                        if (!zChanged || objRememberedValue6 == Composer.Companion.getEmpty()) {
                            obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                                public final Object invoke(Object obj3) {
                                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                                }
                            };
                            composer3.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue6;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LazyDslKt.LazyColumn(modifier7, listState, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(802579400);
                        ComposerKt.sourceInformation(composer3, "1482@65731L1640");
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                        int i11 = ((((48 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            function2 = constructor4;
                            composer3.createNode(function2);
                        } else {
                            function2 = constructor4;
                            composer3.useNode();
                        }
                        Composer composer7 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer7, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer7, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer7.getInserting() || !Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composer7.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash3);
                        }
                        Updater.set-impl(composer7, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        int i12 = (i11 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i13 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer3, -435248528, "C1488@65925L1432:WhatsAppDashboard.kt#naom5h");
                        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        Modifier modifier8 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32));
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifier8);
                        Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                        int i14 = ((((390 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            function3 = constructor5;
                            composer3.createNode(function3);
                        } else {
                            function3 = constructor5;
                            composer3.useNode();
                        }
                        Composer composer8 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer8, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer8.getInserting() || !Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                            composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                            composer8.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash4);
                        }
                        Updater.set-impl(composer8, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        int i15 = (i14 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        int i16 = ((390 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer3, 476804059, "C1495@66269L11,1492@66100L296,1498@66417L41,1501@66599L10,1503@66722L11,1499@66479L347,1506@66847L40,1509@67148L10,1510@67216L11,1507@66908L431:WhatsAppDashboard.kt#naom5h");
                        IconKt.Icon-ww6aTOc(ForumKt.getForum(Icons.INSTANCE.getDefault()), "Empty Chat", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer3, 432, 0);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer3, 6);
                        TextKt.Text--4IGK_g("Say hello to your Gemini Chatbot!", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyMedium(), composer3, 196614, 0, 64986);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer3, 6);
                        TextKt.Text--4IGK_g("Converse freely with the AI under your custom profile role. This chatbot configuration is also used to power high-speed WhatsApp replies when toggled on.", (Modifier) null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 6, 0, 65018);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        messages$delegate = messages$delegate2;
                    }
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer3, 6);
                    Modifier modifier9 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontal, centerVertically2, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer3, modifier9);
                    constructor3 = ComposeUiNode.Companion.getConstructor();
                    int i17 = ((((438 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        function1 = constructor3;
                        composer3.createNode(function1);
                    } else {
                        function1 = constructor3;
                        composer3.useNode();
                    }
                    composer5 = Updater.constructor-impl(composer3);
                    Updater.set-impl(composer5, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash5);
                    }
                    Updater.set-impl(composer5, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                    int i18 = (i17 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    int i19 = ((438 >> 6) & 112) | 6;
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -731159969, "C1593@70947L18,1600@71268L465,1591@70861L886,1620@72069L11,1621@72135L11,1614@71809L211,1613@71761L779:WhatsAppDashboard.kt#naom5h");
                    String strChatbotTab$lambda$194 = ChatbotTab$lambda$194(textInput$delegate);
                    Modifier modifierTestTag = TestTagKt.testTag(RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null), "chatbot_message_input");
                    Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24));
                    ComposerKt.sourceInformationMarkerStart(composer3, 1638983271, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda75
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$236$lambda$235(textInput$delegate, (String) obj3);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$194, (Function1) objRememberedValue, modifierTestTag, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m6getLambda$1496483698$app(), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1553349044, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda76
                        public final Object invoke(Object obj3, Object obj4) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$239(textInput$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer3, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 0, (MutableInteractionSource) null, shape, (TextFieldColors) null, composer3, 817889328, 100663296, 0, 6028664);
                    long j = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    long j2 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                    Shape circleShape = RoundedCornerShapeKt.getCircleShape();
                    Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), "chatbot_send_button");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1639011048, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChanged2 = $composer2.changed(isGenerating$delegate) | $composer2.changedInstance(whatsAppViewModel);
                    Object objRememberedValue7 = composer3.rememberedValue();
                    if (!zChanged2 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                        obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$241$lambda$240(whatsAppViewModel, textInput$delegate, isGenerating$delegate);
                            }
                        };
                        composer3.updateRememberedValue(obj2);
                    } else {
                        obj2 = objRememberedValue7;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) obj2, modifierTestTag2, circleShape, j, j2, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1023153687$app(), composer3, 12582960, 96);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier5;
                }
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i20 = (i5 >> 6) & 14;
                composer3 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i21 = ((0 >> 6) & 112) | 6;
                columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 792601090, "C1284@55266L11,1283@55207L118,1290@55489L8923,1282@55167L9245,1451@64468L1151,1581@70531L40,1584@70602L1948:WhatsAppDashboard.kt#naom5h");
                Modifier modifier10 = modifier3;
                whatsAppViewModel = viewModel;
                final MutableState showSettings$delegate4 = showSettings$delegate;
                Composer composer9 = composer2;
                CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(365315884, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda55
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226(showSettings$delegate4, whatsAppViewModel, useChatbotForReplies$delegate, activeModel$delegate, presetRoles, systemInstruction$delegate, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composer3, 54), composer3, 196614, 24);
                Modifier modifier11 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer3, modifier11);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                int i22 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    function0 = constructor2;
                    composer3.createNode(function0);
                } else {
                    function0 = constructor2;
                    composer3.useNode();
                }
                composer4 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                }
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash6);
                Updater.set-impl(composer4, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                int i23 = (i22 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                int i110 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, 644981233, "C1461@64863L10,1462@64925L11,1458@64725L238:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Conversational Thread", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 196614, 0, 65498);
                if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                    composer3.startReplaceGroup(645248390);
                    ComposerKt.sourceInformation(composer3, "1466@65063L35,1467@65190L11,1467@65144L64,1465@65021L574");
                    ComposerKt.sourceInformationMarkerStart(composer3, -117731519, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance = $composer2.changedInstance(whatsAppViewModel);
                    objRememberedValue2 = composer3.rememberedValue();
                    if (!zChangedInstance) {
                    }
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda66
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$229$lambda$228$lambda$227(whatsAppViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$2005371894$app(), composer3, 805306368, 494);
                } else {
                    composer3.startReplaceGroup(580745636);
                }
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                    composer3.startReplaceGroup(804281610);
                    ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                    Modifier modifier12 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Arrangement.Vertical vertical2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    messages$delegate = messages$delegate2;
                    zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                    Object objRememberedValue8 = composer3.rememberedValue();
                    if (zChanged) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    } else {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LazyDslKt.LazyColumn(modifier12, listState, (PaddingValues) null, false, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(804281610);
                    ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                    Modifier modifier13 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Arrangement.Vertical vertical3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    messages$delegate = messages$delegate2;
                    zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                    Object objRememberedValue9 = composer3.rememberedValue();
                    if (zChanged) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    } else {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LazyDslKt.LazyColumn(modifier13, listState, (PaddingValues) null, false, vertical3, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                    composer3.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer3, 6);
                Modifier modifier14 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontal2, centerVertically4, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer3, modifier14);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                int i111 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    function1 = constructor3;
                    composer3.createNode(function1);
                } else {
                    function1 = constructor3;
                    composer3.useNode();
                }
                composer5 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer5, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer5.getInserting()) {
                }
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash7);
                Updater.set-impl(composer5, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
                int i112 = (i111 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                int i113 = ((438 >> 6) & 112) | 6;
                RowScope rowScope4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -731159969, "C1593@70947L18,1600@71268L465,1591@70861L886,1620@72069L11,1621@72135L11,1614@71809L211,1613@71761L779:WhatsAppDashboard.kt#naom5h");
                String strChatbotTab$lambda$195 = ChatbotTab$lambda$194(textInput$delegate);
                Modifier modifierTestTag3 = TestTagKt.testTag(RowScope.weight$default(rowScope4, Modifier.Companion, 1.0f, false, 2, (Object) null), "chatbot_message_input");
                Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart(composer3, 1638983271, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda75
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$236$lambda$235(textInput$delegate, (String) obj3);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$195, (Function1) objRememberedValue, modifierTestTag3, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m6getLambda$1496483698$app(), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1553349044, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda76
                    public final Object invoke(Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$239(textInput$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer3, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 0, (MutableInteractionSource) null, shape2, (TextFieldColors) null, composer3, 817889328, 100663296, 0, 6028664);
                long j3 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                long j4 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                Shape circleShape2 = RoundedCornerShapeKt.getCircleShape();
                Modifier modifierTestTag4 = TestTagKt.testTag(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), "chatbot_send_button");
                ComposerKt.sourceInformationMarkerStart(composer3, 1639011048, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChanged2 = $composer2.changed(isGenerating$delegate) | $composer2.changedInstance(whatsAppViewModel);
                Object objRememberedValue10 = composer3.rememberedValue();
                if (zChanged2) {
                }
                obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$241$lambda$240(whatsAppViewModel, textInput$delegate, isGenerating$delegate);
                    }
                };
                composer3.updateRememberedValue(obj2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) obj2, modifierTestTag4, circleShape2, j3, j4, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1023153687$app(), composer3, 12582960, 96);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier10;
            }
            whatsAppDashboardKt$ChatbotTab$1$1 = new WhatsAppDashboardKt$ChatbotTab$1$1(listState, messages$delegate2, null);
            $composer2.updateRememberedValue(whatsAppDashboardKt$ChatbotTab$1$1);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(numValueOf, boolValueOf, (Function2) whatsAppDashboardKt$ChatbotTab$1$1, $composer2, 0);
            final List presetRoles2 = CollectionsKt.listOf(new Triple[]{new Triple("⚡ Lite Fast", "Reply in 1-2 extremely short, simple, and casual sentences.", "gemini-3.1-flash-lite-preview"), new Triple("💼 Pro Agent", "Reply in a highly professional, well-structured, formal, and polite manner.", "gemini-3.5-flash"), new Triple("🧠 Deep Brain", "Reply with deep analytical reasoning, highly logical structure, and robust depth.", "gemini-3.1-pro-preview"), new Triple("😏 Witty Buddy", "Reply with clever banter, dry sarcasm, playful wit, and a touch of modern slang.", "gemini-3.5-flash")});
            Modifier modifier15 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap8 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier($composer2, modifier15);
            constructor = ComposeUiNode.Companion.getConstructor();
            int i24 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            composer = Updater.constructor-impl($composer2);
            Updater.set-impl(composer, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting()) {
                composer2 = $composer2;
                measurePolicy = measurePolicyColumnMeasurePolicy;
                if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.set-impl(composer, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
                int i25 = (i24 >> 6) & 14;
                composer3 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i26 = ((0 >> 6) & 112) | 6;
                columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 792601090, "C1284@55266L11,1283@55207L118,1290@55489L8923,1282@55167L9245,1451@64468L1151,1581@70531L40,1584@70602L1948:WhatsAppDashboard.kt#naom5h");
                Modifier modifier16 = modifier3;
                whatsAppViewModel = viewModel;
                final MutableState showSettings$delegate5 = showSettings$delegate;
                Composer composer10 = composer2;
                CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(365315884, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda55
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226(showSettings$delegate5, whatsAppViewModel, useChatbotForReplies$delegate, activeModel$delegate, presetRoles2, systemInstruction$delegate, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composer3, 54), composer3, 196614, 24);
                Modifier modifier17 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Arrangement.Horizontal spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically5 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically5, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer3, modifier17);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                int i27 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    function0 = constructor2;
                    composer3.createNode(function0);
                } else {
                    function0 = constructor2;
                    composer3.useNode();
                }
                composer4 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                }
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash9);
                Updater.set-impl(composer4, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                int i28 = (i27 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope5 = RowScopeInstance.INSTANCE;
                int i114 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, 644981233, "C1461@64863L10,1462@64925L11,1458@64725L238:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Conversational Thread", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 196614, 0, 65498);
                if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                    composer3.startReplaceGroup(645248390);
                    ComposerKt.sourceInformation(composer3, "1466@65063L35,1467@65190L11,1467@65144L64,1465@65021L574");
                    ComposerKt.sourceInformationMarkerStart(composer3, -117731519, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance = $composer2.changedInstance(whatsAppViewModel);
                    objRememberedValue2 = composer3.rememberedValue();
                    if (!zChangedInstance) {
                    }
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda66
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$229$lambda$228$lambda$227(whatsAppViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$2005371894$app(), composer3, 805306368, 494);
                } else {
                    composer3.startReplaceGroup(580745636);
                }
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                    composer3.startReplaceGroup(804281610);
                    ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                    Modifier modifier18 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Arrangement.Vertical vertical4 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    messages$delegate = messages$delegate2;
                    zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                    Object objRememberedValue11 = composer3.rememberedValue();
                    if (zChanged) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    } else {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LazyDslKt.LazyColumn(modifier18, listState, (PaddingValues) null, false, vertical4, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(804281610);
                    ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                    Modifier modifier19 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    Arrangement.Vertical vertical5 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    messages$delegate = messages$delegate2;
                    zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                    Object objRememberedValue12 = composer3.rememberedValue();
                    if (zChanged) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    } else {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                            public final Object invoke(Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                            }
                        };
                        composer3.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    LazyDslKt.LazyColumn(modifier19, listState, (PaddingValues) null, false, vertical5, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                    composer3.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer3, 6);
                Modifier modifier110 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Alignment.Vertical centerVertically6 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontal3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(horizontal3, centerVertically6, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer3, modifier110);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                int i115 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    function1 = constructor3;
                    composer3.createNode(function1);
                } else {
                    function1 = constructor3;
                    composer3.useNode();
                }
                composer5 = Updater.constructor-impl(composer3);
                Updater.set-impl(composer5, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer5.getInserting()) {
                }
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash10);
                Updater.set-impl(composer5, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                int i116 = (i115 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                int i117 = ((438 >> 6) & 112) | 6;
                RowScope rowScope6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -731159969, "C1593@70947L18,1600@71268L465,1591@70861L886,1620@72069L11,1621@72135L11,1614@71809L211,1613@71761L779:WhatsAppDashboard.kt#naom5h");
                String strChatbotTab$lambda$196 = ChatbotTab$lambda$194(textInput$delegate);
                Modifier modifierTestTag5 = TestTagKt.testTag(RowScope.weight$default(rowScope6, Modifier.Companion, 1.0f, false, 2, (Object) null), "chatbot_message_input");
                Shape shape3 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart(composer3, 1638983271, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda75
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$236$lambda$235(textInput$delegate, (String) obj3);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$196, (Function1) objRememberedValue, modifierTestTag5, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m6getLambda$1496483698$app(), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1553349044, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda76
                    public final Object invoke(Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$239(textInput$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer3, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 0, (MutableInteractionSource) null, shape3, (TextFieldColors) null, composer3, 817889328, 100663296, 0, 6028664);
                long j5 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                long j6 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                Shape circleShape3 = RoundedCornerShapeKt.getCircleShape();
                Modifier modifierTestTag6 = TestTagKt.testTag(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), "chatbot_send_button");
                ComposerKt.sourceInformationMarkerStart(composer3, 1639011048, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChanged2 = $composer2.changed(isGenerating$delegate) | $composer2.changedInstance(whatsAppViewModel);
                Object objRememberedValue13 = composer3.rememberedValue();
                if (zChanged2) {
                }
                obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$241$lambda$240(whatsAppViewModel, textInput$delegate, isGenerating$delegate);
                    }
                };
                composer3.updateRememberedValue(obj2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) obj2, modifierTestTag6, circleShape3, j5, j6, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1023153687$app(), composer3, 12582960, 96);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer10.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier16;
            } else {
                composer2 = $composer2;
                measurePolicy = measurePolicyColumnMeasurePolicy;
            }
            composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash8);
            Updater.set-impl(composer, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            int i29 = (i24 >> 6) & 14;
            composer3 = composer2;
            ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i210 = ((0 >> 6) & 112) | 6;
            columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 792601090, "C1284@55266L11,1283@55207L118,1290@55489L8923,1282@55167L9245,1451@64468L1151,1581@70531L40,1584@70602L1948:WhatsAppDashboard.kt#naom5h");
            Modifier modifier111 = modifier3;
            whatsAppViewModel = viewModel;
            final MutableState showSettings$delegate6 = showSettings$delegate;
            Composer composer11 = composer2;
            CardKt.Card(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, composer3, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(365315884, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda55
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226(showSettings$delegate6, whatsAppViewModel, useChatbotForReplies$delegate, activeModel$delegate, presetRoles2, systemInstruction$delegate, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer3, 54), composer3, 196614, 24);
            Modifier modifier112 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            Arrangement.Horizontal spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically7 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(spaceBetween4, centerVertically7, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer3, modifier112);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            int i211 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                function0 = constructor2;
                composer3.createNode(function0);
            } else {
                function0 = constructor2;
                composer3.useNode();
            }
            composer4 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash11 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer4.getInserting()) {
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash11);
            Updater.set-impl(composer4, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
            int i212 = (i211 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope7 = RowScopeInstance.INSTANCE;
            int i118 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer3, 644981233, "C1461@64863L10,1462@64925L11,1458@64725L238:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Conversational Thread", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), composer3, 196614, 0, 65498);
            if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                composer3.startReplaceGroup(645248390);
                ComposerKt.sourceInformation(composer3, "1466@65063L35,1467@65190L11,1467@65144L64,1465@65021L574");
                ComposerKt.sourceInformationMarkerStart(composer3, -117731519, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance = $composer2.changedInstance(whatsAppViewModel);
                objRememberedValue2 = composer3.rememberedValue();
                if (!zChangedInstance) {
                }
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda66
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$229$lambda$228$lambda$227(whatsAppViewModel);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$2005371894$app(), composer3, 805306368, 494);
            } else {
                composer3.startReplaceGroup(580745636);
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ChatbotTab$lambda$188(messages$delegate2).isEmpty()) {
                composer3.startReplaceGroup(804281610);
                ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                Modifier modifier113 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Arrangement.Vertical vertical6 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                messages$delegate = messages$delegate2;
                zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                Object objRememberedValue14 = composer3.rememberedValue();
                if (zChanged) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                        }
                    };
                    composer3.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                        }
                    };
                    composer3.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                LazyDslKt.LazyColumn(modifier113, listState, (PaddingValues) null, false, vertical6, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(804281610);
                ComposerKt.sourceInformation(composer3, "1523@67678L2833,1516@67401L3110");
                Modifier modifier114 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                Arrangement.Vertical vertical7 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer3, 25953579, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                messages$delegate = messages$delegate2;
                zChanged = composer3.changed(messages$delegate) | composer3.changed(isGenerating$delegate);
                Object objRememberedValue15 = composer3.rememberedValue();
                if (zChanged) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                        }
                    };
                    composer3.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda74
                        public final Object invoke(Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$234$lambda$233(messages$delegate, isGenerating$delegate, (LazyListScope) obj3);
                        }
                    };
                    composer3.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                LazyDslKt.LazyColumn(modifier114, listState, (PaddingValues) null, false, vertical7, (Alignment.Horizontal) null, (FlingBehavior) null, false, (Function1) obj, composer3, 24576, 236);
                composer3.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer3, 6);
            Modifier modifier115 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            Alignment.Vertical centerVertically8 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontal4 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(horizontal4, centerVertically8, composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer3, modifier115);
            constructor3 = ComposeUiNode.Companion.getConstructor();
            int i119 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                function1 = constructor3;
                composer3.createNode(function1);
            } else {
                function1 = constructor3;
                composer3.useNode();
            }
            composer5 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash12 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer5.getInserting()) {
            }
            composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash12);
            Updater.set-impl(composer5, modifierMaterializeModifier12, ComposeUiNode.Companion.getSetModifier());
            int i1110 = (i119 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i1111 = ((438 >> 6) & 112) | 6;
            RowScope rowScope8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -731159969, "C1593@70947L18,1600@71268L465,1591@70861L886,1620@72069L11,1621@72135L11,1614@71809L211,1613@71761L779:WhatsAppDashboard.kt#naom5h");
            String strChatbotTab$lambda$197 = ChatbotTab$lambda$194(textInput$delegate);
            Modifier modifierTestTag7 = TestTagKt.testTag(RowScope.weight$default(rowScope8, Modifier.Companion, 1.0f, false, 2, (Object) null), "chatbot_message_input");
            Shape shape4 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart(composer3, 1638983271, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda75
                    public final Object invoke(Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$236$lambda$235(textInput$delegate, (String) obj3);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$197, (Function1) objRememberedValue, modifierTestTag7, false, false, (TextStyle) null, (Function2) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.m6getLambda$1496483698$app(), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1553349044, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda76
                public final Object invoke(Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$239(textInput$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer3, 54), (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 0, (MutableInteractionSource) null, shape4, (TextFieldColors) null, composer3, 817889328, 100663296, 0, 6028664);
            long j7 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            long j8 = MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
            Shape circleShape4 = RoundedCornerShapeKt.getCircleShape();
            Modifier modifierTestTag8 = TestTagKt.testTag(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), "chatbot_send_button");
            ComposerKt.sourceInformationMarkerStart(composer3, 1639011048, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChanged2 = $composer2.changed(isGenerating$delegate) | $composer2.changedInstance(whatsAppViewModel);
            Object objRememberedValue16 = composer3.rememberedValue();
            if (zChanged2) {
            }
            obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$241$lambda$240(whatsAppViewModel, textInput$delegate, isGenerating$delegate);
                }
            };
            composer3.updateRememberedValue(obj2);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) obj2, modifierTestTag8, circleShape4, j7, j8, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1023153687$app(), composer3, 12582960, 96);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer11.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier111;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$244(whatsAppViewModel, modifier2, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<WhatsAppMessage> ChatbotTab$lambda$188(State<? extends List<WhatsAppMessage>> state) {
        return (List) state.getValue();
    }

    private static final String ChatbotTab$lambda$189(State<String> state) {
        return (String) state.getValue();
    }

    private static final String ChatbotTab$lambda$190(State<String> state) {
        return (String) state.getValue();
    }

    private static final boolean ChatbotTab$lambda$191(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean ChatbotTab$lambda$192(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final String ChatbotTab$lambda$194(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final boolean ChatbotTab$lambda$197(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ChatbotTab$lambda$198(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0178  */
    /* JADX WARN: Code duplicated, block: B:29:0x0186  */
    /* JADX WARN: Code duplicated, block: B:32:0x0211  */
    /* JADX WARN: Code duplicated, block: B:35:0x021d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0223  */
    /* JADX WARN: Code duplicated, block: B:47:0x032e  */
    /* JADX WARN: Code duplicated, block: B:50:0x033a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0340  */
    /* JADX WARN: Code duplicated, block: B:54:0x0371  */
    /* JADX WARN: Code duplicated, block: B:57:0x0384  */
    /* JADX WARN: Code duplicated, block: B:58:0x0387  */
    /* JADX WARN: Code duplicated, block: B:62:0x049d  */
    /* JADX WARN: Code duplicated, block: B:63:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:66:0x0552  */
    static final Unit ChatbotTab$lambda$243$lambda$226(final MutableState $showSettings$delegate, final WhatsAppViewModel $viewModel, final State $useChatbotForReplies$delegate, final State $activeModel$delegate, final List $presetRoles, final State $systemInstruction$delegate, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        int i;
        Object objRememberedValue;
        Object obj;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Function0 function2;
        Composer composer2;
        Composer composer3;
        Object objRememberedValue2;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C1291@55503L8899:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(365315884, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1291)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor3;
                $composer.createNode(function0);
            } else {
                function0 = constructor3;
                $composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl($composer);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting()) {
                i = 6;
            } else {
                i = 6;
                if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                }
                Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                int i4 = ((i >> 6) & 112) | 6;
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -84089751, "C1295@55684L32,1292@55564L1655,1326@57280L7108,1326@57237L7151:WhatsAppDashboard.kt#naom5h");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1388190846, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue = $composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$201$lambda$200($showSettings$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier2 = ClickableKt.clickable-XHw0xAI$default(modifierFillMaxWidth$default, false, (String) null, (Role) null, (Function0) obj, 7, (Object) null);
                Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier2);
                constructor = ComposeUiNode.Companion.getConstructor();
                int i5 = ((((432 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer.useNode();
                }
                composer = Updater.constructor-impl($composer);
                Updater.set-impl(composer, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                }
                Updater.set-impl(composer, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i6 = (i5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 610898083, "C1299@55895L786,1315@56748L32,1317@56860L341,1314@56702L499:WhatsAppDashboard.kt#naom5h");
                Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Modifier modifier3 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifier3);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                int i8 = ((((384 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function2 = constructor2;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer.useNode();
                }
                composer2 = Updater.constructor-impl($composer);
                Updater.set-impl(composer2, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer2.getInserting()) {
                    composer3 = $composer;
                } else {
                    composer3 = $composer;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    int i9 = (i8 >> 6) & 14;
                    Composer composer5 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    int i10 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer5, -1482526933, "C1303@56155L11,1300@55973L288,1306@56286L39,1310@56532L10,1311@56605L11,1307@56350L309:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer5, 432, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer5, 6);
                    TextKt.Text--4IGK_g("Chatbot Profile Configuration", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getBodyMedium(), composer5, 196614, 0, 65498);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart($composer, -1781382906, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    objRememberedValue2 = $composer.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$204$lambda$203($showSettings$delegate);
                            }
                        };
                        $composer.updateRememberedValue(obj2);
                    } else {
                        obj2 = objRememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    IconButtonKt.IconButton((Function0) obj2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1868185123, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj3, Object obj4) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$205($showSettings$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, $composer, 54), $composer, 196662, 28);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, ChatbotTab$lambda$197($showSettings$delegate), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1153819782, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224($viewModel, $useChatbotForReplies$delegate, $activeModel$delegate, $presetRoles, $systemInstruction$delegate, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, $composer, 54), $composer, (i4 & 14) | 1572864, 30);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3);
                Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i11 = (i8 >> 6) & 14;
                Composer composer6 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer6, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                int i12 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer6, -1482526933, "C1303@56155L11,1300@55973L288,1306@56286L39,1310@56532L10,1311@56605L11,1307@56350L309:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer6, 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer6, 6);
                TextKt.Text--4IGK_g("Chatbot Profile Configuration", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getBodyMedium(), composer6, 196614, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart($composer, -1781382906, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue2 = $composer.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$204$lambda$203($showSettings$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) obj2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1868185123, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$205($showSettings$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, $composer, 54), $composer, 196662, 28);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                AnimatedVisibilityKt.AnimatedVisibility(columnScope, ChatbotTab$lambda$197($showSettings$delegate), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1153819782, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224($viewModel, $useChatbotForReplies$delegate, $activeModel$delegate, $presetRoles, $systemInstruction$delegate, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, $composer, 54), $composer, (i4 & 14) | 1572864, 30);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash);
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i13 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i14 = ((i >> 6) & 112) | 6;
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -84089751, "C1295@55684L32,1292@55564L1655,1326@57280L7108,1326@57237L7151:WhatsAppDashboard.kt#naom5h");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1388190846, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$201$lambda$200($showSettings$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier4 = ClickableKt.clickable-XHw0xAI$default(modifierFillMaxWidth$default2, false, (String) null, (Role) null, (Function0) obj, 7, (Object) null);
            Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically3, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer, modifier4);
            constructor = ComposeUiNode.Companion.getConstructor();
            int i15 = ((((432 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor;
                $composer.createNode(function1);
            } else {
                function1 = constructor;
                $composer.useNode();
            }
            composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer.getInserting()) {
            }
            composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
            Updater.set-impl(composer, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            int i16 = (i15 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope4 = RowScopeInstance.INSTANCE;
            int i17 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 610898083, "C1299@55895L786,1315@56748L32,1317@56860L341,1314@56702L499:WhatsAppDashboard.kt#naom5h");
            Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier5 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier($composer, modifier5);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            int i18 = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function2 = constructor2;
                $composer.createNode(function2);
            } else {
                function2 = constructor2;
                $composer.useNode();
            }
            composer2 = Updater.constructor-impl($composer);
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting()) {
                composer3 = $composer;
                if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer2, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                int i19 = (i18 >> 6) & 14;
                Composer composer7 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer7, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope5 = RowScopeInstance.INSTANCE;
                int i110 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer7, -1482526933, "C1303@56155L11,1300@55973L288,1306@56286L39,1310@56532L10,1311@56605L11,1307@56350L309:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer7, 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer7, 6);
                TextKt.Text--4IGK_g("Chatbot Profile Configuration", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getBodyMedium(), composer7, 196614, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart($composer, -1781382906, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                objRememberedValue2 = $composer.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$204$lambda$203($showSettings$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) obj2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1868185123, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj3, Object obj4) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$205($showSettings$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, $composer, 54), $composer, 196662, 28);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                AnimatedVisibilityKt.AnimatedVisibility(columnScope2, ChatbotTab$lambda$197($showSettings$delegate), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1153819782, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224($viewModel, $useChatbotForReplies$delegate, $activeModel$delegate, $presetRoles, $systemInstruction$delegate, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, $composer, 54), $composer, (i14 & 14) | 1572864, 30);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer3 = $composer;
            }
            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash5);
            Updater.set-impl(composer2, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            int i111 = (i18 >> 6) & 14;
            Composer composer8 = composer3;
            ComposerKt.sourceInformationMarkerStart(composer8, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope6 = RowScopeInstance.INSTANCE;
            int i112 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer8, -1482526933, "C1303@56155L11,1300@55973L288,1306@56286L39,1310@56532L10,1311@56605L11,1307@56350L309:WhatsAppDashboard.kt#naom5h");
            IconKt.Icon-ww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Settings", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), MaterialTheme.INSTANCE.getColorScheme(composer8, MaterialTheme.$stable).getPrimary-0d7_KjU(), composer8, 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer8, 6);
            TextKt.Text--4IGK_g("Chatbot Profile Configuration", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer8, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer8, MaterialTheme.$stable).getBodyMedium(), composer8, 196614, 0, 65498);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart($composer, -1781382906, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            objRememberedValue2 = $composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                obj2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$204$lambda$203($showSettings$delegate);
                    }
                };
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1868185123, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj3, Object obj4) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$205($showSettings$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer, 54), $composer, 196662, 28);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            AnimatedVisibilityKt.AnimatedVisibility(columnScope2, ChatbotTab$lambda$197($showSettings$delegate), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1153819782, true, new Function3() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224($viewModel, $useChatbotForReplies$delegate, $activeModel$delegate, $presetRoles, $systemInstruction$delegate, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, $composer, 54), $composer, (i14 & 14) | 1572864, 30);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$201$lambda$200(MutableState $showSettings$delegate) {
        ChatbotTab$lambda$198($showSettings$delegate, !ChatbotTab$lambda$197($showSettings$delegate));
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$204$lambda$203(MutableState $showSettings$delegate) {
        ChatbotTab$lambda$198($showSettings$delegate, !ChatbotTab$lambda$197($showSettings$delegate));
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$206$lambda$205(MutableState $showSettings$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1321@57125L11,1318@56886L293:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1868185123, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1318)");
            }
            IconKt.Icon-ww6aTOc(ChatbotTab$lambda$197($showSettings$delegate) ? ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault()) : ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault()), "Toggle Settings", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0995  */
    /* JADX WARN: Code duplicated, block: B:103:0x099b  */
    /* JADX WARN: Code duplicated, block: B:106:0x09cc  */
    /* JADX WARN: Code duplicated, block: B:109:0x09df  */
    /* JADX WARN: Code duplicated, block: B:110:0x09e2  */
    /* JADX WARN: Code duplicated, block: B:115:0x0a48  */
    /* JADX WARN: Code duplicated, block: B:117:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:123:0x0aaf  */
    /* JADX WARN: Code duplicated, block: B:126:0x0aba  */
    /* JADX WARN: Code duplicated, block: B:127:0x0abf  */
    /* JADX WARN: Code duplicated, block: B:131:0x0af4  */
    /* JADX WARN: Code duplicated, block: B:132:0x0b0f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0b22  */
    /* JADX WARN: Code duplicated, block: B:136:0x0b3a  */
    /* JADX WARN: Code duplicated, block: B:139:0x0b75  */
    /* JADX WARN: Code duplicated, block: B:140:0x0b8d  */
    /* JADX WARN: Code duplicated, block: B:144:0x0c62  */
    /* JADX WARN: Code duplicated, block: B:148:0x0c6d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0cdb  */
    /* JADX WARN: Code duplicated, block: B:23:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:26:0x0209  */
    /* JADX WARN: Code duplicated, block: B:27:0x020f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0328  */
    /* JADX WARN: Code duplicated, block: B:41:0x0334  */
    /* JADX WARN: Code duplicated, block: B:42:0x033a  */
    /* JADX WARN: Code duplicated, block: B:53:0x047b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0486  */
    /* JADX WARN: Code duplicated, block: B:57:0x0489  */
    /* JADX WARN: Code duplicated, block: B:61:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:64:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:65:0x0605  */
    /* JADX WARN: Code duplicated, block: B:68:0x0638  */
    /* JADX WARN: Code duplicated, block: B:72:0x064e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:79:0x0731  */
    /* JADX WARN: Code duplicated, block: B:82:0x073c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0741  */
    /* JADX WARN: Code duplicated, block: B:87:0x0774  */
    /* JADX WARN: Code duplicated, block: B:88:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:90:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:91:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0802  */
    /* JADX WARN: Code duplicated, block: B:95:0x081a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0989  */
    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224(final WhatsAppViewModel $viewModel, State $useChatbotForReplies$delegate, State $activeModel$delegate, List $presetRoles, State $systemInstruction$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 function0;
        Composer composer;
        Composer composer2;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer3;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Function0 function2;
        Composer composer4;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composer5;
        int currentCompositeKeyHash3;
        Function0 constructor3;
        Function0 function3;
        Composer composer6;
        RowScope rowScope;
        Composer composer7;
        Iterable iterableListOf;
        int i;
        Iterator it;
        int currentCompositeKeyHash4;
        Modifier modifierMaterializeModifier;
        Function0 constructor4;
        Function0 function4;
        Composer composer8;
        int i2;
        Composer composer9;
        int i3;
        int i4;
        List<Triple> list;
        int i5;
        boolean zChangedInstance2;
        Object obj;
        final String str;
        boolean z;
        boolean z2;
        boolean zChangedInstance3;
        Object objRememberedValue2;
        int i6;
        long j;
        long j2;
        Composer composer10;
        long j3;
        boolean zAreEqual;
        boolean zChangedInstance4;
        Object objRememberedValue3;
        RowScope rowScope2;
        long j4;
        long j5;
        Composer composer11;
        long j6;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C1327@57302L7068:WhatsAppDashboard.kt#naom5h");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1153819782, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1327)");
        }
        Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier);
        Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
        int i7 = ((((6 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            function0 = constructor5;
            $composer.createNode(function0);
        } else {
            function0 = constructor5;
            $composer.useNode();
        }
        Composer composer12 = Updater.constructor-impl($composer);
        Updater.set-impl(composer12, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer12, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer12.getInserting()) {
            composer = $composer;
            if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            }
            Updater.set-impl(composer12, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i8 = (i7 >> 6) & 14;
            composer2 = composer;
            ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, 945140288, "C1333@57653L11,1329@57449L1866,1362@59341L41,1367@59580L10,1369@59712L11,1365@59457L300,1371@59782L40,1372@59847L1656,1397@61529L41,1402@61767L10,1404@61899L11,1400@61645L299,1406@61969L40,1407@62034L1570,1431@63630L41,1443@64302L10,1436@63867L48,1434@63749L599:WhatsAppDashboard.kt#naom5h");
            Modifier modifier2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(12), Dp.constructor-impl(8));
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifier2);
            constructor = ComposeUiNode.Companion.getConstructor();
            int i10 = ((((432 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function1 = constructor;
                composer2.createNode(function1);
            } else {
                function1 = constructor;
                composer2.useNode();
            }
            composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            int i11 = (i10 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i12 = ((432 >> 6) & 112) | 6;
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1559520687, "C1340@58073L756,1354@58980L42,1355@59080L179,1352@58858L431:WhatsAppDashboard.kt#naom5h");
            Modifier modifierWeight$default = RowScope.weight$default(rowScope3, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            int i13 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function2 = constructor2;
                composer2.createNode(function2);
            } else {
                function2 = constructor2;
                composer2.useNode();
            }
            composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            int i14 = (i13 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i15 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -736909492, "C1344@58349L10,1341@58146L258,1348@58637L10,1349@58718L11,1346@58437L362:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Use Profile for Auto-Reply", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
            TextKt.Text--4IGK_g("Outgoing WhatsApp replies will use this chatbot profile, speed, and intelligence setting.", (Modifier) null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            boolean zChatbotTab$lambda$191 = ChatbotTab$lambda$191($useChatbotForReplies$delegate);
            ComposerKt.sourceInformationMarkerStart(composer2, 1297260958, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance = composer2.changedInstance($viewModel);
            objRememberedValue = composer2.rememberedValue();
            if (!zChangedInstance) {
                composer5 = composer2;
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer5);
                SwitchKt.Switch(zChatbotTab$lambda$191, (Function1) objRememberedValue, (Modifier) null, (Function2) null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer5, 54, SwitchDefaults.$stable << 18, 65532), (MutableInteractionSource) null, composer5, 0, 92);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                TextKt.Text--4IGK_g("Intelligence Engine (Model):", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                constructor3 = ComposeUiNode.Companion.getConstructor();
                int i16 = ((((54 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function3 = constructor3;
                    composer2.createNode(function3);
                } else {
                    function3 = constructor3;
                    composer2.useNode();
                }
                composer6 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer6, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash4);
                }
                Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                int i17 = (i16 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                int i18 = ((54 >> 6) & 112) | 6;
                rowScope = RowScopeInstance.INSTANCE;
                composer7 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer7, 445522054, "C:WhatsAppDashboard.kt#naom5h");
                composer7.startReplaceGroup(2092590806);
                ComposerKt.sourceInformation(composer7, "*1383@60544L42,1384@60632L33,1385@60735L361,1382@60482L965");
                iterableListOf = CollectionsKt.listOf(new Pair[]{new Pair("Pro preview (Complex)", "gemini-3.1-pro-preview"), new Pair("Flash (General)", "gemini-3.5-flash"), new Pair("Flash Lite (Fast)", "gemini-3.1-flash-lite-preview")});
                i = 0;
                it = iterableListOf.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Iterable iterable = iterableListOf;
                    final String str2 = (String) pair.component1();
                    int i19 = i;
                    final String str3 = (String) pair.component2();
                    Iterator it2 = it;
                    zAreEqual = Intrinsics.areEqual(ChatbotTab$lambda$190($activeModel$delegate), str3);
                    ComposerKt.sourceInformationMarkerStart(composer7, 1822585742, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance4 = composer7.changedInstance($viewModel) | composer7.changed(str3);
                    Composer composer13 = composer7;
                    objRememberedValue3 = composer13.rememberedValue();
                    if (!zChangedInstance4) {
                        rowScope2 = rowScope;
                        if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                        }
                        Function0 function5 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                            public final Object invoke(Object obj2, Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer7, 54);
                        SuggestionChipDefaults suggestionChipDefaults = SuggestionChipDefaults.INSTANCE;
                        if (zAreEqual) {
                            composer7.startReplaceGroup(1822595959);
                            ComposerKt.sourceInformation(composer7, "1386@60844L11");
                            j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            composer7.endReplaceGroup();
                        } else {
                            composer7.startReplaceGroup(1822596943);
                            composer7.endReplaceGroup();
                            j4 = Color.Companion.getTransparent-0d7_KjU();
                        }
                        if (zAreEqual) {
                            composer7.startReplaceGroup(1822600395);
                            ComposerKt.sourceInformation(composer7, "1387@60991L11");
                            j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer7.startReplaceGroup(1822601652);
                            ComposerKt.sourceInformation(composer7, "1387@61030L11");
                            j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer7.endReplaceGroup();
                        composer11 = composer7;
                        ChipColors chipColors = suggestionChipDefaults.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                        float f = Dp.constructor-impl(1);
                        if (zAreEqual) {
                            composer11.startReplaceGroup(1822609931);
                            ComposerKt.sourceInformation(composer11, "1391@61289L11");
                            j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer11.startReplaceGroup(1822611734);
                            ComposerKt.sourceInformation(composer11, "1391@61328L11");
                            j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer11.endReplaceGroup();
                        ChipKt.SuggestionChip(function5, function2RememberComposableLambda, (Modifier) null, false, (Function2) null, (Shape) null, chipColors, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f, j6), (MutableInteractionSource) null, composer11, 48, 700);
                        measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                        composer7 = composer11;
                        it = it2;
                        i = i19;
                        iterableListOf = iterable;
                        rowScope = rowScope2;
                    } else {
                        rowScope2 = rowScope;
                    }
                    objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda48
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$212$lambda$211($viewModel, str3);
                        }
                    };
                    composer13.updateRememberedValue(objRememberedValue3);
                    Function0 function6 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer7, 54);
                    SuggestionChipDefaults suggestionChipDefaults2 = SuggestionChipDefaults.INSTANCE;
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822595959);
                        ComposerKt.sourceInformation(composer7, "1386@60844L11");
                        j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        composer7.endReplaceGroup();
                    } else {
                        composer7.startReplaceGroup(1822596943);
                        composer7.endReplaceGroup();
                        j4 = Color.Companion.getTransparent-0d7_KjU();
                    }
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822600395);
                        ComposerKt.sourceInformation(composer7, "1387@60991L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer7.startReplaceGroup(1822601652);
                        ComposerKt.sourceInformation(composer7, "1387@61030L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer7.endReplaceGroup();
                    composer11 = composer7;
                    ChipColors chipColors2 = suggestionChipDefaults2.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                    float f2 = Dp.constructor-impl(1);
                    if (zAreEqual) {
                        composer11.startReplaceGroup(1822609931);
                        ComposerKt.sourceInformation(composer11, "1391@61289L11");
                        j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer11.startReplaceGroup(1822611734);
                        ComposerKt.sourceInformation(composer11, "1391@61328L11");
                        j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer11.endReplaceGroup();
                    ChipKt.SuggestionChip(function6, function2RememberComposableLambda2, (Modifier) null, false, (Function2) null, (Shape) null, chipColors2, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f2, j6), (MutableInteractionSource) null, composer11, 48, 700);
                    measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                    composer7 = composer11;
                    it = it2;
                    i = i19;
                    iterableListOf = iterable;
                    rowScope = rowScope2;
                }
                Composer composer14 = composer7;
                composer14.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer14);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                TextKt.Text--4IGK_g("Preset Roles & Model Pairs:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontal2, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
                constructor4 = ComposeUiNode.Companion.getConstructor();
                int i20 = ((((54 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function4 = constructor4;
                    composer2.createNode(function4);
                } else {
                    function4 = constructor4;
                    composer2.useNode();
                }
                composer8 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer8, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer8, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer8.getInserting()) {
                    i2 = currentCompositeKeyHash4;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(i2))) {
                    }
                    Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    int i21 = (i20 >> 6) & 14;
                    composer9 = composer2;
                    i3 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope4 = RowScopeInstance.INSTANCE;
                    i4 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
                    composer9.startReplaceGroup(27501884);
                    ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
                    list = $presetRoles;
                    i5 = 0;
                    for (Triple triple : list) {
                        Iterable iterable2 = list;
                        final String str4 = (String) triple.component1();
                        int i22 = i5;
                        str = (String) triple.component2();
                        int i23 = i3;
                        final String str5 = (String) triple.component3();
                        Modifier modifier3 = modifierMaterializeModifier;
                        if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str) || !Intrinsics.areEqual(ChatbotTab$lambda$190($activeModel$delegate), str5)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        z2 = z;
                        ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                        zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str5);
                        Composer composer15 = composer9;
                        objRememberedValue2 = composer15.rememberedValue();
                        if (!zChangedInstance3) {
                            i6 = i4;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            Function0 function7 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composer9);
                            Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                                public final Object invoke(Object obj2, Object obj3) {
                                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str4, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer9, 54);
                            SuggestionChipDefaults suggestionChipDefaults3 = SuggestionChipDefaults.INSTANCE;
                            if (z2) {
                                composer9.startReplaceGroup(-949618085);
                                ComposerKt.sourceInformation(composer9, "1420@62941L11");
                                j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                                composer9.endReplaceGroup();
                            } else {
                                composer9.startReplaceGroup(-949617132);
                                composer9.endReplaceGroup();
                                j = Color.Companion.getTransparent-0d7_KjU();
                            }
                            long j7 = j;
                            if (z2) {
                                composer9.startReplaceGroup(-949613667);
                                ComposerKt.sourceInformation(composer9, "1421@63079L11");
                                j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                            } else {
                                composer9.startReplaceGroup(-949612007);
                                ComposerKt.sourceInformation(composer9, "1421@63131L11");
                                j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                            }
                            composer9.endReplaceGroup();
                            composer10 = composer9;
                            ChipColors chipColors3 = suggestionChipDefaults3.suggestionChipColors-5tl4gsc(j7, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                            float f3 = Dp.constructor-impl(1);
                            if (z2) {
                                composer10.startReplaceGroup(-949603728);
                                ComposerKt.sourceInformation(composer10, "1425@63390L11");
                                j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                            } else {
                                composer10.startReplaceGroup(-949601925);
                                ComposerKt.sourceInformation(composer10, "1425@63429L11");
                                j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            }
                            composer10.endReplaceGroup();
                            ChipKt.SuggestionChip(function7, function2RememberComposableLambda3, (Modifier) null, false, (Function2) null, (Shape) null, chipColors3, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f3, j3), (MutableInteractionSource) null, composer10, 48, 700);
                            composer9 = composer10;
                            list = iterable2;
                            i5 = i22;
                            i3 = i23;
                            modifierMaterializeModifier = modifier3;
                            i4 = i6;
                        } else {
                            i6 = i4;
                        }
                        objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                            public final Object invoke() {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str5);
                            }
                        };
                        composer15.updateRememberedValue(objRememberedValue2);
                        Function0 function8 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer9);
                        Function2 function2RememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                            public final Object invoke(Object obj2, Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str4, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer9, 54);
                        SuggestionChipDefaults suggestionChipDefaults4 = SuggestionChipDefaults.INSTANCE;
                        if (z2) {
                            composer9.startReplaceGroup(-949618085);
                            ComposerKt.sourceInformation(composer9, "1420@62941L11");
                            j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                            composer9.endReplaceGroup();
                        } else {
                            composer9.startReplaceGroup(-949617132);
                            composer9.endReplaceGroup();
                            j = Color.Companion.getTransparent-0d7_KjU();
                        }
                        long j8 = j;
                        if (z2) {
                            composer9.startReplaceGroup(-949613667);
                            ComposerKt.sourceInformation(composer9, "1421@63079L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                        } else {
                            composer9.startReplaceGroup(-949612007);
                            ComposerKt.sourceInformation(composer9, "1421@63131L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer9.endReplaceGroup();
                        composer10 = composer9;
                        ChipColors chipColors4 = suggestionChipDefaults4.suggestionChipColors-5tl4gsc(j8, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                        float f4 = Dp.constructor-impl(1);
                        if (z2) {
                            composer10.startReplaceGroup(-949603728);
                            ComposerKt.sourceInformation(composer10, "1425@63390L11");
                            j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer10.startReplaceGroup(-949601925);
                            ComposerKt.sourceInformation(composer10, "1425@63429L11");
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer10.endReplaceGroup();
                        ChipKt.SuggestionChip(function8, function2RememberComposableLambda4, (Modifier) null, false, (Function2) null, (Shape) null, chipColors4, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f4, j3), (MutableInteractionSource) null, composer10, 48, 700);
                        composer9 = composer10;
                        list = iterable2;
                        i5 = i22;
                        i3 = i23;
                        modifierMaterializeModifier = modifier3;
                        i4 = i6;
                    }
                    Composer composer16 = composer9;
                    composer16.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer16);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                    String strChatbotTab$lambda$189 = ChatbotTab$lambda$189($systemInstruction$delegate);
                    Modifier modifier4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
                    Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                    TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance($viewModel);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                        obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                            public final Object invoke(Object obj2) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$189, (Function1) obj, modifier4, false, false, bodySmall, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
                i2 = currentCompositeKeyHash4;
                composer8.updateRememberedValue(Integer.valueOf(i2));
                composer8.apply(Integer.valueOf(i2), setCompositeKeyHash5);
                Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i24 = (i20 >> 6) & 14;
                composer9 = composer2;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope5 = RowScopeInstance.INSTANCE;
                i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
                composer9.startReplaceGroup(27501884);
                ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
                list = $presetRoles;
                i5 = 0;
                while (r65.hasNext()) {
                    Iterable iterable3 = list;
                    final String str6 = (String) triple.component1();
                    int i25 = i5;
                    str = (String) triple.component2();
                    int i26 = i3;
                    final String str7 = (String) triple.component3();
                    Modifier modifier5 = modifierMaterializeModifier;
                    if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                    ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str7);
                    Composer composer17 = composer9;
                    objRememberedValue2 = composer17.rememberedValue();
                    if (!zChangedInstance3) {
                        i6 = i4;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        Function0 function9 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer9);
                        Function2 function2RememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                            public final Object invoke(Object obj2, Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str6, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer9, 54);
                        SuggestionChipDefaults suggestionChipDefaults5 = SuggestionChipDefaults.INSTANCE;
                        if (z2) {
                            composer9.startReplaceGroup(-949618085);
                            ComposerKt.sourceInformation(composer9, "1420@62941L11");
                            j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                            composer9.endReplaceGroup();
                        } else {
                            composer9.startReplaceGroup(-949617132);
                            composer9.endReplaceGroup();
                            j = Color.Companion.getTransparent-0d7_KjU();
                        }
                        long j9 = j;
                        if (z2) {
                            composer9.startReplaceGroup(-949613667);
                            ComposerKt.sourceInformation(composer9, "1421@63079L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                        } else {
                            composer9.startReplaceGroup(-949612007);
                            ComposerKt.sourceInformation(composer9, "1421@63131L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer9.endReplaceGroup();
                        composer10 = composer9;
                        ChipColors chipColors5 = suggestionChipDefaults5.suggestionChipColors-5tl4gsc(j9, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                        float f5 = Dp.constructor-impl(1);
                        if (z2) {
                            composer10.startReplaceGroup(-949603728);
                            ComposerKt.sourceInformation(composer10, "1425@63390L11");
                            j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer10.startReplaceGroup(-949601925);
                            ComposerKt.sourceInformation(composer10, "1425@63429L11");
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer10.endReplaceGroup();
                        ChipKt.SuggestionChip(function9, function2RememberComposableLambda5, (Modifier) null, false, (Function2) null, (Shape) null, chipColors5, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f5, j3), (MutableInteractionSource) null, composer10, 48, 700);
                        composer9 = composer10;
                        list = iterable3;
                        i5 = i25;
                        i3 = i26;
                        modifierMaterializeModifier = modifier5;
                        i4 = i6;
                    } else {
                        i6 = i4;
                    }
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str7);
                        }
                    };
                    composer17.updateRememberedValue(objRememberedValue2);
                    Function0 function10 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str6, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults6 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j10 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors6 = suggestionChipDefaults6.suggestionChipColors-5tl4gsc(j10, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f6 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function10, function2RememberComposableLambda6, (Modifier) null, false, (Function2) null, (Shape) null, chipColors6, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f6, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable3;
                    i5 = i25;
                    i3 = i26;
                    modifierMaterializeModifier = modifier5;
                    i4 = i6;
                }
                Composer composer18 = composer9;
                composer18.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer18);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                String strChatbotTab$lambda$1810 = ChatbotTab$lambda$189($systemInstruction$delegate);
                Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
                Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                TextStyle bodySmall2 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
                ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance($viewModel);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1810, (Function1) obj, modifier6, false, false, bodySmall2, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape2, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer5 = composer2;
            objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda47
                public final Object invoke(Object obj2) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$210$lambda$209$lambda$208($viewModel, ((Boolean) obj2).booleanValue());
                }
            };
            composer2.updateRememberedValue(objRememberedValue);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            SwitchKt.Switch(zChatbotTab$lambda$191, (Function1) objRememberedValue, (Modifier) null, (Function2) null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer5, 54, SwitchDefaults.$stable << 18, 65532), (MutableInteractionSource) null, composer5, 0, 92);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            TextKt.Text--4IGK_g("Intelligence Engine (Model):", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontal3, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default3);
            constructor3 = ComposeUiNode.Companion.getConstructor();
            int i110 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function3 = constructor3;
                composer2.createNode(function3);
            } else {
                function3 = constructor3;
                composer2.useNode();
            }
            composer6 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer6, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer6.getInserting()) {
            }
            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash6);
            Updater.set-impl(composer6, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
            int i111 = (i110 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i112 = ((54 >> 6) & 112) | 6;
            rowScope = RowScopeInstance.INSTANCE;
            composer7 = composer2;
            ComposerKt.sourceInformationMarkerStart(composer7, 445522054, "C:WhatsAppDashboard.kt#naom5h");
            composer7.startReplaceGroup(2092590806);
            ComposerKt.sourceInformation(composer7, "*1383@60544L42,1384@60632L33,1385@60735L361,1382@60482L965");
            iterableListOf = CollectionsKt.listOf(new Pair[]{new Pair("Pro preview (Complex)", "gemini-3.1-pro-preview"), new Pair("Flash (General)", "gemini-3.5-flash"), new Pair("Flash Lite (Fast)", "gemini-3.1-flash-lite-preview")});
            i = 0;
            it = iterableListOf.iterator();
            while (it.hasNext()) {
                Pair pair2 = (Pair) it.next();
                Iterable iterable4 = iterableListOf;
                final String str8 = (String) pair2.component1();
                int i113 = i;
                final String str9 = (String) pair2.component2();
                Iterator it3 = it;
                zAreEqual = Intrinsics.areEqual(ChatbotTab$lambda$190($activeModel$delegate), str9);
                ComposerKt.sourceInformationMarkerStart(composer7, 1822585742, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance4 = composer7.changedInstance($viewModel) | composer7.changed(str9);
                Composer composer19 = composer7;
                objRememberedValue3 = composer19.rememberedValue();
                if (!zChangedInstance4) {
                    rowScope2 = rowScope;
                    if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function11 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    Function2 function2RememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str8, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer7, 54);
                    SuggestionChipDefaults suggestionChipDefaults7 = SuggestionChipDefaults.INSTANCE;
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822595959);
                        ComposerKt.sourceInformation(composer7, "1386@60844L11");
                        j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        composer7.endReplaceGroup();
                    } else {
                        composer7.startReplaceGroup(1822596943);
                        composer7.endReplaceGroup();
                        j4 = Color.Companion.getTransparent-0d7_KjU();
                    }
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822600395);
                        ComposerKt.sourceInformation(composer7, "1387@60991L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer7.startReplaceGroup(1822601652);
                        ComposerKt.sourceInformation(composer7, "1387@61030L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer7.endReplaceGroup();
                    composer11 = composer7;
                    ChipColors chipColors7 = suggestionChipDefaults7.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                    float f7 = Dp.constructor-impl(1);
                    if (zAreEqual) {
                        composer11.startReplaceGroup(1822609931);
                        ComposerKt.sourceInformation(composer11, "1391@61289L11");
                        j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer11.startReplaceGroup(1822611734);
                        ComposerKt.sourceInformation(composer11, "1391@61328L11");
                        j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer11.endReplaceGroup();
                    ChipKt.SuggestionChip(function11, function2RememberComposableLambda7, (Modifier) null, false, (Function2) null, (Shape) null, chipColors7, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f7, j6), (MutableInteractionSource) null, composer11, 48, 700);
                    measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                    composer7 = composer11;
                    it = it3;
                    i = i113;
                    iterableListOf = iterable4;
                    rowScope = rowScope2;
                } else {
                    rowScope2 = rowScope;
                }
                objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda48
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$212$lambda$211($viewModel, str9);
                    }
                };
                composer19.updateRememberedValue(objRememberedValue3);
                Function0 function12 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Function2 function2RememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str8, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer7, 54);
                SuggestionChipDefaults suggestionChipDefaults8 = SuggestionChipDefaults.INSTANCE;
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822595959);
                    ComposerKt.sourceInformation(composer7, "1386@60844L11");
                    j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    composer7.endReplaceGroup();
                } else {
                    composer7.startReplaceGroup(1822596943);
                    composer7.endReplaceGroup();
                    j4 = Color.Companion.getTransparent-0d7_KjU();
                }
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822600395);
                    ComposerKt.sourceInformation(composer7, "1387@60991L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer7.startReplaceGroup(1822601652);
                    ComposerKt.sourceInformation(composer7, "1387@61030L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer7.endReplaceGroup();
                composer11 = composer7;
                ChipColors chipColors8 = suggestionChipDefaults8.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                float f8 = Dp.constructor-impl(1);
                if (zAreEqual) {
                    composer11.startReplaceGroup(1822609931);
                    ComposerKt.sourceInformation(composer11, "1391@61289L11");
                    j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer11.startReplaceGroup(1822611734);
                    ComposerKt.sourceInformation(composer11, "1391@61328L11");
                    j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer11.endReplaceGroup();
                ChipKt.SuggestionChip(function12, function2RememberComposableLambda8, (Modifier) null, false, (Function2) null, (Shape) null, chipColors8, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f8, j6), (MutableInteractionSource) null, composer11, 48, 700);
                measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                composer7 = composer11;
                it = it3;
                i = i113;
                iterableListOf = iterable4;
                rowScope = rowScope2;
            }
            Composer composer110 = composer7;
            composer110.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer110);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            TextKt.Text--4IGK_g("Preset Roles & Model Pairs:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal4 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontal4, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default4);
            constructor4 = ComposeUiNode.Companion.getConstructor();
            int i27 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function4 = constructor4;
                composer2.createNode(function4);
            } else {
                function4 = constructor4;
                composer2.useNode();
            }
            composer8 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer8, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer8.getInserting()) {
                i2 = currentCompositeKeyHash4;
                if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(i2))) {
                }
                Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i28 = (i27 >> 6) & 14;
                composer9 = composer2;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope6 = RowScopeInstance.INSTANCE;
                i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
                composer9.startReplaceGroup(27501884);
                ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
                list = $presetRoles;
                i5 = 0;
                while (r65.hasNext()) {
                    Iterable iterable5 = list;
                    final String str10 = (String) triple.component1();
                    int i29 = i5;
                    str = (String) triple.component2();
                    int i210 = i3;
                    final String str11 = (String) triple.component3();
                    Modifier modifier7 = modifierMaterializeModifier;
                    if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                    ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str11);
                    Composer composer111 = composer9;
                    objRememberedValue2 = composer111.rememberedValue();
                    if (!zChangedInstance3) {
                        i6 = i4;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        Function0 function13 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer9);
                        Function2 function2RememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                            public final Object invoke(Object obj2, Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str10, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer9, 54);
                        SuggestionChipDefaults suggestionChipDefaults9 = SuggestionChipDefaults.INSTANCE;
                        if (z2) {
                            composer9.startReplaceGroup(-949618085);
                            ComposerKt.sourceInformation(composer9, "1420@62941L11");
                            j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                            composer9.endReplaceGroup();
                        } else {
                            composer9.startReplaceGroup(-949617132);
                            composer9.endReplaceGroup();
                            j = Color.Companion.getTransparent-0d7_KjU();
                        }
                        long j11 = j;
                        if (z2) {
                            composer9.startReplaceGroup(-949613667);
                            ComposerKt.sourceInformation(composer9, "1421@63079L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                        } else {
                            composer9.startReplaceGroup(-949612007);
                            ComposerKt.sourceInformation(composer9, "1421@63131L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer9.endReplaceGroup();
                        composer10 = composer9;
                        ChipColors chipColors9 = suggestionChipDefaults9.suggestionChipColors-5tl4gsc(j11, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                        float f9 = Dp.constructor-impl(1);
                        if (z2) {
                            composer10.startReplaceGroup(-949603728);
                            ComposerKt.sourceInformation(composer10, "1425@63390L11");
                            j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer10.startReplaceGroup(-949601925);
                            ComposerKt.sourceInformation(composer10, "1425@63429L11");
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer10.endReplaceGroup();
                        ChipKt.SuggestionChip(function13, function2RememberComposableLambda9, (Modifier) null, false, (Function2) null, (Shape) null, chipColors9, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f9, j3), (MutableInteractionSource) null, composer10, 48, 700);
                        composer9 = composer10;
                        list = iterable5;
                        i5 = i29;
                        i3 = i210;
                        modifierMaterializeModifier = modifier7;
                        i4 = i6;
                    } else {
                        i6 = i4;
                    }
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str11);
                        }
                    };
                    composer111.updateRememberedValue(objRememberedValue2);
                    Function0 function14 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str10, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults10 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j12 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors10 = suggestionChipDefaults10.suggestionChipColors-5tl4gsc(j12, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f10 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function14, function2RememberComposableLambda10, (Modifier) null, false, (Function2) null, (Shape) null, chipColors10, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f10, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable5;
                    i5 = i29;
                    i3 = i210;
                    modifierMaterializeModifier = modifier7;
                    i4 = i6;
                }
                Composer composer112 = composer9;
                composer112.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer112);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                String strChatbotTab$lambda$1811 = ChatbotTab$lambda$189($systemInstruction$delegate);
                Modifier modifier8 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
                Shape shape3 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                TextStyle bodySmall3 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
                ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance($viewModel);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1811, (Function1) obj, modifier8, false, false, bodySmall3, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape3, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            i2 = currentCompositeKeyHash4;
            composer8.updateRememberedValue(Integer.valueOf(i2));
            composer8.apply(Integer.valueOf(i2), setCompositeKeyHash7);
            Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i211 = (i27 >> 6) & 14;
            composer9 = composer2;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope7 = RowScopeInstance.INSTANCE;
            i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
            composer9.startReplaceGroup(27501884);
            ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
            list = $presetRoles;
            i5 = 0;
            while (r65.hasNext()) {
                Iterable iterable6 = list;
                final String str12 = (String) triple.component1();
                int i212 = i5;
                str = (String) triple.component2();
                int i213 = i3;
                final String str13 = (String) triple.component3();
                Modifier modifier9 = modifierMaterializeModifier;
                if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                    z = false;
                } else {
                    z = false;
                }
                z2 = z;
                ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str13);
                Composer composer113 = composer9;
                objRememberedValue2 = composer113.rememberedValue();
                if (!zChangedInstance3) {
                    i6 = i4;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function15 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str12, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults11 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j13 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors11 = suggestionChipDefaults11.suggestionChipColors-5tl4gsc(j13, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f11 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function15, function2RememberComposableLambda11, (Modifier) null, false, (Function2) null, (Shape) null, chipColors11, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f11, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable6;
                    i5 = i212;
                    i3 = i213;
                    modifierMaterializeModifier = modifier9;
                    i4 = i6;
                } else {
                    i6 = i4;
                }
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str13);
                    }
                };
                composer113.updateRememberedValue(objRememberedValue2);
                Function0 function16 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer9);
                Function2 function2RememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str12, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer9, 54);
                SuggestionChipDefaults suggestionChipDefaults12 = SuggestionChipDefaults.INSTANCE;
                if (z2) {
                    composer9.startReplaceGroup(-949618085);
                    ComposerKt.sourceInformation(composer9, "1420@62941L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                    composer9.endReplaceGroup();
                } else {
                    composer9.startReplaceGroup(-949617132);
                    composer9.endReplaceGroup();
                    j = Color.Companion.getTransparent-0d7_KjU();
                }
                long j14 = j;
                if (z2) {
                    composer9.startReplaceGroup(-949613667);
                    ComposerKt.sourceInformation(composer9, "1421@63079L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                } else {
                    composer9.startReplaceGroup(-949612007);
                    ComposerKt.sourceInformation(composer9, "1421@63131L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer9.endReplaceGroup();
                composer10 = composer9;
                ChipColors chipColors12 = suggestionChipDefaults12.suggestionChipColors-5tl4gsc(j14, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                float f12 = Dp.constructor-impl(1);
                if (z2) {
                    composer10.startReplaceGroup(-949603728);
                    ComposerKt.sourceInformation(composer10, "1425@63390L11");
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer10.startReplaceGroup(-949601925);
                    ComposerKt.sourceInformation(composer10, "1425@63429L11");
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer10.endReplaceGroup();
                ChipKt.SuggestionChip(function16, function2RememberComposableLambda12, (Modifier) null, false, (Function2) null, (Shape) null, chipColors12, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f12, j3), (MutableInteractionSource) null, composer10, 48, 700);
                composer9 = composer10;
                list = iterable6;
                i5 = i212;
                i3 = i213;
                modifierMaterializeModifier = modifier9;
                i4 = i6;
            }
            Composer composer114 = composer9;
            composer114.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer114);
            ComposerKt.sourceInformationMarkerEnd(composer9);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            String strChatbotTab$lambda$1812 = ChatbotTab$lambda$189($systemInstruction$delegate);
            Modifier modifier10 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
            Shape shape4 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            TextStyle bodySmall4 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
            ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance2 = composer2.changedInstance($viewModel);
            Object objRememberedValue7 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            } else {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1812, (Function1) obj, modifier10, false, false, bodySmall4, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape4, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        composer = $composer;
        composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
        composer12.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash);
        Updater.set-impl(composer12, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
        int i30 = (i7 >> 6) & 14;
        composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
        ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
        int i31 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, 945140288, "C1333@57653L11,1329@57449L1866,1362@59341L41,1367@59580L10,1369@59712L11,1365@59457L300,1371@59782L40,1372@59847L1656,1397@61529L41,1402@61767L10,1404@61899L11,1400@61645L299,1406@61969L40,1407@62034L1570,1431@63630L41,1443@64302L10,1436@63867L48,1434@63749L599:WhatsAppDashboard.kt#naom5h");
        Modifier modifier11 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(12), Dp.constructor-impl(8));
        Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifier11);
        constructor = ComposeUiNode.Companion.getConstructor();
        int i114 = ((((432 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            function1 = constructor;
            composer2.createNode(function1);
        } else {
            function1 = constructor;
            composer2.useNode();
        }
        composer3 = Updater.constructor-impl(composer2);
        Updater.set-impl(composer3, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer3.getInserting()) {
        }
        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash8);
        Updater.set-impl(composer3, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
        int i115 = (i114 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        int i116 = ((432 >> 6) & 112) | 6;
        RowScope rowScope8 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer2, 1559520687, "C1340@58073L756,1354@58980L42,1355@59080L179,1352@58858L431:WhatsAppDashboard.kt#naom5h");
        Modifier modifierWeight$default2 = RowScope.weight$default(rowScope8, Modifier.Companion, 1.0f, false, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default2);
        constructor2 = ComposeUiNode.Companion.getConstructor();
        int i117 = ((((0 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            function2 = constructor2;
            composer2.createNode(function2);
        } else {
            function2 = constructor2;
            composer2.useNode();
        }
        composer4 = Updater.constructor-impl(composer2);
        Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer4, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer4.getInserting()) {
        }
        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash9);
        Updater.set-impl(composer4, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
        int i118 = (i117 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
        ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
        int i119 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, -736909492, "C1344@58349L10,1341@58146L258,1348@58637L10,1349@58718L11,1346@58437L362:WhatsAppDashboard.kt#naom5h");
        TextKt.Text--4IGK_g("Use Profile for Auto-Reply", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 196614, 0, 65502);
        TextKt.Text--4IGK_g("Outgoing WhatsApp replies will use this chatbot profile, speed, and intelligence setting.", (Modifier) null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 6, 0, 65530);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        boolean zChatbotTab$lambda$192 = ChatbotTab$lambda$191($useChatbotForReplies$delegate);
        ComposerKt.sourceInformationMarkerStart(composer2, 1297260958, "CC(remember):WhatsAppDashboard.kt#9igjgp");
        zChangedInstance = composer2.changedInstance($viewModel);
        objRememberedValue = composer2.rememberedValue();
        if (!zChangedInstance) {
            composer5 = composer2;
            if (objRememberedValue == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer5);
            SwitchKt.Switch(zChatbotTab$lambda$192, (Function1) objRememberedValue, (Modifier) null, (Function2) null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer5, 54, SwitchDefaults.$stable << 18, 65532), (MutableInteractionSource) null, composer5, 0, 92);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            TextKt.Text--4IGK_g("Intelligence Engine (Model):", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal5 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontal5, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default5);
            constructor3 = ComposeUiNode.Companion.getConstructor();
            int i1110 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function3 = constructor3;
                composer2.createNode(function3);
            } else {
                function3 = constructor3;
                composer2.useNode();
            }
            composer6 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer6, measurePolicyRowMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer6.getInserting()) {
            }
            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composer6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash10);
            Updater.set-impl(composer6, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
            int i1111 = (i1110 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            int i1112 = ((54 >> 6) & 112) | 6;
            rowScope = RowScopeInstance.INSTANCE;
            composer7 = composer2;
            ComposerKt.sourceInformationMarkerStart(composer7, 445522054, "C:WhatsAppDashboard.kt#naom5h");
            composer7.startReplaceGroup(2092590806);
            ComposerKt.sourceInformation(composer7, "*1383@60544L42,1384@60632L33,1385@60735L361,1382@60482L965");
            iterableListOf = CollectionsKt.listOf(new Pair[]{new Pair("Pro preview (Complex)", "gemini-3.1-pro-preview"), new Pair("Flash (General)", "gemini-3.5-flash"), new Pair("Flash Lite (Fast)", "gemini-3.1-flash-lite-preview")});
            i = 0;
            it = iterableListOf.iterator();
            while (it.hasNext()) {
                Pair pair3 = (Pair) it.next();
                Iterable iterable7 = iterableListOf;
                final String str14 = (String) pair3.component1();
                int i1113 = i;
                final String str15 = (String) pair3.component2();
                Iterator it4 = it;
                zAreEqual = Intrinsics.areEqual(ChatbotTab$lambda$190($activeModel$delegate), str15);
                ComposerKt.sourceInformationMarkerStart(composer7, 1822585742, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance4 = composer7.changedInstance($viewModel) | composer7.changed(str15);
                Composer composer115 = composer7;
                objRememberedValue3 = composer115.rememberedValue();
                if (!zChangedInstance4) {
                    rowScope2 = rowScope;
                    if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function17 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    Function2 function2RememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str14, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer7, 54);
                    SuggestionChipDefaults suggestionChipDefaults13 = SuggestionChipDefaults.INSTANCE;
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822595959);
                        ComposerKt.sourceInformation(composer7, "1386@60844L11");
                        j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        composer7.endReplaceGroup();
                    } else {
                        composer7.startReplaceGroup(1822596943);
                        composer7.endReplaceGroup();
                        j4 = Color.Companion.getTransparent-0d7_KjU();
                    }
                    if (zAreEqual) {
                        composer7.startReplaceGroup(1822600395);
                        ComposerKt.sourceInformation(composer7, "1387@60991L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer7.startReplaceGroup(1822601652);
                        ComposerKt.sourceInformation(composer7, "1387@61030L11");
                        j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer7.endReplaceGroup();
                    composer11 = composer7;
                    ChipColors chipColors13 = suggestionChipDefaults13.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                    float f13 = Dp.constructor-impl(1);
                    if (zAreEqual) {
                        composer11.startReplaceGroup(1822609931);
                        ComposerKt.sourceInformation(composer11, "1391@61289L11");
                        j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer11.startReplaceGroup(1822611734);
                        ComposerKt.sourceInformation(composer11, "1391@61328L11");
                        j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer11.endReplaceGroup();
                    ChipKt.SuggestionChip(function17, function2RememberComposableLambda13, (Modifier) null, false, (Function2) null, (Shape) null, chipColors13, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f13, j6), (MutableInteractionSource) null, composer11, 48, 700);
                    measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                    composer7 = composer11;
                    it = it4;
                    i = i1113;
                    iterableListOf = iterable7;
                    rowScope = rowScope2;
                } else {
                    rowScope2 = rowScope;
                }
                objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda48
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$212$lambda$211($viewModel, str15);
                    }
                };
                composer115.updateRememberedValue(objRememberedValue3);
                Function0 function18 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Function2 function2RememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str14, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer7, 54);
                SuggestionChipDefaults suggestionChipDefaults14 = SuggestionChipDefaults.INSTANCE;
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822595959);
                    ComposerKt.sourceInformation(composer7, "1386@60844L11");
                    j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    composer7.endReplaceGroup();
                } else {
                    composer7.startReplaceGroup(1822596943);
                    composer7.endReplaceGroup();
                    j4 = Color.Companion.getTransparent-0d7_KjU();
                }
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822600395);
                    ComposerKt.sourceInformation(composer7, "1387@60991L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer7.startReplaceGroup(1822601652);
                    ComposerKt.sourceInformation(composer7, "1387@61030L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer7.endReplaceGroup();
                composer11 = composer7;
                ChipColors chipColors14 = suggestionChipDefaults14.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                float f14 = Dp.constructor-impl(1);
                if (zAreEqual) {
                    composer11.startReplaceGroup(1822609931);
                    ComposerKt.sourceInformation(composer11, "1391@61289L11");
                    j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer11.startReplaceGroup(1822611734);
                    ComposerKt.sourceInformation(composer11, "1391@61328L11");
                    j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer11.endReplaceGroup();
                ChipKt.SuggestionChip(function18, function2RememberComposableLambda14, (Modifier) null, false, (Function2) null, (Shape) null, chipColors14, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f14, j6), (MutableInteractionSource) null, composer11, 48, 700);
                measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                composer7 = composer11;
                it = it4;
                i = i1113;
                iterableListOf = iterable7;
                rowScope = rowScope2;
            }
            Composer composer116 = composer7;
            composer116.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer116);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            TextKt.Text--4IGK_g("Preset Roles & Model Pairs:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
            Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontal6 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(horizontal6, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default6);
            constructor4 = ComposeUiNode.Companion.getConstructor();
            int i214 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function4 = constructor4;
                composer2.createNode(function4);
            } else {
                function4 = constructor4;
                composer2.useNode();
            }
            composer8 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer8, measurePolicyRowMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash11 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer8.getInserting()) {
                i2 = currentCompositeKeyHash4;
                if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(i2))) {
                }
                Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i215 = (i214 >> 6) & 14;
                composer9 = composer2;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope9 = RowScopeInstance.INSTANCE;
                i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
                composer9.startReplaceGroup(27501884);
                ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
                list = $presetRoles;
                i5 = 0;
                while (r65.hasNext()) {
                    Iterable iterable8 = list;
                    final String str16 = (String) triple.component1();
                    int i216 = i5;
                    str = (String) triple.component2();
                    int i217 = i3;
                    final String str17 = (String) triple.component3();
                    Modifier modifier12 = modifierMaterializeModifier;
                    if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                    ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                    zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str17);
                    Composer composer117 = composer9;
                    objRememberedValue2 = composer117.rememberedValue();
                    if (!zChangedInstance3) {
                        i6 = i4;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        Function0 function19 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer9);
                        Function2 function2RememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                            public final Object invoke(Object obj2, Object obj3) {
                                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str16, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer9, 54);
                        SuggestionChipDefaults suggestionChipDefaults15 = SuggestionChipDefaults.INSTANCE;
                        if (z2) {
                            composer9.startReplaceGroup(-949618085);
                            ComposerKt.sourceInformation(composer9, "1420@62941L11");
                            j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                            composer9.endReplaceGroup();
                        } else {
                            composer9.startReplaceGroup(-949617132);
                            composer9.endReplaceGroup();
                            j = Color.Companion.getTransparent-0d7_KjU();
                        }
                        long j15 = j;
                        if (z2) {
                            composer9.startReplaceGroup(-949613667);
                            ComposerKt.sourceInformation(composer9, "1421@63079L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                        } else {
                            composer9.startReplaceGroup(-949612007);
                            ComposerKt.sourceInformation(composer9, "1421@63131L11");
                            j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        }
                        composer9.endReplaceGroup();
                        composer10 = composer9;
                        ChipColors chipColors15 = suggestionChipDefaults15.suggestionChipColors-5tl4gsc(j15, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                        float f15 = Dp.constructor-impl(1);
                        if (z2) {
                            composer10.startReplaceGroup(-949603728);
                            ComposerKt.sourceInformation(composer10, "1425@63390L11");
                            j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        } else {
                            composer10.startReplaceGroup(-949601925);
                            ComposerKt.sourceInformation(composer10, "1425@63429L11");
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        composer10.endReplaceGroup();
                        ChipKt.SuggestionChip(function19, function2RememberComposableLambda15, (Modifier) null, false, (Function2) null, (Shape) null, chipColors15, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f15, j3), (MutableInteractionSource) null, composer10, 48, 700);
                        composer9 = composer10;
                        list = iterable8;
                        i5 = i216;
                        i3 = i217;
                        modifierMaterializeModifier = modifier12;
                        i4 = i6;
                    } else {
                        i6 = i4;
                    }
                    objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str17);
                        }
                    };
                    composer117.updateRememberedValue(objRememberedValue2);
                    Function0 function110 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str16, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults16 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j16 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors16 = suggestionChipDefaults16.suggestionChipColors-5tl4gsc(j16, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f16 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function110, function2RememberComposableLambda16, (Modifier) null, false, (Function2) null, (Shape) null, chipColors16, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f16, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable8;
                    i5 = i216;
                    i3 = i217;
                    modifierMaterializeModifier = modifier12;
                    i4 = i6;
                }
                Composer composer118 = composer9;
                composer118.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer118);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
                String strChatbotTab$lambda$1813 = ChatbotTab$lambda$189($systemInstruction$delegate);
                Modifier modifier13 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
                Shape shape5 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                TextStyle bodySmall5 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
                ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance($viewModel);
                Object objRememberedValue8 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                        public final Object invoke(Object obj2) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1813, (Function1) obj, modifier13, false, false, bodySmall5, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape5, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            i2 = currentCompositeKeyHash4;
            composer8.updateRememberedValue(Integer.valueOf(i2));
            composer8.apply(Integer.valueOf(i2), setCompositeKeyHash11);
            Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i218 = (i214 >> 6) & 14;
            composer9 = composer2;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope10 = RowScopeInstance.INSTANCE;
            i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
            composer9.startReplaceGroup(27501884);
            ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
            list = $presetRoles;
            i5 = 0;
            while (r65.hasNext()) {
                Iterable iterable9 = list;
                final String str18 = (String) triple.component1();
                int i219 = i5;
                str = (String) triple.component2();
                int i2110 = i3;
                final String str19 = (String) triple.component3();
                Modifier modifier14 = modifierMaterializeModifier;
                if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                    z = false;
                } else {
                    z = false;
                }
                z2 = z;
                ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str19);
                Composer composer119 = composer9;
                objRememberedValue2 = composer119.rememberedValue();
                if (!zChangedInstance3) {
                    i6 = i4;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function111 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str18, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults17 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j17 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors17 = suggestionChipDefaults17.suggestionChipColors-5tl4gsc(j17, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f17 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function111, function2RememberComposableLambda17, (Modifier) null, false, (Function2) null, (Shape) null, chipColors17, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f17, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable9;
                    i5 = i219;
                    i3 = i2110;
                    modifierMaterializeModifier = modifier14;
                    i4 = i6;
                } else {
                    i6 = i4;
                }
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str19);
                    }
                };
                composer119.updateRememberedValue(objRememberedValue2);
                Function0 function112 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer9);
                Function2 function2RememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str18, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer9, 54);
                SuggestionChipDefaults suggestionChipDefaults18 = SuggestionChipDefaults.INSTANCE;
                if (z2) {
                    composer9.startReplaceGroup(-949618085);
                    ComposerKt.sourceInformation(composer9, "1420@62941L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                    composer9.endReplaceGroup();
                } else {
                    composer9.startReplaceGroup(-949617132);
                    composer9.endReplaceGroup();
                    j = Color.Companion.getTransparent-0d7_KjU();
                }
                long j18 = j;
                if (z2) {
                    composer9.startReplaceGroup(-949613667);
                    ComposerKt.sourceInformation(composer9, "1421@63079L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                } else {
                    composer9.startReplaceGroup(-949612007);
                    ComposerKt.sourceInformation(composer9, "1421@63131L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer9.endReplaceGroup();
                composer10 = composer9;
                ChipColors chipColors18 = suggestionChipDefaults18.suggestionChipColors-5tl4gsc(j18, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                float f18 = Dp.constructor-impl(1);
                if (z2) {
                    composer10.startReplaceGroup(-949603728);
                    ComposerKt.sourceInformation(composer10, "1425@63390L11");
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer10.startReplaceGroup(-949601925);
                    ComposerKt.sourceInformation(composer10, "1425@63429L11");
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer10.endReplaceGroup();
                ChipKt.SuggestionChip(function112, function2RememberComposableLambda18, (Modifier) null, false, (Function2) null, (Shape) null, chipColors18, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f18, j3), (MutableInteractionSource) null, composer10, 48, 700);
                composer9 = composer10;
                list = iterable9;
                i5 = i219;
                i3 = i2110;
                modifierMaterializeModifier = modifier14;
                i4 = i6;
            }
            Composer composer1110 = composer9;
            composer1110.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer1110);
            ComposerKt.sourceInformationMarkerEnd(composer9);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            String strChatbotTab$lambda$1814 = ChatbotTab$lambda$189($systemInstruction$delegate);
            Modifier modifier15 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
            Shape shape6 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            TextStyle bodySmall6 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
            ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance2 = composer2.changedInstance($viewModel);
            Object objRememberedValue9 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            } else {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1814, (Function1) obj, modifier15, false, false, bodySmall6, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape6, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        composer5 = composer2;
        objRememberedValue = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda47
            public final Object invoke(Object obj2) {
                return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$210$lambda$209$lambda$208($viewModel, ((Boolean) obj2).booleanValue());
            }
        };
        composer2.updateRememberedValue(objRememberedValue);
        ComposerKt.sourceInformationMarkerEnd(composer5);
        SwitchKt.Switch(zChatbotTab$lambda$192, (Function1) objRememberedValue, (Modifier) null, (Function2) null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getSuccessGreen(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer5, 54, SwitchDefaults.$stable << 18, 65532), (MutableInteractionSource) null, composer5, 0, 92);
        ComposerKt.sourceInformationMarkerEnd(composer5);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
        TextKt.Text--4IGK_g("Intelligence Engine (Model):", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
        Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Arrangement.Horizontal horizontal7 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(horizontal7, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap12 = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default7);
        constructor3 = ComposeUiNode.Companion.getConstructor();
        int i1114 = ((((54 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            function3 = constructor3;
            composer2.createNode(function3);
        } else {
            function3 = constructor3;
            composer2.useNode();
        }
        composer6 = Updater.constructor-impl(composer2);
        Updater.set-impl(composer6, measurePolicyRowMeasurePolicy9, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer6, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash12 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer6.getInserting()) {
        }
        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        composer6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash12);
        Updater.set-impl(composer6, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
        int i1115 = (i1114 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        int i1116 = ((54 >> 6) & 112) | 6;
        rowScope = RowScopeInstance.INSTANCE;
        composer7 = composer2;
        ComposerKt.sourceInformationMarkerStart(composer7, 445522054, "C:WhatsAppDashboard.kt#naom5h");
        composer7.startReplaceGroup(2092590806);
        ComposerKt.sourceInformation(composer7, "*1383@60544L42,1384@60632L33,1385@60735L361,1382@60482L965");
        iterableListOf = CollectionsKt.listOf(new Pair[]{new Pair("Pro preview (Complex)", "gemini-3.1-pro-preview"), new Pair("Flash (General)", "gemini-3.5-flash"), new Pair("Flash Lite (Fast)", "gemini-3.1-flash-lite-preview")});
        i = 0;
        it = iterableListOf.iterator();
        while (it.hasNext()) {
            Pair pair4 = (Pair) it.next();
            Iterable iterable10 = iterableListOf;
            final String str110 = (String) pair4.component1();
            int i1117 = i;
            final String str111 = (String) pair4.component2();
            Iterator it5 = it;
            zAreEqual = Intrinsics.areEqual(ChatbotTab$lambda$190($activeModel$delegate), str111);
            ComposerKt.sourceInformationMarkerStart(composer7, 1822585742, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance4 = composer7.changedInstance($viewModel) | composer7.changed(str111);
            Composer composer1111 = composer7;
            objRememberedValue3 = composer1111.rememberedValue();
            if (!zChangedInstance4) {
                rowScope2 = rowScope;
                if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                }
                Function0 function113 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Function2 function2RememberComposableLambda19 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str110, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer7, 54);
                SuggestionChipDefaults suggestionChipDefaults19 = SuggestionChipDefaults.INSTANCE;
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822595959);
                    ComposerKt.sourceInformation(composer7, "1386@60844L11");
                    j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    composer7.endReplaceGroup();
                } else {
                    composer7.startReplaceGroup(1822596943);
                    composer7.endReplaceGroup();
                    j4 = Color.Companion.getTransparent-0d7_KjU();
                }
                if (zAreEqual) {
                    composer7.startReplaceGroup(1822600395);
                    ComposerKt.sourceInformation(composer7, "1387@60991L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer7.startReplaceGroup(1822601652);
                    ComposerKt.sourceInformation(composer7, "1387@61030L11");
                    j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer7.endReplaceGroup();
                composer11 = composer7;
                ChipColors chipColors19 = suggestionChipDefaults19.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
                float f19 = Dp.constructor-impl(1);
                if (zAreEqual) {
                    composer11.startReplaceGroup(1822609931);
                    ComposerKt.sourceInformation(composer11, "1391@61289L11");
                    j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer11.startReplaceGroup(1822611734);
                    ComposerKt.sourceInformation(composer11, "1391@61328L11");
                    j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer11.endReplaceGroup();
                ChipKt.SuggestionChip(function113, function2RememberComposableLambda19, (Modifier) null, false, (Function2) null, (Shape) null, chipColors19, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f19, j6), (MutableInteractionSource) null, composer11, 48, 700);
                measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
                composer7 = composer11;
                it = it5;
                i = i1117;
                iterableListOf = iterable10;
                rowScope = rowScope2;
            } else {
                rowScope2 = rowScope;
            }
            objRememberedValue3 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda48
                public final Object invoke() {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$212$lambda$211($viewModel, str111);
                }
            };
            composer1111.updateRememberedValue(objRememberedValue3);
            Function0 function114 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer7);
            Function2 function2RememberComposableLambda110 = ComposableLambdaKt.rememberComposableLambda(190647142, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda49
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(str110, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer7, 54);
            SuggestionChipDefaults suggestionChipDefaults110 = SuggestionChipDefaults.INSTANCE;
            if (zAreEqual) {
                composer7.startReplaceGroup(1822595959);
                ComposerKt.sourceInformation(composer7, "1386@60844L11");
                j4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                composer7.endReplaceGroup();
            } else {
                composer7.startReplaceGroup(1822596943);
                composer7.endReplaceGroup();
                j4 = Color.Companion.getTransparent-0d7_KjU();
            }
            if (zAreEqual) {
                composer7.startReplaceGroup(1822600395);
                ComposerKt.sourceInformation(composer7, "1387@60991L11");
                j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary-0d7_KjU();
            } else {
                composer7.startReplaceGroup(1822601652);
                ComposerKt.sourceInformation(composer7, "1387@61030L11");
                j5 = MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            }
            composer7.endReplaceGroup();
            composer11 = composer7;
            ChipColors chipColors110 = suggestionChipDefaults110.suggestionChipColors-5tl4gsc(j4, j5, 0L, 0L, 0L, 0L, composer11, SuggestionChipDefaults.$stable << 18, 60);
            float f110 = Dp.constructor-impl(1);
            if (zAreEqual) {
                composer11.startReplaceGroup(1822609931);
                ComposerKt.sourceInformation(composer11, "1391@61289L11");
                j6 = MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getPrimary-0d7_KjU();
            } else {
                composer11.startReplaceGroup(1822611734);
                ComposerKt.sourceInformation(composer11, "1391@61328L11");
                j6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer11, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            composer11.endReplaceGroup();
            ChipKt.SuggestionChip(function114, function2RememberComposableLambda110, (Modifier) null, false, (Function2) null, (Shape) null, chipColors110, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f110, j6), (MutableInteractionSource) null, composer11, 48, 700);
            measurePolicyColumnMeasurePolicy = measurePolicyColumnMeasurePolicy;
            composer7 = composer11;
            it = it5;
            i = i1117;
            iterableListOf = iterable10;
            rowScope = rowScope2;
        }
        Composer composer1112 = composer7;
        composer1112.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer1112);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
        TextKt.Text--4IGK_g("Preset Roles & Model Pairs:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelMedium(), composer2, 196614, 0, 65498);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer2, 6);
        Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Arrangement.Horizontal horizontal8 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(horizontal8, Alignment.Companion.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default8);
        constructor4 = ComposeUiNode.Companion.getConstructor();
        int i2111 = ((((54 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            function4 = constructor4;
            composer2.createNode(function4);
        } else {
            function4 = constructor4;
            composer2.useNode();
        }
        composer8 = Updater.constructor-impl(composer2);
        Updater.set-impl(composer8, measurePolicyRowMeasurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer8, currentCompositionLocalMap13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash13 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer8.getInserting()) {
            i2 = currentCompositeKeyHash4;
            if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(i2))) {
            }
            Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2112 = (i2111 >> 6) & 14;
            composer9 = composer2;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope11 = RowScopeInstance.INSTANCE;
            i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
            composer9.startReplaceGroup(27501884);
            ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
            list = $presetRoles;
            i5 = 0;
            while (r65.hasNext()) {
                Iterable iterable11 = list;
                final String str112 = (String) triple.component1();
                int i2113 = i5;
                str = (String) triple.component2();
                int i2114 = i3;
                final String str113 = (String) triple.component3();
                Modifier modifier16 = modifierMaterializeModifier;
                if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                    z = false;
                } else {
                    z = false;
                }
                z2 = z;
                ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str113);
                Composer composer1113 = composer9;
                objRememberedValue2 = composer1113.rememberedValue();
                if (!zChangedInstance3) {
                    i6 = i4;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    Function0 function115 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    Function2 function2RememberComposableLambda111 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                        public final Object invoke(Object obj2, Object obj3) {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str112, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer9, 54);
                    SuggestionChipDefaults suggestionChipDefaults111 = SuggestionChipDefaults.INSTANCE;
                    if (z2) {
                        composer9.startReplaceGroup(-949618085);
                        ComposerKt.sourceInformation(composer9, "1420@62941L11");
                        j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                        composer9.endReplaceGroup();
                    } else {
                        composer9.startReplaceGroup(-949617132);
                        composer9.endReplaceGroup();
                        j = Color.Companion.getTransparent-0d7_KjU();
                    }
                    long j19 = j;
                    if (z2) {
                        composer9.startReplaceGroup(-949613667);
                        ComposerKt.sourceInformation(composer9, "1421@63079L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                    } else {
                        composer9.startReplaceGroup(-949612007);
                        ComposerKt.sourceInformation(composer9, "1421@63131L11");
                        j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    }
                    composer9.endReplaceGroup();
                    composer10 = composer9;
                    ChipColors chipColors111 = suggestionChipDefaults111.suggestionChipColors-5tl4gsc(j19, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                    float f111 = Dp.constructor-impl(1);
                    if (z2) {
                        composer10.startReplaceGroup(-949603728);
                        ComposerKt.sourceInformation(composer10, "1425@63390L11");
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    } else {
                        composer10.startReplaceGroup(-949601925);
                        ComposerKt.sourceInformation(composer10, "1425@63429L11");
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer10.endReplaceGroup();
                    ChipKt.SuggestionChip(function115, function2RememberComposableLambda111, (Modifier) null, false, (Function2) null, (Shape) null, chipColors111, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f111, j3), (MutableInteractionSource) null, composer10, 48, 700);
                    composer9 = composer10;
                    list = iterable11;
                    i5 = i2113;
                    i3 = i2114;
                    modifierMaterializeModifier = modifier16;
                    i4 = i6;
                } else {
                    i6 = i4;
                }
                objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                    public final Object invoke() {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str113);
                    }
                };
                composer1113.updateRememberedValue(objRememberedValue2);
                Function0 function116 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer9);
                Function2 function2RememberComposableLambda112 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str112, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer9, 54);
                SuggestionChipDefaults suggestionChipDefaults112 = SuggestionChipDefaults.INSTANCE;
                if (z2) {
                    composer9.startReplaceGroup(-949618085);
                    ComposerKt.sourceInformation(composer9, "1420@62941L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                    composer9.endReplaceGroup();
                } else {
                    composer9.startReplaceGroup(-949617132);
                    composer9.endReplaceGroup();
                    j = Color.Companion.getTransparent-0d7_KjU();
                }
                long j110 = j;
                if (z2) {
                    composer9.startReplaceGroup(-949613667);
                    ComposerKt.sourceInformation(composer9, "1421@63079L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                } else {
                    composer9.startReplaceGroup(-949612007);
                    ComposerKt.sourceInformation(composer9, "1421@63131L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer9.endReplaceGroup();
                composer10 = composer9;
                ChipColors chipColors112 = suggestionChipDefaults112.suggestionChipColors-5tl4gsc(j110, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                float f112 = Dp.constructor-impl(1);
                if (z2) {
                    composer10.startReplaceGroup(-949603728);
                    ComposerKt.sourceInformation(composer10, "1425@63390L11");
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer10.startReplaceGroup(-949601925);
                    ComposerKt.sourceInformation(composer10, "1425@63429L11");
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer10.endReplaceGroup();
                ChipKt.SuggestionChip(function116, function2RememberComposableLambda112, (Modifier) null, false, (Function2) null, (Shape) null, chipColors112, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f112, j3), (MutableInteractionSource) null, composer10, 48, 700);
                composer9 = composer10;
                list = iterable11;
                i5 = i2113;
                i3 = i2114;
                modifierMaterializeModifier = modifier16;
                i4 = i6;
            }
            Composer composer1114 = composer9;
            composer1114.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer1114);
            ComposerKt.sourceInformationMarkerEnd(composer9);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
            String strChatbotTab$lambda$1815 = ChatbotTab$lambda$189($systemInstruction$delegate);
            Modifier modifier17 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
            Shape shape7 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            TextStyle bodySmall7 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
            ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance2 = composer2.changedInstance($viewModel);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            } else {
                obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj2) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1815, (Function1) obj, modifier17, false, false, bodySmall7, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape7, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        i2 = currentCompositeKeyHash4;
        composer8.updateRememberedValue(Integer.valueOf(i2));
        composer8.apply(Integer.valueOf(i2), setCompositeKeyHash13);
        Updater.set-impl(composer8, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
        int i2115 = (i2111 >> 6) & 14;
        composer9 = composer2;
        i3 = 0;
        ComposerKt.sourceInformationMarkerStart(composer9, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        RowScope rowScope12 = RowScopeInstance.INSTANCE;
        i4 = ((54 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart(composer9, 852546875, "C:WhatsAppDashboard.kt#naom5h");
        composer9.startReplaceGroup(27501884);
        ComposerKt.sourceInformation(composer9, "*1414@62480L204,1418@62730L32,1419@62832L365,1413@62418L1130");
        list = $presetRoles;
        i5 = 0;
        while (r65.hasNext()) {
            Iterable iterable12 = list;
            final String str114 = (String) triple.component1();
            int i2116 = i5;
            str = (String) triple.component2();
            int i2117 = i3;
            final String str115 = (String) triple.component3();
            Modifier modifier18 = modifierMaterializeModifier;
            if (Intrinsics.areEqual(ChatbotTab$lambda$189($systemInstruction$delegate), str)) {
                z = false;
            } else {
                z = false;
            }
            z2 = z;
            ComposerKt.sourceInformationMarkerStart(composer9, -949633035, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            zChangedInstance3 = composer9.changedInstance($viewModel) | composer9.changed(str) | composer9.changed(str115);
            Composer composer1115 = composer9;
            objRememberedValue2 = composer1115.rememberedValue();
            if (!zChangedInstance3) {
                i6 = i4;
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                }
                Function0 function117 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer9);
                Function2 function2RememberComposableLambda113 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                    public final Object invoke(Object obj2, Object obj3) {
                        return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str114, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer9, 54);
                SuggestionChipDefaults suggestionChipDefaults113 = SuggestionChipDefaults.INSTANCE;
                if (z2) {
                    composer9.startReplaceGroup(-949618085);
                    ComposerKt.sourceInformation(composer9, "1420@62941L11");
                    j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                    composer9.endReplaceGroup();
                } else {
                    composer9.startReplaceGroup(-949617132);
                    composer9.endReplaceGroup();
                    j = Color.Companion.getTransparent-0d7_KjU();
                }
                long j111 = j;
                if (z2) {
                    composer9.startReplaceGroup(-949613667);
                    ComposerKt.sourceInformation(composer9, "1421@63079L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
                } else {
                    composer9.startReplaceGroup(-949612007);
                    ComposerKt.sourceInformation(composer9, "1421@63131L11");
                    j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                }
                composer9.endReplaceGroup();
                composer10 = composer9;
                ChipColors chipColors113 = suggestionChipDefaults113.suggestionChipColors-5tl4gsc(j111, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
                float f113 = Dp.constructor-impl(1);
                if (z2) {
                    composer10.startReplaceGroup(-949603728);
                    ComposerKt.sourceInformation(composer10, "1425@63390L11");
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
                } else {
                    composer10.startReplaceGroup(-949601925);
                    ComposerKt.sourceInformation(composer10, "1425@63429L11");
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer10.endReplaceGroup();
                ChipKt.SuggestionChip(function117, function2RememberComposableLambda113, (Modifier) null, false, (Function2) null, (Shape) null, chipColors113, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f113, j3), (MutableInteractionSource) null, composer10, 48, 700);
                composer9 = composer10;
                list = iterable12;
                i5 = i2116;
                i3 = i2117;
                modifierMaterializeModifier = modifier18;
                i4 = i6;
            } else {
                i6 = i4;
            }
            objRememberedValue2 = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda50
                public final Object invoke() {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216($viewModel, str, str115);
                }
            };
            composer1115.updateRememberedValue(objRememberedValue2);
            Function0 function118 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer9);
            Function2 function2RememberComposableLambda114 = ComposableLambdaKt.rememberComposableLambda(-1547773973, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda51
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(str114, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer9, 54);
            SuggestionChipDefaults suggestionChipDefaults114 = SuggestionChipDefaults.INSTANCE;
            if (z2) {
                composer9.startReplaceGroup(-949618085);
                ComposerKt.sourceInformation(composer9, "1420@62941L11");
                j = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU();
                composer9.endReplaceGroup();
            } else {
                composer9.startReplaceGroup(-949617132);
                composer9.endReplaceGroup();
                j = Color.Companion.getTransparent-0d7_KjU();
            }
            long j112 = j;
            if (z2) {
                composer9.startReplaceGroup(-949613667);
                ComposerKt.sourceInformation(composer9, "1421@63079L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU();
            } else {
                composer9.startReplaceGroup(-949612007);
                ComposerKt.sourceInformation(composer9, "1421@63131L11");
                j2 = MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            }
            composer9.endReplaceGroup();
            composer10 = composer9;
            ChipColors chipColors114 = suggestionChipDefaults114.suggestionChipColors-5tl4gsc(j112, j2, 0L, 0L, 0L, 0L, composer10, SuggestionChipDefaults.$stable << 18, 60);
            float f114 = Dp.constructor-impl(1);
            if (z2) {
                composer10.startReplaceGroup(-949603728);
                ComposerKt.sourceInformation(composer10, "1425@63390L11");
                j3 = MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getPrimary-0d7_KjU();
            } else {
                composer10.startReplaceGroup(-949601925);
                ComposerKt.sourceInformation(composer10, "1425@63429L11");
                j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer10, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            composer10.endReplaceGroup();
            ChipKt.SuggestionChip(function118, function2RememberComposableLambda114, (Modifier) null, false, (Function2) null, (Shape) null, chipColors114, (ChipElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(f114, j3), (MutableInteractionSource) null, composer10, 48, 700);
            composer9 = composer10;
            list = iterable12;
            i5 = i2116;
            i3 = i2117;
            modifierMaterializeModifier = modifier18;
            i4 = i6;
        }
        Composer composer1116 = composer9;
        composer1116.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer1116);
        ComposerKt.sourceInformationMarkerEnd(composer9);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer2, 6);
        String strChatbotTab$lambda$1816 = ChatbotTab$lambda$189($systemInstruction$delegate);
        Modifier modifier19 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(100));
        Shape shape8 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
        TextStyle bodySmall8 = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall();
        ComposerKt.sourceInformationMarkerStart(composer2, -1354786400, "CC(remember):WhatsAppDashboard.kt#9igjgp");
        zChangedInstance2 = composer2.changedInstance($viewModel);
        Object objRememberedValue11 = composer2.rememberedValue();
        if (!zChangedInstance2) {
            obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                public final Object invoke(Object obj2) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                }
            };
            composer2.updateRememberedValue(obj);
        } else {
            obj = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda52
                public final Object invoke(Object obj2) {
                    return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221($viewModel, (String) obj2);
                }
            };
            composer2.updateRememberedValue(obj);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        OutlinedTextFieldKt.OutlinedTextField(strChatbotTab$lambda$1816, (Function1) obj, modifier19, false, false, bodySmall8, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1888589322$app(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 4, 0, (MutableInteractionSource) null, shape8, (TextFieldColors) null, composer2, 1573248, 100663296, 0, 6029208);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$210$lambda$209$lambda$208(WhatsAppViewModel $viewModel, boolean it) {
        $viewModel.toggleUseChatbotForReplies();
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$212$lambda$211(WhatsAppViewModel $viewModel, String $modelKey) {
        $viewModel.updateChatbotModel($modelKey);
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$215$lambda$214$lambda$213(String $label, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1384@60634L29:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(190647142, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1384)");
            }
            TextKt.Text--4IGK_g($label, (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$217$lambda$216(WhatsAppViewModel $viewModel, String $prompt, String $model) {
        $viewModel.updateChatbotSystemInstruction($prompt);
        $viewModel.updateChatbotModel($model);
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$220$lambda$219$lambda$218(String $name, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1418@62732L28:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1547773973, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1418)");
            }
            TextKt.Text--4IGK_g($name, (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221(WhatsAppViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.updateChatbotSystemInstruction(it);
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$229$lambda$228$lambda$227(WhatsAppViewModel $viewModel) {
        $viewModel.clearChatbotHistory();
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$234$lambda$233(State $messages$delegate, State $isGenerating$delegate, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List<WhatsAppMessage> listChatbotTab$lambda$188 = ChatbotTab$lambda$188($messages$delegate);
        final Function1 function1 = new Function1() { // from class: com.example.ui.WhatsAppDashboardKt$ChatbotTab$lambda$243$lambda$234$lambda$233$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m21invoke((WhatsAppMessage) p1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m21invoke(WhatsAppMessage whatsAppMessage) {
                return null;
            }
        };
        $this$LazyColumn.items(listChatbotTab$lambda$188.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatbotTab$lambda$243$lambda$234$lambda$233$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke(listChatbotTab$lambda$188.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.WhatsAppDashboardKt$ChatbotTab$lambda$243$lambda$234$lambda$233$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                WhatsAppMessage whatsAppMessage = (WhatsAppMessage) listChatbotTab$lambda$188.get(it);
                $composer.startReplaceGroup(-678632819);
                ComposerKt.sourceInformation($composer, "C*1525@67741L21:WhatsAppDashboard.kt#naom5h");
                WhatsAppDashboardKt.ChatBubble(whatsAppMessage, $composer, (($dirty & 14) >> 3) & 14);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (ChatbotTab$lambda$192($isGenerating$delegate)) {
            LazyListScope.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$847914765$app(), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$242$lambda$236$lambda$235(MutableState $textInput$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $textInput$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$242$lambda$239(final MutableState $textInput$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1553349044, $changed, -1, "com.example.ui.ChatbotTab.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1601)");
            }
            if (ChatbotTab$lambda$194($textInput$delegate).length() > 0) {
                $composer.startReplaceGroup(-1843660791);
                ComposerKt.sourceInformation($composer, "1602@71365L18,1602@71344L349");
                ComposerKt.sourceInformationMarkerStart($composer, 1880190846, "CC(remember):WhatsAppDashboard.kt#9igjgp");
                Object objRememberedValue = $composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    obj = new Function0() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            return WhatsAppDashboardKt.ChatbotTab$lambda$243$lambda$242$lambda$239$lambda$238$lambda$237($textInput$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) obj, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$WhatsAppDashboardKt.INSTANCE.getLambda$1511918932$app(), $composer, 196614, 30);
            } else {
                $composer.startReplaceGroup(-1914421546);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$242$lambda$239$lambda$238$lambda$237(MutableState $textInput$delegate) {
        $textInput$delegate.setValue("");
        return Unit.INSTANCE;
    }

    static final Unit ChatbotTab$lambda$243$lambda$242$lambda$241$lambda$240(WhatsAppViewModel $viewModel, MutableState $textInput$delegate, State $isGenerating$delegate) {
        if (!StringsKt.isBlank(ChatbotTab$lambda$194($textInput$delegate)) && !ChatbotTab$lambda$192($isGenerating$delegate)) {
            $viewModel.sendChatbotMessage(ChatbotTab$lambda$194($textInput$delegate));
            $textInput$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    public static final void ChatBubble(final WhatsAppMessage msg, Composer $composer, final int $changed) {
        long j;
        long contentColor;
        Composer $composer2;
        Function0 function0;
        Function0 function1;
        Object obj;
        Function0 function2;
        Composer composer;
        Function0 function3;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Composer $composer3 = $composer.startRestartGroup(-1853707586);
        ComposerKt.sourceInformation($composer3, "C(ChatBubble)1658@73197L2967:WhatsAppDashboard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(msg) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1853707586, $dirty, -1, "com.example.ui.ChatBubble (WhatsAppDashboard.kt:1638)");
            }
            boolean isIncoming = msg.isIncoming();
            Alignment.Companion companion = Alignment.Companion;
            Alignment.Horizontal alignment = isIncoming ? companion.getStart() : companion.getEnd();
            if (isIncoming) {
                $composer3.startReplaceGroup(886996588);
                ComposerKt.sourceInformation($composer3, "1642@72783L11");
                j = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(887057875);
                ComposerKt.sourceInformation($composer3, "1644@72845L11");
                j = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer3.endReplaceGroup();
            }
            long containerColor = j;
            if (isIncoming) {
                $composer3.startReplaceGroup(887146442);
                ComposerKt.sourceInformation($composer3, "1647@72934L11");
                long j2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                $composer3.endReplaceGroup();
                contentColor = j2;
            } else {
                $composer3.startReplaceGroup(887209713);
                ComposerKt.sourceInformation($composer3, "1649@72998L11");
                long j3 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                $composer3.endReplaceGroup();
                contentColor = j3;
            }
            RoundedCornerShape shape = isIncoming ? RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(4), Dp.constructor-impl(20), Dp.constructor-impl(20), Dp.constructor-impl(20)) : RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(20), Dp.constructor-impl(4), Dp.constructor-impl(20), Dp.constructor-impl(20));
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), alignment, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Alignment.Horizontal alignment2 = alignment;
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
            RoundedCornerShape shape2 = shape;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer composer2 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2033469577, "C1664@73356L2802:WhatsAppDashboard.kt#naom5h");
            Alignment.Vertical bottom = Alignment.Companion.getBottom();
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = isIncoming ? arrangement.getStart() : arrangement.getEnd();
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion, 0.85f);
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, bottom, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxWidth);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            int i4 = ((((390 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
                $composer3.useNode();
            }
            Composer composer3 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -537447114, "C1687@74290L1142:WhatsAppDashboard.kt#naom5h");
            if (isIncoming) {
                $composer3.startReplaceGroup(-537489771);
                ComposerKt.sourceInformation($composer3, "1674@73788L11,1670@73613L593,1684@74223L39");
                Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap currentCompositionLocalMap3 = $composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer3, modifier2);
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                int i7 = ((((48 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function3 = constructor3;
                    $composer3.createNode(function3);
                } else {
                    function3 = constructor3;
                    $composer3.useNode();
                }
                Composer composer4 = Updater.constructor-impl($composer3);
                Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                int i8 = (i7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i9 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1382424817, "C1681@74136L11,1677@73915L273:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(PersonKt.getPerson(Icons.INSTANCE.getDefault()), "User", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), $composer3, 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            } else {
                $composer3.startReplaceGroup(-610518114);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier3 = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), alignment2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap4 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer3, modifier3);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            int i10 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor4);
            } else {
                $composer3.useNode();
            }
            Composer composer5 = Updater.constructor-impl($composer3);
            Updater.set-impl(composer5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composer5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            int i11 = (i10 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1524710311, "C1693@74545L274,1688@74348L471,1701@74853L40,1703@74944L172,1709@75220L10,1710@75285L11,1707@75133L285:WhatsAppDashboard.kt#naom5h");
            SurfaceKt.Surface-T9BRK9s((Modifier) null, (Shape) shape2, containerColor, contentColor, Dp.constructor-impl(2), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-304347213, true, new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.ChatBubble$lambda$251$lambda$250$lambda$248$lambda$246(msg, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer3, 54), $composer3, 12607488, 97);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            long timestamp = msg.getTimestamp();
            ComposerKt.sourceInformationMarkerStart($composer3, 603391706, "CC(remember):WhatsAppDashboard.kt#9igjgp");
            boolean zChanged = $composer3.changed(timestamp);
            Object objRememberedValue = $composer3.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                obj = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(msg.getTimestamp()));
                $composer3.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            String str = (String) obj;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Intrinsics.checkNotNull(str);
            TextKt.Text--4IGK_g(str, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 48, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (isIncoming) {
                $composer3.startReplaceGroup(-610518114);
            } else {
                $composer3.startReplaceGroup(-535636591);
                ComposerKt.sourceInformation($composer3, "1716@75481L39,1721@75712L11,1717@75537L597");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
                Modifier modifier4 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap currentCompositionLocalMap5 = $composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier($composer3, modifier4);
                Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                int i13 = ((((48 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function2 = constructor5;
                    $composer3.createNode(function2);
                } else {
                    function2 = constructor5;
                    $composer3.useNode();
                }
                Composer composer6 = Updater.constructor-impl($composer3);
                Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composer6.getInserting()) {
                    composer = $composer3;
                } else {
                    composer = $composer3;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    }
                    Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                    int i14 = (i13 >> 6) & 14;
                    Composer composer7 = composer;
                    ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i15 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer7, 12639044, "C1728@76062L11,1724@75841L275:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(SmartToyKt.getSmartToy(Icons.INSTANCE.getDefault()), "AI", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), composer7, 432, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                }
                composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composer6.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                int i16 = (i13 >> 6) & 14;
                Composer composer8 = composer;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i17 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer8, 12639044, "C1728@76062L11,1724@75841L275:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(SmartToyKt.getSmartToy(Icons.INSTANCE.getDefault()), "AI", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme(composer8, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), composer8, 432, 0);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.WhatsAppDashboardKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj2, Object obj3) {
                    return WhatsAppDashboardKt.ChatBubble$lambda$252(msg, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    static final Unit ChatBubble$lambda$251$lambda$250$lambda$248$lambda$246(WhatsAppMessage $msg, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1697@74758L10,1694@74567L234:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-304347213, $changed, -1, "com.example.ui.ChatBubble.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WhatsAppDashboard.kt:1694)");
            }
            TextKt.Text--4IGK_g($msg.getMessageText(), PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(14), Dp.constructor-impl(10)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
