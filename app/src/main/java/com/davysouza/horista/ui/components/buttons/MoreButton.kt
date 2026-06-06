package com.davysouza.horista.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.davysouza.horista.R
import com.davysouza.horista.ui.components.cards.GoalCard
import com.davysouza.horista.ui.theme.Gray10
import com.davysouza.horista.ui.theme.Gray40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreButton() {
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

        if (expanded) {
            ModalBottomSheet(
                onDismissRequest = { expanded = !expanded }
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(40.dp)
                ) {
                    GoalCard(
                        title = R.string.daily_goal,
                        description = R.string.daily_goal_description
                    )

                    PrimaryButton(
                        text = R.string.save_goal,
                        onClick = { expanded = !expanded }
                    )
                }
            }
        }

//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
////            DropdownMenuItem(
////                text = { Text("Editar") },
////                onClick = {
////                    expanded = false
////                    // ação
////                }
////            )
//
//            DropdownMenuItem(
//                text = { Text(stringResource(R.string.settings)) },
//                onClick = {
//                    expanded = false
//                    // ação
//                }
//            )
//
////            DropdownMenuItem(
////                text = { Text("Excluir") },
////                onClick = {
////                    expanded = false
////                    // ação
////                }
////            )
//        }
    }
}