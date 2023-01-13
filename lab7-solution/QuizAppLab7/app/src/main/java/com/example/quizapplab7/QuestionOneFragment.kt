package com.example.quizapplab7

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.example.quizapplab7.db.AppDatabase
import com.example.quizapplab7.db.Question
import kotlinx.android.synthetic.main.fragment_question_one.*
import kotlinx.coroutines.launch
import java.util.stream.Collectors


class QuestionOneFragment : BaseFragment() {

    private var questionNumberDisplay: Int = 1
    private var questionNumberFromList: Int = 0
    private lateinit var listQuestion: List<Question>
    private lateinit var radioGroup: RadioGroup
    private lateinit var answers: ArrayList<String>
    private var map: HashMap<Int, String?> = HashMap<Int, String?>()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        answers = ArrayList<String>()
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

                val mapAsString = map.keys.stream().map { key: Any -> key.toString() + "=" + map[key] }.collect(Collectors.joining(","))

                val action = QuestionOneFragmentDirections.actionQuestionOneFragmentToResultFragment(answers = mapAsString)

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
                map[listQuestion[questionNumberFromList].id] = listQuestion[questionNumberFromList].op1
            }
            R.id.option_two_rb -> {
                map[listQuestion[questionNumberFromList].id] = listQuestion[questionNumberFromList].op2
            }
            R.id.option_three_rb -> {
                map[listQuestion[questionNumberFromList].id] = listQuestion[questionNumberFromList].op3
            }
            R.id.option_four_rb -> {
                map[listQuestion[questionNumberFromList].id] = listQuestion[questionNumberFromList].op4
            }
            else -> {
                map[listQuestion[questionNumberFromList].id] = "Not Answered"
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