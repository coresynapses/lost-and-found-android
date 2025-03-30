package org.lostandfoundapp.tamiulostnfound.DataLayer

import android.content.Context

class ItemsRepository(
    private val networkSource: NetworkDataSource = NetworkDataSource(),
    private val storageSource: StorageDataSource = StorageDataSource(),
    private val items: ArrayList<Item> = arrayListOf(
        Item(name = "Shirt", dateReported = "2/3/2022", dateClaimed = null, category = 2),
        Item(name = "Pants", dateReported = "2/3/2022", dateClaimed = "3/2/2022", category = 3),
        Item(name = "Jewel", dateReported = "2/3/2022", dateClaimed = null, category = 4),
        Item(name = "Cards", dateReported = "2/3/2022", dateClaimed = "3/3/2023", category = 5),
        Item(name = "Other", dateReported = "2/3/2022", dateClaimed = null, category = 6)
    ),
) {
    fun setup(ctx: Context) {
        // networkSource.getData()
        storageSource.setupDatabase(ctx)
    }

    fun addItem(item: Item) {
        storageSource.addItem(item)
    }

    fun getItemEntities() : List<ItemEntity> {
        return storageSource.getItems()
    }

    fun getItems() : List<Item> {
        return items
    }
}