package com.senai.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pvp = findViewById<Button>(R.id.pvpButton)

        pvp.setOnClickListener{
            val intent = Intent(this, TokenChooseActivity::class.java)
            startActivity(intent)
        }

    }
}