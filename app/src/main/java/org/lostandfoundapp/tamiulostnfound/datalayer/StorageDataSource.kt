package org.lostandfoundapp.tamiulostnfound.datalayer

import androidx.room.Room
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


data class StorageDataSource(
    var itemsList: List<ItemEntity> = ArrayList<ItemEntity>(),
    var db: ItemDatabase? = null,
) {
    fun setupDatabase(ctx: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            db = Room.databaseBuilder(ctx.applicationContext, ItemDatabase::class.java, "items-db")
                .build()
        }
    }

    fun addItem(item: Item) {
        CoroutineScope(Dispatchers.IO).launch {
            db!!.itemDao().addItem(ItemEntity(item))
        }
    }

    fun getItems() : List<ItemEntity> {
        CoroutineScope(Dispatchers.IO).launch {
            itemsList = db!!.itemDao().getAllItems()
        }
        return itemsList
    }
}