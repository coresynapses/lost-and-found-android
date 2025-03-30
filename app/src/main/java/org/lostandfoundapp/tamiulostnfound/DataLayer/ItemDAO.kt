package org.lostandfoundapp.tamiulostnfound.DataLayer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {
    @Query("SELECT * FROM itementity")
    fun getAllItems(): List<ItemEntity>

    @Insert
    fun addItem(item: ItemEntity)
}