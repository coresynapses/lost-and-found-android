package org.lostandfoundapp.tamiulostnfound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.lostandfoundapp.tamiulostnfound.DataLayer.ItemsRepository
import org.lostandfoundapp.tamiulostnfound.UiLayer.MainScreen
import org.lostandfoundapp.tamiulostnfound.UiLayer.TAMIULostNFoundTheme

val itemRepo: ItemsRepository = ItemsRepository()

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TAMIULostNFoundTheme {
                MainScreen()
            }
        }
    }
}