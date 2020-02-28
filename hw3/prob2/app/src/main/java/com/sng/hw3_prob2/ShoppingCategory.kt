package com.sng.hw3_prob2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sng.hw3_prob2.model.User
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        lnBeauty.setOnClickListener {
            Toast.makeText(this, "You have chosen beauty", Toast.LENGTH_LONG).show()
        }
        lnClothing.setOnClickListener {
            Toast.makeText(this, "You have chosen Clothing", Toast.LENGTH_LONG).show()
        }
        lnElect.setOnClickListener {
            Toast.makeText(this, "You have chosen Elect", Toast.LENGTH_LONG).show()
        }
        lnFood.setOnClickListener {
            Toast.makeText(this, "You have chosen Food", Toast.LENGTH_LONG).show()
        }
        val data = intent?.let {
            if (it.hasExtra("USER")) {
                val user = it.getSerializableExtra("USER") as User
                tvUsername.text = "${getString(R.string.welcome)} ${user.first}"
            }
        }
    }
}
