package com.xoxo.xoxo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.xoxo.xoxo.Inicio.InicioActivity

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_activity)

        val btnCrear = findViewById<MaterialButton>(R.id.btnCrear)
        btnCrear.setOnClickListener {
            startActivity(Intent(this, CrearActivity::class.java))


        }

        val btnPerfil = findViewById<MaterialButton>(R.id.btnPerfil)
        btnPerfil.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))


        }
    }
}