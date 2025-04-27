package org.lostandfoundapp.tamiulostnfound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.lostandfoundapp.tamiulostnfound.datalayer.ItemsRepository
import org.lostandfoundapp.tamiulostnfound.datalayer.itemRepo
import org.lostandfoundapp.tamiulostnfound.uilayer.MainScreen
import org.lostandfoundapp.tamiulostnfound.uilayer.TAMIULostNFoundTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        itemRepo.setup(null)

        setContent {
            TAMIULostNFoundTheme {
                MainScreen()
            }
        }
    }
}