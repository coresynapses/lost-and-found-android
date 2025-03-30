package org.lostandfoundapp.tamiulostnfound.UiLayer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.lostandfoundapp.tamiulostnfound.DataLayer.ItemsRepository


@Preview(showBackground = false)
@Composable
fun ItemPreview() {
    val itemsRepo = ItemsRepository()

    TAMIULostNFoundTheme {
        ItemEntry(itemsRepo.getItems()[1])
    }
}