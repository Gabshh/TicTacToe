package com.senai.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

private val <T> Array<T>.setImageResource: Unit
    get() {}

class ConfigActivity : AppCompatActivity() {
    val profilePictureArray = arrayOf(R.drawable.ic_pfp_default, R.drawable.pfp_2, R.drawable.ic_pfp_3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val direita_seletor_p1 = findViewById<ImageButton>(R.id.direita_seletor_p1)
        val esquerda_seletor_p1 = findViewById<ImageButton>(R.id.esquerda_seletor_p1)

        val direita_seletor_p2 = findViewById<ImageButton>(R.id.direita_seletor_p2)
        val esquerda_seletor_p2 = findViewById<ImageButton>(R.id.esquerda_seletor_p2)

        var profilePictureIndex = 0

        // Player 1 Edit
        direita_seletor_p1.setOnClickListener {
            val profilePicture_p1 = findViewById<ImageView>(R.id.pfp_default_p1)

            profilePictureIndex = loopProfilePicture(profilePictureIndex + 1); // recebendo o index da proxima imagem com o loop ativado

            profilePicture_p1.setImageResource(profilePictureArray[profilePictureIndex])

        }

        esquerda_seletor_p1.setOnClickListener{
            val profilePicture_p1 = findViewById<ImageView>(R.id.pfp_default_p1)

            profilePictureIndex = loopProfilePicture(profilePictureIndex - 1); // recebendo o index da imagem anterior com o loop ativado

            profilePicture_p1.setImageResource(profilePictureArray[profilePictureIndex])
        }

        // Player 2 Edit
        direita_seletor_p2.setOnClickListener {
            val profilePicture_p2 = findViewById<ImageView>(R.id.pfp_default_p2)

            profilePictureIndex = loopProfilePicture(profilePictureIndex + 1); // recebendo o index da proxima imagem com o loop ativado

            profilePicture_p2.setImageResource(profilePictureArray[profilePictureIndex])

        }

        esquerda_seletor_p2.setOnClickListener{
            val profilePicture_p2 = findViewById<ImageView>(R.id.pfp_default_p2)

            profilePictureIndex = loopProfilePicture(profilePictureIndex - 1); // recebendo o index da imagem anterior com o loop ativado

            profilePicture_p2.setImageResource(profilePictureArray[profilePictureIndex])
        }


        val salvar = findViewById<ImageButton>(R.id.salvar_btn)
        salvar.setOnClickListener{
            val alterar_nome_p1 = findViewById<EditText>(R.id.alterar_nome_p1).text.toString()
            val player1_nome = findViewById<TextView>(R.id.player1_nome)
            val nome_p1 = alterar_nome_p1
            player1_nome.setText(nome_p1)

            val alterar_nome_p2 = findViewById<EditText>(R.id.alterar_nome_p2).text.toString()
            val player2_nome = findViewById<TextView>(R.id.player2_nome)
            val nome_p2 = alterar_nome_p2
            player2_nome.setText(nome_p2)

        }



        val voltarBtn = findViewById<ImageButton>(R.id.voltar)

        voltarBtn.setOnClickListener{
            finish()
        }

    }

    private fun loopProfilePicture(currentValue : Int): Int {
        val result : Int

        if (currentValue >= profilePictureArray.size) result = 0
        else if (currentValue <= -1) result = profilePictureArray.size-1
        else result = currentValue

        return result
    }
}