package com.davysouza.horista.ui.components.cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Gray30
import com.davysouza.horista.ui.theme.Purple30

@Composable
fun MoodCard(
    @StringRes text: Int,
    @StringRes subtext: Int,
    @StringRes chipsText: Int,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Purple30),
        modifier = modifier.fillMaxWidth().height(210.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(28.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(subtext),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Gray20
                    )

                    Text(
                        text = stringResource(text),
                        color = Gray10,
                        fontSize = 30.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Image(
                    painterResource(icon),
                    contentDescription = null,
                    Modifier.size(86.dp).weight(.55f)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(144.dp)
                    .height(40.dp)
                    .background(
                        color = Gray30,
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Text(
                    text = stringResource(chipsText),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray20
                )
            }
        }
    }
}