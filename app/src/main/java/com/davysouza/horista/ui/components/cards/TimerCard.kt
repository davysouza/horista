package com.davysouza.horista.ui.components.cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Purple30
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import java.util.Locale
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds

@Composable
fun TimerCard(
    @StringRes mood: Int,
    @StringRes complement: Int,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    var time by remember { mutableStateOf("00:00:00") }

    val startTime = remember {
        LocalDateTime(2026, 6, 6, 8, 0, 0)
    }

    LaunchedEffect(startTime) {
        val timezone = TimeZone.currentSystemDefault()
        val startInstant = startTime.toInstant(timezone)

        while (true) {
            val nowInstant = Clock.System.now()
            val diff = nowInstant - startInstant

            val hours = diff.inWholeHours % 24
            val mins = diff.inWholeMinutes % 60
            val secs = diff.inWholeSeconds % 60

            time = String.format(
                Locale.getDefault(), "%02d:%02d:%02d", hours, mins, secs
            )

            delay(1.seconds)
        }
    }

    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Purple30),
        modifier = modifier.fillMaxWidth().height(210.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painterResource(icon),
                contentDescription = null,
                Modifier.size(86.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = time,
                        color = Gray10,
                        fontSize = 48.sp,
                        lineHeight = 48.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "${stringResource(mood)} • ${stringResource(complement)}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Gray20
                    )
                }
            }
        }
    }
}