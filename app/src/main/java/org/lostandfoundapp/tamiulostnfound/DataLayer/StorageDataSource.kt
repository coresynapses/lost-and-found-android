package org.lostandfoundapp.tamiulostnfound.DataLayer

data class StorageDataSource(
    var itemsList: ArrayList<Item> = ArrayList<Item>()
) {
    fun addItem() {
        itemsList.add(Item())
    }

    fun getItems() : ArrayList<Item> {
        return itemsList
    }
}