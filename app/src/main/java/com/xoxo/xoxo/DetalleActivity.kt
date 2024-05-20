package com.xoxo.xoxo

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageButton
import com.bumptech.glide.Glide
import com.xoxo.xoxo.Inicio.InicioActivity

class DetalleActivity : AppCompatActivity() {
    private lateinit var numero: EditText
    private lateinit var btnSuma: ImageButton
    private lateinit var btnResta: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)


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

        val intent = intent

        val coleccion = intent.getStringExtra("coleccion")
        val producto = intent.getStringExtra("producto")
        val precio = intent.getStringExtra("precio")
        val descuento = intent.getStringExtra("descuento")
        val imageUrl = intent.getStringExtra("imageUrl")

        val txtColeccion = findViewById<TextView>(R.id.txtColeccion)
        val txtProducto = findViewById<TextView>(R.id.txtProducto)
        val txtPrecio = findViewById<TextView>(R.id.textprecio)
        val txtDescuento = findViewById<TextView>(R.id.descuento)
        val imageView = findViewById<ImageView>(R.id.imageView)

        txtColeccion.text = coleccion
        txtProducto.text = producto
        txtPrecio.text = precio
        txtDescuento.text = descuento

        Glide.with(this).load(imageUrl).into(imageView)
        imageView.tag = imageUrl

        // Configurar las propiedades del TextView de descuento
        txtDescuento.setTextColor(Color.parseColor("#9B9B9B"))
        txtDescuento.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        txtDescuento.setTypeface(null, Typeface.BOLD)
        txtDescuento.paintFlags = txtDescuento.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun incrementarNumero() {
        var num = numero.text.toString().toInt()
        if (num < 99) {
            num++
            numero.setText(num.toString())
        }
    }

    private fun decrementarNumero() {
        var num = numero.text.toString().toInt()
        if (num > 1) {
            num--
            numero.setText(num.toString())
        }
    }
}
