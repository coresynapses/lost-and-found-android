package org.lostandfoundapp.tamiulostnfound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.lostandfoundapp.tamiulostnfound.datalayer.ItemsRepository
import org.lostandfoundapp.tamiulostnfound.uilayer.MainScreen
import org.lostandfoundapp.tamiulostnfound.uilayer.TAMIULostNFoundTheme

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