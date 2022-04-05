package com.senai.tictactoe

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

var roundCount = 0

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val botao_superior_esquerdo = findViewById<ImageButton>(R.id.up_left_button)
        val botao_superior_central  = findViewById<ImageButton>(R.id.up_center_button)
        val botao_superior_direito  = findViewById<ImageButton>(R.id.up_right_button)
        val botao_central_esquerdo  = findViewById<ImageButton>(R.id.center_left_button)
        val botao_central           = findViewById<ImageButton>(R.id.center_button)
        val botao_central_direito   = findViewById<ImageButton>(R.id.center_right_button)
        val botao_inferior_esquerdo = findViewById<ImageButton>(R.id.down_left_button)
        val botao_inferior_central  = findViewById<ImageButton>(R.id.down_center_button)
        val botao_inferior_direito  = findViewById<ImageButton>(R.id.down_right_button)


        botao_superior_esquerdo.setOnClickListener{
            if(checarRodada()){
                botao_superior_esquerdo.setImageResource(R.drawable.ic_x_icon)
            }else{
                botao_superior_esquerdo.setImageResource(R.drawable.ic_o_icon)
            }
            roundCount ++
        }

        botao_superior_direito.setOnClickListener{
            if(checarRodada()){
                botao_superior_direito.setImageResource(R.drawable.ic_x_icon)
            }else{
                botao_superior_direito.setImageResource(R.drawable.ic_o_icon)
            }
            roundCount ++
        }












        val homeBtn = findViewById<ImageButton>(R.id.homeButton)

        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }

    private fun checarRodada(): Boolean {

        return roundCount % 2 == 0
    }
}