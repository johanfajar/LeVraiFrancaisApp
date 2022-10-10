package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.barteksc.pdfviewer.PDFView

class Exercice2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_execice2)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("EXERCICE-2.pdf")
            .swipeHorizontal(true)
            .load()

        val buttonQuiz = findViewById<Button>(R.id.buttonQuiz)
        buttonQuiz.setOnClickListener {
            val intent = Intent (this, QuizActivity::class.java)
            startActivity(intent)
        }

    }
}