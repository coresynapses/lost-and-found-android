package org.lostandfoundapp.tamiulostnfound.datalayer

import android.content.Context
import org.lostandfoundapp.tamiulostnfound.R

class ItemsRepository(
    private val networkSource: NetworkDataSource = NetworkDataSource(),
    private val storageSource: StorageDataSource = StorageDataSource(),
    private val items: ArrayList<Item> = arrayListOf(
        Item(name = "Shirt", dateReported = "2/3/2022", dateClaimed = null, category = 1, resource = R.drawable.shirt),
        Item(name = "Pants", dateReported = "2/3/2022", dateClaimed = "3/2/2022", category = 1, resource = R.drawable.pants),
        Item(name = "Jewel", dateReported = "2/3/2022", dateClaimed = null, category = 3, resource = R.drawable.jewel),
        Item(name = "Cards", dateReported = "2/3/2022", dateClaimed = "3/3/2023", category = 0, resource = R.drawable.cards),
        Item(name = "Other", dateReported = "2/3/2022", dateClaimed = null, category = 0, resource = R.drawable.other)
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