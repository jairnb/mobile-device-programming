package com.example.walmartlab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun createAccount(view: View) : Boolean {
        var firstname = firstname_et.text.toString()
        var lastname = lastname_et.text.toString()
        var password = password_et.text.toString()
        var username = username_et.text.toString()

        if (!validate(firstname, lastname, password, username)){
            Toast.makeText(this, "Fields cannot be null.", Toast.LENGTH_LONG).show()
        }
        Toast.makeText(this, "User create successfully.", Toast.LENGTH_LONG).show()

        var u1: User = User(firstname, lastname, username, password)

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", u1)
        startActivity(intent)
        return true;
    }

    private fun validate(firstname: String, lastname: String, password: String, username: String): Boolean{
        if (firstname.isBlank() || lastname.isBlank() || password.isBlank() || username.isBlank()) return false;
        return true;
    }
}