package com.sng.hw3_prob2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sng.hw3_prob2.model.ItemClick
import com.sng.hw3_prob2.model.Product
import kotlinx.android.synthetic.main.activity_rv.*

class RvActivity : AppCompatActivity(), ItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = RvAdapter(arrayListOf(Product("Tivi", 300.00, "White", R.drawable.img_tv,"123", "Tivi with 4k UHD"),
            Product("Iphone", 500.0, "Gold",R.drawable.img_iphone,"333","This Iphone have 4gb of ram and retina screen"),
            Product("PS4", 150.0, "Black", R.drawable.img_ps4, "1", "This is PS$ console for play the game" ),
            Product("Printer", 15.0, "Black", R.drawable.img_printer, "12", "This is HP printer" ),
            Product("Iphone 2", 153.0, "White", R.drawable.img_iphone, "12", "This is black iphone" )),
            this, this)
        recyclerview.adapter = adapter
    }


    class RvAdapter : RecyclerView.Adapter<VH> {
        constructor(data: ArrayList<Product>, callback: ItemClick, context: Context) : super() {
            this.data = data
            this.callback = callback
            this.context = context
        }

        var context: Context
        var data: ArrayList<Product>
        var callback: ItemClick
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val itemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)
            return VH(itemView)
        }

        override fun getItemCount(): Int {
            return data.count()
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.onBind(data[position], callback, context)
        }

    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(data: Product?, callback: ItemClick?, context: Context) {
            data?.let {
                val pro = it
                val title = itemView.findViewById<TextView>(R.id.tvTitle)
                val price = itemView.findViewById<TextView>(R.id.price)
                val color = itemView.findViewById<TextView>(R.id.color)
                val img = itemView.findViewById<ImageView>(R.id.img)
title.text = it.title
                price.text = it.price.toString()
                color.text = it.color
                img.setImageDrawable(context.resources.getDrawable(data.image))
                itemView.setOnClickListener {
                    callback?.onItemCLick(pro)
                }
            }

        }
    }

    override fun onItemCLick(data: Product) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("DATA", data);
        startActivity(i)
    }
}
