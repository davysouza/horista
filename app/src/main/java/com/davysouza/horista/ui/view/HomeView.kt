package com.davysouza.horista.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.davysouza.horista.R
import com.davysouza.horista.ui.components.Header
import com.davysouza.horista.ui.components.buttons.PrimaryButton
import com.davysouza.horista.ui.components.cards.EnergyCard
import com.davysouza.horista.ui.components.cards.InfoCard
import com.davysouza.horista.ui.components.cards.MoodCard
import com.davysouza.horista.ui.components.cards.TimerCard
import com.davysouza.horista.ui.theme.Purple20
import com.davysouza.horista.ui.theme.Red
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    var journeyStarted by rememberSaveable { mutableStateOf(false) }

    val pageState = rememberPagerState(
        initialPage = 0,
        pageCount = { if (journeyStarted) 2 else 1 }
    )

    val containerColor by animateColorAsState(
        targetValue =  if (!journeyStarted) Purple20 else Red,
        animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
    )

    LaunchedEffect(journeyStarted) {
        while (journeyStarted) {
            delay(15.seconds)
            val nextPage = if (pageState.currentPage == 0) 1 else 0
            pageState.animateScrollToPage(nextPage)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Header(title = R.string.today)

            HorizontalPager(
                state =  pageState,
                pageSpacing = 16.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                when (it) {
                    0 -> MoodCard(
                        subtext = R.string.all_set,
                        text = R.string.before_start_text_mood,
                        icon = R.drawable.ic_mood_quiet,
                        chipsText = R.string.quiet_mood
                    )

                    1 -> TimerCard(
                        mood = R.string.focused_mood,
                        complement = R.string.no_breaks,
                        icon = R.drawable.ic_mood_waking_up
                    )
                }
            }

            AnimatedVisibility(
                visible = journeyStarted,
                enter = expandVertically(
                    animationSpec = MaterialTheme.motionScheme.defaultSpatialSpec(),
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
                ),
                exit = shrinkVertically(
                    animationSpec = MaterialTheme.motionScheme.defaultSpatialSpec(),
                    shrinkTowards = Alignment.Top
                ) + fadeOut(
                    animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
                )
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(28.dp)) {
                    InfoCard(
                        title = R.string.start_time,
                        value = "8h15"
                    )

                    InfoCard(
                        title = R.string.todays_time,
                        value = "8h17"
                    )
                }
            }

            PrimaryButton(
                text = if (!journeyStarted) R.string.start_journey else R.string.complete_journey,
                onClick = { journeyStarted = !journeyStarted },
                colors = ButtonDefaults.buttonColors(containerColor = containerColor)
            )

            AnimatedVisibility(
                visible = !journeyStarted,
                enter = expandVertically(
                    animationSpec = MaterialTheme.motionScheme.defaultSpatialSpec(),
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
                ),
                exit = shrinkVertically(
                    animationSpec = MaterialTheme.motionScheme.defaultSpatialSpec(),
                    shrinkTowards = Alignment.Top
                ) + fadeOut(
                    animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
                )
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(36.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(28.dp)) {
                        InfoCard(
                            title = R.string.today,
                            value = "0h00",
                            modifier = Modifier.weight(1f)
                        )

                        InfoCard(
                            title = R.string.goal,
                            value = "8h00",
                            modifier = Modifier.weight(1f)
                        )
                    }

                    EnergyCard(
                        title = R.string.stable_mood,
                        description = R.string.stable_mood_description
                    )
                }
            }
        }
    }
}