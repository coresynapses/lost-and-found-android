package org.lostandfoundapp.tamiulostnfound.DataLayer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {
    @Query("Select * from items")
    fun getAllItems(): List<Item>

    @Insert()
    fun addItem()
}