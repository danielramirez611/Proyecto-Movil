package com.xoxo.xoxo.Inicio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xoxo.xoxo.Coleccion.Coleccion
import com.xoxo.xoxo.Notificacion.Notificacion

class ColeccionAdapter(private val listColeccion: List<Coleccion>) : RecyclerView.Adapter<ColeccionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColeccionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ColeccionViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ColeccionViewHolder, position: Int) {
        val coleccion = listColeccion[position]
        holder.bind(coleccion)
    }

    override fun getItemCount(): Int = listColeccion.size
}
