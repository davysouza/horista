package com.davysouza.horista.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.davysouza.horista.R
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray40

@Composable
fun MoreOptionsMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box {
        FilledTonalIconButton(
            onClick = { expanded = true },
            modifier = Modifier.size(40.dp),
            colors = IconButtonDefaults.filledTonalIconButtonColors(
                containerColor = Gray40,
                contentColor = Gray10
            )
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
//            DropdownMenuItem(
//                text = { Text("Editar") },
//                onClick = {
//                    expanded = false
//                    // ação
//                }
//            )

            DropdownMenuItem(
                text = { Text(stringResource(R.string.settings)) },
                onClick = {
                    expanded = false
                    // ação
                }
            )

//            DropdownMenuItem(
//                text = { Text("Excluir") },
//                onClick = {
//                    expanded = false
//                    // ação
//                }
//            )
        }
    }
}