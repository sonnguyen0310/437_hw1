package com.sng.hw3_prob2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sng.hw3_prob2.model.Product
import com.sng.hw3_prob2.model.User
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_shopping_category.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent?.let {
            if (it.hasExtra("DATA")) {
                val product = it.getSerializableExtra("DATA") as Product
                tvTitle.text = product.title
                price.text = product.price.toString()
                description.text = product.description
                color.text = product.color
                imgBanner.setImageDrawable(this.resources.getDrawable(product.image))
            }
        }
    }
}
