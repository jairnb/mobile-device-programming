package com.example.quizapplab7

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.quizapplab7.db.AppDatabase
import com.example.quizapplab7.db.Question
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.coroutines.launch


class ResultFragment : BaseFragment() {
    private lateinit var listQuestion: List<Question>
    private lateinit var mapAnswer: HashMap<Int, String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        var tryAgainBtn = view.findViewById<Button>(R.id.try_again_btn)
        var resultAnalysisBtn = view.findViewById<Button>(R.id.result_analysis_btn)
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers

        mapAnswer = Helper.convertStringToMap(answers)

        launch {
            context?.let {
                listQuestion = AppDatabase(it).getQuestionDAO().findAllQuestions()
                total_question_tv.text = "Total Questions: ${listQuestion.size}"
                var totalRight = calculate(mapAnswer)
                correct_answer_tv.text = "Correct Answers Score: $totalRight"
                wrong_answer_tv.text = "Wrong answers: ${listQuestion.size - totalRight}"
                score_tv.text = "Your score is: $totalRight/${listQuestion.size}"
            }
        }

        tryAgainBtn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        resultAnalysisBtn.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToAnalysisFragment(answers = answers)

            Navigation.findNavController(requireView()).navigate(action)
        }
        return view
    }

    private fun calculate(answer:  HashMap<Int, String>): Int{
        var count: Int = 0

        for (q in listQuestion){
            if (q.id in answer){
                if (q.correctOption.equals(answer[q.id])){
                    count++
                }
            }
        }
        return count
    }


}