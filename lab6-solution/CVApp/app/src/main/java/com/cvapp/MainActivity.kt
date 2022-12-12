package com.cvapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cvapp.adpter.MainViewAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainViewAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter

        TabLayoutMediator(tlayaout,viewpager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
//                    tab.setIcon(R.drawable.ic_baseline_home_24)
                }
                1->{
                    tab.text="About Me"
//                    tab.setIcon(R.drawable.work)
                }
                2->{
                    tab.text="Work"
//                    tab.setIcon(R.drawable.contact)
                }
                3->{
                    tab.text = "Contact"
//                    tab.setIcon(R.drawable.help)
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.linkedin -> {
                Toast.makeText(applicationContext, "Linkedin", Toast.LENGTH_LONG).show()
                true
            }
            R.id.telegram -> {
                Toast.makeText(applicationContext, "Telegram", Toast.LENGTH_LONG).show()
                true
            }
            R.id.gmail -> {
                Toast.makeText(applicationContext, "Gmail", Toast.LENGTH_LONG).show()
                true
            }
            R.id.whatsapp -> {
                Toast.makeText(applicationContext, "WhatsApp", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}