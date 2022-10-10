package com.example.levraifrancais

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.levraifrancais.databinding.ActivityExercice1Binding





class Exercice1 : AppCompatActivity() {

    private lateinit var binding: ActivityExercice1Binding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val quizLimit = 20

    private val quizData = mutableListOf(
        //multiple choice answer
        mutableListOf("Juliet et moi allons à piscine.","\tNous","\tVous","\tElles"),
        mutableListOf("Toi et tante partez à la pêche.","\tIls","\tNous","\tElles"),
        mutableListOf("Ma mère est endormie.","\tElle","\tNous","\tElles"),
        mutableListOf("\tC’est Julie. Elle _____ français.","\test","\tsuis","\tsont"),
        mutableListOf("\tMartin (Il) ____ un stylo.","\ta","\tas","\tsuis"),
        mutableListOf("\tLes enfants ______ a content.","\tsommes","\tsuis","\tsont"),
        mutableListOf("\tJe _____ professeur.","\tsuis","\tas","\test"),
        mutableListOf("\tVoici ___________ téléphone (m). C'est _______ téléphone de Valérie.","\tUn - le","\tUne - la","\tDes - les"),
        mutableListOf("\tVoici ________ enfants (m). Ce sont _______ enfants de Madame Marion. ","\tDes - les","\tUn - le","\tUne - la"),
        mutableListOf("\tVoici _____ institut (m). C'est _____ institut de Nice.","\tUn - l'","\tUne - la","\tDes - les"),
        mutableListOf("\t____(Tu) grands-parents s’appellent Antonine et Marie.","\tTes","\tTon","\tTa"),
        mutableListOf("\tTheo a une sœur. ____ (Il) sœur s’appelle Sarah.","\tSa","\tSon","\tTon"),
        mutableListOf("\tJ’ai trois enfants. _____ (Je) enfants s’appellent Theo, Sarah et Arthur.","\tMes","\tMa","\tMon"),
        mutableListOf("\tComment s’appelle la mère de Theo?","\tCaroline","\tSarah","\tVéronique"),
        mutableListOf("\tComment s’appelle le grand père d’Arthur?","\tAntonie","\tMarc","\tArthur"),
        mutableListOf("\tQui est Denis?","\tLe père de Theo","\tL’oncle de Theo","\tLe frère de Sarah"),
        mutableListOf("\tQui est sa tante de Sarah ?","\tVéronique","\tClaudine","\tLéa"),
        mutableListOf("\tComment s’appelle la nièce Véronique ?","\tSarah","\tMarie","\tLéa"),
        mutableListOf("\tQui est la fille de Louise ?","\tLea","\tClaudine","\tArthur"),
        mutableListOf("\tQui est Jacques ?","\tLe grand-père de Léa","\tLe père de Caroline","\tLe fils d’Antoine"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_exercice1)

        binding = ActivityExercice1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        quizData.shuffle()

        showNextQuiz()
    }

    fun showNextQuiz() {

        binding.countLabel.text = getString(R.string.count_label, quizCount)

        val quiz = quizData[0]

        val mBold = StyleSpan(Typeface.BOLD_ITALIC)

        if (quiz[0].equals("Juliet et moi allons à piscine.")){

            val mBSpannableString = SpannableString("Juliet et moi allons à piscine.")

            val mUnderlineSpan = UnderlineSpan()


            mBSpannableString.setSpan(mUnderlineSpan, 0, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


            binding.questionLabel.text = mBSpannableString
        } else if (quiz[0].equals("Toi et tante partez à la pêche.")){

            val mBSpannableString = SpannableString("Toi et tante partez à la pêche.")

            val mUnderlineSpan = UnderlineSpan()


            mBSpannableString.setSpan(mUnderlineSpan, 0, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


            binding.questionLabel.text = mBSpannableString
        } else if (quiz[0].equals("Ma mère est endormie.")) {
            val mBSpannableString = SpannableString("Ma mère est endormie.")

            val mUnderlineSpan = UnderlineSpan()


            mBSpannableString.setSpan(mUnderlineSpan, 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


            binding.questionLabel.text = mBSpannableString
        } else {
            binding.questionLabel.text = quiz[0]
            binding.questionLabel.setTypeface(null,Typeface.NORMAL)
        }
        rightAnswer = quiz[1]

        quiz.removeAt(0)

        quiz.shuffle()

        binding.answerBtn1.text = quiz [0]
        binding.answerBtn2.text = quiz [1]
        binding.answerBtn3.text = quiz [2]

        quizData.removeAt(0)

    }

    fun checkAnswer(view: View){
        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        val alertTitle: String
        if (btnText == rightAnswer){
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

            val intent = Intent(this@Exercice1, ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)
        } else {
            quizCount++
            showNextQuiz()
        }
    }
}