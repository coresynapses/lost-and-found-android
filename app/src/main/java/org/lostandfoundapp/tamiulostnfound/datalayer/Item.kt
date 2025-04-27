package org.lostandfoundapp.tamiulostnfound.datalayer

import androidx.annotation.DrawableRes

class Item(
    val name: String = "Item Name",
    val dateReported: String = "",
    var dateClaimed: String? = null,
    val category: Int = 1,
    @DrawableRes val resource: Int = 0
)
