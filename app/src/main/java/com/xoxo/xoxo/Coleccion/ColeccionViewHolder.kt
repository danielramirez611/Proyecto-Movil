package com.xoxo.xoxo.Inicio

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xoxo.xoxo.Coleccion.Coleccion
import com.xoxo.xoxo.Notificacion.Notificacion
import com.xoxo.xoxo.R

class ColeccionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_coleccion, parent, false)) {

    private var img: ImageView? = null


    init {
        img = itemView.findViewById(R.id.imageInsideCard1)



    }

    fun bind(coleccion: Coleccion) {
        Glide.with(img!!.context).load(coleccion.imagen).into(img!!)

    }

}
