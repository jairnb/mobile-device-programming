package com.example.quizapplab7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class QuestionsStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_start)

//        val navController = Navigation.findNavController(this, R.id.fragmentContainerView)
//        NavigationUI.setupActionBarWithNavController(this, navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.fragmentContainerView), null)
//    }
}