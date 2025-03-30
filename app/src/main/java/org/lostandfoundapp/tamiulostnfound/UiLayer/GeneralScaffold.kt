package org.lostandfoundapp.tamiulostnfound.UiLayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GeneralScaffold(
    content: @Composable () -> Unit,
    navController: NavController,
    title: String = "Lost and Found",
    mainScreen: Boolean = false
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
        topBar = {
            Surface(
                color = Color.hsv(
                    hue = 342.0F,
                    saturation = 0.77F,
                    value = 0.38F
                ),
                shape = RectangleShape,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        color = Color.White,
                        text = title,
                        modifier = Modifier.padding(20.dp)
                    )
                    if (mainScreen) {
                        Row(
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(10.dp),
                                tint = Color.White
                            )
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "Settings",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(10.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (mainScreen) {
                FloatingActionButton(
                    onClick = { navController.navigate("add") }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        },
        content = { innerPadding ->
            Box (modifier = Modifier.padding(innerPadding)) {
                content()
            }
        }
    )
}