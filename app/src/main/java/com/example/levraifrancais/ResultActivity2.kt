package com.example.levraifrancais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.levraifrancais.databinding.ActivityResult2Binding


class ResultActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityResult2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result2)

        binding = ActivityResult2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.resultLabel.text = getString(R.string.result_score2, score)

        binding.btnExit.setOnClickListener {
            startActivity(Intent(this@ResultActivity2, HomeActivity::class.java))
        }

    }
}