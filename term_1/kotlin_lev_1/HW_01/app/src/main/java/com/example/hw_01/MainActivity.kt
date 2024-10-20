package com.example.hw_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var fabRm: FloatingActionButton
    private val adapter = ItemAdapter()
    private val ITEM_AMT = "Value"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter

        fabAdd = findViewById(R.id.fab_add)
        fabRm = findViewById(R.id.fab_rm)

        fabAdd.setOnClickListener {
            adapter.addItem(adapter.itemCount + 1)
        }

        fabRm.setOnClickListener {
            if (adapter.itemCount > 0)
                adapter.popLast()
        }

        when(savedInstanceState)
        {
            null -> {
                adapter.setItems(listOf(1, 2, 3))
            }
            else -> {
                for (i in 1..savedInstanceState.getInt(ITEM_AMT))
                   adapter.addItem(i)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)
        outState.putInt(ITEM_AMT, adapter.itemCount)
    }
}
