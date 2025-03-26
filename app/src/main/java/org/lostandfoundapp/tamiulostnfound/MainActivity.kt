package org.lostandfoundapp.tamiulostnfound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import org.lostandfoundapp.tamiulostnfound.ui.theme.TAMIULostNFoundTheme

import org.lostandfoundapp.tamiulostnfound.DataLayer.Item
import org.lostandfoundapp.tamiulostnfound.DataLayer.ItemsRepository


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
                            Text(
                                color = Color.White,
                                text = "Lost and Found",
                                modifier = Modifier.padding(20.dp)
                            )
                            Box(
                                // modifier = Modifier.layout(20.dp)
                            ) {
                                Text(
                                    color = Color.White,
                                    text = "Filter",
                                    modifier = Modifier.padding(20.dp),
                                    textAlign = TextAlign.Right
                                )
                                Text(
                                    color = Color.White,
                                    text = "Settings",
                                    modifier = Modifier.padding(20.dp),
                                    textAlign = TextAlign.Right
                                )

                            }
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                // Do something here
                            }
                        ) {
                            Icon(Icons.Default.AddCircle, contentDescription = "Add")
                        }
                    }
                ) {
                    Text("Hey")
                }
            }
        }
    }
}

@Composable
fun ItemEntry(item: Item) {

    val status: String = if (item.dateClaimed == null) "Lost" else "Found"

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface (color = Color.Cyan,
            modifier = Modifier.size(width = 300.dp, height = 100.dp),
        ) {
            // Text("a")
        }
        Text(
            text = item.name,
            modifier = Modifier.padding(12.dp),
            color = Color.White
        )
        Text(
            text = "Status: ${status}",
            modifier = Modifier.padding(6.dp),
            color = Color.White
        )
        Text(
            text = "Date Reported: ${item.dateReported}",
            modifier = Modifier.padding(6.dp),
            color = Color.White
        )
        Text(
            text = "Category: ${item.category}",
            modifier = Modifier.padding(6.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val itemsRepo = ItemsRepository()
    itemsRepo.addItem()
    itemsRepo.addItem()
    itemsRepo.addItem()
    itemsRepo.addItem()
    itemsRepo.addItem()


    TAMIULostNFoundTheme {
        Column {
            for (item in itemsRepo.getItems()) {
                ItemEntry(item = item)
            }
        }
    }
}



data class LNFUiState(var titems: List<Item>?) {
    val items: List<Item>? = titems
}

class LNFViewModel : ViewModel() {
    private var items : List<Item> = listOf()

    var uiState: LNFUiState by mutableStateOf(LNFUiState(items))
        private set


}