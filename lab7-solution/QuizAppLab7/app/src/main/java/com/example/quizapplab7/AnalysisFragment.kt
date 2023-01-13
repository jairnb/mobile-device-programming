package com.example.quizapplab7

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.quizapplab7.db.AppDatabase
import com.example.quizapplab7.db.Question
import kotlinx.coroutines.launch


class AnalysisFragment : BaseFragment() {


    private lateinit var listQuestion: List<Question>
    private lateinit var listAnswers: List<String>
    private lateinit var mapAnswer: HashMap<Int, String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_analysis, container, false)
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers
        var homeBtn = view.findViewById<Button>(R.id.home_analysis_btn)
        mapAnswer = Helper.convertStringToMap(answers)




        launch {
            context?.let {
                listQuestion = AppDatabase(it).getQuestionDAO().findAllQuestions()
                listAnswers = buildArray(listQuestion, mapAnswer)

                val listView = view.findViewById<ListView>(R.id.list_view)

                val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, listAnswers)
                listView.adapter = adapter
            }
        }

        homeBtn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }


    private fun buildArray(questions: List<Question>, answers: HashMap<Int, String>) : List<String> {
        var ret: ArrayList<String> = ArrayList<String>()

        for (q in questions) {
            var str = """
                ${q.id} - ${q.question}
                Your answer: ${answers[q.id]}
                Correct answer: ${q.correctOption}
                
            """.trimIndent()

            ret.add(str)
        }

        return ret
    }
}