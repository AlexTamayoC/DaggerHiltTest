package com.example.daggerhilttest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilttest.network.MinecraftItemAdapter
import com.example.daggerhilttest.R
import com.example.daggerhilttest.repository.MinecraftRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var repository: MinecraftRepository

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MinecraftItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val items = repository.getItems()
            adapter = MinecraftItemAdapter(items)
            recyclerView.adapter = adapter
        }
    }
}
