package com.senai.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        val voltar = findViewById<ImageButton>(R.id.voltar)

        voltar.setOnClickListener{
            finish()
        }

    }
}