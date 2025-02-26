package com.example.daggerhilttest.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MinecraftItem::class], version = 3, exportSchema = false)
abstract class MinecraftDatabase : RoomDatabase() {
    abstract fun minecraftDao(): MinecraftDao
}
