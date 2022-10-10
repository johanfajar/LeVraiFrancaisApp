package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.github.barteksc.pdfviewer.PDFView

class DafpusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dafpus)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("DaftarPustakaBenar.pdf")
            .load()

        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }


    }
}