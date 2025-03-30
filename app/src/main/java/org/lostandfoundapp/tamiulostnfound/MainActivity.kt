package org.lostandfoundapp.tamiulostnfound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import org.lostandfoundapp.tamiulostnfound.DataLayer.ItemsRepository
import org.lostandfoundapp.tamiulostnfound.UILayer.ItemEntry
import org.lostandfoundapp.tamiulostnfound.ui.theme.TAMIULostNFoundTheme

val itemRepo: ItemsRepository = ItemsRepository()

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TAMIULostNFoundTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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
                            Row {
                                Text(
                                    color = Color.White,
                                    text = "Lost and Found",
                                    modifier = Modifier.padding(20.dp)
                                )
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
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                // Do something here
                            }
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                ) {
                    LazyColumn {
                        items(itemRepo.getItems()) { item ->
                            ItemEntry(item = item)
                        }
                    }
                }
            }
        }
    }
}