package com.senai.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pvpBtn = findViewById<Button>(R.id.pvpButton)
        val pveBtn = findViewById<Button>(R.id.pveButton)
        val configBtn = findViewById<ImageButton>(R.id.configuracoes)

        pvpBtn.setOnClickListener{
            val intent = Intent(this, TokenChooseActivity::class.java)
            startActivity(intent)
        }

        pveBtn.setOnClickListener{
            val intent = Intent(this, DifficultyActivity::class.java)
            startActivity(intent)
        }

        configBtn.setOnClickListener{
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

    }
}