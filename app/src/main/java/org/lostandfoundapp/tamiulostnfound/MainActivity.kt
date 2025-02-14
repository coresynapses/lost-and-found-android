package org.lostandfoundapp.tamiulostnfound

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import org.lostandfoundapp.tamiulostnfound.ui.theme.TAMIULostNFoundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TAMIULostNFoundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Surface(color = Color.Red, shape = CircleShape) {
            Text(
                text = "$name...",
                modifier = modifier.padding(24.dp),
                color = Color.Cyan
            )
        }
        Text(
            text = "asdf1",
            modifier = modifier.padding(25.dp),
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TAMIULostNFoundTheme {
        Greeting("Android")
    }
}

data class Item(var tname: String) {
    val name : String = tname

}

class NetworkDataSource() {

}

class StorageDataSource() {

}

data class ItemsRepository(
    private val networkSource: NetworkDataSource,
    private val storageSource: StorageDataSource
) {
}

data class LNFUiState(var titems: List<Item>?) {
    val items: List<Item>? = titems
}

class LNFViewModel : ViewModel() {
    private var items : List<Item> = listOf()

    var uiState: LNFUiState by mutableStateOf(LNFUiState(items))
        private set


}