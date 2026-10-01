package com.example.ui.theme;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "MyApplicationTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.darkColorScheme-C-Xl9yA$default(ColorKt.getEmeraldPrimary(), Color.Companion.getWhite-0d7_KjU(), 0, 0, 0, ColorKt.getEmeraldSecondary(), Color.Companion.getBlack-0d7_KjU(), 0, 0, ColorKt.getSuccessGreen(), 0, 0, 0, ColorKt.getCosmicBg(), ColorKt.getCosmicTextPrimary(), ColorKt.getCosmicSurface(), ColorKt.getCosmicTextPrimary(), ColorKt.getCosmicCard(), ColorKt.getCosmicTextSecondary(), 0, 0, 0, ColorKt.getErrorRed(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4711012, 15, (Object) null);
    private static final ColorScheme LightColorScheme = ColorSchemeKt.lightColorScheme-C-Xl9yA$default(androidx.compose.ui.graphics.ColorKt.Color(4278222953L), Color.Companion.getWhite-0d7_KjU(), 0, 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4280669030L), Color.Companion.getWhite-0d7_KjU(), 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4278672980L), 0, 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4293980917L), androidx.compose.ui.graphics.ColorKt.Color(4279311137L), Color.Companion.getWhite-0d7_KjU(), androidx.compose.ui.graphics.ColorKt.Color(4279311137L), androidx.compose.ui.graphics.ColorKt.Color(4293520880L), androidx.compose.ui.graphics.ColorKt.Color(4284905345L), 0, 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4292030255L), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4711012, 15, (Object) null);

    static final Unit MyApplicationTheme$lambda$0(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        MyApplicationTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MyApplicationTheme(boolean darkTheme, boolean dynamicColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        ColorScheme colorScheme;
        final boolean darkTheme2;
        final boolean dynamicColor2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(548420513);
        ComposerKt.sourceInformation($composer2, "C(MyApplicationTheme)P(1,2)58@1959L114:Theme.kt#75kw8w");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ((i & 1) == 0 && $composer2.changed(darkTheme)) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(dynamicColor) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            darkTheme2 = darkTheme;
            dynamicColor2 = dynamicColor;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "45@1461L21");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty &= -15;
                }
            } else {
                if ((i & 1) != 0) {
                    darkTheme = DarkThemeKt.isSystemInDarkTheme($composer2, 0);
                    $dirty &= -15;
                }
                if (i2 != 0) {
                    dynamicColor = false;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(548420513, $dirty, -1, "com.example.ui.theme.MyApplicationTheme (Theme.kt:48)");
            }
            if (dynamicColor && Build.VERSION.SDK_INT >= 31) {
                $composer2.startReplaceGroup(-59766970);
                ComposerKt.sourceInformation($composer2, "51@1763L7");
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Context context = (Context) objConsume;
                ColorScheme colorSchemeDynamicDarkColorScheme = darkTheme ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
                $composer2.endReplaceGroup();
                colorScheme = colorSchemeDynamicDarkColorScheme;
            } else if (darkTheme) {
                $composer2.startReplaceGroup(-1248848432);
                $composer2.endReplaceGroup();
                colorScheme = DarkColorScheme;
            } else {
                $composer2.startReplaceGroup(-1248847407);
                $composer2.endReplaceGroup();
                colorScheme = LightColorScheme;
            }
            MaterialThemeKt.MaterialTheme(colorScheme, (Shapes) null, TypeKt.getTypography(), function2, $composer2, (($dirty << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            darkTheme2 = darkTheme;
            dynamicColor2 = dynamicColor;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.MyApplicationTheme$lambda$0(darkTheme2, dynamicColor2, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
