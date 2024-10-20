package com.example.hw_01

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// view - ячейка списка
class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    private val text = view.findViewById<TextView>(R.id.text_view)
    private val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int)
    {
        text.text = "$number"
        if (number % 2 == 0) setBgColor(Color.RED) else setBgColor(Color.BLUE)
    }

    private fun setBgColor(color: Int)
    {
        image.setBackgroundColor(color)
    }
}