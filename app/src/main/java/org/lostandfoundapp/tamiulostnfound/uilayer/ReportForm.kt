package org.lostandfoundapp.tamiulostnfound.uilayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import org.lostandfoundapp.tamiulostnfound.datalayer.Item
import org.lostandfoundapp.tamiulostnfound.datalayer.itemRepo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ReportForm(
    navController: NavController
) {
    var emailAddress by remember { mutableStateOf("") }
    var phoneNumber  by remember { mutableStateOf("") }

    Column {
        Row (verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = emailAddress,
                onValueChange = { emailAddress = it},
                label = { Text("Email:") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row (verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number:") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row {
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text("Cancel")
            }
            Button(onClick = {
                itemRepo.reportFoundItem(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                navController.navigate("main")
            }) {
                Text("Submit")
            }
        }
    }
}