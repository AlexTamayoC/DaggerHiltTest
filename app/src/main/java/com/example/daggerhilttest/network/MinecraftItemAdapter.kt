package com.example.daggerhilttest.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilttest.R
import com.example.daggerhilttest.model.MinecraftItem

class MinecraftItemAdapter(private val items: List<MinecraftItem>) :
    RecyclerView.Adapter<MinecraftItemAdapter.MinecraftViewHolder>() {

    inner class MinecraftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.itemName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.itemDescription)
        val materialTextView: TextView = itemView.findViewById(R.id.itemMaterial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinecraftViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_minecraft, parent, false)
        return MinecraftViewHolder(view)
    }

    override fun onBindViewHolder(holder: MinecraftViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.descriptionTextView.text = item.description
        holder.materialTextView.text = item.material
    }

    override fun getItemCount(): Int = items.size
}
