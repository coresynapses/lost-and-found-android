package org.lostandfoundapp.tamiulostnfound.uilayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.lostandfoundapp.tamiulostnfound.R

@Composable
fun GeneralScaffold(
    content: @Composable () -> Unit,
    navController: NavController,
    title: String = "Lost and Found",
    mainScreen: Boolean = false
) {

    val navButtonColors = ButtonColors(
        containerColor = Color.hsv(hue = 342.0F, saturation = 0.77F, value = 0.38F),
        contentColor = Color.White,
        disabledContentColor = Color.Blue,
        disabledContainerColor = Color.Gray
    )

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
                            Button(
                                onClick = {},
                                colors = navButtonColors,
                                contentPadding = PaddingValues(0.dp),
//                                modifier = Modifier.size(intrisicSize.min)
                            ) {
                                Icon(
                                    Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
//                                        .padding(10.dp)
                                )
                            }
                            Button(
                                onClick = {},
                                colors = navButtonColors,
                                contentPadding = PaddingValues(0.dp),
//                                modifier = Modifier.size(intrisicSize.min)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.filter),
                                    contentDescription = "Filter",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .align(Alignment.CenterVertically)
//                                        .padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (mainScreen) {
                FloatingActionButton(
                    onClick = { navController.navigate("add") },
                    containerColor = Color.hsv(hue = 342.0F, saturation = 0.77F, value = 0.38F)
                ) {
                    Image(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "Filter",
                        modifier = Modifier
                            .size(30.dp)
                    )
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