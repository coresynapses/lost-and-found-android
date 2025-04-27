package org.lostandfoundapp.tamiulostnfound.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.lostandfoundapp.tamiulostnfound.R
import org.lostandfoundapp.tamiulostnfound.datalayer.Item
import org.lostandfoundapp.tamiulostnfound.datalayer.itemRepo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AddForm(
    navController: NavController,
) {
    var itemName by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxHeight()) {
        Column {
            TextField(
                value = itemName,
                onValueChange = { itemName = it },
                label = { Text("What is the lost item that you found?:") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Absolute.Center) {
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text("Cancel")
            }
            Button(onClick = {
                itemRepo.reportLostItem(Item(
                    name = itemName,
                    dateReported = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                    category = 0,
                    resource = R.drawable.jewel
                ))
                navController.navigate("main")
            }) {
                Text("Submit")
            }
        }
    }
}