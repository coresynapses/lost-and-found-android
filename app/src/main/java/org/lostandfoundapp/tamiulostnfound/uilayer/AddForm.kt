package org.lostandfoundapp.tamiulostnfound.uilayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun AddForm(
    navController: NavController
) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Name:")
            TextField(
                value = "Enter name here...",
                onValueChange = {},
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Location:")
            TextField(
                value = "Enter location here...",
                onValueChange = {},
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Time found:")
            TextField(
                value = "Enter time found here...",
                onValueChange = {},
            )
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