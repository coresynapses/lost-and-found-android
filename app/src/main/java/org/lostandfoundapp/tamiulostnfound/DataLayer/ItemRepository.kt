package org.lostandfoundapp.tamiulostnfound.DataLayer

class ItemsRepository(
    private val networkSource: NetworkDataSource = NetworkDataSource(),
    private val storageSource: StorageDataSource = StorageDataSource()
) {
    fun addItem() {
        storageSource.addItem()
    }

    fun getItems() : ArrayList<Item> {
        return storageSource.getItems()
    }
}
