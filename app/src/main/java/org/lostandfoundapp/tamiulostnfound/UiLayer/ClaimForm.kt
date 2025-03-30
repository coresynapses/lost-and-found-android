package org.lostandfoundapp.tamiulostnfound.UiLayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ClaimForm(
    navController: NavController
) {
    Column {
        Text("Claim Form")
        Row {
            Text("Name:")
            Text("Something")
        }
        Row {
            Text("Location:")
            Text("Somewhere")
        }
        Row {
            Text("Time found:")
            Text("Sometime")
        }
        Row {
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text("Cancel")
            }
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text("Submit")
            }
        }
    }
}