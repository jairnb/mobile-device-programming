package com.example.quizapplab7

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.navigation.Navigation
import com.example.quizapplab7.db.AppDatabase
import com.example.quizapplab7.db.Question
import kotlinx.android.synthetic.main.fragment_question_one.*
import kotlinx.coroutines.launch


class QuestionOneFragment : BaseFragment() {

    private var questionNumberDisplay: Int = 1
    private var questionNumberFromList: Int = 0
    private lateinit var listQuestion: List<Question>
    private lateinit var radioGroup: RadioGroup
    private var answers: ArrayList<String> = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_question_one, container, false)
        var nextBtn = view.findViewById<Button>(R.id.next_btn)
        var homeBtn = view.findViewById<Button>(R.id.home_btn)
        radioGroup = view.findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener(this::checkChoice)
        launch {
            context?.let {
                listQuestion = AppDatabase(it).getQuestionDAO().findAllQuestions()
                changeView()
            }
        }

        nextBtn.setOnClickListener {
            if (questionNumberDisplay == 15){
                val action = QuestionOneFragmentDirections.actionQuestionOneFragmentToResultFragment(answers = answers.toTypedArray())
                Navigation.findNavController(requireView()).navigate(action)
            }else {
                questionNumberDisplay++
                questionNumberFromList++
                changeView()
            }


        }

        homeBtn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun checkChoice(group: RadioGroup, checkedId: Int){
        when (checkedId) {
            R.id.option_one_rb -> {
                answers.add(questionNumberFromList, "A")
            }
            R.id.option_two_rb -> {
                answers.add(questionNumberFromList, "B")
            }
            R.id.option_three_rb -> {
                answers.add(questionNumberFromList, "C")
            }
            R.id.option_four_rb -> {
                answers.add(questionNumberFromList, "D")
            }
            else -> {
                answers.add(questionNumberFromList, "Z")
            }
        }

    }

    private fun changeView() {
        question_tv.text = listQuestion[questionNumberFromList].question
        option_one_rb.text = listQuestion[questionNumberFromList].op1
        option_two_rb.text = listQuestion[questionNumberFromList].op2
        option_three_rb.text = listQuestion[questionNumberFromList].op3
        option_four_rb.text = listQuestion[questionNumberFromList].op4

        question_number_tv.text = "$questionNumberDisplay/15"
        radioGroup.clearCheck()
    }

}