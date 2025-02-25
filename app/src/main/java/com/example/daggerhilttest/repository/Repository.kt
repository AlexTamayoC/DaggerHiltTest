package com.example.daggerhilttest.repository

import com.example.daggerhilttest.model.MinecraftItem

interface MinecraftRepository {
    suspend fun getItems(): List<MinecraftItem>
    suspend fun insertItems(items: List<MinecraftItem>)
}


