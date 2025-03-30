package org.lostandfoundapp.tamiulostnfound.DataLayer

import androidx.annotation.DrawableRes

class Item(
    val dateReported: String = "",
    val dateClaimed: String? = null,
    val name: String = "Item Name",
    val category: Int = 1,
    @DrawableRes val resource: Int = 0
)
