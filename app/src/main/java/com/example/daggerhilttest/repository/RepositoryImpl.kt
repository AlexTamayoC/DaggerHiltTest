package com.example.daggerhilttest.repository

import com.example.daggerhilttest.model.MinecraftDao
import com.example.daggerhilttest.model.MinecraftItem

import javax.inject.Inject
class RepositoryImpl @Inject constructor(
    private val dao: MinecraftDao
) : MinecraftRepository {
    override suspend fun getItems(): List<MinecraftItem> {
        val items = dao.getAllItems()
        if (items.isEmpty()) {
            val defaultItems = listOf(
                MinecraftItem(name = "Pico de diamante", description = "Herramienta poderosa para minar", material = "Material necesario: diamante, palos de madera"),
                MinecraftItem(name = "Espada de hierro", description = "Arma robusta para combatir mobs", material = "Material necesario: hierro, cubos de madera"),
                MinecraftItem(name = "Bloque de piedra", description = "Material de construcción básico", material = "Material: piedra")
            )
            defaultItems.forEach { item ->
                dao.insertItem(item)
            }
            return defaultItems
        }
        return items
    }

    override suspend fun insertItems(items: List<MinecraftItem>) {
        items.forEach { item ->
            dao.insertItem(item)
        }
    }
}

