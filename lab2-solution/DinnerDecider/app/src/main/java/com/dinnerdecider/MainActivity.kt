package com.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var listFood: ArrayList<String> = ArrayList<String>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listFood.add("Hamburger")
        listFood.add("Pizza")
        listFood.add("Mexican")
        listFood.add("American")
        listFood.add("Chinese")

    }

    fun decide(view : View) {
        var textListRandom: TextView = findViewById<TextView>(R.id.textView2)

        textListRandom.text = listFood[Random.nextInt(0, listFood.size)]
    }

    fun addFood(view : View) {
        var textAdd: TextView = findViewById<TextView>(R.id.editTextTextPersonName)
        var textListRandom: TextView = findViewById<TextView>(R.id.textView2)

        listFood.add(textAdd.text.toString())

        textListRandom.text = textAdd.text
        textAdd.text = ""
    }
}