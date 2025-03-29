package org.lostandfoundapp.tamiulostnfound.UILayer

import org.lostandfoundapp.tamiulostnfound.DataLayer.Item

data class LNFUiState(var titems: List<Item>?) {
    val items: List<Item>? = titems
}
