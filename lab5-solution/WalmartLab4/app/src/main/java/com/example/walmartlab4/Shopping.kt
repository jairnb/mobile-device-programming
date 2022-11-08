package com.example.walmartlab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class Shopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val intt = intent // Similar to  Intent intent = getIntent()
        val output = intt.getStringExtra("username")

        welcome_username.text = "Welcome $output"
    }

    fun click(view: View) {
//        val intent = Intent(this, ProductListRecView::class.java)
//        startActivity(intent)
        Toast.makeText(this, "Hi there! This is a Toast.", Toast.LENGTH_LONG).show()
    }

    fun clickElectronic(view: View) {
        val intent = Intent(this, ProductListRecView::class.java)
        startActivity(intent)
    }


}