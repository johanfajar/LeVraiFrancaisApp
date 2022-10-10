package com.example.levraifrancais

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class Exercice3 : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercice3)

//        supportActionBar?.hide()
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        webView = findViewById(R.id.wv)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.liveworksheets.com/lf1312521rl")


        // disable scroll on touch
        // disable scroll on touch
        webView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                return event.action == MotionEvent.ACTION_MOVE
            }
        })

        val webSettings = webView.settings

        webSettings.javaScriptEnabled = true

        webSettings.domStorageEnabled = true

        webSettings.builtInZoomControls = true

        webSettings.useWideViewPort = true

        webSettings.loadWithOverviewMode = true
    }
}