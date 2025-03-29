package org.lostandfoundapp.tamiulostnfound.DataLayer

import android.content.Context

class ItemsRepository(
    private val networkSource: NetworkDataSource = NetworkDataSource(),
    private val storageSource: StorageDataSource = StorageDataSource()
) {
    fun setup(ctx: Context) {
        networkSource.getData()
        storageSource.setupDatabase(ctx)
    }

    fun addItem() {
        storageSource.addItem()
    }

    fun getItems() : ArrayList<Item> {
        return storageSource.getItems()
    }
}
