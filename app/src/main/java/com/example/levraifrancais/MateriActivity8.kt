package com.example.levraifrancais

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.github.barteksc.pdfviewer.PDFView
import java.io.IOException

class MateriActivity8 : AppCompatActivity() {

    var mediaPlayer : MediaPlayer? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi8)

        val btnPlay = findViewById<ImageButton>(R.id.buttonSound)
        val btnStop = findViewById<ImageButton>(R.id.buttonStop)
        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Materi5.pdf")
            .swipeHorizontal(true)
            .load()

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener {
            val intent = Intent (this, MateriActivity7::class.java)
            startActivity(intent)
        }

        btnPlay.setOnClickListener {
            playAudio()
        }

        btnStop.setOnClickListener {
            stopAudio()
        }

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