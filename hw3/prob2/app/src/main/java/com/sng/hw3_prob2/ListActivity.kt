package com.sng.hw3_prob2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {


    val items = arrayListOf("Item 1", "Item 2", "Item 3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val itemsAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        listview.adapter = itemsAdapter
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You clicked on ${items[position]}", Toast.LENGTH_LONG).show()
        }
    }
}
