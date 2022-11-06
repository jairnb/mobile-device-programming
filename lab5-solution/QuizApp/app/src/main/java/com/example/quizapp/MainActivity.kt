package com.example.quizapp

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun reset(view: View) {
        radioGroup.clearCheck()

        answer_1_q2_right.isChecked = false
        answer_2_q2.isChecked = false
        answer_3_q2_right.isChecked = false
    }

    fun submit(view: View) {


        var total: Int = 0
        var select = radioGroup.checkedRadioButtonId
        if (select != - 1){
            val radio: RadioButton = findViewById(select)
            if (radio.id == R.id.answer_3_q1_right) total += 50
        }

        if (answer_1_q2_right.isChecked) total += 25
        if (answer_3_q2_right.isChecked) total += 25

        val builder = AlertDialog.Builder(this)

        builder.setTitle("Total Point")
        builder.setMessage("Congratulations! You submitted on ${LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)}, Your achieved $total%")
        builder.setNegativeButton("Exit"){dialogInterface, which ->
            dialogInterface.dismiss() // dismiss the dialog, but activity is still alive
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}