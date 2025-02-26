package com.example.daggerhilttest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "minecraft_items")
data class MinecraftItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val material: String
)


