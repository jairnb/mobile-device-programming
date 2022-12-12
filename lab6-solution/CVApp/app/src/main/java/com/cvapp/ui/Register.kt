package com.cvapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cvapp.MainActivity
import com.cvapp.R
import com.cvapp.data.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        create_account_rg_btn.setOnClickListener{
            val user = createAccount()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)

//            firstname_rg_et.text.clear()
//            lastname_rg_et.text.clear()
//            username_rg_et.text.clear()
//            password_rg_et.text.clear()

            finish()
        }
    }

    private fun createAccount() : User{
        val firstname = firstname_rg_et.text.toString()
        val lastname = lastname_rg_et.text.toString()
        val email = username_rg_et.text.toString()
        val password = password_rg_et.text.toString()

        val user = User(firstname, lastname, email, password)

        val gson = Gson()

        val userJson = gson.toJson(user)

        saveUser(userJson)

        return user
    }

    private fun saveUser(user: String){
        val spf = getSharedPreferences("user", 0)
        val edit = spf.edit()
        edit.putString("user", user)
        edit.apply()
    }
}