package com.xoxo.xoxo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_activity)
        val btnCrear = findViewById<MaterialButton>(R.id.btnCrear)
        btnCrear.setOnClickListener {
            startActivity(Intent(this, CrearActivity::class.java))
        }
    }
}