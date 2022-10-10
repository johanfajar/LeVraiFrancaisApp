package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.github.barteksc.pdfviewer.PDFView

class VocabActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocab2)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Kedua.pdf")
            .swipeHorizontal(true)
            .load()

        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener {
            val intent = Intent (this, VocabActivity1::class.java)
            startActivity(intent)
        }

        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent (this, VocabActivity3::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}