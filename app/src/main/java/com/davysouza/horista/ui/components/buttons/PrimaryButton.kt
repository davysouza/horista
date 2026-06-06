package com.davysouza.horista.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davysouza.horista.ui.theme.Purple20

@Composable
fun PrimaryButton (
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Purple20)
) {
    Button(
        onClick = onClick,
        colors = colors,
        modifier = modifier.fillMaxWidth().height(56.dp)
    ) {
        Text(
            text = stringResource(text),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}