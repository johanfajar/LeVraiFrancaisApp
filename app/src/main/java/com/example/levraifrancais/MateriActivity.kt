package com.example.levraifrancais

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.github.barteksc.pdfviewer.PDFView
import java.io.IOException

class MateriActivity : AppCompatActivity() {

    var mediaPlayer : MediaPlayer? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

//        val btnPlay = findViewById<Button>(R.id.buttonSound)
//        val btnStop = findViewById<Button>(R.id.buttonStop)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Materi1-1.pdf")
            .swipeHorizontal(true)
            .load()

        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent (this, MateriActivity2::class.java)
            startActivity(intent)
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

//        btnPlay.setOnClickListener {
//            playAudio()
//        }
//
//        btnStop.setOnClickListener {
//            stopAudio()
//        }


    }

    private fun stopAudio() {
        if (mediaPlayer!!.isPlaying){
            mediaPlayer!!.stop()

        } else {
            Toast.makeText(this, "Audio has not played", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun playAudio(){
        val audioUrl = "https://vocaroo.com/embed/16JQoIvZUGFB?autoplay=0"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {

            val afd = applicationContext.assets.openFd("VOCABULAIRE.mp3")
            mediaPlayer!!.setDataSource(afd)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()

        } catch (e: IOException){
            e.printStackTrace()
        }

        Toast.makeText(this, "Audio Started Playing", Toast.LENGTH_SHORT).show()
    }

}