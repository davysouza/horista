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
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Gray50

@Composable
fun InfoCard(
    @StringRes title: Int,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Gray50),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    bottom = 28.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            Text(
                text = "${stringResource(title)}:",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Gray20
            )

            Text(
                text = value,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Gray10
            )
        }
    }
}