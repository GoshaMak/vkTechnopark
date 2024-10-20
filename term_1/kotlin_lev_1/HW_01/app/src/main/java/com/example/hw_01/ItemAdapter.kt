package com.example.hw_01

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter() : RecyclerView.Adapter<ItemViewHolder>()
{
    private val items = ArrayList<Int>()

    // создание объектов с вёрсткой item_view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        holder.bind(items[position])
    }

    fun setItems(list: List<Int>)
    {
        items.clear()
        for (item in list)
            addItem(item)
    }

    fun addItem(item: Int)
    {
        items.add(item)
        notifyDataSetChanged()
    }

    fun popLast()
    {
        items.removeAt(items.lastIndex)
        notifyDataSetChanged()
    }
}