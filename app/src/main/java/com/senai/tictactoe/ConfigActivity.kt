package com.senai.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val voltarBtn = findViewById<ImageButton>(R.id.voltar)

        voltarBtn.setOnClickListener{
            finish()
        }
    }
}