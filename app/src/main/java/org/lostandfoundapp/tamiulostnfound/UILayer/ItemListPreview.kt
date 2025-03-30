package org.lostandfoundapp.tamiulostnfound.UILayer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.lostandfoundapp.tamiulostnfound.DataLayer.ItemsRepository
import org.lostandfoundapp.tamiulostnfound.ui.theme.TAMIULostNFoundTheme


@Preview(showBackground = false)
@Composable
fun ItemPreview() {
    val itemsRepo = ItemsRepository()

    TAMIULostNFoundTheme {
        ItemsList(itemsRepo.getItems())
    }
}