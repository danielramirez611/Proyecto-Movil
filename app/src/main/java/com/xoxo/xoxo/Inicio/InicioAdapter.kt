package com.xoxo.xoxo.Inicio

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xoxo.xoxo.DetalleActivity
import com.xoxo.xoxo.R

class InicioAdapter(private val list: List<Inicio>) :
    RecyclerView.Adapter<InicioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InicioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InicioViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: InicioViewHolder, position: Int) {
        val inicio: Inicio = list[position]
        holder.bind(inicio)
    }

    override fun getItemCount(): Int = list.size
}
