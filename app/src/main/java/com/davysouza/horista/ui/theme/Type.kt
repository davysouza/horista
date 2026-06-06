package com.davysouza.horista.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.davysouza.horista.R

val InterFontFamily = FontFamily(
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_thin, FontWeight.Thin)
)

private fun TextStyle.withInter() = copy(
    fontFamily = InterFontFamily
)

private val DefaultTypography = Typography()

// Set of Material typography styles to start with
val Typography = DefaultTypography.copy(
    displayLarge = DefaultTypography.displayLarge.withInter(),
    displayMedium = DefaultTypography.displayMedium.withInter(),
    displaySmall = DefaultTypography.displaySmall.withInter(),

    headlineLarge = DefaultTypography.headlineLarge.withInter(),
    headlineMedium = DefaultTypography.headlineMedium.withInter(),
    headlineSmall = DefaultTypography.headlineSmall.withInter(),

    titleLarge = DefaultTypography.titleLarge.withInter(),
    titleMedium = DefaultTypography.titleMedium.withInter(),
    titleSmall = DefaultTypography.titleSmall.withInter(),

    bodyLarge = DefaultTypography.bodyLarge.withInter(),
    bodyMedium = DefaultTypography.bodyMedium.withInter(),
    bodySmall = DefaultTypography.bodySmall.withInter(),

    labelLarge = DefaultTypography.labelLarge.withInter(),
    labelMedium = DefaultTypography.labelMedium.withInter(),
    labelSmall = DefaultTypography.labelSmall.withInter()
)