package com.example.quizapplab7

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplab7.db.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quiz_main_btn.setOnClickListener {
            val intent = Intent(this, QuestionsStartActivity::class.java)
            startActivity(intent)
        }

        job = Job()

        saveQuestionsOnDatabase()
    }


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun saveQuestionsOnDatabase() {
        var listQuestion = Helper.createQuestion()

        launch {
            applicationContext?.let {
                AppDatabase(it).getQuestionDAO().deleteAllQuestions()
                for (q in listQuestion){
                    AppDatabase(it).getQuestionDAO().addQuestion(q)
                }
            }
        }
    }
}