package app.todolist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.AppTypography

private val LightColors = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val DarkColors = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

data class CustomColorScheme(
    val primaryBackgroundColor: Color,

    val backgroundColor: Color,
    val foregroundColor: Color,
    val iconColor: Color,

    val addIconColor: Color,

    val thumbColor: Color,

    val trackColor: Color,
    val unCheckTrackColor: Color,

    val activeBackgroundColor: Color,
    val activeForegroundColor: Color,

    val cardBackgroundColor: Color,
    val primaryCardForegroundColor: Color,
    val secondaryCardForegroundColor: Color,
    val lightSecondaryCardForegroundColor: Color,

    val cursorColor: Color,

    val activeActionColor: Color,
    val disabledActionColor: Color,

    val floatButtonBackgroundColor: Color
)

private val customColorSchemeLight = CustomColorScheme(
    primaryBackgroundColor = primaryBackgroundColorLight,
    backgroundColor = backgroundColorLight,
    foregroundColor = foregroundColorLight,
    iconColor = iconColorLight,
    thumbColor = thumbColorLight,
    addIconColor = addIconColorLight,
    trackColor = trackColorLight,
    unCheckTrackColor = unCheckTrackColorLight,
    activeBackgroundColor = activeBackgroundColorLight,
    activeForegroundColor = activeForegroundColorLight,
    cardBackgroundColor = cardBackgroundColorLight,
    primaryCardForegroundColor = primaryCardForegroundColorLight,
    secondaryCardForegroundColor = secondaryCardForegroundColorLight,
    lightSecondaryCardForegroundColor = lightSecondaryCardForegroundColorLight,
    cursorColor = cursorColorLight,
    activeActionColor = activeActionColorLight,
    disabledActionColor = disabledActionColorLight,
    floatButtonBackgroundColor = floatButtonBackgroundColorLight,
)

private val customColorSchemeDark = CustomColorScheme(
    primaryBackgroundColor = primaryBackgroundColorDark,
    backgroundColor = backgroundColorDark,
    foregroundColor = foregroundColorDark,
    iconColor = iconColorDark,
    thumbColor = thumbColorDark,
    addIconColor = addIconColorDark,
    trackColor = trackColorDark,
    unCheckTrackColor = unCheckTrackColorDark,
    activeBackgroundColor = activeBackgroundColorDark,
    activeForegroundColor = activeForegroundColorDark,
    cardBackgroundColor = cardBackgroundColorDark,
    primaryCardForegroundColor = primaryCardForegroundColorDark,
    secondaryCardForegroundColor = secondaryCardForegroundColorDark,
    lightSecondaryCardForegroundColor = lightSecondaryCardForegroundColorDark,
    cursorColor = cursorColorDark,
    activeActionColor = activeActionColorDark,
    disabledActionColor = disabledActionColorDark,
    floatButtonBackgroundColor = floatButtonBackgroundColorDark,
)

val LocalColorScheme = staticCompositionLocalOf {
    CustomColorScheme(
        primaryBackgroundColor = Color.Unspecified,
        backgroundColor = Color.Unspecified,
        foregroundColor = Color.Unspecified,
        iconColor = Color.Unspecified,
        thumbColor = Color.Unspecified,
        addIconColor = Color.Unspecified,
        trackColor = Color.Unspecified,
        unCheckTrackColor = Color.Unspecified,
        activeBackgroundColor = Color.Unspecified,
        activeForegroundColor = Color.Unspecified,
        cardBackgroundColor = Color.Unspecified,
        primaryCardForegroundColor = Color.Unspecified,
        secondaryCardForegroundColor = Color.Unspecified,
        lightSecondaryCardForegroundColor = Color.Unspecified,
        cursorColor = Color.Unspecified,
        activeActionColor = Color.Unspecified,
        disabledActionColor = Color.Unspecified,
        floatButtonBackgroundColor = Color.Unspecified
    )
}

@Composable
fun ToDoListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colorScheme =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        } else {
            if (darkTheme) DarkColors else LightColors
        }

    val customColorScheme = when {
        darkTheme -> customColorSchemeDark
        else -> customColorSchemeLight
    }

    CompositionLocalProvider(LocalColorScheme provides customColorScheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}
