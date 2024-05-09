package com.xoxo.xoxo

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ComprarActivity : AppCompatActivity() {
    private lateinit var numero: EditText
    private lateinit var btnSuma: ImageButton
    private lateinit var btnResta: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comprar)
        val arrowIcon = findViewById<ImageView>(R.id.arrowIcon)
        arrowIcon.setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))


        }
        numero = findViewById(R.id.numero)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)

        btnSuma.setOnClickListener {
            incrementarNumero()
        }

        btnResta.setOnClickListener {
            decrementarNumero()
        }
        val textView = findViewById<TextView>(R.id.descuento) // Suponiendo que el TextView se llama textView
        textView.text = "S/15"
        textView.setTextColor(Color.parseColor("#9B9B9B"))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        textView.setTypeface(null, Typeface.BOLD)
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
    private fun incrementarNumero() {
        var num = numero.text.toString().toInt()
        num++
        numero.setText(num.toString())
    }

    private fun decrementarNumero() {
        var num = numero.text.toString().toInt()
        if (num > 1) {
            num--
            numero.setText(num.toString())
        }
    }
}