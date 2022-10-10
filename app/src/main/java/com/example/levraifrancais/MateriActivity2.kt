package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.github.barteksc.pdfviewer.PDFView

class MateriActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi2)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Materi1-2.pdf")
            .swipeHorizontal(true)
            .load()

        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent (this, MateriActivity3::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener {
            val intent = Intent (this, MateriActivity::class.java)
            startActivity(intent)
        }


    }
}