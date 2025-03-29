package org.lostandfoundapp.tamiulostnfound.DataLayer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey val id: Int,
) : Item()
