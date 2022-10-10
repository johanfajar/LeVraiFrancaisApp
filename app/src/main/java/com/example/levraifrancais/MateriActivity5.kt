package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.github.barteksc.pdfviewer.PDFView

class MateriActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi5)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Materi3-1.pdf")
            .swipeHorizontal(true)
            .load()

        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent (this, MateriActivity6::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener {
            val intent = Intent (this, MateriActivity4::class.java)
            startActivity(intent)
        }

    }
}