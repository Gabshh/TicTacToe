package com.senai.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

lateinit var botao1: ImageButton
lateinit var botao2: ImageButton
lateinit var botao3: ImageButton
lateinit var botao4: ImageButton
lateinit var botao5: ImageButton
lateinit var botao6: ImageButton
lateinit var botao7: ImageButton
lateinit var botao8: ImageButton
lateinit var botao9: ImageButton

val jogadaX = R.drawable.ic_x_selected_btn
val jogadaO = R.drawable.ic_o_selected_btn

var roundCount = 0

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        botao1 = findViewById(R.id.up_left_button)
        botao2 = findViewById(R.id.up_center_button)
        botao3 = findViewById(R.id.up_right_button)
        botao4 = findViewById(R.id.center_left_button)
        botao5 = findViewById(R.id.center_button)
        botao6 = findViewById(R.id.center_right_button)
        botao7 = findViewById(R.id.down_left_button)
        botao8 = findViewById(R.id.down_center_button)
        botao9 = findViewById(R.id.down_right_button)

        botao1.setOnClickListener{
            validarJogada(botao1)
        }

        botao2.setOnClickListener{
            validarJogada(botao2)
        }

        botao3.setOnClickListener{
            validarJogada(botao3)
        }

        botao4.setOnClickListener{
            validarJogada(botao4)
        }

        botao5.setOnClickListener{
            validarJogada(botao5)
        }

        botao6.setOnClickListener{
            validarJogada(botao6)
        }

        botao7.setOnClickListener{
            validarJogada(botao7)
        }

        botao8.setOnClickListener{
            validarJogada(botao8)
        }

        botao9.setOnClickListener{
            validarJogada(botao9)
        }


        val homeBtn = findViewById<ImageButton>(R.id.homeButton)

        homeBtn.setOnClickListener{
            roundCount = 0
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun validarJogada(botao: ImageButton?) {

        val roundAviso1 = findViewById<TextView>(R.id.roundAviso1)
        val roundAviso2 = findViewById<TextView>(R.id.roundAviso2)

        if(checarRodada()){
            roundAviso1.setVisibility(View.GONE)
            roundAviso2.setVisibility(View.VISIBLE)
            if (botao != null) {
                botao.setImageResource(jogadaX)
                botao.setTag(jogadaX)
                botao.setClickable(false)
            }
        }else{
            roundAviso1.setVisibility(View.VISIBLE)
            roundAviso2.setVisibility(View.GONE)
            if (botao != null) {
                botao.setImageResource(jogadaO)
                botao.setTag(jogadaO)
                botao.setClickable(false)
            }
        }
        checarVitoria()
        roundCount ++

    }

    private fun checarVitoria() {
        //Checando vitória horizontal por X
        if( validarVitoria(botao1, botao2, botao3, jogadaX) ||
            validarVitoria(botao4, botao5, botao6, jogadaX) ||
            validarVitoria(botao7, botao8, botao9, jogadaX)   ){
            mensagemGameOver()

        }//Checando vitória vertical por X
        else if( validarVitoria(botao1, botao4, botao7, jogadaX) ||
                 validarVitoria(botao2, botao5, botao8, jogadaX) ||
                 validarVitoria(botao3, botao6, botao9, jogadaX)   ) {
                 mensagemGameOver()

        }//Checando vitória diagonal por X
        else if( validarVitoria(botao1, botao5, botao9, jogadaX) ||
                 validarVitoria(botao3, botao5, botao7, jogadaX) ) {
                 mensagemGameOver()
        }

        //Checando vitória horizontal por O
        else if( validarVitoria(botao1, botao2, botao3, jogadaO) ||
                 validarVitoria(botao4, botao5, botao6, jogadaO) ||
                 validarVitoria(botao7, botao8, botao9, jogadaO)   ){
                 mensagemGameOver()

        }//Checando vitória vertical por O
        else if( validarVitoria(botao1, botao4, botao7, jogadaO) ||
                 validarVitoria(botao2, botao5, botao8, jogadaO) ||
                 validarVitoria(botao3, botao6, botao9, jogadaO)   ) {
                 mensagemGameOver()

        }//Checando vitória diagonal por O
        else if( validarVitoria(botao1, botao5, botao9, jogadaO) ||
                 validarVitoria(botao3, botao5, botao7, jogadaO) ) {
                 mensagemGameOver()
        } //Checando empate
        else if(!botao1.isClickable && !botao2.isClickable && !botao3.isClickable &&
                !botao4.isClickable && !botao5.isClickable && !botao6.isClickable &&
                !botao7.isClickable && !botao8.isClickable && !botao9.isClickable){
                mensagemGameOver()
        }
    }


    private fun validarVitoria(botao1: ImageButton, botao2: ImageButton, botao3: ImageButton, jogada: Int): Boolean {
        return botao1.getTag() == jogada && botao2.getTag() == jogada && botao3.getTag() == jogada
    }

    private fun mensagemGameOver() {

        Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()

//        AlertDialog.
//        Builder(this)
//            .setTitle("Atenção!!!")
//            .setMessage("Deseja sair do app?")
//            .setPositiveButton("Sim") {dialog,which -> finish()}
//            .setNegativeButton("Cancelar") {dialog,which ->}
//            .create()
//            .show()
    }

    private fun checarRodada(): Boolean {
        return roundCount % 2 == 0
    }
}