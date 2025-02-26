package com.example.daggerhilttest.repository

import android.content.Context
import androidx.room.Room
import com.example.daggerhilttest.model.MinecraftDao
import com.example.daggerhilttest.model.MinecraftDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MinecraftDatabase {
        return Room.databaseBuilder(
            context,
            MinecraftDatabase::class.java,
            "minecraft_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: MinecraftDatabase): MinecraftDao = database.minecraftDao()

    @Singleton
    @Provides
    fun provideRepository(dao: MinecraftDao): MinecraftRepository = RepositoryImpl(dao)
}
