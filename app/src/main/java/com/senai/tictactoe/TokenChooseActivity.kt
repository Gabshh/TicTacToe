package com.senai.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class TokenChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token_choose)

    val voltarBtn = findViewById<ImageButton>(R.id.voltar)
    val continuarBtn = findViewById<Button>(R.id.continuarButton)

        voltarBtn.setOnClickListener{
            finish()
        }

        continuarBtn.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

    }
}