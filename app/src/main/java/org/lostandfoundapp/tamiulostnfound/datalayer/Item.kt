package org.lostandfoundapp.tamiulostnfound.datalayer

import androidx.annotation.DrawableRes

class Item(
    val dateReported: String = "",
    val dateClaimed: String? = null,
    val name: String = "Item Name",
    val category: Int = 1,
    @DrawableRes val resource: Int = 0
)
