package com.example.daggerhilttest.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MinecraftDao {
    @Query("SELECT * FROM minecraft_items")
    suspend fun getAllItems(): List<MinecraftItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: MinecraftItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<MinecraftItem>)
}

