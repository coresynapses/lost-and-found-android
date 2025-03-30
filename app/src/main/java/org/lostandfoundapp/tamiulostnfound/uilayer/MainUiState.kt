package org.lostandfoundapp.tamiulostnfound.uilayer

import org.lostandfoundapp.tamiulostnfound.datalayer.Item

data class LNFUiState(var titems: List<Item>?) {
    val items: List<Item>? = titems
}
