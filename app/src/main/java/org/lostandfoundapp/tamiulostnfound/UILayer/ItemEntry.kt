package org.lostandfoundapp.tamiulostnfound.UILayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.lostandfoundapp.tamiulostnfound.DataLayer.Item

@Composable
fun ItemsList(items: List<Item>) {
    LazyColumn {
        items(items) { item ->
            ItemEntry(item = item)
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
            modifier = Modifier.size(width = 400.dp, height = 300.dp)
                .fillMaxWidth(),
        ) {}
        Text(
            text = item.name,
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Status: ${status}",
            modifier = Modifier.padding(6.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Date Reported: ${item.dateReported}",
            modifier = Modifier.padding(6.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Category: ${item.category}",
            modifier = Modifier.padding(6.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}