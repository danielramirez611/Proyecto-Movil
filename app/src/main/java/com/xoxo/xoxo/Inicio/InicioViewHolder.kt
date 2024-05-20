package com.xoxo.xoxo.Inicio

import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xoxo.xoxo.DetalleActivity
import com.xoxo.xoxo.R
class InicioViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_incio, parent, false)) {

    private var txtColeccion: TextView? = null
    private var txtProducto: TextView? = null
    private var txtPrecio: TextView? = null
    private var txtDescuento: TextView? = null
    private var image: ImageView? = null
    private var fabHeart: FloatingActionButton? = null

    private var isLiked: Boolean = false

    init {
        txtColeccion = itemView.findViewById(R.id.coleccion)
        txtProducto = itemView.findViewById(R.id.textalgo)
        txtPrecio = itemView.findViewById(R.id.textprecio)
        txtDescuento = itemView.findViewById(R.id.descuento)
        image = itemView.findViewById(R.id.imageProducto1)
        fabHeart = itemView.findViewById(R.id.fabHeart)

        txtPrecio?.paintFlags = txtPrecio?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG) ?: 0

        fabHeart?.setOnClickListener {
            isLiked = !isLiked
            updateFabImage()
        }

        image?.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, DetalleActivity::class.java).apply {
                putExtra("coleccion", txtColeccion?.text.toString())
                putExtra("producto", txtProducto?.text.toString())
                putExtra("precio", txtPrecio?.text.toString())
                putExtra("descuento", txtDescuento?.text.toString())
                putExtra("imageUrl", (image?.tag as? String))
            }
            context.startActivity(intent)
        }
    }

    fun bind(inicio: Inicio) {
        txtColeccion?.text = inicio.coleccion
        txtProducto?.text = inicio.prodcuto
        txtPrecio?.text = inicio.precio
        txtDescuento?.text = inicio.descuento
        Glide.with(image!!.context).load(inicio.url).into(image!!)
        image?.tag = inicio.url // Set the image URL as tag for later retrieval
    }

    private fun updateFabImage() {
        val imageResource = if (isLiked) {
            R.drawable.heart_red
        } else {
            R.drawable.heart
        }
        fabHeart?.setImageResource(imageResource)

        if (isLiked) {
            fabHeart?.setColorFilter(
                ContextCompat.getColor(itemView.context, R.color.rojo),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        } else {
            fabHeart?.clearColorFilter()
        }
    }
}