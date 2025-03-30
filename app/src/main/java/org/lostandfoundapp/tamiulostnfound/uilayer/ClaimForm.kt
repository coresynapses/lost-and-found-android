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
fun ClaimForm(
    navController: NavController
) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Email:")
            TextField(
                value = "Enter email here...",
                onValueChange = {},
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Phone Number:")
            TextField(
                value = "Enter phone number here...",
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