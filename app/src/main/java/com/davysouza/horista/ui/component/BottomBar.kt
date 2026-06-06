package com.davysouza.horista.ui.component

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material.icons.outlined.WorkHistory
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.davysouza.horista.R
import com.davysouza.horista.ui.theme.Purple10
import com.davysouza.horista.ui.theme.Gray20
import com.davysouza.horista.ui.theme.Purple30
import com.davysouza.horista.ui.theme.Purple20

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    val items = listOf(
        NavigationBarItem(
            text = R.string.today,
            icon = Icons.Outlined.Today
        ),

        NavigationBarItem(
            text = R.string.history,
            icon = Icons.Outlined.WorkHistory
        ),

//        NavigationBarItem(
//            text = R.string.settings,
//            icon = Icons.Outlined.Settings
//        )
    )

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            val selected = selectedItem == index

            NavigationBarItem(
                selected = selected,
                onClick = { selectedItem = index },

                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = if(selected) Purple20 else Gray20
                    )
                },

                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Purple30
                ),

                label = {
                    Text(
                        text = stringResource(item.text),
                        fontSize = 14.sp,
                        color = if (selected) Purple10 else Gray20,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    }
}

private data class NavigationBarItem(
    @param:StringRes val text: Int,
    val icon: ImageVector
)