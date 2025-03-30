package org.lostandfoundapp.tamiulostnfound.DataLayer

import java.util.Date

class Item(
    val dateReported: String = "",
    val dateClaimed: String? = null,
    val name: String = "Item Name",
    val category: Int = 1,
)
