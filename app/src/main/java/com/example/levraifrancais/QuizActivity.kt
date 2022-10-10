package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

import com.example.levraifrancais.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val quizLimit = 10

    private val quizData = mutableListOf(
        //multiple choice answer
        mutableListOf("\tLes grands-parents paternels de Lucie sont Lucio et Sarah.","\tVRAI","\tFAUX"),
        mutableListOf("\tLucie a une petite famille.","\tFAUX","\tVRAI"),
        mutableListOf("\tLucie et sa famille habitent à Paris.","\tFAUX","\tVRAI"),
        mutableListOf("\tVilma est la tante de Lucie.","\tVRAI","\tFAUX"),
        mutableListOf("\tCristian est le frère de Romulus.","\tVRAI","\tFAUX"),
        mutableListOf("\tVictor et Vilma sont les parents de Lucie.","\tFAUX","\tVRAI"),
        mutableListOf("\tMichaela est la plus petite.","\tVRAI","\tFAUX"),
        mutableListOf("\tCristian et Romulus sont les cousins de Lucie.","\tFAUX","\tVRAI"),
        mutableListOf("\tLes grands-mères maternelles de Lucie sont Romain et Sarah.","\tFAUX","\tVRAI"),
        mutableListOf("\tLucie a neuf ans.","\tFAUX","\tVRAI")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quiz)


        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        quizData.shuffle()

        showNextQuiz()

    }

    private fun showNextQuiz() {
        binding.countLabel.text = getString(R.string.count, quizCount)

        val quiz = quizData[0]

        binding.questionLabel.text = quiz [0]
        rightAnswer = quiz[1]

        quiz.removeAt(0)

        quiz.shuffle()

        binding.answerBtn1.text = quiz [0]
        binding.answerBtn2.text = quiz [1]


        quizData.removeAt(0)
    }

    fun checkAnswer(view: View){
        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        val alertTitle: String
        if (btnText ==rightAnswer){
            alertTitle = "Vrai (Benar)"
            rightAnswerCount++
        } else {
            alertTitle = "Faux (Salah)"
        }

        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("Réponse: $rightAnswer")
            .setPositiveButton("OK") {dialogInterface, i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()
    }

    fun checkQuizCount(){
        if (quizCount == quizLimit) {

            val intent = Intent(this@QuizActivity, ResultActivity2::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)
        } else {
            quizCount++
            showNextQuiz()
        }
    }
}