package org.lostandfoundapp.tamiulostnfound.datalayer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey val id: Int,
    var name: String = "Item Name",
    var dateReported: String = "",
    var dateClaimed: String? = null,
    var category: Int = 1,
) {
    constructor(item: Item) : this(
        id = 0,
        name = item.name,
        dateReported = item.dateReported,
        dateClaimed = item.dateClaimed,
        category = item.category)
}
