package org.lostandfoundapp.tamiulostnfound.uilayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.lostandfoundapp.tamiulostnfound.datalayer.Item


class LNFViewModel : ViewModel() {
    private var items : List<Item> = listOf()

    var uiState: LNFUiState by mutableStateOf(LNFUiState(items))
        private set
}