package com.example.walmartlab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userList: ArrayList<User> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList.add(User("John", "Doe", "john@doe.com", "password"))
        userList.add(User("Jane", "Doe", "jane@doe.com", "password"))
        userList.add(User("Elon", "Musk", "elon@musk.com", "password"))
        userList.add(User("Peter", "Park", "peter@park.com", "password"))
        userList.add(User("Bruce", "Wayne", "bruce@wayne.com", "password"))


    }

    fun login(view: View) {
        var username = username_et.text.toString()
        var password = password_et.text.toString()

        var res = userList.lastOrNull { u -> u.username.equals(username) && u.password.equals(password) };

        if (res != null){
            val intent = Intent(this, Shopping::class.java)
            intent.putExtra("username", res.username)
            startActivity(intent)
        }else {
            Toast.makeText(this, "Invalid Credentials.", Toast.LENGTH_LONG).show()
        }
    }
}