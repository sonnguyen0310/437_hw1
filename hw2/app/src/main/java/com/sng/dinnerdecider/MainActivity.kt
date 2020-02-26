package com.sng.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var foods = arrayListOf("Hambuger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDecide.setOnClickListener {
            tvFood.text = foods.random()
        }
        btnAdd.setOnClickListener {
            foods.add(edtFood.text.toString())
            tvFood.text = edtFood.text.toString()
            edtFood.setText("")
        }
    }
}
