package com.davysouza.horista.ui.components.cards

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Green50
import com.davysouza.horista.ui.theme.Purple10

@Composable
fun EnergyCard(
    @StringRes title: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Green50),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    bottom = 20.dp,
                    start = 28.dp,
                    end = 40.dp
                )
        ) {
            Text(
                text = stringResource(title),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Purple10
            )

            Text(
                text = stringResource(description),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Gray20
            )
        }
    }
}