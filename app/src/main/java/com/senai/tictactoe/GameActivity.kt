package com.senai.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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

lateinit var jogadaBtn1: Any
lateinit var jogadaBtn2: Any
lateinit var jogadaBtn3: Any
lateinit var jogadaBtn4: Any
lateinit var jogadaBtn5: Any
lateinit var jogadaBtn6: Any
lateinit var jogadaBtn7: Any
lateinit var jogadaBtn8: Any
lateinit var jogadaBtn9: Any

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
            jogadaBtn1 = botao1.getTag()
        }

        botao2.setOnClickListener{
            validarJogada(botao2)
            jogadaBtn2 = botao2.getTag()
        }

        botao3.setOnClickListener{
            validarJogada(botao3)
            jogadaBtn3 = botao3.getTag()
        }

        botao4.setOnClickListener{
            validarJogada(botao4)
            jogadaBtn4 = botao4.getTag()
        }

        botao5.setOnClickListener{
            validarJogada(botao5)
            jogadaBtn5 = botao5.getTag()
        }

        botao6.setOnClickListener{
            validarJogada(botao6)
            jogadaBtn6 = botao6.getTag()
        }

        botao7.setOnClickListener{
            validarJogada(botao7)
            jogadaBtn7 = botao7.getTag()
        }

        botao8.setOnClickListener{validarJogada(botao8)
            jogadaBtn8 = botao8.getTag()
        }

        botao9.setOnClickListener{
            validarJogada(botao9)
            jogadaBtn9 = botao9.getTag()
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
                botao.setImageResource(R.drawable.ic_x_selected_btn)
                botao.setTag(R.drawable.ic_x_selected_btn)
                botao.setClickable(false)
            }
        }else{
            roundAviso1.setVisibility(View.VISIBLE)
            roundAviso2.setVisibility(View.GONE)
            if (botao != null) {
                botao.setImageResource(R.drawable.ic_o_selected_btn)
                botao.setTag(R.drawable.ic_o_selected_btn)
                botao.setClickable(false)
            }
        }
        checarVitoria()
        roundCount ++

    }

    private fun checarVitoria() {
        if( jogadaBtn1 == R.drawable.ic_x_selected_btn && jogadaBtn2 == R.drawable.ic_x_selected_btn && jogadaBtn3 == R.drawable.ic_x_selected_btn ){
            abrirMenuGameOver()
        }
    }

    private fun abrirMenuGameOver() {
        AlertDialog.
        Builder(this)
            .setTitle("Atenção!!!")
            .setMessage("Deseja sair do app?")
            .setPositiveButton("Sim") {_,_ -> finish()}
            .setNegativeButton("Cancelar") {_,_ ->}
            .show()
    }

    private fun checarRodada(): Boolean {
        return roundCount % 2 == 0
    }
}