package com.davysouza.horista.ui.components.cards

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Gray50
import com.davysouza.horista.ui.theme.Purple10
import com.davysouza.horista.ui.theme.Purple30

@Composable
fun GoalCard (
    @StringRes title: Int,
    @StringRes description: Int,
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
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Gray10
            )

            Text(
                text = stringResource(description),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Gray20
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                OutlinedTextField(
                    value = "8h00",
                    onValueChange = {  },
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple30
                    ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .weight(.6f)
                        .size(56.dp)
                ) {
                    Text(
                        text = "-",
                        color = Purple10,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple30
                    ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .weight(.6f)
                        .size(56.dp)
                ) {
                    Text(
                        text = "+",
                        color = Purple10,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }


        }
    }
}