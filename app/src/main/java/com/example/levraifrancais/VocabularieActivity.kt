package com.example.levraifrancais

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import com.github.barteksc.pdfviewer.PDFView

class VocabularieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabularie)

        val background = findViewById<PDFView>(R.id.background)

        background.fromAsset("background-video.pdf")
            .load()

        val video = findViewById<VideoView>(R.id.videoView)

        val oflineUri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        video.setVideoURI(oflineUri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)

        video.setMediaController(mediaController)



        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent (this, VocabActivity1::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }


    }
}