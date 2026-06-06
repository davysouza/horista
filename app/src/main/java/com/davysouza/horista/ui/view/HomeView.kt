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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.R
import com.davysouza.horista.ui.component.EnergyCard
import com.davysouza.horista.ui.component.Header
import com.davysouza.horista.ui.component.InfoCard
import com.davysouza.horista.ui.component.MainCard
import com.davysouza.horista.ui.theme.Purple20
import com.davysouza.horista.ui.theme.Red

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    var journeyStarted by remember { mutableStateOf(false) }

    val containerColor by animateColorAsState(
        targetValue =  if (!journeyStarted) Purple20 else Red,
        animationSpec = MaterialTheme.motionScheme.defaultEffectsSpec()
    )

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

            MainCard(
                subtext = R.string.all_set,
                text = R.string.before_start_text_mood,
                icon = R.drawable.calm,
                chipsText = R.string.quiet_mood
            )

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

            Button(
                onClick = { journeyStarted = !journeyStarted },
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = stringResource(
                        if (!journeyStarted) R.string.start_journey else R.string.complete_journey
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

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