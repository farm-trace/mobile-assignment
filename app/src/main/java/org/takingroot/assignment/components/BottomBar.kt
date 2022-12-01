package org.takingroot.assignment.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(onTabSelected: (Int) -> Unit) {
    Surface(
//        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { onTabSelected(0) }) {
                Icon(
                    Icons.Default.List,
                    contentDescription = "Forms list",
                    modifier = Modifier.size(40.dp)
                )
            }
            Button(onClick = { onTabSelected(1) }) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Responses",
                    modifier = Modifier.size(40.dp)
                )
            }
            Button(onClick = { onTabSelected(2) }) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(onTabSelected = {})
}