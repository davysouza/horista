package com.davysouza.horista.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Gray10
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun Header(
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    val currentDate = LocalDate.now().toShortPtBrDate()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = currentDate)
            Text(
                text = stringResource(title),
                color = Gray10,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        MoreOptionsMenu()
    }
}

private fun LocalDate.toShortPtBrDate(): String {
    val locale = Locale.forLanguageTag("pt-BR")

    val weekDay = dayOfWeek
        .getDisplayName(TextStyle.FULL, locale)
        .substringBefore("-")
        .replaceFirstChar { it.titlecase(locale) }

    val month = month
        .getDisplayName(TextStyle.SHORT, locale)

    return "$weekDay, ${dayOfMonth.toString().padStart(2, '0')} $month"
}