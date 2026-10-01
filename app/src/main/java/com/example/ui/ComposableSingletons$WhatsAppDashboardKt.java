package com.example.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccessTimeKt;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.ChatKt;
import androidx.compose.material.icons.filled.ClearKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.DeleteSweepKt;
import androidx.compose.material.icons.filled.MessageKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.filled.PsychologyKt;
import androidx.compose.material.icons.filled.ScheduleKt;
import androidx.compose.material.icons.filled.SendKt;
import androidx.compose.material.icons.filled.SmartToyKt;
import androidx.compose.material.icons.filled.VoiceChatKt;
import androidx.compose.material.icons.filled.VpnKeyKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.example.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WhatsAppDashboard.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$WhatsAppDashboardKt {
    public static final ComposableSingletons$WhatsAppDashboardKt INSTANCE = new ComposableSingletons$WhatsAppDashboardKt();
    private static Function2<Composer, Integer, Unit> lambda$181000871 = ComposableLambdaKt.composableLambdaInstance(181000871, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_181000871$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$748742419 = ComposableLambdaKt.composableLambdaInstance(748742419, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_748742419$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-234369898, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f9lambda$234369898 = ComposableLambdaKt.composableLambdaInstance(-234369898, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda14
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__234369898$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1823756484, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f8lambda$1823756484 = ComposableLambdaKt.composableLambdaInstance(-1823756484, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda26
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1823756484$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1701888001, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f6lambda$1701888001 = ComposableLambdaKt.composableLambdaInstance(-1701888001, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda27
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1701888001$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-641523749, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f14lambda$641523749 = ComposableLambdaKt.composableLambdaInstance(-641523749, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda28
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__641523749$lambda$6((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-519655266, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f10lambda$519655266 = ComposableLambdaKt.composableLambdaInstance(-519655266, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda29
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__519655266$lambda$7((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$540708986 = ComposableLambdaKt.composableLambdaInstance(540708986, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda30
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_540708986$lambda$8((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$662577469 = ComposableLambdaKt.composableLambdaInstance(662577469, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda31
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_662577469$lambda$9((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1526848574 = ComposableLambdaKt.composableLambdaInstance(1526848574, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda32
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1526848574$lambda$10((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1503363791 = ComposableLambdaKt.composableLambdaInstance(1503363791, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda11
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1503363791$lambda$13((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1249510153, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f1lambda$1249510153 = ComposableLambdaKt.composableLambdaInstance(-1249510153, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda22
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1249510153$lambda$14((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1746998653, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f7lambda$1746998653 = ComposableLambdaKt.composableLambdaInstance(-1746998653, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda33
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1746998653$lambda$15((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$482963775 = ComposableLambdaKt.composableLambdaInstance(482963775, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda34
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_482963775$lambda$16((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-809792625, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f15lambda$809792625 = ComposableLambdaKt.composableLambdaInstance(-809792625, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda35
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__809792625$lambda$17((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1867191885 = ComposableLambdaKt.composableLambdaInstance(1867191885, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda36
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1867191885$lambda$18((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1576294650, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f4lambda$1576294650 = ComposableLambdaKt.composableLambdaInstance(-1576294650, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda37
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1576294650$lambda$19((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1679590844, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f5lambda$1679590844 = ComposableLambdaKt.composableLambdaInstance(-1679590844, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda38
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1679590844$lambda$20((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1717616775 = ComposableLambdaKt.composableLambdaInstance(1717616775, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda39
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1717616775$lambda$21((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1614320581 = ComposableLambdaKt.composableLambdaInstance(1614320581, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1614320581$lambda$22((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1500628507, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f3lambda$1500628507 = ComposableLambdaKt.composableLambdaInstance(-1500628507, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1500628507$lambda$23((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1855552259 = ComposableLambdaKt.composableLambdaInstance(1855552259, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1855552259$lambda$24((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1549228851 = ComposableLambdaKt.composableLambdaInstance(1549228851, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1549228851$lambda$25((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$533862532 = ComposableLambdaKt.composableLambdaInstance(533862532, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda6
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_533862532$lambda$26((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$295857567 = ComposableLambdaKt.composableLambdaInstance(295857567, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda7
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_295857567$lambda$27((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1556702766 = ComposableLambdaKt.composableLambdaInstance(1556702766, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1556702766$lambda$28((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1247695825, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f0lambda$1247695825 = ComposableLambdaKt.composableLambdaInstance(-1247695825, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda9
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1247695825$lambda$29((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-535911145, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f11lambda$535911145 = ComposableLambdaKt.composableLambdaInstance(-535911145, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda10
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__535911145$lambda$30((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1676504792 = ComposableLambdaKt.composableLambdaInstance(1676504792, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda12
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1676504792$lambda$31((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1487588406 = ComposableLambdaKt.composableLambdaInstance(1487588406, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda13
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1487588406$lambda$32((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-594962953, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f12lambda$594962953 = ComposableLambdaKt.composableLambdaInstance(-594962953, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda15
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__594962953$lambda$33((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-627724873, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f13lambda$627724873 = ComposableLambdaKt.composableLambdaInstance(-627724873, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda16
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__627724873$lambda$34((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$77748290 = ComposableLambdaKt.composableLambdaInstance(77748290, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda17
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_77748290$lambda$35((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1888589322 = ComposableLambdaKt.composableLambdaInstance(1888589322, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda18
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1888589322$lambda$36((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$2005371894 = ComposableLambdaKt.composableLambdaInstance(2005371894, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda19
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_2005371894$lambda$37((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$60985059 = ComposableLambdaKt.composableLambdaInstance(60985059, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda20
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_60985059$lambda$39((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$847914765 = ComposableLambdaKt.composableLambdaInstance(847914765, false, new Function3() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda21
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_847914765$lambda$42((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1496483698, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2lambda$1496483698 = ComposableLambdaKt.composableLambdaInstance(-1496483698, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda23
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda__1496483698$lambda$43((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1511918932 = ComposableLambdaKt.composableLambdaInstance(1511918932, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda24
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1511918932$lambda$44((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1023153687 = ComposableLambdaKt.composableLambdaInstance(1023153687, false, new Function2() { // from class: com.example.ui.ComposableSingletons$WhatsAppDashboardKt$$ExternalSyntheticLambda25
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WhatsAppDashboardKt.lambda_1023153687$lambda$45((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1247695825$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4getLambda$1247695825$app() {
        return f0lambda$1247695825;
    }

    /* JADX INFO: renamed from: getLambda$-1249510153$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m5getLambda$1249510153$app() {
        return f1lambda$1249510153;
    }

    /* JADX INFO: renamed from: getLambda$-1496483698$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6getLambda$1496483698$app() {
        return f2lambda$1496483698;
    }

    /* JADX INFO: renamed from: getLambda$-1500628507$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7getLambda$1500628507$app() {
        return f3lambda$1500628507;
    }

    /* JADX INFO: renamed from: getLambda$-1576294650$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8getLambda$1576294650$app() {
        return f4lambda$1576294650;
    }

    /* JADX INFO: renamed from: getLambda$-1679590844$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9getLambda$1679590844$app() {
        return f5lambda$1679590844;
    }

    /* JADX INFO: renamed from: getLambda$-1701888001$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m10getLambda$1701888001$app() {
        return f6lambda$1701888001;
    }

    /* JADX INFO: renamed from: getLambda$-1746998653$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m11getLambda$1746998653$app() {
        return f7lambda$1746998653;
    }

    /* JADX INFO: renamed from: getLambda$-1823756484$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12getLambda$1823756484$app() {
        return f8lambda$1823756484;
    }

    /* JADX INFO: renamed from: getLambda$-234369898$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13getLambda$234369898$app() {
        return f9lambda$234369898;
    }

    /* JADX INFO: renamed from: getLambda$-519655266$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14getLambda$519655266$app() {
        return f10lambda$519655266;
    }

    /* JADX INFO: renamed from: getLambda$-535911145$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m15getLambda$535911145$app() {
        return f11lambda$535911145;
    }

    /* JADX INFO: renamed from: getLambda$-594962953$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m16getLambda$594962953$app() {
        return f12lambda$594962953;
    }

    /* JADX INFO: renamed from: getLambda$-627724873$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m17getLambda$627724873$app() {
        return f13lambda$627724873;
    }

    /* JADX INFO: renamed from: getLambda$-641523749$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m18getLambda$641523749$app() {
        return f14lambda$641523749;
    }

    /* JADX INFO: renamed from: getLambda$-809792625$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m19getLambda$809792625$app() {
        return f15lambda$809792625;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1023153687$app() {
        return lambda$1023153687;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1487588406$app() {
        return lambda$1487588406;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1503363791$app() {
        return lambda$1503363791;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1511918932$app() {
        return lambda$1511918932;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1526848574$app() {
        return lambda$1526848574;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1549228851$app() {
        return lambda$1549228851;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1556702766$app() {
        return lambda$1556702766;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1614320581$app() {
        return lambda$1614320581;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1676504792$app() {
        return lambda$1676504792;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1717616775$app() {
        return lambda$1717616775;
    }

    public final Function2<Composer, Integer, Unit> getLambda$181000871$app() {
        return lambda$181000871;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1855552259$app() {
        return lambda$1855552259;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1867191885$app() {
        return lambda$1867191885;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1888589322$app() {
        return lambda$1888589322;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$2005371894$app() {
        return lambda$2005371894;
    }

    public final Function2<Composer, Integer, Unit> getLambda$295857567$app() {
        return lambda$295857567;
    }

    public final Function2<Composer, Integer, Unit> getLambda$482963775$app() {
        return lambda$482963775;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$533862532$app() {
        return lambda$533862532;
    }

    public final Function2<Composer, Integer, Unit> getLambda$540708986$app() {
        return lambda$540708986;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$60985059$app() {
        return lambda$60985059;
    }

    public final Function2<Composer, Integer, Unit> getLambda$662577469$app() {
        return lambda$662577469;
    }

    public final Function2<Composer, Integer, Unit> getLambda$748742419$app() {
        return lambda$748742419;
    }

    public final Function2<Composer, Integer, Unit> getLambda$77748290$app() {
        return lambda$77748290;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$847914765$app() {
        return lambda$847914765;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x01b0  */
    static final Unit lambda_181000871$lambda$1(Composer $composer, int $changed) {
        int i;
        ComposerKt.sourceInformation($composer, "C107@4351L550:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(181000871, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$181000871.<anonymous> (WhatsAppDashboard.kt:107)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i2 = ((((0 << 3) & 112) << 6) & 896) | 6;
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
                i = 0;
            } else {
                i = 0;
                if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.set-impl(composer, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 535462307, "C111@4551L11,108@4384L217,115@4753L10,116@4825L11,113@4626L253:WhatsAppDashboard.kt#naom5h");
                TextKt.Text--4IGK_g("Auto-Responder", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 196614, 0, 131034);
                TextKt.Text--4IGK_g("Intelligence Engine for WhatsApp", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
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
            ComposerKt.sourceInformationMarkerStart($composer, 535462307, "C111@4551L11,108@4384L217,115@4753L10,116@4825L11,113@4626L253:WhatsAppDashboard.kt#naom5h");
            TextKt.Text--4IGK_g("Auto-Responder", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 196614, 0, 131034);
            TextKt.Text--4IGK_g("Intelligence Engine for WhatsApp", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
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

    static final Unit lambda_748742419$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C150@6192L55:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(748742419, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$748742419.<anonymous> (WhatsAppDashboard.kt:150)");
            }
            IconKt.Icon-ww6aTOc(ChatKt.getChat(Icons.Filled.INSTANCE), "History", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__234369898$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C151@6281L13:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-234369898, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-234369898.<anonymous> (WhatsAppDashboard.kt:151)");
            }
            TextKt.Text--4IGK_g("Chats", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1823756484$lambda$4(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C157@6543L63:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1823756484, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1823756484.<anonymous> (WhatsAppDashboard.kt:157)");
            }
            IconKt.Icon-ww6aTOc(VoiceChatKt.getVoiceChat(Icons.Filled.INSTANCE), "AI Chatbot", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1701888001$lambda$5(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C158@6640L15:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701888001, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1701888001.<anonymous> (WhatsAppDashboard.kt:158)");
            }
            TextKt.Text--4IGK_g("Chatbot", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__641523749$lambda$6(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C164@6906L68:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-641523749, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-641523749.<anonymous> (WhatsAppDashboard.kt:164)");
            }
            IconKt.Icon-ww6aTOc(PsychologyKt.getPsychology(Icons.Filled.INSTANCE), "AI Personality", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__519655266$lambda$7(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C165@7008L21:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519655266, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-519655266.<anonymous> (WhatsAppDashboard.kt:165)");
            }
            TextKt.Text--4IGK_g("Personalities", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_540708986$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C171@7284L61:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(540708986, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$540708986.<anonymous> (WhatsAppDashboard.kt:171)");
            }
            IconKt.Icon-ww6aTOc(ScheduleKt.getSchedule(Icons.Filled.INSTANCE), "Scheduler", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_662577469$lambda$9(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C172@7379L17:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(662577469, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$662577469.<anonymous> (WhatsAppDashboard.kt:172)");
            }
            TextKt.Text--4IGK_g("Scheduler", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1526848574$lambda$10(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C232@10490L45:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526848574, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1526848574.<anonymous> (WhatsAppDashboard.kt:232)");
            }
            TextKt.Text--4IGK_g("Grant Permission", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:31:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:32:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:35:0x0207  */
    /* JADX WARN: Code duplicated, block: B:38:0x021a  */
    /* JADX WARN: Code duplicated, block: B:39:0x021d  */
    /* JADX WARN: Code duplicated, block: B:43:0x037d  */
    static final Unit lambda_1503363791$lambda$13(ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        int i;
        int currentCompositeKeyHash;
        Function0 constructor;
        Function0 function1;
        Composer composer;
        Composer composer2;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C248@11195L1316:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1503363791, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1503363791.<anonymous> (WhatsAppDashboard.kt:248)");
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
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1687168053, "C249@11264L787,264@12076L40,267@12386L10,265@12141L348:WhatsAppDashboard.kt#naom5h");
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
                    ComposerKt.sourceInformationMarkerStart(composer4, -365229645, "C250@11346L283,256@11658L40,261@11973L10,257@11727L298:WhatsAppDashboard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(VpnKeyKt.getVpnKey(Icons.INSTANCE.getDefault()), "API Key", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorKt.getAlertYellow(), composer4, 3504, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer4, 6);
                    TextKt.Text--4IGK_g("Gemini API Key Missing", (Modifier) null, ColorKt.getCosmicTextPrimary(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getTitleMedium(), composer4, 196998, 0, 65498);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                    TextKt.Text--4IGK_g("To enable AI auto-replies, please enter your GEMINI_API_KEY in the AI Studio Secrets panel. The app will fail to generate responses until this is set.", (Modifier) null, ColorKt.getCosmicTextSecondary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 390, 0, 65530);
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
                ComposerKt.sourceInformationMarkerStart(composer5, -365229645, "C250@11346L283,256@11658L40,261@11973L10,257@11727L298:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(VpnKeyKt.getVpnKey(Icons.INSTANCE.getDefault()), "API Key", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorKt.getAlertYellow(), composer5, 3504, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer5, 6);
                TextKt.Text--4IGK_g("Gemini API Key Missing", (Modifier) null, ColorKt.getCosmicTextPrimary(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getTitleMedium(), composer5, 196998, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                TextKt.Text--4IGK_g("To enable AI auto-replies, please enter your GEMINI_API_KEY in the AI Studio Secrets panel. The app will fail to generate responses until this is set.", (Modifier) null, ColorKt.getCosmicTextSecondary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 390, 0, 65530);
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i11 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1687168053, "C249@11264L787,264@12076L40,267@12386L10,265@12141L348:WhatsAppDashboard.kt#naom5h");
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
                ComposerKt.sourceInformationMarkerStart(composer6, -365229645, "C250@11346L283,256@11658L40,261@11973L10,257@11727L298:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(VpnKeyKt.getVpnKey(Icons.INSTANCE.getDefault()), "API Key", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorKt.getAlertYellow(), composer6, 3504, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer6, 6);
                TextKt.Text--4IGK_g("Gemini API Key Missing", (Modifier) null, ColorKt.getCosmicTextPrimary(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getTitleMedium(), composer6, 196998, 0, 65498);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                TextKt.Text--4IGK_g("To enable AI auto-replies, please enter your GEMINI_API_KEY in the AI Studio Secrets panel. The app will fail to generate responses until this is set.", (Modifier) null, ColorKt.getCosmicTextSecondary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 390, 0, 65530);
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
            ComposerKt.sourceInformationMarkerStart(composer7, -365229645, "C250@11346L283,256@11658L40,261@11973L10,257@11727L298:WhatsAppDashboard.kt#naom5h");
            IconKt.Icon-ww6aTOc(VpnKeyKt.getVpnKey(Icons.INSTANCE.getDefault()), "API Key", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorKt.getAlertYellow(), composer7, 3504, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), composer7, 6);
            TextKt.Text--4IGK_g("Gemini API Key Missing", (Modifier) null, ColorKt.getCosmicTextPrimary(), 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getTitleMedium(), composer7, 196998, 0, 65498);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            TextKt.Text--4IGK_g("To enable AI auto-replies, please enter your GEMINI_API_KEY in the AI Studio Secrets panel. The app will fail to generate responses until this is set.", (Modifier) null, ColorKt.getCosmicTextSecondary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 390, 0, 65530);
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

    static final Unit lambda__1249510153$lambda$14(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C469@20623L99,470@20743L39,471@20803L35:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249510153, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1249510153.<anonymous> (WhatsAppDashboard.kt:469)");
            }
            IconKt.Icon-ww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.INSTANCE.getDefault()), "Clear logs", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            TextKt.Text--4IGK_g("Clear All", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1746998653$lambda$15(RowScope $this$FilledTonalButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FilledTonalButton, "$this$FilledTonalButton");
        ComposerKt.sourceInformation($composer, "C693@29558L89,694@29664L39,695@29720L32:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1746998653, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1746998653.<anonymous> (WhatsAppDashboard.kt:693)");
            }
            IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            TextKt.Text--4IGK_g("Custom", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_482963775$lambda$16(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C755@32992L11,752@32773L366:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(482963775, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$482963775.<anonymous> (WhatsAppDashboard.kt:752)");
            }
            IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete Tone", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__809792625$lambda$17(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C842@36307L47:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-809792625, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-809792625.<anonymous> (WhatsAppDashboard.kt:842)");
            }
            TextKt.Text--4IGK_g("Recipient Name (exactly as in WhatsApp)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1867191885$lambda$18(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C843@36394L53:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867191885, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1867191885.<anonymous> (WhatsAppDashboard.kt:843)");
            }
            IconKt.Icon-ww6aTOc(PersonKt.getPerson(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1576294650$lambda$19(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C856@36927L20:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576294650, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1576294650.<anonymous> (WhatsAppDashboard.kt:856)");
            }
            TextKt.Text--4IGK_g("Message Text", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1679590844$lambda$20(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C857@36987L54:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1679590844, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1679590844.<anonymous> (WhatsAppDashboard.kt:857)");
            }
            IconKt.Icon-ww6aTOc(MessageKt.getMessage(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1717616775$lambda$21(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C910@39440L39:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1717616775, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1717616775.<anonymous> (WhatsAppDashboard.kt:910)");
            }
            TextKt.Text--4IGK_g("Or enter custom delay (minutes)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1614320581$lambda$22(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C911@39519L57:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1614320581, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1614320581.<anonymous> (WhatsAppDashboard.kt:911)");
            }
            IconKt.Icon-ww6aTOc(AccessTimeKt.getAccessTime(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1500628507$lambda$23(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C941@41122L72:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1500628507, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1500628507.<anonymous> (WhatsAppDashboard.kt:941)");
            }
            TextKt.Text--4IGK_g("Schedule Message", (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1855552259$lambda$24(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1058@45639L11,1055@45452L310:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1855552259, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1855552259.<anonymous> (WhatsAppDashboard.kt:1055)");
            }
            IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Cancel Schedule", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_295857567$lambda$27(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1079@46197L29:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(295857567, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$295857567.<anonymous> (WhatsAppDashboard.kt:1079)");
            }
            TextKt.Text--4IGK_g("Create AI Personality", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1556702766$lambda$28(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1085@46469L24:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1556702766, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1556702766.<anonymous> (WhatsAppDashboard.kt:1085)");
            }
            TextKt.Text--4IGK_g("Personality Name", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1247695825$lambda$29(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1086@46533L36:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1247695825, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1247695825.<anonymous> (WhatsAppDashboard.kt:1086)");
            }
            TextKt.Text--4IGK_g("e.g., Sarcastic Boss, Pirate", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__535911145$lambda$30(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1092@46810L25:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-535911145, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-535911145.<anonymous> (WhatsAppDashboard.kt:1092)");
            }
            TextKt.Text--4IGK_g("Short Description", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1676504792$lambda$31(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1093@46875L50:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1676504792, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1676504792.<anonymous> (WhatsAppDashboard.kt:1093)");
            }
            TextKt.Text--4IGK_g("e.g., Replies in cheeky professional terms", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1487588406$lambda$32(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1099@47156L36:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487588406, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1487588406.<anonymous> (WhatsAppDashboard.kt:1099)");
            }
            TextKt.Text--4IGK_g("AI Guidelines / Prompt Rules", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__594962953$lambda$33(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1100@47232L71:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-594962953, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-594962953.<anonymous> (WhatsAppDashboard.kt:1100)");
            }
            TextKt.Text--4IGK_g("e.g., Answer with humor, use lots of eye-roll emojis, be brief.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1549228851$lambda$25(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1112@47708L12:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1549228851, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1549228851.<anonymous> (WhatsAppDashboard.kt:1112)");
            }
            TextKt.Text--4IGK_g("Save", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_533862532$lambda$26(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C1117@47834L14:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533862532, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$533862532.<anonymous> (WhatsAppDashboard.kt:1117)");
            }
            TextKt.Text--4IGK_g("Cancel", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_77748290$lambda$35(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1140@48608L11,1140@48508L118:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(77748290, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$77748290.<anonymous> (WhatsAppDashboard.kt:1140)");
            }
            IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete conversation history", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__627724873$lambda$34(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1225@52961L13:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627724873, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-627724873.<anonymous> (WhatsAppDashboard.kt:1225)");
            }
            TextKt.Text--4IGK_g("Close", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1888589322$lambda$36(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1437@63955L39:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1888589322, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1888589322.<anonymous> (WhatsAppDashboard.kt:1437)");
            }
            TextKt.Text--4IGK_g("System Instruction / Agent Role", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_2005371894$lambda$37(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C1469@65249L209,1474@65479L39,1475@65539L38:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2005371894, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$2005371894.<anonymous> (WhatsAppDashboard.kt:1469)");
            }
            IconKt.Icon-ww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.INSTANCE.getDefault()), "Clear thread", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            TextKt.Text--4IGK_g("Clear Thread", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0363  */
    static final Unit lambda_847914765$lambda$42(LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 function0;
        Function0 function1;
        Composer composer;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C1530@67869L2588:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847914765, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$847914765.<anonymous> (WhatsAppDashboard.kt:1530)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 1, (Object) null);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((438 << 3) & 112) << 6) & 896) | 6;
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2065047706, "C1541@68454L11,1537@68231L753,1551@69013L39,1554@69220L11,1553@69141L139,1552@69081L1350:WhatsAppDashboard.kt#naom5h");
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), (Shape) null, 2, (Object) null);
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
            if (composer3.getInserting()) {
                composer = $composer;
            } else {
                composer = $composer;
                if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i5 = (i4 >> 6) & 14;
                Composer composer4 = composer;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer4, -282368387, "C1548@68888L11,1544@68619L335:WhatsAppDashboard.kt#naom5h");
                IconKt.Icon-ww6aTOc(SmartToyKt.getSmartToy(Icons.INSTANCE.getDefault()), "AI", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), composer4, 432, 0);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                CardKt.Card((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(4), Dp.constructor-impl(20), Dp.constructor-impl(20), Dp.constructor-impl(20)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, lambda$60985059, $composer, 196608, 25);
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
            composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            int i7 = (i4 >> 6) & 14;
            Composer composer5 = composer;
            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer5, -282368387, "C1548@68888L11,1544@68619L335:WhatsAppDashboard.kt#naom5h");
            IconKt.Icon-ww6aTOc(SmartToyKt.getSmartToy(Icons.INSTANCE.getDefault()), "AI", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), composer5, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            CardKt.Card((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(4), Dp.constructor-impl(20), Dp.constructor-impl(20), Dp.constructor-impl(20)), CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, lambda$60985059, $composer, 196608, 25);
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

    static final Unit lambda_60985059$lambda$39(ColumnScope $this$Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C1558@69432L969:WhatsAppDashboard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(60985059, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$60985059.<anonymous> (WhatsAppDashboard.kt:1558)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(14), Dp.constructor-impl(10));
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
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1060812540, "C1565@69917L11,1562@69695L279,1567@70011L39,1570@70217L10,1571@70301L11,1568@70087L280:WhatsAppDashboard.kt#naom5h");
            ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), Dp.constructor-impl(2), 0L, 0, $composer, 390, 24);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            TextKt.Text--4IGK_g("Thinking...", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), $composer, 6, 0, 65530);
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

    static final Unit lambda__1496483698$lambda$43(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1594@70999L30:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1496483698, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$-1496483698.<anonymous> (WhatsAppDashboard.kt:1594)");
            }
            TextKt.Text--4IGK_g("Ask Gemini anything...", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1511918932$lambda$44(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1606@71609L11,1603@71415L252:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1511918932, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1511918932.<anonymous> (WhatsAppDashboard.kt:1603)");
            }
            IconKt.Icon-ww6aTOc(ClearKt.getClear(Icons.INSTANCE.getDefault()), "Clear input", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1023153687$lambda$45(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1627@72348L178:WhatsAppDashboard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1023153687, $changed, -1, "com.example.ui.ComposableSingletons$WhatsAppDashboardKt.lambda$1023153687.<anonymous> (WhatsAppDashboard.kt:1627)");
            }
            IconKt.Icon-ww6aTOc(SendKt.getSend(Icons.INSTANCE.getDefault()), "Send", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), 0L, $composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
