package com.sng.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener {
            addNew()
        }
    }

    fun addNew() {
        val tableRow = TableRow(applicationContext)
        val layoutParams = TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT)
        tableRow.layoutParams = layoutParams

        val childParams = TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT,1f)
        val tv = TextView(applicationContext)
        tv.layoutParams = childParams
        tv.text = edtVersion.text.toString()
        tableRow.addView(tv,0)

        val tvCode = TextView(applicationContext)
        tvCode.layoutParams = childParams
        tvCode.text = edtCode.text.toString()
        tableRow.addView(tvCode,1)

        table.addView(tableRow)
    }
}
