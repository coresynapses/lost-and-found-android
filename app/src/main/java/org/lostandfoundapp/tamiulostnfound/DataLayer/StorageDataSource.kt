package org.lostandfoundapp.tamiulostnfound.DataLayer

import androidx.room.Room
import android.content.Context

data class StorageDataSource(
    var itemsList: ArrayList<Item> = ArrayList<Item>(),
    var db: ItemDatabase? = null,
) {
    fun setupDatabase(ctx: Context) {
//        db = Room.databaseBuilder(ctx, ItemDatabase::class.java, "items-db").build()
    }

    fun addItem() {
        itemsList.add(Item())
    }

    fun getItems() : ArrayList<Item> {
        return itemsList
    }
}