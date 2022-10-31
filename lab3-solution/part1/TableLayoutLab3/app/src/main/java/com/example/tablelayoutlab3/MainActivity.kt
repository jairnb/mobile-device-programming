package com.example.tablelayoutlab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultData()

    }

    private fun defaultData(): Unit {
        val tableRow = TableRow(applicationContext)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams.column = 2
        tableRow.setPadding(20)


        val newText = TextView(this)
        newText.textSize = 18F

        val newText2 = TextView(this)
        newText2.textSize = 18F

        newText.text = "Version 1"
        newText2.text = "Code Name 1"


        tableRow.addView(newText, 0)
        tableRow.addView(newText2, 1)

        main_table.addView(tableRow)


        val tableRow2 = TableRow(applicationContext)
        val layoutParams2 = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams2.column = 2
        tableRow2.setPadding(20)

        val newText1 = TextView(this)
        newText1.textSize = 18F

        val newText21 = TextView(this)
        newText21.textSize = 18F

        newText1.text = "Version 2"
        newText21.text = "Code Name 2"


        tableRow2.addView(newText1, 0)
        tableRow2.addView(newText21, 1)

        main_table.addView(tableRow2)
    }

    fun add(view: View) {
        val tableRow2 = TableRow(applicationContext)
        val layoutParams2 = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams2.column = 2
        tableRow2.setPadding(20)

        val newText1 = TextView(this)
        newText1.textSize = 18F

        val newText21 = TextView(this)
        newText21.textSize = 18F

        newText1.text = android_version.text
        newText21.text = code_name.text


        android_version.text.clear()
        code_name.text.clear()

        tableRow2.addView(newText1, 0)
        tableRow2.addView(newText21, 1)

        main_table.addView(tableRow2)
    }
}