package com.senai.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

private val <T> Array<T>.setImageResource: Unit
    get() {}

class ConfigActivity : AppCompatActivity() {
    val profilePictureArray = arrayOf(R.drawable.ic_pfpdefault, R.drawable.ic_pfp2, R.drawable.ic_pfpcake)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val direita_seletor = findViewById<ImageButton>(R.id.direita_seletor)
        val esquerda_seletor = findViewById<ImageButton>(R.id.esquerda_seletor)

        var profilePictureIndex = 0

        direita_seletor.setOnClickListener {
            val profilePicture = findViewById<ImageView>(R.id.pfp_default)

            profilePictureIndex = loopProfilePicture(profilePictureIndex + 1); // recebendo o index da proxima imagem com o loop ativado

            profilePicture.setImageResource(profilePictureArray[profilePictureIndex])

        }

        esquerda_seletor.setOnClickListener{
            val profilePicture = findViewById<ImageView>(R.id.pfp_default)

            profilePictureIndex = loopProfilePicture(profilePictureIndex - 1); // recebendo o index da imagem anterior com o loop ativado

            profilePicture.setImageResource(profilePictureArray[profilePictureIndex])
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