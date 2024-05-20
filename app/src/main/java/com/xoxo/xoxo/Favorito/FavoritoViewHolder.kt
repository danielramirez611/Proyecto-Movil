package com.xoxo.xoxo.Favorito

import android.graphics.Paint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xoxo.xoxo.R

class FavoritoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_favorito, parent, false)) {

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
        txtDescuento = itemView.findViewById(R.id.txtdescuento)
        image = itemView.findViewById(R.id.imageProducto1)
        fabHeart = itemView.findViewById(R.id.fabHeart)

        fabHeart?.setOnClickListener {
            isLiked = !isLiked
            updateFabImage()
        }
    }

    fun bind(favorito: Favorito) {
        txtColeccion?.text = favorito.coleccion
        txtProducto?.text = favorito.prodcuto
        txtPrecio?.text = favorito.precio
        txtDescuento?.text = favorito.descuento

        // Configurar el descuento tachado después de asignar el texto
        txtPrecio?.paintFlags = txtPrecio?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG) ?: Paint.STRIKE_THRU_TEXT_FLAG

        Glide.with(image!!.context).load(favorito.url).into(image!!)
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
