package com.xoxo.xoxo.Comprar

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xoxo.xoxo.R

class ComprarViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_comprar, parent, false)) {

    private var txtColeccion: TextView = itemView.findViewById(R.id.textCategoria1)
    private var txtProducto: TextView = itemView.findViewById(R.id.textNProdcuto1)
    private var txtDescuento: TextView = itemView.findViewById(R.id.descuento)
    private var txtPrecio: TextView = itemView.findViewById(R.id.textprecio1)
    private var numero: TextView = itemView.findViewById(R.id.numero)
    private var btnSuma: ImageButton = itemView.findViewById(R.id.btnSuma)
    private var btnResta: ImageButton = itemView.findViewById(R.id.btnResta)

    init {
        // Configurar el descuento tachado
        txtDescuento.paintFlags = txtDescuento.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        // Configurar la apariencia del precio
        txtDescuento.setTextColor(Color.parseColor("#9B9B9B"))
        txtDescuento.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        txtDescuento .setTypeface(null, Typeface.BOLD)

        btnSuma.setOnClickListener {
            incrementarNumero()
        }

        btnResta.setOnClickListener {
            decrementarNumero()
        }
    }

    fun bind(comprar: Comprar) {
        txtColeccion.text = comprar.coleccion
        txtProducto.text = comprar.producto
        txtDescuento.text = comprar.descuento
        txtPrecio.text = comprar.precio
        numero.text = "1" // Default value
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
