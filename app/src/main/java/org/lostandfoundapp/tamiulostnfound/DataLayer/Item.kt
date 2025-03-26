package org.lostandfoundapp.tamiulostnfound.DataLayer

import java.util.Date

data class Item(
    val name: String = "Item Name",
    val dateReported: Date = Date(),
    val dateClaimed: Date? = null,
    val category: Int = 1,
)
