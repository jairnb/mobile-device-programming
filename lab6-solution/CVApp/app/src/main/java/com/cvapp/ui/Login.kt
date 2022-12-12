package com.cvapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cvapp.MainActivity
import com.cvapp.R
import com.cvapp.data.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        signup_btn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {

            val usernameEt = username_lg_et.text.toString()
            val passwordEt = password_lg_et.text.toString()

            val gson = Gson()
            val spf = getSharedPreferences("user", 0)
            val res = spf.getString("user", "")

            val user = gson.fromJson(res, User::class.java)

            if (user.username == usernameEt && user.password == passwordEt){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)

//                password_lg_et.text.clear()
//                username_lg_et.text.clear()
                finish()
            }else {
                Toast.makeText(applicationContext, "Credentials not matching", Toast.LENGTH_LONG).show()
            }

        }
    }
}