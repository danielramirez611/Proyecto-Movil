package com.xoxo.xoxo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class CrearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear)
        val btnCuenta = findViewById<MaterialButton>(R.id.btnCuenta)
        btnCuenta.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}